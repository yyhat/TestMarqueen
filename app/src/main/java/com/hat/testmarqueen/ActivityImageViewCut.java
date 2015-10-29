package com.hat.testmarqueen;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.FileNotFoundException;

/**
 * Created by anting.hu on 2015/10/29.
 */
public class ActivityImageViewCut extends Activity {
    static final int IMAGE_SELECT = 1;
    static final int IMAGE_CUT = 2;

    private ImageView imageView;
    private Button selectBtn;
    private Button cutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageview_cut);
        imageView= (ImageView)findViewById(R.id.image_view_result);
        selectBtn = (Button)findViewById(R.id.button_select_img);
        cutBtn= (Button)findViewById(R.id.button_cut_img);

        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, IMAGE_SELECT);
            }
        });

        cutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(getCutIntent(), IMAGE_CUT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK)
        {
            if(requestCode == IMAGE_SELECT)
            {
                Uri selectUri = data.getData(); //使用ACTION_PICK打开窗口，data返回的是uri
                Point pt = new Point();
                getWindowManager().getDefaultDisplay().getSize(pt);
                BitmapFactory.Options option = new BitmapFactory.Options();
//                option.inJustDecodeBounds = true; //生成Bitmap时不占用内存
                try {
                    //先读取bitmap的大小
                    BitmapFactory.decodeStream(getContentResolver().openInputStream(selectUri), null, option );
                    int hRatio = (int)Math.ceil(option.outHeight * 1.0 / pt.x);
                    int wRatio = (int)Math.ceil(option.outWidth * 1.0 /pt.y);

                    if(hRatio >wRatio)
                    {
                        option.inSampleSize = hRatio;
                    }
                    else
                    {
                        option.inSampleSize = wRatio;
                    }
                    option.inJustDecodeBounds = false;
                    Bitmap bm = BitmapFactory.decodeStream(getContentResolver().openInputStream(selectUri), null, option );
                    imageView.setImageBitmap(bm);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else if(requestCode == IMAGE_CUT)
            {
                Bitmap bm = data.getParcelableExtra("data");
                imageView.setImageBitmap(bm);
            }
        }
    }


    private Intent getCutIntent() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT, null);
        intent.setType("image/*"); //获取任意图片类型
        intent.putExtra("crop", "true"); //可以拖动选择
        intent.putExtra("aspectX", 1); //表示见剪切框的比例是1:1
        intent.putExtra("aspectY", 1); //表示见剪切框的比例是1:1
        intent.putExtra("outputX", 80); //输出剪切框的宽度
        intent.putExtra("outputY", 80); //输出剪切框的高度
        intent.putExtra("return-data", true); //输出数据
        return intent;
    }
}
