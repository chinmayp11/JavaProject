import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class removecriminal extends Frame implements ActionListener {
    JFrame frame;

    ImageIcon img = new ImageIcon("police2.png");
    JLabel back = new JLabel("",img,JLabel.CENTER);

    JLabel criminalIdLabel = new JLabel("ENTER THE ID OF THE CRIMINAL WHO GOT THE BAIL :");
    JTextField criminalIdTextField = new JTextField();

    JButton removeButton = new JButton("REMOVE");



    removecriminal() {
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
        criminalIdLabel.setBounds(350, 80, 1300, 200);
        criminalIdLabel.setForeground(Color.yellow);
        criminalIdLabel.setFont(new Font("Serif", Font.BOLD, 25));


        criminalIdTextField.setBounds(600, 280, 165, 50);
        criminalIdTextField.setForeground(Color.black);
        criminalIdTextField.setFont(new Font("Serif", Font.BOLD, 50));


        removeButton.setBounds(630, 400, 100, 35);
        removeButton.setForeground(Color.blue);
        removeButton.setFont(new Font("Serif", Font.BOLD, 20));
        removeButton.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        removeButton.setBackground(Color.yellow);


    }

    public void addComponentsToFrame() {
        frame.add(back);
        back.add(criminalIdLabel);



        back.add(criminalIdTextField);


        back.add(removeButton);

    }
    public void actionEvent() {
        removeButton.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == removeButton) {
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setBounds(100, 100, 450, 300);
            JPanel contentPane = new JPanel();
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            contentPane.setLayout(new BorderLayout(0, 0));
            frame.setContentPane(contentPane);

//            String data[][] = null;
//            String column[] = null;


            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/javaproject", "root", "");

                System.out.println("hello");
                String q = "delete from criminal where criminalID= ?";

                PreparedStatement Pstatement = con.prepareStatement(q);

                Pstatement.setString(1, criminalIdTextField.getText());
                Pstatement.executeUpdate();
                JOptionPane.showMessageDialog(this,"Delete successfully");

            }
            catch (SQLException e1) {
                e1.printStackTrace();
                System.out.println("Data is not deleted");
            } catch (Exception e2) {
                e2.printStackTrace();
            }


        }
    }






    public static void main(String[] args) {

        new removecriminal();
    }
}


