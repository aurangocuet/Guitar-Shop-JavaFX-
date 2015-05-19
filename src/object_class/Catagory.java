package object_class;

/**
 * Created by AURANGO SABBIR on 11/25/2014.
 */
public class Catagory {
    private int guitar_catagory_id;
    private String guitar_catagory_decp;

    public Catagory() {

    }

    public Catagory(int guitar_catagory_id, String guitar_catagory_decp) {
        this.guitar_catagory_id = guitar_catagory_id;
        this.guitar_catagory_decp = guitar_catagory_decp;
    }

    public void setGuitar_catagory_id(int guitar_catagory_id) {
        this.guitar_catagory_id = guitar_catagory_id;
    }

    public void setGuitar_catagory_decp(String guitar_catagory_decp) {
        this.guitar_catagory_decp = guitar_catagory_decp;
    }

    public int getGuitar_catagory_id() {
        return guitar_catagory_id;
    }

    public String getGuitar_catagory_decp() {
        return guitar_catagory_decp;
    }

    public String toString() {
        return guitar_catagory_decp;
    }
}
