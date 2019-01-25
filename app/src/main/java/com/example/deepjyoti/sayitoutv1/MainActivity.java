package com.example.deepjyoti.sayitoutv1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    // creating array lists of the article name
    private ArrayList<String> articleNames = new ArrayList<>();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: started");


        initArticles();
    }
    private void initArticles() {
        Log.d(TAG, "initArticles: preparing article names");
        articleNames.add("Hello world");
        articleNames.add("First Article");
        articleNames.add("Article 2");
        articleNames.add("Article 3");
        articleNames.add("Article 4");
        articleNames.add("Article 5");
        articleNames.add("Article 6");
        articleNames.add("Article 7");
        articleNames.add("Article 8");
        articleNames.add("Article 9");
        articleNames.add("Article 10");
        articleNames.add("Article 11");
        articleNames.add("Article 12");

        initRecyclerView();
    }
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: recycler view initialized");
        //getting the refference of the recycler view
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(articleNames, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
