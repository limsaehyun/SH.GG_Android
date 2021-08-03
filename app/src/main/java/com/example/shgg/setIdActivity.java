package com.example.shgg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class setIdActivity extends AppCompatActivity {

    EditText et_name;
    Button btn_next;
    public static String name = "default";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_id);

        et_name = (EditText) findViewById(R.id.et_name);

        btn_next = (Button) findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = et_name.getText().toString();
                if(name.equals("")) {
                    Toast.makeText(setIdActivity.this, "소환사 닉네임을 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    MainActivity.tv_bookMarkName.setVisibility(View.VISIBLE);
                    MainActivity.btn_myId.setVisibility(View.GONE);
                    finish();
                }
            }
        });
    }
}