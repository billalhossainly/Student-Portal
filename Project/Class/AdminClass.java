package Class;

public class AdminClass extends User {
    private String Aid;

    public AdminClass(String aid) {
        Aid = aid;
    }

    public AdminClass(String name, String password, String aid) {
        super(name, password);
        Aid = aid;
    }

    public String getAid() {
        return Aid;
    }

    public void setAid(String aid) {
        Aid = aid;
    }

}
