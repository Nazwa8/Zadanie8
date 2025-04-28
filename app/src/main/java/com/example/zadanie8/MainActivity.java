package com.example.zadanie8;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView emailTekst;
    TextView hasloTekst;
    Button przycisk;
    TextView okno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailTekst = findViewById(R.id.email);
        hasloTekst = findViewById(R.id.haslo);
        przycisk = findViewById(R.id.przycisk);
        okno = findViewById(R.id.oknoDialogowe);

        okno.setTextColor(Color.GRAY);
        okno.setText("Witaj! Aplikacja wykonana przez: Mateusz Skowron");

        przycisk.setOnClickListener(v -> {
            edycjaprofilu();
        });
    }

    public void edycjaprofilu(){

        TextView podajNoweHasloNapis = new TextView(this);
        podajNoweHasloNapis.setText("Podaj nowe hasło: ");
        TextView powtorzoneHasloNapis = new TextView(this);
        powtorzoneHasloNapis.setText("Powtórz hasło: ");

        EditText nowyEmail = new EditText(this);
        EditText noweHaslo = new EditText(this);
        EditText powNoweHaslo = new EditText(this);



    }
}
