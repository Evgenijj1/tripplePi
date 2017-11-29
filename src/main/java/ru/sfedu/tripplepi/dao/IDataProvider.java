package ru.sfedu.tripplepi.dao;
import ru.sfedu.tripplepi.model.Result;
import java.util.List;
import java.util.Optional;
import ru.sfedu.tripplepi.model.*;
/**
 *
 * @author !Евгений
 */
public interface IDataProvider{
    public Result insert(List<Generic> object)throws Exception; 
    
    public Result update(Generic object)throws Exception;
    
    public Result delete(Generic object)throws Exception; 

    public Optional<List<Generic>> select(ClassType type)throws Exception; 

    public Generic getObjectByID(long id, ClassType type) throws Exception;
    
    public Generic getRequestByID(long id) throws Exception;
    
    public Generic getScoreByID(long id) throws Exception;
    
    public Generic getTarifByID(long id) throws Exception;
    
    public Generic getTradeByID(long id) throws Exception;

    public Generic getTrendByID(long id) throws Exception;
    
    public Generic getUserByID(long id) throws Exception;
}