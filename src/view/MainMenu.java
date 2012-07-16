package view;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glTexCoord2d;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class MainMenu {

	/**
	 * Draw the main menu window
	 */
	public void draw() {

		try {
			Display.setDisplayMode(new DisplayMode(
					WindowSettings.WINDOW_WIDHT,
					WindowSettings.WINDOW_HEIGHT
			));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}

	    glMatrixMode(GL_PROJECTION);
	    glDisable(GL_DEPTH_TEST);
	    
	    while (!Display.isCloseRequested()) {
	    	glClear(GL_COLOR_BUFFER_BIT);
			this.drawBackrgound();
			this.drawButtons();
			Display.update();
	    }
	    Display.destroy();
	}

	/**
	 * Draw the background of the window
	 */
	private void drawBackrgound() {
		//TODO: put a background texture
		//glBindTexture(GL_TEXTURE_2D, texture);
		glColor3f(0.5f, 1f, 1.0f);

	    glBegin(GL_QUADS);
	        glTexCoord2d(0, 0);
	        glVertex2f(0, WindowSettings.WINDOW_HEIGHT);
	        glTexCoord2d(0, 1);
	        glVertex2f(0, 0);
	        glTexCoord2d(1, 1);
	        glVertex2f(WindowSettings.WINDOW_WIDHT, 0);
	        glTexCoord2d(1, 0);
	        glVertex2f(WindowSettings.WINDOW_WIDHT, WindowSettings.WINDOW_HEIGHT);
	    glEnd();
	}

	/**
	 * Draw the buttons on the window
	 */
	private void drawButtons() {		
	}
}