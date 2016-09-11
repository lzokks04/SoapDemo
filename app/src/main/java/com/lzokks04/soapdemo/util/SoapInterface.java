package com.lzokks04.soapdemo.util;

import com.lzokks04.soapdemo.util.request.RequestEnvelope;
import com.lzokks04.soapdemo.util.response.ResponseEnvelope;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 此retrofit接口负责设置请求头的设置，目标，
 * RequestEnvelope对象转换成xml后post到服务器
 * 服务器返回xml再解析成ResponseEnvelope获取有关数据
 * Created by Liu on 2016/9/11.
 */
public interface SoapInterface {
    //请求头
    @Headers({"Content-Type: application/soap+xml; charset=utf-8"})
    //请求的地址，前缀 http://www.webxml.com.cn/WebServices/ 发送一个post请求
    @POST("qqOnlineWebService.asmx")
    //将RequestEnvelope对象转换成XML进行POST请求，返回的数据为ResponseEnvelope再转成XML提取需要的数据
    Call<ResponseEnvelope> getdata(@Body RequestEnvelope requestEnvelope);
}
