package ru.sfedu.tripplepi.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import java.util.Date;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
/**
 * Class Tariffing
 */
@Root(name="tarif")
public class Tariffing extends Generic{

  //
  // Fields
  //
  @Element
  @CsvBindByName
  private long sum;
  
  @Element
  @CsvBindByName
  @CsvDate("dd.MM.yyyy hh:mm")
  private Date date;
  
  @Element
  @CsvBindByName
  private long user;
  
  //
  // Constructors
  //
    public Tariffing() throws InterruptedException {
        super(ClassType.TARIF, 1);
    }
    
    public Tariffing(long id, long sum,Date date,long user) throws InterruptedException {
        super(ClassType.TARIF, id);
        this.sum=sum;
        this.date=date;
        this.user=user;
    }
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of sum
   * @param newVar the new value of sum
   */
  public void setSum (long newVar) {
    sum = newVar;
  }

  /**
   * Get the value of sum
   * @return the value of sum
   */
  public long getSum () {
    return sum;
  }

  /**
   * Set the value of date
   * @param newVar the new value of date
   */
  public void setDate (Date newVar) {
    date = newVar;
  }

  /**
   * Get the value of date
   * @return the value of date
   */
  public Date getDate () {
    return date;
  }

  /**
   * Set the value of user
   * @param newVar the new value of user
   */
  public void setUser (long newVar) {
    user = newVar;
  }

  /**
   * Get the value of user
   * @return the value of user
   */
  public long getUser () {
    return user;
  }

  //
  // Other methods
  //
    public String toString(){
      return "Class Tariffing: id="+this.id+", sum="+this.sum+", date="+this.date+", user="+this.user;
    }
    @Override
    public String getValueByFieldName(String name) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
