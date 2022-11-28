package main;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class DataValidation 
{
	public static boolean brandNameValidation(String textfile) 
	{
        // Create a Pattern object
         Pattern r = Pattern.compile("^[a-z-]+$");
         Boolean valuefound = false;


        // Now create matcher object.
         Matcher m = r.matcher(textfile);
             while (m.find( )) {
                 System.out.println("Found the brand name : " + m.group(0));
                 valuefound = true;
             }
             return valuefound;
         
     }

    public static boolean priceValidation(String textfile) 
    {
         String pattern = "^\\d{0,8}(\\.\\d{1,4})?$";
         Boolean valuefound = false;



        // Create a Pattern object
         Pattern r = Pattern.compile(pattern);



        // Now create matcher object.
         Matcher m = r.matcher(textfile);
         while (m.find( )) {
             System.out.println("Found the price range : " + m.group(0));
             valuefound = true;
         }
         return valuefound;
     } 
    
    public static boolean memoryValidation(String memory) 
    {
         String pattern = "^\\d{2,3}$";
         Boolean valuefound = false;

        // Create a Pattern object
         Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
         Matcher m = r.matcher(memory);
         while (m.find( )) 
         {
        	 if((Integer.parseInt(memory)) % 64 == 0)
        		 valuefound = true;
         }
         return valuefound;
     } 
    
    public static void main(String[] args) throws IOException 
    {
    	String url = "https://www.bestbuy.ca/en-ca/category/best-buy-mobile/20006";
    	Document bestBuy = Jsoup.connect(url).get();
    	Scanner input = new Scanner(System.in);
    	String txt= bestBuy.body().text();
    	String brand;
    	String price;
    	String memory;
    	/*
    	System.out.print("Enter a brand name: ");
    	brand = input.next();
    	
    	System.out.print(brandNameValidation(brand));
    	System.out.print("\nEnter a price: ");
    	price = input.next();
    	System.out.print(priceValidation(price));
    	*/
    	System.out.print("\nEnter memory: ");
    	memory = input.next();
    	while(memoryValidation(memory)== false)
    	{
    		System.out.print("\nInvalid value. Enter memory again: ");
        	memory = input.next();
    	}
    	
    	
    	
	}
}
