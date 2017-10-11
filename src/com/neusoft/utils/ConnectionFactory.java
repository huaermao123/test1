package com.neusoft.utils;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ��ȡ���ݿ�����
 * ���ӳ�
 * */
public final class ConnectionFactory {
	//ʹ�õ���ģʽ�������ݿ����ӳ�
    private static ConnectionFactory instance;
    private static ComboPooledDataSource dataSource;
    
   
    static private Properties ps = new Properties();
	static
	{
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties");
		try {
			ps.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    private ConnectionFactory() throws SQLException, PropertyVetoException {
        dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(ps.getProperty("driver"));//��������
        dataSource.setJdbcUrl(ps.getProperty("url"));//���ݿ��ַ
        dataSource.setUser(ps.getProperty("user"));		//�û���
        dataSource.setPassword(ps.getProperty("password")); //����
        dataSource.setInitialPoolSize(5); //��ʼ��������
        dataSource.setMinPoolSize(1);//��С������
        dataSource.setMaxPoolSize(10);//���������
        dataSource.setMaxStatements(50);//��ȴ�ʱ��
        dataSource.setMaxIdleTime(60);//������ʱ�䣬��λ����
    }
    //��ȡʵ��

    public static final ConnectionFactory getInstance() {
        if (instance == null) {
            try {
                instance = new ConnectionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
    //��ȡ����
    public synchronized final Connection getConnection() {
        Connection conn = null;
        try {
        	
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

	public static void beginTransaction(Connection conn) {
		// TODO Auto-generated method stub
		
	}

	public static void commitTransaction(Connection conn) {
		// TODO Auto-generated method stub
		
	}

	public static void rollbackTransaction(Connection conn) {
		// TODO Auto-generated method stub
		
	}

	public static void resetConnection(Connection conn) {
		// TODO Auto-generated method stub
		
	}
}