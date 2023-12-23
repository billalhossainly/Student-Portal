package GUI;

import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import Class.Courses;
import Class.StudentClass;
import Components.CourseTable;
import Components.CourseTable2;

public class AdminRemoveCourse extends JFrame implements ActionListener {
    ImageIcon icon = new ImageIcon("Media\\user.png");
    ImageIcon icon2 = new ImageIcon("Media\\exit.png");
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Admin");
    JButton menu2 = new JButton();
    JPanel panel = new JPanel();
    JButton Next = new JButton("Remove Course");
    JButton Add = new JButton("Add Course");
    JButton Back = new JButton("Back");
    Color color = new Color(37, 171, 186);
    JLabel label;
    List<Courses> courses = new ArrayList<>();
    List<Courses> courses1 = new ArrayList<>();
    List<Courses> cList = new ArrayList<>();
    CourseTable2 courseTable2;
    JTable table;
    JScrollPane scrollPane;
    Courses[] course = new Courses[10];
    StudentClass studentClass;

    public AdminRemoveCourse(StudentClass studentClass) {
        this.setLayout(null);
        this.studentClass = studentClass;
        course = studentClass.gCourses();

        getdata();
        setcourses();
        courses1 = cList;

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
        Next.setBounds(800, 550, 200, 30);
        Next.setBackground(color);
        Next.setFocusable(false);
        Next.addActionListener(this);
        Add.setBounds(500, 550, 200, 30);
        Add.setBackground(color);
        Add.setFocusable(false);
        Add.addActionListener(this);
        Back.setBounds(200, 550, 200, 30);
        Back.setBackground(color);
        Back.setFocusable(false);
        Back.addActionListener(this);
        courseTable2 = new CourseTable2();
        courseTable2.setData(courses);
        table = new JTable(courseTable2);
        table.setOpaque(false);
        table.getTableHeader().setBackground(color);
        table.getTableHeader().setForeground(Color.BLACK);
        table.setGridColor(Color.black);
        table.setRowHeight(50);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(100, 00, 1000, 400);
        this.add(scrollPane);

        this.setJMenuBar(menuBar);
        this.setSize(1200, 800);
        this.setBackground(Color.white);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.add(Next);
        this.add(Back);
        this.add(Add);
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
            boolean getCheck = false;

            for (int i = 0; i < courseTable2.getRowCount(); i++) {
                Boolean selected = (Boolean) courseTable2.getValueAt(i, 5);

                if (selected) {
                    String Cname = (String) courseTable2.getValueAt(i, 0);
                    for (Courses course : courses1) {
                        if (course.getCName().equals(Cname) && course.getSID().equals(studentClass.getSid())) {
                            System.out.println(course.getCName());
                            courses1.remove(course);
                            courses.remove(course);
                            getCheck = true;

                            break;
                        }
                    }

                }
            }
            if (getCheck) {
                JOptionPane.showMessageDialog(this, "Removed");
                courseTable2.refresh();
                setdata2();

            } else {
                JOptionPane.showMessageDialog(this, "Select A Course");
            }

        } else if (e.getSource() == Add) {
            this.dispose();
            new AdminCourseSelection(studentClass);
        }
    }

    public void setcourses() {
        for (Courses courses4 : cList) {
            if (courses4.getSID() == studentClass.getSid()) {
                courses.add(courses4);
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
        for (Courses cours : cList) {
            if (cours.getSID().equals(studentClass.getSid())) {
                courses.add(cours);
            }

        }

    }

    public void setdata2() {
        try {
            FileOutputStream fos = new FileOutputStream("Model\\cobj.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(courses1);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
