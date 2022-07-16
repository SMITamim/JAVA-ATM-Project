import javax.swing.JFrame;
import java.awt.Container;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.io.*;   
import java.io.IOException; 
import java.io.RandomAccessFile;
import javax.swing.JPasswordField;
class newframe extends JFrame
{
	private Container c;
	private JLabel lbl3,lbl4,lbl5;
	private Font f1,f2,f;
	private JTextField t;
	private JPasswordField t1;
	private JButton btn2,back;
	newframe()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(550,700);
		setTitle("DEBIT");
		setResizable(false);
		setLocationRelativeTo(null);
		c=this.getContentPane();
	    c.setLayout(null);
		c.setBackground(Color.pink);
		lbl3=new JLabel("BANK");
		lbl3.setBounds(230,70,500,20);
		f1=new Font("Arial",Font.BOLD,25);
		lbl3.setFont(f1);
		c.add(lbl3);
		lbl4=new JLabel("Enter Your User ID:");
		lbl4.setBounds(40,160,500,19);
		f2=new Font("Book Antiqua",Font.BOLD,19);
		lbl4.setFont(f2);
		c.add(lbl4);
		t= new JTextField();
		f=new Font("Arial",Font.PLAIN,15);
		t.setFont(f);
		t.setBounds(250,160,160,25);
		c.add(t);
		lbl5=new JLabel("Enter Your Password:");
		lbl5.setBounds(40,220,500,20);
		f2=new Font("Book Antiqua",Font.BOLD,19);
		lbl5.setFont(f2);
		c.add(lbl5);
		t1= new JPasswordField();
		f=new Font("Arial",Font.PLAIN,15);
		t1.setFont(f);
		t1.setBounds(250,220,160,25);
		c.add(t1);
		btn2=new JButton("LOGIN");
		 btn2.setBounds(220,340,100,50);
		 
		 c.add(btn2);
		 back=new JButton("BACK");
		 back.setBounds(20,10,100,50);
		 
		 c.add(back);
	
	btn2.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{

				
				readFile();
				countLines();
				logic(t.getText(), t1.getText());
				
		    }

		
	});
	back.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				registration tt=new registration();
				dispose();
				tt.setVisible(true);
			}
	}
);
	}
	
	String Name,Password;
	int ln;
	
	
	
		void readFile()
	{
		try{
			FileReader fr = new FileReader("login.txt");
			System.out.println("file exists!");
			
		}
		catch(FileNotFoundException ex){
			try{
				FileWriter fw = new FileWriter("login.txt");
				System.out.println("file created");
				
			}
			catch(IOException ex1){
				
				ex1.printStackTrace();
			}
			
		}
	}
	void countLines()
	{
		try{
			
			ln = 1;
            RandomAccessFile raf = new RandomAccessFile("login.txt", "rw");
            for(int i=0; raf.readLine()!=null;i++)
            {
	            ln++;
            }	
			System.out.println("number of lines");

		}
		catch(FileNotFoundException ex)
		{
			ex.printStackTrace();
		}
		catch(IOException ex1)
		{
			ex1.printStackTrace();
		}
	}
	
				
		   
		
				 
	
	void logic(String usr, String pswd)
	{
		try{
			RandomAccessFile raf = new RandomAccessFile("login.txt", "rw");
			boolean notFound=true;
			for(int i=0; i<ln; i+=8)
			{
				notFound=true;
				System.out.println("count "+i);
				String forUser = raf.readLine().substring(8);
				String forPswd = raf.readLine().substring(9);
				if(usr.equals(forUser)&pswd.equals(forPswd))
				{
					JOptionPane.showMessageDialog(null,"password matched");
					notFound=false;
					debit dd=new debit();
			        dispose();
			        dd.setVisible(true);
					break;
				}
				
				
				
				for(int k=1; k<=5; k++)
				{
					raf.readLine();
				}
			   }
				if(notFound)
				{
						JOptionPane.showMessageDialog(null,"Wrong password");
				}
				
			}
			
		
		catch(FileNotFoundException ex){
			
			ex.printStackTrace();
		}
		catch(IOException ex1){
			
			ex1.printStackTrace();
		}
		
	}
	public static void main(String[] args)
	{
		newframe ff=new newframe();
		ff.setVisible(true);
		
		
	}
}