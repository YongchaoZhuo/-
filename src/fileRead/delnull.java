package fileRead;
import java.io.*;//����java.io���е�������
import java.util.Scanner;//����java.util���е�Scanner��
public class delnull{//��������
	public delnull() throws IOException{//�������������
	    File f1 = new File("book.dat");
		File f2=new File("temp");//������д���ļ�		
		if(!f2.exists()) {//��ָ��·���¸��ļ�������ִ��if���
			f2.createNewFile();//��ָ��·�����½����ļ�
			}	
		try{ //���߼������try������
        int i=0;//�½��кŵķ���i
		String string=null;//�½����ַ���
		InputStreamReader isr=new InputStreamReader(new FileInputStream(f1),"GB2312");//ѡ����뷽ʽ����������
		BufferedReader read=new BufferedReader(isr);//д����������ʽ
		OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream(f2),"GB2312");//ѡ����뷽ʽ����������
		BufferedWriter write=new BufferedWriter(osw);//д����������ʽ
		while((string = read.readLine())!= null) {//readLine()����,Ҫ��ȡ��һ�����ݲ�Ϊ�վ�һֱִ��
			if(string.equals("")) {//if�������
			continue;//����Ϊ��ʱ�������κβ���
			}
			else {//����
			i++;
			write.write(string+"\r\n");//�����ĵ���д��ָ������			
			}
		}	
		write.close();//�ر���
		read.close();//�ر���
		System.gc();
		f1.delete();
		f2.renameTo(f1);
        }
		catch(Exception e) {
			
		}		
	}
}
