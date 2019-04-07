package web.servlets;

import database.ConnectDatabase;
import database.CreateTable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DatabaseServlet", urlPatterns = {"database"})
public class DatabaseServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ConnectDatabase connect = new ConnectDatabase();
        CreateTable create = new CreateTable();
        connect.connect();
        create.create();
        response.sendRedirect("/");
    }

}
