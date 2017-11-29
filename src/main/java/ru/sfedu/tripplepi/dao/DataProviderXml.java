package ru.sfedu.tripplepi.dao;

import ru.sfedu.tripplepi.model.StatusType;
import ru.sfedu.tripplepi.model.Result;
import java.io.File;
import java.util.List;
import java.util.Optional;
import static java.util.Optional.ofNullable;
import static ru.sfedu.tripplepi.Constants.PATH_XML_STORE;
import ru.sfedu.tripplepi.model.ClassType;
import ru.sfedu.tripplepi.model.Generic;
import static ru.sfedu.tripplepi.utils.ConfigurationUtil.getConfigurationEntry;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.Serializer;
import ru.sfedu.tripplepi.model.ContainerGeneric;
import java.util.logging.Level;
import ru.sfedu.tripplepi.model.Request;
import ru.sfedu.tripplepi.model.Score;
import ru.sfedu.tripplepi.model.Tariffing;
import ru.sfedu.tripplepi.model.TradeStory;
/**
 *
 * @author !Евгений
 */
public class DataProviderXml implements IDataProvider{

    @Override
    public Result insert(List<Generic> list) throws Exception {
        Result result=new Result();
        ContainerGeneric container=new ContainerGeneric();
        List<Generic> lg=this.select(list.get(0).getTypeClass()).get();
        int sum=lg.size();
        list.stream()
                .forEach(object->{
        if(!lg.stream().anyMatch(el->el.getId()==object.getId()) && haveUser(object).getStatus().equals(StatusType.OK.toString())){
            lg.add(object);
        }
                });
        if((sum+list.size()>=lg.size()) && (lg.size()>sum)){
            container.setContainer(lg);
            result=write(container);
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

    @Override
    public Result update(Generic object) throws Exception {
        Result result=new Result();
        ContainerGeneric container=new ContainerGeneric();
        List<Generic> lg=this.select(object.getTypeClass()).get();
        if(!(lg.removeIf(el->el.getId()==object.getId()) && lg.add(object))){
            result.setStatus(StatusType.ERROR.toString());
            result.setErrorMsg("Error in removing or adding element");
        }
        container.setContainer(lg);
        result=write(container);
        return result;
    }

    @Override
    public Result delete(Generic object) throws Exception {
        Result result=new Result();
        ContainerGeneric container=new ContainerGeneric();
        List<Generic> lg=this.select(object.getTypeClass()).get();
        result=this.cascadeDelete(object);
        if((result.getStatus().equals(StatusType.OK.toString())) && !lg.removeIf(el->el.getId()==object.getId())){
            result.setStatus(StatusType.ERROR.toString());
            result.setErrorMsg("Error in removing element");
        }
        container.setContainer(lg);
        result=write(container);
        return result;
    }

    @Override
    public Optional<List<Generic>> select(ClassType type) throws Exception {
        Optional<List<Generic>> result = null;
        ContainerGeneric container;
        Serializer serializer = new Persister();
        File source = new File(getFile(type));
        container= serializer.read(ContainerGeneric.class, source);
        result=ofNullable(container.getContainer());
        return result;
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
    
    private String getFile(ClassType type) throws Exception{
        String file=getConfigurationEntry(PATH_XML_STORE);
        file+=type.toString()+".xml";
        return file;
    }
    
    private Result cascadeDelete(Generic object) throws Exception{
        Result result=new Result(StatusType.OK.toString());
        if(object.getTypeClass()==ClassType.USER){
            if(result.getStatus().equals(StatusType.OK.toString())){
                List<Generic> lg=this.select(ClassType.TRADE).get();
                ContainerGeneric container=new ContainerGeneric();
                if(!lg.removeIf(el->((TradeStory)el).getUser()==object.getId())) result.setStatus(StatusType.ERROR.toString());
                else{
                    container.setContainer(lg);
                    result=write(container);
                }
            }
            if(result.getStatus().equals(StatusType.OK.toString())){
                List<Generic> lg=this.select(ClassType.SCORE).get();
                ContainerGeneric container=new ContainerGeneric();
                if(!lg.removeIf(el->((Score)el).getUser()==object.getId())) result.setStatus(StatusType.ERROR.toString());
                else{
                    container.setContainer(lg);
                    result=write(container);
                }
            }
            if(result.getStatus().equals(StatusType.OK.toString())){
                List<Generic> lg=this.select(ClassType.REQUEST).get();
                ContainerGeneric container=new ContainerGeneric();
                if(!lg.removeIf(el->((Request)el).getUser()==object.getId())) result.setStatus(StatusType.ERROR.toString());
                else{
                    container.setContainer(lg);
                    result=write(container);
                }
            }
            if(result.getStatus().equals(StatusType.OK.toString())){
                List<Generic> lg=this.select(ClassType.TARIF).get();
                ContainerGeneric container=new ContainerGeneric();
                if(!lg.removeIf(el->((Tariffing)el).getUser()==object.getId())) result.setStatus(StatusType.ERROR.toString());
                else{
                    container.setContainer(lg);
                    result=write(container);
                }
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
    
    private Result write(ContainerGeneric object) throws Exception {
        Result result = new Result(StatusType.OK.toString());
        ContainerGeneric container;
        Serializer serializer = new Persister();
        File source = new File(getFile(object.getContainer().get(0).getTypeClass()));
        serializer.write(object, source);
        return result;
    }
    
    private Generic getById(List<Generic> lg,long id){
        return lg.stream()
                .filter(el->el.getId()==id)
                .limit(1)
                .findFirst().get();
    }
}
