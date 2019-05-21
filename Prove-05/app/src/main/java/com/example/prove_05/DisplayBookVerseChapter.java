package com.example.prove_05;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayBookVerseChapter extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_display_book_verse_chapter);

    // get intent that started this activity
    Intent intent = getIntent();

    // get Strings
    String book = intent.getStringExtra(MainActivity.BOOK_MESSAGE);
    String chapter = intent.getStringExtra(MainActivity.CHAPTER_MESSAGE);
    String verse = intent.getStringExtra(MainActivity.VERSE_MESSAGE);

    //Message Log
    Log.i(MainActivity.TAG, "Received intent with " + book + " " + chapter + ":" + verse);

    TextView textView = findViewById(R.id.textDisplayBookVerseChapter);
    textView.setText(book + " " + chapter + ":" + verse);
  }

  public void onSave(View view) {
    SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
    Editor editor = pref.edit();

    editor.putString("Book", getIntent().getStringExtra(MainActivity.BOOK_MESSAGE));
    editor.putString("Chapter", getIntent().getStringExtra(MainActivity.CHAPTER_MESSAGE));
    editor.putString("Verse", getIntent().getStringExtra(MainActivity.VERSE_MESSAGE));

    editor.commit();
    Toast.makeText(this, "Scripture was saved!", Toast.LENGTH_SHORT).show();
  }
}
