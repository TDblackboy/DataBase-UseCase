package per.platform.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import per.modal.Platform;
import per.platform.dao.MysqlDao;
import per.platform.dao.PlatformDao;

/**
 * Servlet implementation class LoadAllServlet
 */
@WebServlet("/LoadAllServlet")
public class QueryAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<Platform> lists=null;
		//数据库检索
		PlatformDao platDao=new MysqlDao();
		lists=platDao.loadAll();
		//将检索数据存在session中使jsp可用
		if(lists!=null) {
			request.getSession().setAttribute("plats",lists);
		}else {
			System.out.println("查找失败："+lists);
		}
		//返回
		response.sendRedirect("../pages/query-all.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
