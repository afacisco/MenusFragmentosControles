package com.example.examen_ut02;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

/*
Autor: Juan Francisco Sánchez González
Fecha: 24/01/2024
Clase: Fragment con un AutoCompleteTextView para elegir alguna figura, se muestra mensaje con los lados
que tiene una de las 3 opciones posibles que se autocompletan: "Cuadrado", "Pentágono" y "Octógono". Si
se escribe otra cosa, saldrá mensaje con 0 lados.
*/

public class SegundoFragmento extends Fragment {

    Button btn;
    public SegundoFragmento() {
        // Requiere constructor público vacío
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.segundo_fragmento, container, false);

        // Adaptador simple con las opciones
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, COUNTRIES);

        // Componente AutoCompleteTextView, se le asigna el adaptador
        AutoCompleteTextView textView = (AutoCompleteTextView)
                view.findViewById(R.id.autoCompleteTextView);
        textView.setAdapter(adapter);

        // Componente botón con su listener
        btn = (Button) view.findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText().toString().equals(COUNTRIES[0])) {
                    Toast.makeText(getActivity(), "4 lados", Toast.LENGTH_LONG).show();
                } else if (textView.getText().toString().equals(COUNTRIES[1])) {
                    Toast.makeText(getActivity(), "5 lados", Toast.LENGTH_LONG).show();
                } else if (textView.getText().toString().equals(COUNTRIES[2])) {
                    Toast.makeText(getActivity(), "8 lados", Toast.LENGTH_LONG).show();
                } else {
                        Toast.makeText(getActivity(), "0 lados", Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }

    // Datos del adaptador (figuras)
    private static final String[] COUNTRIES = new String[] {
            "Cuadrado", "Pentágono", "Octógono"
    };

}
