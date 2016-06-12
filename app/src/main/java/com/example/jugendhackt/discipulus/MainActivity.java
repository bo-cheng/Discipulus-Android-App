package com.example.jugendhackt.discipulus;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

public class MainActivity extends AppCompatActivity {

    private TableLayout vertretungsplan;
    private String name = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button dsb = (Button) findViewById(R.id.button);
        dsb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(intent);
            }
        });
        vertretungsplan = (TableLayout) findViewById(R.id.vertretungsplan);
        for (Vertretungsstunde vertretungsstunde : readVertretungsplan()) {
            TableRow row = new TableRow(MainActivity.this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);
            TextView stunde = new TextView(MainActivity.this);
            TextView fach = new TextView(MainActivity.this);
            TextView raum = new TextView(MainActivity.this);
            stunde.setText(vertretungsstunde.getStunde());
            fach.setText(vertretungsstunde.getFach());
            raum.setText(vertretungsstunde.getRaum());
            stunde.setTextSize(20);
            fach.setTextSize(20);
            raum.setTextSize(20);
            row.addView(stunde);
            row.addView(fach);
            row.addView(raum);
            vertretungsplan.addView(row);
        }
        /*JSONObject main  = reader.getJSONObject("main");
        temperature = main.getString("temp");*/
    }
    protected List<Vertretungsstunde> readVertretungsplan() {
        List<Vertretungsstunde> vertretungsplan = new ArrayList<>();
        vertretungsplan.add(new Vertretungsstunde("1. Stunde ", " Mathematik", " Physik 1"));
        vertretungsplan.add(new Vertretungsstunde("2. Stunde ", " Deutsch", " Chemie 2"));
        vertretungsplan.add(new Vertretungsstunde("3. Stunde ", " Englisch", " Musikraum 1"));
        return vertretungsplan;
    }
    /*protected List<Vertretungsstunde> readVertretungsplanServer() {
        OkHttpClient client = new OkHttpClient();
        List<Vertretungsstunde> vertretungsplan = new ArrayList<>();
        Request request = new Request.Builder()
                .url("http://172.16.102.200:8080/getSubjects")
                .post(new FormBody.Builder().build())
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "2a1b89ec-2368-a1dc-d4b3-a7498d4c2a22")
                .build();

        try {
            Response response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String in = "";
            JSONObject reader = new JSONObject(in);
            JSONObject result = null;
            result = reader.getJSONObject("result");
            name = reader.getJSONArray("result").getJSONObject(0).getString("name");
            vertretungsplan.add(new Vertretungsstunde("1. Stunde", name));
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        vertretungsplan.add(new Vertretungsstunde("2. Stunde", "Deutsch"));
        return vertretungsplan;
    }*/
    /*protected void loadData() {
        Runnable runnable = new Runnable(){
            @Override
            public void run() {

            }
        };
        this.runOnUiThread(runnable);
    }*/
}
