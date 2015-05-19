package sample;

import database_constant.Constants;
import database_constant.Tables;
import database_support.DataInputer;
import database_support.MakeDatabaseConnection;
import database_support.DataBaseHelper;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import object_class.Catagory;
import object_class.Company;
import object_class.Guitar;
import object_class.Name;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * Created by AURANGO SABBIR on 11/25/2014.
 */
public class GuitarEntryController implements Initializable {

    public ChoiceBox<Company> company_list = new ChoiceBox<Company>();
    public ChoiceBox<Name> name_list = new ChoiceBox<Name>();
    public ChoiceBox<Catagory> catagory_list = new ChoiceBox<Catagory>();

    public TextField decp_field;
    public TextField image_field;
    public TextField colour_field;
    public TextField price_field;
    public TextField selling_price_field;

    Connection connection = null;
    Statement statement = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        connection = MakeDatabaseConnection.getConnection();
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        ResultSet result_set = null;
        String str = "SELECT * FROM `guitar_company`";
        try {
            result_set = statement.executeQuery(str);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (result_set.next()) {
                Company com = new Company();
                com.setGuitar_company_id(result_set.getInt(Constants.COMPANY_ID));
                com.setGuitar_company_name(result_set.getString(Constants.COMPANY_NAME));
                com.setGuitar_company_country(result_set.getString(Constants.COMPANY_COUNTRY));
                company_list.getItems().add(com);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        str = "SELECT * FROM `guitar_name`";
        try {
            result_set = statement.executeQuery(str);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (result_set.next()) {
                Name com = new Name();
                com.setGuitar_name_id(result_set.getInt(Constants.NAME_ID));
                com.setGuitar_name(result_set.getString(Constants.NAME));
                com.setNumber_of_guitar(result_set.getInt(Constants.NUMBER_OF_GUITAR));
                name_list.getItems().add(com);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        str = "SELECT * FROM `guitar_catagory`";
        try {
            result_set = statement.executeQuery(str);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (result_set.next()) {
                Catagory com = new Catagory();
                com.setGuitar_catagory_id(result_set.getInt(Constants.CATAGORY_ID));
                com.setGuitar_catagory_decp(result_set.getString(Constants.CATAGORY_DESCRIPTION));
                catagory_list.getItems().add(com);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addNew(ActionEvent actionEvent) {
        System.out.println(company_list.getValue().getGuitar_company_id());
        Guitar guitar = new Guitar();

        if (!company_list.getItems().isEmpty()) {
            guitar.setGuitar_company_id(company_list.getValue().getGuitar_company_id());
        }
        if (!name_list.getItems().isEmpty()) {
            guitar.setGuitar_name_id(name_list.getValue().getGuitar_name_id());
        }
        if (!catagory_list.getItems().isEmpty()) {
            guitar.setGuitar_catagory_id(catagory_list.getValue().getGuitar_catagory_id());
        }
        if (decp_field.getText() != null) {
            guitar.setGuitar_decp(decp_field.getText());
        } else
            guitar.setGuitar_decp("");

        if (colour_field.getText() != null) {
            guitar.setGuitar_colour(colour_field.getText());
        }

        if (image_field.getText() != null) {
            System.out.println("Work with it later");
        } else {
            System.out.println("image link not found");
        }

        if (price_field.getText() != null) {
            guitar.setGuitar_price(Float.parseFloat(price_field.getText()));
        }

        if (selling_price_field.getText() != null) {
            guitar.setGuitar_selling_price(Float.parseFloat(selling_price_field.getText()));
        }

        if (guitar.finalizeObject()){
            new DataBaseHelper().insertIntoDatabase(Tables.GUITAR_INFO, DataInputer.insertGuitar(guitar));
            String sql_set="SET SQL_SAFE_UPDATES = 0";
            String sql_update="UPDATE guitar_name SET number_of_guitar=number_of_guitar+1 where guitar_name='"+
                    name_list.getValue().toString()+"'";
            System.out.println(sql_update);
            try {
                statement.executeUpdate(sql_set);
                statement.executeUpdate(sql_update);
                System.out.println(sql_update);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            reset();
        }
    }

    public void reset(){
        decp_field.clear();
        image_field.clear();
        colour_field.clear();
        price_field.clear();
        selling_price_field.clear();
    }
}
