package com.wenhan.questionairedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LauncherActivity extends AppCompatActivity {

    private Button createBtn, viewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        findview();
        setListener();
    }

    private void findview() {
        createBtn = (Button) findViewById(R.id.activity_launcher_create_btn);
        viewBtn = (Button) findViewById(R.id.activity_launcher_view_btn);
    }

    private void setListener() {
        //创建问卷
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LauncherActivity.this, QuestionaireActivity.class);
                intent.putExtra(QuestionaireActivity.INTENT_LAUNCH_TYPE,
                    QuestionaireActivity.INTENT_LAUNCH_TYPE_CREATE);
                startActivity(intent);
                finish();
            }
        });
        //查看问卷
        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LauncherActivity.this, QuestionaireActivity.class);
                intent.putExtra(QuestionaireActivity.INTENT_LAUNCH_TYPE,
                    QuestionaireActivity.INTENT_LAUNCH_TYPE_VIEW);
                startActivity(intent);
                finish();
            }
        });
    }
}
