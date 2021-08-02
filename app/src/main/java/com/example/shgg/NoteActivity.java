package com.example.shgg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class NoteActivity extends AppCompatActivity {

    ArrayList<MainData> arrayList;
    MainAdapter mainAdapter;
    RecyclerView recyclerView;
    LinearLayout linearLayout;
    private LinearLayoutManager linearLayoutManager;
    ImageButton ib_searchPage;
    ImageButton ib_add;

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

            if(EditNoteActivity.player == 1) {
                redName += EditNoteActivity.redPlayer1;
                blueName += EditNoteActivity.bluePlayer1;
            }
            if(EditNoteActivity.player == 2) {
                redName += EditNoteActivity.redPlayer2;
                blueName += EditNoteActivity.bluePlayer2;
            }
            if(EditNoteActivity.player == 3) {
                redName += EditNoteActivity.redPlayer3;
                blueName += EditNoteActivity.bluePlayer3;
            }
            if(EditNoteActivity.player == 4) {
                redName += EditNoteActivity.redPlayer4;
                blueName += EditNoteActivity.bluePlayer4;
            }
            if(EditNoteActivity.player == 5) {
                redName += EditNoteActivity.redPlayer5;
                blueName += EditNoteActivity.bluePlayer5;
            }

            MainData mainData = new MainData(EditNoteActivity.result, redName, blueName);
            arrayList.add(mainData);

            mainAdapter.notifyDataSetChanged();
        }
    }
}