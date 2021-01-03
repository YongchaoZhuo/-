package fileRead;


public class Book 
{
	public String num;
	public String name;
	public String author;
	public String price;
	public String state;
	
	public Book(String name,String num,String author,String price,String state)
	{
		this.num = num;
		this.name = name;
		this.author = author;
		this.price = price;
		this.state = state;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getState() {
		return state;
	}

	public void setState( String state) {
		this.state = state;
	}

}
