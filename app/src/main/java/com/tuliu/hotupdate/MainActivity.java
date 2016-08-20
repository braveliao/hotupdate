package com.tuliu.hotupdate;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.tuliu.hotupdate.test.A;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "euler";
    private static final String APATCH_PATH = "/fix.apatch"; // 补丁文件名
    private TextView mainTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainTv = (TextView) findViewById(R.id.main_tv);
        mainTv.setText("点击Toast");
        mainTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast();
            }
        });

        findViewById(R.id.main_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });
    }

    private void update() {
        String patchFileStr = Environment.getExternalStorageDirectory().getAbsolutePath() + APATCH_PATH;
        try {
            HotPatchApplication.mPatchManager.addPatch(patchFileStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showToast() {
        Toast.makeText(this, "打补丁之前", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
