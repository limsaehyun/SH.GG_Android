package com.example.shgg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

import static java.lang.Math.*;

public class SeeInfoActivity extends AppCompatActivity {

    ImageView iv_profileIcon;
    TextView tv_name;
    Button btn_refresh;
    Button btn_bookmark;

    ImageView iv_soloTierImage;
    TextView tv_soloTier;
    TextView tv_soloRank;
    TextView tv_soloWinningRate;
    TextView tv_soloWinLose;

    ImageView iv_flexTierImage;
    TextView tv_flexTier;
    TextView tv_flexRank;
    TextView tv_flexWinningRate;
    TextView tv_flexWinLose;

    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_info);

        // 프로필 이미지 세팅
        iv_profileIcon = (ImageView) findViewById(R.id.iv_profileIcon);
        setProfileImage();

        // 이름 세팅
        tv_name = (TextView) findViewById(R.id.tv_name);
        setName();

        // 솔로 랭크 정보 세팅
        iv_soloTierImage = (ImageView) findViewById(R.id.iv_soloTierImage);
        tv_soloTier = (TextView) findViewById(R.id.tv_soloTier);
        tv_soloRank = (TextView) findViewById(R.id.tv_soloRank);
        tv_soloWinningRate = (TextView) findViewById(R.id.tv_soloWinningRate);
        tv_soloWinLose = (TextView) findViewById(R.id.tv_soloWinLose);
        setSolo();

        // 자유 랭크 정보 세팅
        iv_flexTierImage = (ImageView) findViewById(R.id.iv_flexTierImage);
        tv_flexTier = (TextView) findViewById(R.id.tv_flexTier);
        tv_flexRank = (TextView) findViewById(R.id.tv_flexRank);
        tv_flexWinningRate = (TextView) findViewById(R.id.tv_flexWinningRate);
        tv_flexWinLose = (TextView) findViewById(R.id.tv_flexWinLose);
        setFlex();

    }

    private void setProfileImage() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try{
                    URL url = new URL("http://ddragon.leagueoflegends.com/cdn/6.3.1/img/profileicon/" + MainActivity.profileIconId + ".png");

                    HttpURLConnection connection = (HttpURLConnection)url.openConnection();

                    connection.setDoInput(true);
                    connection.connect();

                    InputStream is = connection.getInputStream();
                    bitmap = BitmapFactory.decodeStream(is);

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();

        try {
            thread.join();

            iv_profileIcon.setImageBitmap(bitmap);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 소환사 이름 세팅
    private void setName() {
        tv_name.setText(MainActivity.name);
    }

    private void setSolo() {
        // 솔로랭크 이미지
        setSoloTierImage();


        tv_soloTier.setText(MainActivity.SoloTier);
        tv_soloRank.setText(MainActivity.SoloRank);

        double win = Double.parseDouble(MainActivity.SoloWins);
        double losses = Double.parseDouble(MainActivity.SoloLosses);
        double late = win/(win+losses) * 100;
        double roundWinningLate = Math.round(late*100/100);

        String winningRate = "승률 " + roundWinningLate + "%";
        tv_soloWinningRate.setText(winningRate);
        String winLose = "( " + win +"승 " + losses + "패 " + ")";
        tv_soloWinLose.setText(winLose);
    }

    private void setSoloTierImage() {
        if(Objects.equals(MainActivity.SoloTier, "UNRANK")) {
            iv_soloTierImage.setImageResource(R.drawable.unrank);
        } else if(Objects.equals(MainActivity.SoloTier, "IRON")) {
            iv_soloTierImage.setImageResource(R.drawable.iron);
        } else if(Objects.equals(MainActivity.SoloTier, "BRONZE")) {
            iv_soloTierImage.setImageResource(R.drawable.bronze);
        } else if(Objects.equals(MainActivity.SoloTier, "SILVER")) {
            iv_soloTierImage.setImageResource(R.drawable.silver);
        } else if(Objects.equals(MainActivity.SoloTier, "GOLD")) {
            iv_soloTierImage.setImageResource(R.drawable.gold);
        } else if(Objects.equals(MainActivity.SoloTier, "PLATINUM")) {
            iv_soloTierImage.setImageResource(R.drawable.platinum);
        } else if(Objects.equals(MainActivity.SoloTier, "DIAMOND")) {
            iv_soloTierImage.setImageResource(R.drawable.diamond);
        } else if(Objects.equals(MainActivity.SoloTier, "MASTER")) {
            iv_soloTierImage.setImageResource(R.drawable.master);
        } else if(Objects.equals(MainActivity.SoloTier, "GRANDMASTER")) {
            iv_soloTierImage.setImageResource(R.drawable.grandmaster);
        } else if(Objects.equals(MainActivity.SoloTier, "CHALLENGER")) {
            iv_soloTierImage.setImageResource(R.drawable.challenger);
        }
    }

    private void setFlex() {
        // 자유랭크 이미지
        setFlexTierImage();

        tv_flexTier.setText(MainActivity.FlexTier);
        tv_flexRank.setText(MainActivity.FlexRank);

        double win = Double.parseDouble(MainActivity.FlexWins);
        double losses = Double.parseDouble(MainActivity.FlexLosses);
        double late = win/(win+losses) * 100;
        double roundWinningLate = Math.round(late*100/100);

        String winningRate = "승률 " + roundWinningLate + "%";
        tv_flexWinningRate.setText(winningRate);
        String winLose = "( " + win +"승 " + losses + "패 " + ")";
        tv_flexWinLose.setText(winLose);
    }

    private void setFlexTierImage() {
        if(Objects.equals(MainActivity.FlexTier, "UNRANK")) {
            iv_flexTierImage.setImageResource(R.drawable.unrank);
        } else if(Objects.equals(MainActivity.FlexTier, "IRON")) {
            iv_flexTierImage.setImageResource(R.drawable.iron);
        } else if(Objects.equals(MainActivity.FlexTier, "BRONZE")) {
            iv_flexTierImage.setImageResource(R.drawable.bronze);
        } else if(Objects.equals(MainActivity.FlexTier, "SILVER")) {
            iv_flexTierImage.setImageResource(R.drawable.silver);
        } else if(Objects.equals(MainActivity.FlexTier, "GOLD")) {
            iv_flexTierImage.setImageResource(R.drawable.grandmaster);
        } else if(Objects.equals(MainActivity.FlexTier,"PLATINUM")) {
            iv_flexTierImage.setImageResource(R.drawable.platinum);
        } else if(Objects.equals(MainActivity.FlexTier, "DIAMOND")) {
            iv_flexTierImage.setImageResource(R.drawable.diamond);
        } else if(Objects.equals(MainActivity.FlexTier, "MASTER")) {
            iv_flexTierImage.setImageResource(R.drawable.master);
        } else if(Objects.equals(MainActivity.FlexTier, "GRANDMASTER")) {
            iv_flexTierImage.setImageResource(R.drawable.grandmaster);
        } else if(Objects.equals(MainActivity.FlexTier, "CHALLENGER")) {
            iv_flexTierImage.setImageResource(R.drawable.challenger);
        }
    }


}