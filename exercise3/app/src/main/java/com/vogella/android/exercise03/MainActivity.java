package com.vogella.android.exercise03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter starksAdapter;
    private RecyclerView.Adapter lanistersAdapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button starks_button = (Button) findViewById(R.id.button1);
        final Button lanisters_button = (Button) findViewById(R.id.button2);
        starks_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                recyclerView.setAdapter(starksAdapter);
            }
        });
        lanisters_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                recyclerView.setAdapter(lanistersAdapter);
            }
        });
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        List<String> starks = new ArrayList<>();
        List<String> lanisters = new ArrayList<>();
        starks.add("Eddard Stark");
        starks.add("Rickard Stark");
        starks.add("Brandon Stark");
        starks.add("Catelyn Stark");
        starks.add("Robb Stark");
        starks.add("Sansa Stark");
        starks.add("Arya Stark");
        starks.add("Lyanna Stark");
        starks.add("Jon Snow");
        starks.add("Benjen Stark");
        lanisters.add("Tywin Lannister");
        lanisters.add("Joanna Lannister");
        lanisters.add("Tytos Lannister");
        lanisters.add("Tywin Lannister");
        lanisters.add("Cersei Baratheon");
        lanisters.add("Jaime Lannister");
        lanisters.add("Tyrion Lannister");
        lanisters.add("Robert Baratheon");
        lanisters.add("Joffrey Baratheon");
        lanisters.add("Myrcella Baratheon");
        lanisters.add("Tommen Baratheon");

        starksAdapter = new MyAdapter(starks);
        lanistersAdapter = new MyAdapter(lanisters);
    }
}
