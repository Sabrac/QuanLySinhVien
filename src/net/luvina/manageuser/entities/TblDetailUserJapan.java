/**
 * Copyright(C) 2014 Luvina
 *
 * TblDetailUserJapan.java, Jun 25, 2014 LA-PM
 *
 */
package net.luvina.manageuser.entities;

import java.io.Serializable;
import java.util.Date;

/**
 * TblDetailUserJapan
 * @author LA-PM
 *
 */
public class TblDetailUserJapan implements Serializable {
	int ID;
	int userID;
	String code;
	String name;
	Date start_date;
	Date end_date;
	int total;

	/**
	 * Constructor
	 * @param ID int detail_user_japan_id
	 * @param userID int user_id
	 * @param code String code_level
	 * @param start_date Date start_date
	 * @param end_date Date end_date
	 * @param total int total
	 */
	public TblDetailUserJapan (int ID, int userID, String code, Date start_date, Date end_date, int total) {
		this.ID = ID;
		this.userID = userID;
		this.code = code;
		this.start_date = start_date;
		this.end_date = end_date;
		this.total = total;
	}

	/**
	 * Constructor không tham số
	 */
	public TblDetailUserJapan() {
		this.ID = -1;
		this.userID = -1;
		this.code = "";
		this.name = "";
		this.start_date = null;
		this.end_date = start_date;
		this.total = -1;
	}

	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}
	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the start_date
	 */
	public Date getStart_date() {
		return start_date;
	}
	/**
	 * @param startDate the start_date to set
	 */
	public void setStart_date(Date startDate) {
		start_date = startDate;
	}
	/**
	 * @return the end_date
	 */
	public Date getEnd_date() {
		return end_date;
	}
	/**
	 * @param endDate the end_date to set
	 */
	public void setEnd_date(Date endDate) {
		end_date = endDate;
	}
	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
