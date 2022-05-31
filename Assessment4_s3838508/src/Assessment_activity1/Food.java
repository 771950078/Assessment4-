package Assessment_activity1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Food {
	 private String foodID;

     private String foodName;

     private String foodDescription;

     private double foodPrice;

     private int foodCalorie;

     private String foodType;
     
     
     
     public Food (String foodID, String foodName, String foodDescription, double foodPrice, int foodCalorie, String foodType)

     {
    	 this.foodID = foodID;
    	 this.foodName = foodName;
    	 this.foodDescription = foodDescription;
    	 this.foodPrice = foodPrice;
    	 this.foodCalorie = foodCalorie;
    	 this.foodType = foodType;
      }
     
     public String getFoodID()
     {
    	 return this.foodID;
     }
     
     public String getFoodName()
     {
    	 return this.foodName;
     }
     
     public String getFoodDescription()
     {
    	 return this.foodDescription;
     }
     
     public double getFoodPrice()
     {
    	 return this.foodPrice;
     }
     
     public int getFoodCalorie()
     {
    	 return this.foodCalorie;
     }
     
     public String getFoodType()
     {
    	 return this.foodType;
     }
     
     public void setFoodID(String foodID)
     {
    	 this.foodID = foodID;
     }
     
     public void setFoodName(String foodName)
     {
    	 this.foodName = foodName;
     }
     
     public void setFoodDescription(String foodDescription)
     {
    	 this.foodDescription = foodDescription;
     }
     
     public void setFoodPrice(double FoodPrice)
     {
    	 this.foodPrice = FoodPrice;
     }
     
     public void setFoodCalorie(int FoodCalorie)
     {
    	 this.foodCalorie = FoodCalorie;
     }
     
     public void setFoodType(String FoodType)
     {
    	 this.foodType = FoodType;
     }
     
     public boolean AddFood()

     {
    	 
    	 boolean flag_addingfood = true;
          
    	 if (this.foodName.length()<= 5 || this.foodName.length() >=30)
    	 {
    		 flag_addingfood = false;
    	 }
    	 int WordsCounting = countWords	(this.foodDescription);
    	 if(WordsCounting <= 5 || WordsCounting >= 50)
    	 {
    		 flag_addingfood = false;
    	 }
    	 if (this.foodType.equals("Kid Food"))
    	 {
    		 if(this.foodCalorie >= 800)
    		 {
    			 flag_addingfood = false;
    		 }
    		 else
    		 {
    			 if(this.foodPrice > 150 || this.foodPrice < 5)
        		 {
        			 flag_addingfood = false;
        		 }
    		 }
    	 }
    	 if (!this.foodType.equals("Kid Food"))
    	 {
    		 if(this.foodCalorie >= 1500)
    		 {
    			 flag_addingfood = false;
    		 }
    		 else
    		 {
    			 if (this.foodCalorie >= 1000)
    			 {
    				 if(this.foodPrice>100 || this.foodPrice<5)
    				 {
    					 flag_addingfood = false;
    				 }
    			 }
    			 if (this.foodCalorie <= 1000)
    			 {
    				 if(this.foodPrice > 150 || this.foodPrice < 5)
    				 {
    					 flag_addingfood = false;
    				 }
    			 }
    		 }
    	 }
    	 
         
    	 if(flag_addingfood == true)
    	 {
    		 try
    		 {
    			ArrayList<Food> foodlist = new ArrayList();
    			File file = new File("foodlist.txt");
    			Scanner scan = new Scanner(file);
    			String row;
    			String[] rowelements;
    			String ListFoodID;
    			String ListFoodName;
    			String ListFoodDescription;
    			double ListFoodPrice;
    			int ListFoodCalorie;
    			String ListFoodType;
    			while (scan.hasNextLine())
    			{
    				row = scan.nextLine();
    				rowelements = row.split(",");
    				ListFoodID = rowelements[0];
    				ListFoodName = rowelements[1];
    				ListFoodDescription = rowelements[2];
    				ListFoodPrice = Double.valueOf(rowelements[3]);
    				ListFoodCalorie = Integer.parseInt(rowelements[4]);
    				ListFoodType = rowelements[5];
    				Food listfood = new Food(ListFoodID,ListFoodName,ListFoodDescription,ListFoodPrice,ListFoodCalorie,ListFoodType);
    				foodlist.add(listfood);
    			}
    			for(int i = 0; i < foodlist.size(); i++)
    			{
    				if(this.foodID.equals(foodlist.get(i).getFoodID()))
    				{
    					flag_addingfood=false;
    				}
    			}
    			if(flag_addingfood == true)
    			{
    				Food newfood = new Food(this.foodID, this.foodName,this.foodDescription,this.foodPrice,this.foodCalorie,this.foodType);
    			foodlist.add(newfood);
    			FileWriter filewrite = new FileWriter("foodlist.txt");
    			BufferedWriter myWriter = new BufferedWriter(filewrite);
    			for(int i = 0; i < foodlist.size(); i++)
    			{
    				
    				myWriter.write(foodlist.get(i).getFoodID()+","+foodlist.get(i).getFoodName()+","+foodlist.get(i).getFoodDescription()+","+foodlist.get(i).getFoodPrice()+","+foodlist.get(i).getFoodCalorie()+","+foodlist.get(i).getFoodType());
    				myWriter.write("\n");
    			}
    			myWriter.close();
    			}
    			
    	 }
    		 catch(IOException e)
    		 {
    			 System.out.println("Error sending");
    			 e.printStackTrace();
    		 }
    		 return flag_addingfood;
    	 }
    	 
    	 else
    	 {
    		 return flag_addingfood;
    	 }
     }

     public boolean UpdateFood(String foodName,String foodDescription, double foodPrice, int foodCalorie, String foodType)

     {
    	 
          
    	 boolean flag_updatefood = true;
    	 if (this.foodName.length()< 5 || this.foodName.length() >30)
    	 {
    		 flag_updatefood = false;
    	 }
    	 int WordsCounting = countWords	(this.foodDescription);
    	 if(WordsCounting < 5 || WordsCounting > 50)
    	 {
    		 flag_updatefood = false;
    	 }
    	 if (this.foodType.equals("Kid Food"))
    	 {
    		 if(this.foodCalorie >= 800)
    		 {
    			 flag_updatefood = false;
    		 }
    		 else
    		 {
    			 if(this.foodPrice > 150 || this.foodPrice < 5)
        		 {
    				 flag_updatefood = false;
        		 }
    		 }
    	 }
    	 if (!this.foodType.equals("Kid Food"))
    	 {
    		 if(this.foodCalorie >= 1500)
    		 {
    			 flag_updatefood = false;
    		 }
    		 else
    		 {
    			 if (this.foodCalorie >= 1000)
    			 {
    				 if(this.foodPrice>100 || this.foodPrice<5)
    				 {
    					 flag_updatefood = false;
    				 }
    			 }
    			 if (this.foodCalorie <= 1000)
    			 {
    				 if(this.foodPrice > 150 || this.foodPrice < 5)
    				 {
    					 flag_updatefood = false;
    				 }
    			 }
    		 }
    	 }
    	 if (foodPrice-this.foodPrice > this.foodPrice*0.1 || this.foodPrice - foodPrice > this.foodPrice*0.1)
    	 {
    		 flag_updatefood = false;
    	 }
    	 if (foodCalorie != this.foodCalorie)
    	 {
    		 flag_updatefood = false;
    	 }
    	 if (foodType.equals("Kid Food") && !this.foodType.equals("Kid Food"))
    	 {
    		 flag_updatefood = false;
    	 }
        
    	 if(flag_updatefood == true)
    	 {
    		 try
    		 {
    			 
    			ArrayList<Food> foodlist = new ArrayList();
    			File file = new File("foodlist.txt");
    			Scanner scan = new Scanner(file);
    			String row;
    			String[] rowelements;
    			String ListFoodID;
    			String ListFoodName;
    			String ListFoodDescription;
    			double ListFoodPrice;
    			int ListFoodCalorie;
    			String ListFoodType;
    			while (scan.hasNextLine())
    			{
    				row = scan.nextLine();
    				rowelements = row.split(",");
    				ListFoodID = rowelements[0];
    				ListFoodName = rowelements[1];
    				ListFoodDescription = rowelements[2];
    				ListFoodPrice = Double.valueOf(rowelements[3]);
    				ListFoodCalorie = Integer.parseInt(rowelements[4]);
    				ListFoodType = rowelements[5];
    				Food listfood = new Food(ListFoodID,ListFoodName,ListFoodDescription,ListFoodPrice,ListFoodCalorie,ListFoodType);
    				foodlist.add(listfood);
    			}
    			
    			for(int i = 0; i < foodlist.size(); i++)
    			{
    				if(this.foodID.equals(foodlist.get(i).getFoodID()))
    				{
    					foodlist.get(i).setFoodName(foodName);
    					foodlist.get(i).setFoodDescription(foodDescription);
    					foodlist.get(i).setFoodPrice(foodPrice);
    					foodlist.get(i).setFoodCalorie(foodCalorie);
    					foodlist.get(i).setFoodType(foodType);
    				}
    			}
    			FileWriter filewrite = new FileWriter("foodlist.txt");
    			BufferedWriter myWriter = new BufferedWriter(filewrite);
    			for(int i = 0; i < foodlist.size(); i++)
    			{
    				
    				myWriter.write(foodlist.get(i).getFoodID()+","+foodlist.get(i).getFoodName()+","+foodlist.get(i).getFoodDescription()+","+foodlist.get(i).getFoodPrice()+","+foodlist.get(i).getFoodCalorie()+","+foodlist.get(i).getFoodType());
    				myWriter.write("\n");
    			}
    			myWriter.close();
    	 }
    		 catch(IOException e)
    		 {
    			 System.out.println("An error occurred.");
    			 e.printStackTrace();
    		 }
    		 return flag_updatefood;
    	 }
    	 else
    	 {
    		 return flag_updatefood;
    	 }
         
    	 
     }
     
     
     
     public int countWords (String foodDescription)
     {
    	 StringTokenizer stringTokenizer1 = new StringTokenizer(foodDescription);
    	 return stringTokenizer1.countTokens();
     }
}