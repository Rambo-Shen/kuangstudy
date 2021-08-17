package learning.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;






public class MysqlJDBC {
    public static void main(String[] args) {

        //customer pay order(id);
        //jdbcTransaction(1);

         
    }

    
    public static void jdbcTransaction(int id) {
        String url = "jdbc:mysql://localhost:3306/starbacks?useUnicode=true&characterEncodeing&useSSL=true";
        String username  = "root";
        String psw = "sdm944826sdm";
        String sql = "";
        int coffeeID = 0;
        int customerId = 0;
        int number = 0;
        int price1 = 0;
        int price2 = 0;
        int account1 = 0;
        int account2 = 0;
        try {
            
            Connection connection = DriverManager.getConnection(url, username, psw);
            sql = "select * from orders where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet =  preparedStatement.executeQuery();
            if(resultSet.next()){
                if(!resultSet.getString("state").equals("TBP")){
                    System.out.println("can not pay now when order state is "+resultSet.getString("state").equals("TBP")+"!");
                    return;
                }
                coffeeID = resultSet.getInt("coffee");
                number = resultSet.getInt("number");
                customerId = resultSet.getInt("customer");
            }else{
                System.out.println("no such id!");
                return;
            }
            sql = "select * from coffee where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, coffeeID);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                price1 = resultSet.getInt("price1");
                price2 = resultSet.getInt("price2");
                price1 *= number;
                price2 *= number;
                price1 += price2/100;
                price2 %= 100;
            }else{
                System.out.println("no such coffee!");
                return;
            }
            sql = "select * from customer where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,customerId);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                account1 = resultSet.getInt("account1");
                account2 = resultSet.getInt("account2");
                if(account1<price1 ||(account1 == price1 && account2 < price2)){
                    System.out.println("account has no enough to pay");
                    return;
                }else{
                    account1 -= price1;
                    account2 -= price2;
                    if(account2<0)
                    {
                        account1--;
                        account2 += 100;
                    }
                }
            }else{
                System.out.println("no such customer!");
                return;
            }
            connection.setAutoCommit(false);
            sql = "update orders set state = 'MAK' where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            if(preparedStatement.executeUpdate()>0){
                System.out.println("state turn to MAK from TBP");
            }
            sql = "update customer set account1 = ?,account2 = ? where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, account1);
            preparedStatement.setInt(2, account2);
            preparedStatement.setInt(3, customerId);
            if(preparedStatement.executeUpdate()>0){
                System.out.println("account changed");
            }
            connection.commit();
            System.out.println("committed");

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void jdbcConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
    
            e1.printStackTrace();
        }
        
        String url = "jdbc:mysql://localhost:3306/starbacks?useUnicode=true&characterEncodeing&useSSL=true";
        String username  = "root";
        String psw = "sdm944826sdm";
        String sql = "select * from orders";

        try {
            Connection connection =  DriverManager.getConnection(url, username, psw);
            Statement statement = connection.createStatement();

            ResultSet resultset = statement.executeQuery(sql);
            
            while(resultset.next()){
                //System.out.println(String.format("id = %s, customer = %s, coffee = %s, number = %s, state = %s, station = %s,create time = %s, update time = %s", resultset.getObject("id"),resultset.getObject("customer"),resultset.getObject("coffee"),resultset.getObject("number"),resultset.getObject("state"),resultset.getObject("station"),resultset.getObject("create_time"),resultset.getObject("update_time")));
            }

            //防止sql注入
            sql = "select * from orders where id=?";
            PreparedStatement preparedStatement  = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 4);
            resultset = preparedStatement.executeQuery();
            System.out.println(resultset.next());
            while(resultset.next()){
                System.out.println(String.format("id = %s, customer = %s, coffee = %s, number = %s, state = %s, station = %s,create time = %s, update time = %s", resultset.getObject("id"),resultset.getObject("customer"),resultset.getObject("coffee"),resultset.getObject("number"),resultset.getObject("state"),resultset.getObject("station"),resultset.getObject("create_time"),resultset.getObject("update_time")));
            }

            


            resultset.close();
            statement.close();
            connection.close();
            
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
