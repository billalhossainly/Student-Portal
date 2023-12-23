package Class;

import java.io.Serializable;

public class User implements Serializable {
    private String Name;
    private String password;

    public User() {
    }

    public User(String name, String password) {
        Name = name;
        this.password = password;
    }

    public String getName() {
        return Name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void show() {
        System.out.println("Name: " + Name);
    }

}
