
import java.applet.Applet;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

public class DigitalClock extends Applet implements Runnable{
protected Thread clockThread=null;

public void start(){
if(clockThread==null){
clockThread=new Thread(this);
clockThread.start();
}
}

public void stop(){
clockThread=null;
}

public void run(){
while(Thread.currentThread()==clockThread){
repaint();
try {
Thread.currentThread().sleep(1000);
} catch (InterruptedException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
}

public void paint(Graphics g){
Calendar cal=Calendar.getInstance();
int hour=cal.get(Calendar.HOUR);
int ampm=cal.get(Calendar.AM_PM);
int minute=cal.get(Calendar.MINUTE);
int second=cal.get(Calendar.SECOND);
int year=cal.get(Calendar.YEAR);
//int month=cal.get(Calendar.MONTH)+1;
int day=cal.get(Calendar.DAY_OF_MONTH);
//int dayWeek=cal.get(Calendar.DAY_OF_WEEK)-1;
Date nowDate=new Date();
String dayWeek=nowDate.toString().substring(0,3);
String month=nowDate.toString().substring(4,7);
String ap="";
if(ampm==0){
ap="AM";
}else{
ap="PM";
}
g.drawString(hour+":"+minute/10+minute%10+":"+second/10+second%10+" "+ap, 10, 60);
//g.drawString(day+" "+month+" "+year+" "+dayWeek, 10, 80);
}
}

