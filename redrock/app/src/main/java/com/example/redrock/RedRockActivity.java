package com.example.redrock;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RedRockActivity extends Activity {
    private Button bt1;
    private Button Login;
    private EditText UserName;
    private EditText UserPass;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_red_rock);

    pref = getSharedPreferences("UserInfo",MODE_PRIVATE);
    editor = pref.edit();
    UserName = (EditText) findViewById(R.id.UserName1);
    UserPass = (EditText) findViewById(R.id.UserPass);
    Login = (Button) findViewById(R.id.Login);
    bt1 = (Button) findViewById(R.id.Registered1);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = UserName.getText().toString().trim();
                String password = UserPass.getText().toString().trim();

                String oldName = pref.getString("userName","");
                String oldPass = pref.getString("userPass","");

                Log.i("test","cao:"+name);
                Log.i("test","cao:"+password);
                Log.i("test","caooldName:"+oldName);
                Log.i("test","caooldPass:"+oldPass);

                if(name.equals(oldName) && password.equals(oldPass)){

                    Intent intent = new Intent(RedRockActivity.this, LoginSuccess.class);
                    startActivity(intent);
                    Toast.makeText(RedRockActivity.this,"fuck",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(RedRockActivity.this,"用户名或密码错误",Toast.LENGTH_LONG).show();
                }
            }
        });

    bt1.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
        //在当前onclick方法中监听点击Button(registered)的动作
        Intent intent = new Intent(RedRockActivity.this, RedRpckActivity2.class);
        startActivity(intent); //从当前Activity 跳转到 指定Activity
        }
    });
    }


//    public void doLogin(View view){
//        final String name = UserName.getText().toString().trim();//获取当前输入的用户名
//        final String pass = UserPass.getText().toString().trim();//获取当前输入的密码
//
//        Login.setOnClickListener(new View.OnClickListener(){
//            //监控登陆Button  一旦点击登录，马上判断用户名密码是否存在正确
//            @Override
//            public void onClick(View v) {
//                //pref.getString("文件名","") ---> 获取的文件里边的用户名和密码
//                if(name.equals(pref.getString("userName",""))&&pass.equals(pref.getString("userPass",""))){
//                    Log.i("test",name);
//                    Log.i("test",pass);
//                    Log.i("test","sp-name:"+pref.getString("userName",""));
//                    Intent intent = new Intent(RedRockActivity.this, LoginSuccess.class);
//                    startActivity(intent); //从当前Activity 跳转到 指定Activity
//                }
//                else{
//                    Toast.makeText(RedRockActivity.this,"用户名或密码错误",Toast.LENGTH_LONG);
//                }
//            }
//        });
//
//    }



}
