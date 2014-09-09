/**
 * Copyright(C) 2014 Luvina
 *
 * MstGroup.java, Jun 25, 2014 LA-PM
 *
 */
package net.luvina.manageuser.entities;

import java.io.Serializable;

/**
 * TblGroup
 * @author LA-PM
 *
 */
public class MstGroup implements Serializable {
	private int id;
    private String name;

    /**
     * Contructor
     * @param id int ID
     * @param name String groupName
     */
    public MstGroup(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		if (o instanceof MstGroup) {
			if (id == ((MstGroup)o).id &&
					name.equals(((MstGroup)o).name)) {
				return true;
			}
		}

		return false;
	}

}
