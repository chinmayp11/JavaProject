//package quiz;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.sql.*;



public class Login extends JFrame implements ActionListener {
    JLabel l1, l2, l3;

    JTextField tf1;

    JButton btn1,btn2;

    JPasswordField p1;

    public Login() {

        setTitle("Login Form ");

        setVisible(true);

        setSize(1000, 1000);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        l1 = new JLabel("Login Form ");

        l1.setForeground(Color.blue);

        l1.setFont(new Font("Serif", Font.BOLD, 50));


        l2 = new JLabel("Enter username:");
        l2.setFont(new Font("Serif", Font.BOLD, 20));

        l3 = new JLabel("Enter Password:");
        l3.setFont(new Font("Serif", Font.BOLD, 20));

        tf1 = new JTextField();
        // tf1.setFont(new Font("Serif", Font.BOLD, 20));

        p1 = new JPasswordField();

        btn1 = new JButton("Submit");
        btn2 = new JButton("Register");


        l1.setBounds(500, 50, 400, 30);

        l2.setBounds(400, 130, 150, 30);

        l3.setBounds(400, 200, 150, 30);

        tf1.setBounds(550, 130, 150, 30);

        p1.setBounds(550, 200, 150, 30);

        btn1.setBounds(500, 280, 150, 30);
        // btn2.setBounds(300, 160, 100, 30);


        add(l1);

        add(l2);

        add(tf1);

        add(l3);

        add(p1);

        add(btn1);
        // add(btn2);

        btn1.addActionListener(this);
        //btn2.addActionListener(this);

    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            String str1 = tf1.getText();

            char[] p = p1.getPassword();


            String str2 = new String(p);

            try {

                Class.forName("com.mysql.jdbc.Driver");

                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login?characterEncoding=latin1", "root", "prachi@123");

                PreparedStatement ps = con.prepareStatement("select * from l1 where username=? and password=?");

                ps.setString(1, str1);

                ps.setString(2, str2);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "login successful");
                    setVisible(false);
                    // S_Login obj = new S_Login();
                    //obj.login1();



                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login");
                }
            } catch (ClassNotFoundException ex1) {

                System.out.println(ex1);

            } catch (SQLException ex2) {
                System.out.println(ex2);
            }
            Example e3=new Example();


        }
    }

    public static void main(String args[])

    {
        Login l=new Login();
    }
}