package sample;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import database_constant.Constants;
import database_constant.StaticSQLString;
import database_constant.Tables;
import database_support.GetDataFromDataBase;
import database_support.MakeDatabaseConnection;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import object_class.Catagory;
import object_class.Guitar;
import object_class.Name;
import ui_support.ColumnNames;

import java.net.URL;
import java.nio.FloatBuffer;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Created by AURANGO SABBIR on 12/30/2014.
 */
public class SearchController implements Initializable {

    public ChoiceBox name_list;
    public ChoiceBox catagory_list;
    public TextField first_limit;
    public TextField second_limit;
    public TableView tableView;

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    ResultSetMetaData resultSetMetaData = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        connection = MakeDatabaseConnection.getConnection();
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        ResultSet result_set = null;
        String str = "SELECT * FROM `guitar_name`";
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

    public void searchClicked(ActionEvent actionEvent) {
        tableView.getColumns().clear();
        if (first_limit.getText().isEmpty() && second_limit.getText().isEmpty()) {
            String sql = "SELECT guitar_id,guitar_company.guitar_company_name ,guitar_name.guitar_name,\n" +
                    "guitar_catagory.guitar_catagory_decp,guitar_decp,guitar_colour,guitar_price,\n" +
                    "guitar_selling_price,guitar_arrival_date,avilable\n" +
                    "FROM guitar_info\n" +
                    "INNER JOIN guitar_company\n" +
                    "ON guitar_info.guitar_company_id=guitar_company.guitar_company_id\n" +
                    "INNER JOIN guitar_name\n" +
                    "ON guitar_info.guitar_name_id=guitar_name.guitar_name_id\n" +
                    "INNER JOIN guitar_catagory\n" +
                    "ON guitar_info.guitar_catagory_id=guitar_catagory.guitar_catagory_id\n" +
                    "WHERE guitar_name='" + name_list.getValue().toString() + "' AND guitar_catagory_decp='" + catagory_list.getValue().toString() + "'";
            TableColumn tableColumn = null;
            System.out.println(sql);
            try {
                resultSet = statement.executeQuery(sql);
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
            final ObservableList dataList = new GetDataFromDataBase().printData(resultSet, Tables.GUITAR_INFO);
            System.out.println(dataList.toString());
            tableView.getItems().setAll(dataList);
            tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
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
                            String sql = "DELETE FROM guitar_info where guitar_id='" + tableRow.getItem().toString() + "'";

                            try {
                                statement.executeUpdate(sql);
                                System.out.println(sql);
                            } catch (MySQLIntegrityConstraintViolationException ex) {
                                System.out.println("This data is related to guitar_sold,you can't delete this data");
                                System.out.println("If you want to delete the data from guitar_sold,type y: ");
                                Scanner sc = new Scanner(System.in);
                                String s = sc.nextLine();
                                System.out.println(s);
                                if (s.equals("y")) {
                                    sql = "DELETE FROM guitar_sold WHERE guitar_id='" + tableRow.getItem().toString() + "'";
                                    try {
                                        statement.executeUpdate(sql);
                                        System.out.println(sql);
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    sql = "DELETE FROM guitar_info where guitar_id='" + tableRow.getItem().toString() + "'";
                                    try {
                                        statement.executeUpdate(sql);
                                        System.out.println(sql);
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    System.out.println("nothing typed");
                                }
                                //ex.printStackTrace();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
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

        } else {
            float first = Float.parseFloat(first_limit.getText().toString());
            float second = Float.parseFloat(second_limit.getText().toString());
            if (second < first) {
                System.out.println("Write limit properly");
            } else {
                String sql = "SELECT guitar_id,guitar_company.guitar_company_name ,guitar_name.guitar_name,\n" +
                        "guitar_catagory.guitar_catagory_decp,guitar_decp,guitar_colour,guitar_price,\n" +
                        "guitar_selling_price,guitar_arrival_date,avilable\n" +
                        "FROM guitar_info\n" +
                        "INNER JOIN guitar_company\n" +
                        "ON guitar_info.guitar_company_id=guitar_company.guitar_company_id\n" +
                        "INNER JOIN guitar_name\n" +
                        "ON guitar_info.guitar_name_id=guitar_name.guitar_name_id\n" +
                        "INNER JOIN guitar_catagory\n" +
                        "ON guitar_info.guitar_catagory_id=guitar_catagory.guitar_catagory_id\n" +
                        "WHERE guitar_name='" + name_list.getValue().toString() + "'AND guitar_catagory_decp='" +
                        catagory_list.getValue().toString() + "' AND guitar_selling_price BETWEEN'" +
                        first_limit.getText() + "' AND '" + second_limit.getText() + "'";
                TableColumn tableColumn = null;
                System.out.println(sql);
                try {
                    resultSet = statement.executeQuery(sql);
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
                final ObservableList dataList = new GetDataFromDataBase().printData(resultSet, Tables.GUITAR_INFO);
                System.out.println(dataList.toString());
                tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                tableView.getItems().setAll(dataList);
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
                                String sql = "DELETE FROM guitar_info where guitar_id='" + tableRow.getItem().toString() + "'";

                                try {
                                    statement.executeUpdate(sql);
                                    System.out.println(sql);
                                } catch (MySQLIntegrityConstraintViolationException ex) {
                                    System.out.println("This data is related to guitar_sold,you can't delete this data");
                                    System.out.println("If you want to delete the data from guitar_sold,type y: ");
                                    Scanner sc = new Scanner(System.in);
                                    String s = sc.nextLine();
                                    System.out.println(s);
                                    if (s.equals("y")) {
                                        sql = "DELETE FROM guitar_sold WHERE guitar_id='" + tableRow.getItem().toString() + "'";
                                        try {
                                            statement.executeUpdate(sql);
                                            System.out.println(sql);
                                        } catch (SQLException e) {
                                            e.printStackTrace();
                                        }
                                        sql = "DELETE FROM guitar_info where guitar_id='" + tableRow.getItem().toString() + "'";
                                        try {
                                            statement.executeUpdate(sql);
                                            System.out.println(sql);
                                        } catch (SQLException e) {
                                            e.printStackTrace();
                                        }
                                    } else {
                                        System.out.println("Its ok");
                                    }
                                    //ex.printStackTrace();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
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
    }
}