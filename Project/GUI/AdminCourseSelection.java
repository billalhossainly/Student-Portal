package GUI;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import Class.Courses;
import Class.StudentClass;
import Components.CourseTable;

public class AdminCourseSelection extends JFrame implements ActionListener {
    JLabel sJLabel = new JLabel();
    ImageIcon icon = new ImageIcon("Media\\user.png");
    ImageIcon icon2 = new ImageIcon("Media\\exit.png");
    String[] days = { "Sunday-Tuesday", "Monday-Wednesday" };
    String[] time = { "8:00-10:00", "10:00-12:00", "12:00-2:00", "2:00-4:00" };
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Admin");
    JButton menu2 = new JButton();
    CourseTable courseTable2;
    JTable table;
    JScrollPane scrollPane;
    JComboBox<String> C0;
    JComboBox<String> C1;
    JComboBox<String> C2;
    JComboBox<String> C3;
    JComboBox<String> C4;
    JComboBox<String> C5;
    JComboBox<String> C6;
    JComboBox<String> C7;
    JComboBox<String> day1 = new JComboBox<String>(days);

    JComboBox<String> time1 = new JComboBox<String>(time);

    JLabel Course1 = new JLabel("Select Course 1:");

    JPanel panel = new JPanel();
    JButton Next = new JButton("Next");
    JButton Addc1 = new JButton("Add");

    JButton Back = new JButton("Back");
    Courses[] c = new Courses[20];
    Courses[] c2 = new Courses[20];
    Courses temp = new Courses();
    private List<Courses> courses = new ArrayList<>();
    private List<Courses> courses1 = new ArrayList<>();
    private List<Courses> courses4 = new ArrayList<>();
    private List<Courses> cList = new ArrayList<>();
    Data data = new Data();
    Color color = new Color(37, 171, 186);
    String coursename[] = new String[42];
    StudentClass student;
    private List<StudentClass> students = new ArrayList<>();

    public AdminCourseSelection(StudentClass student) {
        this.setLayout(null);
        this.student = student;
        courses = data.geList();
        getdata();
        getCdata();
        setcour();

        getcoursename(courses);
        Arrays.sort(coursename);
        C0 = new JComboBox<String>(coursename);
        C1 = new JComboBox<String>(coursename);
        C2 = new JComboBox<String>(coursename);
        C3 = new JComboBox<String>(coursename);
        C4 = new JComboBox<String>(coursename);
        C5 = new JComboBox<String>(coursename);
        C6 = new JComboBox<String>(coursename);
        C7 = new JComboBox<String>(coursename);

        menu.setIcon(icon);
        menu2.setIcon(icon2);
        menu2.addActionListener(this);
        menu2.setBorderPainted(false);
        menu2.setBorder(null);
        menu2.setMargin(new Insets(0, 0, 0, 0));
        menu2.setContentAreaFilled(false);
        sJLabel.setText(student.getName());
        sJLabel.setBounds(100, 00, 100, 30);

        Course1.setBounds(100, 150, 200, 30);

        C0.setBounds(200, 150, 380, 30);

        day1.setBounds(600, 150, 150, 30);

        time1.setBounds(770, 150, 100, 30);

        Addc1.setBounds(900, 150, 100, 30);
        Addc1.setBackground(color);
        Addc1.setFocusable(false);
        Addc1.addActionListener(this);

        Next.setBounds(550, 600, 100, 30);
        Next.setBackground(color);
        Next.setFocusable(false);
        Next.addActionListener(this);
        Back.setBounds(400, 600, 100, 30);
        Back.setBackground(color);
        Back.setFocusable(false);
        Back.addActionListener(this);
        menuBar.add(menu);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(menu2);
        menuBar.setBackground(color);
        courseTable2 = new CourseTable();
        courseTable2.setData(courses4);
        table = new JTable(courseTable2);
        table.setOpaque(false);
        table.getTableHeader().setBackground(color);
        table.getTableHeader().setForeground(Color.BLACK);
        table.setGridColor(Color.black);
        table.setRowHeight(50);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(100, 200, 1000, 300);
        this.add(scrollPane);

        this.setJMenuBar(menuBar);
        this.add(C0);

        this.add(Course1);

        this.add(Addc1);

        this.add(day1);

        this.add(time1);

        this.add(sJLabel);

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

        } else if (e.getSource() == Next) {
            for (int i = 0; i < c2.length; i++) {
                if (c2[i] != null) {
                    System.out.println(c2[i]);
                    c2[i].show();
                    courses1.add(c2[i]);
                    student.addCourse(c2[i]);
                }

            }

            this.dispose();
            new AdminFinalCourses(student);
        } else if (e.getSource() == Back) {
            this.dispose();
            new Admin();
        } else if (e.getSource() == Addc1) {
            String cname = C0.getSelectedItem().toString();
            String day = day1.getSelectedItem().toString();
            String time = time1.getSelectedItem().toString();
            System.out.println(cname);
            System.out.println(day);
            System.out.println(time);

            boolean empty = true;
            for (int i = 0; i < c.length; i++) {
                if (c[i] != null) {
                    empty = false;
                    break;
                }
            }

            for (int i = 0; i < c.length; i++) {
                if (empty) {
                    if (c2[i] == null) {
                        c[i] = new Courses(cname, day, time, student.getSid());
                        c2[i] = new Courses(cname, day, time, student.getSid());
                        courses4.add(c2[i]);
                        JOptionPane.showMessageDialog(this, "Added.");

                        break;
                    }
                } else if (c[i] != null && c[i].getCName().equals(cname)) {
                    JOptionPane.showMessageDialog(this, "Same Course Already Take.", "Alert",
                            JOptionPane.WARNING_MESSAGE);
                    break;
                } else if (c[i] != null && c[i].getDate().equals(day) && c[i].getTime().equals(time)) {
                    JOptionPane.showMessageDialog(this, "Time Clash.", "Alert",
                            JOptionPane.WARNING_MESSAGE);
                    break;
                } else if (c[i] == null) {
                    if (c2[i] == null) {
                        c[i] = new Courses(cname, day, time, student.getSid());
                        c2[i] = new Courses(cname, day, time, student.getSid());
                        courses4.add(c2[i]);
                        JOptionPane.showMessageDialog(this, "Added.");

                        break;
                    }

                }

            }

            courseTable2.refresh();

        }

    }

    public void getcoursename(List<Courses> courses) {
        int j = 0;
        for (Courses i : courses) {
            coursename[j] = i.getCName();
            j++;

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

    public void setdata2() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(student.getName());
            System.out.println(students.get(i).getName());
            if (students.get(i).getSid() == student.getSid()) {
                students.get(i).sCourses(student.gCourses());

            }

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

    public void setcour() {
        int i = 0;
        for (Courses courses : cList) {
            if (c[i] == null && courses.getSID().equals(student.getSid())) {
                courses4.add(courses);
                c[i] = courses;
                i++;

            }

        }
    }
}
