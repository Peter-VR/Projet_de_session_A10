/*
 * Created by: Evgenii
 * Project: A11
 * */

package Servlets;

import dao.MessageDao;
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
                var id = Util.tryParse(request.getParameter("id"));
                MessageDao.delete(id);
                Util.redirectToReferrer(request, response, "MessageServlet?mode=search");
                return;

            case "compose":
                request.setAttribute("from", Util.getLoggedId(request));
                Util.forward("MessageCompose.jsp", request, response);
                return;

            case "composeSubmit":
                request.setAttribute("list", MessageDao.findFrom(Util.getLoggedId(request)));
                Util.forward("MessageList.jsp", request, response);
                return;
        }
    }
}
