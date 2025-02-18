import java.util.HashMap;
import java.util.Map;

public class  Credentials {
    Map<String,String>credentials= new HashMap<String,String>();
    Credentials(){
        credentials.put("mahin","123");
        credentials.put("ananya","123");
        credentials.put("vanshika","123");
    }
    void addUser(String name,String password){
        credentials.put(name,password);

    }
    boolean isValidUser(String name, String password) {
        return credentials.containsKey(name) && credentials.get(name).equals(password);
    }
}
