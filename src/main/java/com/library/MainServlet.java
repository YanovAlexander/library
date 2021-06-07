package com.library;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> names = new ArrayList<>();
        names.add("Denis");
        names.add("Hanna");
        names.add("Vadym");
        names.add("Oleksandr");
        names.add("Tetiana");
        req.setAttribute("students", names);
        req.getRequestDispatcher("/view/index.jsp").forward(req, resp);
    }
}
