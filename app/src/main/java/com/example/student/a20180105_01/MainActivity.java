package com.example.student.a20180105_01;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int choice;
    int tmp;    //防止取消時，再次按下按鈕，會顯示上次所選的選項的bug
    boolean chks[]=new boolean[5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click1(View v)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("This is a title");
                builder.setMessage("HELLO\nHELLO~~~");
                builder.setPositiveButton("commit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int x) {
                        Toast.makeText(MainActivity.this,"click commit",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int x) {
                        Toast.makeText(MainActivity.this,"click cancel",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int x) {
                        Toast.makeText(MainActivity.this,"click Neutral",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
    }
    public void click2(View v)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Title");
        final EditText ed=new EditText(MainActivity.this);
        final TextView tv=(TextView)(findViewById(R.id.textView));
        ed.setText(tv.getText().toString());
        builder.setView(ed);
        builder.setPositiveButton("commit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int x) {
                //Toast.makeText(MainActivity.this, "commit", Toast.LENGTH_SHORT).show();
                tv.setText(ed.getText().toString());
            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"cancel",Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
    public void click3(View v)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("List");
        final String fruits[]={"apple","banana","Strawberry"};
        final TextView tv=findViewById(R.id.textView2);
        builder.setItems(fruits, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            tv.setText(fruits[which]);
            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setCancelable(false);
        builder.show();
    }
    public void click4(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("單選列表");
        final String fruits[] = {"蘋果", "香蕉", "梨子"};
        final TextView tv3 = (TextView) findViewById(R.id.textView3);
        tmp=choice; //修正當已選appale時，再次選擇banana但取消，第3次進入雖然預選apple，但實際按commit卻出現banana的錯誤
        builder.setSingleChoiceItems(fruits, choice, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //choice=which;
                tmp=i;
            }
        });
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                choice = tmp;
                tv3.setText(fruits[choice]);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }
    public void click5(View v)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("MultTitle");
        final String fruits[] = {"蘋果", "香蕉", "梨子","西瓜","鳳梨"};
        final TextView tv4=findViewById(R.id.textView4);
        builder.setMultiChoiceItems(fruits, chks, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

            }
        });
        builder.setPositiveButton("commit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            StringBuilder sb=new StringBuilder();   //為防止陣列的字串累加記憶，要用此行全部串起來
                for(int i=0;i<=4;i++)
                {
                    if(chks[i])
                    {
                        sb.append(fruits[i]+",");
                    }
                }
                tv4.setText(sb.toString());
            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }
    public void click6(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("This is title");
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        View v1 = inflater.inflate(R.layout.layout1, null); //解壓器，用來將新創的layout1解壓到這
        final TextView tv = v1.findViewById(R.id.textView5);
        Button btn1 = v1.findViewById(R.id.button7);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("Hello World");
            }
        });
        builder.setView(v1);
        builder.setPositiveButton("commit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }
}
