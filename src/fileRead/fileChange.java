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
			mymsg m= new mymsg("删除失败，查无此书");
		}else{
			delbk d = new delbk(name);
			mymsg m= new mymsg("删除成功");
		}
	}
	public String seach(String name,int a) throws Exception{
		fileWR f = new fileWR();
		if(f.seach(name).equals("er")){
			return "本图书馆暂无此书";
		}else{
			return f.seach(name);
		}
		
}
	
	public fileChange(String a,String name,String num,String author,String price,String state) throws Exception{
		fileWR f = new fileWR();
		String b = name+','+num+','+author+','+price+","+state;
		if(f.seach(name).equals("er")){
			mymsg m= new mymsg("修改失败，查无此书");
		}else{
			f.changeBook(a,b);
			mymsg m= new mymsg("修改成功");
		}
	}
	public fileChange(){}
}
		


