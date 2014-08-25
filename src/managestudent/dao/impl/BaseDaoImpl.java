/**
 * Copyright(C) K16SE 2014
 *
 * BaseDaoImpl.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import managestudent.utils.DatabaseProperties;
import managestudent.dao.BaseDao;

/**
 *
 * @author HaVH
 *
 */
public class BaseDaoImpl implements BaseDao {
	protected Connection connection = null;
    protected PreparedStatement preparedStatement = null;
    protected ResultSet rs = null;

	/* (non-Javadoc)
	 * @see managestudent.dao.BaseDao#connectToDB()
	 */
	@Override
	public boolean connectToDB() {
		boolean result = true;

        try {
			// load mysql driver
			Class.forName(DatabaseProperties.getData("driver"));
			connection = DriverManager.getConnection(DatabaseProperties
					.getData("url"), DatabaseProperties.getData("user"),
					DatabaseProperties.getData("password"));
		} catch (Exception e) {
			System.out.println("an exception occur: " + e.getMessage());
			result = false;
		}
        return result;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.BaseDao#closeConnect()
	 */
	@Override
	public void closeConnect() {
		if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println("an exception occur: " + e.getMessage());
            }
            connection = null;
        }
	}

}
