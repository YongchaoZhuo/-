package fileRead;
import java.io.*;//导入java.io包中的所有类
import java.util.Scanner;//导入java.util包中的Scanner类
public class delnull{//创建类名
	public delnull() throws IOException{//程序主函数入口
	    File f1 = new File("book.dat");
		File f2=new File("temp");//创建待写入文件		
		if(!f2.exists()) {//若指定路径下该文件不存在执行if语句
			f2.createNewFile();//在指定路径下新建该文件
			}	
		try{ //将逻辑语句用try包起来
        int i=0;//新建行号的符号i
		String string=null;//新建空字符串
		InputStreamReader isr=new InputStreamReader(new FileInputStream(f1),"GB2312");//选择编码方式，避免乱码
		BufferedReader read=new BufferedReader(isr);//写入数据流方式
		OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream(f2),"GB2312");//选择编码方式，避免乱码
		BufferedWriter write=new BufferedWriter(osw);//写入数据流方式
		while((string = read.readLine())!= null) {//readLine()方法,要读取的一行内容不为空就一直执行
			if(string.equals("")) {//if条件语句
			continue;//该行为空时不进行任何操作
			}
			else {//否则
			i++;
			write.write(string+"\r\n");//在新文档中写入指定内容			
			}
		}	
		write.close();//关闭流
		read.close();//关闭流
		System.gc();
		f1.delete();
		f2.renameTo(f1);
        }
		catch(Exception e) {
			
		}		
	}
}
