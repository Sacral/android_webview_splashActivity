package com.bdl.willy_android_webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String url = "https://github.com/Sacral/android_webview_splashActivity";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webview = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = webview.getSettings();

        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);//給許可權

        setContentView(webview);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl(url);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event ) {//捕捉返回鍵

        /*if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (webview.canGoBack()) {
                webview.goBack();
                return true;
            }
            else{
                ConfirmExit();//按返回鍵，則執行退出確認
                return true;
            }
        }*/


        if (keyCode == KeyEvent.KEYCODE_BACK) {

                ConfirmExit();//按返回鍵，則執行退出確認
                return true;
            }

        return super.onKeyDown(keyCode, event);
    }

    public void ConfirmExit(){//退出確認
        AlertDialog.Builder ad=new AlertDialog.Builder(MainActivity.this);
        ad.setTitle("離開");
        ad.setMessage("確定要離開此程式嗎?");
        ad.setPositiveButton("是", new DialogInterface.OnClickListener() {//退出按鈕
            public void onClick(DialogInterface dialog, int i) {
                // TODO Auto-generated method stub
                MainActivity.this.finish();//關閉activity
            }
        });
        ad.setNegativeButton("否",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int i) {
                //不退出不用執行任何操作
            }
        });
        ad.show();//顯示對話框
    }

}
//referance
//https://spicyboyd.blogspot.com/2018/05/appandroid-webview-app.html
//https://iter01.com/49313.html
//https://ryanisagoodguy.blogspot.com/2015/02/android-onkeydown.html
//https://blog.csdn.net/kingroc/article/details/51108587
//https://abhiandroid.com/ui/videoview
//http://www.gadgetsaint.com/android/create-video-splash-screen-android/#.X2hEZ8gzaUk
//https://medium.com/@amanyadav2480/video-in-android-app-splash-screen-bc72291abfb7