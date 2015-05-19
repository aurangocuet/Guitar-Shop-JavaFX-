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
public class GuitarNameController {
    public TextField guitar_name;
    public TextField number_of_guitar;

    public void addGuitarNameClicked(ActionEvent actionEvent) {
        new DataBaseHelper().insertIntoDatabase(Tables.GUITAR_NAME, DataInputer.insertName(guitar_name.getText(),number_of_guitar.getText()));
        reset();
    }
    public void reset(){
        guitar_name.clear();
        number_of_guitar.clear();
    }
}

