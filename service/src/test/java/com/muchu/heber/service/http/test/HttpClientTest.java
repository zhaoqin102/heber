package com.muchu.heber.service.http.test;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.javanet.NetHttpTransport;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 梁海鹏
 * @createTime 2017/2/22 15:03
 */
public class HttpClientTest {


    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 10000; i++) {
            service.execute(() -> {
                try {
                    NetHttpTransport.Builder builder = new NetHttpTransport.Builder();
                    NetHttpTransport httpTransport = builder.doNotValidateCertificate().build();
                    HttpRequest httpRequest = httpTransport.createRequestFactory().buildGetRequest(new GenericUrl("https://cn.bing.com"));
                    HttpResponse httpResponse = httpRequest.execute();
                    String s = httpResponse.parseAsString();
                    System.out.println(s);
                    httpResponse.disconnect();
                    httpTransport.shutdown();
                } catch (GeneralSecurityException | IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

}
