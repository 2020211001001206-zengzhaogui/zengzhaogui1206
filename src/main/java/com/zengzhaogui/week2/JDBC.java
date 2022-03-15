package com.zengzhaogui.week2;
import java.sql.*;
class JDBC {
    public static Connection dbConn;
    public void test() {
        String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=Member_Activity_Manadement";
        //这里是写你的数据库名字。上面是新建立了Test，所以填Test
        String userName="ZZG";//这里是写你的登陆数据库的名，安装完默认是sa
        String userPwd="ZZG123456789";//这里是写你的登陆数据库的密码，我设定的比较简单
        try{
            Class.forName(driverName);
            System.out.println("加载驱动成功！");
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("加载驱动失败！");
        }
        try{
            dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
            System.out.println("连接数据库成功！");
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.print("SQL Server连接失败！");
        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new JDBC().test();



    }

}


