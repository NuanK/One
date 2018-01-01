package com.bwie.one.utils;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * 应用层拦截器
 */
public class CommonParamsInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        //得到原始的请求对象
        Request request = chain.request();//原始的请求项
        //得到请求方式 Get 、Post
        String method = request.method();
        if("GET".equals(method)){
            //取出原始的url
            String oldUrl = request.url().toString();
            System.out.println("原始的url : "+oldUrl);
            String newUrl = oldUrl + "&source=android";
            System.out.println("一个新的请求url : "+newUrl);
            //构建新的request
            request = new Request.Builder()
                    .url(newUrl)
                    .build();
        }else if("POST".equals(method)){
            //1,取出旧的参数以及url
            FormBody body = (FormBody) request.body();
            //取出旧的Url
            String oldUrl = request.url().toString();
            //构建一个新的FormBody
            FormBody.Builder newFormBody = new FormBody.Builder();
            for (int i = 0; i < body.size();i++){
                String key = body.name(i);//keywors
                String value = body.value(i);//value
                newFormBody.add(key,value);
            }
            //公共参数
            newFormBody.add("source","android");
            //新构建的reqeust
            request = new Request.Builder()
                    .url(oldUrl)
                    .post(newFormBody.build())
                    .build();
            //2.构建请求体
            //3.重新执行
        }
        return chain.proceed(request);
    }
}
