import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Container;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.JButton;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.awt.event.*;
import java.io.RandomAccessFile;
import java.io.*;  
import javax.swing.JOptionPane; 
import java.util.Calendar;
import javax.swing.JPasswordField;


class registration extends JFrame
{
	private Container c;
	private JLabel name,pass,DOB,NM;
	private Font f1,f;
	private JTextField t,t2,t3;
	private JPasswordField t1;
	private JButton crt,back,login;
    private JTextField jf;
	
	
	
registration()
{
	
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(550,700);
		setTitle("DEBIT");
		setResizable(false);
		setLocationRelativeTo(null);
		c=this.getContentPane();
	    c.setLayout(null);
		c.setBackground(Color.pink);
		name=new JLabel("Name:");
		name.setBounds(50,160,600,20);
		f1=new Font("Book Antiqua",Font.BOLD,19);
		name.setFont(f1);
		c.add(name);
		t= new JTextField();
		f=new Font("Arial",Font.PLAIN,15);
		t.setFont(f);
		t.setBounds(170,160,160,28);
		c.add(t);
		pass=new JLabel("Password:");
		pass.setBounds(50,220,600,20);
		f1=new Font("Book Antiqua",Font.BOLD,19);
		pass.setFont(f1);
		c.add(pass);
		t1= new JPasswordField();
		f=new Font("Arial",Font.PLAIN,15);
		t1.setFont(f);
		t1.setBounds(170,220,160,28);
		c.add(t1);
		NM=new JLabel("Nominee:");
		NM.setBounds(50,340,600,20);
		f1=new Font("Book Antiqua",Font.BOLD,19);
		NM.setFont(f1);
		c.add(NM);
		t2= new JTextField();
		f=new Font("Arial",Font.PLAIN,15);
		t2.setFont(f);
		t2.setBounds(170,340,160,28);
		c.add(t2);
		DOB=new JLabel("Date of birth:");
		DOB.setBounds(50,280,600,20);
		f1=new Font("Book Antiqua",Font.BOLD,19);
		DOB.setFont(f1);
		c.add(DOB);
		
		t3= new JTextField();
		t3.setBounds(170,280,160,28);
		f=new Font("Arial",Font.PLAIN,15);
		t3.setFont(f);
		c.add(t3);
		
		
		crt=new JButton("create account");
		crt.setBounds(100,540,100,60);
		c.add(crt);
		login=new JButton("LOGIN");
		login.setBounds(400,540,100,50);
		c.add(login);
		back=new JButton("BACK");
		back.setBounds(400,20,100,50);
		c.add(back);


	crt.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
				{
					
				readFile();
			    addData(t.getText(), t1.getText(), t2.getText(),t3.getText());
			    countLines();
			    JOptionPane.showMessageDialog(null,"Account created");
				}
	}
);
login.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				newframe tt=new newframe();
				dispose();
				tt.setVisible(true);
			}
	}
);
back.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
             jframe ff=new jframe();
			 dispose();
			 ff.setVisible(true);
				
		    }

		
	});
}
	

	String Name,Password;
	static int initial=1001;
	
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
	
	void addData(String name, String password, String nominee,String date )
	{
		try{
			RandomAccessFile raf = new RandomAccessFile("login.txt","rw");
			for(int i = 0; i<ln; i++)
			{
				raf.readLine();
			}
		    Calendar c= Calendar.getInstance();
            int year=c.get(Calendar.YEAR);
            int month=c.get(Calendar.MONTH);
            String ID=month+"-"+initial+"-"+year;
            System.out.println(ID);
            initial++;
			raf.writeBytes("User id:" +ID+"\r\n");
			raf.writeBytes("Password:" +password+"\r\n");
			raf.writeBytes("Name:" +name+"\r\n");
			raf.writeBytes("Date of birth:" +date+"\r\n");
			raf.writeBytes("Nominee:" +nominee+"\r\n");
			raf.writeBytes("\r\n");
			raf.writeBytes("\r\n");

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
		registration d=new registration();
		d.setVisible(true);
		
		
	}
}