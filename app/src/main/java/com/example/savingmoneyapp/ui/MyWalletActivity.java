package com.example.savingmoneyapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.savingmoneyapp.R;
import com.example.savingmoneyapp.adapter.WalletAdapter;
import com.example.savingmoneyapp.database.DatabaseHelper;
import com.example.savingmoneyapp.fragment.HomeFragment;
import com.example.savingmoneyapp.model.Wallet;

import java.util.ArrayList;
import java.util.List;

public class MyWalletActivity extends AppCompatActivity {
    private List<Wallet> listWallet = new ArrayList<>();
    private DatabaseHelper databaseHelper;
    private Button btnAddWallet;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_wallet);
        databaseHelper = new DatabaseHelper(getApplicationContext());
        anhXa();
        listWallet = databaseHelper.getWallet();
        if(listWallet.size() > 0){
            WalletAdapter walletAdapter = new WalletAdapter(listWallet, getApplicationContext());
            recyclerView.setAdapter(walletAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        }
        btnAddWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MyWalletActivity.this, AddWalletActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void anhXa() {
        recyclerView = findViewById(R.id.recyclerView);
        btnAddWallet = findViewById(R.id.btnAddWallet);
    }
}