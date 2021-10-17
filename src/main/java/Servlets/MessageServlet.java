/*
 * Created by: Evgenii
 * Project: A11
 * */

package Servlets;

import dao.MessageDao;
import entities.Message;
import util.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MessageServlet", value = "/MessageServlet")
public class MessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!Util.isLoggedIn(request)) {
            Util.forward("login.jsp", request, response);
            return;
        }

        Integer fromId, toId;
        String subject, content;
        switch (request.getParameter("mode")) {
            case "inbox":
                request.setAttribute("list", MessageDao.findTo(Util.getLoggedId(request)));
                Util.forward("MessageList.jsp", request, response);
                return;

            case "sent":
                request.setAttribute("list", MessageDao.findFrom(Util.getLoggedId(request)));
                Util.forward("MessageList.jsp", request, response);
                return;

            case "delete":
                var mid = Util.tryParse(request.getParameter("id"));
                MessageDao.delete(mid);
                Util.redirectToReferrer(request, response, "MessageServlet?mode=search");
                return;

            case "compose":
                Util.forward("MessageCompose.jsp", request, response);
                return;

            case "composeSubmit":
                toId = Util.tryParse(request.getParameter("to"));
                subject = request.getParameter("subject");
                content = request.getParameter("content");
                var m = new Message(Util.getLoggedId(request), toId, subject, content);
                MessageDao.insert(m);
                response.sendRedirect("MessageServlet?mode=sent");
                return;

            case "search":
                Util.forward("MessageSearch.jsp", request, response);
                return;

            case "searchSubmit":
                fromId = Util.tryParse(request.getParameter("from"));
                toId = Util.tryParse(request.getParameter("to"));
                subject = request.getParameter("subject");
                content = request.getParameter("content");
                request.setAttribute("list", MessageDao.find(fromId, toId, subject, content));
                Util.forward("MessageList.jsp", request, response);
                return;
        }
    }
}
