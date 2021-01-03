package User;

import java.io.*;

import javax.swing.JPasswordField;

public class password_yz {
	public password_yz(){
	}

	public boolean yzmm(String string, String string2) throws IOException {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("user.dat");
		BufferedReader br = new BufferedReader(fr);
		String x;
		while((x=br.readLine())!=null){
			String s[] = x.split(",");
			//System.out.println(s[0]+","+s[1]);
			if(s[0].equals(string)&&s[1].equals(string2)){
				return true;
			}else {continue;}
		}
		br.close();
		fr.close();
		return false;
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


