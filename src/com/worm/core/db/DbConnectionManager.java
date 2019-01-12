package com.worm.core.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.worm.common.constants.CoreConstants;

public class DbConnectionManager {

	private Configuration _config;
	private SessionFactory sessionFactory;
	
	public DbConnectionManager(String configFilePath) {
		Properties props = getConfigInfo(configFilePath);
		try {
			_config = new Configuration();
			_config.setProperty(CoreConstants.HIBERNATE_DIALECT, props.getProperty((CoreConstants.HIBERNATE_DIALECT)));
			_config.setProperty(CoreConstants.HIBERNATE_CONNECTION_DRIVER_CLASS,
					props.getProperty((CoreConstants.HIBERNATE_CONNECTION_DRIVER_CLASS)));
			_config.setProperty(CoreConstants.HIBERNATE_CONNECTION_URL,
					props.getProperty((CoreConstants.HIBERNATE_CONNECTION_URL)));
			_config.setProperty(CoreConstants.HIBERNATE_CONNECTION_USERNAME,
					props.getProperty((CoreConstants.HIBERNATE_CONNECTION_USERNAME)));
			_config.setProperty(CoreConstants.HIBERNATE_CONNECTION_PASS,
					props.getProperty((CoreConstants.HIBERNATE_CONNECTION_PASS)));
		} catch (Exception e) {
			//Write log at here
		}
		
	}
	
	public SessionFactory getSessionFactory() {
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(_config.getProperties()).build();
		sessionFactory = _config.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

	private Properties getConfigInfo(String configFilePath) {
		Properties props = new Properties();
		InputStream fs = null;
		
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			fs = classLoader.getResourceAsStream(configFilePath);
			props.load(fs);
			return props;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void closeConnection() {
		sessionFactory.close();
	}
}
