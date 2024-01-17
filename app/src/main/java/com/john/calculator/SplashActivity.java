package com.john.calculator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    TextView screenText;
    String firstNumber = "";
    String operator = "";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        screenText = findViewById(R.id.screenText);
    }

    public void onDigitClick(View view) {
        // cast the button of the digit
        Button button = ((Button) view);

        if (screenText.getText().equals("0")) {
            if (button.getText().equals(".")) {
                screenText.append(button.getText());
            } else {
                screenText.setText(button.getText());
            }
        } else if (button.getText().equals(".")) {
            if (!screenText.getText().toString().contains(".")) {
                screenText.append(".");
            }
        } else {
            screenText.append(button.getText());
        }

    }

    public void onMathFunctionClick(View view) {
        // cast the button of the digit
        Button button = ((Button) view);

        if (operator.isEmpty()) {
            firstNumber = screenText.getText().toString();
        } else {
            firstNumber = String.valueOf(calculateFunction(Double.parseDouble(screenText.getText().toString())));
            Log.e("firstNumber" , firstNumber);
        }
        operator = button.getText().toString();
        screenText.setText("0");

    }

    public void onEqualClick(View view) {
        // cast the button of the digit
        Button button = ((Button) view);

        if (operator.isEmpty()) {
            firstNumber = screenText.getText().toString();
        } else {
            firstNumber = String.valueOf(calculateFunction(Double.parseDouble(screenText.getText().toString())));
            Log.e("firstNumber" , firstNumber);
        }
        screenText.setText(firstNumber);
        firstNumber = "";
        operator = "";
    }

    private double calculateFunction(double num2) {
        double num1 = Double.parseDouble(firstNumber);
        Log.e("firstNumber" , firstNumber);
        double result = 0.0;
        Log.e("operator" , operator);
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "x":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            case "%":
                result = num1 % num2;
                break;
        }
        return result;
    }

    public void onAllClearPress(View view){
        operator = "";
        firstNumber = "";
        screenText.setText("0");
    }

    public void onSignReveirce(View view){
        double number = Double.parseDouble(screenText.getText().toString());
        number *= -1;
        screenText.setText(String.valueOf(number));
    }

}
