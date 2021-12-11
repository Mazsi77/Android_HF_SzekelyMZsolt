package com.example.hf6;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.app.Fragment;
import android.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;

public class Fragment1 extends Fragment {

    protected static final String FRAG2 = "2";

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

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        Context c = getActivity().getApplicationContext();
        View vw = inflater.inflate(R.layout.fragment_1, container, false);

        lista = vw.findViewById(R.id.lista);
        Log.w("lista", Boolean.toString(lista == null));
        CustomListViewAdapter adapter = new CustomListViewAdapter(getActivity(), currencies);
        lista.setAdapter(adapter);

        final FragmentManager fragmentManager = getFragmentManager();
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                if(fragmentManager.findFragmentByTag(FRAG2)!=null){
                    TextView currency = getActivity().findViewById(R.id.currency2);
                    TextView currencyName = getActivity().findViewById(R.id.currencyName2);
                    TextView buy = getActivity().findViewById(R.id.buy2);
                    TextView sell = getActivity().findViewById(R.id.sell2);
                    ImageView zaszlo = getActivity().findViewById(R.id.kep2);


                    currency.setText(currencies[position].getCurrencyShort());
                    currencyName.setText(currencies[position].getCurrencyName());
                    buy.setText(Double.toString(currencies[position].getBuy()));
                    sell.setText(Double.toString(currencies[position].getSell()));
                    zaszlo.setImageResource(currencies[position].getImage());
                } else {
                    Intent intent = new Intent(getActivity().getApplicationContext(),  ShowItemActivity.class);
                    intent.putExtra("currency", currencies[position]);
                    startActivity(intent);
                }
            }
        });
        return vw;
    }
}