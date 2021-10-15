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
        request.setAttribute("list", MessageDao.find());
        request.setAttribute("list", MessageDao.findFrom(3));
        //request.setAttribute("list", MessageDao.findFrom(Util.getLoggedId(request)));
        Util.forward("MessageList.jsp", request, response);
        /*
        switch (request.getParameter("mode")) {
            case "auth":
                if ("secret".equals(request.getParameter("pass"))) {
                    request.getRequestDispatcher("find.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("wrongPass.jsp").forward(request, response);
                }
                break;

            case "find":
                TrainingDao dao = new TrainingDao();
                ArrayList<Training> list = dao.find(request.getParameter("lang"));
                request.setAttribute("list", list);
                request.getRequestDispatcher("findResult.jsp").forward(request, response);
                break;
        }
        */
    }
}
