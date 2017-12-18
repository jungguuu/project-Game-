package project;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Vector;
 
class MainFrame extends JFrame implements MouseListener, Runnable{

 private int x, y;
 public int a,b,c,d,ee,sum;
 public int f=0;
 private Vector<Point> v = new Vector<Point>();
 public int i=0;
 

 private JLabel label_title = new JLabel(); //���� Ÿ��Ʋ ǥ�ÿ� ��
 private JLabel label_time = new JLabel(); //���� Ÿ��Ʋ ǥ�ÿ� ��
 private JLabel label_gameover = new JLabel(); //���ӿ��� ǥ�ÿ� ��
 private JLabel label_countDown = new JLabel(); //ī��Ʈ�ٿ� ǥ�ÿ� ��
 private JLabel label_gamestart = new JLabel(); //���ӽ��� ǥ�ÿ� ��
 
 private JButton button_start = new JButton("START"); //���� ���� ��ư
 private JButton button_reset = new JButton("RESET"); //���� ���� ��ư
 

 public Image img1;
 public Image img2;


 private JButton button_level1 = new JButton("START!!"); 
 private JButton button_home = new JButton("HOME");

 Thread th;


 ImagePanel1 screen_left; 
 ImagePanel2 screen_right; 

 
 ImagePanel_main mainScreen;
 



 class countDownThread extends Thread {
  private JLabel label_countDown;
  private JLabel label_gamestart;
  private int count;

 

  public countDownThread(JLabel label_countDown,JLabel label_gamestart) {
   this.label_countDown = label_countDown;
   this.label_gamestart = label_gamestart;
  }

  

  @Override
  public void run() {
   count=3;

    while(true) {
     label_countDown.setVisible(true);
     label_countDown.setText(Integer.toString(count));
     count--;
     try {
      Thread.sleep(1000);
      if(count == 0) {
       label_countDown.setVisible(false);
       label_gamestart.setVisible(true);
       label_gamestart.setText("Game Start!!");
       return;
      }  
     }

     catch(InterruptedException e) {     
      return;

     }

    }
  }

 }
 
 class TimerThread extends Thread {

  private JLabel label_time;
  private JLabel label_gameover;
  private JLabel label_countDown;
  private JLabel label_gamestart;
  
  private int n;
  
  
  
  private boolean type = true;
  private boolean t=true;
  
  public TimerThread(JLabel label_time , JLabel label_gameover,JLabel label_countDown,JLabel label_gamestart) {
   this.label_time = label_time;
   this.label_gameover = label_gameover;
   this.label_countDown = label_countDown;
   this.label_gamestart = label_gamestart;
  }

  public String img_l[] = {"images/left_1.jpg","images/left_2.jpg","images/left_3.jpg","images/left_4.jpg","images/left_5.jpg"};
  public String img_r[] = {"images/right_1.jpg","images/right_2.jpg","images/right_3.jpg","images/right_4.jpg","images/right_5.jpg"};
  
