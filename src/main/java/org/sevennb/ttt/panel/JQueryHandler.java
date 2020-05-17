package org.sevennb.ttt.panel;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;

public class JQueryHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange he) throws IOException {
        Headers headers = he.getResponseHeaders();
        headers.add("Content-Type", "text/js");

        File file = new File ("LabyMod/addons-1.8/AdvancedTTT/assets/jquery-3.5.1.min.js");
        byte[] bytes  = new byte [(int)file.length()];

        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        bufferedInputStream.read(bytes, 0, bytes.length);

        he.sendResponseHeaders(200, file.length());
        OutputStream outputStream = he.getResponseBody();
        outputStream.write(bytes, 0, bytes.length);
        outputStream.close();
    }

}
