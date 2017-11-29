package ru.sfedu.tripplepi.model;

import com.opencsv.bean.CsvBindByName;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
/**
 * Class Score
 */
@Root(name="score")
public class Score extends Generic{

  //
  // Fields
  //
  @Element
  @CsvBindByName
  private long sum;
  
  @Element
  @CsvBindByName
  private boolean real = false;
  
  @Element
  @CsvBindByName
  private long user;
  
  //
  // Constructors
  //
    public Score() throws InterruptedException {
        super(ClassType.SCORE, 1);
    }
    
    public Score(long id, long sum, boolean real, long user) throws InterruptedException {
        super(ClassType.SCORE, id);
        this.sum=sum;
        this.real=real;
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
   * Set the value of real
   * @param newVar the new value of real
   */
  public void setReal (boolean newVar) {
    real = newVar;
  }

  /**
   * Get the value of real
   * @return the value of real
   */
  public boolean getReal () {
    return real;
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
      return "Class Score: id="+this.id+", sum="+this.sum+", real="+this.real+", user="+this.user;
  }
    @Override
    public String getValueByFieldName(String name) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
