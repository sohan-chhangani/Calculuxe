package com.chhangani.sohan.myfirstapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public EditText Num1;
    public EditText Num2;
    public EditText Num;
    public Button AddButton;
    public Button SubButton;
    public Button MulButton;
    public Button DivButton;
    public Button DollarButton;
    public Button EuroButton;
    public Button KelvinButton;
    public Button FahrenButton;
    float dollarValue = 0.012F;
    float euroValue = 0.011F;
    float kelvinValue = 273.15F;
    float fahrenValue = 1.8F;
    public TextView Result;
    public Button ClearButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Num1 = findViewById(R.id.Num1);
        Num2 = findViewById(R.id.Num2);
        Num = findViewById(R.id.Num);

        AddButton =findViewById(R.id.AddButton);
        SubButton=findViewById(R.id.SubButton);
        MulButton=findViewById(R.id.MulButton);
        DivButton=findViewById(R.id.DivButton);
        DollarButton =findViewById(R.id.DollarButton);
        EuroButton=findViewById(R.id.EuroButton);
        KelvinButton=findViewById(R.id.KelvinButton);
        FahrenButton=findViewById(R.id.FButton);

        Result = findViewById(R.id.Result);

        ClearButton=findViewById(R.id.ClearButton);

        try {
            AddButton.setOnClickListener(add);
        }
        catch (NumberFormatException exception){
            invalidInput();
        }
        try {
            SubButton.setOnClickListener(sub);
        }
        catch (NumberFormatException exception){
            invalidInput();
        }
        try {
            MulButton.setOnClickListener(mul);
        }
        catch (NumberFormatException exception){
            invalidInput();
        }
        try {
            DivButton.setOnClickListener(div);
        }
        catch (NumberFormatException exception){
            invalidInput();
        }

        try {
            DollarButton.setOnClickListener(toDollar);
        }
        catch (NumberFormatException exception)
        {
            invalidInput();
        }
        try {
            EuroButton.setOnClickListener(toEuro);
        }
        catch (NumberFormatException exception)
        {
            invalidInput();
        }
        try {
            KelvinButton.setOnClickListener(toKel);
        }
        catch (NumberFormatException exception)
        {
            invalidInput();
        }
        try {
            FahrenButton.setOnClickListener(toFah);
        }
        catch (NumberFormatException exception)
        {
            invalidInput();
        }
        try {
            ClearButton.setOnClickListener(clear);
        }
        catch (NullPointerException exception) {
            invalidInput();
        }
    }

    private void invalidInput() {
        Result.setText(R.string.enter_value);
        Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
    }

    private final View.OnClickListener clear = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            try {

                Num1.setText("");
                Num2.setText("");
                Num.setText("");
                Result.setText("");
            }catch (NumberFormatException numberFormatException )
            {
                invalidInput();
            }
        }
    };


    private final View.OnClickListener add = new View.OnClickListener() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onClick(View view) {
            try {

                if (Num1 != null & Num2 != null) {
                    float value = Float.parseFloat(Num1.getText().toString()) + Float.parseFloat(Num2.getText().toString());
                    Result.setText("Sum: " + value);
                }
                else {
                    invalidInput();
                }
            }catch (NumberFormatException e)
            {
                invalidInput();
            }
        }
    };
    private final View.OnClickListener sub= new View.OnClickListener() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onClick(View view) {
            try {

                if (Num1 != null & Num2 != null) {
                    float value = Float.parseFloat(Num1.getText().toString()) - Float.parseFloat(Num2.getText().toString());
                    Result.setText("Diff: " + value);
                }
                else {
                    invalidInput();
                }
            }catch (NumberFormatException e)
            {
                invalidInput();
            }
        }
    };
    private final View.OnClickListener mul= new View.OnClickListener() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onClick(View view) {
            try {


                if (Num1 != null & Num2 != null) {
                    float value = Float.parseFloat(Num1.getText().toString()) * Float.parseFloat(Num2.getText().toString());
                    Result.setText("Multiply: " + value);
                } else {
                    invalidInput();
                }
            }
            catch (NumberFormatException e)
            {
                invalidInput();
            }
        }

    };
    private final View.OnClickListener div= new View.OnClickListener() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onClick(View view) {
            try {


                if (Num1 != null & Num2 != null) {
                    float value = Float.parseFloat(Num1.getText().toString()) / Float.parseFloat(Num2.getText().toString());
                    Result.setText("Div: " + value);
                } else {
                    invalidInput();
                }
            }
            catch (NumberFormatException e)
            {
                invalidInput();
            }
        }
    };

    private final View.OnClickListener toDollar= new View.OnClickListener() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onClick(View view) {
            try {


                if (Num != null) {
                    float value = Float.parseFloat(Num.getText().toString()) * dollarValue;
                    Result.setText("$ " + value);
                } else {
                    invalidInput();
                }
            } catch (NumberFormatException e) {
                invalidInput();
            }
        }
    };

    private final View.OnClickListener toEuro= new View.OnClickListener() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onClick(View view) {
            try {

                if (Num != null) {
                    float value = Float.parseFloat(Num.getText().toString()) * euroValue;
                    Result.setText("£ " + value);
                } else {
                    invalidInput();
                }
            }
            catch (NumberFormatException e)
            {
                invalidInput();
            }
        }
    };

    private final View.OnClickListener toKel= new View.OnClickListener() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onClick(View view) {
            try {

                if (Num != null) {
                    float value = Float.parseFloat(Num.getText().toString()) + kelvinValue;
                    Result.setText(value + "K");
                } else {
                    invalidInput();
                }
            }
            catch (NumberFormatException e)
            {
                invalidInput();
            }
        }
    };
    private final View.OnClickListener toFah= new View.OnClickListener() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onClick(View view) {
            try {

                if (Num != null) {
                    float value = Float.parseFloat(Num.getText().toString()) * fahrenValue + 32;
                    Result.setText(value + "F");
                } else {
                    invalidInput();
                }
            } catch (NumberFormatException e) {
                invalidInput();
            }
        }
    };

}