package ru.sfedu.tripplepi.model;

import static ru.sfedu.tripplepi.Constants.*;

/**
 *
 * @author eugene
 */
public enum ClassType {

    USER(COLUMNS_USERS, Users.class),
    TREND(COLUMNS_TREND, TrendStory.class),
    TRADE(COLUMNS_TRADE, TradeStory.class),
    TARIF(COLUMNS_TARIF, Tariffing.class),
    SCORE(COLUMNS_SCORE, Score.class),
    REQUEST(COLUMNS_REQUEST, Request.class);
    
    private String[] description;
    private Class cl;
    private ClassType() {
    }

    private ClassType(String[] description, Class cl) {
        this.description = description;
        this.cl=cl;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String[] getDescription() {
        return description;
    }

    public Class getCl() {
        return cl;
    }
}
