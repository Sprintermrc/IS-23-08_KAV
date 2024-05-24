package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.view.View;

public class MainPage extends AppCompatActivity {

    private TextView checkt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

    }

    //меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.Home) {
            Intent intenthome = new Intent(MainPage.this, MainPage.class);
            startActivity(intenthome);
        }
        else if (id == R.id.goToBooks)
        {
            Intent intentgotobooks = new Intent(MainPage.this, MainActivity.class);
            startActivity(intentgotobooks);
        }
        else if (id == R.id.addBook) {
            Intent intentaddbook = new Intent(MainPage.this, AddBook.class);
            startActivity(intentaddbook);
        }

        return super.onOptionsItemSelected(item);

    }
}

