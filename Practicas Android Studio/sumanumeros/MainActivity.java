package com.example.sumanumeros;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    LinearLayout mill;
    EditText num1, num2;
    TextView res, txtNombre;
    Button btnSuma, btnNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mill = new LinearLayout(this);
        mill.setOrientation(LinearLayout.VERTICAL);
        mill.setBackgroundColor(Color.GRAY);
        mill.setPadding(20, 40, 20, 20);

        num1 = new EditText(this);
        num1.setTextSize(20);
        num1.setHint("Dame primer numero");

        num2 = new EditText(this);
        num2.setTextSize(20);
        num2.setHint("Dame segundo numero");

        btnSuma = new Button(this);
        btnSuma.setText("Sumar numeros");

        res = new TextView(this);
        res.setTextSize(20);

        // Botón y texto para mostrar tu nombre
        btnNombre = new Button(this);
        btnNombre.setText("Mostrar nombre");

        txtNombre = new TextView(this);
        txtNombre.setTextSize(20);
        txtNombre.setTextColor(Color.WHITE);
        txtNombre.setPadding(0, 20, 0, 0);

        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numero1 = num1.getText() + "";
                String numero2 = String.valueOf(num2.getText());
                int n1 = Integer.parseInt(numero1);
                int n2 = Integer.parseInt(numero2);
                res.setText(String.valueOf(n1 + n2));
            }
        });

        btnNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNombre.setText("Luis Enrique Castellanos Gomez");
            }
        });

        mill.addView(num1);
        mill.addView(num2);
        mill.addView(btnSuma);
        mill.addView(res);
        mill.addView(btnNombre);
        mill.addView(txtNombre);

        setContentView(mill);
    }
}