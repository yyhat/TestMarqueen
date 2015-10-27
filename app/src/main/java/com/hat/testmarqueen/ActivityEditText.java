package com.hat.testmarqueen;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created by anting.hu on 2015/10/27.
 */
public class ActivityEditText extends Activity {

    private EditText mEditText;
    private Button mAddBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittext1);

        mEditText = (EditText)findViewById(R.id.edit_text1);
        mAddBtn = (Button)findViewById(R.id.add_express_btn);
        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    int iconIndex = new Random().nextInt(10) + 1;
                    Field field = R.drawable.class.getDeclaredField("face" + iconIndex);
                    int resId = Integer.parseInt(field.get(null).toString()) ;
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resId);

                    ImageSpan imageSpan = new ImageSpan(ActivityEditText.this, bitmap);
                    SpannableString spanStr = new SpannableString("face");
                    spanStr.setSpan(imageSpan, 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    mEditText.append(spanStr);

                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
