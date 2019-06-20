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
import per.utils.Pack;

/**
 * Servlet implementation class LoadTermsServlet
 */
@WebServlet("/LoadTermsServlet")
public class QueryConditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryConditionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Platform> lists=null;
		//设置编码
		request.setCharacterEncoding("utf-8");
		//接受jsp请求数据
		Platform plat=Pack.packCondition(request);
		//数据库添加数据
		PlatformDao platDao=new MysqlDao();
		lists=platDao.loadCondition(plat);
		//Session设置数据
		if(lists!=null) {
			request.getSession().setAttribute("plats", lists);
		}else {
			System.out.println("查找失败："+lists);
		}
		//返回
		response.sendRedirect("../pages/query-condition.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
