package com.devman.neo.realcatch.common;

/**
 * Created by neo on 2017-08-22.
 */

public class DML {
    public static String insertSmsMessage(){
        StringBuffer sql = new StringBuffer();
        sql.append("INSERT INTO "+TABLE.T_SMS_LIST+"(");
        sql.append(TABLE.SMS_LIST.MESSAGE+", ");
        sql.append(TABLE.SMS_LIST.RECEIVED_DT);
        sql.append(") values (?, ?)");

        return sql.toString();
    }

    public static String insertFilterNumber(){
        StringBuffer sql = new StringBuffer();
        sql.append("INSERT INTO "+TABLE.T_FILTER_LIST+"(");
        sql.append(TABLE.FILTER_LIST.SENDER);
        sql.append(") values (?)");

        return sql.toString();
    }
}
