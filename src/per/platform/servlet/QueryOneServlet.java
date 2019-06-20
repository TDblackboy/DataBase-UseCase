package per.platform.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import per.modal.Platform;
import per.platform.dao.MysqlDao;
import per.platform.dao.PlatformDao;

/**
 * Servlet implementation class QueryOneServlet
 */
@WebServlet("/QueryOneServlet")
public class QueryOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("utf-8");
		//处理request请求
		String pname=request.getParameter("pname");
		if(pname!=null) {
			Platform condition=new Platform();
			condition.setPname(pname);
			//数据库检索
			PlatformDao platDao=new MysqlDao();
			Platform plat=platDao.loadOne(condition);
			//将检索数据存在session中使jsp可用
			if(plat!=null) {
				request.getSession().setAttribute("plat",plat);
			}else {
				System.out.println("查找失败");
			}
		}else {
			System.out.println("pname值："+pname);
		}
		//返回
		response.sendRedirect("../pages/information.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
