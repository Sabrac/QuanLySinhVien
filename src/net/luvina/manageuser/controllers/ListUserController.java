/**
 * Copyright(C) 2014 Luvina
 *
 * ListUserController.java, Jun 25, 2014 LA-PM
 *
 */
package net.luvina.manageuser.controllers;

import java.io.IOException;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.EscapeTokenizer;

import sun.io.CharacterEncoding;

import net.luvina.manageuser.entities.MstGroup;
import net.luvina.manageuser.entities.TblUser;
import net.luvina.manageuser.entities.UserInfor;
import net.luvina.manageuser.logics.impl.MstGroupLogicImpl;
import net.luvina.manageuser.logics.impl.TblUserLogicImpl;
import net.luvina.manageuser.logics.impl.UserLogicImpl;
import net.luvina.manageuser.utils.Common;
import net.luvina.manageuser.utils.Constant;
import net.luvina.manageuser.utils.MessageErrorProperties;
import net.luvina.manageuser.utils.MessageProperties;

/**
 * Controller ListUser
 * @author LA-PM
 *
 */
public class ListUserController extends javax.servlet.http.HttpServlet implements
        javax.servlet.Servlet {
    static final long serialVersionUID = 1L;

    /*
     * (non-Java-doc)
     *
     * @see javax.servlet.http.HttpServlet#HttpServlet()
     */
    public ListUserController() {
        super();
    }

    /*
     * (non-Java-doc)
     *
     * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request,
     * HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /*
     * (non-Java-doc)
     *
     * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
     * HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	TblUserLogicImpl userLogic = new TblUserLogicImpl();
    	MstGroupLogicImpl groupLogic = new MstGroupLogicImpl();
    	HttpSession session = request.getSession();
    	String template = "";
    	int groupId = 0;
    	int page = 0;
    	String fullNameSearch = "";
    	String sortType = "";
    	String sortByFullName = "";
    	String sortByCodeLevel = "";
    	String sortByEndDate = "";
    	String message = "";
    	List<MstGroup> lsGroup = null;
    	List<UserInfor> lsUser = null;
    	List<Integer> lsPage = null;
    	int range = 3;
    	session.removeAttribute("userInfor");

    	if (!"".equals(Common.checkLogin(session))) { //TODO bug 3
            template = Common.checkLogin(session);
            RequestDispatcher req = request.getRequestDispatcher(template);
            req.forward(request, response);
        } else {
        	//begin get param
        	if (request.getParameter("top") != null) {
        		if ("true".equals(request.getParameter("top"))) {
        			session.removeAttribute("group_id");
        			session.removeAttribute("full_name");
        		}
        	}

            if(request.getParameter("full_name") != null) {
            	fullNameSearch = request.getParameter("full_name").toString();
            	session.setAttribute("full_name", fullNameSearch);
            } else if (session.getAttribute("full_name") != null) {
            	fullNameSearch = session.getAttribute("full_name").toString();
            	session.setAttribute("full_name", fullNameSearch);
            }

            if(request.getParameter("group_id") != null) {
            	groupId = Integer.parseInt(request.getParameter("group_id").toString());
            	session.setAttribute("group_id", groupId);
            } else if (session.getAttribute("group_id") != null) {
            	groupId = Integer.parseInt(session.getAttribute("group_id").toString());
            	session.setAttribute("group_id", groupId);
            }

            if(request.getParameter("sortType") != null) {
            	sortType = request.getParameter("sortType").toString();
            	request.setAttribute("sortType", sortType);
            }

            if(request.getParameter("sortByFullName") != null) {
            	sortByFullName = request.getParameter("sortByFullName").toString();
            	request.setAttribute("sortByFullName", sortByFullName);
            }

            if(request.getParameter("sortByCodeLevel") != null) {
            	sortByCodeLevel = request.getParameter("sortByCodeLevel").toString();
            	request.setAttribute("sortByCodeLevel", sortByCodeLevel);
            }

            if(request.getParameter("sortByEndDate") != null) {
            	sortByEndDate = request.getParameter("sortByEndDate").toString();
            	request.setAttribute("sortByEndDate", sortByEndDate);
            }
            //end get param

	    	//xử lý paging
	    	int totalRecords = 0;
			totalRecords = userLogic.getTotalRecordṣ(groupId, Common.escapeInjection(fullNameSearch));
	        int limit = Integer.parseInt(MessageProperties.getMessage("limit"));

	        if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }

	        if (page == 0) {
	            page = 1;
	        }

	        lsPage = Common.getListPaging(totalRecords, limit, page);

	        int totalPage = Common.getTotalPage(totalRecords, limit);

	        request.setAttribute("page", page);
	        request.setAttribute("lsPage", lsPage);
	        request.setAttribute("range", range);
	        request.setAttribute("totalPage", totalPage);

	        int offset = (page > 0) ? limit * ((int) page - 1) : 0;

	        lsUser = userLogic.getListUsers(offset, limit, groupId, Common.escapeInjection(fullNameSearch),
	        		sortType, sortByFullName, sortByCodeLevel, sortByEndDate);
	        lsGroup = groupLogic.getAllGroups();

	        if(lsUser.size() <= 0) {
	        	message = MessageProperties.getMessage("msg_005");
	        }

	        request.setAttribute("listUser", lsUser);
	        request.setAttribute("message", message);
	        request.setAttribute("lsGroup", lsGroup);
	        template = Constant.ADM002;

	        RequestDispatcher req = request.getRequestDispatcher(template);
	        req.forward(request, response);
        }
    }
}