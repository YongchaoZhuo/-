package fileRead;

import java.io.*;

public class fileWR {


	public void addBook(String str) throws IOException {
		File f1 = new File("book.dat");
		FileWriter fw = new FileWriter(f1, true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.newLine();
		bw.write(str);
		bw.flush();
		bw.close();
		System.gc();
	}



	public void changeBook(String a, String b) throws Exception {
		File f1 = new File("book.dat");
		 File f2 = new File("temp.dat");
		FileReader fr = new FileReader(f1);
		BufferedReader br = new BufferedReader(fr);
		FileWriter fw1 = new FileWriter(f2, true);
		BufferedWriter bw1 = new BufferedWriter(fw1);
		String str = br.readLine();
		while (str != null) {
			String[] s = str.split(",");
			if (a.equals(str)) {
				str = str.replaceAll(a, b);
			}
			bw1.write(str);
			bw1.newLine();
			str = br.readLine();
		}
		System.out.println("ÐÞ¸ÄÍê³É");
		bw1.flush();fw1.close();br.close();fr.close();
		System.gc();
		f1.delete();
		System.gc();
		f2.renameTo(f1);
	}

	public void show() throws Exception {
		File f1 = new File("book.dat");
		FileReader fr = new FileReader(f1);
		BufferedReader br = new BufferedReader(fr);
		String str = br.readLine();

		while (str != null) {
			String[] s = str.split(",");
			for (int i = 0; i < s.length; i++) {
				System.out.println(s[i] + i);
			}
			System.out.println(str);
			str = br.readLine();
		}
		br.close();
		fr.close();
		System.gc();
	}

	public String seach(String bookname) throws Exception {
		File f1 = new File("book.dat");
		FileReader fr = new FileReader(f1);
		BufferedReader br = new BufferedReader(fr);
		String str = br.readLine();
		String temp=null;
		System.out.println(bookname);
		while (str != null) {
			String[] s = str.split(",");
			try{
				if (bookname.equals(s[0])){ 
					temp = str;
					//111
					return temp;
					}
				else temp="er";
			}catch(Exception e){}
			str = br.readLine();
		}
		str = temp;
		br.close();
		fr.close();
		System.gc();
		return str;
	}
}
