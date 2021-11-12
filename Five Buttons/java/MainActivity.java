package info.jason.fivebuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result_str);

        View btn1 = findViewById(R.id.btn_1);
        btn1.setOnClickListener(new SepClick(result));

        View btn2 = findViewById(R.id.btn_2);
        btn2.setOnClickListener(new InClick());

        View btn3 = findViewById(R.id.btn_3);
        btn3.setOnClickListener(this);

        View btn4 = findViewById(R.id.btn_4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("Button 4 clicked via Anon Inner Class");
            }
        });

        View btn5 = findViewById(R.id.btn_5);
        btn5.setOnClickListener(v -> result.setText("Button 5 clicked via Lambda"));
    }

    @Override
    public void onClick(View view) { //this
        result.setText("Button 3 clicked via Activity Class");
    }

    private class InClick implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            result.setText("Button 2 clicked via Inner Class");
        }
    }
}