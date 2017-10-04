package servers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserBean;

/**
 * Servlet implementation class GaiJuanServer
 */
@WebServlet("/GaiJuanServer")
public class GaiJuanServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GaiJuanServer() {
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
		//���ڸľ����ʾ�ɼ�
		int tihao=1;
		String stishu=request.getSession().getAttribute("tishu").toString();
		int tishu=Integer.parseInt(stishu);//��ȡ����
		@SuppressWarnings("unchecked")
		ArrayList<String> ckanswer=(ArrayList<String>) request.getSession().getAttribute("answer");
		Iterator<String> it = ckanswer.iterator();//��ȡ��׼������
		int[] fenzhi=(int[])request.getSession().getAttribute("fenzhi");//��ȡÿ����ķ�ֵ
		String uanswer[]=new String[tishu];//��ȡ�û���д�Ĵ�
        int score=0;	
		response.setContentType("text/html;charset=GBK");//������������������
		PrintWriter out=response.getWriter();		
		for (int i = 0; i < tishu; i++) {
			if(request.getParameter("di"+tihao+"ti")!=null){
			uanswer[i]=request.getParameter("di"+tihao+"ti").toString();
			//System.out.println(answer[i]);
			//System.out.println(ckanswer.get(i));
//			while(it.hasNext())
//				System.out.println(it.next());
			if(uanswer[i].equals(it.next())){
				score+=fenzhi[i];
			}
			}
		tihao++;
		}
//		out.print("<body >");
//		out.print("<div style='border:1px dashed red; padding:60px 0; margin:30px;text-align: center'>");
//		out.println("<div><h3>�����ο��Եĳɼ�Ϊ��"+"<span style='color:red'>"+score+"</span>"+"��</h3></div>");
//		out.print("</div>");
//		out.print("<a style='margin-left: 700px' href='xinxi.jsp'>����</a>");
//		out.print("&nbsp;&nbsp;&nbsp;&nbsp;<a  href='login.jsp'>ע��</a>");
//		out.print("</body>");
		request.setAttribute("score", score);
		RequestDispatcher dispatcher=request.getRequestDispatcher("chengji.jsp");
		dispatcher.forward(request, response);
	}

}
