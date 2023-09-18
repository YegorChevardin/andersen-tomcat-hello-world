package com.yehorchevardin.andersen.javaee.helloworld;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HomeServlet", value = "/home")
public class HomeServlet extends HttpServlet {
  private String message;

  public void init() {
    message = "Hello, %s!";
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String name = req.getParameter("name");

    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();
    out.println("<h1>" + String.format(message, name) + "</h1>");
  }
}
