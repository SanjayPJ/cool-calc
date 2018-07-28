package com.example.bingo6.demo;

import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String runningNumber = "";
    TextView resultView;
    String leftValue;
    String rightValue;
    int result;

    public enum Operation{
        ADD, SUBTRACT, MULTIPLY, DIVIDE, EQUAL
    }

    Operation currentOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button one = (Button) findViewById(R.id.one);
        Button two = (Button) findViewById(R.id.two);
        Button three = (Button) findViewById(R.id.three);
        Button four = (Button) findViewById(R.id.four);
        Button five = (Button) findViewById(R.id.five);
        Button six = (Button) findViewById(R.id.six);
        Button seven = (Button) findViewById(R.id.seven);
        Button eight = (Button) findViewById(R.id.eight);
        Button nine = (Button) findViewById(R.id.nine);
        Button zero = (Button) findViewById(R.id.zero);

        Button clear = (Button) findViewById(R.id.clear);

        Button add = (Button) findViewById(R.id.add);
        Button subtract = (Button) findViewById(R.id.subtract);
        Button multiply = (Button) findViewById(R.id.multiply);
        Button divide = (Button) findViewById(R.id.divide);
        Button equl = (Button) findViewById(R.id.equal);

        resultView = (TextView) findViewById(R.id.result);

        resultView.setText("");


        //adding onclick listener to numbers

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numToTextView(1);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numToTextView(2);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numToTextView(3);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numToTextView(4);
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numToTextView(5);
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numToTextView(6);
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numToTextView(7);
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numToTextView(8);
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numToTextView(9);
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numToTextView(0);
            }
        });


        //adding onclick listeners to mathematical operations

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //call that operator function
                mathOperator(Operation.ADD);
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //call operator function
                mathOperator(Operation.SUBTRACT);
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //call operator function
                mathOperator(Operation.MULTIPLY);
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //call operator function
                mathOperator(Operation.DIVIDE);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //call clear function
                clear();
            }
        });
        equl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mathOperator(Operation.EQUAL);
            }
        });

    }
    void numToTextView(int num){
        runningNumber += String.valueOf(num);
        resultView.setText(runningNumber);
    }

    void mathOperator(Operation operation){
        if(currentOperation == null){
            if(runningNumber != ""){
                leftValue = runningNumber;
                runningNumber = "";
                resultView.setText(runningNumber);
                currentOperation = operation;
            }
        }else{
            if(runningNumber != ""){
                rightValue = runningNumber;
                runningNumber = "";
                resultView.setText(runningNumber);
                switch (currentOperation){
                    case ADD:
                        result = Integer.parseInt(leftValue) + Integer.parseInt(rightValue);
                        break;
                    case SUBTRACT:
                        result = Integer.parseInt(leftValue) - Integer.parseInt(rightValue);
                        break;
                    case MULTIPLY:
                        result = Integer.parseInt(leftValue) * Integer.parseInt(rightValue);
                        break;
                    case DIVIDE:
                        result = Integer.parseInt(leftValue) / Integer.parseInt(rightValue);
                        break;
                }
                resultView.setText(String.valueOf(result));
                leftValue = String.valueOf(result);
                if(operation != Operation.EQUAL){
                    currentOperation = operation;
                }else{
                    currentOperation = null;
                }
            }else{
                currentOperation = operation;
            }
        }
    }
    void clear(){
        currentOperation = null;
        leftValue = "";
        resultView.setText("");
        rightValue = "";
        runningNumber = "";
    }
}
