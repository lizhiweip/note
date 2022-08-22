package com.li.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

public class jsonUtil {
    public static String getJson(Object object) throws JsonProcessingException {
        return getJson(object,"yyyy-MM-dd HH:mm:ss");
    }



    public static String getJson(Object object,String dateFormat) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        //使用ObjectMapper来格式输出
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);//关闭时间戳
        //自定义日期格式
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        mapper.setDateFormat(sdf);

        return mapper.writeValueAsString(object);
    }





}
