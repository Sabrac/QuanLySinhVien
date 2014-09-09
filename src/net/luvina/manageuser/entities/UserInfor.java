/**
 * Copyright(C) 2014 Luvina
 *
 * UserInfor.java, Jun 25, 2014 LA-PM
 *
 */
package net.luvina.manageuser.entities;

import java.io.Serializable;
import java.util.Date;

/**
 * UserInfor
 *
 * @author LA-PM
 *
 */
public class UserInfor implements Serializable{
	int ID;
	String loginName;
	int groupId;
	String fullName;
	String kanaName;
	String pass;
	String rePass;
	Date birth;
	String groupName;
	String email;
	String tel;
	String nameLevel;
	String codeLevel;
	Date startDate;
	Date endDate;
	int point;
	String pointString;

	/**
	 * Constructor
	 * @param ID int ID
	 * @param fullName String full_name
	 * @param birth Date birth_date
	 * @param groupName String group_name
	 * @param email String email
	 * @param tel String tel
	 * @param nameLevel String name_level
	 * @param endDate Date end_date
	 * @param point int total
	 */
	public UserInfor(int ID, String fullName, Date birth, String groupName,
			String email, String tel, String nameLevel, Date endDate, int point) {
		this.ID = ID;
		this.fullName = fullName;
		this.birth = birth;
		this.groupName = groupName;
		this.email = email;
		this.tel = tel;
		this.nameLevel = nameLevel;
		this.endDate = endDate;
		this.point = point;
	}

	/**
	 * Constructor
	 */
	public UserInfor() {
		this.ID = -1;
		this.loginName = "";
		this.groupId = 0;
		this.fullName = "";
		this.kanaName = "";
		this.birth = new Date();
		this.groupName = "";
		this.email = "";
		this.tel = "";
		this.nameLevel = "";
		this.startDate = new Date();
		this.endDate = new Date();
		this.point = 0;
		this.codeLevel = "";
		this.pass = "";
		this.rePass = "";
	}

	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName
	 *            the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the birth
	 */
	public Date getBirth() {
		return birth;
	}

	/**
	 * @param birth
	 *            the birth to set
	 */
	public void setBirth(Date birth) {
		this.birth = birth;
	}

	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName
	 *            the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel
	 *            the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the nameLevel
	 */
	public String getNameLevel() {
		return nameLevel;
	}

	/**
	 * @param nameLevel
	 *            the nameLevel to set
	 */
	public void setNameLevel(String nameLevel) {
		this.nameLevel = nameLevel;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the point
	 */
	public int getPoint() {
		return point;
	}

	/**
	 * @param point
	 *            the point to set
	 */
	public void setPoint(int point) {
		this.point = point;
	}

	/**
	 * @return the loginName
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * @param loginName the loginName to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * @return the groupId
	 */
	public int getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return the kanaName
	 */
	public String getKanaName() {
		return kanaName;
	}

	/**
	 * @param kanaName the kanaName to set
	 */
	public void setKanaName(String kanaName) {
		this.kanaName = kanaName;
	}
	/**
	 * @return the codeLevel
	 */
	public String getCodeLevel() {
		return codeLevel;
	}

	/**
	 * @param codeLevel the codeLevel to set
	 */
	public void setCodeLevel(String codeLevel) {
		this.codeLevel = codeLevel;
	}

	/**
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	/**
	 * @return the rePass
	 */
	public String getRePass() {
		return rePass;
	}

	/**
	 * @param rePass the rePass to set
	 */
	public void setRePass(String rePass) {
		this.rePass = rePass;
	}

	/**
	 * @return the pointString
	 */
	public String getPointString() {
		return pointString;
	}

	/**
	 * @param pointString the pointString to set
	 */
	public void setPointString(String pointString) {
		this.pointString = pointString;
	}
}
