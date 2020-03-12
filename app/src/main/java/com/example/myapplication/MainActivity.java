package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Recordatorio;
    EditText day;
    EditText month;
    EditText year;
    EditText Time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Recordatorio = findViewById(R.id.Recordatorio);
        day = findViewById(R.id.day);
        month = findViewById(R.id.month);
        year = findViewById(R.id.year);
        Time = findViewById(R.id.time);

    }

    public void BottonSave(View view) {
        String d = day.getText().toString();
        String m = month.getText().toString();
        String y = year.getText().toString();
        String r = Recordatorio.getText().toString();

        if (d.isEmpty() || m.isEmpty() || y.isEmpty() || r.isEmpty()) {
            Toast.makeText(this, "Faltan datos", Toast.LENGTH_SHORT).show();
        } else {
            int dd = Integer.parseInt(d);
            int mm = Integer.parseInt(m);
            int yy = Integer.parseInt(y);

            if (dd < 0 || mm < 0 || yy < 2020 || dd > 31 || mm > 12) {
                Toast.makeText(this, "fecha invalida", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "se guardo el recordatorio" + r + "Para el:" + dd + "/" + mm + "/" + yy, Toast.LENGTH_SHORT).show();
            }
        }
    }
}