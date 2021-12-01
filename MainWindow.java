import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.LinkedList;

public class MainWindow extends JFrame{

    public static void main(String[] args){
        Person.addPeople();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainWindow mainWindow = new MainWindow("Okno logowania");
                    mainWindow.setVisible(true);
                }catch(Exception e){
                    e.printStackTrace(System.err);
                }
            }
        });
    }

    public MainWindow() throws HeadlessException {
        this("undefined");
    }

    public MainWindow(String title) throws HeadlessException {
        super(title);
      buildFrame();
   }

   public void buildFrame(){
        JPanel panel = new JPanel();
        setBounds(400, 100, 700, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // zakonczenie programu po zamknieciu okna

        JLabel llogin = new JLabel("Login:"); // napis 'Login'
        llogin.setBounds(100,50, 200, 50);
        add(llogin);

        JLabel lpassword = new JLabel("Password:"); //napis 'password'
        lpassword.setBounds(100, 150, 200,80);
        add(lpassword);

        TextField tlogin = new TextField();
        tlogin.setBounds(100, 100,200, 20);
        add(tlogin);

        JPasswordField tpassword = new JPasswordField();
        tpassword.setBounds(100, 200,200, 20);
        add(tpassword);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(150,300,100,50);
        btnLogin.setMnemonic(KeyEvent.VK_0);
        add(btnLogin);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkData(tlogin.getText(), tpassword.getPassword())){
                    getContentPane().setBackground(Color.GREEN);
                }else{
                  getContentPane().setBackground(Color.RED);
                }
            }
        });

        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(400, 300, 100, 50);
        btnClear.setMnemonic(KeyEvent.VK_0);
        add(btnClear);
        btnClear.addActionListener(e -> {
            tlogin.setText(null);
            tpassword.setText(null);
        });

    }

    public boolean checkData(String login, char[] password) {

        boolean test=false;
        for (int i = 0; i < (Person.people.size()); i++) {
            if (login.equals(Person.people.get(i).login)) {
                if (Arrays.equals(password, (Person.people.get(i).password))) {
                    test = true;
                }
            }
        }
        if(test==true){
            return true;
        }else{
            return false;
        }
    }
}