package org.sevennb.ttt.panel;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.sevennb.ttt.modules.FalleModule;
import org.sevennb.ttt.modules.RolleModule;

import java.io.IOException;
import java.io.OutputStream;

public class FalleHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange he) throws IOException {
        String response = "<div>"+FalleModule.falle.replaceAll("§a§l", "").replaceAll("§2§l", "").replaceAll("§4§l", "").replaceAll("§c§l", "")+"</div>";
        he.sendResponseHeaders(200, response.length());
        OutputStream os = he.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

}
