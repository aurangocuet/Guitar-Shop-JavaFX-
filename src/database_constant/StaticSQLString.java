package database_constant;

import javafx.collections.ObservableList;

/**
 * Created by AURANGO SABBIR on 11/29/2014.
 */
public class StaticSQLString {
    public static String string_sql;
    public static String table_name;

    public static void setString_sql(String string_sql) {
        StaticSQLString.string_sql = string_sql;
    }

    public static void setTable_name(String table_name) {
        StaticSQLString.table_name = table_name;
    }

    public static String getString_sql() {
        return string_sql;
    }

    public static String getTable_name() {
        return table_name;
    }
}
