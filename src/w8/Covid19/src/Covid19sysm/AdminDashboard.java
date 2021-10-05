package Covid19sysm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AdminDashboard extends JFrame implements MouseListener, ActionListener{
	   
	 JButton addPatientDetailsbtn;
	 JButton addContactTracingbtn;
	 JButton viewContactTracingbtn;
	 JButton logoutbtn;
	 
	 Connection conn;
	 
	 JTable tbl;
	 DefaultTableModel model;

     AdminDashboard() {
	   setTitle("Admin");
       setLayout(null);
       
       addPatientDetailsbtn=new JButton("Add Patient Details");
       addContactTracingbtn=new JButton("Add Contact Tracing");
       viewContactTracingbtn=new JButton("View Contact Tracing");
//       assignWardbtn=new JButton("Assign Ward");
       logoutbtn=new JButton("Logout");
       
       addPatientDetailsbtn.addActionListener(this);
       addContactTracingbtn.addActionListener(this);
       viewContactTracingbtn.addActionListener(this);
//       assignWardbtn.addActionListener(this);
       logoutbtn.addActionListener(this);

       addPatientDetailsbtn.setBounds(30, 50, 170, 50);
       addContactTracingbtn.setBounds(30, 120,  170, 50);
//       assignWardbtn.setBounds(175, 50,  130, 50);
       viewContactTracingbtn.setBounds(30, 190,  170, 50);
       logoutbtn.setBounds(60, 260,  100, 50);
       
//       String [] cols= {"Patient_Id","Name","Address","Covid Date","Created Date","Contacted Date"};
//       model=new DefaultTableModel(cols,0);
//       tbl=new JTable(model);
       
//       JScrollPane sp=new JScrollPane(tbl);
//       sp.setBounds(30, 150, 600, 370);
       

       add(addPatientDetailsbtn);
       add(addContactTracingbtn);
       add(viewContactTracingbtn);
//       add(assignWardbtn);
       add(logoutbtn);
//       add(sp);

       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(250,400);
       setVisible(true); 
       
       
//       try {
//           conn =
//              DriverManager.getConnection("jdbc:mysql://localhost/java_hospital?" +
//                                          "user=root&password=#Sishir123");
//       
//       } catch (SQLException ex) {
//           // handle any errors
//           System.out.println("SQLException: " + ex.getMessage());
//           System.out.println("SQLState: " + ex.getSQLState());
//           System.out.println("VendorError: " + ex.getErrorCode());
//       }
//       remove_table();
//       displayTable();
       
   	}
   
//   public void displayTable() {
//       
//       try {
//           String sql="select * from patientDetails";
//           PreparedStatement stmt=conn.prepareStatement(sql);
//           ResultSet result=stmt.executeQuery();
//           
//           while(result.next()) {
//               
//               String id=result.getString("id");
//               String name=result.getString("name");
//               String address=result.getString("address");
//               String dob=result.getString("dob");
//               String gender = result.getString("gender");
//               String description = result.getString("description");
//               String date = result.getString("date");
//               String medical_history = result.getString("medical_history");
//               model.addRow(new Object[] {id,name,address,dob,gender,description,date,medical_history});
//           }
//           
//           
//           
//       }
//       catch(Exception ee) {
//           ee.printStackTrace();
//       }
//   }
//   public void remove_table() {
//       for(int i=model.getRowCount();i>=0;i--) {
//           
//           model.removeRow(i);
//       }
//      
//  }
            
   
   public static void main(String[] args) {
	   AdminDashboard f = new AdminDashboard();
   }

   @Override
   public void actionPerformed(ActionEvent e) {
       Object source=e.getSource();
       
       if(source==addPatientDetailsbtn) {
    	   AddPatientDetails f = new AddPatientDetails();
           dispose();
       }else if (source == logoutbtn) {
    	   Login f = new Login();
           dispose();
       }else if (source == addContactTracingbtn) {
    	   AddContactTracing f = new AddContactTracing();
           dispose();
       } else if (source == viewContactTracingbtn) {
    	   ViewContactTracing f = new ViewContactTracing();
           dispose();
       }



   }

@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
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
