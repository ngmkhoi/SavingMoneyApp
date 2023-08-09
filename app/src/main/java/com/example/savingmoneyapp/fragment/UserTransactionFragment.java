package com.example.savingmoneyapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.savingmoneyapp.R;
import com.example.savingmoneyapp.adapter.UserTransactionAdapter;
import com.example.savingmoneyapp.database.DatabaseHelper;
import com.example.savingmoneyapp.model.UserTransaction;

import java.util.ArrayList;
import java.util.List;

public class UserTransactionFragment extends Fragment {
    private RecyclerView rcViewUserTransaction;
    private DatabaseHelper databaseHelper;
    private List<UserTransaction> listUserTransaction = new ArrayList<>();

    public UserTransactionFragment() {
        // Required empty public constructor
    }
    public static UserTransactionFragment newInstance(String param1, String param2) {
        UserTransactionFragment fragment = new UserTransactionFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        databaseHelper = new DatabaseHelper(getContext());
        View v = inflater.inflate(R.layout.fragment_user_transaction, container, false);
        anhXa(v);
        listUserTransaction = databaseHelper.getAllUserTransaction();
        if(listUserTransaction.size() > 0){
            UserTransactionAdapter userTransactionAdapter = new UserTransactionAdapter(listUserTransaction, getContext());
            rcViewUserTransaction.setAdapter(userTransactionAdapter);
            rcViewUserTransaction.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        return v;
    }

    public void anhXa(View v){
        rcViewUserTransaction = v.findViewById(R.id.recycleUserTransaction);
    }
}