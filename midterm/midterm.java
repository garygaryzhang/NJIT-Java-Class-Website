import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.applet.Applet;
import java.applet.AudioClip;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class midterm extends Applet implements Runnable{
	List<Object> list = new ArrayList<Object>();
	  
    Dimension d;
    Button Button9,Button8,Button7,Button6,Button5,Button4,Button3,Button2,Button1,Button0,
    Buttonstart;
    Label label;
    JPanel panel = new JPanel();
    TextField tf = new TextField();
    Date date = new Date();
    DigitalClock dc = new DigitalClock();
    String timer = "";
    int counter;
    boolean flag = false;
    boolean foodFlag = false;
    
    
    private ActionListener listener = new ActionListener(){
    	
		@Override
		public void actionPerformed(ActionEvent e){
			
			Object obj=e.getSource();
			if(obj == Button1){
				timer += "1";
			
			}
			else if(obj == Button2){
				timer += "2";
			}
			else if(obj == Button3){
				timer += "3";
			}
			else if(obj == Button4){
				timer += "4";
			}
			else if(obj == Button5){
				timer += "5";
			}
			else if(obj == Button6){
				timer += "6";
			}
			else if(obj == Button7){
				timer += "7";
			}
			else if(obj == Button8){
				timer += "8";
			}
			else if(obj == Button9){
				timer += "9";
			}
			else if(obj == Button0){
				timer += "0";
			}else{
				flag = true;
				counter = Integer.parseInt(timer);
			}
			
		}
    	
    };
    
    String str;
    protected Thread clockThread=null;
	public void paint(Graphics g) {
		        setPreferredSize(new Dimension(1200,800));
			    Dimension d=getSize();
			    g.setColor(Color.WHITE);
			    g.fillRect(0, 0, d.width, d.height);
			    g.setFont(new Font("Sans-serif",Font.BOLD,30));
			    g.setColor(Color.BLACK); 
			   g.drawImage(getImage(getCodeBase(),"./microwave.jpg"),0,30,this);
			   d= getSize();
			   
			   g.setColor(Color.red);
			   if(flag){
				   g.setColor(Color.green);
			   }
		       g.drawOval(660,400,15,15);
		       g.fillOval(660,400,15,15);
			  }	
	
	public void init()
    {
		this.setLayout(null);
		setPreferredSize(new Dimension(1200,800));
		  d= getSize();
	      Button9 = new Button("9");
	      Button9.setBounds(660,300,20,20);
	      Button8 = new Button("8");
	      Button8.setBounds(685,300,20,20);
	      Button7 = new Button("7");
	      Button7.setBounds(710,300,20,20);
	      Button6 = new Button("6");
	      Button6.setBounds(660,325,20,20);
	      Button5 = new Button("5");
	      Button5.setBounds(685,325,20,20);
	      Button4 = new Button("4");
	      Button4.setBounds(710,325,20,20);
	      Button3 = new Button("3");
	      Button3.setBounds(660,350,20,20);
	      Button2 = new Button("2");
	      Button2.setBounds(685,350,20,20);
	      Button1 = new Button("1");
	      Button1.setBounds(710,350,20,20);
	      Button0 = new Button("0");
	      Button0.setBounds(660,375,20,20);
	      Buttonstart = new Button("START");
	      Buttonstart.setBounds(685,375,50,20);
	      panel.setBounds(650,160,100,100);
	      
	      
	      add(Button9);
	      add(Button8);
	      add(Button7);
	      add(Button6);
	      add(Button5);
	      add(Button4);
	      add(Button3);
	      add(Button2);
	      add(Button1);
	      add(Button0);
	      add(Buttonstart);
	      
	      Button9.addActionListener(listener);
	      Button8.addActionListener(listener);
	      Button7.addActionListener(listener);
	      Button6.addActionListener(listener);
	      Button5.addActionListener(listener);
	      Button4.addActionListener(listener);
	      Button3.addActionListener(listener);
	      Button2.addActionListener(listener);
	      Button1.addActionListener(listener);
	      Button0.addActionListener(listener);
	      Buttonstart.addActionListener(listener);
	   
	      this.run();
    }
	
	public void start(){
		
		AudioClip audio;
		audio=getAudioClip(getDocumentBase(),"TICKTOCK.WAV");
		if(clockThread==null){
		clockThread=new Thread(this);
		clockThread.start();
		}
		}

		public void stop(){
		clockThread=null;
		}

		public void run(){
            AudioClip audio;
audio=getAudioClip(getDocumentBase(),"TICKTOCK.WAV");
            String displayNum = String.valueOf(counter);
		  
		   label = new Label(displayNum);
		   label.setText(displayNum);
		   label.setBounds(650,160,100,100);
		   label.setBackground(Color.WHITE);
		   label.setForeground(Color.ORANGE);
                                
	while(Thread.currentThread()==clockThread){
	dc.setBounds(650,160,100,100);
	this.add(dc);
	
	
	if(counter>0){
                  audio.play();
		dc.setVisible(false);
		displayNum = String.valueOf(counter);
		   
	   
                            
                          label.setText( ""+counter--);
	    this.add(label);
	   if(counter == 0){
		   foodFlag = true;
                           
		   
	   }
	
	}
	
	if(counter == 0 && foodFlag == true){
		String food ="";
		food = "Food is ready";
		label = new Label(food);
	   label.setBounds(650,120,100,50);
	   label.setBackground(Color.WHITE);
	   this.add(label);
	}
	try {
		Thread.currentThread().sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}
}



	}
