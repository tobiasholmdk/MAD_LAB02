package com.example.mad_lab02_ex01;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
    private MainViewModel model;
    int counter = 0;
    private TextView tv;
    private Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textview);
        but  = findViewById(R.id.button);

        // Get the ViewModel.
        model = new ViewModelProvider(this).get(MainViewModel.class);

        // Create the observer which updates the UI.
        final Observer<Integer> countObs = new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable final Integer count) {
                // Update the UI, in this case, a TextView.
                tv.setText("" + count);
            }
        };
        model.getCurrentName().observe(this, countObs);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter ++;

                model.getCurrentName().setValue(counter);
            }
        });

        if (model.getCurrentName().getValue() != null)
        {
            counter = model.getCurrentName().getValue();
        }

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("LifeCycle", "onStart() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("LifeCycle", "onResume() called");
    }

    @Override
    public void onPause() {

        super.onPause();
        Log.d("LifeCycle", "onPause() called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("LifeCycle", "onStop() called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle", "onDestroy() called");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}