package com.example.jugendhackt.discipulus;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        WebView mbWebview = new WebView(this);
        mbWebview.getSettings().setJavaScriptEnabled(true); // enable javascript
        final Activity activity = this;

        mbWebview.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
        });

        mbWebview .loadUrl("https://mobile.dsbcontrol.de/dsbmobilepage.aspx?user=196044&password=DVfSiW");
        setContentView(mbWebview);

    }
}
