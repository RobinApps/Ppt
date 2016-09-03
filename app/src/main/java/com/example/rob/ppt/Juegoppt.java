package com.example.rob.ppt;

import android.media.Image;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class Juegoppt extends AppCompatActivity {

    Button Piedra;
    Button Papel;
    Button Tijera;
    Button Nuevo;
    TextView numeros;

    TextView Resultado,ganaOp,ganaTu;
    ImageView imgyou,imgopo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juegoppt);

        Piedra = (Button)findViewById(R.id.BtPiedra);
        Papel = (Button)findViewById(R.id.BtPapel);
        Tijera = (Button)findViewById(R.id.BtTijera);
        Nuevo = (Button)findViewById(R.id.BtNuevo);
        numeros = (TextView)findViewById(R.id.LbContador);

        Resultado = (TextView)findViewById(R.id.LbResultado);
        ganaOp = (TextView)findViewById(R.id.LbGanaOP);
        ganaTu = (TextView)findViewById(R.id.LgGanaTu);
        final ImageView logo= (ImageView)findViewById(R.id.imgOp);
        imgyou = (ImageView)findViewById(R.id.you);
        imgopo = (ImageView)findViewById(R.id.opo);
        imgyou.setImageResource(R.drawable.you);
        imgopo.setImageResource(R.drawable.opo);



       // iniciarCrono();
       final CountDownTimer time = new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                numeros.setText(String.valueOf(millisUntilFinished / 1000));
            }

            public void onFinish() {
                numeros.setText("0");
                Piedra.setEnabled(false);
                Papel.setEnabled(false);
                Tijera.setEnabled(false);
                Resultado.setText("Se acabo el Tiempo, LOSE");
                ganaOp.setText(String.valueOf(Integer.parseInt(ganaOp.getText().toString()) + 1));
                ganoOperdio(Integer.parseInt(ganaOp.getText().toString()), "PERDID");


            }


        }.start();

        Nuevo.setEnabled(true);

        Piedra.setOnClickListener(new View.OnClickListener() {//piedra es 1
            @Override
            public void onClick(View v) {
                double oponente = aleatorio();
                if (oponente == 2) {
                    //gana el usuario
                    /*
                    Oponente.setText("Oponente: Papel.");
                    Tu.setText("Tu: Piedra");
                    */
                    Resultado.setText("LOSE");
                    ganaOp.setText(String.valueOf(Integer.parseInt(ganaOp.getText().toString()) + 1));
                    ganoOperdio(Integer.parseInt(ganaOp.getText().toString()), "PERDIDO");
                    logo.setImageResource(R.drawable.picpapelr);
                    logo.setVisibility(View.VISIBLE);
                    varios();
                    time.cancel();
                } else if (oponente == 3) {
                    //pierde el usuario
                    /*
                    Oponente.setText("Oponente: Tijera");
                    Tu.setText("Tu: Piedra");
                    */
                    Resultado.setText("WIN");
                    ganaTu.setText(String.valueOf(Integer.parseInt(ganaTu.getText().toString()) + 1));
                    ganoOperdio(Integer.parseInt(ganaTu.getText().toString()), "GANADO");
                    logo.setImageResource(R.drawable.pictijerar);
                    logo.setVisibility(View.VISIBLE);
                    varios();
                    time.cancel();
                } else {
                    //empates
                    /*
                    Oponente.setText("Oponente: Piedra");
                    Tu.setText("Tu: Piedra");
                    */
                    Resultado.setText("Empate");
                    logo.setImageResource(R.drawable.picpiedrar);
                    logo.setVisibility(View.VISIBLE);
                    Nuevo.setEnabled(true);
                    varios();
                    time.cancel();
                }
                Papel.setVisibility(View.GONE);
                Tijera.setVisibility(View.GONE);
            }
        });

        Papel.setOnClickListener(new View.OnClickListener() {//papel es 2
            @Override
            public void onClick(View v) {
                double oponente = aleatorio();
                if (oponente == 2) {
                    //gana el usuario
                    /*
                    Oponente.setText("Oponente: Papel");
                    Tu.setText("Tu: Papel");
                    */
                    Resultado.setText("Empate");
                    logo.setImageResource(R.drawable.picpapelr);
                    logo.setVisibility(View.VISIBLE);
                    Nuevo.setEnabled(true);
                    varios();
                    time.cancel();
                } else if (oponente == 3) {
                    //pierde el usuario
                    /*
                    Oponente.setText("Oponente: Tijera");
                    Tu.setText("Tu: Papel");
                    */
                    Resultado.setText("LOSE");
                    ganaOp.setText(String.valueOf(Integer.parseInt(ganaOp.getText().toString()) + 1));
                    ganoOperdio(Integer.parseInt(ganaOp.getText().toString()), "PERDIDO");
                    logo.setImageResource(R.drawable.pictijerar);
                    logo.setVisibility(View.VISIBLE);
                    varios();
                    time.cancel();
                } else {
                    //empates
                    /*
                    Oponente.setText("Oponente: Piedra");
                    Tu.setText("Tu: Papel");
                    */
                    Resultado.setText("WIN");
                    ganaTu.setText(String.valueOf(Integer.parseInt(ganaTu.getText().toString()) + 1));
                    ganoOperdio(Integer.parseInt(ganaTu.getText().toString()), "GANADO");
                    logo.setImageResource(R.drawable.picpiedrar);
                    logo.setVisibility(View.VISIBLE);
                   varios();
                    time.cancel();
                }
                Piedra.setVisibility(View.GONE);
                Tijera.setVisibility(View.GONE);
            }
        });

        Tijera.setOnClickListener(new View.OnClickListener() {//Tijera es 3
            @Override
            public void onClick(View v) {
                double oponente = aleatorio();
                if (oponente == 2) {
                    //gana el usuario
                    /*
                    Oponente.setText("Oponente: Papel");
                    Tu.setText("Tu: Tijera");
                    */
                    Resultado.setText("WIN");
                    ganaTu.setText(String.valueOf(Integer.parseInt(ganaTu.getText().toString()) + 1));
                    ganoOperdio(Integer.parseInt(ganaTu.getText().toString()), "GANADO");
                    logo.setImageResource(R.drawable.picpapelr);
                    logo.setVisibility(View.VISIBLE);
                    varios();
                    time.cancel();
                } else if (oponente == 3) {
                    //pierde el usuario
                    /*
                    Oponente.setText("Oponente: Tijera");
                    Tu.setText("Tu: Tijera");
                    */
                    Resultado.setText("Empate");
                    logo.setImageResource(R.drawable.pictijerar);
                    logo.setVisibility(View.VISIBLE);
                    varios();
                    Nuevo.setEnabled(true);
                    time.cancel();
                } else {
                    //empates
                    /*
                    Oponente.setText("Oponente: Piedra");
                    Tu.setText("Tu: Tijera");
                    */
                    Resultado.setText("LOSE");
                    ganaOp.setText(String.valueOf(Integer.parseInt(ganaOp.getText().toString()) + 1));
                    ganoOperdio(Integer.parseInt(ganaOp.getText().toString()), "PERDIDO");
                    logo.setImageResource(R.drawable.picpiedrar);
                    logo.setVisibility(View.VISIBLE);
                    varios();
                    time.cancel();
                }
                Papel.setVisibility(View.GONE);
                Piedra.setVisibility(View.GONE);
            }
        });

        Nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numeros.setVisibility(View.VISIBLE);
                Piedra.setEnabled(true);
                Papel.setEnabled(true);
                Tijera.setEnabled(true);
                Piedra.setVisibility(View.VISIBLE);
                Papel.setVisibility(View.VISIBLE);
                Tijera.setVisibility(View.VISIBLE);
                logo.setVisibility(View.INVISIBLE);

                Resultado.setText("GanaOPierde");

                Nuevo.setEnabled(false);
                time.start();
            }
        });
    }

    double aleatorio () {
        double numero =  Math.floor((Math.random() * 3) + 1);
        return numero;

    };

    void varios(){
       // numeros.setVisibility(View.GONE);
        Piedra.setEnabled(false);
        Papel.setEnabled(false);
        Tijera.setEnabled(false);

    }

    void ganoOperdio(int n,String tipo){
        if (n>=3){
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            "Has" + tipo + "el Juego", Toast.LENGTH_SHORT);

            toast1.show();
            Nuevo.setEnabled(false);
        }else{
            Nuevo.setEnabled(true);
        }
    }
}
