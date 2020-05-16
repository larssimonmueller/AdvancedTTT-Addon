package org.sevennb.ttt.panel;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.sevennb.ttt.utils.ListUtils;
import org.sevennb.ttt.utils.TestLevel;

import java.io.IOException;
import java.io.OutputStream;

public class Handler implements HttpHandler {

    public static String listone = "";
    public static String listtwo = "";

    @Override
    public void handle(HttpExchange he) throws IOException {
        listone = ListUtils.getListAsString(TestLevel.ONE).replaceAll("§a", "").replaceAll("§f", "");
        listtwo = ListUtils.getListAsString(TestLevel.TWO).replaceAll("§2", "").replaceAll("§f", "");
        String response = "<!DOCTYPE html>\n" +
                "<html lang=\"de\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>ATP</title>\n" +
                "    <meta http-equiv=\"refresh\" content=\"1\";>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            background-color: #1C1A2D;\n" +
                "            color: #fff;\n" +
                "            font-size: 40px;\n" +
                "        }\n" +
                "        .content {\n" +
                "            padding-top: 3%;\n" +
                "            padding-left: 3%;\n" +
                "            font-family: \"Segoe UI\", sans-serif;\n" +
                "        }\n" +
                "        h1 {\n" +
                "            font-family: Impact, sans-serif;\n" +
                "            padding-left: 10px;\n" +
                "        }\n" +
                "        strong{\n" +
                "            font-family: Impact, sans-serif;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>ATP 1.0</h1>\n" +
                "<div class=\"content\">\n" +
                "    <h3><strong>Testlevel 1:</strong> "+listone+"</h3><br>\n" +
                "    <h3><strong>Testlevel 2:</strong> "+listtwo+"</h3>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>\n";
        he.sendResponseHeaders(200, response.length());
        OutputStream os = he.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
