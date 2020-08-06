package com.example.library;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.library.interfaces.OnBookClick;
import com.example.library.models.BooksDes;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BooksViewHolder> {

    private OnBookClick onBookClick;

    public void setInBookClickListener(OnBookClick onBookClick) {
        this.onBookClick = onBookClick;
    }

    ArrayList<BooksDes> card;

    public BookAdapter(ArrayList<BooksDes> card) {
        this.card = card;
        BooksDes booksDes1 = new BooksDes(R.drawable.farengeitbook,
                "451 по Фаренгейту",
                " научно-фантастический роман-антиутопия Рэя Брэдбери, изданный в 1953 году. Роман описывает американское общество близкого будущего, в котором книги находятся под запретом; «пожарные», к числу которых принадлежит и главный герой Гай Монтэг, сжигают любые найденные книги. В ходе романа Монтэг разочаровывается в идеалах общества, частью которого он является, становится изгоем и присоединяется к небольшой подпольной группе маргиналов, сторонники которой заучивают тексты книг, чтобы спасти их для потомков.");

        BooksDes booksDes2 = new BooksDes(R.drawable.kiosakibook,
                "Богатый папа ,бедный папа",
                "Роберт Кийосаки убежден, что в школе наши дети не получают нужных финансовых знаний и потом всю жизнь работают ради денег, вместо того чтобы заставить деньги работать на себя. Он предлагает читателю по-новому взглянуть на эту серьезную проблему и научить детей обращаться с деньгами раньше, чем они столкнутся с финансовыми трудностями.\n" +
                        "Для широкого круга читателей.\n");

        BooksDes booksDes3 = new BooksDes(R.drawable.tovarishi, "Три товарища",
                "Самый красивый в двадцатом столетии роман о любви...\n" +
                        "Самый увлекательный в двадцатом столетии роман о дружбе...\n" +
                        "Самый трагический и пронзительный роман о человеческих отношениях за всю историю двадцатого столетия.\n");

        card.add(booksDes1);
        card.add(booksDes2);
        card.add(booksDes3);


    }

    @NonNull
    @Override
    public BooksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_view, parent, false);
        return new BooksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksViewHolder holder, int position) {
        holder.onBind(card.get(position));
    }

    @Override
    public int getItemCount() {
        return card.size();
    }

    public class BooksViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageBook;
        private TextView textBooksHeading;

        public BooksViewHolder(@NonNull View itemView) {
            super(itemView);
            initializationViews(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                 onBookClick.onItemClick(getAdapterPosition());

                }
            });
        }

        private void initializationViews(View itemView) {
            imageBook = itemView.findViewById(R.id.image_cardBooksView);
            textBooksHeading = itemView.findViewById(R.id.text_books_heading);

        }

        public void onBind(BooksDes booksDes) {
            imageBook.setImageResource(booksDes.getImageBook());
            textBooksHeading.setText(booksDes.getTextBooksHeading());

        }
    }
}

