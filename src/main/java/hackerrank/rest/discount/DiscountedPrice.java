package hackerrank.rest.discount;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DiscountedPrice {
    /*
     * Complete the 'getDiscountedPrice' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER barcode as parameter.
     * API URL: https://jsonmock.hackerrank.com/api/inventory?barcode=<barcode>
     */
    public static final String BARCODE_URI = "https://jsonmock.hackerrank.com/api/inventory?barcode=";
    private static final String USER_AGENT = "Mozilla/5.0";

    public static int getDiscountedPrice(int barcode) {
        URL obj = null;
        HttpURLConnection con = null;
        try {
            obj = new URL(BARCODE_URI + barcode);
            con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            int responseCode = 0;
            responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            StringBuffer response = new StringBuffer();
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;

                while (true) {
                    if (!((inputLine = in.readLine()) != null)) break;
                    response.append(inputLine);
                }
                in.close();
            } else {
                System.out.println("GET request did not work.");
            }

            Object object = JSONValue.parse(response.toString());
            JSONObject jsonObject = (JSONObject) object;
            JSONArray jsonArray = (JSONArray) jsonObject.get("data");
            if (jsonArray.size() == 0) {
                return -1;
            }
            jsonObject = (JSONObject) jsonArray.get(0);
            long price = (long) jsonObject.get("price");
            long discount = (long) jsonObject.get("discount");
            long discountedPrice = (long) (price - ((discount / 100.0) * price));
            return (int) discountedPrice;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(getDiscountedPrice(74002314));
        System.out.println(getDiscountedPrice(74005364));
    }
}
