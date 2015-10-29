package com.hat.testmarqueen;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.hat.tools.HttpUtils;


/**
 * Created by anting.hu on 2015/10/29.
 */
public class ActivityImageViewHttp extends Activity {
    private ImageView imageView;
    private Button button;
    private HttpHandle mHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageview_http);
        imageView = (ImageView)findViewById(R.id.image_view_http);
        button = (Button)findViewById(R.id.button_download_img);
        mHandler = new HttpHandle();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                new Thread() {
//                    @Override
//                    public void run() {
//                        HttpUtils.SendRequest("http://pic33.nipic.com/20130927/13741070_125718601105_2.jpg", mHandler);
//                    }
//                }.start();

                String imageUrl="http://pic33.nipic.com/20130927/13741070_125718601105_2.jpg";
                RequestQueue requestQueue = Volley.newRequestQueue(ActivityImageViewHttp.this);

                ImageLoader imageLoader = new ImageLoader(requestQueue, new ImageLoader.ImageCache() {
                    @Override
                    public Bitmap getBitmap(String url) {
                        return null;
                    }

                    @Override
                    public void putBitmap(String url, Bitmap bitmap) {

                        imageView.setImageBitmap(bitmap);
                    }
                });
                imageLoader.get(imageUrl, new ImageLoader.ImageListener() {
                    @Override
                    public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {

                    }

                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

            }
        });
    }


    class HttpHandle extends Handler
    {
        @Override
        public void handleMessage(Message msg) {
            if(msg.what == HttpUtils.HTTP_FINISH)
            {
                Bundle bundle = msg.getData();
                byte[] data = bundle.getByteArray("data");
                Bitmap bm = BitmapFactory.decodeByteArray(data, 0, data.length);
                imageView.setImageBitmap(bm);
            }
        }
    }


}
