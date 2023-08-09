package com.example.savingmoneyapp.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.savingmoneyapp.R;
import com.example.savingmoneyapp.model.User;
import com.example.savingmoneyapp.ui.SignInActivity;

public class SettingFragment extends Fragment {
    FrameLayout chooseDeleteAccount, chooseLogout;
    User user;
    public SettingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_setting, container, false);
        anhXa(v);

        chooseDeleteAccount.setOnClickListener(clickToDeleteAccount());
        chooseLogout.setOnClickListener(clickToLogoutAccount());
        return v;
    }

    @NonNull
    private View.OnClickListener clickToLogoutAccount() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), SignInActivity.class);
                startActivity(i);
                getActivity().finish();
            }
        };
    }

    @NonNull
    private View.OnClickListener clickToDeleteAccount() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        };
    }

    public void anhXa(View v){
        chooseDeleteAccount = v.findViewById(R.id.chooseDeleteAccount);
        chooseLogout = v.findViewById(R.id.chooseLogout);
    }
}