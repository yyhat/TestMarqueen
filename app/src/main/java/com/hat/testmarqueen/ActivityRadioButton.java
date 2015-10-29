package com.hat.testmarqueen;

import android.app.Activity;
import android.drm.DrmStore;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by anting.hu on 2015/10/29.
 */
public class ActivityRadioButton extends Activity {

    private Button sexBtn;
    private RadioGroup sexRadioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);

        sexRadioGroup = (RadioGroup)findViewById(R.id.radio_group_sex);
        sexBtn = (Button)findViewById(R.id.button_sex);
        sexBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectId = sexRadioGroup.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton)findViewById(selectId);

                Toast.makeText(ActivityRadioButton.this, rb.getText().toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
