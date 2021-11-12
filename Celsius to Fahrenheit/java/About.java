package com.example.ctof;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class About extends AppCompatActivity implements View.OnClickListener {

//    TODO add ids to About Activity
//      Backstep Button ID --> about_backstack

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        int passedInt = 0;
        String passedString = "";

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            passedInt = extras.getInt("myValue");
            passedString = extras.getString("myString");
        }

        String text = "Value: " + passedInt + "     String: " + passedString;

        Toast.makeText(this, text, Toast.LENGTH_LONG).show();

        View backstepButton = findViewById(R.id.about_backstack);
        backstepButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.about_backstack) {
            finish();
        }
    }
}