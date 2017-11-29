package ru.sfedu.tripplepi.dao;

import ru.sfedu.tripplepi.model.StatusType;
import ru.sfedu.tripplepi.model.Result;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import java.io.Writer;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.List;
import java.util.Optional;
import static java.util.Optional.ofNullable;
import java.util.logging.Level;
import org.apache.log4j.Logger;

import static ru.sfedu.tripplepi.Constants.PATH_CSV_STORE;
import ru.sfedu.tripplepi.model.ClassType;
import ru.sfedu.tripplepi.model.*;
import static ru.sfedu.tripplepi.utils.ConfigurationUtil.getConfigurationEntry;




/**
 *
 * @author eugene
 */
public class DataProviderCsv implements IDataProvider{
    private static final Logger log = Logger.getLogger(DataProviderCsv.class);

    public DataProviderCsv(){}
   
    @Override
    public Optional<List<Generic>> select(ClassType type) throws Exception {
        Optional<List<Generic>> result;
        try {
            List<Generic> list =new CsvToBeanBuilder(new FileReader(getFile(type))).withType(type.getCl()).build().parse();
            result = ofNullable(list);
        }catch(Exception e){
            log.trace(e.getMessage());
            throw e;
        }
        return result;
    }

    /**
     *
     * @param list
     * @return
     * @throws Exception
     */
    @Override
    public Result insert(List<Generic> list) throws Exception {
        Result result=new Result();
        List<Generic> lg=this.select(list.get(0).getTypeClass()).get();
        int sum=lg.size();
        list.stream()
                .forEach(object->{
        if(!lg.stream().anyMatch(el->el.getId()==object.getId()) && haveUser(object).getStatus().equals(StatusType.OK.toString())){
            lg.add(object);
        }
                });
        if((sum+list.size()>=lg.size()) && (lg.size()>sum)){
            result=write(lg,list.get(0).getTypeClass());
            if(result.getStatus().equals(StatusType.OK.toString())){
                if(sum+list.size()<lg.size()){
                    result.setStatus(StatusType.WARNING.toString());
                    result.setErrorMsg("Lost "+(lg.size()-sum-list.size())+" elements");
                }
            }else result.setErrorMsg("Writing error!");
        }else{
            result.setStatus(StatusType.ERROR.toString());
            result.setErrorMsg("Failed to write elements");
        }
            
        return result;
    }
    
    /**
     *
     * @param object
     * @return
     * @throws Exception
     */
    public Result insert(Generic object) throws Exception{
        Result result=new Result();
        List<Generic> lg=this.select(object.getTypeClass()).get();
        if(!lg.stream().anyMatch(el->el.getId()==object.getId()) && this.haveUser(object).getStatus().equals(StatusType.OK.toString())){
            if(lg.add(object)) result.setStatus(StatusType.OK.toString());
        }else result.setStatus(StatusType.ERROR.toString());
        if (result.getStatus().equals(StatusType.OK.toString())) result=write(lg,object.getTypeClass());
        return result;
    }
    @Override
    public Result update(Generic object) throws Exception {
        Result result=new Result();
        List<Generic> lg=this.select(object.getTypeClass()).get();
        if(!(lg.removeIf(el->el.getId()==object.getId()) && lg.add(object))){
            result.setStatus(StatusType.ERROR.toString());
            result.setErrorMsg("Error in removing or adding element");
        }
        result=write(lg,object.getTypeClass());
        return result;
    }

    @Override
    public Result delete(Generic object) throws Exception {
        Result result=new Result();
        List<Generic> lg=this.select(object.getTypeClass()).get();
        result=this.cascadeDelete(object);
        if((result.getStatus().equals(StatusType.OK.toString())) && !lg.removeIf(el->el.getId()==object.getId())){
            result.setStatus(StatusType.ERROR.toString());
            result.setErrorMsg("Error in removing element");
        }
        result=write(lg,object.getTypeClass());
        return result;
    }
    
    public Result deleteById(long id,ClassType type) throws Exception{
        Result result=new Result();
        List<Generic> lg=this.select(type).get();
        return this.delete(lg.stream()
                .filter(el->el.getId()==id)
                .findFirst().get());
    }

    @Override
    public Generic getObjectByID(long id, ClassType type) throws Exception {
        List<Generic> lg=this.select(type).get();
        return getById(lg,id);
    }

    @Override
    public Generic getRequestByID(long id) throws Exception {
        List<Generic> lg=this.select(ClassType.REQUEST).get();
        return getById(lg,id);
    }

    @Override
    public Generic getScoreByID(long id) throws Exception {
        List<Generic> lg=this.select(ClassType.SCORE).get();
        return getById(lg,id);
    }

