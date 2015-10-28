package com.hat.testmarqueen;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

/**
 * Created by anting.hu on 2015/10/28.
 */
public class ActivityAutoCompleteText extends Activity {
    private AutoCompleteTextView mAutoComTxtView;
    private MultiAutoCompleteTextView mMultiAutoComTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text);
        mAutoComTxtView = (AutoCompleteTextView)findViewById(R.id.auto_complete_text_view);
        mMultiAutoComTxtView = (MultiAutoCompleteTextView)findViewById(R.id.multi_auto_complete_text_view);

        String[] content = new String[]
                {
                        "联合国",
                        "联合国常任理事国",
                        "联合国地址",
                        "Google",
                        "Google map",
                        "Goole chrome"
                };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, content);
        mAutoComTxtView.setAdapter(adapter);

        mMultiAutoComTxtView.setAdapter(adapter);
        mMultiAutoComTxtView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
