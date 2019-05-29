package com.example.prove_06;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  public static final String TAG = "MyActivity";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void onCurrentTempPress(View view) {
    EditText editTown = findViewById(R.id.editTown);

    RunnableCurrentTemp r = new RunnableCurrentTemp(this ,editTown.getText().toString());
    Thread thread = new Thread(r,"ThreadCurrentTemp");
    thread.start();
  }

  public void onForecastPress(View view) {
    EditText editTown = findViewById(R.id.editTown);

    RunnableForecast r = new RunnableForecast(this ,editTown.getText().toString());
    Thread thread = new Thread(r,"ThreadForecast");
    thread.start();
  }
}
