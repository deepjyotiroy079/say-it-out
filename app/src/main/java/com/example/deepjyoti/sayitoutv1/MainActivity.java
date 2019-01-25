package com.example.deepjyoti.sayitoutv1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // private static final String ARTICLE_URL = "http://192.168.225.46/SayitOutv1/includes/DbOperations.php";
    private static final String TAG = "MainActivity";

    // creating array lists of the article name
    private ArrayList<Article> articleList = new ArrayList<Article>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: started");
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        initArticles();
    }
    private void initArticles() {
        articleList = new ArrayList<>();

        articleList.add(new Article("Article1", "This is my first article", 1548416901));
        articleList.add(new Article("Article2", "This is my second article", 1548416903));

        initRecyclerView();
    }
    private void initRecyclerView() {
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(articleList, this);
        recyclerView.setAdapter(adapter);
    }


}