  public void run() {
   try {
       Thread.sleep(4000);
      } catch (Exception e) {return;}

   while(t) {
    ImageIcon i1 =new ImageIcon(img_l[i]);
    ImageIcon i2 =new ImageIcon(img_r[i]);
    label_time.setVisible(false);
    img1 = i1.getImage();
    img2 = i2.getImage();

    type=true;
    
    a=0;b=0;c=0;d=0;ee=0; sum=0;
    n=30; 
    
    v = new Vector<Point>();

    while(type) {
     
     label_gamestart.setVisible(false);
     screen_left.setVisible(true);
     screen_right.setVisible(true);
     label_time.setText(Integer.toString(n));
     label_time.setVisible(true);
     n--;

     try {

       Thread.sleep(1000);
 
       if(n < 0) {
        type=false;
        t=false;
        label_gameover.setVisible(true);
        screen_left.setVisible(false);
        screen_right.setVisible(false);
        label_gameover.setText("Game Over..");

       }
       if(n > 0 && sum ==5) {
       
       n=n;
       type=false;
       label_gameover.setVisible(true);
       screen_left.setVisible(true);
       screen_right.setVisible(true);
       label_gameover.setText("Congraturation!");
       Thread.sleep(1000);
       label_gameover.setVisible(false);
       label_time.setVisible(false);
	   screen_left.setVisible(false);
	   screen_right.setVisible(false);
	 
	   Thread.sleep(1000);    
 
       i++;
       f++;
       
       if(i==5) {
    	   label_time.setVisible(false);
    	   label_gameover.setVisible(true);
    	   
    	   label_gameover.setText("     Clear!!!");
    	   t=false;
    	   button_reset.setEnabled(false);
    	   }
       }  
      
     }
     catch(InterruptedException e) {   
      return;
     }
 
    }
   }

  }
 }
 class ImagePanel1 extends JPanel{
  public void paintComponent(Graphics g) {
   
      super.paintComponent(g);

      g.drawImage(img1,0,0,350,360,this);

      g.setColor(Color.RED);
      
      /*ù��° �׸� : ������ ž, ������ ��, ���� ��, ��Ȳ����, �������
       *�ι�° �׸� : �߾� ������ ��, ������ �ʷϲ�, ���� �ǹػ��� �ݳ׸�, �ǹ� ������ ����, ���� �� 
       *����° �׸� : �߾� �׸� Ȩ, �� �� �Ķ��� �׸� ������, ���� ��Ȳ ������, ���� �Ķ��׸�, ���� �� �׸�
       *�׹�° �׸� : ������ �� �� ȣ��, ������ �߾�, ������ �� ȣ��, �߾� ����, �߾�
       *�ټ���° �׸� : �߾� �Ķ���, ���� ū ����, ���� ���� ����, �߾� �� �Ķ���, ������ �߾� ����
       * */
      int x1[] = {290,165,119,300,140};
      int x2[] = {206,245,15,315,35};
      int x3[] = {58,44,20,295,10};
      int x4[] = {47,310,20,242,183};
      int x5[] = {150,65,75,190,301};
      
      int y1[] = {114,150,75,317,90};
      int y2[] = {96,188,280,210,130};
      int y3[] = {84,326,118,17,45};
      int y4[] = {282,318,5,190,266};
      int y5[] = {268,146,159,122,168};
      
 
  
      for(int i=0; i<v.size(); i++) {
       Point p = v.elementAt(i);

       if((x1[f]-20) <p.getX() && p.getX()<(x1[f]+20) && (y1[f]-20) <p.getY() && p.getY()<(y1[f]+20)) {
           g.drawOval(x1[f], y1[f], 40, 40);
       }

       else if((x2[f]-20)<p.getX() && p.getX()<(x2[f]+20) && (y2[f]-20)<p.getY() && p.getY()<(y2[f]+20)) { 
         g.drawOval(x2[f], y2[f], 40, 40);
       }

       else if((x3[f]-20)<p.getX() && p.getX()<(x3[f]+20) && (y3[f]-20)<p.getY() && p.getY()<(y3[f]+20)) { 
         g.drawOval(x3[f], y3[f], 40, 40);
       }

       else if((x4[f]-20)<p.getX() && p.getX()<(x4[f]+20) && (y4[f]-20)<p.getY() && p.getY()<(y4[f]+20)) { 
         g.drawOval(x4[f], y4[f], 40, 40);
       }

       else if((x5[f]-20)<p.getX() && p.getX()<(x5[f]+20) && (y5[f]-20)<p.getY() && p.getY()<(y5[f]+20)) { 
         g.drawOval(x5[f], y5[f], 40, 40);
       }
    
      }
   
  
  }
  
 }

 class ImagePanel2 extends JPanel {

