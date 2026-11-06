<<<<<<< HEAD
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calculadora extends JFrame implements ActionListener {
    JButton btnSuma, btnResta, btnDivision, btnMultiplicacion, btnIgual, btnPunto;
    JTextField pantalla;
    Font letra = new Font("Arial", Font.BOLD, 30);
    JPanel pPantalla;
    JButton btnDigitos[];
    JPanel panelDigitos[];
    Double num1 = 0.0;
    Double num2 = 0.0;
    String operacion = "";
    boolean nuevaOperacion = true;

    public Calculadora() {
        setTitle("Mi Calculadora");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1));

        pantalla = new JTextField(10);
        pantalla.setFont(letra);
        pantalla.setHorizontalAlignment(SwingConstants.RIGHT);
        pantalla.setEditable(false);
        pantalla.setText("0");

        panelDigitos = new JPanel[4];
        for (int i = 0; i < 4; i++) {
            panelDigitos[i] = new JPanel(new GridLayout(1, 4, 5, 5));
        }

        btnDigitos = new JButton[10];
        for (int i = 0; i < 10; i++) {
            btnDigitos[i] = new JButton(String.valueOf(i));
            btnDigitos[i].setFont(letra);
            btnDigitos[i].addActionListener(this);
        }

        // Configuración de botones de operación
        btnSuma = new JButton("+");
        btnResta = new JButton("-");
        btnMultiplicacion = new JButton("*");
        btnDivision = new JButton("/");
        btnIgual = new JButton("=");
        btnPunto = new JButton(".");

        JButton[] ops = {btnSuma, btnResta, btnMultiplicacion, btnDivision, btnIgual, btnPunto};
        for (JButton b : ops) {
            b.setFont(letra);
        }

        ActionListener opListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    num1 = Double.parseDouble(pantalla.getText());
                    operacion = e.getActionCommand();
                    nuevaOperacion = true;
                } catch (NumberFormatException ex) {
                    pantalla.setText("Error");
                    nuevaOperacion = true;
                }
            }
        };

        btnSuma.addActionListener(opListener);
        btnResta.addActionListener(opListener);
        btnMultiplicacion.addActionListener(opListener);
        btnDivision.addActionListener(opListener);

        // Control del punto decimal (evita múltiples puntos)
        btnPunto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nuevaOperacion) {
                    pantalla.setText("0.");
                    nuevaOperacion = false;
                } else if (!pantalla.getText().contains(".")) {
                    pantalla.setText(pantalla.getText() + ".");
                }
            }
        });

        // Cálculo de operaciones básicas
        btnIgual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (operacion.isEmpty()) {
                    return;
                }
                try {
                    num2 = Double.parseDouble(pantalla.getText());
                    double resultado = 0.0;
                    boolean divisionPorCero = false;

                    switch (operacion) {
                        case "+":
                            resultado = num1 + num2;
                            break;
                        case "-":
                            resultado = num1 - num2;
                            break;
                        case "*":
                            resultado = num1 * num2;
                            break;
                        case "/":
                            if (num2 == 0) {
                                divisionPorCero = true;
                            } else {
                                resultado = num1 / num2;
                            }
                            break;
                    }

                    if (divisionPorCero) {
                        pantalla.setText("Error: Div 0");
                    } else {
                        // Si no tiene decimales, mostrar como entero
                        if (resultado == (long) resultado) {
                            pantalla.setText(String.format("%d", (long) resultado));
                        } else {
                            pantalla.setText(String.valueOf(resultado));
                        }
                    }
                    operacion = "";
                    nuevaOperacion = true;
                } catch (NumberFormatException ex) {
                    pantalla.setText("Error");
                    nuevaOperacion = true;
                }
            }
        });

        // Fila 1 (7, 8, 9, +)
        panelDigitos[3].add(btnDigitos[7]);
        panelDigitos[3].add(btnDigitos[8]);
        panelDigitos[3].add(btnDigitos[9]);
        panelDigitos[3].add(btnSuma);

        // Fila 2 (4, 5, 6, -)
        panelDigitos[2].add(btnDigitos[4]);
        panelDigitos[2].add(btnDigitos[5]);
        panelDigitos[2].add(btnDigitos[6]);
        panelDigitos[2].add(btnResta);

        // Fila 3 (1, 2, 3, *)
        panelDigitos[1].add(btnDigitos[1]);
        panelDigitos[1].add(btnDigitos[2]);
        panelDigitos[1].add(btnDigitos[3]);
        panelDigitos[1].add(btnMultiplicacion);

        // Fila 4 (0, ., =, /)
        panelDigitos[0].add(btnDigitos[0]);
        panelDigitos[0].add(btnPunto);
        panelDigitos[0].add(btnIgual);
        panelDigitos[0].add(btnDivision);

        pPantalla = new JPanel(new BorderLayout());
        pPantalla.add(pantalla, BorderLayout.CENTER);

        add(pPantalla);
        add(panelDigitos[3]);
        add(panelDigitos[2]);
        add(panelDigitos[1]);
        add(panelDigitos[0]);
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        String num = a.getActionCommand();
        if (nuevaOperacion || pantalla.getText().equals("0")) {
            pantalla.setText(num);
            nuevaOperacion = false;
        } else {
            pantalla.setText(pantalla.getText() + num);
        }
    }

    public static void main(String[] args) {
        Calculadora c = new Calculadora();
        c.setVisible(true);
    }
