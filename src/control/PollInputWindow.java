package control;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

/**
 * Handles the reactions due to input actions
 * @author Alexandre Rio
 * @version 1.0
 */
public class PollInputWindow {

/**
 * poll input
 */
public static void pollInput() {


      if (Mouse.isButtonDown(0)) {
    	  //win.w = Mouse.getX() - win.w2/2;
    	  //win.l = Mouse.getY() - win.l2/2;
      }

      if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
    	  System.out.println("SPACE KEY IS DOWN");
      }

      while (Keyboard.next()) {
    	  if (Keyboard.getEventKeyState()) {	
    		  if (Keyboard.getEventKey() == Keyboard.KEY_A) {
    			  System.out.println("A Key Pressed");
    		  }
    		  if (Keyboard.getEventKey() == Keyboard.KEY_S) {
    			  System.out.println("S Key Pressed");
    		  }
    		  if (Keyboard.getEventKey() == Keyboard.KEY_D) {
    			  System.out.println("D Key Pressed");
    		  }
    	  } else {
    		  if (Keyboard.getEventKey() == Keyboard.KEY_A) {
    			  System.out.println("A Key Released");
    		  }
    		  if (Keyboard.getEventKey() == Keyboard.KEY_S) {
    			  System.out.println("S Key Released");
    		  }
    		  if (Keyboard.getEventKey() == Keyboard.KEY_D) {
    			  System.out.println("D Key Released");
    		  }
    	  }
      }
   }
}
