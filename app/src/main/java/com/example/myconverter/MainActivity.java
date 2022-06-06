package com.example.myconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText text_number;
    private Button convert_btn;
    private Spinner spinner_btn;
    private TextView tonna;
    private TextView kilogramm;
    private TextView gramm;

    String[] massa = new String[]{"Тонны", "Килограммы", "Граммы"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        convert_btn = (Button) findViewById(R.id.convert_btn);
        text_number = (EditText) findViewById(R.id.text_number);
        tonna = (TextView) findViewById(R.id.tonna);
        kilogramm = (TextView) findViewById(R.id.kilogramm);
        gramm = (TextView) findViewById(R.id.gramm);


        ArrayAdapter<String> massaAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, massa);
        massaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        Spinner spMassa = (Spinner) findViewById(R.id.spinner_btn);
        spMassa.setAdapter(massaAdapter);
        spMassa.setSelection(0);


        spMassa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?>
                                               parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();}
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}});




        convert_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double amount = Double.parseDouble(text_number.getText().toString());
                if (spMassa.getSelectedItem().toString() == "Тонны") {
                    tonna.setText(String.valueOf(amount));
                    kilogramm.setText(String.valueOf(amount * 1000));
                    gramm.setText(String.valueOf(amount * 100000));

                }else if(spMassa.getSelectedItem().toString() == "Килограммы") {
                    kilogramm.setText(String.valueOf(amount));
                    tonna.setText(String.valueOf(amount / 1000));
                    gramm.setText(String.valueOf(amount * 1000));

                }else if(spMassa.getSelectedItem().toString() == "Граммы") {
                gramm.setText(String.valueOf(amount));
                tonna.setText(String.valueOf(amount / 1000000));
                kilogramm.setText(String.valueOf(amount / 1000));
            }




            }
        });
    }
}











