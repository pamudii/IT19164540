package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap; 
import java.util.Map; 
import java.util.Scanner;


@WebServlet("/ResearchAPI")
public class ResearchAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Research researchObj = new Research();
    
    public ResearchAPI() {
    
    }

	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String output = researchObj.insertResearch(request.getParameter("researchName"), 
				 request.getParameter("researchField"), 
				request.getParameter("fundTotal"), 
				request.getParameter("completeStatus")); 
				response.getWriter().write(output);
		//doGet(request, response);
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map paras = getParasMap(request); 
		 String output = researchObj.updateResearch(paras.get("hidResearchIDSave").toString(), 
		 paras.get("researchName").toString(), 
		 paras.get("researchField").toString(), 
		paras.get("fundTotal").toString(), 
		paras.get("completeStatus").toString()); 
		response.getWriter().write(output);
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map paras = getParasMap(request); 
		 String output = researchObj.deleteResearch(paras.get("researchID").toString()); 
		response.getWriter().write(output);
	}
	
	// Convert request parameters to a Map
	private static Map getParasMap(HttpServletRequest request) 
	{ 
	 Map<String, String> map = new HashMap<String, String>(); 
	 	try
	 	{ 
		Scanner scanner = new Scanner(request.getInputStream(), "UTF-8"); 
		String queryString = scanner.hasNext() ? 
				scanner.useDelimiter("\\A").next() : ""; 
				scanner.close(); 
				String[] params = queryString.split("&"); 
				for (String param : params) 
				{ 
					String[] p = param.split("=");
					map.put(p[0], p[1]); 
				} 
		 } 
		catch (Exception e) 
		 { 
		 } 
		return map; 
	 }
	

}
