package util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Util {
    public static void forward(String jsp, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //request.getRequestDispatcher("WEB-INF/jsp/" + jsp).forward(request, response);
        request.getRequestDispatcher(jsp).forward(request, response);
    }

    public static boolean isLoggedIn(HttpSession session) {
        return session != null
                && session.getAttribute("idPersonne") != null;
    }

    public static Integer getLoggedId(HttpServletRequest request) {
        return (Integer) request.getSession().getAttribute("idPersonne");
    }
}
