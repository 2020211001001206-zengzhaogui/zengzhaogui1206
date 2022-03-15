package com.zengzhaogui.week2;
import java.io.PrintWriter;
import java.sql.*;
class JDBC {
    public static Connection dbConn;
    public void test() {
        String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=userdbtest";
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
//        String username="17364000924";
//        String password="1";
//
//        String email="33";
//        String male="66";
//        String birthdate="1908-2-17";
//        int id=10;
//        try{
//            System.out.println("1");
//            Statement stmt= dbConn.createStatement();
//            System.out.println("2");
//            String sqll="insert into Usertable(id,username,password,email,gender,birthdate) values ("+id+",'"+username+"','"+
//                    password+"','"+email+"','"+male+"','"+birthdate+"');";
//            System.out.println(sqll);
//
//            int count=stmt.executeUpdate(sqll);
//            System.out.println("4");
//            if(count>0){
//                System.out.println("successful");
//                id++;
//            }else{
//                System.out.println("yinyinyin");
//            }
//        }catch(Exception e){
//            System.out.println("出错了");
//
//        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new JDBC().test();



    }

}


