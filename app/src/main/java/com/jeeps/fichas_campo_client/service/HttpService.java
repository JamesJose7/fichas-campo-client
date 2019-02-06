package com.jeeps.fichas_campo_client.service;

import com.jeeps.fichas_campo_client.model.User;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Credentials;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class HttpService {
    private HttpServiceListener listener;
    private OkHttpClient client;

    public interface HttpServiceListener {
        void onSuccess(String json);
        void onFailure();
        void postResult(String json);
    }

    public HttpService(HttpServiceListener listener) {
        this.listener = listener;
    }

    public void sendAuthRequest(String url, User user) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .build();

        client = new OkHttpClient.Builder().authenticator((route, response) -> {
            if (response.request().header("Authorization") != null) {
                return null; // Give up, we've already attempted to authenticate.
            }

            //System.out.println("Authenticating for response: " + response);
            //System.out.println("Challenges: " + response.challenges());
            String credential = Credentials.basic(user.getUsername(), user.getPassword());
            return response.request().newBuilder()
                    .header("Authorization", credential)
                    .build();
        }).build();

        client.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                listener.onFailure();
            }

            @Override public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful()) {
                        listener.onFailure();
                        throw new IOException("Unexpected code " + response);
                    }

                    /*Headers responseHeaders = response.headers();
                    for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                        System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                    }*/
                    listener.onSuccess(responseBody.string());
                }
            }
        });
    }

    public void sendRequest(String url) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .build();

        client = new OkHttpClient();

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

    public void postAuthRequest(String url, String postBody, User user) throws Exception {
        MediaType JSON_FORMAT = MediaType.parse("application/json");

        client = new OkHttpClient.Builder().authenticator((route, response) -> {
            if (response.request().header("Authorization") != null)
                return null; // Give up, we've already attempted to authenticate.
            String credential = Credentials.basic(user.getUsername(), user.getPassword());
            return response.request().newBuilder()
                    .header("Authorization", credential)
                    .build();
        }).build();

        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(JSON_FORMAT, postBody))
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                    System.out.println("HTTP: " + response.code());
                    Headers responseHeaders = response.headers();
                    for (int i = 0, size = responseHeaders.size(); i < size; i++)
                        System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                    listener.postResult(responseHeaders.get("Location"));
                }
            }
        });
    }

    public void sendDeleteRequest(String url, User user) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .delete()
                .build();

        client = new OkHttpClient.Builder().authenticator((route, response) -> {
            if (response.request().header("Authorization") != null)
                return null; // Give up, we've already attempted to authenticate.
            String credential = Credentials.basic(user.getUsername(), user.getPassword());
            return response.request().newBuilder()
                    .header("Authorization", credential)
                    .build();
        }).build();

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
                    listener.onSuccess(responseBody.toString());
                }
            }
        });
    }

}
