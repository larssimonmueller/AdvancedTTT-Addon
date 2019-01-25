package org.sevennb.ttt.utils.data;

import net.labymod.main.LabyMod;
import org.sevennb.ttt.TTTAddon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebHandler {

    public static void send(String role){
        if(TTTAddon.DATA){
            read("https://7nb.org/mod/index.php?id="+ LabyMod.getInstance().getPlayerUUID().toString() +"&role="+role);
        }
    }

    public static String read(String url){
        StringBuilder response=new StringBuilder();
        String USER_AGENT="Mozilla/5.0",inputLine;
        BufferedReader in=null;

        try
        {
            HttpURLConnection con=(HttpURLConnection)new URL(url).openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept-Charset","UTF-8");
            con.setRequestProperty("User-Agent",USER_AGENT);
            int responseCode=con.getResponseCode();
            in=new BufferedReader(new InputStreamReader(con.getInputStream()));
            while ((inputLine=in.readLine())!=null) { response.append(inputLine); }
            in.close();
        }
        catch (Exception e) { e.printStackTrace(); }
        finally
        {
            try { if (in!=null) in.close(); }
            catch (Exception ex) { ex.printStackTrace(); }
        }
        return response.toString();
    }
}
