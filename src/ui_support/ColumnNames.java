package ui_support;

import database_constant.Constants;
import sun.text.resources.CollationData_sk;

import java.util.HashMap;

/**
 * Created by AURANGO SABBIR on 11/27/2014.
 */
public class ColumnNames {
    public static HashMap COLUMN_NAME= createHashMap();

    public static HashMap createHashMap(){
        HashMap map=new HashMap();
        map.put(Constants.CATAGORY_DESCRIPTION,"CATAGORY DESCRIPTION");
        map.put(Constants.NUMBER_OF_GUITAR,"NUMBER OF GUITAR");
        map.put(Constants.NAME,"NAME");
        map.put(Constants.COMPANY_COUNTRY,"COMPANY COUNTRY");
        map.put(Constants.ARRIVAL_DATE,"ARRIVAL DATE");
        map.put(Constants.AVAILABLE,"AVAILABLE");
        map.put(Constants.CATAGORY_ID,"CATAGORY ID");
        map.put(Constants.COLOUR,"COLOUR");
        map.put(Constants.COMPANY_ID,"COMPANY ID");
        map.put(Constants.COMPANY_NAME,"COMPANY NAME");
        map.put(Constants.DESCRIPTION,"DESCRIPTION");
        map.put(Constants.GUITAR_ID,"GUITAR ID");
        map.put(Constants.CUSTOMER_ADDRESS,"CUSTOMER ADDRESS");
        map.put(Constants.CUSTOMER_ID,"CUSTOMER ID");
        map.put(Constants.CUSTOMER_CONTACT,"CUSTOMER CONTACT");
        map.put(Constants.CUSTOMER_NAME,"CUSTOMER NAME");
        map.put(Constants.SOLD_DATE,"SOLD DATE");
        map.put(Constants.PRICE,"PRICE");
        map.put(Constants.SELLING_PRICE,"SELLEING PRICE");
        map.put(Constants.NAME_ID,"NAME ID");
        map.put(Constants.SOLD_ID,"GUITAR SOLD ID");
        return map;
    }
}
