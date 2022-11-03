package com.example.sensor;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
public class Linear extends AppCompatActivity {

    TextView textView5;
    SensorManager sm;
    List list;

    SensorEventListener sel = new SensorEventListener() {
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] values = sensorEvent.values;
            if (sensorEvent.values[2] < 1) {
                textView5.setText("x: " + values[0] + " m/s²\ny: " + values[1] + " m/s²\nz: " + values[2] + " m/s²");
                getWindow().getDecorView().setBackgroundColor(Color.WHITE);
            } else {
                textView5.setText("x: " + values[0] + " m/s²\ny: " + values[1] + " m/s²\nz: " + values[2] + " m/s²");
                getWindow().getDecorView().setBackgroundColor(Color.RED);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear);
        setTitle("TYPE_LINEAR_ACCELERATION");

        textView5 = findViewById(R.id.textView5);
        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        list = sm.getSensorList(Sensor.TYPE_LINEAR_ACCELERATION); //Type Sensor
        if (list.size() > 0) {
            sm.registerListener(sel, (Sensor) list.get(0), SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            Toast.makeText(getBaseContext(), "Sorry, sensor not available for this device.", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onStop() {
        if (list.size() > 0) {
            sm.unregisterListener(sel);
        }
        super.onStop();
    }
}
