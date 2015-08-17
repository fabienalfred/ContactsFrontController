package contacts.services;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import contacts.dao.ContactDAO;

/**
 * Application Lifecycle Listener implementation class ApplicationListener
 *
 */
@WebListener
public class ApplicationListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent event)  { 
         // TODO Auto-generated method stub
    }

	public void contextInitialized(ServletContextEvent event)  { 
//		ServletContext application = event.getServletContext();
//		ContactDAO contactDAO = new ContactDAO();
//		application.setAttribute("contactDAO", contactDAO);
    }
	
}
