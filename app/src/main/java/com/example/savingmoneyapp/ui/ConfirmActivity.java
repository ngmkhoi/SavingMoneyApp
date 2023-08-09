package com.example.savingmoneyapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.savingmoneyapp.R;
import com.example.savingmoneyapp.database.DatabaseHelper;

public class ConfirmActivity extends AppCompatActivity {
    private TextView txtSTK, spendingTerm, txtPercent, txtMoneySend, txtMethod;
    private Button btnSave;
    private String nameWallet, spTerm, percentage, moneySending, methodPayment;
    private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        databaseHelper = new DatabaseHelper(this);
        anhXa();
        getStringExtrasData();
        setTextTxt();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getpricesInWallet = databaseHelper.getPrices(nameWallet);
                Integer convertPricesToInt = Integer.parseInt(getpricesInWallet);
                Integer convertPricesSendToInt = Integer.parseInt(moneySending);
                if(convertPricesSendToInt > convertPricesToInt){
                    Toast.makeText(ConfirmActivity.this, "Số tiền nạp nhỏ hơn số tiền trong ví", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(ConfirmActivity.this, SeeProfitActivity.class);
                    startActivity(i);
                    finish();
                }
                else{
                    databaseHelper.insertSavingBank(nameWallet, spTerm, percentage, moneySending, methodPayment);
                    databaseHelper.insertSavingMoneyTransaction(moneySending);
                    Integer updatePrices = convertPricesToInt - convertPricesSendToInt;
                    String convertUpdatePricesToString = updatePrices.toString();
                    databaseHelper.changeMoney(nameWallet, convertUpdatePricesToString);
                    Toast.makeText(ConfirmActivity.this, "Đã mở sổ tiết kiệm thành công", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }

    private void anhXa() {
        txtSTK = findViewById(R.id.tvStk);
        spendingTerm = findViewById(R.id.tvThang);
        txtPercent = findViewById(R.id.tvPhanTram);
        txtMoneySend = findViewById(R.id.tvSoTien);
        txtMethod = findViewById(R.id.tvShowHthuc);
        btnSave = findViewById(R.id.btn_XacNhan);
    }
    private void getStringExtrasData() {
        Intent i = getIntent();
        nameWallet = i.getStringExtra("namewallet");
        spTerm = i.getStringExtra("sendingTerm");
        percentage = databaseHelper.getPercentage(spTerm);
        moneySending = i.getStringExtra("moneySend");
        methodPayment = i.getStringExtra("nameMethodPayment");
    }
    private void setTextTxt() {
        txtSTK.setText(nameWallet);
        spendingTerm.setText(spTerm);
        txtPercent.setText(percentage);
        txtMoneySend.setText(moneySending);
        txtMethod.setText(methodPayment);
    }

}