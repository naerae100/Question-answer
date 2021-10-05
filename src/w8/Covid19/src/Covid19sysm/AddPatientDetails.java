package Covid19sysm;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AddPatientDetails extends JFrame implements MouseListener, ActionListener {
    JLabel titlelbl;
    JLabel idlbl;
    JLabel namelbl;
    JLabel addresslbl;
    JLabel phonelbl;
    JLabel covidDatelbl;
    JLabel datelbl;
    JLabel contactedDatelbl;
    
    
    JTextField txtid;
    JTextField txtname;
    JTextField txtaddress;
    JTextField txtphone;
    JTextField txtcovidDate;
    JFormattedTextField txtdate;
    JTextField txtcontactedDate;
    
    
    
    JButton backbtn;
    JButton updatebtn;
    JButton clearbtn;
    JButton addbtn;
    
    // For Table
    JTable tbl;
    DefaultTableModel model;
    
    JTable tbl1;
    DefaultTableModel model1;
    
    // For Ending Table
    
    
    AddPatientDetails() {
    	
    	
        setTitle("Add Patient");
        setLayout(null);

        titlelbl=new JLabel("Add Patient");
        idlbl = new JLabel("Patient Id:");
        namelbl=new JLabel("Name:");
        addresslbl=new JLabel("Address:");
        phonelbl=new JLabel("Phone:");
        covidDatelbl=new JLabel("Covid Date:");
        contactedDatelbl=new JLabel("Contacted Date:");
        
        txtid = new JTextField(10);
        txtname=new JTextField(10);
        txtaddress=new JTextField(10);
        txtphone=new JTextField(10);
        txtcovidDate=new JTextField(10);
//        String gender[]={"Male","Female","Others"}; 
//        txtgender=new JComboBox(gender);
        txtcontactedDate=new JTextField(10);
        
        DateFormat dateFormat = new SimpleDateFormat("dd MMM YYYY");
        txtdate = new JFormattedTextField(dateFormat);
        datelbl = new JLabel("Date:");
        datelbl.setLabelFor(txtdate);
        txtdate.setValue(new Date());
        
        backbtn=new JButton("Back");
        updatebtn=new JButton("Update");
        clearbtn=new JButton("Clear");
        addbtn = new JButton("Add");
        
        backbtn.addActionListener(this);
        updatebtn.addActionListener(this);
        clearbtn.addActionListener(this);
        addbtn.addActionListener(this);
        
	     titlelbl.setBounds(110, 15, 200, 30);
	     titlelbl.setFont(new Font("Serif", Font.BOLD, 25));
	    
	     idlbl.setBounds(50, 50, 75, 25);
	     namelbl.setBounds(50, 100, 75, 25);
	     addresslbl.setBounds(50, 150, 75, 25);
	     phonelbl.setBounds(50, 200, 75, 25);
	     covidDatelbl.setBounds(50, 250, 75, 25);
	     datelbl.setBounds(50,300,75,25);
	     contactedDatelbl.setBounds(50, 350, 75, 25);
	     
	     
	     txtid.setBounds(170, 50, 200, 25);
	     txtname.setBounds(170, 100, 200, 25);
	     txtaddress.setBounds(170, 150, 200, 25);
	     txtphone.setBounds(170, 200, 200, 25);
	     txtcovidDate.setBounds(170, 250, 200, 25);
	     txtdate.setBounds(170, 300, 200, 25);
	     txtcontactedDate.setBounds(170, 350, 200, 25);
	     
	     
	     backbtn.setBounds(30, 400, 100, 25);
	     clearbtn.setBounds(130, 400, 100, 25);
	     addbtn.setBounds(230, 400, 100, 25);
	     updatebtn.setBounds(330, 400, 100, 25);
	     
	     // Table
	     String [] cols= {"Patient_Id","Name","Address","Phone","Covid Date","Created Date","Contacted Date"};
	     model=new DefaultTableModel(cols,0);
	     tbl=new JTable(model);
	     
	     JScrollPane sp=new JScrollPane(tbl);
	     sp.setBounds(400, 50, 600, 370);
	     add(sp);
	     tbl.addMouseListener(this);
	     
	  // Table

	     
	     
	     add(titlelbl);
	     add(idlbl);
	     add(txtid);
	     add(namelbl);
	     add(txtname);
	     
	     add(addresslbl);
	     add(txtaddress);
	     add(phonelbl);
	     add(txtphone);
	     add(covidDatelbl);
	     add(txtcovidDate);
	     add(contactedDatelbl);
	     add(txtcontactedDate);
	     
	     add(datelbl);
	     add(txtdate);
	     
	     add(backbtn);
	     add(updatebtn);
	     add(clearbtn);
	     add(addbtn);
	     
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     setSize(1050,500);
	     setVisible(true);
           
	     displayTable();
             
    }

    
    public void displayTable() {
        try {
        	File f = new File("C:\\Users\\naera\\eclipse-workspace\\NemoX\\src\\w8\\fileHandeling_java\\patientDetails.txt");
        	Scanner reader = new Scanner(f);
            
            while(reader.hasNextLine()) {
            	String line = reader.nextLine();
            	String data[] = line.split(",");
                
                String id=data[0];
                String name=data[1];
                String address=data[2];
                String phone=data[3];
                String covidDate = data[4];
                String date = data[5];
                String contactedDate = data[6];
                model.addRow(new Object[] {id,name,address,phone,covidDate,date,contactedDate});
            }
            reader.close();       
        }
        catch(Exception ee) {
            ee.printStackTrace();
        }
        

        
        
    }
    
    public void remove_table() {
        for(int i=model.getRowCount()-1;i>=0;i--) {
            model.removeRow(i);
        }
       
   }
    
    public static void main(String[] args) throws IOException {
    	AddPatientDetails f = new AddPatientDetails();
    }
 
    public void reset() {
    	txtid.setText("");
        txtname.setText("");
        txtaddress.setText("");
        txtphone.setText("");
        txtcovidDate.setText("");
        txtcontactedDate.setText("");
        }
    
    public String get_String(String i) throws IOException { 
    	
    	File f = new File("C:\\Users\\naera\\eclipse-workspace\\NemoX\\src\\w8\\fileHandeling_java\\patientDetails.txt");
    	BufferedReader br = new BufferedReader(new FileReader(f));
    	String j = "";
    	String line;
    	while ((line = br.readLine()) != null) {
            String data[] = line.split(",");
            if (i.equals(data[0])) {
            	j = line;
            }
        }
    	br.close();
    	return j;
    	
    }
    
    public static boolean isIdPresent(String Id) throws IOException{
    	boolean bool = false;
    	ArrayList<String> list = new ArrayList<String>();
    	
    	File f = new File("C:\\Users\\naera\\eclipse-workspace\\NemoX\\src\\w8\\fileHandeling_java\\patientDetails.txt");
    	BufferedReader br = new BufferedReader(new FileReader(f));
    	String line;
    	while ((line = br.readLine()) != null) {
            String data[] = line.split(",");
            list.add(data[0]);
            
        }
    	
    	br.close();
    	
    	for(int i=0; i<list.size();i++) {
//    		System.out.print(list.get(i));
    		if (Id.equals(list.get(i))) {
//    			System.out.println("Id is present "+ list.get(i));
    			bool = true;
    		}
    	}
    	return bool;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source=e.getSource();
        try {
			System.out.println(isIdPresent(txtid.getText()));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        if(source==updatebtn) {
        	String id = txtid.getText();
        	String name = txtname.getText();
            String address = txtaddress.getText();
            String phone = txtphone.getText();
            String covidDate = txtcovidDate.getText();
            String date = txtdate.getText();
            String contactedDate = txtcontactedDate.getText();
            
            try {
				if(isIdPresent(id)) {
					if (id.isEmpty()==false && name.isEmpty() == false && address.isEmpty() == false && phone.isEmpty() == false && 
				    		covidDate.isEmpty() == false && date.isEmpty() == false && contactedDate.isEmpty() == false) {

				    	String userdata = id + "," + name + "," + address + "," + phone + "," + covidDate + "," + date + "," + contactedDate;
				        try {
				        	File f = new File("C:\\Users\\naera\\eclipse-workspace\\NemoX\\src\\w8\\fileHandeling_java\\patientDetails.txt");
				        	File tempFile = new File("C:\\Users\\naera\\eclipse-workspace\\NemoX\\src\\w8\\fileHandeling_java\\myTempFile.txt");
				            BufferedReader br = new BufferedReader(new FileReader(f));
				        	BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
				            String line;
				            ArrayList<String> coll = new ArrayList<String>();
				            
				            Scanner scanner = new Scanner(f);
				            if(scanner.hasNextLine()) {
				            	while (scanner.hasNextLine()) {
				                line = scanner.nextLine();
				                if (line.equals(get_String(id))) {
				                	continue;
				                }
				                coll.add(line);
				            	}
				            } 
				            coll.add(userdata);
				            
				            scanner.close();
				            
				            for (String s : coll) {
				                writer.write(s);
				                writer.write("\n");
				            }

				            writer.close();
				            br.close();
				            f.delete();
				        	boolean successful = tempFile.renameTo(new File("C:\\Users\\naera\\eclipse-workspace\\NemoX\\src\\w8\\fileHandeling_java\\patientDetails.txt"));
				        	
				        	if (successful) {
				        		System.out.println("Success");
				        	}else {
				        		System.out.println("Failed");
				        	}
				            
				            
				        } catch (Exception a) {
				            a.printStackTrace();
				        }

				        JOptionPane.showMessageDialog(null, "Updated Successfully");
				        remove_table();
				        displayTable();
				        reset();
				    } else {
				        JOptionPane.showMessageDialog(null, "Updation Failed");
				    }    
				} else {
					JOptionPane.showMessageDialog(null, "The Patient Id has not been added. Add patient to Update Details");
				}
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            
                                      
        }else if(source==addbtn) {
        	String id = txtid.getText();
        	String name = txtname.getText();
            String address = txtaddress.getText();
            String phone = txtphone.getText();
            String covidDate = txtcovidDate.getText();
            String date = txtdate.getText();
            String contactedDate = txtcontactedDate.getText();
            
            try {
				if(!isIdPresent(id)) {
					if (id.isEmpty()==false && name.isEmpty() == false && address.isEmpty() == false && phone.isEmpty() == false && 
				    		covidDate.isEmpty() == false && date.isEmpty() == false && contactedDate.isEmpty() == false) {

				        String userdata = id + "," + name + "," + address + "," + phone + "," + covidDate + "," + date + "," + contactedDate;
				        try {
				            File f = new File("C:\\Users\\naera\\eclipse-workspace\\NemoX\\src\\w8\\fileHandeling_java\\patientDetails.txt");
				            if (!f.exists()) {
				                f.createNewFile();
				            }
				            FileWriter fw = new FileWriter(f, true);
				            fw.write(userdata);
				            fw.write("\n");
				            fw.flush();
				            fw.close();
				        } catch (Exception a) {
				            a.printStackTrace();
				        }
				        
				        JOptionPane.showMessageDialog(null, "Added Successfully");
				        remove_table();
				        displayTable();
				        reset();
				    } else {
				        JOptionPane.showMessageDialog(null, "Addition Failed");
				    }
				} else {
					JOptionPane.showMessageDialog(null, "The Patient Id has already been added. Add different patient id to Add Details");
				}
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
        else if(source==clearbtn) {
            reset();
        }
        else if(source==backbtn) {
            AdminDashboard f = new AdminDashboard();
            dispose();
        }

    }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row=tbl.rowAtPoint(e.getPoint());
        System.out.println("row_id= "+row);
        
        System.out.println(model.getValueAt(row, 0));
        txtid.setText(model.getValueAt(row, 0).toString());
        txtname.setText(model.getValueAt(row, 1).toString());
        txtaddress.setText(model.getValueAt(row, 2).toString());
        txtphone.setText(model.getValueAt(row, 3).toString());
        txtcovidDate.setText(model.getValueAt(row, 4).toString());
        txtdate.setText(model.getValueAt(row, 5).toString());
        txtcontactedDate.setText(model.getValueAt(row, 6).toString());
        
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}