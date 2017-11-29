package ru.sfedu.tripplepi.model;
/**
 *
 * @author eugene
 */
public class Flat extends Request{

    public Flat(long id, double price, boolean trend, long volume, String time, long user) throws InterruptedException {
        super(id,price,trend,volume,time,user);
    }
    
}
