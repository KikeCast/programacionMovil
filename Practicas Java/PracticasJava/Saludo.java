<<<<<<< HEAD
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Saludo extends JFrame {

    public Saludo() {
        setTitle("Programa 01 - Saludo");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton btnSaludar = new JButton("SALUDA");

        btnSaludar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "HOLA LUIS ENRIQUE CASTELLANOS");
            }
        });

        add(btnSaludar);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Saludo();
    }
=======
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Saludo extends JFrame {

    public Saludo() {
        setTitle("Programa 01 - Saludo");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton btnSaludar = new JButton("SALUDA");

        btnSaludar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "HOLA LUIS ENRIQUE CASTELLANOS");
            }
        });

        add(btnSaludar);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Saludo();
    }
>>>>>>> 109dde53fd3b0fbb1929f3c53a65b41d501efd42
}