package com.example.prove_06;

import android.app.Activity;
import android.widget.Toast;
import java.lang.ref.WeakReference;

public class OddCountRunnable implements Runnable {

  WeakReference<Activity> activity;

  public OddCountRunnable(Activity activity) {
    this.activity = new WeakReference<Activity>(activity);
  }

  @Override
  public void run() {
    int count = 1;
    while (count < 100) {
      System.out.println("Odd Count: " + count);
      try {
        Thread.sleep(250);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      count += 2;
    }

    if(activity != null)
    {
    activity.get().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        Toast.makeText(activity.get(), "Finished Counting by Odds", Toast.LENGTH_SHORT).show();
      }
    });
    }
  }
}
