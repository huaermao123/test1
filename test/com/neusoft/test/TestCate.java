package com.neusoft.test;

import java.util.List;

import com.neusoft.dao.CateDao;
import com.neusoft.dao.DaoFactory;
import com.neusoft.dao.impl.CateDaoImpl;
import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;

public class TestCate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//add();
		//getAll();
		//getxy();
		//deltel();
		xiugai();
		//del();
	}
	/*
	  * �����Ϣ
	  * */
  public static void add() {
		 
		    Cate cc=new Cate("Ʒ66",80);
			  int c =  new CateDaoImpl().insert(cc);
		
		   System.out.println(c);
   }
  //ɾ��ͨ��cidɾ��
  public static void del() {
	  
	  int c =  new CateDaoImpl().deleteCate(94,64);
		
		 System.out.println(c);
  }
  
  //�޸�
  public static void xiugai() {
	  Cate pid=new Cate(179,"fʱ��3");
	  int c =  new CateDaoImpl().updateCate(pid);

		 System.out.println(c);
  }
  
  //��ѯ
  public static  void getAll() {
	  CateDao cateDao=DaoFactory.getInstance("cateDao", CateDao.class);
	  List<Cate> dd= cateDao.getCateList();
	  System.out.println(dd);
  }
  
  //��ѯ��ҳ
  public static void  getxy() {
	 PageModel<Cate> cd= new CateDaoImpl().getCatesByPage(1,3);
	 System.out.println(cd);
  }
  //ɾ��
  public static void deltel() {
	Integer  vv=new CateDaoImpl().delRegion(214);
	System.out.println(vv);
  }  
   
  
}
