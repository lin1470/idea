package daoservice;

import java.util.List;
import java.util.Map;

import bean.UserBean;

public interface UserService {
	public boolean addPerson(UserBean params);//�����û�
    public boolean deletePersonByID(String params);//ɾ���û�
    public boolean updatePerson(UserBean params);//�޸��û���Ϣ
    public UserBean queryPersonById(String selectionArgs);//��ѯ������¼
    public List<UserBean> listPersonMaps();//��ѯ���м�¼
}
