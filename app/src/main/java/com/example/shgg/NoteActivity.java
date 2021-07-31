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

        MainData mainData = new MainData("승리", "A", "B");
        arrayList.add(mainData);

        mainAdapter.notifyDataSetChanged();
    }
}