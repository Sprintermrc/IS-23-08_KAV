package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;
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
                books.add(new Book(name1, author1, year1));


            }

        } finally {

        }

        books.add(new Book("Хребты безумия", "Говард Филипс Лавкрафт", "1939"));
        books.add(new Book("Преступление и наказание", "Фёдор Достоевский", "1866"));
        books.add(new Book("На западном фронте без перемен", "Эрих Мария Ремарк", "1928"));
        books.add(new Book("The Dunwich Horror", "H. P. Lovecraft", "1928"));

        books.addAll(booksFull);

        adapter = new ListAdapter(this, (ArrayList<Book>) books);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        button = findViewById(R.id.buttonsearch);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }



    public void addBookToList(){
        Toast toast = Toast.makeText(getApplicationContext(),
                "Успешно", Toast.LENGTH_SHORT);
        toast.show();
    }



    ///меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        // inside inflater we are inflating our menu file.
        inflater.inflate(R.menu.search_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.actionSearch);
       // getMenuInflater().inflate(R.menu.main_menu, menu);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter3(newText);
                return false;
            }
        });
        return true;
    }

    public void filter3(String text) {

        ArrayList<Book> filteredlist = new ArrayList<Book>();
        for (Book item : books) {
            //  if (item.getYear().toLowerCase().contains(text.toLowerCase())|| item.getYear().contains(text.toLowerCase())
            //                                        || item.getAuthor().toLowerCase().contains(text.toLowerCase())) {

            if (item.getName().toLowerCase().contains(text.toLowerCase()) || item.getYear().toLowerCase().contains(text.toLowerCase()) ||item.getAuthor().toLowerCase().contains(text.toLowerCase())) {
                filteredlist.add(item);
                Toast toast9 = Toast.makeText(getApplicationContext(),
                        "Найдено!", Toast.LENGTH_SHORT);
                toast9.show();
            }
            if (filteredlist.isEmpty()) {
            }
            else {
                int a = filteredlist.size();
                books.clear();
                adapter.filterList(filteredlist);
                Toast toast90 = Toast.makeText(getApplicationContext(),
                        "Найдено!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!", Toast.LENGTH_SHORT);
                toast90.show();
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
}

