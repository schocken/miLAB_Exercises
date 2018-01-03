package com.vogella.android.ex10;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.*;
import org.json.JSONObject;
import org.json.JSONException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fetchWeather(final View view) {
        final timeFetcher fetcher = new timeFetcher(view.getContext());
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Fetching weather...");
        progressDialog.show();
        fetcher.dispatchRequest(new timeFetcher().timeResponseListener() {
            @Override
            public void onResponse(timeFetcher.timeResponse response) {
                progressDialog.hide();
                if (response.isError) {
                    Toast.makeText(view.getContext(), "Error while fetching weather", Toast.LENGTH_LONG);
                    return;
                }
                ((TextView)MainActivity.this.findViewById(R.id.time)).setText(response.location);
            }
        });
    }
}
