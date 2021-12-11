package com.example.hf6;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }
        setContentView(R.layout.fragment_2);
        Bundle extras = getIntent().getExtras();
        TextView currency = findViewById(R.id.currency2);
        TextView currencyName = findViewById(R.id.currencyName2);
        TextView buy = findViewById(R.id.buy2);
        TextView sell = findViewById(R.id.sell2);
        ImageView zaszlo = findViewById(R.id.kep2);



        if (extras != null) {
            Currency selected = (Currency) extras.get("currency");
            currency.setText(selected.getCurrencyShort());
            currencyName.setText(selected.getCurrencyName());
            buy.setText(Double.toString(selected.getBuy()));
            sell.setText(Double.toString(selected.getSell()));
            zaszlo.setImageResource(selected.getImage());

        }
    }
}