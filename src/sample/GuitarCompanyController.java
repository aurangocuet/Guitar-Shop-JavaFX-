package sample;

import database_constant.Tables;
import database_support.DataInputer;
import database_support.MakeDatabaseConnection;
import database_support.DataBaseHelper;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

/**
 * Created by AURANGO SABBIR on 11/24/2014.
 */
public class GuitarCompanyController {
    public TextField company_name;
    public TextField country_name;

    public void addCompanyClicked(ActionEvent actionEvent){
        new DataBaseHelper().insertIntoDatabase(Tables.GUITAR_COMPANY, DataInputer.insertCompany(company_name.getText(),country_name.getText()));
        reset();
    }

    public void reset(){
        company_name.clear();
        country_name.clear();
    }
}
