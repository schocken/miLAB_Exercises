package com.vogella.android.ex10;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Schocken on 03/01/2018.
 */

public class timeFetcher {
    public void dispatchRequest(final timeResponseListener listener) {
            JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, "10.0.2.2", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            timeResponse res = new timeResponse(false,
                                    response.getString("time"),
                            listener.onResponse(res);
                        } catch (JSONException e) {
                            listener.onResponse(createErrorResponse());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onResponse(createErrorResponse());
            }
        });
    }
}
