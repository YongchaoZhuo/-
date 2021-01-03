package fileRead;
import java.io.*;
import java.util.*;

import User.mymsg;

public class BookDeal 
{
	public Book findBookByNum(String num)
	{
		Book result=null;
		try
		{
			FileReader fr=new FileReader("book.dat");
			BufferedReader br=new BufferedReader(fr);
			String temp=br.readLine();
			while(temp!=null)
			{
				String[]infos=temp.split(",");
				if(infos[0].equals(num))
				{
					result=new Book(infos[0],infos[1],infos[2],infos[3],infos[4]);
					break;
				}
				temp=br.readLine();
			}
			br.close();
			fr.close();
		}
		catch(FileNotFoundException ex)
		{
		}
		catch(IOException ex)
		{	
		}
		return result;
	}

	public Book[] findBooksByNameAt(String name)
	{
		ArrayList<Book> result=new ArrayList<Book>();
		try
		{
			FileReader fr=new FileReader("book.dat");
			BufferedReader br=new BufferedReader(fr);
			String temp=br.readLine();
			while(temp!=null)
			{
				String[]infos=temp.split(",");
				if(infos[1].contains(name))
				{
					result.add(new Book(infos[0],infos[1],infos[2],infos[3],infos[4]));
				}
				temp=br.readLine();
			}
			br.close();
			fr.close();
		}
		catch(FileNotFoundException ex)
		{
		}
		catch(IOException ex)
		{	
		}
		return (Book[])result.toArray(new Book[result.size()]);
	}
	
	public Book[] findBookByAuthor(String author)
	{
		ArrayList<Book> result=new ArrayList<Book>();
		try
		{
			FileReader fr=new FileReader("book.dat");
			BufferedReader br=new BufferedReader(fr);
			String temp=br.readLine();
			while(temp!=null)
			{
				String[]infos=temp.split(",");
				if(infos[2].equals(author))
				{
					result.add(new Book(infos[0],infos[1],infos[2],infos[3],infos[4]));
				}
				temp=br.readLine();
			}
			br.close();
			fr.close();
		}
		catch(FileNotFoundException ex)
		{
		}
		catch(IOException ex)
		{	
		}
		return (Book[])result.toArray(new Book[result.size()]);
	}
	
	public ArrayList<Book>  findAllBooks()
	{
		ArrayList<Book> result=new ArrayList<Book>();
		try
		{
			FileReader fr=new FileReader("book.dat");
			BufferedReader br=new BufferedReader(fr);
			String temp=br.readLine();
			while(temp!=null)
			{
				String[] infos=temp.split(",");
				result.add(new Book(infos[0],infos[1],infos[2],infos[3],infos[4]));
				temp=br.readLine();
			}
			br.close();
			fr.close();
		}
		catch(FileNotFoundException ex)
		{
		}
		catch(IOException ex)
		{	
		}
		return result;
	}
	
	private boolean checkNumIsExist(String num)
	{
		boolean result=false;
		try
		{
			FileReader fr=new FileReader("book.dat");
			BufferedReader br=new BufferedReader(fr);
			String temp=br.readLine();
			while(temp!=null)
			{
				String[] infos=temp.split(",");
				if(infos[0].equals(num))
				{
					result=true;
					break;
				}
				temp=br.readLine();
			}
			br.close();
			fr.close();
		}
		catch(FileNotFoundException ex)
		{
		}
		catch(IOException ex)
		{	
		}
		return result;
	}
	
	private boolean checkNameIsExist(String name)
	{
		boolean result=false;
		try
		{
			FileReader fr=new FileReader("book.dat");
			BufferedReader br=new BufferedReader(fr);
			String temp=br.readLine();
			while(temp!=null)
			{
				String[] infos=temp.split(",");
				if(infos[0].equals(name))
				{
					result=true;
					break;
				}
				temp=br.readLine();
			}
			br.close();
			fr.close();
		}
		catch(FileNotFoundException ex)
		{
		}
		catch(IOException ex)
		{	
		}
		
		return result;
	}
	
	public void addBook(Book book)
	{
		System.gc();
		try {
			delnull dn = new delnull();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!checkNumIsExist(book.num))
		{
			try
			{
				FileWriter fw=new FileWriter("book.dat",true);
				BufferedWriter bw = new BufferedWriter(fw);
				StringBuffer str=new StringBuffer();
				str.append(book.name+",");
				str.append(book.num+",");
				str.append(book.author+",");
				str.append(book.price+",");
				str.append(book.state);
				bw.newLine();
				bw.write(str.toString());
				bw.close();
				fw.close();
				delnull dn1 = new delnull();
			}
			catch(FileNotFoundException ex)
			{
			}
			catch(IOException ex)
			{	
			}
		}
	}
	
	public void delBookByName(String name)
	{
		if(checkNameIsExist(name))
		{
			ArrayList<Book> books=findAllBooks();
			for(int i=0;i<books.size();i++)
			{
				Book temp=(Book)books.get(i);
				if(temp.name.equals(name))
				{
					books.remove(temp);
					break;
				}
			}
			try {
				FileWriter fw = new FileWriter("book.dat");
				BufferedWriter bw = new BufferedWriter(fw);
				for(int i=0;i<books.size();i++)
				{
					Book temp=(Book)books.get(i);
					StringBuffer str=new StringBuffer();
					str.append(temp.name+",");
					str.append(temp.num+",");
					str.append(temp.author+",");
					str.append(temp.price+",");
					str.append(temp.state);
					bw.write(str.toString());
					bw.newLine();
				}
				bw.close();
				fw.close();
				System.gc();
				delnull d = new delnull();
			} 
			catch(FileNotFoundException ex)
			{
			}
			catch(IOException ex)
			{	
			}
			
		}
	}
	public void updateBook(Book book)
	{
		delBookByName(book.name);
		addBook(book);
	}
	
	public void updateBooks(Book[] books)
	{
		if(books.length>0)
		{
			for(int i=0;i<books.length;i++)
			{
				updateBook(books[i]);
			}
		}
	}
	
	public void delStus(String[] names)
	{
		if(names.length>0)
		{
			for(int i=0;i<names.length;i++)
			{
				delBookByName(names[i]);
			}
		}
	}
}

