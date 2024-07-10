package com.example.examen_ut02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

/*
Autor: Juan Francisco Sánchez González
Fecha: 24/01/2024
Clase: Actividad principal que contiene una Toolbar con la opción de salir de la aplicación. Y un menú
lateral NavigationView con 3 ítems para cambiar de fragmento. Se utilizan 3 fragmentos con 3 funcionalidades
distintas.
*/

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView nav;
    private Fragment fragmentInicio;
    private Fragment fragmentSegundo;
    private Fragment fragmentTercero;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Componente Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Instanciamos los 3 fragmentos y añadimos el 1º a la actividad utilizando la clase FragmentManager
        fragmentInicio = new PrimerFragmento();
        fragmentSegundo = new SegundoFragmento();
        fragmentTercero = new TercerFragmento();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor_fragment, fragmentInicio).commit();

        // Componente NavigatorDrawer
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        nav = (NavigationView) findViewById(R.id.nav_view);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.nav_item_one) {
                    // Reemplazamos el 1º fragmento en la actividad utilizando la clase FragmentManager
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_fragment, fragmentInicio).commit();
                } else if (item.getItemId() == R.id.nav_item_two) {
                    // Reemplazamos el 2º fragmento en la actividad utilizando la clase FragmentManager
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_fragment, fragmentSegundo).commit();
                } else if (item.getItemId() == R.id.nav_item_three) {
                    // Reemplazamos el 3º fragmento en la actividad utilizando la clase FragmentManager
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_fragment, fragmentTercero).commit();
                }
                // Close the navigation drawer when an item is selected
                item.setChecked(true);
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    // OptionsMenu de la ToolBar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options_act1, menu);
        return true;
    }

    // Listener OptionsMenu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Salir
        if (item.getItemId() == R.id.opcionSalir) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}