package com.example.restapitrial;

import java.text.SimpleDateFormat;
import java.util.Date;

public class City {
    String name;
    double lon;//longitude boylam
    double lat;//latitude enlem
    String wheatherDescription;
    double temp;
    double tempFeelsLike;
    double tempMin;
    double tempMax;
    int humidity;//nem
    int visibility;
    double windSpeed;
    double windDegree;
    double cloudRate;//as a percent

    @Override
    public String toString(){
        String sb = "result:\n" +
                this.lon +"\n"+
                this.lat +"\n"+
                this.wheatherDescription +"\n"+
                this.temp +"\n"+
                this.tempFeelsLike +"\n"+
                this.tempMin +"\n"+
                this.tempMax +"\n"+
                this.humidity +"\n"+
                this.visibility +"\n"+
                this.windSpeed +"\n"+
                this.windDegree +"\n"+
                this.cloudRate +"\n";

        return sb;

    }

}
