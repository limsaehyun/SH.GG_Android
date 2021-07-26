package com.example.shgg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class SeeInfoActivity extends AppCompatActivity {

    ImageView iv_tierImage;
    TextView tv_name;
    Button btn_refresh;
    Button btn_bookmark;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_info);

        iv_tierImage = (ImageView) findViewById(R.id.iv_tierImage);
        setTierImage();

        tv_name = (TextView) findViewById(R.id.tv_name);
        setName();

    }

    // 티어 이미지 세팅
    private void setTierImage() {
        if(Objects.equals(MainActivity.SoloTier, "UNRANK")) {
            iv_tierImage.setImageResource(R.drawable.unrank);
        } else if (Objects.equals(MainActivity.SoloTier, "IRON")) {
            iv_tierImage.setImageResource(R.drawable.iron);
        } else if (Objects.equals(MainActivity.SoloTier, "BRONZE")) {
            iv_tierImage.setImageResource(R.drawable.bronze);
        } else if (Objects.equals(MainActivity.SoloTier, "SILVER")) {
            iv_tierImage.setImageResource(R.drawable.silver);
        } else if (Objects.equals(MainActivity.SoloTier, "GOLD")) {
            iv_tierImage.setImageResource(R.drawable.gold);
        } else if (Objects.equals(MainActivity.SoloTier, "PLATINUM")) {
            iv_tierImage.setImageResource(R.drawable.platinum);
        } else if (Objects.equals(MainActivity.SoloTier, "DIAMOND")) {
            iv_tierImage.setImageResource(R.drawable.diamond);
        } else if (Objects.equals(MainActivity.SoloTier, "MASTER")) {
            iv_tierImage.setImageResource(R.drawable.master);
        } else if (Objects.equals(MainActivity.SoloTier, "GRANDMASTER")) {
            iv_tierImage.setImageResource(R.drawable.grandmaster);
        } else if (Objects.equals(MainActivity.SoloTier, "CHALLENGER")) {
            iv_tierImage.setImageResource(R.drawable.challenger);
        }
    }

    // 소환사 이름 세팅
    private void setName() {
        tv_name.setText(MainActivity.name);
    }


}
