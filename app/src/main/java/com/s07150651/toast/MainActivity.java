package com.s07150651.toast;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) this.findViewById(R.id.button1);
        Button button2 = (Button) this.findViewById(R.id.button2);
        Button button3 = (Button) this.findViewById(R.id.button3);
        button1.setOnClickListener(showToast1);
        button2.setOnClickListener(showToast2);
        button3.setOnClickListener(showToast3);

    }

    View.OnClickListener showToast1=new View.OnClickListener(){
        public void onClick(View v){
            Toast.makeText(MainActivity.this,"直接输出信息",Toast.LENGTH_SHORT).show();
        }
    };
    View.OnClickListener showToast2=new View.OnClickListener(){
        public void onClick(View v){
            //获取LayoutInflater对象
            LayoutInflater li=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //获取一个View对象
            View view=li.inflate(R.layout.toastinfo,null);
            Toast toast=new Toast(MainActivity.this);
            toast.setView(view);
            toast.show();
        }
    };
    View.OnClickListener showToast3=new View.OnClickListener(){
        public void onClick(View v){
            //1.创建Toast
            Toast toast=Toast.makeText(MainActivity.this,"图文显示",Toast.LENGTH_LONG);
            //2.创建Layout,并设置为水平布局
            LinearLayout mLayout=new LinearLayout(MainActivity.this);
            mLayout.setOrientation(LinearLayout.VERTICAL);
            ImageView mImage=new ImageView(MainActivity.this); //创建显示图像的ImageView
            mImage.setImageResource(R.mipmap.ic_launcher);
            View toastView=toast.getView(); //获取显示文字的Toast View
            mLayout.addView(mImage); //将图片添加到Layout
            mLayout.addView(toastView);
            //3.设置Toast显示的View,参数为上面生成的Layout
            toast.setView(mLayout);
            toast.show();
        }
    };
}
