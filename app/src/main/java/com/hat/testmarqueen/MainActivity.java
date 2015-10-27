package com.hat.testmarqueen;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

/**
 * Created by anting.hu on 2015/10/27.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String  str="<a href='http://www.baidu.com'>百度</a>那一大堆都是一样的啊,都是写的那三个方法.我copy了测试大小没变";
        CharSequence charSequence = Html.fromHtml(str);
        TextView textView = (TextView)findViewById(R.id.text_view);
        textView.setText(charSequence);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

    }
}
