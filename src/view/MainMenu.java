package view;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_FRONT_AND_BACK;
import static org.lwjgl.opengl.GL11.GL_LINE;
import static org.lwjgl.opengl.GL11.glCallList;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glDeleteLists;
import static org.lwjgl.opengl.GL11.glPolygonMode;

import org.lwjgl.opengl.Display;

import view.model.OBJLoader;
import control.PollInputMainMenu;

/**
 * 
 * @author Alexandre Rio
 * @version 1.0
 */
public class MainMenu {

	/** when true properly close the application */
    private boolean done = false;
    /** */
    private static int groundList = 1;
    /** */
    private static String groundPath = "./res/model/ground.obj"
    /** */		;
    private static int catList = 2;
    /** */
    private static String catPath = "res/model/cat.obj";
    private static boolean DEBUG = false; 
	/**
	 * Main loop of the game, initializes openGL, creates the window,
	 * poll the input and draw the scene.
	 * 
	 */
	public void draw() {
		try {
			WindowSettings.init();
			this.setUpDisplayLists();
			while (!done) {
				PollInputMainMenu.pollInput(this);
				this.drawBackrgound();
				Display.update();
				Display.sync(60);
			}
			this.cleanUp();
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	/**
	 * 
	 */
	private void drawBackrgound() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        WindowSettings.CAM.applyModelviewMatrix(true);
        if (DEBUG)
        	glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
        glCallList(groundList);
        glCallList(catList);
	}

	/**
	 * Setter used to quit the main loop
	 */
	public void quit() {
		this.done = true;
	}

	/**
	 * 
	 */
	private void cleanUp() {
		glDeleteLists(groundList, 1);
		glDeleteLists(catList, 2);
		Display.destroy();
	}

	/**
	 * 
	 */
	 private void setUpDisplayLists() {
	        OBJLoader.name(groundPath, groundList);
	        OBJLoader.name(catPath, catList);
	 }

}