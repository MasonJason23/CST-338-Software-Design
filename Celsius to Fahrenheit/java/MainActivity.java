package com.example.ctof;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//    TODO add ids to Main Activity
//      Edittext ID --> cinput_edittext
//      Calculate Button ID --> calc_button
//      ResultTextView ID --> result_text
//      About Button ID --> about_button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View calculateButton = findViewById(R.id.calc_button);
        calculateButton.setOnClickListener(this);

        View aboutButton = findViewById(R.id.about_button);
        aboutButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        EditText cinput;
        String input;
        TextView result;
        double fout;
        String errorMsg;

        if (view.getId() == R.id.calc_button) {
            cinput = findViewById(R.id.cinput_edittext);
            input = cinput.getText().toString();

            result = findViewById(R.id.result_text);
            try {
                double cin = Double.parseDouble(input);
                fout = cin * (9.0/5.0) + 32.0;
                result.setText(Double.toString(fout));
            } catch (Exception e) {
                errorMsg = "Error";
                result.setText(errorMsg);
            }

            Log.d("MainActivity", "Button clicked");
            Log.d("MainActivity", input);
        }
        else if (view.getId() == R.id.about_button) {
            Log.d("MainActivity", "About button clicked");

            Intent aboutPage = new Intent(this, About.class);
            Bundle extraInfo = new Bundle();
            extraInfo.putInt("myValue", 5);
            extraInfo.putString("myString", "CS");
            aboutPage.putExtras(extraInfo);
            startActivity(aboutPage);
        }
    }
}