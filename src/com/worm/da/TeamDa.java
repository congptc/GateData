package com.worm.da;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TeamDa {
	
	private static SessionFactory _factory;
	
	public TeamDa(SessionFactory factory) {
		_factory = factory;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getAll() {
		Session session = _factory.openSession();
		String sql = "SELECT * FROM tetm_manager_team";		
		List<Object[]> objTeam = session.createNativeQuery(sql).list();
		return objTeam;
	}
}
