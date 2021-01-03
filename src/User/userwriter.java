package User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class userwriter {
	public userwriter(String str1) throws IOException{
			
	FileWriter fw = new FileWriter("user.dat",true);
	BufferedWriter bw = new BufferedWriter(fw);
	fw.write(str1+"\n");
	System.out.println("×¢²áÍê³É");
	bw.flush();
	bw.close();
	fw.close();
}
	public userwriter(){
		
	}
	public static boolean isT(String user) throws IOException{
		FileReader fr = new FileReader("user.dat");
		BufferedReader br = new BufferedReader(fr);
		String x;
		boolean r_B = false;
		while((x=br.readLine())!=null){
			String s[] = x.split(",");
			if(user.equals(s[0])){
				r_B = false;
			}else{
				r_B = true;
			}
			if(!r_B){
				break;
			}
		}
		br.close();
		fr.close();
	return r_B;
	}
}
