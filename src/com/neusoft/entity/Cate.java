package com.neusoft.entity;

public class Cate {
/*
 *  cid     int       primary key auto_increment,
 *  cname  varchar(20)  not null,
 *   pid   int
 *
 *父类的pid,-- 类别表
 *
 */

	private int cid;
	private String cname;
	private int pid;
	public Cate(){
		
	}
	public Cate(int cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}

	public Cate(int cid, String cname, int pid) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "Cate [cid=" + cid + ", cname=" + cname + ", pid=" + pid + "]";
	}

	public int getCid() {
		return cid;
	}
	public Cate(int pid) {
		super();
		this.pid = pid;
	}

	public Cate(String cname, int pid) {
		super();
		this.cname = cname;
		this.pid = pid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}
	
	
}
