package com.tuana9a.learnjavahibernate.servlets;

import com.tuana9a.learnjavahibernate.daos.BookDao;
import com.tuana9a.learnjavahibernate.models.ResponseEntity;
import com.tuana9a.learnjavahibernate.utils.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/books/name")
public class BooksNameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        resp.setContentType("application/json; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        Object result = BookDao.getInstance().findByName(name);
        writer.print(JsonUtils.getInstance().toJson(ResponseEntity.builder()
                .code(1)
                .message("success")
                .data(result)
                .build()));
    }

}
