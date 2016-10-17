package cn.bluepages.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import cn.bluepages.dao.Employeeinfo;
import cn.bluepages.dao.UserDao;

public class UserServlet extends HttpServlet {
	UserDao dao = new UserDao();//引用Dao层中的方法。
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException  {		
		String name = req.getParameter("name");
		String result = "";
		try {
			List<Employeeinfo> employeeinfos = dao.findByName(name);
			result = JSONObject.toJSONString(employeeinfos);
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.getWriter().write(result);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	

}
