package com.hat.testmarqueen;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anting.hu on 2015/10/29.
 */
public class ActivityCheckbox extends Activity {

    private List<CheckBox> mListCheckBox;
    private String[] mCheckContent=new String[] {"宅在家里", "去旅游", "去图书馆", "去加班(好员工)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        LinearLayout linearLayout = (LinearLayout)getLayoutInflater().inflate(R.layout.activity_checkbox, null);

        mListCheckBox = new ArrayList<CheckBox>();
        for(int i=0; i< mCheckContent.length; i++)
        {
            CheckBox cb = (CheckBox)getLayoutInflater().inflate(R.layout.checkbox, null);
            cb.setText(mCheckContent[i]);
            linearLayout.addView(cb, i);
            mListCheckBox.add(cb);
        }
        setContentView(linearLayout);


        Button checkBoxBtn = (Button)findViewById(R.id.button_checkbox);
        checkBoxBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectStr = "";
                for(int i=0; i< mListCheckBox.size(); i++)
                {
                    if(mListCheckBox.get(i).isChecked())
                    {
                        selectStr += mListCheckBox.get(i).getText() + "\n";
                    }
                }

                if(selectStr.equals(""))
                    selectStr = "什么都没有选择";

                new AlertDialog.Builder (ActivityCheckbox.this)
                        .setMessage(selectStr)
                        .setPositiveButton("关闭", null)
                        .show();
            }
        });
    }
}
