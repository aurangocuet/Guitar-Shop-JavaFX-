package object_class;

import com.mysql.jdbc.Blob;

/**
 * Created by AURANGO SABBIR on 11/25/2014.
 */
public class Guitar {
    private int guitar_id;
    private int guitar_company_id;
    private String guitar_company_name;
    private int guitar_name_id;
    private String guitar_name;
    private int guitar_catagory_id;
    private String guitar_catagory_decp;
    private String guitar_decp;
    private String guitar_colour;
    private Blob guitar_image;
    private float guitar_price;
    private float guitar_selling_price;
    private String guitar_arrival_date;
    private int avilable;

    public Guitar(int guitar_id, String guitar_company_name, String guitar_name, String guitar_catagory_decp, String guitar_decp, String guitar_colour, float guitar_price, float guitar_selling_price, String guitar_arrival_date, int avilable) {
        this.guitar_id = guitar_id;
        this.guitar_company_name = guitar_company_name;
        this.guitar_name = guitar_name;
        this.guitar_catagory_decp = guitar_catagory_decp;
        this.guitar_decp = guitar_decp;
        this.guitar_colour = guitar_colour;
        this.guitar_price = guitar_price;
        this.guitar_selling_price = guitar_selling_price;
        this.guitar_arrival_date = guitar_arrival_date;
        this.avilable = avilable;
    }

    public Guitar() {

    }

    public void setGuitar_id(int guitar_id) {
        this.guitar_id = guitar_id;
    }

    public void setGuitar_company_id(int guitar_company_id) {
        this.guitar_company_id = guitar_company_id;
    }

    public void setGuitar_company_name(String guitar_company_name) {
        this.guitar_company_name = guitar_company_name;
    }

    public void setGuitar_name_id(int guitar_name_id) {
        this.guitar_name_id = guitar_name_id;
    }

    public void setGuitar_name(String guitar_name) {
        this.guitar_name = guitar_name;
    }

    public void setGuitar_catagory_id(int guitar_catagory_id) {
        this.guitar_catagory_id = guitar_catagory_id;
    }

    public void setGuitar_catagory_decp(String guitar_catagory_decp) {
        this.guitar_catagory_decp = guitar_catagory_decp;
    }

    public void setGuitar_decp(String guitar_decp) {
        this.guitar_decp = guitar_decp;
    }

    public void setGuitar_colour(String guitar_colour) {
        this.guitar_colour = guitar_colour;
    }

    public void setGuitar_image(Blob guitar_image) {
        this.guitar_image = guitar_image;
    }

    public void setGuitar_price(float guitar_price) {
        this.guitar_price = guitar_price;
    }

    public void setGuitar_selling_price(float guitar_selling_price) {
        this.guitar_selling_price = guitar_selling_price;
    }

    public void setGuitar_arrival_date(String guitar_arrival_date) {
        this.guitar_arrival_date = guitar_arrival_date;
    }

    public void setAvilable(int avilable) {
        this.avilable = avilable;
    }

    public int getGuitar_id() {
        return this.guitar_id;
    }

    public String getGuitar_company_name() {
        return guitar_company_name;
    }

    public String getGuitar_name() {
        return guitar_name;
    }

    public String getGuitar_catagory_decp() {
        return guitar_catagory_decp;
    }

    public int getGuitar_company_id() {
        return guitar_company_id;
    }

    public int getGuitar_name_id() {
        return guitar_name_id;
    }

    public int getGuitar_catagory_id() {
        return guitar_catagory_id;
    }

    public String getGuitar_decp() {
        return guitar_decp;
    }

    public String getGuitar_colour() {
        return guitar_colour;
    }

    public Blob getGuitar_image() {
        return guitar_image;
    }


    public float getGuitar_price() {
        return guitar_price;
    }

    public float getGuitar_selling_price() {
        return guitar_selling_price;
    }

    public String getGuitar_arrival_date() {
        return guitar_arrival_date;
    }

    public int getAvilable() {
        return avilable;
    }

    public String toString() {
        return this.getGuitar_id()+"";
    }

    public Boolean finalizeObject() {
        if (this.isNotEmpty()) {
            return true;
        } else
            return false;
    }

    public Boolean isNotEmpty() {
        if (this.guitar_catagory_id != 0 && this.guitar_company_id != 0 && this.guitar_name_id != 0 && this.guitar_price != 0 && this.guitar_selling_price != 0 && this.guitar_colour != null && this.guitar_decp != null) {
            return true;
        } else
            return false;
    }
}
