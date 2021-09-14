
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class FishModel extends Entity{
	int speed=5;
	private int moveX;
	private int moveY;

	private boolean [] keys;  //array to determine keypress
	public FishModel(int x, int y) {
		super(x, y);
		
	
        keys = new boolean [120];
	    		
	}
	public void update(){	
		if (keys[KeyEvent.VK_W] == true) {  //w key, so move up
    		y-=speed;
    	}if(keys[KeyEvent.VK_A] == true)  {
    		x-=speed;
    	}if(keys[KeyEvent.VK_S] == true)  {
    		y+=speed;
    	}if(keys[KeyEvent.VK_D] == true)  {
    		x+=speed;
    	}
    	
    	checkCollision();
    }
	
	public void draw(Graphics2D g2d){
        g2d.drawImage(getFishImg(),x,y,null);
    }
	 public Image getFishImg(){
	        ImageIcon ic=new ImageIcon(getClass().getClassLoader().getResource("Fish.png")); //getting the image
	        return ic.getImage();
	   }
	//
			
			
	        	
			
		
	public Rectangle getBounds(){
        return new Rectangle(x,y,getFishImg().getWidth(null),getFishImg().getHeight(null));
	}
	 public void checkCollision(){
		 if (x+getFishImg().getWidth(null) >1450 ){ 	//1360 is the width of the window
	            x-=5;			//changes moveX from 3 to -3
	    	}if(x+getFishImg().getWidth(null)<10){          //setting boundaries for Fish to not go off the screen
	    		x+=5;                                         //gave some extra space offscreen because PatrickModel is a bit too big
	    	}if(y+getFishImg().getHeight(null)<10){
	    		y+=5;
	    	}if(y+getFishImg().getHeight(null)>775){
	    		y-=5;
	    	}
	 }
	
	 public void keyPressed(KeyEvent e) {
	    	int key = e.getKeyCode();
	    	if(key==KeyEvent.VK_W) {
				keys[key] = true;     //once key is recorded it changes array to true sends to update
			}
			
			if(key==KeyEvent. VK_A) {
				keys[key] = true;
			}
			if(key==KeyEvent.VK_S) {
				keys[key] = true;
			}
			
			if(key==KeyEvent. VK_D) {
				keys[key] = true;
			}
				
				
			
	    }
	 public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			if(key==KeyEvent.VK_W) {
				keys[key] = false;
			}
			
			if(key==KeyEvent. VK_A) { //once key is released, array turns false to stop moving
				keys[key] = false;
			}
			if(key==KeyEvent.VK_S) {
				keys[key] = false;
			}
			
			if(key==KeyEvent. VK_D) {
				keys[key] = false;
			}
			
		}

	
	
}
	

