package com.example.examen_ut02;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

/*
Autor: Juan Francisco Sánchez González
Fecha: 24/01/2024
Clase: Fragment con un Textview y un Switch . El texto tendrá 2 colores o 2 estados y al pulsar el
switch para cambiar de estado se cambiará el color del texto.
*/

public class TercerFragmento extends Fragment {

    Switch sw;
    TextView text;

    public TercerFragmento() {
        // Requiere constructor público vacío
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tercer_fragmento, container, false);

        // Instanciamos componentes
        sw = (Switch) view.findViewById(R.id.switch1);
        text = (TextView) view.findViewById(R.id.textView);

        // Listener Switch
        sw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sw.isChecked()) {
                    text.setTextColor(Color.BLUE);
                } else {
                    text.setTextColor(Color.RED);
                }
            }
        });

        return view;
    }
}