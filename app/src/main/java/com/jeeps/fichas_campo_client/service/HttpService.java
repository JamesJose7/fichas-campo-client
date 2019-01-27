package com.jeeps.fichas_campo_client.service;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class HttpService {
    private HttpServiceListener listener;
    private final OkHttpClient client = new OkHttpClient();

    public interface HttpServiceListener {
        void onSuccess(String json);
    }

    public HttpService(HttpServiceListener listener) {
        this.listener = listener;
    }

    public void sendRequest(String url) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                    /*Headers responseHeaders = response.headers();
                    for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                        System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                    }*/
                    listener.onSuccess(responseBody.string());
                }
            }
        });
    }

}
