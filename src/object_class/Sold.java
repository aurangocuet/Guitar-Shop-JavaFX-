package object_class;

/**
 * Created by AURANGO SABBIR on 12/23/2014.
 */
public class Sold {
    public int guitar_sold_id;
    public int customer_id;
    public int guitar_id;
    public String guitar_sold_date;

    public void setGuitar_sold_id(int guitar_sold_id) {
        this.guitar_sold_id = guitar_sold_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setGuitar_id(int guitar_id) {
        this.guitar_id = guitar_id;
    }

    public void setGuitar_sold_date(String guitar_sold_date) {
        this.guitar_sold_date = guitar_sold_date;
    }

    public int getGuitar_sold_id() {
        return guitar_sold_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public int getGuitar_id() {
        return guitar_id;
    }

    public String getGuitar_sold_date() {
        return guitar_sold_date;
    }
}
