package assigmentSem3;

import java.util.*;
import java.io.*;
import java.lang.*;
public class MyAss2QApp {
    public static void main(String[] args) throws Exception 
    {
        
        try
        {
            BufferedReader br = new BufferedReader (new FileReader ("cakeOrder.txt"));
            PrintWriter pickOut = new PrintWriter (new FileWriter ("pickup.txt"));
            PrintWriter delOut = new PrintWriter (new FileWriter ("delivery.txt"));
            Queue cakeQ=new Queue();
            Queue tempQ=new Queue();
            
            //a)b)c)read the data from cakeOrder.txt and insert into cakeQ
            
            Cake cake; //Declare Object name call cake
            
            String n = null;
            String id,type;
            int qty;
          
            //Read the data in the cakeOrder.txt file then insert into cakeQ queue
            while((n = br.readLine()) != null) {
            	
            	StringTokenizer st = new StringTokenizer(n,"*");
            	
            	id = st.nextToken();
            	type = st.nextToken();
            	qty = Integer.parseInt(st.nextToken());
            	
            	
            	cake = new Cake(id,type,qty);
        
            	
            	cakeQ.enqueue(cake);
            	
            
            }
            
            //d)display the data in the cakeQ
            
            
            
            while(cakeQ.isEmpty() != true) {
            	
            	cake = cakeQ.dequeue(); 
            	
            	cake.detPrice();
            	System.out.println(cake.toString());
            	
            	tempQ.enqueue(cake);
            }
            
            
            //e)The first character of custID is based on the delivery type. if the first character is 'P' 
	    //mean the customer choose to pickup the cake and if the first character is 'D', the customer 
            //choose to have delivery service. Example of custID are P002,D112 and etc. Write the data for delivery 
            //into delivery.txt output file and the data for customer that choose self pick up into pickup.txt. 
            
            pickOut.println(String.format("Data for Pickup : %n ")); //Using String format function then %n for like separator
            delOut.println(String.format("Data for Delivery : %n "));
            int numP = 0;
            int numD = 0;
            while(tempQ.isEmpty() != true) {
            	
            	cake = tempQ.dequeue();
            	
            	
            	if(cake.getCustID().substring(0,1).equalsIgnoreCase("P")) { //Check for the first letter if P then insert into pickup.txt
            		
            		numP++;
            		pickOut.println(numP +")" + cake.toString());
            		
            		
            	}else {  //else it will insert into delivery.txt
            		numD++;
            		delOut.println(numD + ")" + cake.toString());
            	}
            	
            	cakeQ.enqueue(cake);
            	
            }
            
            
            
            
            
            //f)Display the total quantity order for each cake type and display the cake name of the highest total order
            
             int countRed = 0,countD24 = 0,countBurnt = 0, high = 0, countBF = 0;
             
             
             while(cakeQ.isEmpty() != true) {
            	 
            	 cake = cakeQ.dequeue();
            	 
            
            	String caketype = cake.getCakeType();  //assign cakeType to caketype variable
            
            
            	if(caketype.equalsIgnoreCase("Red Velvet")) {
        		
        		countRed++;
        		
            	}else if(caketype.equalsIgnoreCase("D24 Chocolate Cake")) {
        		
        		countD24++;
        		
            	}else if(caketype.equalsIgnoreCase("Burnt Cheese Cake")) {
        		
        		countBurnt++;
        		
        		
            	}else {
        		
        		countBF++;
        	  }  
            	
        	tempQ.enqueue(cake);
         }	 
             
          
            
             System.out.println("\nTotal quantity of D24 Chocolate Cake : " + countD24);
             System.out.println("Total quantity of Red Velvet : " + countRed);
             System.out.println("Total quantity of Burnt Cheese Cake : " + countBurnt);
             System.out.println("Total quantity of Black Forest : " + countBF);
     
            
            
            //g)Display the receipt that will display the custID, cakeType, price(using detPrice() method), qty, 
	    //payment for each order. In order to calculate the payment for each order you need to multiply quantity 
	    //with the cake price and it is an extra charge of RM 5.00 for delivery service. Lastly, display the total 
            //payment for all the orders. 
              
                
            br.close();
            pickOut.close();
            delOut.close();
        }
        catch(Exception e) {System.err.println(e.getMessage());}
    
        }
     /***End of main() Method***/   
}/***End of Application Class***/