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
        checkt = findViewById(R.id.check);
        int id = item.getItemId();
        if (id == R.id.Home) {
            checkt.setText("1");
            Intent intenthome = new Intent(MainPage.this, MainPage.class);
            startActivity(intenthome);
        }
        else if (id == R.id.goToBooks)
        {
            checkt.setText("2");
            Intent intentgotobooks = new Intent(MainPage.this, MainActivity.class);
            startActivity(intentgotobooks);
        }
        else if (id == R.id.addBook) {
            checkt.setText("3");
            Intent intentaddbook = new Intent(MainPage.this, AddBook.class);
            startActivity(intentaddbook);
        }

        return super.onOptionsItemSelected(item);

    }
}

