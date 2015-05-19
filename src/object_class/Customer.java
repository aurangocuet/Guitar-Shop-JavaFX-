package object_class;

/**
 * Created by AURANGO SABBIR on 12/23/2014.
 */
public class Customer {
    public int customer_id;
    public String customer_name;
    public String customer_address;
    public String customer_contact;

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public void setCustomer_contact(String customer_contact) {
        this.customer_contact = customer_contact;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public String getCustomer_contact() {
        return customer_contact;
    }

    public String toString(){
        return this.getCustomer_name()+" NUMBER :"+this.getCustomer_contact();
    }
}
