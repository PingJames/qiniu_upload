package com.qiniu.qiniuultra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    String FilePath = "file:///storage/emulated/0/DCIM/Camera/xx.mp4";  // 5.4

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView filepath = (TextView) findViewById(R.id.filepath);
        filepath.setText("FilePath: " + FilePath);

        // import compile 'com.qiniu:qiniu-java-sdk:7.1.+' replace library code.

        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            new Upload().upload(getBaseContext(),FilePath);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
    }
}
