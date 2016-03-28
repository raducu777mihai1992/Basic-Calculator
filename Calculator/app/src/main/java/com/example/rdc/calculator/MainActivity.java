package com.example.rdc.calculator;

import android.os.Bundle;;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button add_Button, sub_Button, div_Button, mult_Button;
    private EditText firstNumber_field, secondNumber_field;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_activity);

        init();
    }

    private void init() {
        // 1st and 2nd number
        firstNumber_field = (EditText)findViewById(R.id.FirstNumber_field);
        secondNumber_field = (EditText)findViewById(R.id.SecondNumber_field);

        //  + , - , * , /
        add_Button = (Button)findViewById(R.id.add_button);
        sub_Button = (Button)findViewById(R.id.sub_button);
        mult_Button = (Button)findViewById(R.id.mult_button);
        div_Button = (Button)findViewById(R.id.div_button);

        // Result text field id
        result = (TextView)findViewById(R.id.Results_OutputText);

        // Set buttons on listener
        add_Button.setOnClickListener(this);
        sub_Button.setOnClickListener(this);
        mult_Button.setOnClickListener(this);
        div_Button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String num1 = firstNumber_field.getText().toString();
        String num2 = secondNumber_field.getText().toString();

        switch (v.getId()){
            case R.id.add_button:
                Float add_res = Float.parseFloat(num1) + Float.parseFloat(num2);
                result.setText(String.valueOf(add_res));
                break;
            case R.id.sub_button:
                Float sub_res = Float.parseFloat(num1) - Float.parseFloat(num2);
                result.setText(String.valueOf(sub_res));
                break;
            case R.id.mult_button:
                Float mul_res = Float.parseFloat(num1) * Float.parseFloat(num2);
                result.setText(String.valueOf(mul_res));
                break;
            case R.id.div_button:
                if (Float.parseFloat(num2) != 0.0) {
                    Float div_res = Float.parseFloat(num1) / Float.parseFloat(num2);
                    result.setText(String.valueOf(div_res));
                }
                else{
                    result.setText("Cannot divide by zero!");
                }
                break;
        }

    }
}
