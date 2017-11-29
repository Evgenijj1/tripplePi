package ru.sfedu.tripplepi.model;

import com.opencsv.bean.CsvBindByName;
import java.io.Serializable;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 *
 * @author eugene
 */
@Root
public abstract class Generic implements Serializable{
    
    @Attribute
    @CsvBindByName
    long id=1;
    
    @Attribute
    private  ClassType typeClass;

    public Generic(ClassType typeClass, long id){
        this.typeClass=typeClass;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ClassType getTypeClass() {
        return typeClass;
    }

    public void setTypeClass(ClassType typeClass) {
        this.typeClass = typeClass;
    }
    
    public abstract String getValueByFieldName(String name) throws Exception;
}
