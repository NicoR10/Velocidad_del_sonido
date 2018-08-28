package com.example.android.velocidad_del_sonido;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText temp;
    private TextView res;
    private TextView ms;
    private TextView vel_son;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        temp = (EditText)findViewById(R.id.temperatura);
        res = (TextView)findViewById(R.id.resultado);
        ms = (TextView)findViewById(R.id.ms);
        vel_son = (TextView)findViewById(R.id.vel_son);
        ms.setVisibility(View.INVISIBLE);
        vel_son.setVisibility(View.INVISIBLE);

    }

    //Este metodo calcula la velocidad del sonido
    public void calcular(View view){

        try{

            String valor_temp = temp.getText().toString();
            double temp_val = Double.parseDouble(valor_temp);

            double velocidad = 20*Math.sqrt(273 + temp_val);
            velocidad = Math.round(velocidad*100.00)/100.00;

            String velocidad_string = String.valueOf(velocidad);
            res.setText(velocidad_string);
            ms.setVisibility(View.VISIBLE);
            vel_son.setVisibility(View.VISIBLE);

        }catch(Exception e){
            Toast.makeText(this, "Ingrese un valor", Toast.LENGTH_SHORT).show();
        }


    }

    public void borrar(View view){

        ms.setVisibility(View.INVISIBLE);
        vel_son.setVisibility(View.INVISIBLE);
        res.setText("");
        temp.setText("");

    }

}
