/**
 * Copyright(C) 2014 Luvina
 *
 * MstJapan.java, Jun 25, 2014 LA-PM
 *
 */
package net.luvina.manageuser.entities;

import java.io.Serializable;

/**
 * MstJapan
 * @author LA-PM
 *
 */
public class MstJapan implements Serializable {
	private String code;
	private String name;
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

	/**
	 * Constructor
	 * @param code String code_level
	 * @param name String name_level
	 */
	public MstJapan(String code, String name) {
		this.code = code;
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		if (o instanceof MstJapan) {
			if (code.equals(((MstJapan)o).code) &&
					name.equals(((MstJapan)o).name)) {
				return true;
			}
		}

		return false;
	}
}
