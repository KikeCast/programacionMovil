package com.example.papa;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView ivCuerpo, ivPelo, ivOjos, ivNariz, ivBoca, ivPies;
    Button btnCalificar;
    TextView tvResultado;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enlazar vistas
        ivCuerpo = findViewById(R.id.ivCuerpo);
        ivPelo = findViewById(R.id.ivPelo);
        ivOjos = findViewById(R.id.ivOjos);
        ivNariz = findViewById(R.id.ivNariz);
        ivBoca = findViewById(R.id.ivBoca);
        ivPies = findViewById(R.id.ivPies);

        btnCalificar = findViewById(R.id.btnCalificar);
        tvResultado = findViewById(R.id.tvResultado);

        // Activar movimiento táctil (Drag & Drop) en las 5 piezas
        hacerArrastrable(ivPelo);
        hacerArrastrable(ivOjos);
        hacerArrastrable(ivNariz);
        hacerArrastrable(ivBoca);
        hacerArrastrable(ivPies);

        // Evento para calificar posiciones
        btnCalificar.setOnClickListener(v -> calificarArmado());
    }

    // Método reutilizable para arrastrar cualquier ImageView por la pantalla
    @SuppressLint("ClickableViewAccessibility")
    private void hacerArrastrable(View vista) {
        vista.setOnTouchListener(new View.OnTouchListener() {
            float dX, dY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Guarda la diferencia entre la esquina de la vista y el toque del dedo
                        dX = v.getX() - event.getRawX();
                        dY = v.getY() - event.getRawY();
                        v.bringToFront(); // Trae la pieza seleccionada al frente
                        break;

                    case MotionEvent.ACTION_MOVE:
                        // Actualiza coordenadas en tiempo real
                        v.setX(event.getRawX() + dX);
                        v.setY(event.getRawY() + dY);
                        break;
                }
                return true;
            }
        });
    }

    // Cálculo geométrico relativo al cuerpo para evaluar cada parte
    private void calificarArmado() {
        float cuerpoX = ivCuerpo.getX();
        float cuerpoY = ivCuerpo.getY();
        float cuerpoAncho = ivCuerpo.getWidth();
        float cuerpoAlto = ivCuerpo.getHeight();

        // Tolerancia en píxeles para considerar "posición aproximada correcta"
        double tolerancia = 70.0;

        int aciertos = 0;
        StringBuilder detalle = new StringBuilder();

        // 1. Pelo: centrado horizontalmente (0.50), en la parte superior (0.08)
        if (estaEnPosicion(ivPelo, cuerpoX + cuerpoAncho * 0.50f, cuerpoY + cuerpoAlto * 0.08f, tolerancia)) {
            aciertos++;
        } else {
            detalle.append("Pelo ");
        }

        // 2. Ojos: centrados horizontalmente (0.50), tercio superior (0.33)
        if (estaEnPosicion(ivOjos, cuerpoX + cuerpoAncho * 0.50f, cuerpoY + cuerpoAlto * 0.33f, tolerancia)) {
            aciertos++;
        } else {
            detalle.append("Ojos ");
        }

        // 3. Nariz: centro del cuerpo (0.50, 0.50)
        if (estaEnPosicion(ivNariz, cuerpoX + cuerpoAncho * 0.50f, cuerpoY + cuerpoAlto * 0.50f, tolerancia)) {
            aciertos++;
        } else {
            detalle.append("Nariz ");
        }

        // 4. Boca: centrada horizontalmente (0.50), parte media-baja (0.70)
        if (estaEnPosicion(ivBoca, cuerpoX + cuerpoAncho * 0.50f, cuerpoY + cuerpoAlto * 0.70f, tolerancia)) {
            aciertos++;
        } else {
            detalle.append("Boca ");
        }

        // 5. Pies: centrados horizontalmente (0.50), base inferior del cuerpo (0.95)
        if (estaEnPosicion(ivPies, cuerpoX + cuerpoAncho * 0.50f, cuerpoY + cuerpoAlto * 0.95f, tolerancia)) {
            aciertos++;
        } else {
            detalle.append("Pies ");
        }

        // Calcular calificación sobre 100
        int calificacion = aciertos * 20;

        if (aciertos == 5) {
            tvResultado.setTextColor(Color.parseColor("#15803D")); // Verde
            tvResultado.setText("¡Excelente! Calificación: 100 / 100");
        } else {
            tvResultado.setTextColor(Color.parseColor("#B91C1C")); // Rojo
            tvResultado.setText("Calificación: " + calificacion + "/100 | Ajustar: " + detalle.toString().trim());
        }
    }

    // Calcula la distancia euclidiana entre el centro de la pieza y su coordenada ideal
    private boolean estaEnPosicion(ImageView pieza, float objetivoX, float objetivoY, double tolerancia) {
        float centroPiezaX = pieza.getX() + (pieza.getWidth() / 2f);
        float centroPiezaY = pieza.getY() + (pieza.getHeight() / 2f);

        double distancia = Math.hypot(centroPiezaX - objetivoX, centroPiezaY - objetivoY);
        return distancia <= tolerancia;
    }
}