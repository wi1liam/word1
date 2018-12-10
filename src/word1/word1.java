package word1;



import javax.swing.*;
import java.util.Random;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class word1 extends JFrame{
	
	JFrame f=new JFrame();
	JPanel jpanel1 = new JPanel();
	int d;
	int speed=10;
	int score=0;
	public word1(){
		gameInit();
	}
	
	public void run()
	{
		f.addKeyListener(new KeyListener() {
				
				  public void keyReleased(KeyEvent e) {
					  	  if (e.getKeyCode() == 34) {
					  		speed=5;
			      }
					  
				  }
			  //键被按下
			  public void keyPressed(KeyEvent e) {
			      // TODO Auto-generated method stub

			  }

			  // 一个按下弹起的组合动作
			  public void keyTyped(KeyEvent e) {

			  }
			});
		f.addKeyListener(new KeyListener() {
			
			  public void keyReleased(KeyEvent e) {
				  	  if (e.getKeyCode() == 33) {
				  		speed=20;
		      }
				  
			  }
		  //键被按下
		  public void keyPressed(KeyEvent e) {
		      // TODO Auto-generated method stub

		  }

		  // 一个按下弹起的组合动作
		  public void keyTyped(KeyEvent e) {

		  }
		});
		for(d=0;d<10;d++)
		{
			try{
				Random rand = new Random();
				int x=rand.nextInt(3000)+1000;
				Thread.sleep(x); //每隔400ms的时间；
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
		myThread z=new myThread();
		//new Thread(battle1)
		new Thread(z).start();
		/*myThread c=new myThread();
		c.run();
		myThread d=new myThread();
		d.run();*/
		}
	}
	private void gameInit(){

		f.setSize(500, 500);
		f.setLocation(580, 200);
		f.setTitle("alphabet game");
		f.setLayout(null);
		
		
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		jpanel1.setBounds(new Rectangle(4, 4, 500,500));
		f.add(jpanel1);

	}
		public static void main(String[] args){
			word1 x=new word1();
			x.run();
		}


class myThread implements Runnable{

	JLabel show = new JLabel(); 

	public  myThread()
	{
		
		show.setFont(new java.awt.Font("宋体",Font.PLAIN, 33));
		jpanel1.add(show);
		
		
	}
	int s;
	int p=0;
public void run(){
	
	char c=(char)('A'+Math.random()*('Z'-'A'+1));
	String pst =String.valueOf(c);
	show.setText(pst);
	int x=(int)(Math.random()*500);
int y= 0; 

boolean fo = true;
//Integer.valueOf(zifu)
int a=Integer.valueOf(c);


show.setVisible(true);


	s=speed;
while(fo)
{
	
  if(s==0&&p==0)
  {
	  score++;
	  p=1;
  }
	show.setBounds(x, y=y+s, 33, 33); //可见JLabel每次移动的距离为z；
	try{
		Thread.sleep(400); //每隔400ms的时间；
	}catch(InterruptedException e){
		e.printStackTrace();
	}

	f.addKeyListener(new KeyListener() {
		
		  public void keyReleased(KeyEvent e) {
			  	  if (e.getKeyCode() == a) {
          	 show.setVisible(false);
          	 s=0;
          
         
            }
			  	  
        
        }

        //键被按下
        public void keyPressed(KeyEvent e) {
            // TODO Auto-generated method stub
      
        }

        // 一个按下弹起的组合动作
        public void keyTyped(KeyEvent e) {

        }
	});
	
	if(y >= 350){  //落到一定高度，停止；
		
		break;
	}
}
int option = JOptionPane.showConfirmDialog(f, "得分为"+score);
try{
	Thread.sleep(40); //每隔400ms的时间；
}catch(InterruptedException e){
	e.printStackTrace();
}
System.exit(0);

}


}

}