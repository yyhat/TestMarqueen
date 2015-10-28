package com.hat.testmarqueen;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by anting.hu on 2015/10/28.
 */
public class ActivityInputType extends Activity {
    private EditText digitNumEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputtype);

        Button checkBtn = (Button)findViewById(R.id.check_edittext_btn);
        digitNumEditText = (EditText)findViewById(R.id.edit_text_digit_num);
        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = digitNumEditText.getText().toString();
                if(str == null || str.isEmpty())
                    digitNumEditText.setError("不能为空");
            }
        });
    }
}
