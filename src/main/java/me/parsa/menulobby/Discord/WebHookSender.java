package me.parsa.menulobby.Discord;

import okhttp3.*;

public class WebHookSender {
    public static void sendWebhookMessage(String content, String WEBHOOK_URL) {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"),
                "{ \"content\": \"" + content + "\" }"
        );
        Request request = new Request.Builder()
                .url(WEBHOOK_URL)
                .post(body)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                System.out.println("Error sending webhook: " + response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
