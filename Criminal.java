import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.State;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.awt.Graphics;
import java.awt.Image;

public class Criminal extends Frame implements ActionListener {
    JFrame frame;

    ImageIcon img = new ImageIcon("criminal88.png");
    JLabel back = new JLabel("", img, JLabel.CENTER);
    String[] gender = {"Male", "Female"};
    String[] crime = {"Murder", "Robbery", "Fight", "Rape", "Drugs"};
    String[] jail = {"Central Jail", "District Jail", "Sub Jail", "Women Jail", "Open Jails", "Special Jails"};
    JLabel criminalIdLabel = new JLabel("CRIMINAL ID:");
    JLabel nameLabel = new JLabel("CRIMINAL NAME:");
    JLabel fatherNameLabel = new JLabel("FATHER NAME:");
    JLabel lastNameLabel = new JLabel("LAST NAME:");
    JLabel genderLabel = new JLabel("GENDER:");
    JLabel crimeLabel = new JLabel("CRIME:");
    JLabel jailLabel = new JLabel("JAIL:");
    JLabel adhaarNumberLabel = new JLabel("ADHAAR NUMBER:");
    // JLabel contactLabel=new JLabel("CONTACT NUMBER:");
    // JLabel addressLabel=new JLabel("ADDRESS:");
    JLabel entryDateLabel = new JLabel("ENTRY DATE:");
    JLabel imprisonmentLabel = new JLabel("IMPRISONMENT:");
    JLabel bailDateLabel = new JLabel("BAIL DATE:");


    JTextField criminalIdTextField = new JTextField();
    JTextField nameTextField = new JTextField();
    JTextField fatherNameTextField = new JTextField();
    JTextField lastNameTextField = new JTextField();
    JComboBox genderComboBox = new JComboBox(gender);
    JComboBox crimeComboBox = new JComboBox(crime);
    JComboBox jailComboBox = new JComboBox(jail);
    JTextField adhaarNumberTextField = new JTextField();
    //  JTextField contactTextField=new JTextField();
    // JTextField addressTextField=new JTextField();
    JTextField entryDateTextField = new JTextField();
    JTextField imprisonmentTextField = new JTextField();
    JTextField bailDateTextField = new JTextField();
    JButton addButton = new JButton("ADD");
    JButton deleteButton = new JButton("DELETE");
    JButton backButton = new JButton("BACK");



    Criminal() {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }

    public void createWindow() {
        frame = new JFrame();
        frame.setTitle("Criminal Information");
        frame.setBounds(0, 0, 1400, 800);
        back.setBounds(0, 0, 1400, 800);
        // frame.getContentPane().setBackground(Color.orange);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(1400, 800);
        //Image img = Toolkit.getDefaultToolkit().getImage("\"C:\\Users\\JUNAD\\OneDrive\\Desktop\\bg.jpg\"");
    }

    public void setLocationAndSize() {
        criminalIdLabel.setBounds(400, 40, 150, 70);
        criminalIdLabel.setForeground(Color.yellow);
        criminalIdLabel.setFont(new Font("sans-serif", Font.BOLD, 20));
        nameLabel.setBounds(400, 100, 200, 70);
        nameLabel.setForeground(Color.yellow);
        nameLabel.setFont(new Font("sans-serif", Font.BOLD, 20));
        fatherNameLabel.setBounds(400, 150, 190, 70);
        fatherNameLabel.setForeground(Color.yellow);
        fatherNameLabel.setFont(new Font("sans-serif", Font.BOLD, 20));
        lastNameLabel.setBounds(400, 200, 190, 70);
        lastNameLabel.setForeground(Color.yellow);
        lastNameLabel.setFont(new Font("sans-serif", Font.BOLD, 20));
        genderLabel.setBounds(400, 250, 150, 70);
        genderLabel.setForeground(Color.yellow);
        genderLabel.setFont(new Font("sans-serif", Font.BOLD, 20));
        crimeLabel.setBounds(400, 300, 150, 70);
        crimeLabel.setForeground(Color.yellow);
        crimeLabel.setFont(new Font("sans-serif", Font.BOLD, 20));
        adhaarNumberLabel.setBounds(400, 350, 190, 70);
        adhaarNumberLabel.setForeground(Color.yellow);
        adhaarNumberLabel.setFont(new Font("sans-serif", Font.BOLD, 20));
        entryDateLabel.setBounds(400, 400, 150, 70);
        entryDateLabel.setForeground(Color.yellow);
        entryDateLabel.setFont(new Font("sans-serif", Font.BOLD, 20));
        imprisonmentLabel.setBounds(400, 450, 210, 70);
        imprisonmentLabel.setForeground(Color.yellow);
        imprisonmentLabel.setFont(new Font("sans-serif", Font.BOLD, 20));
        bailDateLabel.setBounds(400, 500, 150, 70);
        bailDateLabel.setForeground(Color.yellow);
        bailDateLabel.setFont(new Font("sans-serif", Font.BOLD, 20));
        jailLabel.setBounds(400, 550, 150, 70);
        jailLabel.setForeground(Color.yellow);
        jailLabel.setFont(new Font("sans-serif", Font.BOLD, 20));


        criminalIdTextField.setBounds(700, 60, 165, 23);
        nameTextField.setBounds(700, 120, 165, 23);
        fatherNameTextField.setBounds(700, 170, 165, 23);
        lastNameTextField.setBounds(700, 220, 165, 23);

        genderComboBox.setBounds(700, 275, 165, 23);
        crimeComboBox.setBounds(700, 320, 165, 23);
        adhaarNumberTextField.setBounds(700, 370, 165, 23);
        imprisonmentTextField.setBounds(700, 470, 165, 23);
        entryDateTextField.setBounds(700, 420, 165, 23);
        bailDateTextField.setBounds(700, 520, 165, 23);
        jailComboBox.setBounds(700, 570, 165, 23);
        addButton.setBounds(350, 650, 200, 35);
        addButton.setForeground(Color.blue);
        addButton.setFont(new Font("sans-serif", Font.BOLD, 20));
        deleteButton.setBounds(700, 650, 200, 35);
        deleteButton.setForeground(Color.blue);
        deleteButton.setFont(new Font("sans-serif", Font.BOLD, 20));
        backButton.setBounds(1000, 650, 200, 35);
        backButton.setForeground(Color.blue);
        backButton.setFont(new Font("sans-serif", Font.BOLD, 20));
    }

