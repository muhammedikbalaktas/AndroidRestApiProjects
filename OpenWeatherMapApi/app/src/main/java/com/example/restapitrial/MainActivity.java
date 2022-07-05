package com.example.restapitrial;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;

public class MainActivity extends AppCompatActivity {
    public static final String URL_FOR_REQUEST="https://api.openweathermap.org/data/2.5/weather?q=Mardin,tr&appid=YOUR_APP_ID_&lang=tr&units=metric";
    private static String data="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getVolleyResult();


    }



    public String getResult(City city){


        String result="";
        result+="enlem: "+city.lat;
        result+="\nboylam: "+city.lon;
        result+="\nhava: "+city.wheatherDescription;
        result+="\nsıcaklık: "+city.temp;
        result+="\nhissedilen sıcaklık: "+city.tempFeelsLike;
        result+="\nmaksimum sıcaklık: "+city.tempMax;
        result+="\nminimum sıcaklık: "+city.tempMin;
        result+="\nnem: "+city.humidity;
        result+="\nrüzgar hızı: "+city.windSpeed;
        result+="\nrüzgar derecesi: "+city.windDegree;
        result+="\nbulut oranı: %"+city.cloudRate;


        return result;
    }
    public void getVolleyResult(){
        RequestQueue reqeustQueue= Volley.newRequestQueue(this);

        StringRequest stringRequest =new StringRequest(Request.Method.GET, URL_FOR_REQUEST, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                data=response;
                Toast.makeText(getApplicationContext(),"volley successed",Toast.LENGTH_LONG).show();
                City mardin;
                JsonManager jsonManager=new JsonManager();

                if(!isFinishing()){
                    try {
                        mardin=jsonManager.arrangeCityData(data);
                        TextView tv_result=findViewById(R.id.tv_result);
                        TextView tv_title=findViewById(R.id.tv_title);
                        tv_title.setText("MARDİN");
                        tv_result.setText(getResult(mardin));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"some error occured"+error,Toast.LENGTH_LONG).show();
            }
        });
        reqeustQueue.add(stringRequest);








    }
}