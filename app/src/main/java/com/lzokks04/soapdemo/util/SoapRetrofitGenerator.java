package com.lzokks04.soapdemo.util;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Retrofit请求对象的封装类
 * 包括请求的基址，请求头Content-Type: application/soap+xml; charset=utf-8
 * 转换器设置为SimpleXmlConverterFactory。
 * Created by Liu on 2016/9/11.
 */
public class SoapRetrofitGenerator {

    public final static String BASE_URL = "http://www.webxml.com.cn/WebServices/";

    private static SoapInterface interFace;

    private static Strategy strategy = new AnnotationStrategy();

    private static Serializer serializer = new Persister(strategy);

    private static OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();

    /**
     * 使其变成单例
     *
     * @return
     */
    public static SoapInterface getInterfaceFun() {
        if (interFace == null) {
            interFace = createService(SoapInterface.class);
        }
        return interFace;
    }

    /**
     * 初始化Retrofit.Builder，在SimpleXmlConverterFactory创建时传入Serializer参数
     */
    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(SimpleXmlConverterFactory.create(serializer));

    public static <S> S createService(Class<S> serviceClass) {
        //自定义拦截器
        okHttpClient.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                //初始化Request
                Request original = chain.request();
                Request.Builder requestBuilder = original.newBuilder()
                        //设置成SOAP1.2的头
                        .header("Content-Type", "application/soap+xml; charset=utf-8")
                        .method(original.method(), original.body());
                Request request = requestBuilder.build();
                //返回Request对象
                return chain.proceed(request);
            }
        });

        //设置超时
        OkHttpClient client = okHttpClient.connectTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .build();
        Retrofit retrofit = retrofitBuilder.client(client).build();
        return retrofit.create(serviceClass);
    }


}
