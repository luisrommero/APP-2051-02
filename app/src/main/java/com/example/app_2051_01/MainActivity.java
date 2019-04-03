package com.example.app_2051_01;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public Button BtnSimple;
    public ImageButton BtnImage;
    public Button BtnSimpleConImagen;
    public TextView LblMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnSimple = (Button) findViewById(R.id.BtnSimple);
        BtnImage = (ImageButton) findViewById(R.id.BtnImage);
        BtnSimpleConImagen = (Button) findViewById(R.id.BtnSimpleConImagen);
        LblMensaje = (TextView)findViewById(R.id.LblMensaje);

        View.OnClickListener Escuchador = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Acción a realizar
                LblMensaje.setText("HOLA, acaban de dar clic en el botón!" + v.getId());
            }
        };

        BtnSimple.setOnClickListener(Escuchador);
        BtnImage.setOnClickListener(Escuchador);
        BtnSimpleConImagen.setOnClickListener(Escuchador);

    }

}
