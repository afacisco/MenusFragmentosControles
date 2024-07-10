package com.example.examen_ut02;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

/*
Autor: Juan Francisco Sánchez González
Fecha: 24/01/2024
Clase: Fragment que al pulsar el botón se muestra mensaje con la puntuación pulsada por el usuario
en el RatingBar.
*/

public class PrimerFragmento extends Fragment {

    RatingBar rb;
    Button btn;

    public PrimerFragmento() {
        // Requiere constructor público vacío
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.primer_fragmento, container, false);

        // Instanciamos controles vista
        rb = (RatingBar) view.findViewById(R.id.ratingBar);
        btn = (Button) view.findViewById(R.id.button);

        // Listener botón
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Puntuación: " + String.valueOf(rb.getRating()), Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}
