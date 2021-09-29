package com.example.hf1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addBtn = findViewById(R.id.plusz);
        Button minusBtn = findViewById(R.id.minusz);
        Button multiBtn = findViewById(R.id.szorzas);
        Button divisionBtn = findViewById(R.id.osztas);

        Button[] buttons = {addBtn, minusBtn, multiBtn, divisionBtn};
        char[] operators = {'+', '-', '*', '/'};

        TextView resultView = findViewById(R.id.textView);

        for (int i=0; i<4; i++){
            int finalI = i;
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try{
                        float[] numbers = getValues();
                        float res = 0;
                        switch (operators[finalI]) {
                            case '+' :
                                res= numbers[0] + numbers[1];
                                break;
                            case '-' :
                                res= numbers[0] - numbers[1];
                                break;
                            case '/' :
                                if(numbers[1]==0) throw new Exception("Nem oszthatunk 0-val!");
                                res= numbers[0] / numbers[1];
                                break;
                            case '*' :
                                res= numbers[0] * numbers[1];
                        }
                        resultView.setText(Float.toString(res));
                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    private float[] getValues () throws Exception {
        EditText number1Text = findViewById(R.id.number1);
        EditText number2Text = findViewById(R.id.number2);

        String text1 = number1Text.getText().toString();
        String text2 = number2Text.getText().toString();

        if(text1.matches("")) throw new Exception("Üres bemenet az 1. mezőben");
        if(text2.matches("")) throw new Exception("Üres bemenet a 2. mezőben");

        float number1;
        float number2;

        try{
            number1 = Float.parseFloat(text1);
            number2 = Float.parseFloat(text2);
        }
        catch(Exception e) {
            throw new Exception("Hibás bemenet, kérjük csak számokat írjon");
        }
        float[] res= {number1, number2};
        return res;
    }



}