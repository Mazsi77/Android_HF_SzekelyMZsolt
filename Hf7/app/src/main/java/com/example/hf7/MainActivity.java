package com.example.hf7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Animal> animals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animals = Arrays.asList(
                new Animal("Octopus","8 tentacled monster",R.drawable.cat),
                new Animal("Pig","Delicious in rolls",R.drawable.disznyo),
                new Animal("Sheep","Great for jumpers",R.drawable.giraffe),
                new Animal("Rabbit","Nice in a stew",R.drawable.horse),
                new Animal("Snake","Great for shoes",R.drawable.lion),
                new Animal("Spider","Scary",R.drawable.rabbit),
                new Animal("Spider","8 tentacled monster",R.drawable.sheep),
                new Animal("Spider","Scary",R.drawable.rabbit),
                new Animal("Spider","Scary",R.drawable.rabbit),
                new Animal("Spider","Scary",R.drawable.rabbit)
        );

        RecyclerView rvAnimals = findViewById(R.id.recycleView);
        rvAnimals.setHasFixedSize(true);
        rvAnimals.setLayoutManager(new LinearLayoutManager(this));
        AnimalsAdapter adapter = new AnimalsAdapter(this, animals);
        rvAnimals.setAdapter(adapter);
    }
}