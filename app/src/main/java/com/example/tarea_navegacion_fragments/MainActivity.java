package com.example.tarea_navegacion_fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.barra_navegacion);
        Menu menu = bottomNavigationView.getMenu();
        menu.add(Menu.NONE, 1, Menu.NONE, "Rojo").setIcon(R.drawable.casa);
        menu.add(Menu.NONE, 2, Menu.NONE, "Azul").setIcon(android.R.drawable.ic_menu_my_calendar);
        menu.add(Menu.NONE, 3, Menu.NONE, "Verde").setIcon(android.R.drawable.ic_menu_send);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                int id = item.getItemId();
                Fragmento1 fragmento1 = null;
                Fragmento2 fragmento2 = null;
                Fragmento3 fragmento3 = null;

                switch (id) {
                    case 1:
                        fragmento1 = new Fragmento1();
                        fragmentTransaction.replace(R.id.fragmentContainerView2, fragmento1);
                        break;
                    case 2:
                        fragmento2 = new Fragmento2();
                        fragmentTransaction.replace(R.id.fragmentContainerView2, fragmento2);
                        break;
                    case 3:
                        fragmento3 = new Fragmento3();
                        fragmentTransaction.replace(R.id.fragmentContainerView2, fragmento3);
                        break;
                    default:
                        return false;
                    }
                fragmentTransaction.commitAllowingStateLoss();

                return true;
                }
            });

        }
}