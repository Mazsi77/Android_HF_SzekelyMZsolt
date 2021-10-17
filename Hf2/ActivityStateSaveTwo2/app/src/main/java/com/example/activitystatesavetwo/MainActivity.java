package com.example.activitystatesavetwo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText text;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.editText);
        checkBox = findViewById(R.id.checkBox);

        if(savedInstanceState != null){
            text.setText(savedInstanceState.getString("editText"));
            checkBox.setChecked(savedInstanceState.getBoolean("checkBox"));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("editText", text.getText().toString());
        outState.putBoolean("checkBox", checkBox.isChecked());
    }
}