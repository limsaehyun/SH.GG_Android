package com.example.shgg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static String SoloTier = "UNRANK";
    public static String SoloRank;
    public static String SoloName;
    public static String SoloWins;
    public static String SoloLosses;

    public static String FlexTier;
    public static String FlexRank;
    public static String FlexName;
    public static String FlexWins;
    public static String FlexLosses;

    public static String name;

    private Summoner responsevalue;
    private UserInfo userInfo;
    private String API_KEY;

    EditText et_name;
    ImageButton ib_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ib_search = (ImageButton) findViewById(R.id.ib_search);
        ib_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                et_name = (EditText) findViewById(R.id.et_name);
                name = et_name.getText().toString();

                if(name != null) {
                    getId(name);
                } else {
                    System.out.println("입력값이 없음");
                }

            }
        });

    }

    private void getId(String name) {

        name = et_name.getText().toString();

        if(name != null) {
            // API_KEY 받아오기
            API_KEY = BuildConfig.API_KEY;

            RiotAPI riotAPI = ApiProvider.getInstance().create(RiotAPI.class);

            Call<Summoner> call = riotAPI.getSummoner(name, API_KEY);

            call.enqueue(new Callback<Summoner>() {
                @Override
                public void onResponse(Call<Summoner> call, Response<Summoner> response) {
                    responsevalue = response.body();
                    setId(responsevalue);
                }

                @Override
                public void onFailure(Call<Summoner> call, Throwable t) {}
            });
        }
        else {
            System.out.println("입력해주세요.");
        }
    }

    private void setId(Summoner summoner) {

        String id = summoner.getId();
        String name = summoner.getName();
        String level = summoner.getSummonerLevel();

        getInfo(id);

    }

    private void getInfo(String id) {
        RiotAPI riotAPI = ApiProvider.getInstance().create(RiotAPI.class);

        Call<List<UserInfo>> call = riotAPI.getUserInfo(id, API_KEY);

        call.enqueue(new Callback<List<UserInfo>>() {
            @Override
            public void onResponse(Call<List<UserInfo>> call, Response<List<UserInfo>> response) {
                List<UserInfo> data = response.body();
                setInfo(data);
            }

            @Override
            public void onFailure(Call<List<UserInfo>> call, Throwable t) {
                System.out.println("실패");

            }
        });
    }

    private void setInfo(List<UserInfo> userInfos) {
        int su = userInfos.size();

        if(su == 1) {
            System.out.println("작동" + userInfos.get(0).getTier());
            SoloTier = userInfos.get(0).getTier();
            SoloRank = userInfos.get(0).getRank();
            SoloName = userInfos.get(0).getSummonerName();
            SoloWins = userInfos.get(0).getWins();
            SoloLosses = userInfos.get(0).getLosses();
        }
        if(su > 1) {
            FlexTier = userInfos.get(1).getTier();
            FlexRank = userInfos.get(1).getRank();
            FlexName = userInfos.get(1).getSummonerName();
            FlexWins = userInfos.get(1).getWins();
            FlexLosses = userInfos.get(1).getLosses();
        }

        startActivity(new Intent(MainActivity.this, SeeInfoActivity.class));
    }

}