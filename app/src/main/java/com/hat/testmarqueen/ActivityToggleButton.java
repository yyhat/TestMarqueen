package com.hat.testmarqueen;

import android.app.Activity;
import android.content.pm.LabeledIntent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

/**
 * Created by anting.hu on 2015/10/29.
 */
public class ActivityToggleButton extends Activity {

    private ToggleButton toggleButton;
    private LinearLayout btnLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button);

        toggleButton = (ToggleButton)findViewById(R.id.toggle_btn);
        btnLinearLayout = (LinearLayout)findViewById(R.id.linearlayout_btn);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    btnLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
                }
                else
                {
                    btnLinearLayout.setOrientation(LinearLayout.VERTICAL);
                }
            }
        });

    }
}
