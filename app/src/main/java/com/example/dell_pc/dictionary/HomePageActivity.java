package com.example.dell_pc.dictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

    public void addNewWord(View view) {
        //to add new word
        Intent intent1 = new Intent(this,AddWordActivity.class);
        startActivity(intent1);
    }

    public void gotoDictionary(View view) {
        //goto the dictionary
        Intent intent2 = new Intent(this,DictionaryActivity.class);
        startActivity(intent2);

    }
}
