package com.example.lab5_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
//Отслеживает нажатия на различные кнопки
public class MainActivity extends AppCompatActivity {
    //Нажатие на кнопку "Камера"
    private final BroadcastReceiver cameraRec = new BroadcastReceiver() {

        @Override
        public void onReceive(Context c, Intent intent) {
                startCameraDialog();
        }
    };
    //Нажатие на кнопку "Режим в самолете"
    private final BroadcastReceiver airplanemodeRec = new BroadcastReceiver() {

        @Override
        public void onReceive(Context c, Intent intent) {
                boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);
                Log.e("e","WW");
                startAirplaneModeDialog(isAirplaneModeOn);
        }
    };
    //Получение сообщения о низком заряде батареи
    private final BroadcastReceiver batteryRec = new BroadcastReceiver() {

        @Override
        public void onReceive(Context c, Intent intent) {
            if (intent.getAction().equals("android.intent.action.BATTERY_LOW")) {
                startBatteryDialog();
            }
        }
    };
    //диалоговое окно с сообщением о низком заряде батареи
    private void startBatteryDialog() {
        MobileBattery dialog = new MobileBattery();
        dialog.show(getSupportFragmentManager(),"dlgBattery");
    }
    //диалоговое окно о начале работы камеры
    private void startCameraDialog() {
        MobileCamera dialog = new MobileCamera();
        dialog.show(getSupportFragmentManager(),"dlgCamera");
    }
    //диалоговое окно о вкл или выкл режима в самолете
    private void startAirplaneModeDialog(boolean isAirplaneModeOn) {
        MobileAirplane dialog = new MobileAirplane(isAirplaneModeOn);
        dialog.show(getSupportFragmentManager(),"dlgAirplane");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    //Приемкник
    protected void onStart() {
        //Начала работы приемника
        super.onStart();
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_LOW);
        Intent batteryStatus = registerReceiver(batteryRec, ifilter);
        IntentFilter ifilter1 = new IntentFilter(Intent.ACTION_CAMERA_BUTTON);
        Intent cameraStatus = registerReceiver(cameraRec, ifilter1);
        IntentFilter ifilter2 = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        Intent airplanemodeStatus = registerReceiver(airplanemodeRec, ifilter2);
    }

    @Override
    protected void onStop() {
        //Конец работы приемника
        super.onStop();
        if (batteryRec != null)
            unregisterReceiver(batteryRec);
        if (cameraRec != null)
            unregisterReceiver(cameraRec);
        if (airplanemodeRec != null)
            unregisterReceiver(airplanemodeRec);
    }
}

