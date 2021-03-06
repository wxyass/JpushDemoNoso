package com.wxyass.jpush;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.wxyass.jpush.base.BaseActivity;
import com.wxyass.jpush.module.PushMessage;

/**
 * Created by qndroid on 16/11/19.
 *
 * @function 显示推送的消息界面
 */
public class PushMessageActivity extends BaseActivity {

    private TextView mTypeView;
    private TextView mTypeValueView;
    private TextView mContentView;
    private TextView mContentValueView;

    private PushMessage mPushMessage;
    private boolean fromPush;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jpush_layout);
        initView();
        initData();

    }

    //初始化推送过来的数据
    private void initData() {
        Intent intent = getIntent();
        if(intent.hasExtra("pushMessage")){
            mPushMessage = (PushMessage) intent.getSerializableExtra("pushMessage");
        }
        fromPush = intent.getBooleanExtra("fromPush",false);


    }

    private void initView() {
        mTypeView = (TextView) findViewById(R.id.message_type_view);
        mTypeValueView = (TextView) findViewById(R.id.message_type_value_view);
        mContentView = (TextView) findViewById(R.id.message_content_view);
        mContentValueView = (TextView) findViewById(R.id.message_content_value_view);

        /*mTypeValueView.setText(mPushMessage.messageType);
        mContentValueView.setText(mPushMessage.messageContent);
        if (!TextUtils.isEmpty(mPushMessage.messageUrl)) {
            //跳转到web页面
            gotoWebView();
        }*/
    }

    private void gotoWebView() {
        /*Intent intent = new Intent(this, AdBrowserActivity.class);
        intent.putExtra(AdBrowserActivity.KEY_URL, mPushMessage.messageUrl);
        startActivity(intent);
        finish();*/
    }
}
