package cn.test.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {
    private static final String TGT = "mainactivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_test);
        findViewById(R.id.tv_ios_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertViewTestActivity.start(MainActivity.this);
            }
        });
    }
}
