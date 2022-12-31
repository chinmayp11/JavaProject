import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
public class RegistrationForm2 implements ActionListener {
    JFrame frame;
    ImageIcon img = new ImageIcon("imagecrime.png");
    JLabel back = new JLabel("",img,JLabel.CENTER);
    String[] gender={"Male","Female"};
    JLabel nameLabel=new JLabel("NAME");
    JLabel genderLabel=new JLabel("GENDER");
    JLabel fatherNameLabel=new JLabel("FATHER NAME");
    JLabel passwordLabel=new JLabel("PASSWORD");
    JLabel confirmPasswordLabel=new JLabel("CONFIRM PASSWORD");
    JLabel cityLabel=new JLabel("CITY");
    JLabel emailLabel=new JLabel("EMAIL");
    JTextField nameTextField=new JTextField();
    JComboBox genderComboBox=new JComboBox(gender);
    JTextField fatherTextField=new JTextField();
    JPasswordField passwordField=new JPasswordField();
    JPasswordField confirmPasswordField=new JPasswordField();
    JTextField cityTextField=new JTextField();
    JTextField emailTextField=new JTextField();
    JButton registerButton=new JButton("REGISTER");
    JButton resetButton=new JButton("RESET");


    RegistrationForm2()
    {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }
    public void createWindow()
    {
        frame=new JFrame();
        frame.setTitle("Registration Form");
        frame.setBounds(40,40,780,600);
//        frame.setBounds(40,40,380,600);
        frame.getContentPane().setBackground(Color.pink);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    public void setLocationAndSize()
    {
        nameLabel.setBounds(20,20,40,70);
        genderLabel.setBounds(20,70,80,70);
        fatherNameLabel.setBounds(20,120,100,70);
        passwordLabel.setBounds(20,170,100,70);
        confirmPasswordLabel.setBounds(20,220,140,70);
        cityLabel.setBounds(20,270,100,70);
        emailLabel.setBounds(20,320,100,70);
        nameTextField.setBounds(180,43,165,23);
        genderComboBox.setBounds(180,93,165,23);
        fatherTextField.setBounds(180,143,165,23);
        passwordField.setBounds(180,193,165,23);
        confirmPasswordField.setBounds(180,243,165,23);
        cityTextField.setBounds(180,293,165,23);
        emailTextField.setBounds(180,343,165,23);
        registerButton.setBounds(70,400,100,35);
        resetButton.setBounds(220,400,100,35);
    }
    public void addComponentsToFrame()
    {
        frame.add(nameLabel);
        frame.add(genderLabel);
        frame.add(fatherNameLabel);
        frame.add(passwordLabel);
        frame.add(confirmPasswordLabel);
        frame.add(cityLabel);
        frame.add(emailLabel);

        frame.add(nameTextField);
        frame.add(genderComboBox);
        frame.add(fatherTextField);
        frame.add(passwordField);
        frame.add(confirmPasswordField);
        frame.add(cityTextField);
        frame.add(emailTextField);
        frame.add(registerButton);
        frame.add(resetButton);

        back.add(nameLabel);
        back.add(genderLabel);
        back.add(fatherNameLabel);
        back.add(passwordLabel);
        back.add(confirmPasswordLabel);
        back.add(cityLabel);
        back.add(emailLabel);

        back.add(nameTextField);
        back.add(genderComboBox);
        back.add(fatherTextField);
        back.add(passwordField);
        back.add(confirmPasswordField);
        back.add(cityTextField);
        back.add(emailTextField);
        back.add(registerButton);
        back.add(resetButton);






    }
    public void actionEvent()
    {
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setBounds(100, 100, 450, 300);
            JPanel contentPane = new JPanel();
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            contentPane.setLayout(new BorderLayout(0, 0));
            frame.setContentPane(contentPane);

            String data[][] = null;
            String column[] = null;
            //try {
            //         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdatabase", "root", "prachi@123");

            //         PreparedStatement ps = con.prepareStatement("select * from admin4", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //         //PreparedStatement ps1= con.prepareStatement("insert into admin4 values('" + name + "','" + gender "','" + fatherName + "'));

            //         ResultSet rs = ps.executeQuery();



            //         ResultSetMetaData rsmd = rs.getMetaData();
            //         int cols = rsmd.getColumnCount();
            //         column = new String[cols];
            //         for (int i = 1; i <= cols; i++) {
            //             column[i - 1] = rsmd.getColumnName(i);
            //         }

            //         rs.last();
            //         int rows = rs.getRow();
            //         rs.beforeFirst();

            //         data = new String[rows][cols];
            //         int count = 0;
            //         while (rs.next()) {
            //             for (int i = 1; i <= cols; i++) {
            //                 data[count][i - 1] = rs.getString(i);
            //             }
            //             count++;
            //         }
            //         con.close();
            //     } catch (Exception e1) {
            //         System.out.println(e1);
            //     }

            //     JTable table = new JTable(data, column);
            //     JScrollPane sp = new JScrollPane(table);

            //     contentPane.add(sp, BorderLayout.CENTER);
            // }


            try {
                //Creating Connection Object
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/newdatabase","root","prachi@123");
                //Preapared Statement
                System.out.println("hello");
                String q="insert into Register(name,gender,fatherName,password,confirmPassword,city,email)values(?,?,?,?,?,?,?)";


                PreparedStatement Pstatement=con.prepareStatement(q);
                // PreparedStatement Pstatement=Connection.prepareStatement("insert into admin3 values('" + name +"','" + gender + "', '" + fatherName + "');
                //Specifying the values of it's parameter
                Pstatement.setString(1,nameTextField.getText());
                Pstatement.setString(2,genderComboBox.getSelectedItem().toString());
                Pstatement.setString(3,fatherTextField.getText());
                Pstatement.setString(4,passwordField.getText());
                Pstatement.setString(5,confirmPasswordField.getText());
                Pstatement.setString(6,cityTextField.getText());
                Pstatement.setString(7,emailTextField.getText());
//                PreparedStatement Pstatement=connection.prepareStatement("insert into admin values()");
                //Checking for the Password match
                if(passwordField.getText().equalsIgnoreCase(confirmPasswordField.getText()))
                {
                    //Executing query
                    Pstatement.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Data Registered Successfully");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"password did not match");
                }

            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            catch(ClassNotFoundException e2) {
                e2.printStackTrace();
            }

        }
        if(e.getSource()==resetButton)
        {
            //Clearing Fields
            nameTextField.setText("");
            genderComboBox.setSelectedItem("Male");
            fatherTextField.setText("");
            passwordField.setText("");
            confirmPasswordField.setText("");
            cityTextField.setText("");
            emailTextField.setText("");
        }

    }
}