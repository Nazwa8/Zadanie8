package com.example.zadanie8;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView emailTekst;
    TextView hasloTekst;
    Button przycisk;
    TextView komunikat;
    TextView imie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailTekst = findViewById(R.id.email);
        hasloTekst = findViewById(R.id.haslo);
        przycisk = findViewById(R.id.przycisk);
        komunikat = findViewById(R.id.komunikatPole);
        imie = findViewById(R.id.imie);

        komunikat.setTextColor(Color.GRAY);
        komunikat.setText("Witaj! Aplikacja wykonana przez: Mateusz Skowron");
        imie.setText("Mateusz Skowron 4TP");

        przycisk.setOnClickListener(v -> {
            showCustomDialog();
            emailTekst.setText("");
            hasloTekst.setText("");
        });
    }


    private void showCustomDialog(){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);

        EditText wpisantEmail = dialog.findViewById(R.id.nowyEmail);
        Button btnSubmit = dialog.findViewById(R.id.btnSubmitEmail);
        Button btnCancel = dialog.findViewById(R.id.btnCancel);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputEmail = wpisantEmail.getText().toString().trim(); // trim() usuwa białe znaki

                if (!inputEmail.contains("@")){
                    dialog.dismiss();
                    komunikat.setTextColor(Color.RED);
                    komunikat.setText("Błąd: Nieprawidłowy format emaila.");
                }else{
                    dialog.dismiss();
                    showCustomDialog2();
                    emailTekst.setText(inputEmail);
                    komunikat.setTextColor(Color.GREEN);
                    komunikat.setText("Profil zaktualizowany! Nowy email: " + inputEmail);
                }
            }
        });



        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // zamykanie
                komunikat.setTextColor(Color.GRAY);
                komunikat.setText("Edycja profilu anulowana.");
                dialog.dismiss();
            }
        });

            dialog.show();

         Window window = dialog.getWindow();
         if (window != null) {
             window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
         }
    }


    private void showCustomDialog2(){
        final Dialog dialog2 = new Dialog(this);
        dialog2.setContentView(R.layout.custom_dialog_password);

        EditText wpisaneHaslo = dialog2.findViewById(R.id.noweHaslo);
        EditText powHaslo = dialog2.findViewById(R.id.powNowe_Haslo);
        Button btnSubmit2 = dialog2.findViewById(R.id.btnSubmitPassword);
        Button btnCancel2 = dialog2.findViewById(R.id.btnCancel2);

        //zapisz
        btnSubmit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputPassword = wpisaneHaslo.getText().toString().trim(); // trim() usuwa białe znaki
                String repeatPassword = powHaslo.getText().toString().trim();
                if (!inputPassword.equals(repeatPassword)){
                    dialog2.dismiss();
                    komunikat.setTextColor(Color.RED);
                    komunikat.setText("Błąd: Hasła nie pasują do siebie.");
                }else{
                    dialog2.dismiss();
                    hasloTekst.setText(inputPassword);

                }
            }
        });

        //anuluj
        btnCancel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // zamykanie
                komunikat.setTextColor(Color.GRAY);
                komunikat.setText("Edycja profilu anulowana.");
                dialog2.dismiss();
            }
        });

        dialog2.show();

         Window window = dialog2.getWindow();
         if (window != null) {
             window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
         }

    } // koniec dialogu 2

}
