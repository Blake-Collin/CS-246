package com.example.prove_06;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void onPushCountEven(View view) {
    //Create new runnable
    EvenCountRunnable r = new EvenCountRunnable(this);

    //Create new thread and start it
    Thread thread2 = new Thread(r, "Thread 2");
    thread2.start();
  }

  public void onPushCountOdd(View view) {
    //Create new runnable
    OddCountRunnable r = new OddCountRunnable(this);

    //Create new thread and start it
    Thread thread1 = new Thread(r, "Thread 1");
    thread1.start();
  }
}
