package org.sevennb.ttt.panel;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;

public class LogoHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange he) throws IOException {
        Headers headers = he.getResponseHeaders();
        headers.add("Content-Type", "image/png");

        File file = new File ("LabyMod/addons-1.8/AdvancedTTT/assets/logo.png");
        byte[] bytes  = new byte [(int)file.length()];
        System.out.println(file.getAbsolutePath());
        System.out.println("length:" + file.length());

        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        bufferedInputStream.read(bytes, 0, bytes.length);

        he.sendResponseHeaders(200, file.length());
        OutputStream outputStream = he.getResponseBody();
        outputStream.write(bytes, 0, bytes.length);
        outputStream.close();
    }
}
