package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.TikuBean;
import daoservice.TikuService;
import dbutil.DBUtil;

public class TikuDao implements TikuService{

	@SuppressWarnings("unused")
	@Override
	public List<TikuBean> listTiMuByLevel(String level) {
		// TODO Auto-generated method stub
		//��ѯlevel�ȼ���������Ŀ
		//�������ݿ�
		List<TikuBean> timuList= new ArrayList<TikuBean>();
		Connection conn=DBUtil.getConnection();
		StringBuilder sql=new StringBuilder();
		sql.append("select * from tikutable where level=?");//level,fenzhi,tigan,xx1,xx2,xx3,xx4,answer
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql.toString());
			ptmt.setString(1, level);//�������ʽ������һ��Ҫ��������ý���
			ResultSet rs=ptmt.executeQuery();
			TikuBean timu=null;
			while(rs.next()){
				timu=new TikuBean();
				timu.setTiLevel(rs.getString("level"));
				timu.setFenZhi(rs.getInt("fenzhi"));
				timu.setTiGan(rs.getString("tigan"));
				timu.setXx1(rs.getString("xx1"));
				timu.setXx2(rs.getString("xx2"));
				timu.setXx3(rs.getString("xx3"));
				timu.setXx4(rs.getString("xx4"));
				timu.setAnswer(rs.getString("answer"));
				timuList.add(timu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return timuList;
	}
	
}
