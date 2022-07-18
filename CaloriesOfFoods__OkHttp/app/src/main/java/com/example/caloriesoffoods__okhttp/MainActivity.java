package com.example.caloriesoffoods__okhttp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    public static String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText=findViewById(R.id.et_input);
        Button btn_search=findViewById(R.id.btn_search);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Some places are empty",Toast.LENGTH_LONG).show();
                }
                else{
                    String input=editText.getText().toString();
                    sendRequest(input);
                }
            }
        });
    }

    void sendRequest(String input){
        HttpUrl.Builder urlBuilder=HttpUrl.parse("https://calorieninjas.p.rapidapi.com/v1/nutrition").newBuilder();
        urlBuilder.addQueryParameter("query",input);
        String url=urlBuilder.toString();

        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder()
                .url(url)
                .get()
                .addHeader("X-RapidAPI-Key","fe969f7600msh66b179c9495cefep1a0024jsn1d378f194d3d")
                .addHeader("X-RapidAPI-Host","calorieninjas.p.rapidapi.com")
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Toast.makeText(getApplicationContext(),"Error"+e,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) {
                if(response.isSuccessful()){
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),"succeed",Toast.LENGTH_LONG).show();
                            try {
                                result=response.body().string();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                            intent.putExtra("result",result);
                            startActivity(intent);




                        }
                    });
                }

            }
        });

    }
}