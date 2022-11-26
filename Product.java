package main;

/*
 * DONE BY HOA TO
 * 
 * Product class
 * 
 * Store a product's name, price, pricing type and buying links
 */

public class Product 
{
	public String name;
	public String link;
	public String formattedPrice;
	public String paymentType;
	
	public String getName()
	{
		return name;
    }
	 
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getLink() 
	{
		return link;
	}

	public void setLink(String link) 
	{
		this.link = link;
	}

	public String getFormattedPrice() 
	{
		return formattedPrice;
	}

	public void setFormattedPrice(String formattedPrice) 
	{
		this.formattedPrice = formattedPrice;
	}
	
	public String getPaymentType()
	{
		return paymentType;
	}
	
	public void setPaymentType(String type)
	{
		this.paymentType = type;
	}
}
