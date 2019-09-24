package com.example.firebaseauth.CATEGORIES;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.firebaseauth.R;

public class CategoriesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private CategoriesAdapter catsAdapter;

    private int[] cats= {
            R.drawable.furniture,
            R.drawable.boutique,
            R.drawable.cosmetics,
            R.drawable.cutlery,
            R.drawable.groceries,
            R.drawable.kitchen,
            R.drawable.milk,
            R.drawable.shopping,
            R.drawable.supermarkets };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        recyclerView = findViewById(R.id.activity_categories_recycler_view);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        catsAdapter= new CategoriesAdapter(cats);
        recyclerView.setAdapter(catsAdapter);

    }
}
