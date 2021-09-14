
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;	//to set random plastic locations
import java.awt.event.ActionEvent;      //for timer
import java.awt.event.ActionListener;   //for timer
import java.util.ArrayList;	//because we have an ArrayList of plastic
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics2D;
import java.util.Random;		//to set random plastic locations
import java.awt.event.ActionEvent;      //for timer
import java.awt.event.ActionListener;   //for timer
import java.util.ArrayList;		//because we have an ArrayList of plastic
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;		//timer import

public class GameFrame extends JPanel implements ActionListener{
    Timer mainTimer;
    double timer=0;
    static FishModel fish;
    Random rand = new Random();     //seed the random generator
    static ArrayList<Plastic> plastic = new ArrayList<Plastic>();     //initializing variables
    static int bro=1;
    int xbruh, ybruh;
    Background bruh= new Background(0,0);
	public GameFrame() {
        setFocusable(true);
        fish = new FishModel(650,420);		//postions Fish in the middle of the screen
        mainTimer = new Timer(10,this);     //sets Timer to update() every 10 milliseconds
        mainTimer.start();                  //to start the timer
        setPlastic();      //calls the method below for setting up the plastic randomly
        addKeyListener(new KeyAdapt(fish));
	}
	public void setPlastic() {
		for (int i=0;i<12;i++) {
		plastic.add(new Plastic(rand.nextInt(1300),rand.nextInt(620))); //adding 12 plastic bags
		}
	}
	
	public void actionPerformed(ActionEvent arg0){  //this method nec'y for timers
       
		
		for (int i=0;i<plastic.size();i++) {
		plastic.get(i).update();
        }
        fish.update();
        
        timer+=0.01;                       //timer adds 10 milliseconds per refresh
        checkEnd();
        repaint();
       
    }
	
	public void paint(Graphics g){	//this method paints everything onto the screen
        super.paint(g);
        
        Graphics2D g2d  = (Graphics2D) g;  //cast g as Graphics2d 
     
        bruh.draw(g2d); //draw background
        
        fish.draw(g2d);	 //draw fish
     
        for (int i=0;i<plastic.size();i++){    //draw the ArrayList of plastic bags (which is
            Plastic tempPlastic = plastic.get(i);   //changiDng in size as we go)
            tempPlastic.draw(g2d);
            
        }
        g.setColor(Color.green);
        g.setFont(new Font(null,Font.BOLD,20));
        g.drawString("[HACK THE NORTH Project GUI]",1050,620);
        g.setColor(Color.white);
        g.drawString("By. Kayen M and Kevin Le",1050,640);   //printing text and the timer
        g.setColor(Color.yellow);
        g.setFont(new Font(null,Font.BOLD,30));
        g.drawString("Timer:"+timer,1205,26);
        g.setFont(new Font(null,Font.BOLD,30));
        g.setColor(Color.yellow);
        g.drawString("ENTANGLED IN PLASTIC!",532,26);
        g.setColor(Color.white);
        g.setFont(new Font(null,Font.BOLD,20));
        g.drawString("Avoid the plastic for as long as you can!",525,46);
        g.setColor(Color.green);
        g.setFont(new Font(null,Font.BOLD,20));
        g.drawString("Use the WASD keys to control the fish!",5,620);
        g.setColor(Color.white);
        g.drawString("[W]_Up [S]_Down [A]_Left [D]_Right",5,640);
    }

	private void checkEnd() {
		if (bro==0) {
			System.exit(0); 
		}
		
	}
	public static FishModel getFishList(){	
        return fish;				//gets provided to checkCollisions()
 }
	public static int bruh() {
		return bro;
	}
 
}