package com.example.dm2.examen1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Actividad1 extends AppCompatActivity {

    private TextView txt_num1, txt_num2,txt_signo,txt_igual;
    private EditText txt_resultado;
    private Button empezar,evaluar;
    private ImageButton volver;
    private RadioGroup radios;


    private int num1, num2, resultado, intentos = 10, aciertos = 0;
    private int idSeleccionada;
    private String signo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);

        txt_resultado = (EditText) findViewById(R.id.txt_resultado);
        radios = (RadioGroup) findViewById(R.id.radio_group);
        txt_num1=(TextView)findViewById(R.id.txt_num1);
        txt_num2=(TextView)findViewById(R.id.txt_num2);
        txt_signo=(TextView)findViewById(R.id.txt_signo);
        empezar=(Button) findViewById(R.id.btn_empezar);
        evaluar=(Button) findViewById(R.id.btn_evaluar);
        txt_igual=(TextView)findViewById(R.id.txt_igual);
        volver=(ImageButton) findViewById(R.id.volver);


        empezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Ponemos invisible empezar y ponesmos visible evaluar
                empezar.setVisibility(View.INVISIBLE);
                evaluar.setVisibility(View.VISIBLE);

                num1=(int) (Math.random()*100+1);
                num2=(int) (Math.random()*100+1);

                //Cogemos el radio seleccioando cuando pulsamos empezar
                idSeleccionada =radios.getCheckedRadioButtonId();
                Log.i("RADIOP",String.valueOf(idSeleccionada));
                switch (idSeleccionada){
                    case R.id.radio_sum:
                        signo=" + ";
                        resultado=num1+num2;
                        break;
                    case  R.id.radio_res:
                        signo=" - ";
                        resultado=num1-num2;
                        break;
                    case  R.id.radio_mult:
                        signo=" x ";
                        resultado=num1*num2;
                        break;
                    case -1:
                        Toast.makeText(getApplicationContext(), "Debes seleccionar una opcion para empezar", Toast.LENGTH_SHORT);
                }

                txt_signo.setText(signo);
                txt_igual.setVisibility(View.VISIBLE);
                txt_num1.setText(String.valueOf(num1));
                txt_num2.setText(String.valueOf(num2));

                radios.setEnabled(false);
            }
        });

        //EVALUAR
        evaluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_resultado=(EditText)findViewById(R.id.txt_resultado);
                if(resultado!=Integer.parseInt(txt_resultado.getText().toString())){
                    aciertos++;
                }else
                    aciertos--;

                intentos--;
                if (intentos==0){
                    int porcentaje=(aciertos*10) /100;
                    Toast.makeText(getApplicationContext(),
                            "Has tenido un "+porcentaje+"% de aciertos", Toast.LENGTH_SHORT).show();
                    txt_resultado.setText("");
                    txt_num2.setText("");
                    txt_num1.setText("");
                    txt_signo.setText("");
                    radios.clearCheck();

                    empezar.setVisibility(View.VISIBLE);
                    evaluar.setVisibility(View.INVISIBLE);
                }else{
                    num1=(int) (Math.random()*100+1);
                    num2=(int) (Math.random()*100+1);
                    if(signo.equals(" + ")){
                        resultado=num1+num2;
                    }
                    if(signo.equals(" - ")){
                        resultado=num1-num2;
                    }
                    if(signo.equals(" x ")){
                        resultado=num1*num2;
                    }
                    txt_num1.setText(String.valueOf(num1));
                    txt_num2.setText(String.valueOf(num2));
                    txt_resultado.setText("");
                }
            }
        });


        //VOLVER
    volver.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Actividad1.this, MainActivity.class);
            startActivity(intent);
        }
    });

    }

}
