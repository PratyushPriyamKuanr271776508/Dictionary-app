package com.example.dell_pc.dictionary;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class DictionaryActivity extends AppCompatActivity {
private MediaPlayer mp;
private HashMap<String,String> dictionary = new HashMap<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        mp = MediaPlayer.create(this,R.raw.jeopardy_theme);
        mp.start();

ArrayList<String> al = new ArrayList<>();
try {
    Scanner scan = new Scanner(getResources().openRawResource(R.raw.words));

    Scanner scan1 = new Scanner(openFileInput("out.txt"));


    while (scan.hasNextLine()) {
        String w = scan.nextLine();
        String[] s = w.split("\t");
        dictionary.put(s[0], s[1]);
        al.add(s[0]);
    }
    while (scan1.hasNextLine()) {
        String w = scan1.nextLine();
        String[] s = w.split("\t");
        dictionary.put(s[0], s[1]);
        al.add(s[0]);
    }

}catch (Exception e){
    e.printStackTrace();
}
        ListView lv = (ListView) findViewById(R.id.Word_list);
ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, al);
lv.setAdapter(adapter);
lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String word = parent.getItemAtPosition(position).toString();
        String defn = dictionary.get(word);
        Toast.makeText(DictionaryActivity.this, defn, Toast.LENGTH_SHORT).show();
    }
});
    }
    protected void onPause(){
        super.onPause();
        mp.stop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mp.start();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
