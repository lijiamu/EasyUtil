package com.picker;

import android.content.Context;
import android.content.res.AssetManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author：李佳模 ON：2020/10/30
 * description: 从 assets 中province.json文件 获取省市区 数据
 */
public class CityData {
    public static List<String> provinceList = new ArrayList<>();
    public static List<List<String>> cityList = new ArrayList<>();
    public static List<List<List<String>>> areaList = new ArrayList<>();
    public static void initCity(Context context){
        //获取assets目录下的json文件数据
        String JsonData = getJson(context,"province.json");
        parseJson(JsonData);
    }
    /**
     * 从asset目录下读取fileName文件内容
     *
     * @param fileName 待读取asset下的文件名
     * @return 得到省市县的String
     */
    public static String getJson(Context context,String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            AssetManager assetManager =context.getAssets();
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
    /**
     * 解析json填充集合
     *
     * @param str 待解析的json，获取省市县
     */
    public static void parseJson(String str) {
        try {
            //  获取json中的数组
            JSONArray jsonArray = new JSONArray(str);
            //  遍历数据组
            for (int i = 0; i < jsonArray.length(); i++) {
                //  获取省份的对象
                JSONObject provinceObject = jsonArray.optJSONObject(i);
                //  获取省份名称放入集合
                String provinceName = provinceObject.getString("name");
                provinceList.add(provinceName);
                //  获取城市数组
                JSONArray cityArray = provinceObject.optJSONArray("city");
                List<String> tempCitys = new ArrayList<>();
                //   声明存放城市的集合
                List<List<String>> tempAreas = new ArrayList<>();
                //声明存放区县集合的集合
                //  遍历城市数组
                for (int j = 0; j < cityArray.length(); j++) {
                    //  获取城市对象
                    JSONObject cityObject = cityArray.optJSONObject(j);
                    //  将城市放入集合
                    String cityName = cityObject.optString("name");
                    tempCitys.add(cityName);
                    List<String> tempAreas2 = new ArrayList<>();
                    // 声明存放区县的集合
                    //  获取区县的数组
                    JSONArray areaArray = cityObject.optJSONArray("area");
                    //  遍历区县数组，获取到区县名称并放入集合
                    for (int k = 0; k < areaArray.length(); k++) {
                        String areaName = areaArray.getString(k);
                        tempAreas2.add(areaName);
                    }
                    //  将区县的集合放入集合
                    tempAreas.add(tempAreas2);
                }
                //  将存放区县集合的集合放入集合
                areaList.add(tempAreas);
                //  将存放城市的集合放入集合
                cityList.add(tempCitys);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
