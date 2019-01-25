package com.example.deepjyoti.sayitoutv1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> articleNames = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapter(ArrayList<String> articleNames, Context context) {
        this.articleNames = articleNames;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        holder.article_name.setText(articleNames.get(position));

        holder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on"+articleNames.get(position));
                // Toast.makeText(context, articleNames.get(position), Toast.LENGTH_SHORT).show();
                Snackbar.make(view, articleNames.get(position), Snackbar.LENGTH_SHORT).setAction("Action", null).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return articleNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView article_name;
        RelativeLayout parent_layout;
        public ViewHolder(View itemView) {
            super(itemView);
            article_name = itemView.findViewById(R.id.article_name);
            parent_layout = itemView.findViewById(R.id.parent_layout);

        }
    }
}
