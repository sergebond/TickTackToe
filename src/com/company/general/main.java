package com.company.general;

import java.sql.SQLException;

import com.company.dao.GamerDao;
import com.company.tables.Gamer;

public class main {

	public static void main(String[] args) throws SQLException {
		Factory factory = Factory.getInstance();
		GamerDao gamerDao = factory.GetGamerDao();
		
		gamerDao.addGamer(new Gamer("Login", "password"));
	}

}
