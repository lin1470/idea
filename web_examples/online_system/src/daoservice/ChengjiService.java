package daoservice;

import java.util.List;

import bean.ChengjiBean;

public interface ChengjiService {
	public boolean addChengji(ChengjiBean params);//������߳ɼ�
	public List<ChengjiBean> queryChengjiByUsername(String username);//��ѯ��ǰ�û����гɼ�
}
