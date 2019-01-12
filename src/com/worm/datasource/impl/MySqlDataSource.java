package com.worm.datasource.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import com.worm.common.constants.CoreConstants;
import com.worm.datasource.interfaces.IDataSource;

public class MySqlDataSource implements IDataSource {

	@Override
	public DataSource getDataSource() {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public DataSource getDataSource() {
		Properties props = new Properties();
		FileInputStream fis = null;
		BasicDataSource ds = new BasicDataSource();
		
		
		try {
			fis = new  FileInputStream(ConfigConstants.DB_PROPERTIES_FILE_PATH);
			props.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		ds.setDriverClassName(props.getProperty(ConfigConstants.MYSQL_DRIVER));
		ds.setUrl(props.getProperty(ConfigConstants.MYSQL_DB_URL));
		ds.setUsername(props.getProperty(ConfigConstants.MYSQL_DB_USERNAME));
		ds.setPassword(props.getProperty(ConfigConstants.MYSQL_DB_PASSWORD));
		return ds;
	}*/

}
