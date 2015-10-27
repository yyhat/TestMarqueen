package com.hat.testmarqueen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by anting.hu on 2015/10/27.
 */
public class MainActivity extends Activity implements AdapterView.OnItemClickListener{

    private ListView mListView;
    private String[] activityDesList = new String[]
            {
                "TextView 跑马灯效果",
                "EditText 插入表情"
            };
    private Class<?>[] activityList = new Class<?>[]
            {
                ActivityMarqueen.class,
                ActivityEditText.class
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView)findViewById(R.id.list_view);
        mListView.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, activityDesList));
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       if(position < activityList.length)
       {
           Intent intent = new Intent(MainActivity.this, activityList[position]);
           startActivity(intent);
       }

    }
}
