package com.example.xiang.cat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Xiang on 2017/10/5.
 */

public class PageToday extends Fragment {
    public String showUri="https://catravel.herokuapp.com/api/activity/?";
    ListView listView;
    String values[];

    com.android.volley.RequestQueue requestQueue;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        requestQueue = Volley.newRequestQueue(getContext());
        View view = inflater.inflate(R.layout.page_today, container, false);
        TextView txvtd = (TextView) view.findViewById(R.id.txvtd);
        listView = (ListView)view.findViewById(R.id.popEventList);
        Thread t= new Thread(event);
        t.start();
        return  view;

    }
    private Runnable event=new Runnable () {
        public void run() {
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, showUri, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    try {
                        values=new String[response.length()];
                        for(int i= 0;i<response.length();i++){
                            JSONObject jasondata = response.getJSONObject(i);
                            String title = jasondata.getString("title");
                            values[i]=title;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    ArrayAdapter<String> listAdapter;
                    listAdapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,values);
                    listView.setAdapter(listAdapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        }
                    });
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    System.out.append(error.getMessage());
                }
            });
            requestQueue.add(jsonArrayRequest);
        }
    };

}
