package org.sevennb.ttt.panel;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.sevennb.ttt.utils.ListUtils;
import org.sevennb.ttt.utils.TestLevel;

import java.io.IOException;
import java.io.OutputStream;

public class TestOneHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange he) throws IOException {
        String listone = ListUtils.getListAsString(TestLevel.ONE).replaceAll("§a", "").replaceAll("§f", "");
        he.sendResponseHeaders(200, listone.length());
        OutputStream os = he.getResponseBody();
        os.write(listone.getBytes());
        os.close();
    }
}
