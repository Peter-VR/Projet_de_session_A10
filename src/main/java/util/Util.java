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

    public static void redirectToReferrer(HttpServletRequest request, HttpServletResponse response, String defaultUrl) throws IOException {
        var referer = request.getHeader("referer");
        if (referer == null || referer.isEmpty())
            referer = defaultUrl;
        response.sendRedirect(referer);
    }

    public static boolean isLoggedIn(HttpSession session) {
        return session != null
                && session.getAttribute("idPersonne") != null;
    }

    public static boolean isLoggedIn(HttpServletRequest request) {
        return request != null
                && isLoggedIn(request.getSession());
    }

    public static Integer getLoggedId(HttpServletRequest request) {
        return (Integer) request.getSession().getAttribute("idPersonne");
    }

    public static Integer tryParse(String n) {
        try {
            return Integer.parseInt(n);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
