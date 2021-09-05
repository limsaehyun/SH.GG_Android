package com.example.shgg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class NoteActivity extends AppCompatActivity {

    ArrayList<MainData> arrayList;
    MainAdapter mainAdapter;
    RecyclerView recyclerView;
    LinearLayout linearLayout;
    private LinearLayoutManager linearLayoutManager;
    ImageButton ib_searchPage;
    ImageButton ib_add;

    public static Boolean colorValue[] = new Boolean[1000];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();

        mainAdapter = new MainAdapter(arrayList, getApplicationContext());
        recyclerView.setAdapter(mainAdapter);

        ib_searchPage = (ImageButton) findViewById(R.id.ib_searchPage);
        ib_searchPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ib_add = (ImageButton) findViewById(R.id.ib_add);
        ib_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NoteActivity.this, EditNoteActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(EditNoteActivity.edit) {


            String redName = "";
            String blueName = "";

            if(EditNoteActivity.player >= 1) {
                redName += EditNoteActivity.redPlayer1 + "\n";
                blueName += EditNoteActivity.bluePlayer1 + "\n";
            }
            if(EditNoteActivity.player >= 2) {
                redName += EditNoteActivity.redPlayer2 + "\n";
                blueName += EditNoteActivity.bluePlayer2 + "\n";
            }
            if(EditNoteActivity.player >= 3) {
                redName += EditNoteActivity.redPlayer3 + "\n";
                blueName += EditNoteActivity.bluePlayer3 + "\n";
            }
            if(EditNoteActivity.player >= 4) {
                redName += EditNoteActivity.redPlayer4 + "\n";
                blueName += EditNoteActivity.bluePlayer4 + "\n";
            }
            if(EditNoteActivity.player >= 5) {
                redName += EditNoteActivity.redPlayer5 + "\n";
                blueName += EditNoteActivity.bluePlayer5 + "\n";
            }

            if(EditNoteActivity.result.equals("승리")) {
                colorValue[arrayList.size()] = true;
            } else {
                colorValue[arrayList.size()] = false;
            }

            MainData mainData = new MainData(EditNoteActivity.result, redName, blueName);
            arrayList.add(mainData);

            mainAdapter.notifyDataSetChanged();
        }
    }
}