   public void paintComponent(Graphics g) {
    
       super.paintComponent(g);

       g.drawImage(img2,0,0,350,360,this);

       g.setColor(Color.RED);
       
       int x1[] = {290,165,119,300,140};
       int x2[] = {206,245,15,315,35};
       int x3[] = {58,44,20,295,10};
       int x4[] = {47,310,20,242,183};
       int x5[] = {150,65,75,190,301};
       
       int y1[] = {114,150,75,317,90};
       int y2[] = {96,188,280,210,130};
       int y3[] = {84,326,118,17,45};
       int y4[] = {282,318,5,190,266};
       int y5[] = {268,146,159,122,168};
 
   
       for(int i=0; i<v.size(); i++) {
        Point p = v.elementAt(i);

        if((x1[f]-20) <p.getX() && p.getX()<(x1[f]+20) && (y1[f]-20) <p.getY() && p.getY()<(y1[f]+20)) { 
            g.drawOval(x1[f], y1[f], 40, 40);
            if(a==0) a++;
        }

        else if((x2[f]-20)<p.getX() && p.getX()<(x2[f]+20) && (y2[f]-20)<p.getY() && p.getY()<(y2[f]+20)) {
          g.drawOval(x2[f], y2[f], 40, 40);
          if(b==0) b++;
        }

        else if((x3[f]-20)<p.getX() && p.getX()<(x3[f]+20) && (y3[f]-20)<p.getY() && p.getY()<(y3[f]+20)) { 
          g.drawOval(x3[f], y3[f], 40, 40);
        
          if(c==0) c++;
        }

        else if((x4[f]-20)<p.getX() && p.getX()<(x4[f]+20) && (y4[f]-20)<p.getY() && p.getY()<(y4[f]+20)) { 
          g.drawOval(x4[f], y4[f], 40, 40);
         
          if(d==0) d++;
        }

        else if((x5[f]-20)<p.getX() && p.getX()<(x5[f]+20) && (y5[f]-20)<p.getY() && p.getY()<(y5[f]+20)) { 
          g.drawOval(x5[f], y5[f], 40, 40);
       
          if(ee==0) ee++;
        }
        sum = a+b+c+d+ee;
       }
    }
   
   
  }
 

 
 class ImagePanel_main extends JPanel{
	 ImageIcon m = new ImageIcon("images/main.jpg");
	 public Image main = m.getImage();
	 
	 public void paintComponent(Graphics g) {
	       super.paintComponent(g);
	       g.drawImage(main,0,0,800,600,this);
	       
	 }
 }

 public MainFrame() {

  init();
  start();


  setTitle("Ʋ���׸�ã��"); //������ Ÿ��Ʋ
  setSize(800,600); //������ ũ�� 800*600
  setResizable(false); //������ ũ�� ���� �Ұ�
  setVisible(true); //������ ��� 

 }

 public void init() {

  Container contentPane = this.getContentPane(); //�����ӿ� ������ ����Ʈ���� �˾Ƴ���

  contentPane.setBackground(Color.pink); //����Ʈ���� �� ����
  contentPane.setLayout(null); //����Ʈ���� ��ġ������ ����
 
  mainScreen = new ImagePanel_main();
  mainScreen.setBounds(0,0,800,600);
  mainScreen.setLayout(null);
  contentPane.add(mainScreen); 
 
  mainScreen.add(button_level1);
  
 
  button_level1.setBounds(310, 410, 170,60);
  button_level1.setFont(new Font("Default", Font.BOLD, 20));
  //contentPane.add(button_level1); 
  
  
  
  label_title.setBounds(200, 30, 400, 30); //������Ʈ ��ġ(250,30)�� ũ��(300*30) ����
  label_title.setFont(new Font("Default", Font.BOLD, 30));
  contentPane.add(label_title); //label_title�� ����Ʈ�ҿ� ����


  label_time.setBounds(620, 40, 300, 30); 
  label_time.setFont(new Font("Default", Font.BOLD, 30));
  label_time.setForeground(Color.RED); //label_time���ڻ��� ���������� ����
  contentPane.add(label_time); 

  

  label_gameover.setBounds(250, 200, 400, 60); 
  label_gameover.setFont(new Font("Default", Font.BOLD, 50));
  label_gameover.setForeground(Color.RED); 
  contentPane.add(label_gameover); 

  

  label_countDown.setBounds(370, 190, 400, 150); 
  label_countDown.setFont(new Font("Default", Font.BOLD, 70));
  contentPane.add(label_countDown); 

  

  label_gamestart.setBounds(250, 220, 400, 60); 
  label_gamestart.setFont(new Font("Default", Font.BOLD, 50));
  contentPane.add(label_gamestart);

  

  button_start.setBounds(150, 480, 150, 50); 
  button_start.setFont(new Font("Default", Font.BOLD, 20));
  button_start.setEnabled(false);
  

  contentPane.add(button_start); 
  button_start.setVisible(false);
  button_start.setEnabled(false); 

  

  button_reset.setBounds(500, 480, 150, 50);
  button_reset.setFont(new Font("Default", Font.BOLD, 20));

  contentPane.add(button_reset); 
  button_reset.setVisible(false);
  button_reset.setEnabled(false); 


  button_home.setBounds(325, 480, 150, 50);
  button_home.setFont(new Font("Default", Font.BOLD, 20));
  contentPane.add(button_home); 
  
  button_home.setVisible(false);
  button_home.setEnabled(false);
 

  screen_left = new ImagePanel1(); 
  screen_left.setBounds(30,70,350,360);
  contentPane.add(screen_left); 
  screen_left.setVisible(false);
 
  screen_right = new ImagePanel2();
  screen_right.setBounds(400,70,350,360);
  contentPane.add(screen_right); 
  screen_right.setVisible(false);
  


 
 

 }

 

