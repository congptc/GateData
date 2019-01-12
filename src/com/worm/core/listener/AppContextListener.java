package com.worm.core.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.worm.common.constants.CoreConstants;
import com.worm.core.db.DbConnectionManager;

public class AppContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		String configFilePath = (String) servletContext.getInitParameter("configFilePath");

		DbConnectionManager dbManager = new DbConnectionManager(configFilePath);
		servletContext.setAttribute("dbManager", dbManager);

		System.out.println("Database connection initialized for Application.");

	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		DbConnectionManager dbManager = (DbConnectionManager) servletContext.getAttribute(CoreConstants.DB_MANAGER_CONTEXT);
		dbManager.closeConnection();
		System.out.println("Database connection closed for Application.");
	}

}
