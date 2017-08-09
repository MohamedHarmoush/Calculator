package com.harmoush.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    float numberOne;
    float numberTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void clearTextOne(View view){
        TextView numberOne = (TextView)findViewById(R.id.number1);
        numberOne.setText("");
    }
    public void clearTextTwo(View view){
        TextView numberTwo = (TextView)findViewById(R.id.number2);
        numberTwo.setText("");
    }
    /*get numberOne and numberTwo from textViews and check the validation of the two numbers.
    * it returns false if the two numbers or one of them is invalid.
    */
    public boolean getNumbersWithoutError(){
        //textview od number1 and number2
        TextView number1 = (TextView)findViewById(R.id.number1);
        TextView number2 = (TextView)findViewById(R.id.number2);
        //get number One and Number two from textViews
        String num1 = number1.getText().toString();
        String num2 = number2.getText().toString();
        String message = "";
        boolean num1IsValid = true;
        boolean num2IsValid = true;
        try {
            numberOne = Integer.parseInt(num1);
        }catch(NumberFormatException ex) {
            num1IsValid = false ;
        }
        try {
            numberTwo = Integer.parseInt(num2);
        }catch(NumberFormatException ex) {
            num2IsValid = false;
        }
        if(!num1IsValid||!num2IsValid) {
            if(!num1IsValid&&!num2IsValid)
                message="Number One and Number Two are invalid numbers";
            else if(!num1IsValid)
                message ="Number One is invalid number";
            else
                message ="Number Two is invalid number";
            Toast.makeText(getApplicationContext(), message+"\n please enter a valid number!", Toast.LENGTH_SHORT).show();
            return  false;
        }
        return true;
    }
    public void add(View view){
        if(getNumbersWithoutError()) {
            //Toast.makeText(getApplicationContext(),numberOne+"    "+numberTwo,Toast.LENGTH_SHORT).show();
            String addRes = String.valueOf(numberOne + numberTwo);
            TextView res = (TextView) findViewById(R.id.result);
            res.setText(addRes);
        }
    }
    public void sub(View view) {
        if(getNumbersWithoutError()) {
            String addRes = String.valueOf(numberOne - numberTwo);
            TextView res = (TextView) findViewById(R.id.result);
            res.setText(addRes);
        }
    }
    public void mul(View view){
        if(getNumbersWithoutError()) {
            String addRes = String.valueOf(numberOne * numberTwo);
            TextView res = (TextView) findViewById(R.id.result);
            res.setText(addRes);
        }
    }
    public void div(View view){
        if(getNumbersWithoutError()) {
            if (numberTwo != 0) {
                String addRes = String.valueOf(numberOne / numberTwo);
                TextView res = (TextView) findViewById(R.id.result);
                res.setText(addRes);
            } else {
                Toast.makeText(getApplicationContext(), "Divison by zero is undefined!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
