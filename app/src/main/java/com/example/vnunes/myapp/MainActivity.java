package com.example.vnunes.myapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn0 = findViewById(R.id.btn_0);
        Button btn1 = findViewById(R.id.btn_1);
        Button btn2 = findViewById(R.id.btn_2);
        Button btn3 = findViewById(R.id.btn_3);
        Button btn4 = findViewById(R.id.btn_4);
        Button btn5 = findViewById(R.id.btn_5);
        Button btn6 = findViewById(R.id.btn_6);
        Button btn7 = findViewById(R.id.btn_7);
        Button btn8 = findViewById(R.id.btn_8);
        Button btn9 = findViewById(R.id.btn_9);
        Button btndelete = findViewById(R.id.btn_delete);
        Button btnp1 = findViewById(R.id.btn_p1);
        Button btnp2 = findViewById(R.id.btn_p2);
        Button btnplus = findViewById(R.id.btn_plus);
        Button btnminus = findViewById(R.id.btn_minus);
        Button btnmult = findViewById(R.id.btn_mult);
        Button btndiv = findViewById(R.id.btn_div);
        Button btnequals = findViewById(R.id.btn_equals);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btndelete.setOnClickListener(this);
        btnp1.setOnClickListener(this);
        btnp2.setOnClickListener(this);
        btnplus.setOnClickListener(this);
        btnequals.setOnClickListener(this);
        btnmult.setOnClickListener(this);
        btndiv.setOnClickListener(this);
        btnminus.setOnClickListener(this);
    }

    public void onClick(View v) {
        TextView userInput = findViewById(R.id.userInput);
        TextView userResult = findViewById(R.id.userResult);
        switch (v.getId()) {
            case R.id.btn_1:
                userInput.setText(userInput.getText() + "1");
                break;
            case R.id.btn_2:
                userInput.setText(userInput.getText() + "2");
                break;
            case R.id.btn_3:
                userInput.setText(userInput.getText() + "3");
                break;
            case R.id.btn_4:
                userInput.setText(userInput.getText() + "4");
                break;
            case R.id.btn_5:
                userInput.setText(userInput.getText() + "5");
                break;
            case R.id.btn_6:
                userInput.setText(userInput.getText() + "6");
                break;
            case R.id.btn_7:
                userInput.setText(userInput.getText() + "7");
                break;
            case R.id.btn_8:
                userInput.setText(userInput.getText() + "8");
                break;
            case R.id.btn_9:
                userInput.setText(userInput.getText() + "9");
                break;
            case R.id.btn_delete:
                if (!userInput.getText().toString().equals(""))
                    userInput.setText(userInput.getText().toString().substring(0, userInput.getText().length() - 1));
                break;
            case R.id.btn_p1:
                userInput.setText(userInput.getText()+"(");
                break;
            case R.id.btn_p2:
                userInput.setText(userInput.getText()+")");
                break;
            case R.id.btn_plus:
                userInput.setText(userInput.getText() + "+");
                break;
            case R.id.btn_minus:
                userInput.setText(userInput.getText() + "-");
                break;
            case R.id.btn_mult:
                userInput.setText(userInput.getText() + "*");
                break;
            case R.id.btn_div:
                userInput.setText(userInput.getText() + "/");
                break;
            case R.id.btn_equals:
                if (!Validate.validadeExpression(userInput.getText().toString())) {
                    Toast.makeText(this, "It's not a valid expression", Toast.LENGTH_SHORT).show();
                }else{
                    userResult.setText("" + Calculator.solveExpression(userInput.getText().toString()));
                }
                break;
        }
    }
}
