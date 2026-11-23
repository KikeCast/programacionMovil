package com.example.instrumentosmusicales;

import android.os.Bundle;
import android.media.MediaPlayer;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageButton btnGuitarra, btnBateria, btnPiano;
    MediaPlayer reproductor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGuitarra = findViewById(R.id.btnGuitarra);
        btnBateria = findViewById(R.id.btnBateria);
        btnPiano = findViewById(R.id.btnPiano);

        btnGuitarra.setOnClickListener(v -> reproducirSonido(R.raw.guitarra));
        btnBateria.setOnClickListener(v -> reproducirSonido(R.raw.bateria));
        btnPiano.setOnClickListener(v -> reproducirSonido(R.raw.piano));
    }

    private void reproducirSonido(int sonido) {
        if (reproductor != null) {
            reproductor.release();
            reproductor = null;
        }

        reproductor = MediaPlayer.create(this, sonido);

        if (reproductor != null) {
            reproductor.setOnCompletionListener(mp -> {
                mp.release();
                if (reproductor == mp) {
                    reproductor = null;
                }
            });
            reproductor.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (reproductor != null) {
            reproductor.release();
            reproductor = null;
        }
    }
}