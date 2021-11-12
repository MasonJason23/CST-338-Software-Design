package info.jason.fivebuttons;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SepClick implements View.OnClickListener {

    private static final String TAG = "SepClick";
    private TextView resultTxt;

    public SepClick(TextView result) {
        resultTxt = result;
    }

    @Override
    public void onClick(View view) {
        Log.d(TAG, "Button clicked via separate class");
        resultTxt.setText("Button 1 clicked via Separate Class");
    }
}