 public void start() {

  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ �����츦 ������ ���α׷� ����
  this.addMouseListener(this); //�����ӳ� ���콺���� Ȱ��ȭ

  mainScreen.addMouseListener(this);

  
  
  
  button_start.addMouseListener(this); //��ư�� ���콺 ���� Ȱ��ȭ
  button_reset.addMouseListener(this);

  button_home.addMouseListener(this);
  button_level1.addMouseListener(this);

  screen_left.addMouseListener(this);
  screen_right.addMouseListener(this);

  

  label_title.setText("5���� ã�� ������ click!"); //�� �ؽ�Ʈ ���� ���� 

 }

 

 @Override
 public void mouseClicked(MouseEvent e) {

  TimerThread runnable = new TimerThread(label_time, label_gameover,label_countDown,label_gamestart);
  Thread countThread = new Thread(runnable);

  

  countDownThread runnable1 = new countDownThread(label_countDown,label_gamestart);
  Thread countDownThread = new Thread(runnable1);

  button_reset.addActionListener(new ActionListener(){

   @Override
   public void actionPerformed(ActionEvent e) {
    countDownThread.interrupt();
    countThread.interrupt();

   }

  });

  

  button_home.addActionListener(new ActionListener(){

   @Override
   public void actionPerformed(ActionEvent e) {
    countDownThread.interrupt();
    countThread.interrupt();

   }

  });

 
  if (e.getSource() == button_level1) { //���� ���� ��ư�� ������ 

    countDownThread.start();

    countThread.start();
    
    mainScreen.setVisible(false);
    
    
    button_level1.setVisible(false);
    button_home.setVisible(true);
    button_home.setEnabled(true);
    button_start.setVisible(true);
    button_start.setEnabled(false);
    button_reset.setVisible(true);
    button_reset.setEnabled(true);
    }
  
  
  

 
  if(e.getSource() == button_start) {
   countDownThread.start();
   countThread.start();  
   button_start.setEnabled(false);
   
  
  }
  if(e.getSource() == button_home) {
  i=0;
  f=0; //�ٽ�ó������
  mainScreen.setVisible(true);
  
  
   button_level1.setVisible(true);
   



   button_home.setVisible(false);
   button_home.setEnabled(false);
   
   button_start.setVisible(false);
   button_start.setEnabled(false);
   
   button_reset.setVisible(false);
   button_reset.setEnabled(false);

   
   label_countDown.setVisible(false);
   label_gameover.setVisible(false);
   label_time.setVisible(false);

   screen_left.setVisible(false);
   screen_right.setVisible(false);
   v = new Vector<Point>();
  }
  if(e.getSource() == button_reset) {
	  button_start.setEnabled(true);

   label_time.setText("30");
   label_time.setVisible(false);
   label_countDown.setVisible(false);

   label_gameover.setVisible(false);

   
   screen_left.setVisible(false);
   screen_right.setVisible(false);
   v = new Vector<Point>(); 
  } 

 }


 @Override

 public void mouseEntered(MouseEvent e) {
  // TODO Auto-generated method stub 
 }

 

 @Override

 public void mouseExited(MouseEvent e) {
  // TODO Auto-generated method stub 
 }

 

 @Override

 public void mousePressed(MouseEvent e) {

  screen_right.addMouseListener(new MouseListener() {
      public void mouseClicked(MouseEvent e) {}
      public void mouseEntered(MouseEvent e) {}
      public void mouseExited(MouseEvent e) {}
      public void mousePressed(MouseEvent e) {
       Point point = e.getPoint();
       v.add(point);
      }
      public void mouseReleased(MouseEvent e) {}
  }); 

 }

 

 @Override

 public void mouseReleased(MouseEvent e) {

  screen_right.addMouseListener(new MouseListener() {
      public void mouseClicked(MouseEvent e) {}
      public void mouseEntered(MouseEvent e) {}
      public void mouseExited(MouseEvent e) {}
      public void mousePressed(MouseEvent e) {}
      public void mouseReleased(MouseEvent e) {repaint();}

  });

 }

 

 @Override
 public void run() {
  // TODO Auto-generated method stub
 }  

}

 

public class game {

 

 public static void main(String[] args) {

  new MainFrame();

 }

}  
