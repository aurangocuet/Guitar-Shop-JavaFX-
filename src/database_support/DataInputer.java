package database_support;

import database_constant.Constants;
import object_class.Guitar;

import java.util.HashMap;

/**
 * Created by AURANGO SABBIR on 11/25/2014.
 */
public class DataInputer {
    public static HashMap insertGuitar(Guitar guitar){
        HashMap map=new HashMap();
        if(guitar.isNotEmpty()){
            map.put(Constants.COMPANY_ID,guitar.getGuitar_company_id());
            map.put(Constants.NAME_ID,guitar.getGuitar_name_id());
            map.put(Constants.CATAGORY_ID,guitar.getGuitar_catagory_id());
            map.put(Constants.DESCRIPTION,guitar.getGuitar_decp());
            map.put(Constants.COLOUR,guitar.getGuitar_colour());
            map.put(Constants.PRICE,guitar.getGuitar_price());
            map.put(Constants.SELLING_PRICE,guitar.getGuitar_selling_price());
            map.put(Constants.AVAILABLE,"1");
        }
        System.out.println(map.toString());
        return map;
    }

    public static HashMap insertCompany(String company_name,String country_name){
        HashMap map=new HashMap();
        map.put(Constants.COMPANY_NAME,company_name);
        map.put(Constants.COMPANY_COUNTRY,country_name);
        return map;
    }

    public static HashMap insertName(String name,String number_of_guitar){
        HashMap map=new HashMap();
        map.put(Constants.NAME,name);
        map.put(Constants.NUMBER_OF_GUITAR,number_of_guitar);
        return map;
    }

    public static HashMap insertCatagory(String catagory_decp){
        HashMap map=new HashMap();
        map.put(Constants.CATAGORY_DESCRIPTION,catagory_decp);
        return map;
    }

    public static HashMap insertCustomer(String cus_name,String cus_contact,String cus_address){
        HashMap map=new HashMap();
        map.put(Constants.CUSTOMER_NAME,cus_name);
        map.put(Constants.CUSTOMER_CONTACT,cus_contact);
        map.put(Constants.CUSTOMER_ADDRESS,cus_address);
        return map;
    }

    public static HashMap insertSold(String guitar_id,String customer_id){
        HashMap map=new HashMap();
        map.put(Constants.GUITAR_ID,guitar_id);
        map.put(Constants.CUSTOMER_ID,customer_id);
        return map;
    }
}
