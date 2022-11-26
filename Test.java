package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * DONE BY HOA TO
 * 
 * Test class for WebCrawler and WebScrapper
 * 
 */

public class Test 
{
	public static void main(String[] args) throws IOException 
	{
		String url = "https://www.bestbuy.ca/en-ca";
		String product="";
		int searchPage;
		List<Product> products = new ArrayList<>();
		WebCrawler obj = new WebCrawler();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("*****************************************************");
        System.out.println("************ BEST BUY PRODUCTS FETCHER **************");
        System.out.println("*****************************************************");
        
        
        System.out.print("\nSearch product: ");
        product = sc.next();
        
        System.out.println("\nCRAWLING FOR RELEVANT LINK.....\n");
        obj.crawl(url,product);
        System.out.println("\nLINK FOUND!!\n");
        
        System.out.println("Starting link: "+obj.resultLink);
        
        System.out.println("Number of pages to search: ");
        searchPage = sc.nextInt();
        
        System.out.println("\nFETCHING PRODUCTS.....\n");
        products = WebScrapper.getItems(obj.resultLink, products, searchPage);
        
        System.out.println("\nShowing products from "+searchPage+" page(s):\n");
        
        for(Product p : products)
		{
			System.out.println("Item: "+p.getName());
			System.out.println("Price: "+p.getFormattedPrice());
			System.out.println("Financing type: "+p.getPaymentType());
			System.out.println("Link: "+p.getLink()+"\n");
		}
        
	}
}
