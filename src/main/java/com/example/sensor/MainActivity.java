package com.example.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Accelerometer(View view) {
        Intent i = new Intent(MainActivity.this, Accelerometer.class);
        startActivity(i);
    }
    public void Gravity(View view) {
        Intent i = new Intent(MainActivity.this, Gravity.class);
        startActivity(i);
    }
    public void Gyroscope(View view) {
        Intent i = new Intent(MainActivity.this, Gyroscope.class);
        startActivity(i);
    }
    public void Linear(View view) {
        Intent i = new Intent(MainActivity.this, Linear.class);
        startActivity(i);
    }
    public void Rotation(View view) {
        Intent i = new Intent(MainActivity.this, Rotation.class);
        startActivity(i);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.about) {
            startActivity(new Intent(this, AboutActivity.class));
        } else if (item.getItemId() == R.id.sensor) {
            startActivity(new Intent(this, SensorActivity.class));
        }
        return true;
    }
}