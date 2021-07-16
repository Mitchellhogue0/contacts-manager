import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Contact {

    protected HashMap<String, Long> contact = new HashMap<>();

    public Contact(String name, Long number) {
        this.contact.put(name, number);
    }

    public Set<Map.Entry<String, Long>> getContact() {
        return contact.entrySet();
    }

    public void setContact(String name, Long number) {
        this.contact.put(name, number);
    }
}
