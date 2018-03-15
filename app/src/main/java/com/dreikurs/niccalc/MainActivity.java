package com.dreikurs.niccalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText input;
    private TextView bDayLabel;
    private TextView ageLabel;
    private TextView genderLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);


        addListenerOnCalcButton();

    }

    private void addListenerOnCalcButton() {
        input       = (EditText)findViewById(R.id.nicTF);
        Button calcBtn = (Button) findViewById(R.id.calcBtn);
        bDayLabel   = (TextView)findViewById(R.id.bDayLabel);
        ageLabel    = (TextView)findViewById(R.id.ageLabel);
        genderLabel = (TextView)findViewById(R.id.genderLabel);

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int in;
                String inp = input.getText().toString();

                try {
                    in = Integer.parseInt(inp);

                    if (inp.length() != 9) {
                        bDayLabel.setText("");
                        genderLabel.setText("");
                        ageLabel.setText("");
                        Toast.makeText(getApplicationContext(), "NIC number is missing some digits!\nPlease Try again...", Toast.LENGTH_SHORT).show();

                    } else {
                        String[] result = Calculator.bDay(in);

                        bDayLabel.setText(result[0]);
                        genderLabel.setText(result[1]);
                        ageLabel.setText(result[2]);
                    }


                } catch (NumberFormatException e) {
                    bDayLabel.setText("");
                    genderLabel.setText("");
                    ageLabel.setText("");
                    Toast.makeText(getApplicationContext(), "Please enter a valid NIC number!", Toast.LENGTH_SHORT).show();

                }


            }
        });



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
        if (id == R.id.action_about) {
            Toast.makeText(getApplicationContext(), "Created by Prasith Lakshan", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
