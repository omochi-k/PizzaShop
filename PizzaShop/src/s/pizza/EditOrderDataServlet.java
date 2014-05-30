package s.pizza;

import java.io.IOException;
import java.util.*;
 
import javax.jdo.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
 
public class EditOrderDataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("no url...");
    }
 
    @Override
    protected void doPost(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        long id = Long.parseLong(req.getParameter("id"));
        String order = req.getParameter("title");
        String url = req.getParameter("url");
        String comment = req.getParameter("comment");
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        OrderData data = (OrderData)manager.getObjectById(OrderData.class,id);
        data.setOrder(order);
        data.setUrl(url);
        data.setComment(comment);
        manager.close();
        resp.sendRedirect("/index.html");
    }
}

