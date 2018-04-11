package com.example.dell_pc.dictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class AddWordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);
    }

    public void addThisWordClick(View view) throws FileNotFoundException {
        EditText et = (EditText)findViewById(R.id.your_word);
        String newword = et.getText().toString();
        EditText et2 = (EditText)findViewById(R.id.defn);
        String newdef = et2.getText().toString();

        PrintStream output = new PrintStream(openFileOutput("out.txt",MODE_PRIVATE|MODE_APPEND));
        output.println(newword + "\t" + newdef);
        output.close();
        finish();
        Toast.makeText(this,"Successfully added",Toast.LENGTH_SHORT).show();
    }
}
