package Class;

import java.io.Serializable;

public class Courses implements Serializable {
    private String CName;
    private String Section;
    private String Room;

    private String Date;
    private String Time;
    private int Credit = 3;
    private String SID;
    private double Ammount = 16500;
    private Boolean check = false;

    public Courses() {
    }

    public Courses(String cName, String date, String time) {
        CName = cName;
        Date = date;
        Time = time;
    }

    public Courses(String cName, String date, String time, String sID) {
        CName = cName;
        Date = date;
        Time = time;
        SID = sID;
    }

    public Courses(String cName, String section, String room, String date, String time, int credit, double ammount) {
        CName = cName;
        Section = section;
        Room = room;
        Date = date;
        Time = time;
        Credit = credit;
        Ammount = ammount;
    }

    public Courses(String cName, String section, String room, String date, String time, int credit) {
        CName = cName;
        Section = section;
        Room = room;
        Date = date;
        Time = time;
        Credit = credit;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String cName) {
        CName = cName;
    }

    public String getSection() {
        return Section;
    }

    public void setSection(String section) {
        Section = section;
    }

    public String getRoom() {
        return Room;
    }

    public void setRoom(String room) {
        Room = room;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public int getCredit() {
        return Credit;
    }

    public void setCredit(int credit) {
        Credit = credit;
    }

    public double getAmmount() {
        return Ammount;
    }

    public void setAmmount(double ammount) {
        Ammount = ammount;
    }

    public String getSID() {
        return SID;
    }

    public void setSID(String sID) {
        SID = sID;
    }

    public void show() {
        System.out.println("Name: " + CName + "\n" + "Date: " + Date + "\n" + "Time: " + Time);
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }

}
