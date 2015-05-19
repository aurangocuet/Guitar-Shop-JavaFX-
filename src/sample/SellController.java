package sample;

import database_constant.Constants;
import database_constant.Tables;
import database_support.DataBaseHelper;
import database_support.DataInputer;
import database_support.MakeDatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * Created by AURANGO SABBIR on 11/30/2014.
 */
public class SellController implements Initializable {
    public TextField guitar_id_field;
    public TextField customer_number_field;
    public AnchorPane customer_anchor;
    public AnchorPane new_customer_anchor;
    public TextField name_field;
    public TextField contact_field;
    public TextField address_field;
    public Button sell_button;

    Connection connection;
    Statement statement;

    public SellController() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        connection = MakeDatabaseConnection.getConnection();
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        customer_anchor.setVisible(false);
        new_customer_anchor.setVisible(false);
    }

    public void previousCustomerClicked(ActionEvent actionEvent) {
        customer_anchor.setVisible(true);
        new_customer_anchor.setVisible(false);
        sell_button.setText("SELL");
    }

    public void newCustomerClicked(ActionEvent actionEvent) {
        customer_anchor.setVisible(false);
        new_customer_anchor.setVisible(true);
        sell_button.setText("ADD & SELL");
    }

    public void sellClicked(ActionEvent actionEvent) {
        String sql = "SELECT * FROM guitar_info WHERE guitar_id='" + guitar_id_field.getText().toString() + "'";
        ResultSet resultSet = null;
        Integer available = null;
        try {
            resultSet = statement.executeQuery(sql);
            resultSet.next();
            available = resultSet.getInt(Constants.AVAILABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (!available.equals("0")) {
            if (customer_number_field.getText().isEmpty()) {
                new DataBaseHelper().insertIntoDatabase(Tables.CUSTOMER_INFO, DataInputer.insertCustomer(name_field.getText(), contact_field.getText(), address_field.getText()));
                sql = "SELECT * FROM customer WHERE " + Constants.CUSTOMER_CONTACT + "='" + contact_field.getText() + "'";
                System.out.println(sql);
                Integer customer_id = null;
                try {
                    resultSet = statement.executeQuery(sql);
                    resultSet.next();
                    customer_id = resultSet.getInt(Constants.CUSTOMER_ID);
                    sql = "UPDATE guitar_info SET avilable='0' WHERE guitar_id ='" + guitar_id_field.getText() + "'";
                    System.out.println(sql);
                    sql = "UPDATE guitar_name SET number_of_guitar=number_of_guitar-1 where guitar_name_id=" +
                            "(SELECT guitar_name_id from guitar_info WHERE guitar_id ='" + guitar_id_field.getText() + "')";
                    statement.executeUpdate(sql);
                    System.out.println(sql);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                new DataBaseHelper().insertIntoDatabase(Tables.GUITAR_SOLD, DataInputer.insertSold(guitar_id_field.getText(), customer_id.toString()));
                reset();
            } else {
                sql = "SELECT * FROM customer WHERE " + Constants.CUSTOMER_CONTACT + "='" + customer_number_field.getText() + "'";
                System.out.println(sql);
                Integer customer_id = null;
                try {
                    resultSet = statement.executeQuery(sql);
                    resultSet.next();
                    customer_id = resultSet.getInt(Constants.CUSTOMER_ID);
                    sql = "UPDATE guitar_info SET avilable='0' WHERE guitar_id ='" + guitar_id_field.getText() + "'";
                    System.out.println(sql);
                    statement.executeUpdate(sql);
                    sql = "UPDATE guitar_name SET number_of_guitar=number_of_guitar-1 where guitar_name_id=" +
                            "(SELECT guitar_name_id from guitar_info WHERE guitar_id ='" + guitar_id_field.getText() + "')";
                    statement.executeUpdate(sql);
                    System.out.println(sql);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                new DataBaseHelper().insertIntoDatabase(Tables.GUITAR_SOLD, DataInputer.insertSold(guitar_id_field.getText(), customer_id.toString()));
                reset();
            }

        } else {
            System.out.println("Already Sold");
            reset();
        }
    }

    void reset() {
        guitar_id_field.clear();
        customer_number_field.clear();
        name_field.clear();
        contact_field.clear();
        address_field.clear();
    }
}