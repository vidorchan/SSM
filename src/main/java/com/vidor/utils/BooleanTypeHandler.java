package com.vidor.utils;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

/**
 * java中的boolean和jdbc中的char之间转换;true-Y;false-N
 */
public class BooleanTypeHandler implements TypeHandler {

    @Override
    public Object getResult(ResultSet arg0, String arg1) throws SQLException {
        String str = arg0.getString(arg1);
        Boolean rt = Boolean.FALSE;
        if (str.equalsIgnoreCase("Y")) {
            rt = Boolean.TRUE;
        }
        return rt;
    }

    @Override
    public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public Object getResult(CallableStatement arg0, int arg1) throws SQLException {
        Boolean b = arg0.getBoolean(arg1);
        return b == true ? "Y" : "N";
    }

    @Override
    public void setParameter(PreparedStatement arg0, int arg1, Object arg2, JdbcType arg3) throws SQLException {
        Boolean b = (Boolean) arg2;
        String value = (Boolean) b == true ? "Y" : "N";
        arg0.setString(arg1, value);
    }
}  