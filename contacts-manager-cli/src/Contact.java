import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Contact {

   protected String name;
   protected String number;

    public Contact(String name, String number) {
        this.name = name;
        if (number.length() == 10){
            this.number = number.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
        } else {
            this.number = number;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if (number.length() == 10){
            this.number = number.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
        } else {
            this.number = number;
        }
    }
}
