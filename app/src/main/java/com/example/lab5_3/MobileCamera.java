package com.example.lab5_3;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
//Класс нажатия на кнопку "Камера"
public class MobileCamera extends DialogFragment {
    @NonNull
    @Override
    //Начало диалога
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //Создание нового диалогового окна
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Камера телефона");
        builder.setMessage("Открытие камеры");
        //Завершение диалога
        builder.setPositiveButton("Oк", null);
        return builder.create();
    }
}
