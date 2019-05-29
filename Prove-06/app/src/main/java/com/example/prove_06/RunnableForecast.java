package com.example.prove_06;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.lang.ref.WeakReference;

public class RunnableForecast implements Runnable {


  WeakReference<Activity> activity;
  String town;

  public RunnableForecast (Activity activity, String town) {
    this.activity = new WeakReference<>(activity);
    this.town  = town;
  }

  @Override
  public void run() {
    Log.i(MainActivity.TAG, "Getting Forecast for " + town);

    final WeatherForecast forecast = WeatherMain.getForecast(town);



    if (activity != null)
      activity
          .get()
          .runOnUiThread(
              new Runnable() {
                @Override
                public void run() {
                  ArrayAdapter<WeatherForecastItem> itemsAdapter = new ArrayAdapter<WeatherForecastItem>(activity.get(),android.R.layout.simple_expandable_list_item_1, forecast.getList());
                  ListView listView = activity.get().findViewById(R.id.listViewForecast);
                  listView.setAdapter(itemsAdapter);
                }
              });
  }
}
