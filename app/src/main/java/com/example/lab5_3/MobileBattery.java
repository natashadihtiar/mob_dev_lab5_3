package com.example.lab5_3;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
//Класс проверки заряда телефона
public class MobileBattery extends DialogFragment {
    @NonNull
    @Override
    //Открытие диалога
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    //Создание нового диалогового окна
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Заряд батареи");
        builder.setMessage("Низкий заряд батареи");
        //Завершение диалога
        builder.setPositiveButton("Oк", null);
        return builder.create();
    }
}
