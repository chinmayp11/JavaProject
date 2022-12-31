import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import java.util.Vector;

public class Jtable extends JFrame
{

    JFrame frame;

    String[] gender = {"Male", "Female"};
    String[] crime = {"Murder", "Robbery", "Fight", "Rape", "Drugs"};
    JLabel genderLabel = new JLabel("GENDER:");
    JLabel crimeLabel = new JLabel("CRIME:");
    JLabel searchlabel=new JLabel("SEARCH HERE:");
    JTextField searchbar=new JTextField();
    JComboBox genderComboBox = new JComboBox(gender);
    JComboBox crimeComboBox = new JComboBox(crime);
    JPanel panel=new JPanel();
    String col[]={"criminal ID","criminal name","fathername","lastname","gender","crime","Adharno","entrydate","imprisonment","baildate","jail"};
    Object row[] []={};
    DefaultTableModel model=new DefaultTableModel(row,col);
    JTable tabel=new JTable(model);
    JScrollPane pane=new JScrollPane(tabel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


    public void table_fetch(){
        int c;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/javaproject", "root", "");

            String q = "select * from criminal";

            PreparedStatement Pstatement = con.prepareStatement(q);

            ResultSet res = Pstatement.executeQuery();
            ResultSetMetaData Rss = res.getMetaData();
            c = Rss.getColumnCount();
            DefaultTableModel df = (DefaultTableModel) tabel.getModel();
            df.setRowCount(0);

           while (res.next()){
               Vector v2 = new Vector();
               for (int i=1; i<=c; i++){
                   v2.add(res.getString("criminalId"));
                   v2.add(res.getString("name"));
                   v2.add(res.getString("fatherName"));
                   v2.add(res.getString("lastName"));
                   v2.add(res.getString("gender"));
                   v2.add(res.getString("crime"));
                   v2.add(res.getString("adhaarNumber"));
                   v2.add(res.getString("entryDate"));
                   v2.add(res.getString("imprisonment"));
                   v2.add(res.getString("bailDate"));
                   v2.add(res.getString("jail"));
               }
               df.addRow(v2);
           }


        }
        catch (SQLException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        }
    }



    private void filter(String query){
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        tabel.setRowSorter(tr);
        if (query != null){
            tr.setRowFilter(RowFilter.regexFilter(query));
        }else{
            tabel.setRowSorter(tr);
        }
    }
    public Jtable()
    {
        createframe();
        design();
        addrow();
        table_fetch();
        //genderComboBox();
        //crimeComboBox();
        combolistener1();
        combolistener2();
        Searchlabel();
    }
    public void addrow()
    {
        for(int i=0;i<10;i++)
        {
            model.addRow(new Object[]{"","","","","","","","","","",""});
        }
    }

    public void createframe() {
        frame = new JFrame("display");
        frame.setBounds(0,0,1400,800);
        frame.setVisible(true);


        frame.add(genderLabel);
        frame.add(crimeLabel);
        frame.add(genderComboBox);
        frame.add(crimeComboBox);
        frame.add(searchbar);
        frame.add(searchlabel);
        frame.add(panel);
    }
    public void design()
    {
        //label and textfield design
        genderLabel.setBounds(80, 50, 150, 70);
        genderLabel.setForeground(Color.black);
        genderLabel.setFont(new Font("sans-serif", Font.BOLD, 20));
        crimeLabel.setBounds(400, 50, 150, 70);
        crimeLabel.setForeground(Color.black);
        crimeLabel.setFont(new Font("sans-serif", Font.BOLD, 20));

        genderComboBox.setBounds(200, 70, 165, 23);
       // genderComboBox.addActionListener(event);
        crimeComboBox.setBounds(530, 70, 165, 23);

        searchlabel.setBounds(700, 70, 165, 23);
        searchlabel.setFont(new Font("sans-serif", Font.BOLD, 20));
        searchlabel.setForeground(Color.black);
        searchbar.setBounds(900, 70, 165, 23);

      //tabel design
        panel.setLayout(null);
        panel.add(pane).setBounds(0,150,1400,400);
        tabel.setRowHeight(tabel.getRowHeight()+20);
        tabel.getTableHeader().setReorderingAllowed(false);
    }
    public void combolistener1()
    {
        ItemListener listen=new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getSource()==genderComboBox)
                    if(e.getStateChange()==ItemEvent.SELECTED){
                        String query = genderComboBox.getSelectedItem().toString();
                        filter(query);
                    }
            }
        };
       genderComboBox.addItemListener(listen);
    }

    public void combolistener2()
    {
        ItemListener listen=new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getSource()==crimeComboBox)
                    if(e.getStateChange()==ItemEvent.SELECTED){
                        String query = crimeComboBox.getSelectedItem().toString();
                        filter(query);
                    }
            }
        };
        crimeComboBox.addItemListener(listen);
    }

   public void Searchlabel(){
        searchbar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = searchbar.getText().toLowerCase();
                filter(query);
            }
        });
   }

    public static void main(String[] args) {
        new Jtable();
    }

}

