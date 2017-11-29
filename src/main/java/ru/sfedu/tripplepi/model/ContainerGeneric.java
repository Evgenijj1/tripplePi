package ru.sfedu.tripplepi.model;

import java.util.List;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
/**
 *
 * @author !Евгений
 */
@Root(name = "root")
public class ContainerGeneric {
    @ElementList(required = false, name = "container")
    List<Generic> container;
    
    public ContainerGeneric(){
    }
    
    public ContainerGeneric(List<Generic> list){
        this.container=list;
    }
    
    public List<Generic> getContainer() {
        return container;
    }

    public void setContainer(List<Generic> container) {
        this.container = container;
    }
}
