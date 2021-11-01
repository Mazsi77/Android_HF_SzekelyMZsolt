package com.example.hf5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    ArrayAdapter<String> adapter;
    ArrayList<String> arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arr = new ArrayList<String>(Arrays.asList("a", "c", "b", "d", "e"));

        lista = findViewById(R.id.lista);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr);
        registerForContextMenu(lista);
        lista.setAdapter(adapter);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context, menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option, menu);
        return true;
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo contextInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        TextView textView = (TextView) contextInfo.targetView;

        int color;
        switch (item.getItemId()) {
            case R.id.piros:
                color = Color.RED;
                break;
            case R.id.zold:
                color = Color.GREEN;
                break;
            case R.id.sarga:
                color = Color.YELLOW;
                break;
            default:
                return false;
        }

        textView.setTextColor(color);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.rendez:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    arr.sort(String::compareToIgnoreCase);
                }
                adapter.notifyDataSetChanged();
                break;
            case R.id.torol:
                arr.clear();
                adapter.notifyDataSetChanged();
                break;
            default:
                return false;
        }
        return true;
    }
}