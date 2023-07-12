package hackerrank.rest.discount;

import java.io.*;
import java.math.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.*;
import java.text.*;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.net.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class DiscountedPrice {
    /*
     * Complete the 'getDiscountedPrice' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER barcode as parameter.
     * API URL: https://jsonmock.hackerrank.com/api/inventory?barcode=<barcode>
     */
    public static final String BARCODE_URI = "https://jsonmock.hackerrank.com/api/inventory?barcode=";

    public static int getDiscountedPrice(int barcode) {
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .followRedirects((HttpClient.Redirect.NORMAL))
                .connectTimeout(Duration.ofSeconds(20))
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BARCODE_URI + barcode))
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Object obj = JSONValue.parse(response.body());
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jsonObject.get("data");
            if (jsonArray.size() == 0) {
                return -1;
            }
            jsonObject = (JSONObject) jsonArray.get(0);
            long price = (long)jsonObject.get("price");
            long discount = (long)jsonObject.get("discount");
            long discountedPrice = (long)(price - ((discount / 100.0) * price));
            return (int)discountedPrice;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(getDiscountedPrice(74002314));
        System.out.println(getDiscountedPrice(74005364));
    }
}
