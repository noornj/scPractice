package com.noor;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import javax.servlet.http.HttpServletResponse;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class httpServer {

  public static void main(String[] args) throws Exception {
    HttpServer server = HttpServer.create(new InetSocketAddress(8350), 0);
    server.createContext("/", new genericHandler());
    server.setExecutor(null);
    server.start();

  }
static class genericHandler implements HttpHandler{
  @Override
  public void handle (HttpExchange v) throws IOException {
    String response = "hello world!";
    v.sendResponseHeaders(200, response.getBytes().length);
    OutputStream outstr = v.getResponseBody();
    outstr.write(response.getBytes());
    outstr.close();
  } 
}

}
