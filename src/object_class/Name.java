package object_class;

/**
 * Created by AURANGO SABBIR on 11/25/2014.
 */
public class Name {
    private int guitar_name_id;
    private String guitar_name;
    private int number_of_guitar;

    public Name(){

    }
    public Name(int guitar_name_id,String guitar_name,int number_of_guitar){
        this.guitar_name_id=guitar_name_id;
        this.guitar_name=guitar_name;
        this.number_of_guitar=number_of_guitar;
    }

    public void setGuitar_name_id(int guitar_name_id){
        this.guitar_name_id=guitar_name_id;
    }

    public void setGuitar_name(String guitar_name){
        this.guitar_name=guitar_name;
    }

    public void setNumber_of_guitar(int number_of_guitar){
        this.number_of_guitar=number_of_guitar;
    }

    public int getGuitar_name_id(){
        return guitar_name_id;
    }

    public String getGuitar_name(){
        return guitar_name;
    }

    public int getNumber_of_guitar(){
        return number_of_guitar;
    }

    public String toString(){
        return guitar_name;
    }
}
