package com.jesuspinar.caracruz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        Button btnHead =  findViewById(R.id.btnHead);
        Button btnTail =  findViewById(R.id.btnTail);

        btnHead.setOnClickListener(v -> initGame(true));
        btnTail.setOnClickListener(v -> initGame(false));
    }

    private void initGame(boolean isHead) {
        //Random try
        int rNum = random(0,1);
        //Render img
        if (rNum == 0){
            imageView.setImageResource(R.drawable.euro_cara);
        }else{
            imageView.setImageResource(R.drawable.euro_cruz);
        }

        //Filter 0 head 1 tail
        if(isHead && rNum == 0){
            Toast.makeText(this,getString(R.string.winText), Toast.LENGTH_SHORT).show();
            displayText(true);
        }else if(!isHead && rNum == 1){
            Toast.makeText(this,getString(R.string.winText), Toast.LENGTH_SHORT).show();
            displayText(true);
        }else {
            Toast.makeText(this,getString(R.string.loseText), Toast.LENGTH_SHORT).show();
            displayText(false);
        }

        //Reset result
        resetResult();
    }
    public int random(int min, int max){
        Random r = new Random();
        return r.nextInt(max-min+1)+min;
    }

    private void displayText(boolean isWin) {
        TextView tvResult = findViewById(R.id.tvResult);
        if(isWin){
            tvResult.setText(getString(R.string.winText));
        }else{
            tvResult.setText(getString(R.string.loseText));
        }
        tvResult.setVisibility(View.VISIBLE);
    }

    private void resetResult() {
        //TODO:
    }
}