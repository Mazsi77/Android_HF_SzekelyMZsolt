package com.example.feladat1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Currency[] currencies = {
            new Currency("EUR", "Euro", 4.4100,4.5500,R.drawable.eur),
            new Currency("USD", "Dolar american", 3.9750,4.1450,R.drawable.usa),
            new Currency("GBP", "Lisra sterlina", 6.1250,6.3550, R.drawable.uk),
            new Currency("AUD", "Dolar australian", 2.9600,3.0600,R.drawable.australia),
            new Currency("CAD", "Dolar Canadian", 3.0950,3.2650,R.drawable.canada),
            new Currency("CHF", "Franc elvetian", 4.2300,4.3300,R.drawable.switzerland),
            new Currency("DKK", "Corona daneza", 0.5850,0.6150,R.drawable.denmark),
            new Currency("EUR", "Forint maghiar", 0.0136,0.0146,R.drawable.hungary)
    };

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.lista);
        CustomListViewAdapter adapter = new CustomListViewAdapter(this, currencies);
        lista.setAdapter(adapter);

    }
}