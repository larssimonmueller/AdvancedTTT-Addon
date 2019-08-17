package org.sevennb.ttt.utils.data;

import net.labymod.main.LabyMod;
import org.sevennb.ttt.TTTAddon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebHandler {

    public static String read(String url) {
        StringBuilder response = new StringBuilder();
        String USER_AGENT = "Mozilla/5.0", inputLine;
        BufferedReader in = null;

        try {
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept-Charset", "UTF-8");
            con.setRequestProperty("User-Agent", USER_AGENT);
            int responseCode = con.getResponseCode();
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        } catch (Exception e) {
            if (TTTAddon.DEVELOPERS.contains(LabyMod.getInstance().getPlayerName())) {
                LabyMod.getInstance().displayMessageInChat("§c" + e.getMessage());
            }
        } finally {
            try {
                if (in != null) in.close();
            } catch (Exception ex) {
                if (TTTAddon.DEVELOPERS.contains(LabyMod.getInstance().getPlayerName())) {
                    LabyMod.getInstance().displayMessageInChat("§cWebread: " + ex.getMessage());
                }
            }
            return response.toString();
        }
    }


    public static List<String> readDevelopers(){
        List<String> perms = new ArrayList<String>();
            String out = read("https://7nb.org/mod/devs.txt");
            String[] array = out.split(";");
            perms.clear();
            perms = Arrays.asList(array);
        return perms;
    }
}
