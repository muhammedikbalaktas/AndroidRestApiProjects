package com.example.caloriesoffoods__okhttp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent=getIntent();

        String result=intent.getStringExtra("result");
        try {

            arrangeData(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void arrangeData(String data) throws JSONException {

        Food food=new Food();
        JSONObject jsonObject=new JSONObject(data);
        JSONArray items=jsonObject.getJSONArray("items");
        if(items.length()==0){
            TextView tv_result=findViewById(R.id.tv_result);
            tv_result.setText("wrong input detected please retype it!");


        }
        else{
            JSONObject jsonObject1=items.getJSONObject(0);


            food.setŞeker(jsonObject1.getDouble("sugar_g"));
            food.setLif(jsonObject1.getDouble("fiber_g"));
            food.setGramaj(100);
            food.setSodyum(jsonObject1.getDouble("sodium_mg"));
            food.setIsim(jsonObject1.getString("name"));
            food.setPotasyum(jsonObject1.getDouble("potassium_mg"));
            food.setDoymuş_yağ(jsonObject1.getDouble("fat_saturated_g"));
            food.setYağ(jsonObject1.getDouble("fat_total_g"));
            food.setKalori(jsonObject1.getDouble("calories"));
            food.setKolestrol(jsonObject1.getDouble("cholesterol_mg"));
            food.setProtein(jsonObject1.getDouble("protein_g"));
            food.setKarbonhidrat(jsonObject1.getDouble("carbohydrates_total_g"));
            TextView tv_result=findViewById(R.id.tv_result);
            tv_result.setText(food.toString());
            TextView tv_title=findViewById(R.id.tv_title);
            tv_title.setText(food.getIsim());
        }




    }
}