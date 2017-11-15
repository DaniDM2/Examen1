package com.example.dm2.examen1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class Actividad2 extends AppCompatActivity {

    private Spinner spinner;
    private Button btn_lista;
    private TextView txt_ubicacion;
    private RadioGroup r_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        btn_lista=(Button)findViewById(R.id.btn_visualizar);
        txt_ubicacion=(TextView)findViewById(R.id.txt_ubicacion);
        r_group=(RadioGroup)findViewById(R.id.radio_group);

        //SPINNER
        spinner = (Spinner) findViewById(R.id.spinner_provincias);
        final String[] PROVINCIAS = {"Araba", "Bizkaia", "Gipuzkoa"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,PROVINCIAS);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String seleccion=parent.getItemAtPosition(position).toString();
                switch (seleccion) {
                    case "Araba" :
                        txt_ubicacion.setVisibility(View.INVISIBLE);
                        r_group.setVisibility(View.INVISIBLE);
                        btn_lista.setVisibility(View.VISIBLE);
                        break;
                    case "Bizkaia":
                        txt_ubicacion.setVisibility(View.VISIBLE);
                        r_group.setVisibility(View.VISIBLE);
                        btn_lista.setVisibility(View.VISIBLE);
                        break;
                    case "Gipuzkoa":
                        btn_lista.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
