package com.wxyass.jpush;

import android.content.Intent;
import android.os.Bundle;

import com.wxyass.jpush.base.BaseActivity;
import com.wxyass.jpush.module.PushMessage;

/**
 * Created by qndroid on 16/11/19.
 *
 * @function 显示推送的消息界面
 */
public class LoginActivity extends BaseActivity {

    private PushMessage mPushMessage;
    private boolean fromPush;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        if(intent.hasExtra("pushMessage")){
            // mPushMessage = (PushMessage) intent.getSerializableExtra("pushMessage");
        }
        fromPush = intent.getBooleanExtra("fromPush",false);
    }

    private void initView() {
    }

    //
    private void onSucLog() {
        if(fromPush){
            Intent intent = new Intent(LoginActivity.this,PushMessageActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("pushMessage", mPushMessage);
            startActivity(intent);
        }
    }
}
