package Components;

import java.awt.*;

import java.awt.event.*;

import java.util.*;
import java.util.List;

import javax.swing.*;

import javax.swing.table.DefaultTableCellRenderer;

import Class.Courses;

public class Panel extends JPanel implements ActionListener {
    JLabel l1 = new JLabel("Name: ");
    JLabel l2 = new JLabel("Password: ");
    JLabel l4 = new JLabel();
    JTextField tf1 = new JTextField();
    JPasswordField tf2 = new JPasswordField();
    JButton bt = new JButton("Login");
    ImageIcon icon = new ImageIcon("Media\\eye.png");
    ImageIcon icon2 = new ImageIcon("Media\\hide.png");
    JCheckBox passhowButton = new JCheckBox("", icon);
    CourseTable courseTable;
    JTable table;
    private List<Courses> courses = new ArrayList<>();
    Courses c1 = new Courses("aaaaa", "A", "2001", "Monday", "8:30", 3);
    Courses c2 = new Courses("aaaaa", "B", "2002", "Sunday", "8:30", 3);
    Courses c3 = new Courses("aaaaa", "C", "2003", "Monday", "8:30", 3);
    Courses c4 = new Courses("aaaaa", "D", "2004", "Sunday", "8:30", 3);
    Courses c5 = new Courses("aaaaa", "E", "2005", "Monday", "8:30", 3);

    public Panel() {
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
        courses.add(c4);
        courses.add(c5);
        courseTable = new CourseTable();

        table = new JTable(courseTable);
        table.setOpaque(false);
        table.getTableHeader().setBackground(Color.pink);
        table.getTableHeader().setForeground(Color.BLACK);
        table.setGridColor(Color.black);
        table.setRowHeight(50);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);

        courseTable.setData(courses);

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(00, 00, 1200, 800);
        this.add(sp);
        this.setLayout(null);
        this.setSize(400, 400);
        this.setVisible(true);
        this.setBackground(Color.white);

    }

    public void setdata(List<Courses> courses) {
        courseTable.setData(courses);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (passhowButton.isSelected()) {
            passhowButton.setIcon(icon2);
            tf2.setEchoChar((char) 0);

        } else {
            passhowButton.setIcon(icon);
            tf2.setEchoChar('*');

        }
    }

}
