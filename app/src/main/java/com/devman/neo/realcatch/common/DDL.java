package com.devman.neo.realcatch.common;

/**
 * Created by neo on 2017-08-22.
 */

public class DDL {

    public static String SMS_LIST_T(){
        StringBuffer sql = new StringBuffer();
        sql.append("CREATE TABLE IF NOT EXISTS "+TABLE.T_SMS_LIST+"(");
        sql.append(TABLE.SMS_LIST.SEQ + " integer primary key autoincrement, ");
        sql.append(TABLE.SMS_LIST.MESSAGE + " TEXT, ");
        sql.append(TABLE.SMS_LIST.RECEIVED_DT + " TEXT");
        sql.append(")");
        return sql.toString();
    }

    public static String FILTER_LIST_T(){
        StringBuffer sql = new StringBuffer();
        sql.append("CREATE TABLE IF NOT EXISTS "+TABLE.T_FILTER_LIST+"(");
        sql.append(TABLE.FILTER_LIST.SENDER + " TEXT");
        sql.append(")");
        return sql.toString();
    }
}