    @Override
    public Generic getTarifByID(long id) throws Exception {
        List<Generic> lg=this.select(ClassType.TARIF).get();
        return getById(lg,id);
    }

    @Override
    public Generic getTradeByID(long id) throws Exception {
        List<Generic> lg=this.select(ClassType.TRADE).get();
        return getById(lg,id);
    }

    @Override
    public Generic getTrendByID(long id) throws Exception {
        List<Generic> lg=this.select(ClassType.TREND).get();
        return getById(lg,id);
    }

    @Override
    public Generic getUserByID(long id) throws Exception {
        List<Generic> lg=this.select(ClassType.USER).get();
        return getById(lg,id);
    }
    
    private Result cascadeDelete(Generic object) throws Exception{
        Result result=new Result(StatusType.OK.toString());
        if(object.getTypeClass()==ClassType.USER){
            if(result.getStatus().equals(StatusType.OK.toString())){
                List<Generic> lg=this.select(ClassType.TRADE).get();
                if(!lg.removeIf(el->((TradeStory)el).getUser()==object.getId())) result.setStatus(StatusType.ERROR.toString());
                else result=write(lg,ClassType.TRADE);
            }
            if(result.getStatus().equals(StatusType.OK.toString())){
                List<Generic> lg=this.select(ClassType.SCORE).get();
                if(!lg.removeIf(el->((Score)el).getUser()==object.getId())) result.setStatus(StatusType.ERROR.toString());
                else result=write(lg,ClassType.SCORE);
            }
            if(result.getStatus().equals(StatusType.OK.toString())){
                List<Generic> lg=this.select(ClassType.REQUEST).get();
                if(!lg.removeIf(el->((Request)el).getUser()==object.getId())) result.setStatus(StatusType.ERROR.toString());
                else result=write(lg,ClassType.REQUEST);
            }
            if(result.getStatus().equals(StatusType.OK.toString())){
                List<Generic> lg=this.select(ClassType.TARIF).get();
                if(!lg.removeIf(el->((Tariffing)el).getUser()==object.getId())) result.setStatus(StatusType.ERROR.toString());
                else result=write(lg,ClassType.TARIF);
            }
            if(result.getStatus().equals(StatusType.ERROR.toString()))
                result.setErrorMsg("Cascade delete failed!");
        }
        return result;
    }
    
    private Result haveUser(Generic object){
        Result result=new Result();
        if(object.getTypeClass()==ClassType.USER || object.getTypeClass()==ClassType.TREND) result.setStatus(StatusType.OK.toString());
        else{
            try {
                List<Generic> list=this.select(ClassType.USER).get();
                switch(object.getTypeClass().toString()){
                    case "REQUEST":
                        if (list.stream()
                        .anyMatch(el->el.getId()==((Request)object).getUser()))
                            result.setStatus(StatusType.OK.toString());
                        else result.setStatus(StatusType.ERROR.toString());
                        break;
                    case "TARIF":
                        if (list.stream()
                        .anyMatch(el->el.getId()==((Tariffing)object).getUser()))
                            result.setStatus(StatusType.OK.toString());
                        else result.setStatus(StatusType.ERROR.toString());
                        break;
                    case "SCORE":
                        if (list.stream()
                        .anyMatch(el->el.getId()==((Score)object).getUser()))
                            result.setStatus(StatusType.OK.toString());
                        else result.setStatus(StatusType.ERROR.toString());
                        break;     
                    case "TRADE":
                        if (list.stream()
                        .anyMatch(el->el.getId()==((TradeStory)object).getUser()))
                            result.setStatus(StatusType.OK.toString());
                        else result.setStatus(StatusType.ERROR.toString());
                        break;
                    default: result.setStatus(StatusType.WARNING.toString());
                             result.setErrorMsg("Class Type '"+object.getTypeClass().toString()+" is unknown!");
                }
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(DataProviderCsv.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    
    private Result write(List<Generic> list, ClassType type) throws Exception{
        Result result=new Result();        
        try (Writer writer = new FileWriter(getFile(type))) {
            StatefulBeanToCsv beanToCsv =new StatefulBeanToCsvBuilder(writer).build();
            beanToCsv.write(list);
            
            result.setStatus(StatusType.OK.toString());
        } catch (IOException ex) {
            result.setStatus(StatusType.ERROR.toString());
            java.util.logging.Logger.getLogger(DataProviderCsv.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    private String getFile(ClassType type) throws Exception{
        String file=getConfigurationEntry(PATH_CSV_STORE);
        file+=type.toString()+".csv";
        return file;
    }
    
    private Generic getById(List<Generic> lg,long id){
        return lg.stream()
                .filter(el->el.getId()==id)
                .limit(1)
                .findFirst().get();
    }
}
