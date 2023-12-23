package GUI;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import Class.Courses;
import Class.StudentClass;
import Components.CourseTable;

public class AdminFinalCourses extends JFrame implements ActionListener {
    ImageIcon icon = new ImageIcon("Media\\user.png");
    ImageIcon icon2 = new ImageIcon("Media\\exit.png");
    String[] ids = { "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" };
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Admin");
    JScrollPane scrollPane;
    JButton menu2 = new JButton();
    JComboBox<String> Id = new JComboBox<String>(ids);;
    JLabel ID = new JLabel();
    JPanel panel = new JPanel();
    JButton Back = new JButton("Back");
    JButton Remove = new JButton("Remove Course");
    CourseTable courseTablea;
    JTable tablea;
    private List<Courses> courses1 = new ArrayList<>();
    private List<Courses> courses2 = new ArrayList<>();
    StudentClass studentClass;
    Courses[] course = new Courses[10];

    private List<Courses> cList = new ArrayList<>();

    Color color = new Color(37, 171, 186);

    public AdminFinalCourses(StudentClass studentClass) {
        this.setLayout(null);
        this.studentClass = studentClass;

        course = studentClass.gCourses();
        setcourses();
        setcourses1();
        getdata();
        setdata2();

        menu.setIcon(icon);
        menu2.setIcon(icon2);
        menu2.addActionListener(this);
        menu2.setBorderPainted(false);
        menu2.setBorder(null);
        menu2.setMargin(new Insets(0, 0, 0, 0));
        menu2.setContentAreaFilled(false);
        ID.setText("Name: " + studentClass.getName() + " Id: " + studentClass.getSid());
        ID.setFont(new Font("Arial", Font.PLAIN, 20));
        ID.setBounds(00, 00, 500, 30);

        menuBar.add(menu);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(menu2);
        menuBar.setBackground(color);
        courseTablea = new CourseTable();
        courseTablea.setData(courses1);
        tablea = new JTable(courseTablea);
        tablea.setOpaque(false);
        tablea.getTableHeader().setBackground(color);
        tablea.getTableHeader().setForeground(Color.BLACK);
        tablea.setGridColor(Color.black);
        tablea.setRowHeight(50);
        scrollPane = new JScrollPane(tablea);
        scrollPane.setBounds(100, 100, 1000, 400);

        Back.setBackground(color);
        Back.setFocusable(false);
        Back.addActionListener(this);
        Back.setBounds(300, 550, 200, 30);

        Remove.setBackground(color);
        Remove.setFocusable(false);
        Remove.addActionListener(this);
        Remove.setBounds(600, 550, 200, 30);

        this.setJMenuBar(menuBar);
        this.add(scrollPane);
        this.add(ID);
        this.add(Back);
        this.add(Remove);

        this.setSize(1200, 800);
        this.setBackground(Color.white);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menu2) {
            this.dispose();
            new Login();
        } else if (e.getSource() == Back) {
            this.dispose();
            new Admin();
        } else if (e.getSource() == Remove) {
            this.dispose();
            new AdminRemoveCourse(studentClass);
        }
    }

    public void setcourses() {
        for (int i = 0; i < course.length; i++) {
            if (course[i] != null) {
                System.out.println(course[i].getCName());
                courses1.add(course[i]);
            }

        }

    }

    public void setcourses1() {
        for (int i = 0; i < course.length; i++) {
            if (course[i] != null) {
                System.out.println(course[i].getCName());
                courses2.add(course[i]);
            }

        }

    }

    public void getdata() {
        try {
            FileInputStream fis = new FileInputStream("Model\\cobj.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            cList = (ArrayList) ois.readObject();
            ois.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException c) {

            c.printStackTrace();
        }

    }

    public void setdata2() {
        for (Courses c : cList) {
            courses2.add(c);
        }
        try {
            FileOutputStream fos = new FileOutputStream("Model\\cobj.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(courses2);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
