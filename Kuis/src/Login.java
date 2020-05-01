import java.awt.event.*;
import javax.swing.*;


public class Login extends JFrame{
    JLabel ljudul = new JLabel("Login Admin");
    JLabel lunsername = new JLabel("Username");
    JLabel lpassword = new JLabel("Password");
    final JTextField tusername = new JTextField();
    final JPasswordField tpassword = new JPasswordField();
    JButton btnLogin = new JButton("LOGIN");
    
    public Login()
    {
        setTitle("Login");
        setLocation(400, 200);
        setSize(350,300);
        setDefaultCloseOperation(3);
        
        
        btnLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
                if(tusername.getText().equals("admin") && tpassword.getText().equals("1234")){
                    FilmMVC f = new FilmMVC();
                    dispose();
                }
                else 
                {
                    System.out.println("username atau password salah");
                    JOptionPane.showMessageDialog(null, "Login Failed!");
                }
            }
        });

        setLayout(null);
        add(ljudul);
        add(lunsername);
        add(lpassword);
        add(tusername);
        add(tpassword);
        add(btnLogin);
               
        ljudul.setBounds(130,20,100,20);
        lunsername.setBounds(50,60,100,10);
        lpassword.setBounds(50,100,100,10);
        tusername.setBounds(150,60,120,20);
        tpassword.setBounds(150,100,120,20);
        btnLogin.setBounds(130,160,80,20);
        setVisible(true);
    }

}
