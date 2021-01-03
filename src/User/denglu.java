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

        jlb1 = new JLabel("用户名");
        jlb2 = new JLabel("密    码");
        msg = new JLabel("请输入密码");

        jb1 = new JButton("登录");
        jb1.setVisible(false);
        jb1.addActionListener(new ActionListener() {
			//判断密码是否正确
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String userpass;
				userpass = jtf1.getText()+","+jpf1.getText();
				
				try {
					password_yz y = new password_yz();
					if(y.yzmm(jtf1.getText(),jpf1.getText())){
						System.out.println("登陆成功");
						
						Program_main m = new Program_main();
						m.main(null);
						denglu.this.setVisible(false);
						
					}else{
						msg.setText("密码错误");
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
				//denglu.this.setVisible(false);
			}
		});
        jb2 = new JButton("取消");
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
						msg.setText("无该账号，请重新输入");
					}else{
						jb1.setVisible(true);
						msg.setText("请输入密码");
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
      
        // 加入各个组件
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
		this.setTitle("登录页面");
		 this.setSize(400, 400);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setLocation(100, 100);
	        JLabel jl=new JLabel("图书管理系统",JLabel.CENTER);
			jl.setFont(new Font("楷体", Font.BOLD, 24));
			jl.setForeground(Color.white);
	        this.setVisible(true);
	}

}

