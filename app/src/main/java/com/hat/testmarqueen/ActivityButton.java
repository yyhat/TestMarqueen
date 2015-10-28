package com.hat.testmarqueen;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by anting.hu on 2015/10/28.
 */
public class ActivityButton extends Activity implements View.OnClickListener,
        View.OnKeyListener, View.OnTouchListener, View.OnFocusChangeListener{

    private Button button;
    private ImageButton imgButton;
    private int value = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_focus);
        button = (Button)findViewById(R.id.button);
        imgButton = (ImageButton)findViewById(R.id.imageButton);

        button.setOnClickListener(this);

        imgButton.setOnKeyListener(this);
        imgButton.setOnTouchListener(this);
        imgButton.setOnFocusChangeListener(this);
    }

    @Override
    public void onClick(View v) {

        Button btn = (Button)v;
        Point pt = new Point(0, 0);
        getWindowManager().getDefaultDisplay().getSize(pt);
        Log.i("Test", "w=" + pt.x + ", h=" + pt.y + " , btnW=" + btn.getWidth());
        int w = (int)(btn.getWidth() * (1 + value * 0.1f));
        int h = (int)(btn.getHeight() * (1 + value * 0.1f));

        if(value == 1 && w >=pt.x) {
            value = -1;
            w = (int)(btn.getWidth() * (1 + value * 0.1f));
            h = (int)(btn.getHeight() * (1 + value * 0.1f));
        }
        else if(value == -1 && w < 100)
        {
            value = 1;
            w = (int)(btn.getWidth() * (1 + value * 0.1f));
            h = (int)(btn.getHeight() * (1 + value * 0.1f));
        }

        btn.setWidth(w);
        btn.setHeight(h);

    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {

//        if(hasFocus)
//        {
//            imgButton.setImageResource(R.drawable.exit_scene2);
//        }
//        else
//        {
//            imgButton.setImageResource(R.drawable.exit_scene3);
//        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {

        if(KeyEvent.ACTION_UP == event.getAction())
        {
            v.setBackgroundResource(R.drawable.exit_scene3);
        }
        else if(KeyEvent.ACTION_DOWN == event.getAction())

        {
            v.setBackgroundResource(R.drawable.exit_scene2);
        }

        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        ImageButton btn = (ImageButton)v;

        if(MotionEvent.ACTION_UP == event.getAction())
        {
            v.setBackgroundResource(R.drawable.exit_scene3);
        }
        else if(MotionEvent.ACTION_DOWN == event.getAction())
        {
            v.setBackgroundResource(R.drawable.exit_scene2);
        }

        return false;
    }
}
