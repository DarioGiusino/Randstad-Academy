package org.lessons;

public class Book {
	private String description;
	private String author;
	private Double sellPrice;
	
	public Book(String description, String author, Double sellPrice) {
		setDescription(description);
		setAuthor(author);
		setSellPrice(sellPrice);
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Double getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}
	@Override
	public String toString() {
		String s = "Descrizione libro: " + getDescription()
				+"\nAutore libro: " + getAuthor()
				+"\nPrezzo libro: " + getSellPrice()
				+"\n-------------------------------";
		return s;
	}
	
}
