package com.ouyben.eventbusdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private TextView main_tv;
    private Button button;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 注册
        EventBus.getDefault().register(this);

        initView();
        setSupportActionBar(toolbar);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }
// TODO: 主线程操作
    //@Subscribe
//    public void onEventMainThread(MessageEvent event) {
//        String msg = "onEventMainThread收到了消息：" + event.getMessage();
//        Log.d("harvic", msg);
//        main_tv.setText(msg);
//        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
//    }
    // TODO: 子线程
    @Subscribe
    public void onEvent(MessageEvent event) {
        String msg = "收到了消息：" + event.getMessage();
        Log.d("harvic", msg);
        main_tv.setText(msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        main_tv = (TextView) findViewById(R.id.main_tv);
        button = (Button) findViewById(R.id.button);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        button.setOnClickListener(this);
        fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                startActivity(new Intent(this, First_Activity.class));
                break;
            case R.id.fab:

                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 取消注册
        EventBus.getDefault().unregister(this);
    }
}
