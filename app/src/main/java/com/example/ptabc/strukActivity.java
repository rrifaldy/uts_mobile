package com.example.ptabc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.w3c.dom.Text;

public class strukActivity extends AppCompatActivity {
    Calendar calendar;
    EditText bayar;
    TextView textView;
    int hari,bulan,tahun;
    Button btnBayar,btnKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_struk);

        Calendar calendar = Calendar.getInstance();
        hari = calendar.get(Calendar.DAY_OF_MONTH);
        bulan = calendar.get(Calendar.MONTH)+1;
        tahun = calendar.get(Calendar.YEAR);

        String finalTanggal = hari+"-"+bulan+"-"+tahun;

        textView = findViewById(R.id.txtDate);
        textView.setText(finalTanggal);


        TextView sub = findViewById(R.id.tampilSub);
        TextView tot = findViewById(R.id.tampilTotal);
        TextView data = findViewById(R.id.data);
        TextView subtotal = findViewById(R.id.subtotal);
        TextView total = findViewById(R.id.total);
        Intent intent = getIntent();

        int subb = intent.getIntExtra("Subtotal", 0);
        int tott = intent.getIntExtra("Total", 0);
        sub.setText("Rp. " + subb);
        tot.setText("Rp. " + tott);

        int subtotal2 = intent.getIntExtra("Subtotal", 0);
        int total2 = intent.getIntExtra("Total", 0);
        subtotal.setText("Rp. " + subtotal2);
        total.setText("Rp. " + total2);

        String sum = intent.getStringExtra("teks");
        data.setText(sum);

        btnBayar = findViewById(R.id.bayar);
        btnBayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                int tott = intent.getIntExtra("Total", 0);
                EditText tampilBayar = findViewById(R.id.txtBayar);
                int text2 = Integer.parseInt(String.valueOf(tampilBayar.getText()));
                TextView bayar = findViewById(R.id.pembayar);
                bayar.setText("Rp. " + text2);
                EditText tampilNama = findViewById(R.id.txtNama);
                String text = tampilNama.getText().toString();
                TextView nama = findViewById(R.id.nama);
                nama.setText(text);
                TextView datee = findViewById(R.id.tanggal);
                datee.setText(finalTanggal);
                int bayarr = 0;
                bayarr = (int) (text2);
                if (bayarr >= tott){
                    ScrollView svv = (ScrollView)findViewById(R.id.sv);
                    svv.scrollTo(0, svv.getBottom());
                }
                else{
                    Toast.makeText(getApplicationContext(), "Jumlah Tunai Harus Sama Dengan Atau Melebihi Total Pembayaran", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnKembali = findViewById(R.id.kembali);
        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText tampilNama = findViewById(R.id.txtNama);
                tampilNama.setText("");
                EditText tampilBayar = findViewById(R.id.txtBayar);
                tampilBayar.setText("");
                TextView datee = findViewById(R.id.tanggal);
                datee.setText(finalTanggal);
                Intent i = new Intent(strukActivity.this,pesanActivity.class);
                startActivity(i);
            }
        });
    }
}