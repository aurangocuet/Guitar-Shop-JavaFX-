package sample;

import database_constant.Tables;
import database_support.DataBaseHelper;
import database_support.DataInputer;
import database_support.MakeDatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * Created by AURANGO SABBIR on 11/24/2014.
 */
public class GuitarCatagoryController  {

    public TextField guitar_catagory;

    public void addCatagoryClicked(ActionEvent actionEvent){
        new DataBaseHelper().insertIntoDatabase(Tables.GUITAR_CATAGORY, DataInputer.insertCatagory(guitar_catagory.getText()));
        reset();
    }
    public void reset(){
        guitar_catagory.clear();
    }
}
