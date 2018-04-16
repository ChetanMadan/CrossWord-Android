package com.pcr.dexter.crossword;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public ArrayList<String> words = new ArrayList<>();


    private TextView[] textviews = new TextView[37];
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textviews[0] = (TextView) findViewById(R.id.textView1);
        textviews[1] = (TextView) findViewById(R.id.textView2);
        textviews[2] = (TextView) findViewById(R.id.textView3);
        textviews[3] = (TextView) findViewById(R.id.textView4);
        textviews[4] = (TextView) findViewById(R.id.textView5);
        textviews[5] = (TextView) findViewById(R.id.textView6);
        textviews[6] = (TextView) findViewById(R.id.textView7);
        textviews[7] = (TextView) findViewById(R.id.textView8);
        textviews[8] = (TextView) findViewById(R.id.textView9);
        textviews[9] = (TextView) findViewById(R.id.textView10);
        textviews[10] = (TextView) findViewById(R.id.textView11);
        textviews[11] = (TextView) findViewById(R.id.textView12);
        textviews[12] = (TextView) findViewById(R.id.textView13);
        textviews[13] = (TextView) findViewById(R.id.textView14);
        textviews[14] = (TextView) findViewById(R.id.textView15);
        textviews[15] = (TextView) findViewById(R.id.textView16);
        textviews[16] = (TextView) findViewById(R.id.textView17);
        textviews[17] = (TextView) findViewById(R.id.textView18);
        textviews[18] = (TextView) findViewById(R.id.textView19);
        textviews[19] = (TextView) findViewById(R.id.textView20);
        textviews[20] = (TextView) findViewById(R.id.textView21);
        textviews[21] = (TextView) findViewById(R.id.textView22);
        textviews[22] = (TextView) findViewById(R.id.textView23);
        textviews[23] = (TextView) findViewById(R.id.textView24);
        textviews[24] = (TextView) findViewById(R.id.textView25);
        textviews[25] = (TextView) findViewById(R.id.textView26);
        textviews[26] = (TextView) findViewById(R.id.textView27);
        textviews[27] = (TextView) findViewById(R.id.textView28);
        textviews[28] = (TextView) findViewById(R.id.textView29);
        textviews[29] = (TextView) findViewById(R.id.textView30);
        textviews[30] = (TextView) findViewById(R.id.textView31);
        textviews[31] = (TextView) findViewById(R.id.textView32);
        textviews[32] = (TextView) findViewById(R.id.textView33);
        textviews[33] = (TextView) findViewById(R.id.textView34);
        textviews[34] = (TextView) findViewById(R.id.textView35);
        textviews[35] = (TextView) findViewById(R.id.textView36);

        AssetManager assetManager = getAssets();
        try {
            InputStream inputStream = assetManager.open("words.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = in.readLine()) != null) {
                String word = line.trim();
                if (2 <= word.length() && word.length() <= 6) {
                    words.add(word);
                }

            }
        } catch (IOException e) {
            Toast toast = Toast.makeText(this, "Couldn't load dictionary fine", Toast.LENGTH_LONG);
        }


        String some = "";
        
        while (some.length() != 6) {
            some = words.get(rand.nextInt(words.size()));

        }
        char[] chsome = some.toCharArray();
        char c = some.charAt(3);
        int i;
        int r = rand.nextInt(6);
        int row = 0;
        switch (r) {
            case 1:
                row = 0;
                break;
            case 2:
                row = 6;
                break;
            case 3:
                row = 12;
                break;
            case 4:
                row = 18;
                break;
            case 5:
                row = 24;
                break;
            case 6:
                row = 30;
                break;
        }

        for (i = 0; i < 6; i++, row++) {
            textviews[row].setText(Character.toString(chsome[i]).toUpperCase());
        }

    }

    private int check() {
        int i=0;
        int j=0;
        while (i++ % 6 != 0) {
            if (textviews[i] == null) {
                i++;
            } else {
                j= i;
            }

            //return (j);
        }
        while (i-- % 6 != 0) {
            if (textviews[i] == null) {
                i--;
            } else {
                j= i;
            }
        }



        while (i > 6) {
            if (textviews[i] == null) {
                i = i - 6;
            } else {
                j= i;
            }
        }

        while (i<=36) {
            if (textviews[i] == null) {
                i = i + 6;
            } else {
                j= i;
            }
        }
        return j;

    }

}