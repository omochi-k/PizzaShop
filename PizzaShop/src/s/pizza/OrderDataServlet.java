package s.pizza;

import java.io.IOException;
import java.util.*;
import java.net.URL;

import javax.jdo.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import s.pizza.OrderData;
import s.pizza.PMF;

public class OrderDataServlet extends HttpServlet {
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
	        String title = req.getParameter("title");
	        String url = req.getParameter("url");
	        String comment = req.getParameter("comment");
	        Date date = Calendar.getInstance().getTime();
	        OrderData data = new OrderData(title,url,comment,date);
	        PersistenceManagerFactory factory = PMF.get();
	        PersistenceManager manager = factory.getPersistenceManager();
	        try {
	            manager.makePersistent(data);
	        } finally {
	            manager.close();
	        }
	        resp.sendRedirect("/index.html");
	    }
}
