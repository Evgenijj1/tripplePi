package ru.sfedu.tripplepi.model;

import com.opencsv.bean.CsvBindByName;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Class TradeStory
 */
@Root(name="trade")
public class TradeStory extends Generic{

  //
  // Fields
  //
  @Element
  @CsvBindByName
  private long volume;
  
  @Element
  @CsvBindByName
  private double buy;
  
  @Element
  @CsvBindByName
  private double sell;
  
  @Element
  @CsvBindByName
  private boolean trend;
  
  @Element
  @CsvBindByName
  private long user;
  
  //
  // Constructors
  //
    public TradeStory() throws InterruptedException {
        super(ClassType.TRADE, 1);
    }
    
    public TradeStory(long id, long volume,long buy,long sell, boolean trend, long user) throws InterruptedException {
        super(ClassType.TRADE, id);
        this.volume=volume;
        this.buy=buy;
        this.sell=sell;
        this.trend=trend;
        this.user=user;
    }
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

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

  /**
   * Set the value of buy
   * @param newVar the new value of buy
   */
  public void setBuy (double newVar) {
    buy = newVar;
  }

  /**
   * Get the value of buy
   * @return the value of buy
   */
  public double getBuy () {
    return buy;
  }

  /**
   * Set the value of sell
   * @param newVar the new value of sell
   */
  public void setSell (double newVar) {
    sell = newVar;
  }

  /**
   * Get the value of sell
   * @return the value of sell
   */
  public double getSell () {
    return sell;
  }

  /**
   * Set the value of trend
   * @param newVar the new value of trend
   */
  public void setTrend (boolean newVar) {
    trend = newVar;
  }

  /**
   * Get the value of trend
   * @return the value of trend
   */
  public boolean getTrend () {
    return trend;
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
      return "Class TradeStory: id="+this.id+", buy="+this.buy+", sell="+this.sell+", volume="+this.volume+", trend="+this.trend+", user="+this.user;
  }
    @Override
    public String getValueByFieldName(String name) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
