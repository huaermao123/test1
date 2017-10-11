package com.neusoft.entity;

public class Product {

/*	id    int     primary key   auto_increment,
	 pname varchar(20)  not null,
	 cid   int,-- ���������cate���е�cid
	 pno    varchar(30),-- ����
	 pic    varchar(100),-- ��ƷͼƬ
	 price  double ,-- ��Ʒ�۸�
	 online  int ,  -- 1: ���� 0������
	 pdetail text   -- ��Ʒ����
	 *
	 **/
	
	private int id;//
	private int cid;//���������cate���е�cid
	private String pno;//����
	private String pic;//��ƷͼƬ
	private double price;//��Ʒ�۸�
	private  int online;//1: ���� 0������
	private  String  pdetail;//��Ʒ����
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic){
		this.pic = pic;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getOnline() {
		return online;
	}
	public void setOnline(int online) {
		this.online = online;
	}
	public String getPdetail() {
		return pdetail;
	}
	public void setPdetail(String pdetail) {
		this.pdetail = pdetail;
	}
	public Product(int cid, String pno, String pic, double price, int online, String pdetail) {
		super();
		this.cid = cid;
		this.pno = pno;
		this.pic = pic;
		this.price = price;
		this.online = online;
		this.pdetail = pdetail;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", cid=" + cid + ", pno=" + pno + ", pic=" + pic + ", price=" + price + ", online="
				+ online + ", pdetail=" + pdetail + "]";
	}
	
	
	
}
