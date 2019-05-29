package com.example.prove_06;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;
import java.lang.ref.WeakReference;

public class RunnableCurrentTemp implements Runnable {

  WeakReference<Activity> activity;
  String town;

  public RunnableCurrentTemp(Activity activity, String town) {
    this.activity = new WeakReference<>(activity);
    this.town = town;
  }

  @Override
  public void run() {
    Log.i(MainActivity.TAG, "Getting Current Temp for " + town);

    final WeatherConditions conditions = WeatherMain.getConditions(town);

    Log.i(MainActivity.TAG, "Current Temp: " + conditions.getMeasurements().get("temp").toString());

    if (activity != null) {
      activity
          .get()
          .runOnUiThread(
              new Runnable() {
                @Override
                public void run() {
                  Toast.makeText(
                          activity.get(),
                          "Current Temp: " + conditions.getMeasurements().get("temp"),
                          Toast.LENGTH_SHORT)
                      .show();
                }
              });
    }
  }
}
