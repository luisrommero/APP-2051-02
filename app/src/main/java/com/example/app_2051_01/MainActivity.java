package com.example.app_2051_01;

import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.RadioAccessSpecifier;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public Button BtnSimple;
    public ToggleButton BtnToggle;
    public Switch BtnSwitch;
    public ImageButton BtnImage;
    public Button BtnSimpleConImagen;
    public TextView LblMensaje;
    public  CheckBox ChkQueso;
    public CheckBox ChkJamon;
    public CheckBox ChkPina;
    public RadioGroup RdoGroup;
    public RadioButton RbOpcionNormal;
    public RadioButton RbOpcionSarten;
    public RadioButton RbOpcionOrillaDeQueso;
    public Button BtnProcesarIngredientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnSimple = (Button) findViewById(R.id.BtnSimple);
        BtnToggle = (ToggleButton) findViewById(R.id.BtnToggle);
        BtnSwitch = (Switch) findViewById(R.id.BtnSwitch);
        BtnImage = (ImageButton) findViewById(R.id.BtnImage);
        BtnSimpleConImagen = (Button) findViewById(R.id.BtnSimpleConImagen);
        LblMensaje = (TextView)findViewById(R.id.LblMensaje);
        ChkQueso = (CheckBox) findViewById(R.id.ChkQueso);
        ChkJamon = (CheckBox)findViewById(R.id.ChkJamon);
        ChkPina = (CheckBox)findViewById(R.id.ChkPina);
        RdoGroup = (RadioGroup) findViewById(R.id.RdoGroup);
        RbOpcionNormal = (RadioButton) findViewById(R.id.RbOpcionNormal);
        RbOpcionSarten = (RadioButton) findViewById(R.id.RbOpcionSarten);
        RbOpcionOrillaDeQueso = (RadioButton) findViewById(R.id.RbOpcionOrillaDeQueso);
        BtnProcesarIngredientes = (Button)findViewById(R.id.BtnProcesarIngredientes);

        View.OnClickListener EscuchadorClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(v instanceof CompoundButton)
                {
                    LblMensaje.setText((((CompoundButton)v).isChecked()) ? "ENCENDIDO" : "APAGADO");
                }
                else LblMensaje.setText("HOLA, acaban de dar clic en el botón!" + v.getId());
            }
        };

        BtnSimple.setOnClickListener(EscuchadorClick);
        BtnToggle.setOnClickListener(EscuchadorClick);
        BtnSwitch.setOnClickListener(EscuchadorClick);
        BtnImage.setOnClickListener(EscuchadorClick);
        BtnSimpleConImagen.setOnClickListener(EscuchadorClick);

        View.OnClickListener ProcesarIngredientesListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Mensaje = "Mi pizza tiene: ";
                Mensaje += (ChkQueso.isChecked() ? ", " + ChkQueso.getText() : "");
                Mensaje += (ChkJamon.isChecked() ? ", " + ChkJamon.getText() : "");
                Mensaje += (ChkPina.isChecked() ? ", " + ChkPina.getText() : "");

                int IdRadioButton = RdoGroup.getCheckedRadioButtonId();

                if(IdRadioButton == -1) LblMensaje.setText("Debe seleccionar un tipo de masa.");
                else
                {
                    switch (IdRadioButton)
                    {
                        case R.id.RbOpcionNormal:
                            Mensaje += ". con MASA NORMAL.";
                            break;
                        case R.id.RbOpcionSarten:
                            Mensaje += ". con MASA DE SARTÉN.";
                            break;
                        case R.id.RbOpcionOrillaDeQueso:
                            Mensaje += ". con ORILLA RELLENA DE QUESO.";
                            break;
                    }
                    LblMensaje.setText(Mensaje);
                }
            }
        };

        BtnProcesarIngredientes.setOnClickListener(ProcesarIngredientesListener);

        RadioGroup.OnCheckedChangeListener ListenerRadioGroup = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int IdRadioButton = group.getCheckedRadioButtonId();
                for (int i = 0; i < RdoGroup.getChildCount(); i++)
                {
                    View o = RdoGroup.getChildAt(i);
                    if (o instanceof RadioButton) {
                        if(IdRadioButton != o.getId()) o.setEnabled(false);
                    }
                }
            }
        };

        RdoGroup.setOnCheckedChangeListener(ListenerRadioGroup);




    }

}
