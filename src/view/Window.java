package view;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

import control.PollInputWindow;

public class Window {

	public int w, l, w2, l2;

	/**
	 * Creates the main window
	 */
	public void start() {

		try {
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		w = 100;
		l = 100;
		w2 = 200;
		l2 = 200;

		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 800, 0, 600, 1, -1);
		glMatrixMode(GL_MODELVIEW);

		while (!Display.isCloseRequested()) {

			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

			// set the color of the quad (R,G,B,A)
			glColor3f(0.5f, 0.5f, 1.0f);

			// draw quad
			glBegin(GL_QUADS);
			glVertex2f(w, l);
			glVertex2f(w + w2, l);
			glVertex2f(w + w2, l + l2);
			glVertex2f(w, l + l2);
			glEnd();

			PollInputWindow.pollInput(this);
			Display.update();
		}
		Display.destroy();
	}
}
