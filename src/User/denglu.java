package User;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class denglu extends JFrame{
	 JPanel jp1, jp2, jp3,jp4;
	    JLabel jlb1, jlb2,jlb3,msg;
	    JButton jb1, jb2;
	    JTextField jtf1;
	    JPasswordField jpf1;
	    

	
	public denglu(){
		
		jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();

        jlb1 = new JLabel("�û���");
        jlb2 = new JLabel("��    ��");
        msg = new JLabel("����������");

        jb1 = new JButton("��¼");
        jb1.setVisible(false);
        jb1.addActionListener(new ActionListener() {
			//�ж������Ƿ���ȷ
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String userpass;
				userpass = jtf1.getText()+","+jpf1.getText();
				
				try {
					password_yz y = new password_yz();
					if(y.yzmm(jtf1.getText(),jpf1.getText())){
						System.out.println("��½�ɹ�");
						
						Program_main m = new Program_main();
						m.main(null);
						denglu.this.setVisible(false);
						
					}else{
						msg.setText("�������");
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
				//denglu.this.setVisible(false);
			}
		});
        jb2 = new JButton("ȡ��");
        jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				denglu.this.setVisible(false);
			}
		});

        jtf1 = new JTextField(10);
        jtf1.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				try {
					password_yz yz = new password_yz();
					if(yz.isT(jtf1.getText())){
						jb1.setVisible(false);
						msg.setText("�޸��˺ţ�����������");
					}else{
						jb1.setVisible(true);
						msg.setText("����������");
					}
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

        jpf1 = new JPasswordField(10);
      
        // ����������
        jp1.add(jlb1);
        jp1.add(jtf1);

        jp2.add(jlb2);
        jp2.add(jpf1);
        

        jp3.add(msg);

        jp4.add(jb1);
        jp4.add(jb2);
       

   
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        
		this.setLayout(new GridLayout(4,1));
		this.setTitle("��¼ҳ��");
		 this.setSize(400, 400);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setLocation(100, 100);
	        JLabel jl=new JLabel("ͼ�����ϵͳ",JLabel.CENTER);
			jl.setFont(new Font("����", Font.BOLD, 24));
			jl.setForeground(Color.white);
	        this.setVisible(true);
	}

}

