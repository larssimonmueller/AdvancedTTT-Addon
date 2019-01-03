package org.sevennb.ttt.utils.data;

import net.minecraft.client.Minecraft;
import org.sevennb.ttt.TTTAddon;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class WebHandler {

    public static void send(String role){
        if(TTTAddon.DATA){
            String username = Minecraft.getMinecraft().thePlayer.getName();
            try {
                read(new URL("https://7nb.org/mod.php?name="+username+"&role="+role));
            } catch (MalformedURLException e) {}
        }
    }

    public static String read(URL url){
        Scanner scan = null;
        try {
            scan = new Scanner(url.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (scan != null) {
            while(scan.hasNextLine()) {
                return scan.nextLine();
            }
        }
        return "invalid";
    }
}
