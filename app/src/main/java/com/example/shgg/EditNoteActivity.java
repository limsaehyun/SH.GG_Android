package com.example.shgg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class EditNoteActivity extends AppCompatActivity {

    private RadioGroup rg1;
    private ImageButton ib_next;

    private EditText et_redPlayer1;
    private EditText et_redPlayer2;
    private EditText et_redPlayer3;
    private EditText et_redPlayer4;
    private EditText et_redPlayer5;

    private EditText et_bluePlayer1;
    private EditText et_bluePlayer2;
    private EditText et_bluePlayer3;
    private EditText et_bluePlayer4;
    private EditText et_bluePlayer5;

    public static String redPlayer1;
    public static String redPlayer2;
    public static String redPlayer3;
    public static String redPlayer4;
    public static String redPlayer5;

    public static String bluePlayer1;
    public static String bluePlayer2;
    public static String bluePlayer3;
    public static String bluePlayer4;
    public static String bluePlayer5;

    boolean checkStatus = false;
    public static String result;

    public static int player;

    public static boolean edit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        rg1 = (RadioGroup) findViewById(R.id.rg1);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.r1_btn1) {
                    checkStatus = true;
                    result = "승리";
                } else if(i == R.id.r1_btn2) {
                    checkStatus = true;
                    result = "패배";
                }
            }
        });

        ib_next = (ImageButton) findViewById(R.id.ib_next);

        et_redPlayer1 = (EditText) findViewById(R.id.et_redPlayer1);
        et_redPlayer2 = (EditText) findViewById(R.id.et_redPlayer2);
        et_redPlayer3 = (EditText) findViewById(R.id.et_redPlayer3);
        et_redPlayer4 = (EditText) findViewById(R.id.et_redPlayer4);
        et_redPlayer5 = (EditText) findViewById(R.id.et_redPlayer5);

        et_bluePlayer1 = (EditText) findViewById(R.id.et_bluePlayer1);
        et_bluePlayer2 = (EditText) findViewById(R.id.et_bluePlayer2);
        et_bluePlayer3 = (EditText) findViewById(R.id.et_bluePlayer3);
        et_bluePlayer4 = (EditText) findViewById(R.id.et_bluePlayer4);
        et_bluePlayer5 = (EditText) findViewById(R.id.et_bluePlayer5);

        ib_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redPlayer1 = et_redPlayer1.getText().toString();
                redPlayer2 = et_redPlayer2.getText().toString();
                redPlayer3 = et_redPlayer3.getText().toString();
                redPlayer4 = et_redPlayer4.getText().toString();
                redPlayer5 = et_redPlayer5.getText().toString();

                bluePlayer1 = et_bluePlayer1.getText().toString();
                bluePlayer2 = et_bluePlayer2.getText().toString();
                bluePlayer3 = et_bluePlayer3.getText().toString();
                bluePlayer4 = et_bluePlayer4.getText().toString();
                bluePlayer5 = et_bluePlayer5.getText().toString();

                if(!(redPlayer5.equals("") && bluePlayer5.equals(""))) {
                    player = 5;
                } else if(!(redPlayer4.equals("") && bluePlayer4.equals(""))) {
                    player = 4;
                } else if(!(redPlayer3.equals("") && bluePlayer3.equals(""))) {
                    player = 3;
                } else if(!(redPlayer2.equals("") && bluePlayer2.equals(""))) {
                    player = 2;
                } else if(!(redPlayer1.equals("") && bluePlayer1.equals(""))) {
                    player = 1;
                } else player = 0;

                if (!(redPlayer1.equals("") && bluePlayer1.equals("") && checkStatus)) {
                    edit = true;
                    finish();
                } else {
                    if(player == 0) {
                        Toast.makeText(EditNoteActivity.this, "최소 플레이어를 입력하세요.", Toast.LENGTH_LONG).show();
                    }
                    if(!checkStatus) {
                        Toast.makeText(EditNoteActivity.this, "승리 여부를 체크해주세요.", Toast.LENGTH_LONG).show();
                    }
                }


            }
        });

    }
}