<<<<<<< HEAD
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Galeria extends JFrame {
    JButton btnAtras, btnAdelante, btnPlay;
    JPanel panelBotones, panelImagen, panelSuperior;
    ImageIcon[] imagenes;
    String[] titulos;
    int imagenActual;
    JLabel etiquetaImagen, etiquetaTitulo;

    Timer timer;
    boolean reproduciendo;

    public Galeria() {
        setTitle("Castellanos Gomez Luis Enrique");
        setSize(450, 580);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Nombres/Títulos de las 10 imágenes
        titulos = new String[]{
            "1. Frieren",
            "2. Tras Finalizar el Viaje",
            "3. Héroes",
            "4. Frieren: Más Allá del Viaje",
            "5. El Héroe",
            "6. Nuevos Heroes",
            "7. Fern",
            "8. Stark",
            "9. Love",
            "10. Enemigos: Demonios"
        };

        // Carga de las 10 imágenes
        imagenes = new ImageIcon[10];
        imagenes[0] = new ImageIcon("frieren.jpg");
        imagenes[1] = new ImageIcon("adventure.jpg");
        imagenes[2] = new ImageIcon("heroes.jpg");
        imagenes[3] = new ImageIcon("himmel.jpg");
        imagenes[4] = new ImageIcon("himmel_1.jpg");
        imagenes[5] = new ImageIcon("new_heroes.jpg");
        imagenes[6] = new ImageIcon("fern.jpg");
        imagenes[7] = new ImageIcon("stark.jpg");
        imagenes[8] = new ImageIcon("fern_stark.jpg");
        imagenes[9] = new ImageIcon("demons.jpg");

        // Etiqueta para el título de la imagen
        etiquetaTitulo = new JLabel("", SwingConstants.CENTER);
        etiquetaTitulo.setFont(new Font("Arial", Font.BOLD, 22));

        panelSuperior = new JPanel();
        panelSuperior.add(etiquetaTitulo);

        // Componentes centrales para la imagen
        panelBotones = new JPanel();
        panelImagen = new JPanel();
        btnAtras = new JButton("Atrás");
        btnAdelante = new JButton("Adelante");
        btnPlay = new JButton("Reproducir");

        etiquetaImagen = new JLabel();
        panelImagen.add(etiquetaImagen);

        // Muestra la primera imagen y título al iniciar
        mostrarImagen();

        // Botón Atrás
        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (imagenActual == 0) {
                    imagenActual = imagenes.length - 1;
                } else {
                    imagenActual--;
                }
                mostrarImagen();
            }
        });

        // Botón Adelante
        btnAdelante.addActionListener(e -> {
            if (imagenActual == imagenes.length - 1) {
                imagenActual = 0;
            } else {
                imagenActual++;
            }
            mostrarImagen();
        });

        // Botón Reproducir / Detener
        btnPlay.addActionListener(e -> {
            if (!reproduciendo) {
                btnPlay.setText("Detener");
                reproduciendo = true;
                timer.start();
            } else {
                btnPlay.setText("Reproducir");
                reproduciendo = false;
                timer.stop();
            }
        });

        // Temporizador para cambio automático cada 2 segundos
        timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (imagenActual == imagenes.length - 1) {
                    imagenActual = 0;
                } else {
                    imagenActual++;
                }
                mostrarImagen();
            }
        });

        panelBotones.add(btnAtras);
        panelBotones.add(btnAdelante);
        panelBotones.add(btnPlay);

        add(panelSuperior, BorderLayout.NORTH);
        add(panelImagen, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    public void mostrarImagen() {
        // Actualiza el título
        etiquetaTitulo.setText(titulos[imagenActual]);

        // Escala e inserta la imagen
        ImageIcon icono = imagenes[imagenActual];
        Image imagen = icono.getImage();
        Image imagenEscalada = imagen.getScaledInstance(
                400,
                400,
                Image.SCALE_SMOOTH
        );

        etiquetaImagen.setIcon(new ImageIcon(imagenEscalada));
    }

    public static void main(String[] args) {
        Galeria g = new Galeria();
        g.setVisible(true);
    }
=======
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Galeria extends JFrame {
    JButton btnAtras, btnAdelante, btnPlay;
    JPanel panelBotones, panelImagen, panelSuperior;
    ImageIcon[] imagenes;
    String[] titulos;
    int imagenActual;
    JLabel etiquetaImagen, etiquetaTitulo;

    Timer timer;
    boolean reproduciendo;

    public Galeria() {
        setTitle("Castellanos Gomez Luis Enrique");
        setSize(450, 580);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Nombres/Títulos de las 10 imágenes
        titulos = new String[]{
            "1. Frieren",
            "2. Tras Finalizar el Viaje",
            "3. Héroes",
            "4. Frieren: Más Allá del Viaje",
            "5. El Héroe",
            "6. Nuevos Heroes",
            "7. Fern",
            "8. Stark",
            "9. Love",
            "10. Enemigos: Demonios"
        };

        // Carga de las 10 imágenes
        imagenes = new ImageIcon[10];
        imagenes[0] = new ImageIcon("frieren.jpg");
        imagenes[1] = new ImageIcon("adventure.jpg");
        imagenes[2] = new ImageIcon("heroes.jpg");
        imagenes[3] = new ImageIcon("himmel.jpg");
        imagenes[4] = new ImageIcon("himmel_1.jpg");
        imagenes[5] = new ImageIcon("new_heroes.jpg");
        imagenes[6] = new ImageIcon("fern.jpg");
        imagenes[7] = new ImageIcon("stark.jpg");
        imagenes[8] = new ImageIcon("fern_stark.jpg");
        imagenes[9] = new ImageIcon("demons.jpg");

        // Etiqueta para el título de la imagen
        etiquetaTitulo = new JLabel("", SwingConstants.CENTER);
        etiquetaTitulo.setFont(new Font("Arial", Font.BOLD, 22));

        panelSuperior = new JPanel();
        panelSuperior.add(etiquetaTitulo);

        // Componentes centrales para la imagen
        panelBotones = new JPanel();
        panelImagen = new JPanel();
        btnAtras = new JButton("Atrás");
        btnAdelante = new JButton("Adelante");
        btnPlay = new JButton("Reproducir");

        etiquetaImagen = new JLabel();
        panelImagen.add(etiquetaImagen);

        // Muestra la primera imagen y título al iniciar
        mostrarImagen();

        // Botón Atrás
        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (imagenActual == 0) {
                    imagenActual = imagenes.length - 1;
                } else {
                    imagenActual--;
                }
                mostrarImagen();
            }
        });

        // Botón Adelante
        btnAdelante.addActionListener(e -> {
            if (imagenActual == imagenes.length - 1) {
                imagenActual = 0;
            } else {
                imagenActual++;
            }
            mostrarImagen();
        });

        // Botón Reproducir / Detener
        btnPlay.addActionListener(e -> {
            if (!reproduciendo) {
                btnPlay.setText("Detener");
                reproduciendo = true;
                timer.start();
            } else {
                btnPlay.setText("Reproducir");
                reproduciendo = false;
                timer.stop();
            }
        });

        // Temporizador para cambio automático cada 2 segundos
        timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (imagenActual == imagenes.length - 1) {
                    imagenActual = 0;
                } else {
                    imagenActual++;
                }
                mostrarImagen();
            }
        });

        panelBotones.add(btnAtras);
        panelBotones.add(btnAdelante);
        panelBotones.add(btnPlay);

        add(panelSuperior, BorderLayout.NORTH);
        add(panelImagen, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    public void mostrarImagen() {
        // Actualiza el título
        etiquetaTitulo.setText(titulos[imagenActual]);

        // Escala e inserta la imagen
        ImageIcon icono = imagenes[imagenActual];
        Image imagen = icono.getImage();
        Image imagenEscalada = imagen.getScaledInstance(
                400,
                400,
                Image.SCALE_SMOOTH
        );

        etiquetaImagen.setIcon(new ImageIcon(imagenEscalada));
    }

    public static void main(String[] args) {
        Galeria g = new Galeria();
        g.setVisible(true);
    }
>>>>>>> 109dde53fd3b0fbb1929f3c53a65b41d501efd42
}