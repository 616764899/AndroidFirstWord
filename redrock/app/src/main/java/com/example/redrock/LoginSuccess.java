package com.example.redrock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by 梅梅 on 2015/12/4.
 */
public class LoginSuccess extends Activity{
    private Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginsuccess);

        bt1 = (Button) findViewById(R.id.returnmain);
        bt1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //在当前onclick方法中监听点击Button(Registered)的动作
                Intent intent = new Intent(LoginSuccess.this, RedRockActivity.class);
                startActivity(intent); //从当前Activity 跳转到 指定Activity
            }
        });
    }
}
