package GUI;

import javax.swing.*;

import Class.StudentClass;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class StudentPasswordChange extends JFrame implements ActionListener {
    ImageIcon icon = new ImageIcon("Media\\user.png");
    ImageIcon icon2 = new ImageIcon("Media\\exit.png");
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu();
    JButton menu2 = new JButton();
    JButton Confirm = new JButton("Confirm");
    JButton GoBack = new JButton("Go Back");
    JLabel Currentpassword = new JLabel("Current Password: ");
    JPasswordField Currentpasswordtf = new JPasswordField();
    JLabel Newpassword = new JLabel("New Password: ");
    JPasswordField Newpasswordtf = new JPasswordField();
    ImageIcon icon3 = new ImageIcon("Media\\eye.png");
    ImageIcon icon4 = new ImageIcon("Media\\hide.png");
    ImageIcon icon5 = new ImageIcon("Media\\eye.png");
    ImageIcon icon6 = new ImageIcon("Media\\hide.png");
    JCheckBox passhowButton = new JCheckBox("", icon3);
    JCheckBox Button2 = new JCheckBox("", icon5);
    private List<StudentClass> students = new ArrayList<>();
    Color color = new Color(37, 171, 186);
    StudentClass studentClass;
    StudentClass studentClass2;

    public StudentPasswordChange(StudentClass studentClass) {
        this.studentClass = studentClass;
        this.setLayout(null);
        getdata();

        menu = new JMenu(studentClass.getSid());
        menu.setIcon(icon);
        menu2.setIcon(icon2);
        menu2.addActionListener(this);
        menu2.setBorderPainted(false);
        menu2.setBorder(null);
        menu2.setMargin(new Insets(0, 0, 0, 0));
        menu2.setContentAreaFilled(false);
        menuBar.add(menu);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(menu2);
        menuBar.setBackground(color);

        Currentpassword.setBounds(350, 100, 300, 30);
        Newpassword.setBounds(350, 150, 300, 30);
        Currentpasswordtf.setBounds(500, 100, 300, 30);
        Newpasswordtf.setBounds(500, 150, 300, 30);
        passhowButton.setBounds(770, 100, 24, 24);
        Button2.setBounds(770, 150, 24, 24);

        Currentpasswordtf.setBackground(Color.white);
        Currentpasswordtf.setOpaque(false);
        Newpasswordtf.setBackground(Color.white);
        Newpasswordtf.setOpaque(false);
        Currentpasswordtf.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        Newpasswordtf.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));

        passhowButton.setBorderPainted(false);
        passhowButton.setBorder(null);
        passhowButton.setMargin(new Insets(0, 0, 0, 0));
        passhowButton.setContentAreaFilled(false);
        passhowButton.addActionListener(this);

        Button2.setBorderPainted(false);
        Button2.setBorder(null);
        Button2.setMargin(new Insets(0, 0, 0, 0));
        Button2.setContentAreaFilled(false);
        Button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Button2.isSelected()) {
                    Newpasswordtf.setEchoChar((char) 0);
                    Button2.setIcon(icon6);
                } else {
                    Newpasswordtf.setEchoChar('*');
                    Button2.setIcon(icon5);

                }
            }
        });

        Confirm.setBounds(600, 250, 100, 30);
        Confirm.setBackground(color);
        Confirm.addActionListener(this);
        GoBack.setBounds(400, 250, 100, 30);
        GoBack.setBackground(color);
        GoBack.addActionListener(this);

        this.setJMenuBar(menuBar);
        this.setSize(1200, 800);
        this.setBackground(color);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.add(passhowButton);
        this.add(Button2);
        this.add(Currentpassword);
        this.add(Currentpasswordtf);
        this.add(Newpassword);
        this.add(Newpasswordtf);
        this.add(Confirm);
        this.add(GoBack);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean c = passhowButton.isSelected();
        boolean nr = Button2.isSelected();
        if (c) {
            passhowButton.setIcon(icon4);
            Currentpasswordtf.setEchoChar((char) 0);

        } else if (!c) {
            passhowButton.setIcon(icon3);
            Currentpasswordtf.setEchoChar('*');

        }

        if (e.getSource() == menu2) {
            this.dispose();
            new Login();
        } else if (e.getSource() == GoBack) {
            this.dispose();
            new Student(studentClass);
        } else if (e.getSource() == Confirm) {
            String cr = new String(Currentpasswordtf.getPassword());
            String nw = new String(Newpasswordtf.getPassword());

            for (StudentClass student : students) {
                if (student.getSid().equals(studentClass.getSid())) {
                    studentClass2 = student;
                    students.remove(student);
                    break;
                }
            }
            if (studentClass2.getPassword().equals(cr)) {
                studentClass2.setPassword(nw);
                students.add(studentClass2);
                setdata();
                JOptionPane.showMessageDialog(this, "Password Changed");

            } else {
                JOptionPane.showMessageDialog(this, "Password Does Not Match");
            }

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

}
