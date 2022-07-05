package com.example.restapitrial;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.TimeZone;

public class JsonManager {
    public City arrangeCityData(String data) throws JSONException {

        JSONObject rootJsonObject=new JSONObject(data);
        City result=new City();
        //coordinate arrangement for temp json

        JSONObject tempJson=rootJsonObject.getJSONObject("coord");
        result.lat=tempJson.getDouble("lat");
        result.lon=tempJson.getDouble("lon");

        //wheather description for temp json

        JSONArray wheather=rootJsonObject.getJSONArray("weather");
        tempJson=wheather.getJSONObject(0);
        result.wheatherDescription=tempJson.getString("description");

        //temperature for temJson

        tempJson=rootJsonObject.getJSONObject("main");
        result.temp=tempJson.getDouble("temp");
        result.tempFeelsLike=tempJson.getDouble("feels_like");
        result.tempMin=tempJson.getDouble("temp_min");
        result.tempMax=tempJson.getDouble("temp_max");
        result.humidity=tempJson.getInt("humidity");


        //wind for tempJson

        tempJson=rootJsonObject.getJSONObject("wind");
        result.windSpeed=tempJson.getDouble("speed");
        result.windDegree=tempJson.getDouble("deg");

        //clouds for tempJson

        tempJson=rootJsonObject.getJSONObject("clouds");
        result.cloudRate=tempJson.getDouble("all");
        result.visibility=rootJsonObject.getInt("visibility");










        return result;

    }




}
