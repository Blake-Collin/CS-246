package com.example.prove_06;

import android.app.Activity;
import android.widget.Toast;
import java.lang.ref.WeakReference;

public class EvenCountRunnable implements Runnable {

WeakReference<Activity> activity;

  public EvenCountRunnable(Activity activity) {
    this.activity = new WeakReference<Activity>(activity);
  }

  @Override
  public void run() {
    int count = -2;
    while (count < 100) {
      count += 2;
      System.out.println("Even Count: " + count);
      try {
        Thread.sleep(250);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    if(activity != null)
    {
      activity.get().runOnUiThread(new Runnable() {
        @Override
        public void run() {
          Toast.makeText(activity.get(), "Finished Counting by Evens", Toast.LENGTH_SHORT).show();
        }
      });
    }
  }
}
