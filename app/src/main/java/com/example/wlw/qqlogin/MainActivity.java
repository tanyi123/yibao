package com.example.wlw.qqlogin;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends Activity {
    int[] ico=new int[]{R.drawable.qq,R.drawable.ico1,R.drawable.ico2};//保存头像资源的数组

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        int index=bundle.getInt("Index");
        ImageButton ib= (ImageButton) findViewById(R.id.qq);
        ib.setImageResource(ico[index]);
        ImageButton btn= (ImageButton) findViewById(R.id.m_exit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
