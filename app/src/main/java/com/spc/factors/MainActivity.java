package com.spc.factors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.abs;

public class MainActivity extends AppCompatActivity {

    EditText etNumber;  // The number entered
    TextView tvResult;  // the result view
    int number_to_factorise;
    String results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find the relevant screen components
        etNumber = findViewById(R.id.number);
        tvResult = findViewById(R.id.result);

        etNumber.setText("");
        tvResult.setText(R.string.results);

        etNumber.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN
                        && keyCode == KeyEvent.KEYCODE_ENTER)) {
                    factorise();
                    return true;
                }
                return false;
            }

            private void factorise() {
                results = "Factors of " + etNumber.getText() + " are:\n";
                tvResult.setText(results);
                number_to_factorise = Integer.parseInt(etNumber.getText().toString());
                Log.d("FACTORS","number is "+number_to_factorise );
                Log.d("FACTORS","loopmax is "+(number_to_factorise/2) );

                for (int i = 1; i <= (number_to_factorise / 2); i++) {
                    if (number_to_factorise % i == 0) {
                        results = results + i + " ";
                        tvResult.setText(results);
                    }
                }
                results = results + number_to_factorise + "\nDone!";
                tvResult.setText(results);
            }

        });
    }
}
