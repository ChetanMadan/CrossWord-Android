package com.pcr.dexter.crossword;

import android.annotation.TargetApi;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public ArrayList<String> words = new ArrayList<>();

    public String[][] correctChars = new String[6][6];

    public String[][] toCheck = new String[6][6];
    private TextView[][] textviews = new TextView[6][6];
    Random rand = new Random();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button abc = (Button) findViewById(R.id.button3);



        textviews[0][0] = (TextView) findViewById(R.id.textView1);
        textviews[1][0] = (TextView) findViewById(R.id.textView2);
        textviews[2][0] = (TextView) findViewById(R.id.textView3);
        textviews[3][0] = (TextView) findViewById(R.id.textView4);
        textviews[4][0] = (TextView) findViewById(R.id.textView5);
        textviews[5][0] = (TextView) findViewById(R.id.textView6);
        textviews[0][1] = (TextView) findViewById(R.id.textView7);
        textviews[1][1] = (TextView) findViewById(R.id.textView8);
        textviews[2][1] = (TextView) findViewById(R.id.textView9);
        textviews[3][1] = (TextView) findViewById(R.id.textView10);
        textviews[4][1] = (TextView) findViewById(R.id.textView11);
        textviews[5][1] = (TextView) findViewById(R.id.textView12);
        textviews[0][2] = (TextView) findViewById(R.id.textView13);
        textviews[1][2] = (TextView) findViewById(R.id.textView14);
        textviews[2][2] = (TextView) findViewById(R.id.textView15);
        textviews[3][2] = (TextView) findViewById(R.id.textView16);
        textviews[4][2] = (TextView) findViewById(R.id.textView17);
        textviews[5][2] = (TextView) findViewById(R.id.textView18);
        textviews[0][3] = (TextView) findViewById(R.id.textView19);
        textviews[1][3] = (TextView) findViewById(R.id.textView20);
        textviews[2][3] = (TextView) findViewById(R.id.textView21);
        textviews[3][3] = (TextView) findViewById(R.id.textView22);
        textviews[4][3] = (TextView) findViewById(R.id.textView23);
        textviews[5][3] = (TextView) findViewById(R.id.textView24);
        textviews[0][4] = (TextView) findViewById(R.id.textView25);
        textviews[1][4] = (TextView) findViewById(R.id.textView26);
        textviews[2][4] = (TextView) findViewById(R.id.textView27);
        textviews[3][4] = (TextView) findViewById(R.id.textView28);
        textviews[4][4] = (TextView) findViewById(R.id.textView29);
        textviews[5][4] = (TextView) findViewById(R.id.textView30);
        textviews[0][5] = (TextView) findViewById(R.id.textView31);
        textviews[1][5] = (TextView) findViewById(R.id.textView32);
        textviews[2][5] = (TextView) findViewById(R.id.textView33);
        textviews[3][5] = (TextView) findViewById(R.id.textView34);
        textviews[4][5] = (TextView) findViewById(R.id.textView35);
        textviews[5][5] = (TextView) findViewById(R.id.textView36);



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


        String startWord = "";

        while (startWord.length() != 6) {
            startWord = words.get(rand.nextInt(words.size()));

        }
        char[] chStartWord = startWord.toCharArray();
        int i;
        int row = rand.nextInt(5);
        int column = rand.nextInt(5);

        setwordVert(0, 0, startWord);


        String c2 = "" + textviews[0][2].getText();
        String w2 = "";

        for (i = 0; i < words.size(); i++) {
            w2 = words.get(i);
            String cht = "" + w2.charAt(0);
            if (Character.toString(w2.charAt(0)).equalsIgnoreCase(c2) && w2.length() == 6) {
                break;
            } else if (Character.toString(w2.charAt(0)).equalsIgnoreCase(c2) && w2.length() == 5) {
                break;
            } else {

            }
        }


        setwordHoriz(0, 2, w2);


        String c5 = "" + textviews[0][5].getText();
        String w5 = "";
        for (i = 0; i < words.size(); i++) {
            w5 = words.get(i);
            if (Character.toString(w5.charAt(0)).equalsIgnoreCase(c5) && w5.length() == 6 && w5 != w2) {
                break;
            } else if (Character.toString(w5.charAt(0)).equalsIgnoreCase(c5) && w5.length() == 5 && w5 != w2) {
                break;
            }


        }

        setwordHoriz(0, 5, w5);


        String r5 = "" + textviews[5][5].getText();
        String wr5 = "";
        String temp = "" + textviews[5][2].getText();
        if (textviews[5][2].getText() == null) {
            for (i = 0; i < words.size(); i++) {
                wr5 = words.get(i);
                if (Character.toString(wr5.charAt(wr5.length() - 1)).equalsIgnoreCase(r5) && wr5.length() == 6) {
                    break;
                } else if (wr5.length() == 5) {
                    break;
                } else if (wr5.length() == 4) {
                    break;
                }
            }
        } else if (textviews[5][2].getText() != null) {
            for (i = 0; i < words.size(); i++) {
                wr5 = words.get(i);
                if (Character.toString(w5.charAt(w5.length() - 1)).equalsIgnoreCase(r5) && Character.toString(wr5.charAt(2)).equalsIgnoreCase(String.valueOf(textviews[5][2].getText())) && wr5.length() == 6) {
                    break;
                } else if (Character.toString(w5.charAt(w5.length() - 1)).equalsIgnoreCase(r5) && Character.toString(wr5.charAt(2)).equalsIgnoreCase(String.valueOf(textviews[5][2].getText())) && wr5.length() == 5) {
                    break;
                } else if (Character.toString(w5.charAt(w5.length() - 1)).equalsIgnoreCase(r5) && Character.toString(wr5.charAt(2)).equalsIgnoreCase(temp) && wr5.length() == 4) {
                    break;
                }
            }
        }
        setwordVert(5, 0, wr5);


        String c11 = "" + textviews[5][0].getText();
        String c12 = "" + textviews[0][0].getText();
        String wr1 = "";
        for (i = 0; i < words.size(); i++) {
            wr1 = words.get(i);
            if (wr1.length() == 6 && Character.toString(wr1.charAt(0)).equalsIgnoreCase(c12) && Character.toString(wr1.charAt(5)).equalsIgnoreCase(c11)) {
                break;
            } else if (wr1.length() == 6 && Character.toString(wr1.charAt(0)).equalsIgnoreCase(c12)) {
                break;
            }

        }
        setwordHoriz(0, 0, wr1);


        c11 = "" + textviews[1][0].getText();
        c12 = "" + textviews[1][2].getText();
        String c22 = "" + textviews[1][5].getText();

        String wr2 = "";
        for (i = 0; i < words.size(); i++) {
            wr2 = words.get(i);
            if (wr2.length() == 6 && Character.toString(wr2.charAt(0)).equalsIgnoreCase(c11) && Character.toString(wr2.charAt(2)).equalsIgnoreCase(c12) && Character.toString(wr2.charAt(5)).equalsIgnoreCase(c22)) {
                break;
            } else if (wr2.length() == 5 && Character.toString(wr2.charAt(0)).equalsIgnoreCase(c11) && Character.toString(wr2.charAt(2)).equalsIgnoreCase(c11)) {
                break;
            } else if (wr2.length() == 4 && Character.toString(wr2.charAt(0)).equalsIgnoreCase(c11) && Character.toString(wr2.charAt(2)).equalsIgnoreCase(c11)) {
                break;
            }
        }
        setwordVert(1, 0, wr2);


        c11 = "" + textviews[3][0].getText();
        c12 = "" + textviews[3][2].getText();
        c22 = "" + textviews[3][5].getText();


        wr2 = "";
        for (i = 0; i < words.size(); i++) {
            wr2 = words.get(i);
            if (wr2.length() == 6 && Character.toString(wr2.charAt(0)).equalsIgnoreCase(c11) && Character.toString(wr2.charAt(2)).equalsIgnoreCase(c12) && Character.toString(wr2.charAt(5)).equalsIgnoreCase(c22)) {
                break;
            } else if (wr2.length() == 5 && Character.toString(wr2.charAt(0)).equalsIgnoreCase(c11) && Character.toString(wr2.charAt(2)).equalsIgnoreCase(c12)) {
                break;
            } else if (wr2.length() == 4 && Character.toString(wr2.charAt(0)).equalsIgnoreCase(c11) && Character.toString(wr2.charAt(2)).equalsIgnoreCase(c12)) {
                break;
            }
        }
        setwordVert(3, 0, wr2);


        fillBlack();


        int j = 0;
        for (i = 0; i < 6; i++) {
            for (j = 0; j < 6; j++) {
                correctChars[i][j] = textviews[i][j].getText().toString();
            }
        }





    }



    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void fillBlack(){
        int i=0;
        int j=0;
        for (i = 0; i <= 5; i++) {
            for(j=0;j<=5;j++){
                String str= ""+textviews[i][j].getText();
                if(str==""){
                    textviews[i][j].setBackgroundColor(Color.BLACK);
                  }
            }
        }
    }
    private void setwordHoriz(int rowStart, int columnStart, String wordToPrint) {
        int i = 0;

        char[] chStartWord = wordToPrint.toCharArray();

        for (i = rowStart; i < wordToPrint.length(); i++) {
            textviews[i][columnStart].setText(Character.toString(chStartWord[i]));
        }
    }


    private void setwordVert(int rowStart, int columnStart, String wordToPrint) {
        int i = 0;

        char[] chStartWord = wordToPrint.toCharArray();

        for (i = columnStart; i < wordToPrint.length(); i++) {
            textviews[rowStart][i].setText(Character.toString(chStartWord[i]));
        }
    }



    public void clicked(View view){
        int i =0,j=0;
        for(i=0;i<6;i++){
            for(j=0;j<6;j++){
                if(rand.nextBoolean()){
                    textviews[i][j].setText("");
                }
            }
        }
    }

    public void check(View view) {
        int i = 0, j = 0;
        for (i = 0; i < 6; i++) {
            for (j = 0; j < 6; j++) {
                toCheck[i][j] = textviews[i][j].getText().toString();
            }
        }

        if(toCheck==correctChars){
            textviews[0][0].setText("hello");
        }
        else
            textviews[0][0].setText("hi");
    }
}
