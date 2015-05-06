package com.example.androidgiroscopio;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener
{
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private Sensor mMagnetometer;
    private Sensor SensorGravity;


    private List<float[]> mRotHist = new ArrayList<float[]>();
    private int mRotHistIndex;
    // Change the value so that the azimuth is stable and fit your requirement
    private int mHistoryMaxLength = 40;
    float[] mGravity;
    float[] mMagnetic;
    float[] mRotationMatrix = new float[9];
    // the direction of the back camera, only valid if the device is tilted up by
    // at least 25 degrees.
    private float mFacing = Float.NaN;

    public static final float TWENTY_FIVE_DEGREE_IN_RADIAN = 0.436332313f;
    public static final float ONE_FIFTY_FIVE_DEGREE_IN_RADIAN = 2.7052603f;
    

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mMagnetometer = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        SensorGravity = mSensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mMagnetometer, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, SensorGravity, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void onSensorChanged(SensorEvent event) {


        if (event.sensor.getType() == Sensor.TYPE_GRAVITY)
        {
            mGravity = event.values.clone();
        }
        else
        {
           mMagnetic = event.values.clone();
        }

        if (mGravity != null && mMagnetic != null)
        {
             if (SensorManager.getRotationMatrix(mRotationMatrix, null, mGravity, mMagnetic))
             {
                 // inclination is the degree of tilt by the device independent of orientation (portrait or landscape)
                 // if less than 25 or more than 155 degrees the device is considered lying flat
                 float inclination = (float) Math.acos(mRotationMatrix[8]);
                 if (inclination < TWENTY_FIVE_DEGREE_IN_RADIAN 
                         || inclination > ONE_FIFTY_FIVE_DEGREE_IN_RADIAN)
                 {
                     // mFacing is undefined, so we need to clear the history
                     clearRotHist();
                     mFacing = Float.NaN;
                 }
                 else
                 {
                     setRotHist();
                     // mFacing = azimuth is in radian
                     mFacing = findFacing(); 
                     TextView testua = (TextView) findViewById(R.id.gyroscope);
                     Double balioa = Math.toDegrees(mFacing);
                     testua.setText(balioa.toString());
                 }
             }
        }
   }

   private void clearRotHist()
   {
       mRotHist.clear();
       mRotHistIndex = 0;
   }

   private void setRotHist()
   {
       float[] hist = mRotationMatrix.clone();
       if (mRotHist.size() == mHistoryMaxLength)
       {
           mRotHist.remove(mRotHistIndex);
       }   
       mRotHist.add(mRotHistIndex++, hist);
       mRotHistIndex %= mHistoryMaxLength;
   }

   private float findFacing()
   {
       float[] averageRotHist = average(mRotHist);
       return (float) Math.atan2(-averageRotHist[2], -averageRotHist[5]);
   }

   public float[] average(List<float[]> values)
   {
       float[] result = new float[9];
       for (float[] value : values)
       {
           for (int i = 0; i < 9; i++)
           {
               result[i] += value[i];
           }
       }

       for (int i = 0; i < 9; i++)
       {
           result[i] = result[i] / values.size();
       }

       return result;
    	
    	
    }
}