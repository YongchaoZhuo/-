package User;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class reg extends JFrame{
	 JPanel jp1, jp2, jp3,jp4;
	    JLabel jlb1, jlb2,jlb3,msg;
	    JButton jb1, jb2;
	    JTextField jtf1;
	    JPasswordField jpf1,jpf2;
	    

	
	public reg(){
		
		jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();

        jlb1 = new JLabel("�û���");
        jlb2 = new JLabel("��    ��");
        jlb3 = new JLabel("ȷ������");
        msg = new JLabel("��������������");

        jb1 = new JButton("ע��");
        jb1.setVisible(false);
        jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String userpass;
				userpass = jtf1.getText()+","+jpf1.getText();
				
				try {
					userwriter uw = new userwriter(userpass);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				reg.this.setVisible(false);
			}
		});
        jb2 = new JButton("ȡ��");
        jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				reg.this.setVisible(false);
			}
		});

        jtf1 = new JTextField(10);
        jtf1.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				try {
					userwriter u1 = new userwriter();
					if(u1.isT(jtf1.getText())){
						jb1.setVisible(true);
						msg.setText("�˺�������");
					}else{
						jb1.setVisible(false);
						msg.setText("���и��˺���������������");
					}
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
       
        jpf1 = new JPasswordField(10);
        jpf2 = new JPasswordField(10);
        jpf2.addKeyListener(new KeyListener() {
			
			public void keyPressed(FocusEvent e) {
				if(!jpf2.getText().equals(jpf1.getText())){
					msg.setText("�������벻һ�£���������������");
					System.out.println(jpf2.getText());
				}else{
					msg.setText("��");
				}
			}
			
			

			@Override
			public void keyTyped(KeyEvent e) {				
			}

			@Override
			public void keyPressed(KeyEvent e) {				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(!jpf2.getText().equals(jpf1.getText())){
					msg.setText("�������벻һ�£���������������");
				}else{
					msg.setText("�̡�");
					System.out.println("��������һ��");
				}
			}
		});

        // ����������
        jp1.add(jlb1);
        jp1.add(jtf1);

        jp2.add(jlb2);
        jp2.add(jpf1);
        
        jp3.add(jlb3);
        jp3.add(jpf2);
        jp3.add(msg);

        jp4.add(jb1);
        jp4.add(jb2);

   
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        
		this.setLayout(new GridLayout(4,1));
		this.setTitle("ע��ҳ��");
		 this.setSize(400, 400);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setLocation(100, 100);
	        JLabel jl=new JLabel("ͼ�����ϵͳ",JLabel.CENTER);
			jl.setFont(new Font("����", Font.BOLD, 24));
			jl.setForeground(Color.white);
	        this.setVisible(true);
	}
}
