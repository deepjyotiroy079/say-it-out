package com.example.deepjyoti.sayitoutv1;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;
import android.view.Menu;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // private static final String ARTICLE_URL = "http://192.168.225.46/SayitOutv1/includes/DbOperations.php";
    private static final String ARTICLE_URL = "http://djr-android-online.000webhostapp.com/includes/DbOperations.php";
    private static final String TAG = "MainActivity";

    // creating array lists of the article name
    private ArrayList<Article> articleList = new ArrayList<Article>();
    RecyclerView recyclerView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
        } else if(item.getItemId() == R.id.admin) {
            Toast.makeText(this, "This is the admin panel", Toast.LENGTH_SHORT).show();
        } else {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }

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
        // articleList = new ArrayList<>();

        // articleList.add(new Article("Article1", "This is my first article", 1548416901));
        // articleList.add(new Article("Article2", "This is my second article", 1548416903));
        StringRequest stringRequest = new StringRequest(Request.Method.GET, ARTICLE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);

                    for(int i=0;i<array.length();i++) {
                        JSONObject article = array.getJSONObject(i);
                        articleList.add(new Article(article.getString("article_title"), article.getString("article_content")));
                    }
                    RecyclerViewAdapter adapter = new RecyclerViewAdapter(articleList, MainActivity.this);
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        Volley.newRequestQueue(this).add(stringRequest);

    }

}
