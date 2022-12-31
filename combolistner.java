import javax.swing.*;
import java.awt.event.*;
public class combolistner extends JFrame {
    JFrame frame;



    public void window()
    {
        String[] gender = {"Male", "Female"};
        String[] crime = {"Murder", "Robbery", "Fight", "Rape", "Drugs"};
        JComboBox crimeComboBox = new JComboBox(crime);
        JComboBox genderComboBox = new JComboBox(gender);
        crimeComboBox.setBounds(0, 0, 165, 23);



        ItemListener listen=new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
               if(e.getSource()==crimeComboBox)
                   if(e.getStateChange()==ItemEvent.SELECTED){
                       System.out.println(e.getSource());
                       System.out.println(e.paramString());
                   }
            }
        };
        crimeComboBox.addItemListener(listen);


        frame = new JFrame("display");
        frame.setBounds(0,0,300,400);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.add(crimeComboBox);

    }
    public combolistner()
    {
        window();
    }

    public static void main(String[] args) {
       new combolistner();
    }
}
