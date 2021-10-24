package com.example.feladat1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomListViewAdapter extends ArrayAdapter {
    private final Activity context;

    private final Currency[] currencies;

    public CustomListViewAdapter( Activity context, Currency[] currencies){
        super(context, R.layout.listaelem, currencies);
        this.context = context;
        this.currencies = currencies;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listaelem, null, true);

        TextView currency = rowView.findViewById(R.id.currency);
        TextView currencyName = rowView.findViewById(R.id.currencyName);
        TextView buy = rowView.findViewById(R.id.buy);
        TextView sell = rowView.findViewById(R.id.sell);
        ImageView zaszlo = rowView.findViewById(R.id.kep);

        currency.setText(currencies[position].getCurrencyShort());
        currencyName.setText(currencies[position].getCurrencyName());
        buy.setText(Double.toString(currencies[position].getBuy()));
        sell.setText(Double.toString(currencies[position].getSell()));
        zaszlo.setImageResource(currencies[position].getImage());

        return rowView;
    }
}
