package User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class delbk {
	public delbk(String bookname) throws IOException{
		File f1 = new File("book.dat");
		File f2 = new File("temp.dat");
		FileReader fr = new FileReader(f1);
		BufferedReader br = new BufferedReader(fr);
		FileWriter fw1 = new FileWriter(f2, true);
		BufferedWriter bw1 = new BufferedWriter(fw1);
		String str = br.readLine();
		while (str != null) {
			String[] s = str.split(",");
			if (!bookname.equals(s[0])) {
				bw1.write(str);
				bw1.newLine();
			}
			str = br.readLine();
		}
		bw1.flush();fw1.close();
		br.close();
		fr.close();
		System.gc();       		
		f1.delete();
		f2.renameTo(f1);
	}
	}

