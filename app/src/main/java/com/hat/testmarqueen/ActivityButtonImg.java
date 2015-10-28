package com.hat.testmarqueen;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ImageSpan;
import android.widget.Button;

/**
 * Created by anting.hu on 2015/10/28.
 */
public class ActivityButtonImg extends Activity {
    private Button btnImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_img);

        btnImg = (Button)findViewById(R.id.button_img);

        SpannableString leftString = new SpannableString("left");
        Bitmap leftBitMap = BitmapFactory.decodeResource(getResources(), R.drawable.face6);
        ImageSpan leftSpan = new ImageSpan(leftBitMap, DynamicDrawableSpan.ALIGN_BOTTOM);
        leftString.setSpan(leftSpan, 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

    }
}
