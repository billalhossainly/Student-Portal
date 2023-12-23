package GUI;

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

import Class.*;

public class AdminIDselection extends JFrame implements ActionListener {
    int s;
    ImageIcon icon = new ImageIcon("Media\\user.png");
    ImageIcon icon2 = new ImageIcon("Media\\exit.png");
    int setSize;
    String[] ids = new String[50];

    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Admin");
    JButton menu2 = new JButton();

    JPanel panel = new JPanel();
    JButton Next = new JButton("Next");
    JButton Back = new JButton("Back");
    JLabel Year = new JLabel("Select Id:");
    JComboBox<String> Id;
    private List<Courses> cList = new ArrayList<>();
    private List<StudentClass> students = new ArrayList<>();
    StudentClass student;

    Color color = new Color(37, 171, 186);
    Data data = new Data();

    public AdminIDselection() {

        this.setLayout(null);

        getdata();
        getCdata();
        ids = new String[students.size()];

        sid();

        Id = new JComboBox<String>(ids);

        menu.setIcon(icon);
        menu2.setIcon(icon2);
        menu2.addActionListener(this);
        menu2.setBorderPainted(false);
        menu2.setBorder(null);
        menu2.setMargin(new Insets(0, 0, 0, 0));
        menu2.setContentAreaFilled(false);

        Year.setBounds(320, 150, 200, 30);
        Id.setBounds(400, 150, 300, 30);
        Next.setBounds(750, 150, 100, 30);
        Next.setBackground(color);
        Next.setFocusable(false);
        Next.addActionListener(this);
        Back.setBounds(500, 200, 100, 30);
        Back.setBackground(color);
        Back.setFocusable(false);
        Back.addActionListener(this);
        menuBar.add(menu);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(menu2);
        menuBar.setBackground(color);

        this.setJMenuBar(menuBar);
        this.add(Id);
        this.add(Year);
        this.add(Next);
        this.add(Back);

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
        } else if (e.getSource() == Next) {
            String id = Id.getSelectedItem().toString();
            boolean check = false;

            if (!check) {
                for (StudentClass s : students) {
                    System.out.println(s.getName());
                    if (s.getSid().equals(id)) {
                        student = s;
                    }
                }
                this.dispose();
                new AdminCourseSelection(student);
            } else {
                JOptionPane.showMessageDialog(this, "Id already completed Registration", "Alert",
                        JOptionPane.WARNING_MESSAGE);
            }

        }

    }

    public void sid() {
        int j = 0;

        for (StudentClass i : students) {

            ids[j] = i.getSid();

            j++;

        }

    }

    public void setdata() {
        try {
            FileOutputStream fos = new FileOutputStream("Model\\sobj.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getdata() {
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

    public void getCdata() {
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

}
