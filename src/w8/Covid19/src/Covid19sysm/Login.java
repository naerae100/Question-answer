package Covid19sysm;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.*;



public class Login extends JFrame implements ActionListener {
    JLabel titlelbl;
    JLabel usernamelbl;
    JLabel passwordlbl;

    JTextField txtname;
    JPasswordField txtpassword;

    JButton loginbtn;
    JButton clearbtn;
    JButton registerbtn;

    Login() {
        setTitle("Login");
        setLayout(null);

        titlelbl = new JLabel("Login");
        usernamelbl = new JLabel("User Id:");
        passwordlbl = new JLabel("Password:");

        txtname = new JTextField(10);
        txtpassword = new JPasswordField(10);

        loginbtn = new JButton("Login");
        clearbtn = new JButton("Clear");
        registerbtn = new JButton("Sign Up");

        loginbtn.addActionListener(this);
        clearbtn.addActionListener(this);
        registerbtn.addActionListener(this);

        titlelbl.setBounds(150, 75, 100, 50);
        titlelbl.setFont(new Font("Serif", Font.BOLD, 25));

        usernamelbl.setBounds(50, 200, 75, 25);
        passwordlbl.setBounds(50, 250, 75, 25);

        txtname.setBounds(170, 200, 200, 25);
        txtpassword.setBounds(170, 250, 200, 25);

        clearbtn.setBounds(150, 300, 80, 25);
        loginbtn.setBounds(50, 300, 80, 25);
        registerbtn.setBounds(250, 300, 85, 25);

        add(titlelbl);
        add(usernamelbl);
        add(txtname);

        add(passwordlbl);
        add(txtpassword);

        add(loginbtn);
        add(clearbtn);
        add(registerbtn);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 520);
        setVisible(true);
    }

    public static void main(String[] args) {
        Login f = new Login();
    }

    public void reset() {
        txtname.setText("");
        txtpassword.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == loginbtn) {
            String name = txtname.getText();
            String password = txtpassword.getText();

            try {
                File f = new File("C:\\Users\\naera\\eclipse-workspace\\NemoX\\src\\w8\\fileHandeling_java\\registerdetails.txt");
                // FileReader fr =new FileReader(f);
                BufferedReader br = new BufferedReader(new FileReader(f));
                String line;

                while ((line = br.readLine()) != null) {
                    String data[] = line.split(",");
                    if (name.equals(data[0]) && password.equals(data[2])) {
                        JOptionPane.showMessageDialog(null, "Login Successful");
                        AdminDashboard admin = new AdminDashboard();
                        dispose();
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Login Failed");
                    }
                }
            }
            catch (Exception ee) {
                ee.printStackTrace();
            }
        }
        else if (source == clearbtn) {
            txtname.setText("");
            txtpassword.setText("");
        } else if (source == registerbtn) {
            Register register = new Register();
            dispose();
        }
    }
}
