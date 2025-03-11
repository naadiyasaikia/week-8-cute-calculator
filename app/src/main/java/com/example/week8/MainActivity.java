package com.example.week8;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    EditText inputBoxEdit, inputBox2Edit;
    TextView outputbox;
    Button add, sub, mul, div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ImageView addButton = findViewById(R.id.add);
        ImageView mulButton = findViewById(R.id.mul);
        ImageView subButton = findViewById(R.id.sub);
        ImageView divButton = findViewById(R.id.div);
        inputBoxEdit = findViewById(R.id.inputbox_edit);
        inputBox2Edit = findViewById(R.id.inputbox2_edit);
        outputbox = findViewById(R.id.outputbox);

        addButton.setOnClickListener(v -> calculate("+"));
        subButton.setOnClickListener(v -> calculate("-"));
        mulButton.setOnClickListener(v -> calculate("*"));
        divButton.setOnClickListener(v -> calculate("/"));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void calculate(String operation) {
        String num1Str = inputBoxEdit.getText().toString().trim();
        String num2Str = inputBox2Edit.getText().toString().trim();

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            outputbox.setText("There are no numbers!");
            return;
        }

        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        double result = 0;

        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    outputbox.setText("Division by zero is not possible!");
                    return;
                }
                result = num1 / num2;
                break;
        }

        outputbox.setText(String.format("%.2f", result));
    }
    }