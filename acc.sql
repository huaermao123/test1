

    private int id;//主键
	private String username;//账号名
	private String password;//密码
	private String ip;//客户端Ip
	private long date;//最近登录时间
	
	
	create database  bussiness;
	use bussiness;
	create table if not exists account(
	  id         int          primary key auto_increment,
	  username   varchar(20)   not null,
	  password   varchar(20)   not null,
	  ip         varchar(20)   not null,
	  logindate  bigint   
	);
	
	insert into account(username,password,ip,logindate) values("admin","admin","127.0.0.1",now());
	
	

 create database bussiness;
 
 use bussiness;
 -- 商品表
 create table product(
 id    int     primary key   auto_increment,
 pname varchar(20)  not null,
 cid   int,-- 外键，引用cate表中的cid
 pno    varchar(30),-- 货号
 pic    varchar(100),-- 商品图片
 price  double ,-- 商品价格
 online  int ,  -- 1: 上线 0：下线
 pdetail text   -- 商品详情
 ); 
 -- 类别表
 create table Cate(
 cid     int       primary key auto_increment,
 cname  varchar(20)  not null,
 pid   int
 );
 insert into Cate(cid,cname,pid)value(1,'水果',0);
  insert into Cate(cid,cname,pid)value(2,'蔬菜',0);
   insert into Cate(cid,cname,pid)value(3,'白菜',2);
   insert into Cate(cid,cname,pid)value(4,'黄瓜',2);
  insert into Cate(cid,cname,pid)value(5,'苹果',1);
  insert into Cate(cid,cname,pid)value(6,'香蕉',1);
-- 规格表
create table rule(
id      int      primary key auto_increment,
pid     int,-- 商品id,引用商品表的id
size   varchar(20)   -- 尺寸
);	
-- 会员表
-- 买家账号信息
create table account_consumer(
id  int   primary key auto_increment,
loginname varchar(50) not null,
password varchar(50),
registertime bigint,-- 注册时间
lastlogintime bigint,-- 最后登录时间
ip         varchar(20)-- ip地址
);	
-- 买家购买信息
create table  shoppinginfo_consumer(

id       int      primary  key auto_increment,
aid      int   ,-- 买家账号id,依赖acount_consumer表中的id
nickname  varchar(20),-- 用户昵称
money  double,-- 订单金额
lasttime bigint  -- 最近消费
);	
	
-- 卖家
  -- 卖家账号信息
  create table account_product(
  id    int     primary  key auto_increment,
  loginname  varchar(50)  not null,
  password  varchar(50),  
  registertime  bigint,  -- 注册时间
  lastlogintime  bigint,-- 最后登录时间
  ip   varchar(20)-- ip地址
  );	
	
 -- 地址表，供客户选择
 create  table  address(
  id  int primary key auto_increment,
  province varchar(20)  not null,-- 省份
  city varchar(40)  not null,-- 城市
  area varchar(40)  not null-- 区/县
 
 
 );	
	
	
	-- 买家收货信息表
	create table consumer_addr(
	id    int     primary key auto_increment,
	name varchar(20) not null,-- 收货人姓名
	addr varchar(200) not null,-- 收货人地址
	phone varchar(20)  not null,-- 联系方式
	provice varchar(20),  -- 省份
	city varchar(20),-- 市
	area varchar(40),-- 区/县
	adder varchar(200)-- 详细信息
	);
	
	-- 订单表
	create table orderinfo(
	id    int    primary key   auto_increment,-- 订单id
	orderno  varchar(50)   not null,-- 订单编号
	orderstatus  int,  -- 订单状态 1:未付款2:已付款3:已发货 4:已完成
	paystatus   int, -- 1:在线支付 2:货到付款
	ordertime  bigint, -- 下单时间
	paytime  bigint,-- 付款时间
	addrinfo  int,-- 收件人信息,引用自cosumer_addr表中的id
	mask  varchar(200)-- 备注信息
	);
	-- 多对多关系，订单和商品
	create table product_orderinfo(
	orderid     int  ,-- 订单id值引用自orderinfo表中的id
	productid   int ,-- 商品id,值引用,值引用product表中的id
   primary  key(orderid,productid)-- 联合主键
	);
	
	
	