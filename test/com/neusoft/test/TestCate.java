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
	  * 添加信息
	  * */
  public static void add() {
		 
		    Cate cc=new Cate("品66",80);
			  int c =  new CateDaoImpl().insert(cc);
		
		   System.out.println(c);
   }
  //删除通过cid删除
  public static void del() {
	  
	  int c =  new CateDaoImpl().deleteCate(94,64);
		
		 System.out.println(c);
  }
  
  //修改
  public static void xiugai() {
	  Cate pid=new Cate(179,"f时空3");
	  int c =  new CateDaoImpl().updateCate(pid);

		 System.out.println(c);
  }
  
  //查询
  public static  void getAll() {
	  CateDao cateDao=DaoFactory.getInstance("cateDao", CateDao.class);
	  List<Cate> dd= cateDao.getCateList();
	  System.out.println(dd);
  }
  
  //查询分页
  public static void  getxy() {
	 PageModel<Cate> cd= new CateDaoImpl().getCatesByPage(1,3);
	 System.out.println(cd);
  }
  //删除
  public static void deltel() {
	Integer  vv=new CateDaoImpl().delRegion(214);
	System.out.println(vv);
  }  
   
  
}
