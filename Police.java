import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Police extends Frame implements ActionListener{
    JFrame frame;

    ImageIcon img = new ImageIcon("police1.png");
    JLabel back = new JLabel("",img,JLabel.CENTER);
    String[] gender = {"Male", "Female"};
    String[] policeStation = {"Sangli", "Kolhapur", "Satara", "Pune", "Mumbai"};
    JLabel policeIdLabel = new JLabel("ID");
    JLabel caseIdLabel = new JLabel("CASE ID");
    JLabel policeStationLabel = new JLabel("POLICE STATION");
    JLabel adhaarNumberLabel = new JLabel("ADHAAR NUMBER");
    JLabel nameLabel = new JLabel(" NAME");
    JLabel fatherNameLabel = new JLabel(" FATHER NAME");
    JLabel lastNameLabel = new JLabel("LAST NAME");
    JLabel genderLabel = new JLabel("GENDER");
    JLabel contactLabel = new JLabel("CONTACT NO");
    JLabel addressLabel = new JLabel("ADDRESS");


    JTextField policeIdTextField = new JTextField();
    JTextField caseIdTextField = new JTextField();
    JComboBox policeStationComboBox = new JComboBox(policeStation);
    JTextField nameTextField = new JTextField();
    JTextField fatherNameTextField = new JTextField();
    JTextField lastNameTextField = new JTextField();
    JTextField adhaarNumberTextField = new JTextField();
    JComboBox genderComboBox = new JComboBox(gender);
    JTextField contactTextField = new JTextField();
    JTextField addressTextField = new JTextField();
    JButton addButton = new JButton("ADD");
    JButton deleteButton = new JButton("DELETE");
    JButton backButton = new JButton("BACK");


    Police() {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }

    public void createWindow() {
        frame = new JFrame();
        frame.setTitle("Police Information");
        frame.setBounds(0, 0, 1400, 800);
        back.setBounds(0,0,1400,800);
        //frame.getContentPane().setBackground(Color.pink);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(1400, 800);
    }

    public void setLocationAndSize() {
        policeIdLabel.setBounds(400, 40, 150, 70);
        policeIdLabel.setForeground(Color.yellow);
        policeIdLabel.setFont(new Font("sans-serif", Font.PLAIN, 20));

        nameLabel.setBounds(400, 100, 200, 70);
        nameLabel.setForeground(Color.yellow);
        nameLabel.setFont(new Font("sans-serif", Font.PLAIN, 20));

        fatherNameLabel.setBounds(400, 150, 190, 70);
        fatherNameLabel.setForeground(Color.yellow);
        fatherNameLabel.setFont(new Font("sans-serif", Font.PLAIN, 20));

        lastNameLabel.setBounds(400, 200, 190, 70);
        lastNameLabel.setForeground(Color.yellow);
        lastNameLabel.setFont(new Font("sans-serif", Font.PLAIN, 20));

        genderLabel.setBounds(400, 250, 150, 70);
        genderLabel.setForeground(Color.yellow);
        genderLabel.setFont(new Font("sans-serif", Font.PLAIN, 20));

        adhaarNumberLabel.setBounds(400, 300, 190, 70);
        adhaarNumberLabel.setForeground(Color.yellow);
        adhaarNumberLabel.setFont(new Font("sans-serif", Font.PLAIN, 20));

        caseIdLabel.setBounds(400, 350, 190, 70);
        caseIdLabel.setForeground(Color.yellow);
        caseIdLabel.setFont(new Font("sans-serif", Font.PLAIN, 20));

        policeStationLabel.setBounds(400, 400, 150, 70);
        policeStationLabel.setForeground(Color.yellow);
        policeStationLabel.setFont(new Font("sans-serif", Font.PLAIN, 20));

        addressLabel.setBounds(400, 450, 210, 70);
        addressLabel.setForeground(Color.yellow);
        addressLabel.setFont(new Font("sans-serif", Font.PLAIN, 20));

        contactLabel.setBounds(400, 500, 200, 70);
        contactLabel.setForeground(Color.yellow);
        contactLabel.setFont(new Font("sans-serif", Font.PLAIN, 20));


        policeIdTextField.setBounds(700, 60, 165, 23);
        nameTextField.setBounds(700, 120, 165, 23);
        fatherNameTextField.setBounds(700, 170, 165, 23);
        lastNameTextField.setBounds(700, 220, 165, 23);
        genderComboBox.setBounds(700, 275, 165, 23);
        adhaarNumberTextField.setBounds(700, 320, 165, 23);
        caseIdTextField.setBounds(700, 370, 165, 23);
        policeStationComboBox.setBounds(700, 420, 165, 23);
        addressTextField.setBounds(700, 470, 165, 23);
        contactTextField.setBounds(700, 520, 165, 23);
        addButton.setBounds(400, 600, 100, 35);
        deleteButton.setBounds(600, 600, 100, 35);
        backButton.setBounds(800, 600, 100, 35);
    }

    public void addComponentsToFrame() {
        frame.add(back);
        back.add(policeIdLabel);
        back.add(nameLabel);
        back.add(fatherNameLabel);
        back.add(lastNameLabel);
        back.add(genderLabel);
        back.add(adhaarNumberLabel);
        back.add(caseIdLabel);
        back.add(policeStationLabel);
        back.add(addressLabel);
        back.add(contactLabel);


        back.add(policeIdTextField);
        back.add(nameTextField);
        back.add(fatherNameTextField);
        back.add(lastNameTextField);
        back.add(genderComboBox);
        back.add(adhaarNumberTextField);
        back.add(caseIdTextField);
        back.add(policeStationComboBox);
        back.add(contactTextField);
        back.add(addressTextField);

        back.add(addButton);
        back.add(deleteButton);
        back.add(backButton);
    }
    public void actionEvent() {
        addButton.addActionListener(this);
        deleteButton.addActionListener(this);
        backButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
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


            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/javaproject", "root", "");

                System.out.println("hello");
                String q = "insert into police(policeId,name,fatherName,lastName,gender,adhaarNumber,caseId,policeStation,contact,address)values(?,?,?,?,?,?,?,?,?,?)";


                PreparedStatement Pstatement = con.prepareStatement(q);

                Pstatement.setString(1, policeIdTextField.getText());
                Pstatement.setString(2, nameTextField.getText());
                Pstatement.setString(3, fatherNameTextField.getText());
                Pstatement.setString(4, lastNameTextField.getText());
                Pstatement.setString(5, genderComboBox.getSelectedItem().toString());
                Pstatement.setString(6, adhaarNumberTextField.getText());
                Pstatement.setString(7, caseIdTextField.getText());
                Pstatement.setString(8, policeStationComboBox.getSelectedItem().toString());
                Pstatement.setString(9, addressTextField.getText());
                Pstatement.setString(10, contactTextField.getText());
                Pstatement.executeUpdate();
                JOptionPane.showMessageDialog(this,"Record add successfully");
//                PreparedStatement Pstatement=connection.prepareStatement("insert into admin values()");
                //Checking for the Password match

        if(e.getSource()==deleteButton)
        {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                // establish connection
                Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "prachi@123");
                Statement statement = con.createStatement();
                statement.executeUpdate("DELETE FROM student WHERE policeId=" + policeIdTextField.getText() + "");
                JOptionPane.showMessageDialog(null, "Record deleted...");
                statement.close();
                con.close();
                //Referesh(); //Calling Referesh() method
            } catch (SQLException | ClassNotFoundException e1) {
                JOptionPane.showMessageDialog(null, e1);
            }
        }
//
//                // }
           }
        catch (SQLException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            }

            if (e.getSource() == backButton) {
                System.out.println("hii");
                Example e3 =new Example();

            }

        }
    }






    public static void main(String[] args) {

            new Police();
        }
    }


