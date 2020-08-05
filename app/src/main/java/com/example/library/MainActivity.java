package com.example.library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.library.models.BooksDes;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private BookAdapter adapter;
    private ArrayList<BooksDes> card = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createRecView();
    }

    private void createRecView() {
        RecyclerView recyclerView=findViewById(R.id.rec_view_book_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
adapter=new BookAdapter(card);
recyclerView.setAdapter(adapter);
    }
}