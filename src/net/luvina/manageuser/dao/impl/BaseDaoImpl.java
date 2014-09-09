/**
 * Copyright(C) 2014 Luvina
 *
 * ListUserController.java, Jun 25, 2014 LA-PM
 *
 */
package net.luvina.manageuser.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.luvina.manageuser.dao.BaseDao;
import net.luvina.manageuser.utils.DatabaseProperties;


/**
 * Xử lý kết nối db
 * @author LA-PM
 *
 */
public class BaseDaoImpl implements BaseDao{
    protected Connection connection = null;
    protected PreparedStatement preparedStatement = null;
    protected ResultSet rs = null;


    /* (non-Javadoc)
     * @see manageuser.dao.BaseDao#connectToDB()
     */
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
     * @see manageuser.dao.BaseDao#closeConnect()
     */
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
