package control;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import view.MainMenu;
import view.WindowSettings;

import static org.lwjgl.opengl.GL11.*;
/**
 * Handles the input interruptions and the reactions.
 * @author Alexandre Rio
 * @version 1.0
 */
public class PollInputMainMenu {
	
	private static float[] lightPosition = {-2.19f, 1.36f, 11.45f, 1f};
	/**
	 * @param win
	 */
	public static void pollInput(MainMenu win) {
		WindowSettings.CAM.processMouse(1, 80, -80);
        WindowSettings.CAM.processKeyboard(16, 0.03f, 0.03f, 0.03f);
        glLight(GL_LIGHT0, GL_POSITION, WindowSettings.asFloatBuffer(lightPosition));
        if (Mouse.isButtonDown(0))
            Mouse.setGrabbed(true);
        else if (Mouse.isButtonDown(1))
            Mouse.setGrabbed(false);

		if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
			win.quit();
		}
		if(Display.isCloseRequested()) {
			win.quit();
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_F1) || Keyboard.isKeyDown(Keyboard.KEY_F11)) {
			WindowSettings.switchFullscreen();
		}
	}

}