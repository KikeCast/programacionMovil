import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Bordes extends JFrame implements ActionListener {
    JButton btnCalcular;
    JLabel txtTitulo;
    JTextArea txtTabla;
    JTextField tablaDada;
    JPanel panelControles;

    public Bordes() {
        setTitle("BorderLayout");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        btnCalcular = new JButton("Calcular");
        btnCalcular.addActionListener(this);
        add(btnCalcular, BorderLayout.SOUTH);

        txtTitulo = new JLabel("Crear Tabla");

        txtTabla = new JTextArea("");
        add(txtTabla, BorderLayout.CENTER);

        tablaDada = new JTextField(4);

        panelControles = new JPanel();
        panelControles.add(txtTitulo);
        panelControles.add(tablaDada);
        add(panelControles, BorderLayout.NORTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int tabla = Integer.parseInt(tablaDada.getText().trim());
            String res = "";
            for (int i = 1; i <= 10; i++) {
                res += (tabla + " x " + i + " = " + (tabla * i) + "\n");
            }
            txtTabla.setText(res);
        } catch (NumberFormatException ex) {
            txtTabla.setText("Por favor, ingresa un número válido.");
        }
    }

    public static void main(String[] args) {
        Bordes b = new Bordes();
        b.setVisible(true);
    }
}