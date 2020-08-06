 package com.example.library.ui.description;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.library.R;
import com.example.library.models.BooksDes;

import java.util.ArrayList;

public class BooksDescFragment extends Fragment {
    private TextView bookHeading,booksDesc;
    private ImageView imageBooks;
    private ArrayList<BooksDes> booksList=new ArrayList<>();
    private BooksDes model;



    public BooksDescFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle=this.getArguments();
        if (bundle!=null){
            model=(BooksDes)bundle.getSerializable("pos");
            booksList.add(model);
        }
        return inflater.inflate(R.layout.fragment_books_desc, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bookHeading=view.findViewById(R.id.text_heading_in_fr);
        booksDesc=view.findViewById(R.id.text_desc_in_fr);
        imageBooks=view.findViewById(R.id.image_heading_book);
        if (model!=null){
            bookHeading.setText(model.getTextBooksHeading());
            booksDesc.setText(model.getTextBookDesc());
            imageBooks.setImageResource(model.getImageBook());

        }
    }
}