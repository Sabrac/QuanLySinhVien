/**
 * Copyright(C) 2014 Luvina
 *
 * ListUserController.java, Jun 25, 2014 LA-PM
 *
 */
package net.luvina.manageuser.dao;

/**
 * @author LA-PM
 *
 */
public interface BaseDao {


    /**
     * connectToDB
     *
     * @return true: connectToDB success
     *  false: connectToDB unsuccess
     */
    public boolean connectToDB();

    /**
     * closeConnect
     */
    public void closeConnect();

}
