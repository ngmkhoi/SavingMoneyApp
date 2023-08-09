package com.example.savingmoneyapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.savingmoneyapp.R;
import com.example.savingmoneyapp.database.DatabaseHelper;
import com.example.savingmoneyapp.model.UserTransaction;

import java.util.List;

public class UserTransactionAdapter extends RecyclerView.Adapter<UserTransactionAdapter.ViewHolder> {
    private List<UserTransaction> listUserTransaction;
    private Context context;
    private DatabaseHelper databaseHelper;

    public UserTransactionAdapter(List<UserTransaction> listUserTransaction, Context context) {
        this.listUserTransaction = listUserTransaction;
        this.context = context;
        this.databaseHelper = new DatabaseHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.user_transaction_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserTransaction userTransaction = listUserTransaction.get(position);

        String chargedMoney = "0", withdrawMoney = "0", saveMoney = "0";
        if (userTransaction.getAdd_money() != null) chargedMoney = userTransaction.getAdd_money();
        if (userTransaction.getWithdraw_money() != null) withdrawMoney = userTransaction.getWithdraw_money();
        if (userTransaction.getSaving_money_banking() != null) saveMoney = userTransaction.getSaving_money_banking();

        holder.txtWithdrawMoney.setText("Số tiền nạp: " + chargedMoney);
        holder.txtAddMoney.setText("Số tiền rút: " + withdrawMoney);
        holder.txtSavingMoneyBanking.setText("Sổ tiết kiệm đã mở: " + saveMoney);

        /*if(userTransaction.getAdd_money() != null){
            holder.txtAddMoney.setText("Số tiền nạp: " + userTransaction.getAdd_money());
        } else if (userTransaction.getWithdraw_money() != null) {

        }
        holder.txtWithdrawMoney.setText("Số tiền rút: " + userTransaction.getWithdraw_money());
        holder.txtAddMoney.setText("Số tiền nạp: " + userTransaction.getAdd_money());
        holder.txtSavingMoneyBanking.setText("Sổ tiết kiệm đã mở" + userTransaction.getSaving_money_banking());*/

    }

    @Override
    public int getItemCount() {
        return listUserTransaction.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtWithdrawMoney, txtAddMoney, txtSavingMoneyBanking;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtWithdrawMoney = itemView.findViewById(R.id.titleWithDrawMoney);
            txtAddMoney = itemView.findViewById(R.id.titleAddMoney);
            txtSavingMoneyBanking = itemView.findViewById(R.id.titleSavingMoneyBanking);
        }
    }
}
