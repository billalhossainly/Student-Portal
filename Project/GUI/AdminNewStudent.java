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

import Class.StudentClass;

public class AdminNewStudent extends JFrame implements ActionListener {
    ImageIcon icon = new ImageIcon("Media\\user.png");
    ImageIcon icon2 = new ImageIcon("Media\\exit.png");
    ImageIcon icon3 = new ImageIcon("Media\\eye.png");
    ImageIcon icon4 = new ImageIcon("Media\\hide.png");
    JCheckBox passhowButton = new JCheckBox("", icon3);
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Admin");
    JButton menu2 = new JButton();
    Color color = new Color(37, 171, 186);
    JButton Confirm = new JButton("Confirm");
    JButton Back = new JButton("Back");
    JLabel sidl = new JLabel("ID: ");
    JLabel namel = new JLabel("Name: ");
    JLabel passl = new JLabel("Password: ");
    JTextField name = new JTextField();
    JTextField sid = new JTextField();
    JPasswordField pass = new JPasswordField();
    private List<StudentClass> students = new ArrayList<>();
    StudentClass student;

    public AdminNewStudent() {
        this.setLayout(null);
        getdata();
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

        Confirm.setBounds(650, 300, 100, 30);
        Confirm.setBackground(color);
        Confirm.setFocusable(false);
        Confirm.addActionListener(this);
        Back.setBounds(450, 300, 100, 30);
        Back.setBackground(color);
        Back.setFocusable(false);
        Back.addActionListener(this);

        sidl.setBounds(450, 100, 300, 30);
        namel.setBounds(430, 150, 300, 30);
        passl.setBounds(410, 200, 300, 30);
        sid.setBounds(500, 100, 300, 30);
        name.setBounds(500, 150, 300, 30);
        pass.setBounds(500, 200, 300, 30);
        passhowButton.setBounds(770, 200, 24, 24);
        sid.setBackground(Color.white);
        sid.setOpaque(false);
        name.setBackground(Color.white);
        name.setOpaque(false);
        pass.setBackground(Color.white);
        pass.setOpaque(false);
        passhowButton.setBorderPainted(false);
        passhowButton.setBorder(null);
        passhowButton.setMargin(new Insets(0, 0, 0, 0));
        passhowButton.setContentAreaFilled(false);

        passhowButton.addActionListener(this);
        sid.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        name.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        pass.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));

        this.setJMenuBar(menuBar);
        this.add(passhowButton);
        this.add(Confirm);
        this.add(Back);
        this.add(name);
        this.add(namel);
        this.add(sid);
        this.add(sidl);
        this.add(pass);
        this.add(passl);
        this.setSize(1200, 800);
        this.setBackground(Color.white);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

    }

    public void actionPerformed(ActionEvent e) {
        if (passhowButton.isSelected()) {
            passhowButton.setIcon(icon4);
            pass.setEchoChar((char) 0);

        } else {
            passhowButton.setIcon(icon3);
            pass.setEchoChar('*');

        }
        if (e.getSource() == menu2) {
            this.dispose();
            new Login();

        } else if (e.getSource() == Back) {
            this.dispose();
            new Admin();
        } else if (e.getSource() == Confirm) {
            String sids = sid.getText();
            String names = name.getText();
            String passs = new String(pass.getPassword());
            if (sids.isEmpty() || names.isEmpty() || passs.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Fill All Fields");
            } else {
                for (StudentClass studentClass : students) {
                    if (studentClass.getSid().equals(sids)) {
                        JOptionPane.showMessageDialog(this, "ID Already Taken");
                        break;
                    } else {
                        student = new StudentClass(names, passs, sids);
                        students.add(student);
                        setdata();
                        JOptionPane.showMessageDialog(this, "New Student Created");
                        sid.setText("");
                        name.setText("");
                        pass.setText("");
                        break;

                    }

                }
            }

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

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
