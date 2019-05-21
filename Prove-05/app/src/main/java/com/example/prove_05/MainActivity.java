package com.example.prove_05;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  public static final String TAG = "MyActivity";
  public static final String BOOK_MESSAGE = "com.example.prove_05.BOOK";
  public static final String CHAPTER_MESSAGE = "com.example.prove_05.CHAPTER";
  public static final String VERSE_MESSAGE = "com.example.prove_05.VERSE";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void sendMessage(View view) {

    // Get references to the text boxes
    EditText editBook = (EditText) findViewById(R.id.editBook);
    EditText editChapter = (EditText) findViewById(R.id.editChapter);
    EditText editVerse = (EditText) findViewById(R.id.editVerse);

    Log.i(
        TAG,
        "About to create intent with "
            + editBook.getText().toString()
            + " "
            + editChapter.getText().toString()
            + ":"
            + editVerse.getText().toString());

    // Create new Intent
    Intent intent = new Intent(this, DisplayBookVerseChapter.class);

    // Assign values for across
    intent.putExtra(BOOK_MESSAGE, editBook.getText().toString());
    intent.putExtra(CHAPTER_MESSAGE, editChapter.getText().toString());
    intent.putExtra(VERSE_MESSAGE, editVerse.getText().toString());

    // Start new Activity
    startActivity(intent);
  }

  public void onLoad(View view) {
    //Get Application Preferences
    SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode

    //Log Message
    Log.i(TAG, "Attempting to Load!");

    //Retrieve Variables
    String book = pref.getString("Book", null);
    String chapter = pref.getString("Chapter", null);
    String verse = pref.getString("Verse", null);

    //Get EditText Box References
    EditText editBook = (EditText) findViewById(R.id.editBook);
    EditText editChapter = (EditText) findViewById(R.id.editChapter);
    EditText editVerse = (EditText) findViewById(R.id.editVerse);

    //Assign Variables back
    editBook.setText(book);
    editChapter.setText(chapter);
    editVerse.setText(verse);

    Toast.makeText(this, "Loaded Scripture!", Toast.LENGTH_SHORT).show();
  }
}
