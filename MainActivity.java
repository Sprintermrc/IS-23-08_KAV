package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Book> books = new ArrayList<Book>();
    private List<Book> booksFull = new ArrayList<Book>();
    private ListAdapter adapter;
    private RecyclerView rv;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        try {
            Bundle addData = getIntent().getExtras();
            if (addData == null) {
            } else {
                String name1 = addData.getString("name");
                String author1 = addData.getString("author");
                String year1 = addData.getString("year");
                String publisher1 = addData.getString("publisher");
                books.add(new Book(name1, author1, year1, publisher1));


            }

        } finally {

        }

        books.add(new Book("У лукоморья дуб зеленый", "Пушкин", "1825", "-"));
        books.add(new Book("Преступление и наказание", "Фёдор Достоевский", "1866", "-"));
        books.add(new Book("Война и мир", "Толстой", "1865", "-"));
        books.add(new Book("Руслан иЛюдмилла", "пушкин", "1818", "-"));
        books.add(new Book("Крым на веки с Россией", "Бабурин Сергей", "2014", "'Благословение'"));

        books.addAll(booksFull);

        adapter = new ListAdapter(this, (ArrayList<Book>) books);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);



        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }



    public void sortBooksByTitle() {
        Collections.sort(books, Comparator.comparing(Book::getName));
    }

    public void sortBooksByAuthor() {
        Collections.sort(books, Comparator.comparing(Book::getAuthor));
    }

    public void sortBooksByYear() {
        Collections.sort(books, Comparator.comparing(Book::getYear));
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.search_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.actionSearch);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filter3(query);



                books.clear();
                adapter.notifyDataSetChanged();

                return false;

            }

            @Override
            public boolean onQueryTextChange(String text) {

                return false;
            }
        });
        return true;
    }
    ///меню
    public void filter3(String text) {

        ArrayList<Book> filteredlist = new ArrayList<Book>();
        for (Book item : books) {
            //  if (item.getYear().toLowerCase().contains(text.toLowerCase())|| item.getYear().contains(text.toLowerCase())
            //                                        || item.getAuthor().toLowerCase().contains(text.toLowerCase())) {

            if (item.getName().toLowerCase().contains(text.toLowerCase()) || item.getYear().toLowerCase().contains(text.toLowerCase()) ||item.getAuthor().toLowerCase().contains(text.toLowerCase())) {
                filteredlist.add(item);


            }
            if (filteredlist.isEmpty()) {

            }
            else {
                int a = filteredlist.size();
                int b = books.size();
                Toast toast1 = Toast.makeText(getApplicationContext(), "совпадения " + "всего "+a + b , Toast.LENGTH_SHORT);
                toast1.show();

               adapter.filterList(filteredlist);



            }
        }

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.Home) {
            Intent intenthome = new Intent(MainActivity.this, MainPage.class);
            startActivity(intenthome);
        }
        else if (id == R.id.goToBooks)
        {
            Intent intentgotobooks = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intentgotobooks);
        }
        else if (id == R.id.addBook) {
            Intent intentaddbook = new Intent(MainActivity.this, AddBook.class);
            startActivity(intentaddbook);
        }

        return super.onOptionsItemSelected(item);

    }


    public boolean onSortItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.sortByName) {
            books.clear();
            adapter.notifyDataSetChanged();

        }
        else if (id == R.id.sortByAuthor)
        {
            Collections.sort(books, Comparator.comparing(Book::getYear));
            adapter.notifyDataSetChanged();
        }
        else if (id == R.id.sortByYear) {
        sortBooksByYear();
            adapter.notifyDataSetChanged();

        }

        return super.onOptionsItemSelected(item);

    }
}

