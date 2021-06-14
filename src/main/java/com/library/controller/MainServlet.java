package com.library.controller;

import com.library.config.AppInit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private final static Logger LOG = LoggerFactory.getLogger(MainServlet.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("doGet.");
        req.getRequestDispatcher("/view/index.jsp").forward(req, resp);
    }
}
