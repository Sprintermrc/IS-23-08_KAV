package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddBook extends AppCompatActivity {
    private Button button;
    private EditText addAuthor;
    private EditText addName;
    private EditText addYear;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_book);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBookData();
            }
        });
    }

    //добавление книг
     public void addBookData() {
         Intent intent = new Intent(AddBook.this, MainActivity.class);
         addAuthor = findViewById(R.id.addAuthor);
         addName = findViewById(R.id.addName);
         addYear = findViewById(R.id.addYear);
         String nameadd = addName.getText().toString();
         String authoradd = addAuthor.getText().toString();
         String yearadd = addYear.getText().toString();
         intent.putExtra("name", nameadd);
         intent.putExtra("author",authoradd);
         intent.putExtra("year",yearadd);
         startActivity(intent);
     }




    ///меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.Home) {
            Intent intenthome = new Intent(AddBook.this, MainPage.class);
            startActivity(intenthome);
        }
        else if (id == R.id.goToBooks)
        {
            Intent intentgotobooks = new Intent(AddBook.this, MainActivity.class);
            startActivity(intentgotobooks);
        }
        else if (id == R.id.addBook) {
            Intent intentaddbook = new Intent(AddBook.this, AddBook.class);
            startActivity(intentaddbook);
        }

        return super.onOptionsItemSelected(item);

    }
}
