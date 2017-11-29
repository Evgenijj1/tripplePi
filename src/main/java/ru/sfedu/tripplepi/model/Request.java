package ru.sfedu.tripplepi.model;

import com.opencsv.bean.CsvBindByName;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 *
 * @author eugene
 */
@Root(name="request")
public class Request extends Generic{
    
    @Element
    @CsvBindByName
    double price=0;
    
    @Element
    @CsvBindByName
    long volume=0;
    
    @Element
    @CsvBindByName
    boolean trend;
    
    @Element
    @CsvBindByName
    String time;
    
    @Element
    @CsvBindByName
    long user;

    public Request() throws InterruptedException {
        super(ClassType.REQUEST, 1);
    }
    public Request(long id, double price, boolean trend, long volume, String time, long user) throws InterruptedException {
        super(ClassType.REQUEST, id);
        this.price=price;
        this.trend=trend;
        this.volume=volume;
        this.time=time;
        this.user=user;
    }
    
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public boolean isTrend() {
        return trend;
    }

    public void setTrend(boolean trend) {
        this.trend = trend;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }
    public String toString(){
      return "Class Request: id="+this.id+", price="+this.price+", volume="+this.volume+", trend="+this.trend+", user="+this.user+", time="+this.time;
    }
    @Override
    public String getValueByFieldName(String name) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
