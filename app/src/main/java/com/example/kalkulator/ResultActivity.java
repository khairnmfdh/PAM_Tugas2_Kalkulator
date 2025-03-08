package com.example.kalkulator;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    public TextView textViewHasil, textViewNIM, textViewNama;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewHasil = findViewById(R.id.textViewHasil);
        textViewNIM = findViewById(R.id.textViewNIM);
        textViewNama = findViewById(R.id.textViewNama);

        String hasil = getIntent().getStringExtra("hasil");
        String nim = getIntent().getStringExtra("nim");
        String nama = getIntent().getStringExtra("nama");

        textViewHasil.setText("Hasil: "+hasil);
        textViewNIM.setText("NIM: "+nim);
        textViewNama.setText("Nama: "+nama);

        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}