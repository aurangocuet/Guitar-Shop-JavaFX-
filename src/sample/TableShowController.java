package sample;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import database_constant.StaticSQLString;
import database_support.GetDataFromDataBase;
import database_support.MakeDatabaseConnection;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import object_class.Guitar;
import org.omg.PortableInterceptor.INACTIVE;
import ui_support.ColumnNames;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Created by AURANGO SABBIR on 11/27/2014.
 */

public class TableShowController implements Initializable {
    public AnchorPane anchorPane;

    private TableView tableView;
    public Connection connection = null;
    public Statement statement = null;
    private ResultSet resultSet;
    private ResultSetMetaData resultSetMetaData;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        connection = MakeDatabaseConnection.getConnection();
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        TableColumn tableColumn = null;
        System.out.println(StaticSQLString.getString_sql());
        tableView = new TableView();
        try {
            resultSet = statement.executeQuery(StaticSQLString.getString_sql());
            resultSetMetaData = resultSet.getMetaData();
            int cols = resultSetMetaData.getColumnCount();
            for (int i = 0; i < cols; i++) {
                tableColumn = new TableColumn(ColumnNames.COLUMN_NAME.get(resultSetMetaData.getColumnName(i + 1)).toString());
                tableColumn.setCellValueFactory(new PropertyValueFactory<>(resultSetMetaData.getColumnName(i + 1)));
                tableView.getColumns().add(tableColumn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        final ObservableList dataList = new GetDataFromDataBase().printData(resultSet, StaticSQLString.getTable_name());
        System.out.println(dataList.toString());
        tableView.getItems().setAll(dataList);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.prefWidthProperty().bind(anchorPane.widthProperty());
        tableView.prefHeightProperty().bind(anchorPane.heightProperty());
        anchorPane.getChildren().add(tableView);
        tableView.setRowFactory(new Callback<TableView, TableRow>() {
            @Override
            public TableRow call(final TableView tableView) {
                final TableRow tableRow = new TableRow<>();
                ContextMenu contextMenu = new ContextMenu();
                MenuItem detail = new MenuItem("Detail");
                detail.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        System.out.println(tableRow.getItem().toString());
                    }
                });
                MenuItem delete = new MenuItem("Delete");
                delete.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        tableView.getItems().remove(tableRow.getItem());
                        System.out.println(tableRow.getItem().toString());
                    }
                });
                contextMenu.getItems().addAll(delete, detail);
                tableRow.contextMenuProperty().bind(
                        Bindings.when(Bindings.isNotNull(tableRow.itemProperty()))
                                .then(contextMenu)
                                .otherwise((ContextMenu) null));
                return tableRow;
            }
        });
    }
}