import javax.swing.JFrame;
import java.awt.Container;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.*;
class types extends JFrame
{
	private Container c;
	private JLabel lb,userlabel;
	private Font f1,f;
	private JButton btn1,btn2,btn3;
	types()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(550,700);
		setTitle("TYPES OF ACCOUNT");
		
		setLocationRelativeTo(null);
		c=this.getContentPane();
	    c.setLayout(null);
		c.setBackground(Color.pink);
		
		userlabel=new JLabel();
		userlabel.setText("**WELCOME UCC BANK**");
		userlabel.setBounds(100,70,600,20);
		f=new Font("Arial",Font.BOLD,25);
		userlabel.setFont(f);
		c.add(userlabel);
		lb=new JLabel("CHOOSE YOUR ACCOUNT");
		lb.setBounds(140,120,500,20);
		f1=new Font("Book Antiqua",Font.BOLD,20);
		lb.setFont(f1);
		c.add(lb);
		
		 btn1=new JButton("DEBIT ");
		 btn1.setBounds(160,180,180,50);
		 
		 c.add(btn1);
		 btn2=new JButton("CREDIT");
		 btn2.setBounds(160,260,180,50);
		 
		 c.add(btn2);
		 btn3=new JButton("SAVINGS");
		 btn3.setBounds(160,340,180,50);
		 
		 c.add(btn3);
	
	btn1.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{

				
				jframe jj=new jframe();
				dispose();
				jj.setVisible(true);
				
		    }

		
	});
	btn2.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				jframecr jj=new jframecr();
				dispose();
				jj.setVisible(true);
			}
	}
);
btn3.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				jframesa jj=new jframesa();
				dispose();
				jj.setVisible(true);
			}
	}
);
	}
public static void main(String[] args)
	{
		types ff=new types();
		ff.setVisible(true);
		
		
	}
}