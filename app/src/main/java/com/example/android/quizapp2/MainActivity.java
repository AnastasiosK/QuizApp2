/***
 * Anastasios k.
 * 3/12/2017
 */
package com.example.android.quizapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /***
     * Make some declarations
     */

    public int score = 0;
    public EditText yes_or_no,name_write;
    public String edit_yes_or_no,edit_name;
    public RadioGroup radio_selection_group;
    public RadioButton radiocorrect,radio_one;
    private CheckBox acb, bcb,robb,eddardcb,littlefinger,hound;

    /***
     * App starts
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yes_or_no = findViewById(R.id.Firstedittext);
        name_write = findViewById(R.id.last_edittext);
        radio_selection_group = findViewById(R.id.Radiogroup);
        radiocorrect = findViewById(R.id.radiobuttoncorrect);
        acb = findViewById(R.id.checkboxOne);
        bcb = findViewById(R.id.checkboxTwo);
        eddardcb = findViewById(R.id.eddardstark);
        hound = findViewById(R.id.hound);
        littlefinger = findViewById(R.id.littlefinger);
        robb = findViewById(R.id.robb);
        score = 0;
        final Button button = findViewById(R.id.Submitbutton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validationSuccess()) {
                    getScore(v);
                } else {
                    AlertDialog();
                }
            }
        });
}
            private Boolean validationSuccess() {

                if (radio_selection_group.getCheckedRadioButtonId() < 0) {
                    Toast.makeText(getBaseContext(), "Please fill all the questions", Toast.LENGTH_LONG).show();
                    return false;
                }
                if (yes_or_no.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(getApplicationContext(), "You need to Type Yes or No", Toast.LENGTH_LONG).show();
                    return false;
                }
                if(name_write.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getApplicationContext(),"You need to write the name of the queen",Toast.LENGTH_LONG).show();
                    return false;
                }
                if ((acb.isChecked()==true || bcb.isChecked()==true) && (eddardcb.isChecked()==true || littlefinger.isChecked()==true || robb.isChecked()==true || hound.isChecked()==true)){
                    return true;
                }
                else
                {
                    Toast.makeText(getBaseContext(),"Please select one of the checkboxes or more!",Toast.LENGTH_LONG).show();
                    return false;
                }
            }

            private void AlertDialog(){
                Toast.makeText(getBaseContext(),"Please fill all the questions",Toast.LENGTH_LONG).show();
            }

            public void getScore(View view){
                acb = (CheckBox) findViewById(R.id.checkboxOne);
                bcb = (CheckBox) findViewById(R.id.checkboxTwo);
                yes_or_no = (EditText) findViewById(R.id.Firstedittext);
                name_write = (EditText) findViewById(R.id.last_edittext);
                edit_yes_or_no = yes_or_no.getText().toString().toUpperCase();
                edit_name = name_write.getText().toString().toUpperCase();
                int radiobuttonid = radio_selection_group.getCheckedRadioButtonId();
                radiocorrect = (RadioButton) findViewById(radiobuttonid);
                radio_one = (RadioButton) findViewById(R.id.radiobuttoncorrect);

                if (acb.isChecked() && bcb.isChecked()){
                    score = score +1;
                }
                if (edit_yes_or_no.equals("YES")){
                    score = score +1;
                }
                if (edit_name.equals("DAENERYS")){
                    score = score +1;
                }
                if(radiocorrect == radio_one){
                    score = score +1;
                }

                if (eddardcb.isChecked() && (hound.isChecked() || robb.isChecked() || littlefinger.isChecked())){
                    score = score + 0;
                    Toast.makeText(getApplicationContext(),"Please select only one character!",Toast.LENGTH_LONG).show();
                }
                else if(eddardcb.isChecked()){
                    score = score +1;
                }


                /***
                 * If the user makes a perfect score it displays a different message
                 * to get a perfect score all answers must be correct
                 */

                if (score == 5) {
                    Toast.makeText(getApplicationContext(), "You are the best!!! You made a perfect score of : " + score, Toast.LENGTH_LONG).show();
                    score = 0;
                } else
                    Toast.makeText(getApplicationContext(), "This is your score: " + score, Toast.LENGTH_LONG).show();
                score = 0;
            }


    }

