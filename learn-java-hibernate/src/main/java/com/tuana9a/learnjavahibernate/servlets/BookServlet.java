package com.tuana9a.learnjavahibernate.servlets;

import com.tuana9a.learnjavahibernate.daos.BookDao;
import com.tuana9a.learnjavahibernate.models.Book;
import com.tuana9a.learnjavahibernate.models.ResponseEntity;
import com.tuana9a.learnjavahibernate.utils.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/book")
public class BookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf-8");
        PrintWriter writer = resp.getWriter();

        boolean success = false;
        BookDao dao = BookDao.getInstance();
        try {
            Book book = JsonUtils.getInstance().fromJson(req.getReader(), Book.class);
            book.setId(System.currentTimeMillis());
            dao.save(book);
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        writer.print(JsonUtils.getInstance().toJson(ResponseEntity.builder()
                .code(1)
                .data(success)
                .build()));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = JsonUtils.getInstance().fromJson(req.getReader(), Book.class);
        resp.setContentType("application/json; charset=utf-8");
        PrintWriter writer = resp.getWriter();

        BookDao dao = BookDao.getInstance();
        JsonUtils jsonUtils = JsonUtils.getInstance();

        dao.update(book);
        writer.print(jsonUtils.toJson(ResponseEntity.builder()
                .code(1)
                .message("success")
                .data(book)
                .build()));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        resp.setContentType("application/json; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        BookDao dao = BookDao.getInstance();
        JsonUtils jsonUtils = JsonUtils.getInstance();

        dao.delete(Long.parseLong(id));
        writer.print(jsonUtils.toJson(ResponseEntity.builder()
                .code(1)
                .message("success")
                .data(id)
                .build()));
    }
}
