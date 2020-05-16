package org.sevennb.ttt.panel;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import net.labymod.main.LabyMod;

import java.io.IOException;
import java.io.OutputStream;

public class Handler implements HttpHandler {

    @Override
    public void handle(HttpExchange he) throws IOException {
        String response = "<!DOCTYPE html>\n" +
                "<html lang=\"de\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>ATP</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>ATP 1.0</h1>\n" +
                "<h3>Test ONE: <strong id=\"listone\"></strong></h3>\n" +
                "<h3>Test TWO: <strong id=\"listtwo\"></strong></h3>\n" +
                "</body>\n" +
                "</html>\n" +
                "<script>\n" +
                "    var instance = setInterval(update, 1000)\n" +
                "\n" +
                "    function update() {\n" +
                "        //Test Level 1\n" +
                "        var rawFile = new XMLHttpRequest();\n" +
                "        rawFile.open(\"GET\", \"list1.atp\", false);\n" +
                "        rawFile.onreadystatechange = function ()\n" +
                "        {\n" +
                "            if(rawFile.readyState === 4)\n" +
                "            {\n" +
                "                if(rawFile.status === 200 || rawFile.status == 0)\n" +
                "                {\n" +
                "                    var allText = rawFile.responseText;\n" +
                "                    $('#listone').text(allText);\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "        rawFile.send(null);\n" +
                "\n" +
                "        //Test Level 2\n" +
                "        rawFile = new XMLHttpRequest();\n" +
                "        rawFile.open(\"GET\", \"list2.atp\", false);\n" +
                "        rawFile.onreadystatechange = function ()\n" +
                "        {\n" +
                "            if(rawFile.readyState === 4)\n" +
                "            {\n" +
                "                if(rawFile.status === 200 || rawFile.status == 0)\n" +
                "                {\n" +
                "                    allText = rawFile.responseText;\n" +
                "                    $('#listtwo').text(allText);\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "        rawFile.send(null);\n" +
                "    }\n" +
                "</script>";
        he.sendResponseHeaders(200, response.length());
        OutputStream os = he.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
