package servers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.rmi.server.Dispatcher;
import dao.UserDao;
import bean.UserBean;

/**
 * Servlet implementation class ZhuceServer
 */
@WebServlet("/ZhuceServer")
public class ZhuceServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZhuceServer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��֤�û�ע����Ϣ�Ƿ���ȷ
		RequestDispatcher dispatcher = null;//ָ����תҳ��
		String zcusername=request.getParameter("zcusername");
		String zcpassword=request.getParameter("zcpassword");
		String message;
		if(zcusername==null||zcusername==""){
			message="�û�������Ϊ�գ�";
			request.setAttribute("mes", message);
			dispatcher=request.getRequestDispatcher("tiaozhuan2.jsp");
		}else if (zcpassword==null||zcpassword=="") {
			message="���벻��Ϊ�գ�";
			request.setAttribute("mes", message);
			dispatcher=request.getRequestDispatcher("tiaozhuan2.jsp");
		}else{
		UserDao dao=new UserDao();
		if(dao.queryPersonById(zcusername)==null){//�ж��û��Ƿ��ѱ�ע��
	UserBean user=new UserBean();	
	user.setUsername(zcusername);
	user.setPassword(zcpassword);
	user.setSex(request.getParameter("sex"));
	user.setLevel(request.getParameter("level"));
	dao.addPerson(user);//���뵽���ݿ�
	request.setAttribute("mes", "ע��ɹ���");//������Ϣ
	dispatcher=request.getRequestDispatcher("tiaozhuan.jsp");
	System.out.println("chenggong!");
		}
		else {
			request.setAttribute("mes", "���û��Ѵ��ڣ�");
			dispatcher=request.getRequestDispatcher("tiaozhuan2.jsp");
			System.out.println("shibai");
		}
		}
		dispatcher.forward(request, response);
	}
}
