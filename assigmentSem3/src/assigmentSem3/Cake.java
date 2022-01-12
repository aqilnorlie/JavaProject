package assigmentSem3;

/**
*
* Group members name and matric number:
* 1) 
* 2)
* 3)
* 4)
* Class :
*/
import java.lang.*;

	public class Cake
	{
	  private String custID; //D001, P003
	  private String cakeType; //D24 Chocolate Cake,Red Velvet,Burnt Cheese Cake,Black Forest
	  private int qty;
	  private double price;
	  
	  public Cake(String ID,String cakeType, int qty)
	  {    this.custID=ID;
	       this.cakeType=cakeType;
	       this.qty=qty;
	  }
	  
	  
	
	  
	  public void setID(String ID){this.custID=ID;}
	  public void setCakeType(String cakeType){this.cakeType=cakeType;}
	  public void setQty(int qty){this.qty=qty;}
	
	
	  
	  //2.a)Write the retriever method for custID, cakeType and qty
	  
	  public String getCustID() {return custID;}
	  public String getCakeType(){return cakeType;}
	  public int getQuantity(){return qty;}
	  
	  
	 
	  //2.b)Write the detPrice() method that will return the price of cake based on cakeType.Refer 2_GroupProject.docx
	  
	  public double detPrice() {
		  
		  if(cakeType.equalsIgnoreCase("D24 Chocolate cake")) {
			  
			 return this.price = 120.00;
			  
		  }else if(cakeType.equalsIgnoreCase("Red Velvet") || (cakeType.equalsIgnoreCase("Black Forest"))){
			  
			  return this.price = 80.00;
			  
		  }else if(cakeType.equalsIgnoreCase("Burnt Cheese Cake")) {
			  
			  return this.price = 100.00;
			   
		  }else {
		  
			  return 0;
		 
		  }
		  
	  }
	  
	   
	  //2.c)Write the toString method that will return the output look like as below:
	  //Customer ID:XXXX	Cake Type:XXXXXXX	        Price: RM XX.XX	     Quantity:XX
	  
	  public String toString() { 
          									//Using String format with flag left align and width 15 with conversion s String
				
		  return "Customer ID: " + this.custID + String.format("\tCake Type : %-15s",this.cakeType) 
		  + "\tPrice : RM " + String.format("%.2f",this.price) + "\tQuantity: " + this.qty; 
}
     
}