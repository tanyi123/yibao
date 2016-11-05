package com.example.wlw.qqlogin;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);//设置该Activity使用的布局

        Button button= (Button) findViewById(R.id.btLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=((EditText)findViewById(R.id.username)).getText().toString();
                String pwd=((EditText)findViewById(R.id.password)).getText().toString();

                boolean flag=false;//用于记录登录是否成功的标识变量
                String index="";//保存头像编号的变量
                //通过遍历数组的形式判断输入的账号和密码是否正确
                for(int i=0;i<Data.USER.length;i++)
                {
                    if(number.equals(Data.USER[i][0]))//判断账号是否正确
                    {
                        if(pwd.equals(Data.USER[i][1]))
                        {
                            index=Data.USER[i][2];
                            flag=true;//将标识变量设置为true
                            break;
                        }
                    }
                }
                if(flag)
                {
                    //创建要显示Activity对应的intent对象
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    Bundle bundle=new Bundle();//创建一个bundle的对象bundle
                    bundle.putInt("Index",Integer.parseInt(index));//保存头像编码
                    intent.putExtras(bundle);//将数据包添加到intent对象中
                    startActivity(intent);//开启一个新的activity
                }
                else
                {
                    Toast toast=Toast.makeText(LoginActivity.this,"你输入的账号或密码错误!",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM,0,0);//设置对其方式
                    toast.show();//显示对话框
                }
            }
        });
    }
}
