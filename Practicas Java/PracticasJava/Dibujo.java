<<<<<<< HEAD
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Dibujo extends JFrame {
    JComboBox<String> comboColores;
    JPanel panelDibujo, panelSuperior;
    JButton btnLimpiar;

    BufferedImage imagen;
    Graphics2D g2;
    Image imagenFondo;

    int xAnterior, yAnterior;

    public Dibujo() {
        setTitle("Paint");
        setSize(400, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        comboColores = new JComboBox<>();
        comboColores.addItem("Rojo");
        comboColores.addItem("Verde");
        comboColores.addItem("Azul");

        btnLimpiar = new JButton("Limpiar");

        panelSuperior = new JPanel();
        panelSuperior.add(comboColores);
        panelSuperior.add(btnLimpiar);

        add(panelSuperior, BorderLayout.NORTH);

        // Lienzo en memoria
        imagen = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
        g2 = imagen.createGraphics();

        // Cargar imagen de fondo (reemplaza 'fondo.jpg' por el nombre de tu imagen)
        cargarFondo();

        panelDibujo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imagen, 40, 10, null);
            }
        };
        panelDibujo.setBackground(Color.WHITE);

        // Evento de cambio de color
        comboColores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarColor();
            }
        });

        // Evento del botón Limpiar
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarFondo();
                actualizarColor();
                panelDibujo.repaint();
            }
        });

        // Captura inicial al hacer clic
        panelDibujo.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xAnterior = e.getX() - 40;
                yAnterior = e.getY() - 10;
            }
        });

        // Trazado al arrastrar el ratón
        panelDibujo.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getX() - 40;
                int y = e.getY() - 10;

                g2.drawLine(xAnterior, yAnterior, x, y);

                xAnterior = x;
                yAnterior = y;

                panelDibujo.repaint();
            }
        });

        add(panelDibujo, BorderLayout.CENTER);
    }

    private void cargarFondo() {
        try {
            // Lee un archivo llamado 'fondo.jpg' o 'fondo.png' colocado en la misma carpeta del proyecto
            File archivoImagen = new File("fondo.jpg");
            if (archivoImagen.exists()) {
                imagenFondo = ImageIO.read(archivoImagen);
                g2.drawImage(imagenFondo, 0, 0, imagen.getWidth(), imagen.getHeight(), null);
            } else {
                // Si aún no tienes un archivo 'fondo.jpg', se rellena de blanco para no dejarlo negro
                g2.setColor(Color.WHITE);
                g2.fillRect(0, 0, imagen.getWidth(), imagen.getHeight());
            }
        } catch (Exception ex) {
            g2.setColor(Color.WHITE);
            g2.fillRect(0, 0, imagen.getWidth(), imagen.getHeight());
        }
    }

    private void actualizarColor() {
        int colorSeleccionado = comboColores.getSelectedIndex();
        switch (colorSeleccionado) {
            case 0: g2.setColor(Color.RED); break;
            case 1: g2.setColor(Color.GREEN); break;
            case 2: g2.setColor(Color.BLUE); break;
        }
    }

    public static void main(String[] args) {
        Dibujo d = new Dibujo();
        d.setVisible(true);
    }
=======
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Dibujo extends JFrame {
    JComboBox<String> comboColores;
    JPanel panelDibujo, panelSuperior;
    JButton btnLimpiar;

    BufferedImage imagen;
    Graphics2D g2;
    Image imagenFondo;

    int xAnterior, yAnterior;

    public Dibujo() {
        setTitle("Paint");
        setSize(400, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        comboColores = new JComboBox<>();
        comboColores.addItem("Rojo");
        comboColores.addItem("Verde");
        comboColores.addItem("Azul");

        btnLimpiar = new JButton("Limpiar");

        panelSuperior = new JPanel();
        panelSuperior.add(comboColores);
        panelSuperior.add(btnLimpiar);

        add(panelSuperior, BorderLayout.NORTH);

        // Lienzo en memoria
        imagen = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
        g2 = imagen.createGraphics();

        // Cargar imagen de fondo (reemplaza 'fondo.jpg' por el nombre de tu imagen)
        cargarFondo();

        panelDibujo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imagen, 40, 10, null);
            }
        };
        panelDibujo.setBackground(Color.WHITE);

        // Evento de cambio de color
        comboColores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarColor();
            }
        });

        // Evento del botón Limpiar
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarFondo();
                actualizarColor();
                panelDibujo.repaint();
            }
        });

        // Captura inicial al hacer clic
        panelDibujo.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xAnterior = e.getX() - 40;
                yAnterior = e.getY() - 10;
            }
        });

        // Trazado al arrastrar el ratón
        panelDibujo.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getX() - 40;
                int y = e.getY() - 10;

                g2.drawLine(xAnterior, yAnterior, x, y);

                xAnterior = x;
                yAnterior = y;

                panelDibujo.repaint();
            }
        });

        add(panelDibujo, BorderLayout.CENTER);
    }

    private void cargarFondo() {
        try {
            // Lee un archivo llamado 'fondo.jpg' o 'fondo.png' colocado en la misma carpeta del proyecto
            File archivoImagen = new File("fondo.jpg");
            if (archivoImagen.exists()) {
                imagenFondo = ImageIO.read(archivoImagen);
                g2.drawImage(imagenFondo, 0, 0, imagen.getWidth(), imagen.getHeight(), null);
            } else {
                // Si aún no tienes un archivo 'fondo.jpg', se rellena de blanco para no dejarlo negro
                g2.setColor(Color.WHITE);
                g2.fillRect(0, 0, imagen.getWidth(), imagen.getHeight());
            }
        } catch (Exception ex) {
            g2.setColor(Color.WHITE);
            g2.fillRect(0, 0, imagen.getWidth(), imagen.getHeight());
        }
    }

    private void actualizarColor() {
        int colorSeleccionado = comboColores.getSelectedIndex();
        switch (colorSeleccionado) {
            case 0: g2.setColor(Color.RED); break;
            case 1: g2.setColor(Color.GREEN); break;
            case 2: g2.setColor(Color.BLUE); break;
        }
    }

    public static void main(String[] args) {
        Dibujo d = new Dibujo();
        d.setVisible(true);
    }
>>>>>>> 109dde53fd3b0fbb1929f3c53a65b41d501efd42
}