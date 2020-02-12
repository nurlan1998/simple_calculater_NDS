package com.example.calculaternds;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edAmount;
    private EditText edNds;
    private RadioButton markNds;
    private RadioButton chargeNds;
    private TextView onNds;
    private TextView ndsTextView;
    private TextView amountWithNds;

    private float num1;
    private float num2;

    float amountOnNds;
    float amountNds;
    float allAmountWithNds;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edAmount = findViewById(R.id.edAmount);
        edNds = findViewById(R.id.edNds);
        markNds = findViewById(R.id.markNds);
        chargeNds = findViewById(R.id.chargeNds);
        onNds = findViewById(R.id.onNds);
        ndsTextView = findViewById(R.id.nds);
        amountWithNds = findViewById(R.id.amountWithNds);
    }

    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();
        if (!TextUtils.isEmpty(edAmount.getText().toString().trim()) &&
                !TextUtils.isEmpty(edNds.getText().toString().trim()) ){
            //Если условие выполнилось делаете расчет
            num1 = Float.parseFloat(edAmount.getText().toString());
            num2 = Float.parseFloat(edNds.getText().toString());

            Nds nds = new Nds(num1,num2);

            switch (view.getId()){
            case R.id.chargeNds:
                if (checked) {
                    amountNds = nds.ChargeNds();
                    allAmountWithNds = num1 + amountNds;
                    amountOnNds = allAmountWithNds - amountNds;

                    ndsTextView.setText("" + amountNds);
                    onNds.setText("" + amountOnNds);
                    amountWithNds.setText("" + allAmountWithNds);
                }
                break;
                case R.id.markNds:
                    if(checked){
                        amountNds = nds.MarkNds();
                        allAmountWithNds = num1;
                        amountOnNds = allAmountWithNds - amountNds;
                        onNds.setText("" + amountOnNds);
                        ndsTextView.setText("" + amountNds);
                        amountWithNds.setText("" + allAmountWithNds);
                    }
                    break;
        }
    }else {
            Toast.makeText(this, "Заполните поля", Toast.LENGTH_SHORT).show();
        }
    }

    public void clearOnClick(View view) {
        onNds.setText("0,00");
        ndsTextView.setText("0,00");
        amountWithNds.setText("0,00");
        edNds.setText("");
        edAmount.setText("");
    }
}
