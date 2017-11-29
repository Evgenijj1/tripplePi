package ru.sfedu.tripplepi.model;
import com.opencsv.bean.CsvBindByName;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
/**
 * Class TrendStory
 */
@Root(name="trend")
public class TrendStory extends Generic{

  //
  // Fields
  //
  @Element
  @CsvBindByName
  private String time;
  
  @Element
  @CsvBindByName
  private double open;
  
  @Element
  @CsvBindByName
  private double close;
  
  @Element
  @CsvBindByName
  private double high;
  
  @Element
  @CsvBindByName
  private double low;
  
  @Element
  @CsvBindByName
  private long volume;
  
  //
  // Constructors
  //

    public TrendStory() throws InterruptedException {
        super(ClassType.TREND, 1);
    }
    
    public TrendStory(long id, double open, double close, double high, double low, long volume, String time) throws InterruptedException {
        super(ClassType.TREND, 1);
        this.open=open;
        this.close=close;
        this.high=high;
        this.low=low;
        this.volume=volume;
        this.time=time;
    }
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of open
   * @param newVar the new value of open
   */
  public void setOpen (long newVar) {
    open = newVar;
  }

  /**
   * Get the value of open
   * @return the value of open
   */
  public double getOpen () {
    return open;
  }

  /**
   * Set the value of close
   * @param newVar the new value of close
   */
  public void setClose (double newVar) {
    close = newVar;
  }

  /**
   * Get the value of close
   * @return the value of close
   */
  public double getClose () {
    return close;
  }

  /**
   * Set the value of high
   * @param newVar the new value of high
   */
  public void setHigh (double newVar) {
    high = newVar;
  }

  /**
   * Get the value of high
   * @return the value of high
   */
  public double getHigh () {
    return high;
  }

  /**
   * Set the value of low
   * @param newVar the new value of low
   */
  public void setLow (double newVar) {
    low = newVar;
  }

  /**
   * Get the value of low
   * @return the value of low
   */
  public double getLow () {
    return low;
  }

  /**
   * Set the value of time
   * @param newVar the new value of time
   */
  public void setTime (String newVar) {
    time = newVar;
  }

  /**
   * Get the value of time
   * @return the value of time
   */
  public String getTime () {
    return time;
  }

  /**
   * Set the value of volume
   * @param newVar the new value of volume
   */
  public void setVolume (long newVar) {
    volume = newVar;
  }

  /**
   * Get the value of volume
   * @return the value of volume
   */
  public long getVolume () {
    return volume;
  }

  //
  // Other methods
  //
  public String toString(){
      return "Class TrendStory: id="+this.id+", open="+this.open+", close="+this.close+", high="+this.high+", low="+this.low+", volume="+this.volume+", time="+this.time;
  }
    @Override
    public String getValueByFieldName(String name) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
