
import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Example extends JFrame implements ActionListener
{
    JFrame frame;
    ImageIcon img = new ImageIcon("example1.png");
    JLabel back = new JLabel("", img, JLabel.CENTER);

    JButton addpoliceButton=new JButton("ADD POLICE");

    JButton addcriminalButton=new JButton("ADD CRIMINALS");
    JButton removecriminalButton=new JButton("REMOVE CRIMINAL");
    JButton removepoliceButton=new JButton("REMOVE POLICE");
   // JButton addcrimeButton=new JButton("ADD CRIME");
    JButton logoutButton=new JButton("LOG OUT");


    Example()
    {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }
    public void createWindow()
    {
        frame=new JFrame();
        frame.setTitle("BUTTONS");
        frame.setBounds(0,0,1400,800);
        back.setBounds(0, 0, 1400, 800);
        frame.getContentPane().setBackground(Color.white);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(900,600);
        //Image img = Toolkit.getDefaultToolkit().getImage("\"C:\\Users\\JUNAD\\OneDrive\\Desktop\\bg.jpg\"");
    }
    public void setLocationAndSize()
    {

        addpoliceButton.setBounds(50,200,200,100);
        addpoliceButton.setForeground(Color.blue);
        addpoliceButton.setFont(new Font("sans-serif", Font.BOLD, 20));
        addcriminalButton.setBounds(50,330,200,100);
        addcriminalButton.setForeground(Color.blue);
        addcriminalButton.setFont(new Font("sans-serif", Font.BOLD, 20));
        removepoliceButton.setBounds(330,200,200,100);
        removepoliceButton.setForeground(Color.blue);
        removepoliceButton.setFont(new Font("sans-serif", Font.BOLD, 20));
        removecriminalButton.setBounds(330,330,200,100);
        removecriminalButton.setForeground(Color.blue);
        removecriminalButton.setFont(new Font("sans-serif", Font.BOLD, 20));
        logoutButton.setBounds(200,500,200,100);
        logoutButton.setForeground(Color.blue);
        logoutButton.setFont(new Font("sans-serif", Font.BOLD, 20));

        //addcrimeButton.setBounds(430,330, 200,100);
        //addcriminaldetailsButton.setBounds(430,200,200,100);

        addpoliceButton.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        addcriminalButton.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        removepoliceButton.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        removecriminalButton.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        //addcrimeButton.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        logoutButton.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        addpoliceButton.setBackground(Color.yellow);
        addcriminalButton.setBackground(Color.yellow);
        removecriminalButton.setBackground(Color.yellow);
        removepoliceButton.setBackground(Color.yellow);
        //addcrimeButton.setBackground(Color.pink);
        logoutButton.setBackground(Color.CYAN);
    }
    public void addComponentsToFrame()
    {
        frame.add(back);
        back.add(addpoliceButton);
        back.add(addcriminalButton);
        back.add(removecriminalButton);
        back.add(removepoliceButton);
        back.add(logoutButton);
        //frame.add(addcrimeButton);
       // frame.add(addcriminaldetailsButton);
    }

public void actionPerformed(ActionEvent e)

{
    String button=e.getActionCommand();
    if(button.equals("ADD CRIMINALS"))
    {
        Criminal c1=new Criminal();
    }
    else if(button.equals("ADD POLICE"))
    {
        Police p1=new Police();
    }
    else if(button.equals("REMOVE POLICE"))
    {
          removepolice p2=new removepolice();
    }
    else if(button.equals("REMOVE CRIMINAL"))
    {
        removecriminal p2=new removecriminal();
    }

    //showData();

}
    public void actionEvent()
    {
        addcriminalButton.addActionListener(this::actionPerformed);
//        deleteButton.addActionListener(this);
        addpoliceButton.addActionListener(this::actionPerformed);
        removepoliceButton.addActionListener(this::actionPerformed);
        removecriminalButton.addActionListener(this::actionPerformed);
        logoutButton.addActionListener(this::actionPerformed);
    }




    public static void main(String[] args) {
        //creating object of RegistrationForm class
        new Example();
    }
}

