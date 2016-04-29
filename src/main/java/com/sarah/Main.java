package com.sarah;


import com.google.gson.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


class Forecast{
    private String name;
    private List<Double> forecast;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Double> getForecast() {
        return forecast;
    }

    public void setForecast(List<Double> forecast) {
        this.forecast = forecast;
    }

    @Override
    public String toString(){
        String forecastString = name + ": ";
        List<String> forecastStrings = new ArrayList<>();
        for (Double temp :forecast) {
            forecastString = forecastString + " " + temp.toString()
                    + ",";
        }
        return forecastString;
    }
}

public class Main {
    public static void main(String[] args){
        String jsonData = "[{\"name\"} : \"columbus\", "+
                "\"forecast\" : [70, 80, 70, 65, 75]}," +
                "{\"name\"} : \"cleveland\", "+
                "\"forecast\" : [60, 70, 60, 55, 65]}," +
                "{\"name\"} : \"cincinnati\", +
                "\"forecast\" :  [80, 90, 80, 75, 85]}];



        //JsonParser parser = new JsonParser();
        //Forecast forecast = new Forecast();

        //JsonObject jsonObject = parser.parse(jsonData).getAsJsonObject();

        //for (Map.Entry<String, JsonElement> entry: jsonObject.entrySet()) {
            //if (entry.getValue().isJsonArray()){
                //JsonArray jsonArray = entry.getValue().getAsJsonArray();

                //List<Double> temps = new ArrayList<>();
                //for (JsonElement element: jsonArray) {
                   // temps.add(element.getAsDouble());
                //}
               // forecast.setForecast(temps);

            //}
            //else {
                //forecast.setName(entry.getValue().getAsString());
            //}
        //}

        Gson gson = new Gson();
        Forecast[] forecasts = gson.fromJson(jsonData, Forecast.class);
        for (Forecast forecast:forecasts) {
            System.out.println(forecast);

        }
    }
}
