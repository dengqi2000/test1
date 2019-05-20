package com.sht.demo;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestBigData {

    /**
     * @param args
     * @throws Exception
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static void main(String[] args) throws Exception {
        //--------------------------------连接数据库----------------------
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC";
        String user="root";
        String password="123456";

        //1、新建驱动
        Driver driverInstance = (Driver) Class.forName(driver).newInstance();
        //2、注册驱动
        DriverManager.registerDriver(driverInstance);
        //3、获取连接
        Connection conn = DriverManager.getConnection(url, user, password);

        //----------------------对数据库进行操作-------------------
        //记录开始时间
        Long begin=System.currentTimeMillis();
        //-----------插入数据----------
        //sql语句前缀
        String sqlPre="insert into user (id,name,password) values ";
        StringBuffer sb = new StringBuffer();
        //设置事务为非自动提交
        conn.setAutoCommit(false);
        //使用PrepareStatement更好
        PreparedStatement pstate = conn.prepareStatement("");

        //--------------------------十万条数据-------------
        //设置外循环，总提交事务的次数
        int a = 0;
        for(int i=0;i<100;i++){
            for(int j=0;j<10000;j++){
                //构建sql后缀
                //sb.append("("+j*i+",SYSDATE(),"+i*j*Math.random()+"),");
                sb.append("(").append(a).append(",").append("\'dengqi\'").append(",").append("\'sdljs\'").append(")").append(",");
            }
            //构建完整的sql
            String sql = sqlPre + sb.substring(0, sb.length()-1);
            //添加sql
            pstate.addBatch(sql);
            //执行sql
            pstate.executeBatch();
            //提交事务
            conn.commit();
            //清空StringBuffer上一次添加的sql语句
            sb = new StringBuffer();
        }
        //大循环完毕，关闭连接
        pstate.close();
        conn.close();
        //结束时间
        Long end = System.currentTimeMillis();
        System.out.println("100万条数据，插入数据库耗时："+(end-begin)+"ms");
    }

}