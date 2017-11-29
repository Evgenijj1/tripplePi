package ru.sfedu.tripplepi;

import org.apache.log4j.Logger;
import ru.sfedu.tripplepi.dao.DataProviderCsv;
import ru.sfedu.tripplepi.dao.DataProviderXml;
import ru.sfedu.tripplepi.model.ClassType;
import ru.sfedu.tripplepi.model.ContainerGeneric;
/**
 *
 * @author eugene
 */
public class TripplePiClient {
    private static Logger log = Logger.getLogger(TripplePiClient.class);
    
    TripplePiClient(){
        log.debug("TripplePiClient[0]: starting application.........");
    }
    
    public void logBasicSystemInfo() {
        log.info("Launching the application...");
        log.info(
        "Operating System: " + System.getProperty("os.name") + " "
        + System.getProperty("os.version")
        );
        log.info("JRE: " + System.getProperty("java.version"));
        log.info("Java Launched From: " + System.getProperty("java.home"));
        log.info("Class Path: " + System.getProperty("java.class.path"));
        log.info("Library Path: " + System.getProperty("java.library.path"));
        log.info("User Home Directory: " + System.getProperty("user.home"));
        log.info("User Working Directory: " + System.getProperty("user.dir"));
        log.info("Test INFO logging.");
    }
    public static void main(String []args){  
        
    }
}
