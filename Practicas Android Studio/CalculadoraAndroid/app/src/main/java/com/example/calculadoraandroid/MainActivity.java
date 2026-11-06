package com.example.calculadoraandroid;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    EditText pantalla;
    TextView txtNombre;
    int tamLetra = 30;

    Button[] botones = new Button[18];

    Double num1 = 0.0, num2 = 0.0;
    String operacion = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        // Contenedor principal vertical
        LinearLayout principal = new LinearLayout(this);
        principal.setOrientation(LinearLayout.VERTICAL);
        principal.setPadding(20, 40, 20, 30);
        principal.setBackgroundColor(Color.DKGRAY);

        // 1. Etiqueta con tu nombre en la parte superior
        txtNombre = new TextView(this);
        txtNombre.setText("Castellanos Gomez Luis Enrique");
        txtNombre.setTextSize(22);
        txtNombre.setTextColor(Color.WHITE);
        txtNombre.setPadding(0, 0, 0, 20);
        principal.addView(txtNombre);

        // Pantalla de la calculadora
        pantalla = new EditText(this);
        pantalla.setBackgroundColor(Color.WHITE);
        pantalla.setTextSize(tamLetra);
        pantalla.setFocusable(false); // Evita que se abra el teclado del celular al presionar
        principal.addView(pantalla);

        // Filas horizontales de la calculadora
        LinearLayout l1 = new LinearLayout(this);
        l1.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout l2 = new LinearLayout(this);
        l2.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout l3 = new LinearLayout(this);
        l3.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout l4 = new LinearLayout(this);
        l4.setOrientation(LinearLayout.HORIZONTAL);

        // 2. Creación y asignación de evento para los botones numéricos (0-9)
        for (int i = 0; i <= 9; i++) {
            botones[i] = new Button(this);
            botones[i].setText(String.valueOf(i));
            botones[i].setTextSize(tamLetra);
            botones[i].setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    String textoBoton = ((Button) v).getText().toString();
                    pantalla.setText(pantalla.getText() + textoBoton);
                }
            });
        }

        // Distribución de los botones de dígitos en sus respectivas filas (l1 a l4)
        for (int j = 0; j <= 9; j++) {
            switch (j) {
                case 7: case 8: case 9:
                    l1.addView(botones[j]);
                    break;
                case 4: case 5: case 6:
                    l2.addView(botones[j]);
                    break;
                case 1: case 2: case 3:
                    l3.addView(botones[j]);
                    break;
                case 0:
                    l4.addView(botones[j]);
                    break;
            }
        }

        // 3. Botón Punto Decimal (.)
        botones[10] = new Button(this);
        botones[10].setText(".");
        botones[10].setTextSize(tamLetra);
        botones[10].setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!pantalla.getText().toString().contains(".")) {
                    pantalla.setText(pantalla.getText() + ".");
                }
            }
        });
        l4.addView(botones[10]);

        // 4. Botón de Suma (+)
        botones[11] = new Button(this);
        botones[11].setText("+");
        botones[11].setTextSize(tamLetra);
        botones[11].setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarOperacion("+");
            }
        });
        l1.addView(botones[11]);

        // 5. Botón de Resta (-)
        botones[13] = new Button(this);
        botones[13].setText("-");
        botones[13].setTextSize(tamLetra);
        botones[13].setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarOperacion("-");
            }
        });
        l2.addView(botones[13]);

        // 6. Botón de Multiplicación (*)
        botones[14] = new Button(this);
        botones[14].setText("*");
        botones[14].setTextSize(tamLetra);
        botones[14].setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarOperacion("*");
            }
        });
        l3.addView(botones[14]);

        // 7. Botón de División (/)
        botones[15] = new Button(this);
        botones[15].setText("/");
        botones[15].setTextSize(tamLetra);
        botones[15].setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarOperacion("/");
            }
        });
        l4.addView(botones[15]);

        // 8. Botón de Limpiar (C)
        botones[16] = new Button(this);
        botones[16].setText("C");
        botones[16].setTextSize(tamLetra);
        botones[16].setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                pantalla.setText("");
                num1 = 0.0;
                num2 = 0.0;
                operacion = "";
            }
        });
        l4.addView(botones[16]);

        // 9. Botón Igual (=)
        botones[12] = new Button(this);
        botones[12].setText("=");
        botones[12].setTextSize(tamLetra);
        botones[12].setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String valorPantalla = pantalla.getText().toString();
                if (!valorPantalla.isEmpty() && !operacion.isEmpty()) {
                    num2 = Double.parseDouble(valorPantalla);
                    double res = 0;

                    switch (operacion) {
                        case "+":
                            res = num1 + num2;
                            break;
                        case "-":
                            res = num1 - num2;
                            break;
                        case "*":
                            res = num1 * num2;
                            break;
                        case "/":
                            if (num2 != 0) {
                                res = num1 / num2;
                            } else {
                                pantalla.setText("Error");
                                return;
                            }
                            break;
                    }
                    pantalla.setText(String.valueOf(res));
                    operacion = ""; // Reiniciar operación tras calcular
                }
            }
        });
        l3.addView(botones[12]);

        // Agregar las filas al contenedor principal
        principal.addView(l1);
        principal.addView(l2);
        principal.addView(l3);
        principal.addView(l4);

        setContentView(principal);
    }

    // Método auxiliar para registrar la operación activa y limpiar pantalla para el segundo número
    private void guardarOperacion(String op) {
        String valorPantalla = pantalla.getText().toString();
        if (!valorPantalla.isEmpty()) {
            num1 = Double.parseDouble(valorPantalla);
            operacion = op;
            pantalla.setText("");
        }
    }
}