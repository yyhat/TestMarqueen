package com.hat.testmarqueen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by anting.hu on 2015/10/27.
 */
public class MainActivity extends Activity implements AdapterView.OnItemClickListener{

    private ListView mListView;
    private String[] activityDesList = new String[]
            {
                "TextView 跑马灯效果",
                "EditText 插入表情",
                "EditText InputType",
                "AutoCompleteText",
                "Button各种状态",
                "Button中文字和图片混饶",
                "RadioButton",
                "ToggleButton",
                "CheckBox",
                "SeekBar",
                    "测试ImageView",
                    "测试图片选择和剪切",
                    "测试图片放大和旋转",
                    "通过网络获取图片,设置ImageView"
            };
    private Class<?>[] activityList = new Class<?>[]
            {
                ActivityMarqueen.class,
                ActivityEditText.class,
                ActivityInputType.class,
                ActivityAutoCompleteText.class,
                ActivityButton.class,
                ActivityButtonImg.class,
                ActivityRadioButton.class,
                ActivityToggleButton.class,
                ActivityCheckbox.class,
                ActivitySeekbar.class,
                    ActivityImageView.class,
                    ActivityImageViewCut.class,
                    ActivityImageViewRotate.class,
                    ActivityImageViewHttp.class
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
