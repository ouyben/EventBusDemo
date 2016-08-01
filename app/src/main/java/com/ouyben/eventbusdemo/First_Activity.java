package com.ouyben.eventbusdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

public class First_Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText et;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initView();
    }

    private void initView() {
        et = (EditText) findViewById(R.id.et);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        String etString = et.getText().toString().trim();
        if (TextUtils.isEmpty(etString)) {
            Toast.makeText(this, "请输入发送字段", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO 发送
        EventBus.getDefault().post(new MessageEvent(etString));
    }
}
