package fileRead;

import java.io.IOException;
import java.util.Scanner;

import User.delbk;
import User.mymsg;

public class fileChange {
	public static void main(String[] args) throws Exception{
		
	}
	
	public fileChange(String name,String num,String author,String price,String state) throws IOException{
		fileWR f = new fileWR();
		String information = name+","+num+","+author+","+price+","+state;
		//System.out.println(information);
		f.addBook(information);
	}
	public fileChange(String name) throws Exception{
		fileWR f = new fileWR();
		if(f.seach(name).equals("er")){
			mymsg m= new mymsg("ɾ��ʧ�ܣ����޴���");
		}else{
			delbk d = new delbk(name);
			mymsg m= new mymsg("ɾ���ɹ�");
		}
	}
	public String seach(String name,int a) throws Exception{
		fileWR f = new fileWR();
		if(f.seach(name).equals("er")){
			return "��ͼ������޴���";
		}else{
			return f.seach(name);
		}
		
}
	
	public fileChange(String a,String name,String num,String author,String price,String state) throws Exception{
		fileWR f = new fileWR();
		String b = name+','+num+','+author+','+price+","+state;
		if(f.seach(name).equals("er")){
			mymsg m= new mymsg("�޸�ʧ�ܣ����޴���");
		}else{
			f.changeBook(a,b);
			mymsg m= new mymsg("�޸ĳɹ�");
		}
	}
	public fileChange(){}
}
		


