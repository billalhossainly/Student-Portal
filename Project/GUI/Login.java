package GUI;

import Components.*;
import java.awt.*;

import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import javax.swing.plaf.ColorUIResource;

import Class.AdminClass;
import Class.Courses;
import Class.StudentClass;

public class Login extends JFrame implements ActionListener {
    private List<StudentClass> students = new ArrayList<>();
    Courses[] courses = new Courses[10];
    JTextField textField;
    JButton bt = new JButton("Login");
    JButton bt1 = new JButton("Login");
    TeacherPanel panel1 = new TeacherPanel();
    AdminPanel panel2 = new AdminPanel();
    Color color = new Color(37, 171, 186);
    JTabbedPane tp = new JTabbedPane();
    Data data = new Data();
    ImageIcon uni = new ImageIcon("Media\\university1.png");
    JLabel icon = new JLabel(uni);
    private List<StudentClass> students2 = new ArrayList<>();
    AdminClass adminClass = new AdminClass("admin", "admin", "111111");
    StudentClass studentClass2;

    public Login() {

        getdata4();
        this.setLayout(null);

        bt.setBounds(550, 450, 200, 30);
        bt.setFocusable(false);
        bt.setBackground(color);
        bt.addActionListener(this);
        bt1.setBounds(550, 450, 200, 30);
        bt1.setFocusable(false);
        bt1.setBackground(color);
        bt1.addActionListener(this);
        icon.setBounds(00, 250, 300, 300);

        UIManager.put("TabbedPane.borderColor", new ColorUIResource(color));
        UIManager.put("TabbedPane.borderHightlightColor", new ColorUIResource(color));
        UIManager.put("TabbedPane.darkShadow", new ColorUIResource(color));
        UIManager.put("TabbedPane.contentAreaColor", new ColorUIResource(
                color));
        UIManager.put("TabbedPane.selected", color);
        panel1.add(bt);
        panel2.add(bt1);

        tp.setBounds(00, 00, 1200, 800);

        tp.add("Student Login", panel1);
        tp.add("Admin Login", panel2);
        this.add(tp);
        this.setSize(1200, 800);
        this.setLayout(null);
        this.setBackground(Color.white);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt) {
            String Sid = panel1.getname();
            String pass = panel1.getpass();

            boolean check = false;
            for (StudentClass s : students) {

                if (s.getSid().equals(Sid) && s.getPassword().equals(pass)) {
                    check = true;
                    studentClass2 = s;

                }
            }
            if (check) {
                this.dispose();
                new Student(studentClass2);
            } else {
                JOptionPane.showMessageDialog(this, "Id Password Mismatch.", "Alert",
                        JOptionPane.WARNING_MESSAGE);

            }

        } else if (e.getSource() == bt1) {
            String Sid = panel2.getname();
            String pass = panel2.getpass();
            if (adminClass.getName().equals(Sid) && adminClass.getPassword().equals(pass)) {
                this.dispose();
                new Admin();
            } else {
                JOptionPane.showMessageDialog(this, "Id Password Mismatch.", "Alert",
                        JOptionPane.WARNING_MESSAGE);

            }

        }
    }

    public void setdata() {
        try {
            FileOutputStream fos = new FileOutputStream("Model\\sobj.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students2);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getdata4() {
        try {
            FileInputStream fis = new FileInputStream("Model\\sobj.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (ArrayList) ois.readObject();
            ois.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }

    }
}