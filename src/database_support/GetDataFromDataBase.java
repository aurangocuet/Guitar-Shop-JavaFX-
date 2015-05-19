package database_support;

import database_constant.Constants;
import database_constant.Tables;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import object_class.*;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by AURANGO SABBIR on 11/29/2014.
 */

public class GetDataFromDataBase {
    public ObservableList printData(ResultSet resultSet, String table_name) {
        ObservableList guitarObservableList = FXCollections.observableArrayList();
        if (table_name == Tables.GUITAR_INFO) {
            try {

                int count = 0;
                while (resultSet.next()) {
                    count++;
                    Guitar guitar = new Guitar();
                    guitar.setGuitar_id(resultSet.getInt(Constants.GUITAR_ID));
                    guitar.setGuitar_company_name(resultSet.getString(Constants.COMPANY_NAME));
                    guitar.setGuitar_name(resultSet.getString(Constants.NAME));
                    guitar.setGuitar_catagory_decp(resultSet.getString(Constants.CATAGORY_DESCRIPTION));
                    guitar.setGuitar_decp(resultSet.getString(Constants.DESCRIPTION));
                    guitar.setGuitar_colour(resultSet.getString(Constants.COLOUR));
                    guitar.setGuitar_price(resultSet.getFloat(Constants.PRICE));
                    guitar.setGuitar_selling_price(resultSet.getFloat(Constants.SELLING_PRICE));
                    guitar.setGuitar_arrival_date(resultSet.getString(Constants.ARRIVAL_DATE));
                    guitar.setAvilable(resultSet.getInt(Constants.AVAILABLE));
                    guitarObservableList.add(guitar);
                }
                resultSet.close();
                System.out.println(count);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(table_name == Tables.GUITAR_COMPANY){
            try {
                int count = 0;
                while (resultSet.next()) {
                    count++;
                    Company company=new Company();
                    company.setGuitar_company_id(resultSet.getInt(Constants.COMPANY_ID));
                    company.setGuitar_company_name(resultSet.getString(Constants.COMPANY_NAME));
                    company.setGuitar_company_country(resultSet.getString(Constants.COMPANY_COUNTRY));
                    guitarObservableList.add(company);
                }
                resultSet.close();
                System.out.println(count);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(table_name == Tables.GUITAR_SOLD){
            try {
                int count = 0;
                while (resultSet.next()) {
                    count++;
                    Sold sold=new Sold();
                    sold.setGuitar_sold_id(resultSet.getInt(Constants.SOLD_ID));
                    sold.setCustomer_id(resultSet.getInt(Constants.CUSTOMER_ID));
                    sold.setGuitar_id(resultSet.getInt(Constants.GUITAR_ID));
                    sold.setGuitar_sold_date(resultSet.getString(Constants.SOLD_DATE));
                    guitarObservableList.add(sold);
                }
                resultSet.close();
                System.out.println(count);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(table_name == Tables.GUITAR_NAME){
            try {
                int count = 0;
                while (resultSet.next()) {
                    count++;
                    Name name=new Name();
                    name.setGuitar_name_id(resultSet.getInt(Constants.NAME_ID));
                    name.setGuitar_name(resultSet.getString(Constants.NAME));
                    name.setNumber_of_guitar(resultSet.getInt(Constants.NUMBER_OF_GUITAR));
                    guitarObservableList.add(name);
                }
                resultSet.close();
                System.out.println(count);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(table_name == Tables.GUITAR_CATAGORY){
            try {
                int count = 0;
                while (resultSet.next()) {
                    count++;
                    Catagory catagory=new Catagory();
                    catagory.setGuitar_catagory_id(resultSet.getInt(Constants.CATAGORY_ID));
                    catagory.setGuitar_catagory_decp(resultSet.getString(Constants.CATAGORY_DESCRIPTION));
                    guitarObservableList.add(catagory);
                }
                resultSet.close();
                System.out.println(count);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(table_name == Tables.CUSTOMER_INFO){
            try {
                int count = 0;
                while (resultSet.next()) {
                    count++;
                    Customer customer=new Customer();
                    customer.setCustomer_id(resultSet.getInt(Constants.CUSTOMER_ID));
                    customer.setCustomer_name(resultSet.getString(Constants.CUSTOMER_NAME));
                    customer.setCustomer_address(resultSet.getString(Constants.CUSTOMER_ADDRESS));
                    customer.setCustomer_contact(resultSet.getString(Constants.CUSTOMER_CONTACT));
                    guitarObservableList.add(customer);
                }
                resultSet.close();
                System.out.println(count);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return guitarObservableList;
    }
}
