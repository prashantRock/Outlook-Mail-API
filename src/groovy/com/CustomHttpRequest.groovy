package com

import grails.converters.JSON
import org.codehaus.groovy.grails.web.json.JSONObject

/**
 * Created by prashant on 3/2/18.
 */
class CustomHttpRequest {
    private static String CLIENT_ID = "738767fa-1dd3-413b-8797-2c2bd6944683"
    private static String CLIENT_SECRET = "cVHJ17491_}cdxdeqUVHA_*"
    private static String accessCode = "Mb08d4f51-0824-d987-cc84-2d99a263cd0b"
    private static String REDIRECT_URI = "http://localhost:8080/outlook/mail/redirectURL"


    public static  String sendGet(String completeURL, String accessToken) throws Exception {
        String result = "";
        URL url = new URL(completeURL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Authorization", "Bearer "+accessToken);
        conn.setRequestProperty("Content-Type","application/json; charset=utf-8");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result = result + line;
        }
        rd.close();
        return result;
    }

    public static String fetchAccessToken(){
        String googleAccessTokenURL="https://login.microsoftonline.com/common/oauth2/v2.0/token"
        HttpURLConnection con = null;
        OutputStreamWriter writer=null;
        String urlParameters =
                "client_id=" + URLEncoder.encode(CLIENT_ID, "UTF-8") +
                        "&client_secret=" + URLEncoder.encode(CLIENT_SECRET, "UTF-8") +
                        "&grant_type=" + URLEncoder.encode("authorization_code", "UTF-8") +
                        "&code=" + URLEncoder.encode(accessCode, "UTF-8") +
                        "&redirect_uri=" + URLEncoder.encode(REDIRECT_URI, "UTF-8") ;
        String completeURL=googleAccessTokenURL
        URL obj = new URL(completeURL)
        con = (HttpURLConnection) obj.openConnection()
        con.setDoInput(true)
        con.setDoOutput(true)
        con.setRequestMethod("POST")
        con.setRequestProperty("Accept", "application/json")
        con.setRequestProperty("Content-Type","application/x-www-form-urlencoded")
        writer = new OutputStreamWriter(con.getOutputStream(),"UTF-8")
        writer.write(urlParameters)
        writer.flush()
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer responseStream =new StringBuffer();
        while((inputLine= bufferedReader.readLine())!=null)
        {
            responseStream.append(inputLine);
        }
        String apiResponse = responseStream.toString();
        JSONObject userJson = JSON.parse(apiResponse)
        println userJson
        if(con.getResponseCode()==200){
            println "accesss token "+userJson.access_token
        }
    }
}