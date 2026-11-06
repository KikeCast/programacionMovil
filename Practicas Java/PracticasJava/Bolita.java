<<<<<<< HEAD
import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bolita extends JPanel {

int x, y;
Image img;
int offsetX, offsetY;

public Bolita() {
setSize(300, 300);
x = 50;
y = 50;

img = new ImageIcon("bolita.jpg").getImage();
setBackground(Color.green);

MouseAdapter mouse = new MouseAdapter() {

@Override
public void mousePressed(MouseEvent e) {
if (e.getButton() == MouseEvent.BUTTON1) {
offsetX = e.getX() - x;
offsetY = e.getY() - y;
}
}

@Override
public void mouseDragged(MouseEvent e) {
if ((e.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) != 0) {
x = e.getX() - offsetX;
y = e.getY() - offsetY;
repaint();
}
}
};

addMouseListener(mouse);
addMouseMotionListener(mouse);
}

@Override
protected void paintComponent(Graphics g) {
super.paintComponent(g);
g.drawImage(img, x, y, this);
}
}

class Ventana extends JFrame {

public Ventana() {
setSize(450, 430);
setTitle("Castellanos Gomez Luis Enrique");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

Bolita bolita = new Bolita();
add(bolita);
}

public static void main(String[] args) {
Ventana v = new Ventana();
v.setVisible(true);
}
=======
import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bolita extends JPanel {

int x, y;
Image img;
int offsetX, offsetY;

public Bolita() {
setSize(300, 300);
x = 50;
y = 50;

img = new ImageIcon("bolita.jpg").getImage();
setBackground(Color.green);

MouseAdapter mouse = new MouseAdapter() {

@Override
public void mousePressed(MouseEvent e) {
if (e.getButton() == MouseEvent.BUTTON1) {
offsetX = e.getX() - x;
offsetY = e.getY() - y;
}
}

@Override
public void mouseDragged(MouseEvent e) {
if ((e.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) != 0) {
x = e.getX() - offsetX;
y = e.getY() - offsetY;
repaint();
}
}
};

addMouseListener(mouse);
addMouseMotionListener(mouse);
}

@Override
protected void paintComponent(Graphics g) {
super.paintComponent(g);
g.drawImage(img, x, y, this);
}
}

class Ventana extends JFrame {

public Ventana() {
setSize(450, 430);
setTitle("Castellanos Gomez Luis Enrique");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

Bolita bolita = new Bolita();
add(bolita);
}

public static void main(String[] args) {
Ventana v = new Ventana();
v.setVisible(true);
}
>>>>>>> 109dde53fd3b0fbb1929f3c53a65b41d501efd42
}