=======
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calculadora extends JFrame implements ActionListener {
    JButton btnSuma, btnResta, btnDivision, btnMultiplicacion, btnIgual, btnPunto;
    JTextField pantalla;
    Font letra = new Font("Arial", Font.BOLD, 30);
    JPanel pPantalla;
    JButton btnDigitos[];
    JPanel panelDigitos[];
    Double num1 = 0.0;
    Double num2 = 0.0;
    String operacion = "";
    boolean nuevaOperacion = true;

    public Calculadora() {
        setTitle("Mi Calculadora");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1));

        pantalla = new JTextField(10);
        pantalla.setFont(letra);
        pantalla.setHorizontalAlignment(SwingConstants.RIGHT);
        pantalla.setEditable(false);
        pantalla.setText("0");

        panelDigitos = new JPanel[4];
        for (int i = 0; i < 4; i++) {
            panelDigitos[i] = new JPanel(new GridLayout(1, 4, 5, 5));
        }

        btnDigitos = new JButton[10];
        for (int i = 0; i < 10; i++) {
            btnDigitos[i] = new JButton(String.valueOf(i));
            btnDigitos[i].setFont(letra);
            btnDigitos[i].addActionListener(this);
        }

        // Configuración de botones de operación
        btnSuma = new JButton("+");
        btnResta = new JButton("-");
        btnMultiplicacion = new JButton("*");
        btnDivision = new JButton("/");
        btnIgual = new JButton("=");
        btnPunto = new JButton(".");

        JButton[] ops = {btnSuma, btnResta, btnMultiplicacion, btnDivision, btnIgual, btnPunto};
        for (JButton b : ops) {
            b.setFont(letra);
        }

        ActionListener opListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    num1 = Double.parseDouble(pantalla.getText());
                    operacion = e.getActionCommand();
                    nuevaOperacion = true;
                } catch (NumberFormatException ex) {
                    pantalla.setText("Error");
                    nuevaOperacion = true;
                }
            }
        };

        btnSuma.addActionListener(opListener);
        btnResta.addActionListener(opListener);
        btnMultiplicacion.addActionListener(opListener);
        btnDivision.addActionListener(opListener);

        // Control del punto decimal (evita múltiples puntos)
        btnPunto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nuevaOperacion) {
                    pantalla.setText("0.");
                    nuevaOperacion = false;
                } else if (!pantalla.getText().contains(".")) {
                    pantalla.setText(pantalla.getText() + ".");
                }
            }
        });

        // Cálculo de operaciones básicas
        btnIgual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (operacion.isEmpty()) {
                    return;
                }
                try {
                    num2 = Double.parseDouble(pantalla.getText());
                    double resultado = 0.0;
                    boolean divisionPorCero = false;

                    switch (operacion) {
                        case "+":
                            resultado = num1 + num2;
                            break;
                        case "-":
                            resultado = num1 - num2;
                            break;
                        case "*":
                            resultado = num1 * num2;
                            break;
                        case "/":
                            if (num2 == 0) {
                                divisionPorCero = true;
                            } else {
                                resultado = num1 / num2;
                            }
                            break;
                    }

                    if (divisionPorCero) {
                        pantalla.setText("Error: Div 0");
                    } else {
                        // Si no tiene decimales, mostrar como entero
                        if (resultado == (long) resultado) {
                            pantalla.setText(String.format("%d", (long) resultado));
                        } else {
                            pantalla.setText(String.valueOf(resultado));
                        }
                    }
                    operacion = "";
                    nuevaOperacion = true;
                } catch (NumberFormatException ex) {
                    pantalla.setText("Error");
                    nuevaOperacion = true;
                }
            }
        });

        // Fila 1 (7, 8, 9, +)
        panelDigitos[3].add(btnDigitos[7]);
        panelDigitos[3].add(btnDigitos[8]);
        panelDigitos[3].add(btnDigitos[9]);
        panelDigitos[3].add(btnSuma);

        // Fila 2 (4, 5, 6, -)
        panelDigitos[2].add(btnDigitos[4]);
        panelDigitos[2].add(btnDigitos[5]);
        panelDigitos[2].add(btnDigitos[6]);
        panelDigitos[2].add(btnResta);

        // Fila 3 (1, 2, 3, *)
        panelDigitos[1].add(btnDigitos[1]);
        panelDigitos[1].add(btnDigitos[2]);
        panelDigitos[1].add(btnDigitos[3]);
        panelDigitos[1].add(btnMultiplicacion);

        // Fila 4 (0, ., =, /)
        panelDigitos[0].add(btnDigitos[0]);
        panelDigitos[0].add(btnPunto);
        panelDigitos[0].add(btnIgual);
        panelDigitos[0].add(btnDivision);

        pPantalla = new JPanel(new BorderLayout());
        pPantalla.add(pantalla, BorderLayout.CENTER);

        add(pPantalla);
        add(panelDigitos[3]);
        add(panelDigitos[2]);
        add(panelDigitos[1]);
        add(panelDigitos[0]);
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        String num = a.getActionCommand();
        if (nuevaOperacion || pantalla.getText().equals("0")) {
            pantalla.setText(num);
            nuevaOperacion = false;
        } else {
            pantalla.setText(pantalla.getText() + num);
        }
    }

    public static void main(String[] args) {
        Calculadora c = new Calculadora();
        c.setVisible(true);
    }
>>>>>>> 109dde53fd3b0fbb1929f3c53a65b41d501efd42
}