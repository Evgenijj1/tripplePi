package ru.sfedu.tripplepi;

/**
 *
 * @author eugene
 */
public class Constants {
    public static final String VARIABLE="variable";
    public static final String PATH_CSV_STORE="csv_store";
    public static final String PATH_XML_STORE="xml_store";
            
    /*public static final String[] COLUMNS_USERS = new String[] {"id", "name","surname", "patronymic","email","phone","activation","block","role","created_at","updated_at"}; 
    public static final String[] COLUMNS_TREND = new String[] {"id","open","close","high","low","volume","time"};
    public static final String[] COLUMNS_TRADE = new String[] {"id", "volume","buy","sell","trend","user"};
    public static final String[] COLUMNS_TARIF = new String[] {"id", "sum","date","user"};
    public static final String[] COLUMNS_SCORE = new String[] {"id", "sum", "real","user"};
    public static final String[] COLUMNS_REQUEST = new String[] {"id", "price", "volume","trend","time","user"};*/
    public static final String[] COLUMNS_USERS = new String[] {"name","surname", "patronymic","email","phone"}; 
    public static final String[] COLUMNS_TREND = new String[] {"open","close","high","low","volume","time"};
    public static final String[] COLUMNS_TRADE = new String[] {"volume","buy","sell","trend","user"};
    public static final String[] COLUMNS_TARIF = new String[] {"sum","date","user"};
    public static final String[] COLUMNS_SCORE = new String[] {"sum","user"};
    public static final String[] COLUMNS_REQUEST = new String[] {"price", "volume","trend","time","user"};
}