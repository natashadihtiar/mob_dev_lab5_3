package com.example.lab5_3;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
//Класс режима "в самолете"
public class MobileAirplane extends DialogFragment {
    boolean isAirplaneModeOn;

    public MobileAirplane(boolean isAirplaneModeOn) {
        this.isAirplaneModeOn = isAirplaneModeOn;
    }

    @NonNull
    @Override
    //Открытие диалога
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    //Создание нового диалогового окна
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Режим в самолете");
        //Проверка включен или выключен режим
        if(isAirplaneModeOn) {
            builder.setMessage("Вкл.");
        }
        else {
            builder.setMessage("Выкл.");
        }
        //Завершение диалога
        builder.setPositiveButton("Ок", null);
        return builder.create();
    }
}
