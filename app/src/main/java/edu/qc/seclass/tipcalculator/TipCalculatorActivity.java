package edu.qc.seclass.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalculatorActivity extends AppCompatActivity {

    private EditText amount;
    private EditText size;
    private Button calculate;
    private TextView tip15ans;
    private TextView tip20ans;
    private TextView tip25ans;
    private TextView total15ans;
    private TextView total20ans;
    private TextView total25ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amount = findViewById(R.id.checkAmountValue);
        size = findViewById(R.id.partySizeValue);
        calculate = findViewById(R.id.buttonCompute);
        tip15ans = findViewById(R.id.fifteenPercentTipValue);
        tip20ans = findViewById(R.id.twentyPercentTipValue);
        tip25ans = findViewById(R.id.twentyfivePercentTipValue);
        total15ans = findViewById(R.id.fifteenPercentTotalValue);
        total20ans = findViewById(R.id.twentyPercentTotalValue);
        total25ans = findViewById(R.id.twentyfivePercentTotalValue);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(amount.getText().toString().isEmpty()) {
                    Toast.makeText(TipCalculatorActivity.this, "Check amount cannot be empty", Toast.LENGTH_SHORT).show();
                }else if(size.getText().toString().isEmpty()) {
                    Toast.makeText(TipCalculatorActivity.this, "Party size cannot be empty", Toast.LENGTH_SHORT).show();
                }else {
                    Double amountNum = Double.parseDouble(amount.getText().toString());
                    Double sizeNum = Double.parseDouble(size.getText().toString());

                    int decimalPlaces = 0;

                    if(amountNum % 1 != 0) {
                        String amountStr = amount.getText().toString();
                        decimalPlaces = amountStr.length() - amountStr.indexOf('.') - 1;
                    }

                    if(amountNum == 0 || decimalPlaces > 2) {
                        Toast.makeText(TipCalculatorActivity.this, "Invalid check amount", Toast.LENGTH_SHORT).show();
                    }else if(sizeNum == 0 || sizeNum % 1 != 0) {
                        Toast.makeText(TipCalculatorActivity.this, "Invalid party size", Toast.LENGTH_SHORT).show();
                    }else {
                        double tip15ansNum = amountNum * 0.15 / sizeNum;
                        double tip20ansNum = amountNum * 0.20 / sizeNum;
                        double tip25ansNum = amountNum * 0.25 / sizeNum;
                        double total15ansNum = amountNum / sizeNum + tip15ansNum;
                        double total20ansNum = amountNum / sizeNum + tip20ansNum;
                        double total25ansNum = amountNum / sizeNum + tip25ansNum;
                        tip15ans.setText(String.valueOf(Math.round(tip15ansNum)));
                        tip20ans.setText(String.valueOf(Math.round(tip20ansNum)));
                        tip25ans.setText(String.valueOf(Math.round(tip25ansNum)));
                        total15ans.setText(String.valueOf(Math.round(total15ansNum)));
                        total20ans.setText(String.valueOf(Math.round(total20ansNum)));
                        total25ans.setText(String.valueOf(Math.round(total25ansNum)));
                    }
                }
            }
        });
    }
}