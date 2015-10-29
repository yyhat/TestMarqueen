package com.hat.testmarqueen;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by anting.hu on 2015/10/29.
 */
public class ActivitySeekbar extends Activity implements SeekBar.OnSeekBarChangeListener {

    private TextView textView1;
    private TextView textView2;
    private SeekBar seekBar1;
    private  SeekBar seekBar2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar);

        textView1 = (TextView)findViewById(R.id.text_view_seekbar1);
        textView2 = (TextView)findViewById(R.id.text_view_seekbar2);
        seekBar1 = (SeekBar)findViewById(R.id.seekbar1);
        seekBar2 = (SeekBar)findViewById(R.id.seekbar2);

        seekBar1.setOnSeekBarChangeListener(this);
        seekBar2.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(seekBar.getId() == R.id.seekbar1) {
            textView1.setText("Seekbar1  当前进度: " + progress);
        }
        else if(seekBar.getId() == R.id.seekbar2)
            textView1.setText("Seekbar2  当前进度: " + progress);


    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        if(seekBar.getId() == R.id.seekbar1)
        {
            textView2.setText("Seekbar1  开始拖动");
        }
        else if(seekBar.getId() == R.id.seekbar2)
        {
            {
                textView2.setText("Seekbar2  开始拖动");
            }
        }
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        if(seekBar.getId() == R.id.seekbar1)
        {
            textView2.setText("Seekbar1  停止拖动");
        }
        else if(seekBar.getId() == R.id.seekbar2)
        {
            {
                textView2.setText("Seekbar2  停止拖动");
            }
        }
    }
}
