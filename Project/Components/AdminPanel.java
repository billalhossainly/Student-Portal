package Components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

public class AdminPanel extends JPanel implements ActionListener {
    JLabel l1 = new JLabel("Name: ");
    JLabel l2 = new JLabel("Password: ");
    JLabel l4 = new JLabel();
    JTextField tf1 = new JTextField();
    JPasswordField tf2 = new JPasswordField();
    ImageIcon uni = new ImageIcon("Media\\university1.png");
    JLabel unicon = new JLabel(uni);
    Color color = new Color(37, 171, 186);

    ImageIcon icon = new ImageIcon("Media\\eye.png");
    ImageIcon icon2 = new ImageIcon("Media\\hide.png");
    JCheckBox passhowButton = new JCheckBox("", icon);

    public AdminPanel() {
        unicon.setBounds(470, 00, 300, 300);
        l1.setBounds(450, 300, 300, 30);
        l2.setBounds(430, 350, 300, 30);
        l4.setBounds(500, 00, 300, 30);
        tf1.setBounds(500, 300, 300, 30);
        tf2.setBounds(500, 350, 300, 30);
        passhowButton.setBounds(770, 350, 24, 24);
        UIManager.put("TabbedPane.borderColor", new ColorUIResource(color));
        UIManager.put("TabbedPane.borderHightlightColor", new ColorUIResource(color));
        UIManager.put("TabbedPane.darkShadow", new ColorUIResource(color));
        UIManager.put("TabbedPane.contentAreaColor", new ColorUIResource(
                color));
        UIManager.put("TabbedPane.selected", color);

        tf1.setBackground(Color.white);
        tf2.setBackground(Color.white);
        tf2.setOpaque(false);
        passhowButton.setBorderPainted(false);
        passhowButton.setBorder(null);
        passhowButton.setMargin(new Insets(0, 0, 0, 0));
        passhowButton.setContentAreaFilled(false);
        passhowButton.setRolloverIcon(icon);
        passhowButton.setPressedIcon(icon2);
        passhowButton.setDisabledIcon(icon2);
        passhowButton.addActionListener(this);
        tf1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        tf2.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        this.setLayout(null);
        this.setSize(400, 400);
        this.setVisible(true);
        this.setBackground(Color.white);
        this.add(passhowButton);
        this.add(tf1);
        this.add(tf2);
        this.add(l1);
        this.add(l2);
        this.add(l4);
        this.add(unicon);

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

    public String getname() {
        String name = new String(tf1.getText());
        System.out.println(tf1.getText());
        return name;
    }

    public String getpass() {
        String pass = new String(tf2.getPassword());
        return pass;
    }
}
