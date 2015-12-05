package com.example.redrock;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by 梅梅 on 2015/12/3.
 */
public class RedRpckActivity2 extends Activity{
    private Button bt1;
    private Button bt2;
    private EditText UserName;
    private EditText UserPass;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_red_rock);//将布局activity1_red_rock.xml文件引入到activity当中

        bt1 = (Button) findViewById(R.id.ReturnLogin);
        bt1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //在当前onclick方法中监听点击Button的动作
                Intent intent = new Intent(RedRpckActivity2.this, RedRockActivity.class);
                startActivity(intent); //从当前Activity 跳转到 指定Activity
            }
        });

        UserName = (EditText) findViewById(R.id.UserName); //绑定具体的EditText
        UserPass = (EditText) findViewById(R.id.UserPass);
        pref = getSharedPreferences("UserInfo",MODE_PRIVATE);
        editor = pref.edit(); //启动编辑

        bt2 = (Button) findViewById(R.id.Registered2);
        bt2.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                String name = UserName.getText().toString().trim(); //获取输入的用户名(除空格外)
                String pass = UserPass.getText().toString().trim();
                if(name.isEmpty()||pass.isEmpty()){
                    Toast.makeText(RedRpckActivity2.this,"用户名和密码不能为空",Toast.LENGTH_LONG).show();
                }
                else{
                    editor.putString("userName",name);
                    editor.putString("userPass",pass);
                    editor.commit();  //存入数据后必须提交，否则无效
                    Toast.makeText(RedRpckActivity2.this,"注册成功",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

//    public void doRegistered(View view){
//        String name = UserName.getText().toString().trim(); //获取输入的用户名(除空格外)
//        String pass = UserPass.getText().toString().trim();
//        if(name==null||pass==null){
//            Toast.makeText(RedRpckActivity2.this,"用户名和密码不能为空",Toast.LENGTH_LONG).show();
//        }
//        else{
//            editor.putString("userName",name);
//            editor.putString("userPass",pass);
//            editor.commit();  //存入数据后必须提交，否则无效
//            Toast.makeText(RedRpckActivity2.this,"注册成功",Toast.LENGTH_LONG).show();
//        }
//
//    }


}
