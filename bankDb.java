import java.sql.*;
import java.io.*;
import oracle.jdbc.*;
import oracle.sql.*;
import java.util.*;

public class JDBCselect
{
    public static void main(String[] args) 
    {
      try
	  {
         DriverManager.registerDriver
	     (new oracle.jdbc.driver.OracleDriver());
         
         System.out.println("Connecting to JDBC...");

         Connection conn = DriverManager.getConnection
	     ("jdbc:oracle:thin:@localhost:1521:xe","fedora","oracle");
	 //param1: the JDBC URL
	 //param2: the name you used to log in to the DBMS
	 //param3: the password

         System.out.println("JDBC connected.\n");

         // Create a statement
         Statement stmt = conn.createStatement();
	     
 
   

        System.out.println("Account created.\n");

        
        
        
        
        
        
	 // close the result set, the statement and connect   
	 stmt.close();
	 conn.close();
	  }
      catch(Exception e)
	  {
	      System.out.println("SQL exception: ");
	      e.printStackTrace();
	      System.exit(-1);
	  }
    }
}   
       
       
       
       
       
       
       
       
       
       
       
        stmt.execute("create table branch (b#  varchar(3),address varchar2(10), primary key (b#))");
        System.out.println("Branch created.\n");
             
        stmt.execute("create table customer(c# varchar2(5),cname  varchar2(10) unique, status  int, primary key (c#))");
        System.out.println("Customer created.\n");
        
        stmt.execute("create table account (b#  varchar2(3),l#  varchar2(4),a#  varchar2(7), c# varchar2(5), balance int check(balance >=0),primary key (b#,c#),
        foreign key (b#) references branch (b#) on delete cascade, foreign key (c#) references customer(c#) on delete cascade");
   

        System.out.println("Account created.\n");

    
   
}


Part 3.

import java.sql.*;
import java.io.*;
import oracle.jdbc.*;
import oracle.sql.*;
import java.util.*;

public class P1
{
 
    
   
    public static int getStatus(int balance) {
    if(balance == 0){
        return 0;
    }
    else if(balance <=1000){
        return 1;
    }
    else if(balance <=2000){
        return 2;   
    }
    else 
        return 3;
    }  




 

    public static String incCustomerNum(String str){
       String retVal;
       int temp = Integer.parseInt(str);
       temp ++;
       retVal = Integer.toString(temp);
       return formatCustomerNum(retVal);
    }   
    
    
    public static String formatCustomerNum(String str){
       if(str.length() == 1){
           return "0000" + str;
       }else if(str.length() == 2){
           return "000" + str;
       }
       else if(str.length() == 3){
           return "00" + str;
       }
       else if(str.length() == 4){
           return "0" + str;
       }
       else 
           return str; 
    } 
    
    
    
    
   

    public static String pickCustomerNum(ArrayList<String> str){
        
    if(str.size() == 0 || str == null)
       return formatCustomerNum("0");       
        
   
    ArrayList<Integer> intList = new ArrayList<Integer>();
    int retVal;
    
    for(int i = 0; i < str.size(); i++){
         intList.add(Integer.parseInt(str.get(i)));  
               
        
    }
    Collections.sort(intList);
    
    for(int i=0; i < intList.size(); i++){
        if(intList.get(i) != i)
            return formatCustomerNum(Integer.toString(i));
          
    } 
   
    return incCustomerNum(Integer.toString((intList.get(intList.size()-1))));    
    }    
        
    
    
    
    
    
    
    
    
    
    
    
    
     

    public static String incBranchNum(String str){
       String retVal;
       int temp = Integer.parseInt(str);
       temp ++;
       retVal = Integer.toString(temp);
       return formatBranchNum(retVal);
    }   
    
    
    
    
    
   
    public static String formatBranchNum(String str){
       if(str.length() == 1){
           return "00" + str;
       }else if(str.length() == 2){
           return "0" + str;
       }
       else 
           return str; 
    } 
    
    
    
    
    
    

    public static String pickBranchNum(ArrayList<String> str){
        
    if(str.size() == 0 || str == null)
       return formatBranchNum("0");       
        
   
    ArrayList<Integer> intList = new ArrayList<Integer>();
    int retVal;
    
    for(int i = 0; i < str.size(); i++){
         intList.add(Integer.parseInt(str.get(i)));  
               
        
    }
    Collections.sort(intList);
    
    for(int i=0; i < intList.size(); i++){
        if(intList.get(i) != i)
            return formatBranchNum(Integer.toString(i));
          
    } 
   
    return incBranchNum(Integer.toString((intList.get(intList.size()-1))));    
    }    
        
    
    
    
    
    
    
    

    public static String incLocalNum(String str){
       String retVal;
       int temp = Integer.parseInt(str);
       temp ++;
       retVal = Integer.toString(temp);
       return formatLocalNum(retVal);
    }   
    
   
    public static String formatLocalNum(String str){
       if(str.length() == 1){
           return "000" + str;
       }else if(str.length() == 2){
           return "00" + str;
       }
       else if(str.length() == 3){
           return "0" + str;
       }
     
       else 
           return str; 
    } 
    
    
    
    
    
   

    public static String pickLocalNum(ArrayList<String> str){
        
    if(str.size() == 0 || str == null)
       return formatLocalNum("0");       
        
   
    ArrayList<Integer> intList = new ArrayList<Integer>();
    int retVal;
    
    for(int i = 0; i < str.size(); i++){
         intList.add(Integer.parseInt(str.get(i)));  
               
        
    }
    Collections.sort(intList);
    
    for(int i=0; i < intList.size(); i++){
        if(intList.get(i) != i)
            return formatLocalNum(Integer.toString(i));
          
    } 

    return incLocalNum(Integer.toString((intList.get(intList.size()-1))));    
    }    
        
    
    
    
    
    
    
    
    
    
    
    
    
    public static void open_branch(){
        System.out.println("Attempting to open branch.");
    
        try
	    {
        
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
       
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","fedora","oracle");
       
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT b# FROM Branch"); 
         
         
        ArrayList<String> temp = new ArrayList<String>();
        String id = "000";
        Scanner obj = new Scanner(System.in);
        System.out.println("What is the address for the new branch?: ");
        String addr = obj.nextLine();
        
        
        
        
        if(!rs.isBeforeFirst()){
           stmt.executeUpdate("insert into branch values ( '"+id+"', '"+addr+"')");   
        }
             

        else{
            while(rs.next())
	        {

            temp.add(rs.getString("b#"));
		
       	    }
        
            id = pickBranchNum(temp);
            stmt.executeUpdate("insert into branch values ( '"+id+"' , '"+addr+"')"); 
        
        }
           
	 
	   
	    stmt.close();
	    conn.close();
	    }
        catch(Exception e)
	    {
	      System.out.println("Branch not created");
	      e.printStackTrace();
	      System.exit(-1);
	    }
     
    }
    
    
    
    
    
    
    
    
    
    public static void close_branch(){
    System.out.println("Attempting to delete branch.");
        try
	    {
        
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
  
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","fedora","oracle");

        Statement stmt = conn.createStatement();
        
         
         
        ArrayList<String> temp = new ArrayList<String>();
        String id;
        Scanner obj = new Scanner(System.in);
        
        System.out.println("Select 1. if you have the b# of the branch you want deleted, 2. if you know the address:");
        String addr = obj.nextLine();
        
        
        
        
        if(addr.equals("1")){
         System.out.println("Branch number?");
         addr = obj.nextLine();   
         ResultSet rs = stmt.executeQuery("SELECT b.b# FROM Branch b where b.b# = '"+addr+"'");    
          
          if(!rs.isBeforeFirst()){
           System.out.println("Branch didnt exist.");  
          }
          
          else{
            stmt.executeUpdate("delete from branch where b# = '"+addr+"'"); 
            System.out.println("Branch deleted");
          }



         
        }
        else{
         System.out.println("Address?");   
         addr = obj.nextLine();   
         ResultSet rs = stmt.executeQuery("SELECT b.address FROM Branch b where b.address = '"+addr+"'");    
          
          if(!rs.isBeforeFirst()){
           System.out.println("Branch didnt exist.");  
          }
          
          else{
            stmt.executeUpdate("delete from branch where address = '"+addr+"'"); 
            System.out.println("Branch deleted");
          }

   
            
            
            
        }
        
        

	    stmt.close();
	    conn.close();
	    }
        catch(Exception e)
	    {
	      System.out.println("Branch not deleted");
	      e.printStackTrace();
	      System.exit(-1);
	    }
     
    }
    
    
    
    
    
    
    
    
    
    
    
    public static void setup_account(){
    System.out.println("Setting up account.");
        try
            {

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","fedora","oracle");

        Statement stmt = conn.createStatement();



        ArrayList<String> temp = new ArrayList<String>();

        Scanner obj = new Scanner(System.in);
        Scanner obj2 = new Scanner(System.in);
        
        System.out.println("Name?:");
        String name = obj.nextLine();

        System.out.println("Balance?:");
        int balance = obj.nextInt();
        String id;
        String bnum;
        String addr;
        String cnum = "00000"; 



        ResultSet rs = stmt.executeQuery("SELECT c.c# FROM customer c where c.cname = '"+name+"'");


 
        

        if(!rs.isBeforeFirst()){
          System.out.println("Customer didnt exist.");
          return;
        }
        
        while(rs.next()){

          cnum = rs.getString(1);

        }
          
                















        rs = stmt.executeQuery("SELECT a.l# FROM account a, branch b where b.b#=a.b#");

        if(!rs.isBeforeFirst()){
         
          id = "0000";
          
        }

        else{


        while(rs.next()){

          temp.add(rs.getString(1));

          }
          id = pickLocalNum(temp);
        }

    
        System.out.println("Select 1. if you have the b# of the branch, 2. if you know the address:");

        addr = obj2.nextLine();




        if(addr.equals("1")){
         System.out.println("Branch number?");
         addr = obj2.nextLine();
         rs = stmt.executeQuery("SELECT b.b# FROM Branch b where b.b# = '"+addr+"'");

          if(!rs.isBeforeFirst()){
           System.out.println("Branch didnt exist.");
           return;
          }

          else{
            rs.next();
            bnum = rs.getString("b#");
          }




        }
        else{
         System.out.println("Address?");
         addr = obj2.nextLine();
         rs = stmt.executeQuery("SELECT b.b# FROM Branch b where b.address = '"+addr+"'");

          if(!rs.isBeforeFirst()){
           System.out.println("Branch didnt exist.");
           return;
          }

          else{
            rs.next();  
            bnum = rs.getString("b#");
          }

        }

        String anum = bnum + id;

        stmt.executeUpdate("insert into account values ( '"+bnum+"', '"+cnum+"', '"+anum+"', '"+id+"' ,'"+balance+"')");


        rs.close();
        stmt.close();
        conn.close();
        
        }
        catch(Exception e)
            {
              System.out.println("account not created");
              e.printStackTrace();
              System.exit(-1);
            }

    }

    
    
    
    
    
    
    
    


public static void setup_customer(){
    System.out.println("Attempting to setup customer.");
        try
            {

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","fedora","oracle");
        Statement stmt = conn.createStatement();



        ArrayList<String> temp = new ArrayList<String>();

        Scanner obj = new Scanner(System.in);
        int status = 0;
        String id;
        
        
        System.out.println("Name?:");
        String name = obj.nextLine();




        ResultSet rs = stmt.executeQuery("SELECT c.cname FROM customer c where c.cname = '"+name+"'");

        if(rs.isBeforeFirst()){
          System.out.println("Customer already existed.");
          return;
        }

         




        rs = stmt.executeQuery("SELECT c# FROM customer c ");

        if(!rs.isBeforeFirst()){
          id = "00000";

        }

        else{


        while(rs.next()){

          temp.add(rs.getString(1));

          }
          id = pickCustomerNum(temp);
        }

    
     






        


        stmt.executeUpdate("insert into customer values ('"+id+"', '"+name+"', '"+status+"')");
            

        rs.close();
        stmt.close();
        conn.close();
        
        System.out.println("=====Setting up account====="); 
        setup_account();
        
        
        }
        catch(Exception e)
            {
              System.out.println("account not created");
              e.printStackTrace();
              System.exit(-1);
            }

    }

    
    

    






public static void close_account(){
    System.out.println("Attempting to close account.");
        try
            {

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
       
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","fedora","oracle");
   
        Statement stmt = conn.createStatement();



        ArrayList<String> temp = new ArrayList<String>();

        Scanner obj = new Scanner(System.in);
        Scanner obj2 = new Scanner(System.in);
        
        String bnum;
        int balance;
        ResultSet rs; 
        
        
        
        
        System.out.println("What is the name of the person who owns the account you want to drop?");
        System.out.println("Name?:");
        String name = obj.nextLine();

        System.out.println("Select 1. if you have the b# of the branch, 2. if you know the address:");

        String addr = obj2.nextLine();

       


        if(addr.equals("1")){
         System.out.println("Branch number?");
         addr = obj2.nextLine();
         rs = stmt.executeQuery("SELECT b.b# FROM Branch b where b.b# = '"+addr+"'");

          if(!rs.isBeforeFirst()){
           System.out.println("Branch didnt exist.");
           return;
          }

          else{
            rs.next();
            bnum = rs.getString("b#");
          }




        }
        else{
         System.out.println("Address?");
         addr = obj2.nextLine();
         rs = stmt.executeQuery("SELECT b.b# FROM Branch b where b.address = '"+addr+"'");

          if(!rs.isBeforeFirst()){
           System.out.println("Branch didnt exist.");
           return;
          }

          else{
            rs.next();  
            bnum = rs.getString("b#");
          }

        }       











        


        rs = stmt.executeQuery("SELECT a.balance FROM account a, customer c where c.cname = '"+name+"' and a.c#=c.c#");


        if(!rs.isBeforeFirst()){
          System.out.println("Account didnt exist");
          return;

        }

        else{
    
          stmt.executeUpdate("delete from account a where exists(select * from  customer c  where a.balance=0 and c.cname = '"+name+"' and a.c#=c.c#)");  
      
        
          
        }
          
        
        rs = stmt.executeQuery("SELECT a.c# from account a, customer c where a.c# = c.c# and c.cname = '"+name+"'");
      
        if(!rs.isBeforeFirst()){
          System.out.println("Customer: " + name + " no longer has any accounts, deleting....");  
          stmt.executeUpdate("delete from customer c where c.cname = '"+name+"'");
          

        } 
         
         
        rs = stmt.executeQuery("SELECT a.b# from account a, Branch b where a.b# = b.b# and b.b# = '"+bnum+"'");

        if(!rs.isBeforeFirst()){
          System.out.println("Branch: " + bnum + " no longer has any accounts, deleting....");  
          stmt.executeUpdate("delete from Branch b where b.b# = '"+bnum+"'");
          

        }  
         
         
         
         

        rs.close();
        stmt.close();
        conn.close();
        
        }
        catch(Exception e)
            {
              System.out.println("account error");
              e.printStackTrace();
              System.exit(-1);
            }

    }

    









public static void withdraw(){
    System.out.println("Attempting to withdraw.");
        try
            {

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
       
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","fedora","oracle");
   
        Statement stmt = conn.createStatement();



        ArrayList<String> temp = new ArrayList<String>();

        Scanner obj = new Scanner(System.in);
        Scanner obj2 = new Scanner(System.in);
        
        String bnum;
        String anum;
        String name;
        int amount;
        int balance = 0;
        int newBalance = 0;
        ResultSet rs; 
        
        
        
        
        System.out.println("What is the name of the person who owns the account?");
        name = obj.nextLine();

        System.out.println("What is the account numer?");

        anum = obj2.nextLine();

        System.out.println("Amount to withdraw?");
        amount = obj.nextInt();
                 



        
        rs = stmt.executeQuery("SELECT a.balance FROM account a, customer c where c.cname = '"+name+"' and a.c#=c.c#");


        if(!rs.isBeforeFirst()){
          System.out.println("Account didnt exist");
          return;

        }
          
        else{
            
            while(rs.next()){

               balance = rs.getInt(1);
               

            }
           
            
            
            
        }  
          
        if(balance >= amount){
           System.out.println("Withdrawing......");
           stmt.executeUpdate("update account set balance = (balance - '"+amount+"') where a# = '"+anum+"'");           
            
        }
        
        else{
           System.out.println("Not enough money."); 
           
        }
          
          
          
      
         
         
         
         

        rs.close();
        stmt.close();
        conn.close();
        
        }
        catch(Exception e)
            {
              System.out.println("account error");
              e.printStackTrace();
              System.exit(-1);
            }

    }

    






public static void deposit(){
    System.out.println("Attempting to deposit.");
        try
            {

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
       
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","fedora","oracle");
   
        Statement stmt = conn.createStatement();



        ArrayList<String> temp = new ArrayList<String>();

        Scanner obj = new Scanner(System.in);
        Scanner obj2 = new Scanner(System.in);
        
        String bnum;
        String anum;
        String name;
        int amount;
        int newBalance=0;
        int balance = 0;
        ResultSet rs; 
        
        
        
        
        System.out.println("What is the name of the person who owns the account?");
        name = obj.nextLine();

        System.out.println("What is the account numer?");

        anum = obj2.nextLine();

        System.out.println("Amount to deposit?");
        amount = obj.nextInt();
                 



        
        rs = stmt.executeQuery("SELECT a.balance FROM account a, customer c where c.cname = '"+name+"' and a.c#=c.c#");


        if(!rs.isBeforeFirst()){
          System.out.println("Account didnt exist");
          return;

        }
          
        else{
            
            while(rs.next()){

               balance = rs.getInt(1);
               

            }
           
            
            
            
        }  
          
    
        System.out.println("depositing......");
        stmt.executeUpdate("update account set balance = (balance + '"+amount+"') where a# = '"+anum+"'");           
        
        newBalance = getStatus(balance + amount);
        stmt.executeUpdate("update customer set status = '"+newBalance+"' where cname = '"+name+"'");
        
        
        
                
        
        
         
         
         
         

        rs.close();
        stmt.close();
        conn.close();
        
        }
        catch(Exception e)
            {
              System.out.println("account error");
              e.printStackTrace();
              System.exit(-1);
            }

    }












public static void transfer(){
    System.out.println("Attempting to transfer.");
        try
            {

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
       
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","fedora","oracle");
   
        Statement stmt = conn.createStatement();



        ArrayList<String> temp = new ArrayList<String>();

        Scanner obj = new Scanner(System.in);
        Scanner obj2 = new Scanner(System.in);
        
        String bnum;
        String anum1;
        String anum2;
        
        String name;
        int amount;
        
        
        int balance = 0;
        ResultSet rs; 
        
        
        
        
        System.out.println("What is you name?");
        name = obj.nextLine();

        System.out.println("What is your account number?");
        anum1 = obj2.nextLine();

        System.out.println(" What is the account number you want to send the money to?");
        anum2 = obj2.nextLine();
         

        System.out.println("Amount to transfer?");
        amount = obj.nextInt();
                 




        rs = stmt.executeQuery("SELECT a.balance FROM account a, customer c where c.cname = '"+name+"' and a.c#=c.c#");


        if(!rs.isBeforeFirst()){
          System.out.println("Account didnt exist");
          return;

        }
          
        else{
            
            while(rs.next()){

               balance = rs.getInt(1);
               

            }
           
            
            
            
        }  
          
        if(balance >= amount){
           System.out.println("transfering......");
           stmt.executeUpdate("update account set balance = (balance - '"+amount+"') where a# = '"+anum1+"'");           
           stmt.executeUpdate("update account set balance = (balance + '"+amount+"') where a# = '"+anum2+"'"); 
        }
        
        else{
           System.out.println("Not enough money."); 
           
        }
               
         
         
         

        rs.close();
        stmt.close();
        conn.close();
        
        }
        catch(Exception e)
            {
              System.out.println("account error");
              e.printStackTrace();
              System.exit(-1);
            }

    }













    
    
    
    public static void show_branch(){
    System.out.println("Showing branch accounts.");
        try
            {

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","fedora","oracle");

        Statement stmt = conn.createStatement();



        ArrayList<String> temp = new ArrayList<String>();

        Scanner obj = new Scanner(System.in);
        Scanner obj2 = new Scanner(System.in);
        
   
        
        int totalBalance = 0;
        String id;
        String bnum;
        String addr;
        ResultSet rs;

       
              
    
        System.out.println("Select 1. if you have the b# of the branch, 2. if you know the address:");

        addr = obj2.nextLine();




        if(addr.equals("1")){
         System.out.println("Branch number?");
         addr = obj2.nextLine();
         rs = stmt.executeQuery("SELECT b.b# FROM Branch b where b.b# = '"+addr+"'");

          if(!rs.isBeforeFirst()){
           System.out.println("Branch didnt exist.");
           return;
          }

          else{
            rs.next();
            bnum = rs.getString("b#");
          }




        }
        else{
         System.out.println("Address?");
         addr = obj2.nextLine();
         rs = stmt.executeQuery("SELECT b.b# FROM Branch b where b.address = '"+addr+"'");

          if(!rs.isBeforeFirst()){
           System.out.println("Branch didnt exist.");
           return;
          }

          else{
            rs.next();  
            bnum = rs.getString("b#");
          }

            
         }
            
        

       
        rs = stmt.executeQuery("select a.b#, a.c#, a.a#, a.l#, a.balance from account a, branch b  where b.b# = '"+bnum+"' and a.b# = b.b#");
        
        System.out.println("b#   c#     a#       l#    balance");
        System.out.println("==================================");
     
      
         while(rs.next())
         {
          
	    System.out.print(rs.getString("b#")+"   ");
	    
	    System.out.print(rs.getString("c#")+"   ");
        
        System.out.print(rs.getString("a#")+"   ");
            
        System.out.print(rs.getString("l#")+"   ");
           
	    System.out.println(rs.getInt("balance"));
                 
         
            }
            
        rs = stmt.executeQuery("select a.balance from account a, branch b  where b.b# = '"+bnum+"' and b.b#=a.b#");
      
        while(rs.next()){
            
            totalBalance += rs.getInt("balance");
        }
        System.out.println("Total balance is = " + totalBalance);
      
      
      


        rs.close();
        stmt.close();
        conn.close();
    
        }
        
        catch(Exception e)
            {
              System.out.println("account not created");
              e.printStackTrace();
              System.exit(-1);
            }

    }

    
    
    
















    
    
    
    public static void show_all_branches(){
    System.out.println("Showing ALL branch accounts.");
        try
            {

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","fedora","oracle");

        Statement stmt = conn.createStatement();



        ArrayList<String> temp = new ArrayList<String>();

        Scanner obj = new Scanner(System.in);
        Scanner obj2 = new Scanner(System.in);
        
   
        
        int totalBalance = 0;
        String id;
        String bnum;
        String addr;
        ResultSet rs;

       

        
       
        rs = stmt.executeQuery("select b# from branch");
        
    
     
      
         while(rs.next())
         {
            System.out.println("b# = " + rs.getString("b#")); 
            show_branch();
         
            }
            
      
      
      


        rs.close();
        stmt.close();
        conn.close();
    
        }
        
        catch(Exception e)
            {
              System.out.println("account not created");
              e.printStackTrace();
              System.exit(-1);
            }

    }

    
    
    


    
    











    public static void show_customer(){
    System.out.println("Showing customer accounts.");
        try
            {

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","fedora","oracle");

        Statement stmt = conn.createStatement();



        ArrayList<String> temp = new ArrayList<String>();

        Scanner obj = new Scanner(System.in);
        Scanner obj2 = new Scanner(System.in);
        
   
        
        int totalBalance = 0;
        String id;
        String anum;
        String status;
        int balance = 0; 
        ResultSet rs;
        String name; 

       
              
    
        System.out.println("Customer name?");

        name = obj2.nextLine();




       
            
        

       
        rs = stmt.executeQuery("select a.c#, c.status, a.a#, a.balance from account a, customer c  where c.cname = '"+name+"' and a.c# = c.c#");
        
        System.out.println("c#     status     a#        balance");
        System.out.println("====================================");
     
      
         while(rs.next())
         {
          
	    System.out.print(rs.getString("c#")+"   ");
	    
	    System.out.print(rs.getInt("status")+"   ");
        
        System.out.print(rs.getString("a#")+"   ");
            
           
	    System.out.println(rs.getInt("balance"));
                 
         
            }
            
        rs = stmt.executeQuery("select a.balance from account a, customer c  where c.cname = '"+name+"' and c.c# = a.c#");
      
        while(rs.next()){
            
            totalBalance += rs.getInt("balance");
        }
        System.out.println("Total balance is = " + totalBalance);
      
      
      


        rs.close();
        stmt.close();
        conn.close();
    
        }
        
        catch(Exception e)
            {
              System.out.println("error");
              e.printStackTrace();
              System.exit(-1);
            }

    }






    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
      
    public static void branch(){
 
        try
            {

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","fedora","oracle");

        Statement stmt = conn.createStatement();



        ArrayList<String> temp = new ArrayList<String>();

        Scanner obj = new Scanner(System.in);
        Scanner obj2 = new Scanner(System.in);
        
   
        
        int totalBalance = 0;
        String id;
        String bnum;
        String addr;
        ResultSet rs;

       
              
    




         System.out.println("Address?");
         addr = obj2.nextLine();
         rs = stmt.executeQuery("SELECT b.b# FROM Branch b where b.address = '"+addr+"'");

          if(!rs.isBeforeFirst()){
           System.out.println("Branch didnt exist.");
           return;
          }

          else{
            rs.next();  
            bnum = rs.getString("b#");
          }
          System.out.println("bnum is: '"+bnum+"'");

            
         
            
        

       
      
      


        rs.close();
        stmt.close();
        conn.close();
    
        }
        
        catch(Exception e)
            {
              
              e.printStackTrace();
              System.exit(-1);
            }

    }

    
    
    
    
    
    
    
    
    
    
    
    

public static void remove_customer(){
    System.out.println("Deleting customer.");
        try
            {

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
       
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","fedora","oracle");
   
        Statement stmt = conn.createStatement();



        ArrayList<String> temp = new ArrayList<String>();

        Scanner obj = new Scanner(System.in);
        Scanner obj2 = new Scanner(System.in);
        
        String bnum;
        int balance;
        ResultSet rs; 
        
        
        
       
        System.out.println("Name?:");
        String name = obj.nextLine();

        

      








        


        rs = stmt.executeQuery("SELECT c.cname from customer c where c.cname = '"+name+"'");


        if(!rs.isBeforeFirst()){
          System.out.println("customer didnt exist");
          return;

        }

        else{
    
          stmt.executeUpdate("delete from customer c where c.cname = '"+name+"'");  
      
        
          
        }
          
        
     
         
         
         

        rs.close();
        stmt.close();
        conn.close();
        
        }
        catch(Exception e)
            {
              System.out.println("account error");
              e.printStackTrace();
              System.exit(-1);
            }

    }

        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) 
    {
        
        
     String choice; 
     Scanner obj = new Scanner(System.in);  
     while(true){
        
         
        System.out.println("Here are the choices.");
        System.out.println("1.openBranch, 2.closeBranch, 3.setup_account, 4.setup_customer, 5.close_account, 6.withdraw");
        System.out.println("7.deposit, 8.transfer, 9. show_branch, 10. show_all_branches, 11. show_customer, 12. branch 13. remove_customer, q to quit");        
        choice = obj.nextLine(); 
        
         if(choice.equals("1")){
             open_branch();
             
         }
         else if(choice.equals("2")){
             
             close_branch();
         }
         else if(choice.equals("3")){
             setup_account();
             
         }
         else if(choice.equals("4")){
             setup_customer();
             
         }
         else if(choice.equals("5")){
            close_account(); 
             
         }
          else if(choice.equals("6")){
             withdraw();
             
         }
          else if(choice.equals("7")){
             deposit();
             
         }
          else if(choice.equals("8")){
             transfer();
             
         }
          else if(choice.equals("9")){
             show_branch();
             
         }
          else if(choice.equals("10")){
             show_all_branches();
             
         }
          else if(choice.equals("11")){
            show_customer(); 
             
         }
          else if(choice.equals("12")){
            branch(); 
             
         }
         else if(choice.equals("13")){
            remove_customer(); 
             
         }
         else{
             break;
         }
         
         
         
         
         
     }
     
 
     
     
    
    }
}
