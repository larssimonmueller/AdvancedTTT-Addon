package org.sevennb.ttt.panel;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.sevennb.ttt.utils.ListUtils;
import org.sevennb.ttt.utils.TestLevel;

import java.io.IOException;
import java.io.OutputStream;

public class TestTwoHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange he) throws IOException {
        String listtwo = "<div>"+ListUtils.getListAsString(TestLevel.TWO).replaceAll("§2", "").replaceAll("§f", "")+"</div>";
        he.sendResponseHeaders(200, listtwo.length());
        OutputStream os = he.getResponseBody();
        os.write(listtwo.getBytes());
        os.close();
    }

}
