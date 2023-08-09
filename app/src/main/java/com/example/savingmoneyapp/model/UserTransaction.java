package com.example.savingmoneyapp.model;

public class UserTransaction {
    private int id_user_transaction;
    private String name_wallet;
    private String withdraw_money;
    private String add_money;
    private String saving_money_banking;

    public UserTransaction(int id_user_transaction, String name_wallet, String withdraw_money, String add_money, String saving_money_banking) {
        this.id_user_transaction = id_user_transaction;
        this.name_wallet = name_wallet;
        this.withdraw_money = withdraw_money;
        this.add_money = add_money;
        this.saving_money_banking = saving_money_banking;
    }

    public UserTransaction() {
    }

    public int getId_user_transaction() {
        return id_user_transaction;
    }

    public void setId_user_transaction(int id_user_transaction) {
        this.id_user_transaction = id_user_transaction;
    }

    public String getName_wallet() {
        return name_wallet;
    }

    public void setName_wallet(String name_wallet) {
        this.name_wallet = name_wallet;
    }

    public String getWithdraw_money() {
        return withdraw_money;
    }

    public void setWithdraw_money(String withdraw_money) {
        this.withdraw_money = withdraw_money;
    }

    public String getAdd_money() {
        return add_money;
    }

    public void setAdd_money(String add_money) {
        this.add_money = add_money;
    }

    public String getSaving_money_banking() {
        return saving_money_banking;
    }

    public void setSaving_money_banking(String saving_money_banking) {
        this.saving_money_banking = saving_money_banking;
    }
}
