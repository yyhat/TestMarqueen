package com.hat.testmarqueen;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.renderscript.Font;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
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

        mEditText = (EditText)findViewById(R.id.edit_text_imagespan);
        mAddBtn = (Button)findViewById(R.id.add_express_btn);
        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    int iconIndex = new Random().nextInt(10) + 1;
                    Field field = R.drawable.class.getDeclaredField("face" + iconIndex);
                    int resId = Integer.parseInt(field.get(null).toString());
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

        //字体颜色设置（ForegroundColorSpan）
        SpannableString fcSpanString = new SpannableString("欢迎光临Harvic的博客");
        EditText fcSpanEditText = (EditText)findViewById(R.id.edit_text_fcspan);
        ForegroundColorSpan fcspan = new ForegroundColorSpan(Color.BLUE);
        fcSpanString.setSpan(fcspan,1, 5, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        fcSpanEditText.setText(fcSpanString);

        //字体背景颜色（BackgroundColorSpan）
        SpannableString bcSpanString = new SpannableString("欢迎光临Harvic的博客");
        EditText bcSpanEditText = (EditText)findViewById(R.id.edit_text_bcspan);
        BackgroundColorSpan bcspan = new BackgroundColorSpan(Color.YELLOW);
        bcSpanString.setSpan(bcspan,1, 5, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        bcSpanEditText.setText(bcSpanString);

        //字体大小（AbsoluteSizeSpan）
        SpannableString sizeSpanString = new SpannableString("欢迎光临Harvic的博客");
        EditText sizeSpanEditText = (EditText)findViewById(R.id.edit_text_sizespan);
        AbsoluteSizeSpan sizespan = new AbsoluteSizeSpan(16);
        sizeSpanString.setSpan(sizespan,1, 5, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        sizeSpanEditText.setText(sizeSpanString);


        //粗体、斜体（StyleSpan）
        SpannableString styleSpanString = new SpannableString("欢迎光临Harvic的博客");
        EditText styleSpanEditText = (EditText)findViewById(R.id.edit_text_stylespan);
        StyleSpan stylespan = new StyleSpan(Typeface.BOLD_ITALIC); //TODO Typeface
        styleSpanString.setSpan(stylespan,1, 5, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        styleSpanEditText.setText(styleSpanString);


        //删除线（StrikethroughSpan）
        SpannableString strikeSpanString = new SpannableString("欢迎光临Harvic的博客");
        EditText strikeSpanEditText = (EditText)findViewById(R.id.edit_text_strikespan);
        StrikethroughSpan strikespan = new StrikethroughSpan();
        strikeSpanString.setSpan(strikespan,1, 5, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        strikeSpanEditText.setText(strikeSpanString);


        //下划线（UnderlineSpan）
        SpannableString underlineSpanString = new SpannableString("欢迎光临Harvic的博客");
        EditText underlineSpanEditText = (EditText)findViewById(R.id.edit_text_underlinespan);
        UnderlineSpan underlinespan = new UnderlineSpan();
        underlineSpanString.setSpan(underlinespan,1, 5, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        underlineSpanEditText.setText(underlineSpanString);
    }
}
