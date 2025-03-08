package com.example.kalkulator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public EditText editTextNum1, editTextNum2;
    public RadioGroup radioGroup;
    public Button buttonHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNum1 = findViewById(R.id.editTextNum1);
        editTextNum2 = findViewById(R.id.editTextNum2);
        radioGroup = findViewById(R.id.radioGroup);
        buttonHitung = findViewById(R.id.buttonHitung);

        buttonHitung.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                hitung();
            }
        });
    }

        public void hitung(){
            String num1Str = editTextNum1.getText().toString();
            String num2Str = editTextNum2.getText().toString();

            if(num1Str.isEmpty() || num2Str.isEmpty()){
                Toast.makeText(this, "Masukkan 2 angka!", Toast.LENGTH_SHORT).show();
                return;
            }

            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);
            double hasil = 0;

            int selectedId = radioGroup.getCheckedRadioButtonId();
                if(selectedId == -1){
                    Toast.makeText(this, "Pilih operasi terlebih dahulu!", Toast.LENGTH_SHORT).show();
                    return;
                }

             RadioButton selectedRadioButton = findViewById(selectedId);
             String operasi = selectedRadioButton.getText().toString();

             switch(operasi){
                 case "+" :
                     hasil = num1+num2;
                     break;
                 case "-":
                     hasil = num1-num2;
                     break;
                 case "*":
                     hasil = num1*num2;
                     break;
                 case "/":
                     if(num2 == 0){
                         Toast.makeText(this, "Tidak bisa membagi dengan 0!", Toast.LENGTH_SHORT).show();
                         return;
                     }
                     hasil = num1/num2;
                     break;
             }

             //pindah ke Activity kedua dengan hasil perhitungan
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
             intent.putExtra("hasil", String.valueOf(hasil));
             intent.putExtra("nim", "235150700111026");
             intent.putExtra("nama", "Khairani Mufidah");
            startActivity(intent);
            }
        }