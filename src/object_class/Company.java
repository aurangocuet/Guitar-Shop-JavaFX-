package object_class;

/**
 * Created by AURANGO SABBIR on 11/25/2014.
 */
public class Company {

    private int guitar_company_id;
    private String guitar_company_name;
    private String guitar_company_country;
    public Company(){

    }

    public void setGuitar_company_id(int guitar_company_id) {
        this.guitar_company_id = guitar_company_id;
    }

    public void setGuitar_company_name(String guitar_company_name) {
        this.guitar_company_name = guitar_company_name;
    }

    public void setGuitar_company_country(String guitar_company_country) {
        this.guitar_company_country = guitar_company_country;
    }

    public int getGuitar_company_id() {
        return guitar_company_id;
    }

    public String getGuitar_company_name() {
        return guitar_company_name;
    }

    public String getGuitar_company_country() {
        return guitar_company_country;
    }

    public String toString() {    return guitar_company_name;  }
}
