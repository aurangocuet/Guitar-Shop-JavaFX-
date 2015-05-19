package database_support;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by AURANGO SABBIR on 11/18/2014.
 */
public class TableCreator {

    public static void runTableCreateSQL() {
        Connection con = MakeDatabaseConnection.getConnection();
        Statement st= null;
        try {
            st = con.createStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        String sql = "CREATE  TABLE IF NOT EXISTS `guitar_company` (\n" +
                "  `guitar_company_id` INT NOT NULL AUTO_INCREMENT ,\n" +
                "  `guitar_company_name` VARCHAR(25) NOT NULL ,\n" +
                "  `guitar_company_country` VARCHAR(15) NOT NULL ,\n" +
                "    PRIMARY KEY (`guitar_company_id`) )\n" +
                "ENGINE = InnoDB";

        try {
            st.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        sql="CREATE  TABLE IF NOT EXISTS `guitar_name` (\n" +
                "  `guitar_name_id` INT NOT NULL AUTO_INCREMENT ,\n" +
                "  `guitar_name` VARCHAR(20) NOT NULL ,\n" +
                "  `number_of_guitar` INT NOT NULL ,\n" +
                "    PRIMARY KEY (`guitar_name_id`) )\n" +
                "ENGINE = InnoDB";
        try {
            st.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        sql="CREATE  TABLE IF NOT EXISTS `guitar_catagory` (\n" +
                "  `guitar_catagory_id` INT NOT NULL AUTO_INCREMENT ,\n" +
                "  `guitar_catagory_decp` VARCHAR(35) NOT NULL ,\n" +
                "    PRIMARY KEY (`guitar_catagory_id`) )\n" +
                "ENGINE = InnoDB";
        try {
            st.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        sql="CREATE  TABLE IF NOT EXISTS  `customer` (\n" +
                "  `customer_id` INT NOT NULL AUTO_INCREMENT ,\n" +
                "  `customer_contact` VARCHAR(12) NOT NULL ,\n" +
                "  `customer_name` VARCHAR(20) NOT NULL ,\n" +
                "  `customer_address` VARCHAR(45) NOT NULL ,\n" +
                "    PRIMARY KEY (`customer_id`, `customer_contact`) )\n" +
                "ENGINE = InnoDB";
        try {
            st.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        sql="CREATE  TABLE IF NOT EXISTS  `guitar_info` (\n" +
                "  `guitar_id` INT NOT NULL AUTO_INCREMENT ,\n" +
                "  `guitar_company_id` INT NOT NULL ,\n" +
                "  `guitar_name_id` INT NOT NULL ,\n" +
                "  `guitar_catagory_id` INT NOT NULL ,\n" +
                "  `guitar_decp` VARCHAR(45) NULL ,\n" +
                "  `guitar_colour` VARCHAR(10) NOT NULL ,\n" +
                "  `guitar_image` BLOB NULL ,\n" +
                "  `guitar_price` FLOAT NOT NULL ,\n" +
                "  `guitar_selling_price` FLOAT NOT NULL ,\n" +
                "  `guitar_arrival_date` DATETIME DEFAULT CURRENT_TIMESTAMP ,\n" +
                "  `avilable` ENUM('0','1') NULL ,\n" +
                "    PRIMARY KEY (`guitar_id`) ,\n" +
                "    FOREIGN KEY (`guitar_company_id` )\n" +
                "    REFERENCES  `guitar_company` (`guitar_company_id` )\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION,\n" +
                "    FOREIGN KEY (`guitar_name_id` )\n" +
                "    REFERENCES  `guitar_name` (`guitar_name_id` )\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION,\n" +
                "    FOREIGN KEY (`guitar_catagory_id` )\n" +
                "    REFERENCES  `guitar_catagory` (`guitar_catagory_id` )\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION)\n" +
                "ENGINE = InnoDB";
        try {
            st.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("2");
            System.out.println(e.toString());
        }
        sql="CREATE  TABLE IF NOT EXISTS  `guitar_sold` (\n" +
                "  `guitar_sold_id` INT NOT NULL AUTO_INCREMENT ,\n" +
                "  `customer_id` INT NOT NULL ,\n" +
                "  `guitar_id` INT NOT NULL ,\n" +
                "  `guitar_sold_date` DATETIME DEFAULT CURRENT_TIMESTAMP ,\n" +
                "    PRIMARY KEY (`guitar_sold_id`) ,\n" +
                "    FOREIGN KEY (`customer_id` )\n" +
                "    REFERENCES  `customer` (`customer_id` )\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION,\n" +
                "    FOREIGN KEY (`guitar_id` )\n" +
                "    REFERENCES  `guitar_info` (`guitar_id` )\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION)\n" +
                "ENGINE = InnoDB";
        try {
            st.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("1");
            System.out.println(e.toString());
        }
    }
}
