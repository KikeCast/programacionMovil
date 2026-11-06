<<<<<<< HEAD
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Boton extends JFrame {

    public Boton() {
        setSize(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Programa 01");

        JButton btnSaludar = new JButton("Saluda");

        btnSaludar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Luis Enrique");
            }
        });

        add(btnSaludar);
        setVisible(true);
    }
=======
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Boton extends JFrame {

    public Boton() {
        setSize(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Programa 01");

        JButton btnSaludar = new JButton("Saluda");

        btnSaludar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Luis Enrique");
            }
        });

        add(btnSaludar);
        setVisible(true);
    }
>>>>>>> 109dde53fd3b0fbb1929f3c53a65b41d501efd42
}