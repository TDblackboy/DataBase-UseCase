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
import per.utils.Pack;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//设置编码
		request.setCharacterEncoding("utf-8");
		//接受jsp请求数据
		Platform plat=Pack.packRequest(request);
		//数据库添加数据
		PlatformDao platDao=new MysqlDao();
		boolean op=false;
		op=platDao.add(plat);
		//返回处理
		if(op) {
			response.sendRedirect("../pages/addData.jsp");
		}else {
			response.sendRedirect("../pages/error.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
