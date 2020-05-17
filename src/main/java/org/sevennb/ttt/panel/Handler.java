package org.sevennb.ttt.panel;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.sevennb.ttt.modules.FalleModule;
import org.sevennb.ttt.modules.RolleModule;
import org.sevennb.ttt.utils.ListUtils;
import org.sevennb.ttt.utils.TestLevel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Handler implements HttpHandler {

    public static String listone = "";
    public static String listtwo = "";

    @Override
    public void handle(HttpExchange he) throws IOException {
        listone = ListUtils.getListAsString(TestLevel.ONE).replaceAll("§a", "").replaceAll("§f", "");
        listtwo = ListUtils.getListAsString(TestLevel.TWO).replaceAll("§2", "").replaceAll("§f", "");
        String response = "";
        try {
            Scanner scanner;
            scanner = new Scanner(new File("LabyMod/addons-1.8/AdvancedTTT/PanelTemplate.php"));
            while(scanner.hasNext()) {
                String line = scanner.nextLine();
                String falle = FalleModule.falle.replaceAll("§a§l", "").replaceAll("§2§l", "").replaceAll("§4§l", "").replaceAll("§c§l", "");
                String rolle = RolleModule.rolle.replaceAll("§4", "").replaceAll("§a", "").replaceAll("§9", "");
                line = line.replaceAll("%lo", listone).replaceAll("%lt", listtwo).replaceAll("%falle", falle).replaceAll("%rolle", rolle);
                response = response+"\n"+line;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        he.sendResponseHeaders(200, response.length());
        OutputStream os = he.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
