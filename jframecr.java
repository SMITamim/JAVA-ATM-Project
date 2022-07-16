
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;



class jframecr extends JFrame
{
	private Container c;
	private JLabel userlabel;
	private Font f;
	private JButton btn1,btn2;
	
	jframecr()
	{
		content();
	}
	 public void content()
	{    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     setSize(550,700);
		 setTitle("CREDIT");
		setResizable(false);
		 setLocationRelativeTo(null);
		
	     c=this.getContentPane();
	     c.setLayout(null);
		 c.setBackground(Color.pink);
		 userlabel=new JLabel();
		 userlabel.setText("WELCOME UCC BANK");
		 userlabel.setBounds(150,100,600,20);
		 f=new Font("Arial",Font.BOLD,25);
		 userlabel.setFont(f);
		 c.add(userlabel);
		 btn1=new JButton("CREATE ACCOUNT");
		 btn1.setBounds(200,200,150,50);
		 btn2=new JButton("LOGIN");
		 btn2.setBounds(200,300,150,50);
		 c.add(btn1);
		 c.add(btn2);
		 btn2.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent ae){
				
			 newframecr tree= new newframecr();
			 dispose();
			 tree.setVisible(true);
			 
			 
		 }});
		 btn1.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent ae){
		 registration reg=new registration();
				 reg.setVisible(true);
				 dispose();
			 }
		 }
		 );
		
		 
	}
	public static void main(String[] args)
	{
		jframe frame=new jframe();
		frame.setVisible(true);
		
	}
}