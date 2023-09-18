package com.yehorchevardin.andersen.javaee.helloworld;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "Hello", value = "/hello")
public class HelloServlet extends HttpServlet {
  private String message;

  @Override
  public void init() {
    message = "Hello, %s!";
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String name = req.getParameter("name");
    Writer writer = resp.getWriter();
    writer.write("<h1>");
    writer.write(String.format(message, name));
    writer.write("</h1>");
  }
}
