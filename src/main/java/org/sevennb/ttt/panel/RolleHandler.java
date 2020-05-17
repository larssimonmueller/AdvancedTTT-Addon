package org.sevennb.ttt.panel;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.sevennb.ttt.modules.RolleModule;
import org.sevennb.ttt.utils.ListUtils;
import org.sevennb.ttt.utils.TestLevel;

import java.io.IOException;
import java.io.OutputStream;

public class RolleHandler implements HttpHandler {


    @Override
    public void handle(HttpExchange he) throws IOException {
        String response = RolleModule.rolle.replaceAll("§4", "").replaceAll("§a", "").replaceAll("§9", "");
        he.sendResponseHeaders(200, response.length());
        OutputStream os = he.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
