package com.example.library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.library.interfaces.OnBookClick;
import com.example.library.models.BooksDes;
import com.example.library.ui.description.BooksDescFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private BookAdapter adapter;
    private ArrayList<BooksDes> card = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createRecView();
    }

    private void createRecView() {
        recyclerView = findViewById(R.id.rec_view_book_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new BookAdapter(card);
        recyclerView.setAdapter(adapter );
        adapter.setInBookClickListener(new OnBookClick() {
            @Override
            public void onItemClick(int pos) {
                Bundle bundle=new Bundle();
                bundle.putSerializable("pos",card.get(pos));
                BooksDescFragment fragment =new BooksDescFragment();
                fragment.setArguments(bundle);
                Log.d("check", "fuck");
                getSupportFragmentManager().beginTransaction().add(R.id.container_fr,fragment).addToBackStack(null).commit();
                recyclerView.setVisibility(View.INVISIBLE);
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        recyclerView.setVisibility(View.VISIBLE);
    }
}