package com.example.ptabc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class pesanActivity extends AppCompatActivity {
    Button btnPesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pesan);

        final CheckBox honey = findViewById(R.id.honey);
        final CheckBox burger = findViewById(R.id.burger);
        final CheckBox fries = findViewById(R.id.fries);

        final CheckBox ice = findViewById(R.id.ice);
        final CheckBox oreo = findViewById(R.id.oreo);
        final CheckBox fanta = findViewById(R.id.fanta);

        final EditText jmlHoney = findViewById(R.id.jmlHoney);
        final EditText jmlBurger = findViewById(R.id.jmlBurger);
        final EditText jmlFries = findViewById(R.id.jmlFries);

        final EditText jmlIce = findViewById(R.id.jmlIce);
        final EditText jmlOreo = findViewById(R.id.jmlOreo);
        final EditText jmlFanta = findViewById(R.id.jmlFanta);


        final int hargaHoney = 35000;
        final int hargaBurger = 30000;
        final int hargaFries = 25000;

        final int hargaIce = 10000;
        final int hargaOreo = 18000;
        final int hargaFanta = 15000;

        btnPesan = findViewById(R.id.pesan);
        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = "";
                double pajak = 0.10;
                int total = 0;
                int kembalian = 0;
                int subtotal = 0;
                if(honey.isChecked()){
                    String hasil = "Honey Garlic Chicken Rice";
                    int jml = Integer.parseInt(String.valueOf(jmlHoney.getText()));
                    int subtotal1 = hargaHoney * jml;
                    subtotal = subtotal + subtotal1;
                    text += jml + "\t\t" + hasil + "\t\t\t\t\t\t\t\t\t" + "Rp. " + subtotal1 + "\n\n";
                    total = (int) (total + subtotal1 * pajak + subtotal1);
                }
                if(burger.isChecked()){
                    String hasil = "Beef Burger";
                    int jml = Integer.parseInt(String.valueOf(jmlBurger.getText()));
                    int subtotal1 = hargaBurger * jml;
                    subtotal = subtotal + subtotal1;
                    text += jml + "\t\t" + hasil + "\t\t\t\t\t\t\t\t\t" + "Rp. " + subtotal1 + "\n\n";
                    total = (int) (total + subtotal1 * pajak + subtotal1);
                }
                if(fries.isChecked()){
                    String hasil = "Regular Fries";
                    int jml = Integer.parseInt(String.valueOf(jmlFries.getText()));
                    int subtotal1 = hargaFries * jml;
                    subtotal = subtotal + subtotal1;
                    text += jml + "\t\t" + hasil + "\t\t\t\t\t\t\t\t\t" + "Rp. " + subtotal1 + "\n\n";
                    total = (int) (total + subtotal1 * pajak + subtotal1);
                }
                if(ice.isChecked()){
                    String hasil = "Ice Cream Cone";
                    int jml = Integer.parseInt(String.valueOf(jmlIce.getText()));
                    int subtotal1 = hargaIce * jml;
                    subtotal = subtotal + subtotal1;
                    text += jml + "\t\t" + hasil + "\t\t\t\t\t\t\t\t\t" + "Rp. " + subtotal1 + "\n\n";
                    total = (int) (total + subtotal1 * pajak + subtotal1);
                }
                if(oreo.isChecked()){
                    String hasil = "Flurry Oreo";
                    int jml = Integer.parseInt(String.valueOf(jmlOreo.getText()));
                    int subtotal1 = hargaOreo * jml;
                    subtotal = subtotal + subtotal1;
                    text += jml + "\t\t" + hasil + "\t\t\t\t\t\t\t\t\t" + "Rp. " + subtotal1 + "\n\n";
                    total = (int) (total + subtotal1 * pajak + subtotal1);
                }
                if(fanta.isChecked()){
                    String hasil = "Fanta Float";
                    int jml = Integer.parseInt(String.valueOf(jmlFanta.getText()));
                    int subtotal1 = hargaFanta * jml;
                    subtotal = subtotal + subtotal1;
                    text += jml + "\t\t" + hasil + "\t\t\t\t\t\t\t\t\t" + "Rp. " + subtotal1 + "\n\n";
                    total = (int) (total + subtotal1 * pajak + subtotal1);
                }

                Intent i = new Intent(pesanActivity.this,strukActivity.class);
                i.putExtra("teks", text);
                i.putExtra("Subtotal", subtotal);
                i.putExtra("Total", total);
                honey.setChecked(false);
                burger.setChecked(false);
                fries.setChecked(false);
                ice.setChecked(false);
                oreo.setChecked(false);
                fanta.setChecked(false);
                startActivity(i);
            }
        });
    }
}