package com.example.myapplication;

import android.app.LauncherActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<Book> books;
    private List<Book> booksFull;

    private ArrayList<Book> bookModelArrayList;

    ListAdapter(Context context, ArrayList<Book> books) {
        this.books = books;
    }
    public ListAdapter(ArrayList<Book> courseModelArrayList, Context context) {
        this.bookModelArrayList = bookModelArrayList;
    }
    public void filterList(ArrayList<Book> filterlist) {
        bookModelArrayList = filterlist;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

       // View view = inflater.inflate(R.layout.list_item, parent, false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Book book = books.get(position);

        holder.nameView.setText(book.getName().toString());
        holder.authorView.setText(book.getAuthor().toString());
        holder.yearView.setText(book.getYear().toString());
    }

    @Override
    public int getItemCount() {
        return books.size();
    }
    public void filter(String text) {
        if (text.isEmpty()) {
            books.clear();
            booksFull.addAll(books);
        } else {
            books.addAll(booksFull);
            text = text.toLowerCase();
            for (Book item : booksFull) {
                if (item.getName().toLowerCase().contains(text)) {
                    books.add(item);
                }
            }
        }
         notifyDataSetChanged();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameView, authorView, yearView;

        ViewHolder(View view) {
            super(view);
            nameView = view.findViewById(R.id.name);
            authorView = view.findViewById(R.id.author);
            yearView = view.findViewById(R.id.year);
        }
    }
}