package com.worm.core.db;

import javax.servlet.ServletContext;

import org.hibernate.SessionFactory;

import com.worm.common.constants.CoreConstants;

public class DbHelper {

	public static SessionFactory getSessionFactory(ServletContext sc) {
		DbConnectionManager dbManager = (DbConnectionManager) sc.getAttribute(CoreConstants.DB_MANAGER_CONTEXT);
		return dbManager.getSessionFactory();
	}

}
