package com.hat.testmarqueen;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by anting.hu on 2015/10/29.
 */
public class ActivityImageViewRotate extends Activity implements SeekBar.OnSeekBarChangeListener{
    private ImageView imageView;
    private TextView textView1;
    private TextView textView2;
    private SeekBar seekBar1;
    private SeekBar seekBar2;
    private double ratio;
    private Matrix mMatrix;
    private int minWidth = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageview_rotate);
        imageView = (ImageView)findViewById(R.id.image_view_rotate);
        textView1 = (TextView)findViewById(R.id.text_view_scale);
        seekBar1 = (SeekBar)findViewById(R.id.seekbar_scale);
        seekBar1.setOnSeekBarChangeListener(this);

        textView2 = (TextView)findViewById(R.id.text_view_rotate);
        seekBar2 = (SeekBar)findViewById(R.id.seekbar_rotate);
        seekBar2.setOnSeekBarChangeListener(this);

        Point pt = new Point();
        getWindowManager().getDefaultDisplay().getSize(pt);

//        ratio = imageView.getHeight()/imageView.getWidth() * 1.0;
        ratio = 200/150 * 1.0;

        mMatrix = new Matrix();
        mMatrix.reset();

        seekBar1.setMax(pt.x - minWidth);


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
    {
        if(seekBar.getId() == R.id.seekbar_scale)
        {
            int w = progress + minWidth;
            int h = (int)(ratio * w);
            imageView.setLayoutParams( new LinearLayout.LayoutParams(w, h));
            textView1.setText("当前宽度： " + progress);

        }
        else if(seekBar.getId() == R.id.seekbar_rotate)
        {
            Bitmap src = ((BitmapDrawable)getResources().getDrawable(R.drawable.chat_button_over)).getBitmap();
            mMatrix.setRotate(progress);
            ((BitmapDrawable)imageView.getDrawable()).getBitmap().recycle();

            Bitmap newBitmap = Bitmap.createBitmap(src, 0, 0, src.getWidth(), src.getHeight(), mMatrix, true);
            imageView.setImageBitmap(newBitmap);
            textView2.setText("当前旋转： " + progress + "度");
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
