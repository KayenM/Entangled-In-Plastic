
import java.awt.event.KeyAdapter;   //note these new key imports
import java.awt.event.KeyEvent;

public class KeyAdapt extends KeyAdapter {
	FishModel b;   //this Class has a variable which will be the fish so all keypress
                     //handling happens in FishModel Class because of the variable’s Ball type
        
	public KeyAdapt(FishModel patrick){ //the fish is received from GameFrame after fish is created
		b=patrick;   //this sets the sent ball as the one being key controlled
	}
	
	public void keyPressed(KeyEvent e){
		b.keyPressed(e);    //method from FishModel Class dictates reaction to keystrokes
	}
	public void keyReleased (KeyEvent e) {
		b.keyReleased(e);  //method to react to keyrelease
	}
	
	 
}
