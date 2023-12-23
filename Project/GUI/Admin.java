package GUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Admin extends JFrame implements ActionListener {
    ImageIcon icon = new ImageIcon("Media\\user.png");
    ImageIcon icon2 = new ImageIcon("Media\\exit.png");
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Admin");
    JButton menu2 = new JButton();
    JPanel panel = new JPanel();
    Color color = new Color(37, 171, 186);
    JButton Next = new JButton("Add Course");
    JButton Remove = new JButton("Remove Course");
    JButton CreateSt = new JButton("Create New Student Account");

    public Admin() {
        this.setLayout(null);

        menu.setIcon(icon);
        menu2.setIcon(icon2);
        menu2.addActionListener(this);
        menu2.setBorderPainted(false);
        menu2.setBorder(null);
        menu2.setMargin(new Insets(0, 0, 0, 0));
        menu2.setContentAreaFilled(false);

        Next.setBounds(400, 150, 400, 50);
        Next.setBackground(color);
        Next.setFocusable(false);
        Next.addActionListener(this);

        Remove.setBounds(400, 250, 400, 50);
        Remove.setBackground(color);
        Remove.setFocusable(false);
        Remove.addActionListener(this);

        CreateSt.setBounds(400, 350, 400, 50);
        CreateSt.setBackground(color);
        CreateSt.setFocusable(false);
        CreateSt.addActionListener(this);

        menuBar.add(menu);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(menu2);
        menuBar.setBackground(color);

        this.setJMenuBar(menuBar);

        this.add(Next);
        this.add(Remove);
        this.add(CreateSt);

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

            this.dispose();
            new AdminIDselection();
        } else if (e.getSource() == Remove) {
            this.dispose();
            new AdminRemoveCourseID();
        } else if (e.getSource() == CreateSt) {
            this.dispose();
            new AdminNewStudent();
        }
    }
}