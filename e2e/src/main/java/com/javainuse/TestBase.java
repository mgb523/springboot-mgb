package com.javainuse;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class TestBase {
    public static String NAVIGATION_ROUTE = "http://localhost:8989";
    public static String SHORT_LINK = "/short-link";
    public static String USAGE_COUNT = "/usage-count";

    public CloseableHttpResponse getRequest(String uri) throws IOException {
        HttpUriRequest request = new HttpGet(
                NAVIGATION_ROUTE +
                        uri);
        CloseableHttpResponse response = executeRequest(request);
        response.close();
        return response;
    }

    private CloseableHttpResponse executeRequest(HttpUriRequest request) throws IOException {
        return HttpClientBuilder.create().build().execute(request);
    }
}
