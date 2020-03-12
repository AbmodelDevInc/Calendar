package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText Recordatorio;
    EditText day;
    EditText month;
    EditText year;
    EditText Time;

    Button bFecha;


    private int dia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bFecha = (Button)findViewById(R.id.bFecha);
       // cdia = (EditText)findViewById(R.id.cdia);
        day = findViewById(R.id.day);

        bFecha.setOnClickListener(this);


        Recordatorio = findViewById(R.id.Recordatorio);
       // day = findViewById(R.id.day);
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

    @Override
    public void onClick(View v) {
        if(v== bFecha){
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog;
            datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    day.setText(dayOfMonth+"");
                }
            }
            ,dia);
            datePickerDialog.show();
        }
    }
}