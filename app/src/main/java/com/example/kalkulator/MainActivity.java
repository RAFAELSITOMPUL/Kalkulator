package com.example.kalkulator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private StringBuilder input = new StringBuilder();
    private double value1, value2;
    private String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        int[] buttonIds = {
                R.id.button0, R.id.button1, R.id.button2, R.id.button3,
                R.id.button4, R.id.button5, R.id.button6, R.id.button7,
                R.id.button8, R.id.button9, R.id.buttonAdd, R.id.buttonSubtract,
                R.id.buttonMultiply, R.id.buttonDivide, R.id.buttonClear, R.id.buttonEqual
        };

        for (int id : buttonIds) {
            findViewById(id).setOnClickListener(this::onButtonClick);
        }
    }

    private void onButtonClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();

        switch (buttonText) {
            case "C":
                input.setLength(0);
                display.setText("");
                break;
            case "=":
                value2 = Double.parseDouble(input.toString());
                double result;
                switch (operator) {
                    case "+":
                        result = value1 + value2;
                        break;
                    case "-":
                        result = value1 - value2;
                        break;
                    case "*":
                        result = value1 * value2;
                        break;
                    case "/":
                        result = value1 / value2;
                        break;
                    default:
                        result = 0;
                }
                display.setText(String.valueOf(result));
                input.setLength(0);
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                operator = buttonText;
                value1 = Double.parseDouble(input.toString());
                input.setLength(0);
                break;
            default:
                input.append(buttonText);
                display.setText(input.toString());
                break;
        }
    }
}
