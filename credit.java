import javax.swing.JFrame;
import java.awt.Container;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.*;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
class credit extends JFrame
{
	private Container c;
	private Font f2;
	double balance=00;
	double curbalance; 
	private JTextField tx;
	private JButton d,w,ex,back;
	credit()
{
		
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(550,700);
		setTitle("CREDIT");
		setResizable(false);
		setLocationRelativeTo(null);
		c=this.getContentPane();
	    c.setLayout(null);
		c.setBackground(Color.pink);
		d=new JButton("DEPOSITE");
		d.setBounds(70,350,100,50);
		c.add(d);
		w=new JButton("WITHDRAW");
		w.setBounds(350,350,100,50);
		c.add(w);
		tx= new JTextField();
		tx.setBounds(180,250,130,40);
		tx.setBackground(Color.BLACK);
		tx.setForeground(Color.WHITE);
		f2=new Font("Arial",Font.BOLD,18);
		tx.setFont(f2);
		c.add(tx);
		ex=new JButton("EXIT");
		ex.setBounds(400,20,100,50);
		c.add(ex);
		back=new JButton("BACK");
		back.setBounds(10,20,100,50);
		c.add(back);
		d.addActionListener(new ActionListener() 
		{
			@Override
			
			public void actionPerformed(ActionEvent e)
			{
             String amount=tx.getText();
			 double deposite=Double.parseDouble(amount);
			 
	
			curbalance=balance+deposite;
			 balance=curbalance;
			 JOptionPane.showMessageDialog(null,"this is your current balance:::::"+balance);
		     System.out.println(balance);
		
		    }
		
			
		}
		
		);
		w.addActionListener(new ActionListener() 
		{
			@Override
			
			public void actionPerformed(ActionEvent e)
			{
             String amount=tx.getText();
			 double withdraw=Double.parseDouble(amount);
			 
		    if(withdraw<=balance)
		   {
			if(withdraw<=balance/2)
			{
			
			curbalance = balance - withdraw;
			balance=curbalance;
			System.out.println("This is your Current balance");
			 JOptionPane.showMessageDialog(null,"this is your current balance:::::"+balance);
		     System.out.println(balance);
		
			
			}
			else
			{
				System.out.println("Can't withdraw more than 50% of your balance");
				System.out.println(balance);
				
			}
		}
		else if(withdraw>balance)
		{
			
			
			
			curbalance = curbalance+100000;
			balance=curbalance;
			System.out.println("This is your remaining credit");
			System.out.println(balance);
			
			if(withdraw<=balance/2)
			{
			curbalance = balance-withdraw;
			balance=curbalance;
			System.out.println("Withdraw Successful");
			
			System.out.println(balance);
			
			}
			else
			{
				System.out.println("Can't withdraw more than 50% of your balance");
				System.out.println(balance);
				
			}
			
			
		}
		else
		{
			System.out.println("Insuficient balance");
			System.out.println(balance);
			
		}
	    }
		}
		
		);
		back.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
             types ff=new types();
			 dispose();
			 ff.setVisible(true);
				
		    }

		
	});
		ex.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
	}
);
		
		}
		
		public static void main(String[] args)
	{
		credit d=new credit();
		d.setVisible(true);
		
		
	}
}
