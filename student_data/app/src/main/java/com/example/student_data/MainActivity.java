package com.example.student_data;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText n,er;
    RadioGroup radioGroup;
    RadioButton r1;
    Button b1;
    CheckBox cb1, cb2, cb3, cb4, cb5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n = (EditText) findViewById(R.id.name);
        er = (EditText) findViewById(R.id.enrol);
        b1 = (Button) findViewById(R.id.button);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        cb1 = (CheckBox) findViewById(R.id.c1);
        cb2 = (CheckBox) findViewById(R.id.c2);
        cb3 = (CheckBox) findViewById(R.id.c3);
        cb4 = (CheckBox) findViewById(R.id.c4);
        cb5 = (CheckBox) findViewById(R.id.c5);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r1 = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                String a = r1.getText().toString();
                String na = n.getText().toString();
                String en = er.getText().toString();
                String checkBoxChoices = "";

                if (cb1.isChecked()) {
                    checkBoxChoices += cb1.getText().toString()+"\n" ;
                }
                else{
                    checkBoxChoices += cb1.getText().toString()+"\n" ;
                }

                if (cb2.isChecked()) {
                    checkBoxChoices += cb2.getText().toString()+"\n" ;
                }
                else{
                    checkBoxChoices += cb2.getText().toString()+"\n" ;
                }

                if (cb3.isChecked()) {
                    checkBoxChoices += cb3.getText().toString()+"\n" ;
                }
                else{
                    checkBoxChoices += cb3.getText().toString()+"\n" ;
                }

                if (cb4.isChecked()) {
                    checkBoxChoices += cb4.getText().toString()+"\n" ;
                }
                else{
                    checkBoxChoices += cb4.getText().toString()+"\n" ;
                }

                Toast.makeText(MainActivity.this,
                        String.format("name: %s\nEnrollment_NO: %s\n Subject:%sGender:%s",
                                na, en, checkBoxChoices, a), Toast.LENGTH_LONG).show();

            }
        });
    }
}