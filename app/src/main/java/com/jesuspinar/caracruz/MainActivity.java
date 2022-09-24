package com.jesuspinar.caracruz;

import android.os.Handler;
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
    Button btnHead;
    Button btnTail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        btnHead = findViewById(R.id.btnHead);
        btnTail = findViewById(R.id.btnTail);

        btnHead.setOnClickListener(v -> {
            initGame(true);
            waitResetResult();
        });
        btnTail.setOnClickListener(v -> {
            initGame(false);
            waitResetResult();

        });
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
        //Filter 0 head, 1 tail
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

    private void waitResetResult() {
        // Block buttons action util handler
        btnHead.setVisibility(View.GONE);
        btnTail.setVisibility(View.GONE);
        Handler handler = new Handler();
        handler.postDelayed((Runnable) () -> {
            //Hides results
            TextView tvResult = findViewById(R.id.tvResult);
            tvResult.setText(getString(R.string.demoText));
            tvResult.setVisibility(View.INVISIBLE);
            //Resets img
            imageView.setImageResource(R.drawable.question);
            //Activate buttons
            btnHead.setVisibility(View.VISIBLE);
            btnTail.setVisibility(View.VISIBLE);
        }, 3100);
    }
}