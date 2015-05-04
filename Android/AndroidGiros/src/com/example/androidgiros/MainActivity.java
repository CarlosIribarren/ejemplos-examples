package com.example.androidgiros;


import java.text.DecimalFormat;
import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener {

private SensorManager sensor;
Sensor accelerometer;
Sensor magnetometer;
TextView gyroscope;


 /** Called when the activity is first created. */
 @Override
 public void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
   setContentView(R.layout.activity_main);

    gyroscope = (TextView) this.findViewById(R.id.gyroscope);

sensor = (SensorManager)getSystemService(SENSOR_SERVICE);
accelerometer = sensor.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
magnetometer = sensor.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
}

public void onResume(){
  super.onResume();
  sensor.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME);
  sensor.registerListener(this, magnetometer, SensorManager.SENSOR_DELAY_GAME);
}

public void onPause(){
  super.onPause();
  sensor.unregisterListener(this);
 }
 @Override
 public void onAccuracyChanged(Sensor sensor, int accuracy) {
// TODO Auto-generated method stub

 }
 float[] gravity;
 float[] gmagnetic;


 double azimuth = 0 , pitch = 0 , roll = 0  ; 

  public double toTwoDecimals(double d){
DecimalFormat toTwoDec = new DecimalFormat("#.##");
return Double.valueOf(toTwoDec.format(d));
   }
   @Override
    public void onSensorChanged(SensorEvent event) {
// TODO Auto-generated method stub
if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
    gravity= event.values;
if(event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD)
    gmagnetic = event.values;
if( gravity != null && gmagnetic !=null){
    float R[] = new float[9];
    float I[] = new float[9];
    boolean success = SensorManager.getRotationMatrix(R, I, gravity, gmagnetic);
    if(success){
        float orientation[] = new float[3];
        SensorManager.getOrientation(R, orientation);

         azimuth = (double) toTwoDecimals(Math.toDegrees(event.values[0])); 
         pitch = (double)toTwoDecimals(Math.toDegrees(event.values[1]));
         roll = (double) toTwoDecimals(Math.toDegrees(event.values[2]));

        gyroscope.setText("Azimuth: " + azimuth + 
                "nPitch: " + pitch + 
                "nRoll: " + roll);
    }
}
  }

  }
	/*
azimuth = (double) toTwoDecimals(Math.toDegrees(orientation[0])); 
pitch = (double)toTwoDecimals(Math.toDegrees(orientation[1]));
roll = (double) toTwoDecimals(Math.toDegrees(orientation[2]));
*/