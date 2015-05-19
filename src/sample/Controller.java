package sample;

import database_constant.StaticSQLString;
import database_constant.Tables;
import database_support.TableCreator;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by AURANGO SABBIR on 11/24/2014.
 */

public class Controller {

    public void runTabelCreator(ActionEvent actionEvent) {
        TableCreator.runTableCreateSQL();
    }

    public void addCompany(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("fxml/guitar_company.fxml"));
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("ADD NEW COMPANY");
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);


        stage.show();
    }

    public void addName(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("fxml/guitar_name.fxml"));
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("ADD NEW NAME");
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public void addCatagory(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("fxml/guitar_catagory.fxml"));
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("ADD NEW CATAGORY");
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public void addNewEntry(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("fxml/guitar_entry.fxml"));
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("ADD NEW");
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public void searchClicked(ActionEvent actionEvent){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("fxml/search.fxml"));
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("SEARCH");
        //stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public void sellClicked(ActionEvent actionEvent){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("fxml/sell.fxml"));
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("SELL");
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public void guitarListClicked(ActionEvent actionEvent) {
        StaticSQLString.setString_sql("select guitar_id,guitar_company.guitar_company_name ,guitar_name.guitar_name,\n" +
                "guitar_catagory.guitar_catagory_decp,guitar_decp,guitar_colour,guitar_price,\n" +
                "guitar_selling_price,guitar_arrival_date,avilable\n" +
                "from guitar_info\n" +
                "inner join guitar_company\n" +
                "on guitar_info.guitar_company_id=guitar_company.guitar_company_id\n" +
                "inner join guitar_name\n" +
                "on guitar_info.guitar_name_id=guitar_name.guitar_name_id\n" +
                "inner join guitar_catagory\n" +
                "on guitar_info.guitar_catagory_id=guitar_catagory.guitar_catagory_id");
        StaticSQLString.setTable_name(Tables.GUITAR_INFO);
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("fxml/table_show.fxml"));
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("GUITAR LIST");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public void customerListClicked(ActionEvent actionEvent){
        StaticSQLString.setString_sql("SELECT * FROM customer");
        StaticSQLString.setTable_name(Tables.CUSTOMER_INFO);
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("fxml/table_show.fxml"));
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("CUSTOMER LIST");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public void soldListClicked(ActionEvent actionEvent){
        StaticSQLString.setString_sql("SELECT * FROM guitar_sold");
        StaticSQLString.setTable_name(Tables.GUITAR_SOLD);
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("fxml/table_show.fxml"));
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("SOLD LIST");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public void companyListClicked(ActionEvent actionEvent){
        StaticSQLString.setString_sql("SELECT * FROM guitar_company");
        StaticSQLString.setTable_name(Tables.GUITAR_COMPANY);
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("fxml/table_show.fxml"));
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("COMPANY LIST");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public void nameListClicked(ActionEvent actionEvent){
        StaticSQLString.setString_sql("SELECT * FROM guitar_name");
        StaticSQLString.setTable_name(Tables.GUITAR_NAME);
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("fxml/table_show.fxml"));
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("GUITAR NAME LIST");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public void catagoryListClicked(ActionEvent actionEvent){
        StaticSQLString.setString_sql("SELECT * FROM guitar_catagory");
        StaticSQLString.setTable_name(Tables.GUITAR_CATAGORY);
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("fxml/table_show.fxml"));
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("GUITAR CATAGORY LIST");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
}
