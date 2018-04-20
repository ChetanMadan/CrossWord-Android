package com.pcr.dexter.crossword;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class intro extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);
    }


    public void startClicked(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

    public void onExit(View view){
        finish();
    }
}