    public void addComponentsToFrame() {
        frame.add(back);
        back.add(criminalIdLabel);
        back.add(nameLabel);
        back.add(fatherNameLabel);
        back.add(lastNameLabel);
        back.add(genderLabel);
        back.add(crimeLabel);
        back.add(adhaarNumberLabel);
        back.add(entryDateLabel);
        back.add(imprisonmentLabel);
        back.add(bailDateLabel);
        back.add(jailLabel);

        back.add(criminalIdTextField);
        back.add(nameTextField);
        back.add(fatherNameTextField);
        back.add(lastNameTextField);
        back.add(genderComboBox);
        back.add(crimeComboBox);
        back.add(adhaarNumberTextField);
        back.add(entryDateTextField);
        back.add(imprisonmentTextField);
        back.add(bailDateTextField);
        back.add(jailComboBox);
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
            String criminalId= criminalIdTextField.getText();
            String name=nameTextField.getText();
            String fatherName=fatherNameTextField.getText();

            String lastName = lastNameTextField.getText();
            String gender = genderComboBox.getSelectedItem().toString();
            String crime = crimeComboBox.getSelectedItem().toString();
            String adhaarNumber = adhaarNumberTextField.getText();
            String entryDate = entryDateTextField.getText();
            String imprisonment = imprisonmentTextField.getText();
            String bailDate = bailDateTextField.getText();
            String jail = jailComboBox.getSelectedItem().toString();
            System.out.println(criminalId + name);


            try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "prachi@123");

                System.out.println("hello");
                String q = "insert into criminal(criminalId,name,fatherName,lastName,gender,crime,adhaarNumber,entryDate,imprisonment,bailDate,jail)values(('" + criminalId + "','" + name + "','" + fatherName + "','" + lastName + "','" +gender + "','" + crime + "','" + adhaarNumber + "','" + entryDate +"','" + imprisonment + "','" + bailDate + "','" + jail +"')";


                PreparedStatement Pstatement = con.prepareStatement(q);
                Statement st = con.createStatement();
                int x = st.executeUpdate(q);

//                Pstatement.setString(1, criminalIdTextField.getText());
//                Pstatement.setString(2, nameTextField.getText());
//                Pstatement.setString(3, fatherNameTextField.getText());
//                Pstatement.setString(4, lastNameTextField.getText());
//                Pstatement.setString(5, genderComboBox.getSelectedItem().toString());
//                Pstatement.setString(6, crimeComboBox.getSelectedItem().toString());
//                Pstatement.setString(7, adhaarNumberTextField.getText());
//                Pstatement.setString(8, entryDateTextField.getText());
//                Pstatement.setString(9, imprisonmentTextField.getText());
//                Pstatement.setString(10, bailDateTextField.getText());
//                Pstatement.setString(11, jailComboBox.getSelectedItem().toString());


//                PreparedStatement Pstatement=connection.prepareStatement("insert into admin values()");
                //Checking for the Password match

//        if(e.getSource()==resetButton)
//        {
//            //Clearing Fields
//            nameTextField.setText("");
//            genderComboBox.setSelectedItem("Male");
//            fatherTextField.setText("");
//            passwordField.setText("");
//            confirmPasswordField.setText("");
//            cityTextField.setText("");
//            emailTextField.setText("");
                // }

                // }
            } catch (Exception e1) {
                e1.printStackTrace();
            } /*catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            }*/

            if (e.getSource() == backButton) {
                System.out.println("hii");
                Example e3 =new Example();
            }

        }
    }


        public static void main (String[]args){
            //creating object of RegistrationForm class
            new Criminal();
        }
    }
