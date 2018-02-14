package com.example.android.testapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

//import static com.example.android.testapp.R.id.login;
import static com.example.android.testapp.R.id.radioButton;

public class Form2 extends AppCompatActivity {

    Button button;
    Bundle bundle;
    RadioGroup radioGroup;
    EditText weight,height,dob;
    ImageButton girl,boy;
    String selectedtext;
    RadioButton radioButton;
    String lifestyle;
    int month,day,year;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form2);
        Intent intent = getIntent();
        bundle = intent.getExtras();
        button = (Button)findViewById(R.id.submit);
        weight = (EditText)findViewById(R.id.weight) ;
        height = (EditText)findViewById(R.id.height);
        dob = (EditText)findViewById(R.id.dob);
        girl = (ImageButton)findViewById(R.id.girl);
        boy = (ImageButton)findViewById(R.id.boy);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);

        girl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                girl.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                if(boy.isEnabled()) {
                    boy.setEnabled(false);
                }
                else{
                    boy.setEnabled(true);
                }

            }
        });
        boy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boy.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                if(girl.isEnabled()){
                    girl.setEnabled(false);
                }
                else{
                    girl.setEnabled(true);
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                int radioButtonID = radioGroup.getCheckedRadioButtonId();
//                radioButton = (RadioButton)radioGroup.findViewById(radioButtonID);
//                selectedtext = (String) radioButton.getText();

                bundle.putString("dob",dob.getEditableText().toString());
                bundle.putString("height",height.getEditableText().toString());
                bundle.putString("weight",weight.getEditableText().toString());
                bundle.putString("lifestyle",lifestyle);
                if (girl.isEnabled() && boy.isEnabled()){
                    Toast.makeText(Form2.this,"Select a gender!",Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    if (girl.isEnabled()){
                        bundle.putString("gender","female");
                    }
                    else {
                        bundle.putString("gender","male");
                    }

                }
                Intent intent2=new Intent(Form2.this,LoginActivity.class);
                intent2.putExtras(bundle);
                startActivity(intent2);

            }
        });
    }

    public void onRadio(View view){
        boolean checked = ((RadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.radioButton:
                lifestyle="Sedentary";
                break;
            case R.id.radioButton2:
                lifestyle="Moderate";
                break;
            case R.id.radioButton3:
                lifestyle="Active";
                break;
            case R.id.radioButton4:
                lifestyle="Veryactive";
                break;

        }
    }
//    @RequiresApi(api = Build.VERSION_CODES.N)
//    private void SelectDate(View view) {
//
//        final Calendar c = Calendar.getInstance();
//        year = c.get(Calendar.YEAR);
//        month = c.get(Calendar.MONTH);
//        day = c.get(Calendar.DAY_OF_MONTH);
//
//        DatePickerDialog datePickerDialog=new DatePickerDialog(Form2.this, new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
//                c.set(i,i1,i2,0,0,0);
//                epoch[0]=c.getTimeInMillis();
//            }
//        })
////        showDialog(DATE_PICKER_ID);
//
//    }
//
//    @Override
//    protected Dialog onCreateDialog(int id) {
//        switch (id) {
//            case DATE_PICKER_ID:
//
//                // open datepicker dialog.
//                // set date picker for current date
//                // add pickerListener listner to date picker
//                return new DatePickerDialog(this, pickerListener, year, month,day);
//        }
//        return null;
//    }
//
//    private DatePickerDialog.OnDateSetListener pickerListener = new DatePickerDialog.OnDateSetListener() {
//
//        // when dialog box is closed, below method will be called.
//        @Override
//        public void onDateSet(DatePicker view, int selectedYear,
//                              int selectedMonth, int selectedDay) {
//
//            year  = selectedYear;
//            month = selectedMonth;
//            day   = selectedDay;
//
//            // Show selected date
//            dob.setText(new StringBuilder().append(month + 1)
//                    .append("-").append(day).append("-").append(year)
//                    .append(" "));
//
//        }
 //   };
}
