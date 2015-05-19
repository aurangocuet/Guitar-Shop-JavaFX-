package database_support;

import database_constant.CommonCharacters;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 * Created by AURANGO SABBIR on 11/18/2014.
 */
public class DataBaseHelper {

    Connection con = null;
    Statement st = null;

    public DataBaseHelper() {
        con = MakeDatabaseConnection.getConnection();
        try {
            st = con.createStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void insertIntoDatabase(String table_name, HashMap map) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("INSERT INTO");
        stringBuilder.append(CommonCharacters.SPACE);
        stringBuilder.append(table_name);
        stringBuilder.append(CommonCharacters.SPACE);
        stringBuilder.append(CommonCharacters.FIRSTBRACES);
        stringBuilder.append(CommonCharacters.SPACE);

        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            stringBuilder.append(entry.getKey());
            stringBuilder.append(CommonCharacters.COMMA);
            stringBuilder.append(CommonCharacters.SPACE);
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        stringBuilder.append(CommonCharacters.SECONDBRACES);
        stringBuilder.append(CommonCharacters.SPACE);
        stringBuilder.append("VALUES");
        stringBuilder.append(CommonCharacters.FIRSTBRACES);
        stringBuilder.append(CommonCharacters.SPACE);
        iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            stringBuilder.append(CommonCharacters.SINGLE_COUAT);
            stringBuilder.append(entry.getValue());
            stringBuilder.append(CommonCharacters.SINGLE_COUAT);
            stringBuilder.append(CommonCharacters.COMMA);
            stringBuilder.append(CommonCharacters.SPACE);
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        stringBuilder.append(CommonCharacters.SECONDBRACES);
        System.out.println(stringBuilder.toString());
        try {
            st.executeUpdate(stringBuilder.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
