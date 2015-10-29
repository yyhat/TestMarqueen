/*
 * Copyright (c) 2013. wyouflf (wyouflf@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hat.tools;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class HttpUtils {
    public static final int HTTP_FINISH = 1;

    public static void SendRequest(String url, Handler handler) {
        HttpGet request = new HttpGet(url);
        HttpClient httpClient = new DefaultHttpClient();

        byte[] data = null;
        InputStream in = null;
        try {
            HttpResponse response = httpClient.execute(request);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                in = response.getEntity().getContent();
                byte[] buf = new byte[1024];
                int len = 0;
                while ((len = in.read(buf))!= -1) {
                    out.write(buf, 0, len);
                }
                data = out.toByteArray();
                Message msg = new Message();
                msg.what =HTTP_FINISH;
                Bundle bundle = new Bundle();
                bundle.putByteArray("data", data);
                msg.setData(bundle);
                handler.sendMessage(msg);
                out.close();
            }
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
