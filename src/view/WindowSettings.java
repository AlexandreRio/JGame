package view;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

import static org.lwjgl.opengl.GL11.*;

/**
 * Abstract class to easily configure window's settings like width, height and
 * texture file path. Also handles the graphical initialization.
 * 
 * @author Alexandre Rio
 * @version 1.0
 */
public abstract class WindowSettings {

	/** Height of the window */
	public static final int WINDOW_HEIGHT = 600;
	/** Width of the window */
	public static final int WINDOW_WIDHT = 800;
	/** Number of bits by pixel */
	public static final int BITS_PER_PIXEL = 24;
	/** Display mode used, based on the previous settings */
	private static DisplayMode displayMode;
	/** */
	public static Camera CAM;
	/** True will sets the game in full screen mode */
	private static boolean fullscreen;

	/**
	 * Sets up the graphical part of the game
	 * 
	 * @throws Exception If the window creation failed
	 */
	public static void init() throws Exception {
		createWindow();
		initGL();
		initCamera();
		initLighting();
	}

	/**
	 * Creates the window based on a available display mode
	 * 
	 * @throws Exception If something went wrong ?
	 */
	private static void createWindow() throws Exception {
		Display.setFullscreen(WindowSettings.fullscreen);
		DisplayMode d[] = Display.getAvailableDisplayModes();
		for (int i = 0; i < d.length; i++) {
			// System.out.println(d[i].toString());
			if (d[i].getWidth() == WindowSettings.WINDOW_WIDHT
					&& d[i].getHeight() == WindowSettings.WINDOW_HEIGHT
					&& d[i].getBitsPerPixel() == WindowSettings.BITS_PER_PIXEL) {
				displayMode = d[i];
				break;
			}
		}
		Display.setDisplayMode(displayMode);
		Display.setTitle("JGame");
		Display.create();
	}

	/**
	 * Initialize openGL
	 */
	private static void initGL() {
		GL11.glEnable(GL11.GL_TEXTURE_2D); // Enable Texture Mapping
		GL11.glShadeModel(GL11.GL_SMOOTH); // Enable Smooth Shading
		GL11.glClearColor(0.5f, 0.5f, 0.5f, 10f); // Black Background
		GL11.glClearDepth(1.0); // Depth Buffer Setup
		GL11.glEnable(GL11.GL_DEPTH_TEST); // Enables Depth Testing
		GL11.glDepthFunc(GL11.GL_LEQUAL); // The Type Of Depth Testing To Do

		GL11.glMatrixMode(GL11.GL_PROJECTION); // Select The Projection Matrix
		GL11.glLoadIdentity(); // Reset The Projection Matrix

		// Calculate The Aspect Ratio Of The Window
		GLU.gluPerspective(45.0f, (float) displayMode.getWidth()
				/ (float) displayMode.getHeight(), 0.1f, 100.0f);
		GL11.glMatrixMode(GL11.GL_MODELVIEW); // Select The Modelview Matrix

		// Really Nice Perspective Calculations
		GL11.glHint(GL11.GL_PERSPECTIVE_CORRECTION_HINT, GL11.GL_NICEST);
	}

	/**
	 * Initialize the camera.
	 * 
	 * @see Camera
	 */
	public static void initCamera() {
		CAM = new Camera((float) displayMode.getWidth()
				/ (float) displayMode.getHeight(), -1.38f, 1.36f, 7.95f);
		CAM.setPitch(-1.12f);
		CAM.setYaw(70);
		CAM.applyPerspectiveMatrix();
	}

	/**
	 *  
	 */
	private static void initLighting() {
        glShadeModel(GL_SMOOTH);
        glEnable(GL_DEPTH_TEST);
        glEnable(GL_LIGHTING);
        glEnable(GL_LIGHT0);
        //glLightModel(GL_LIGHT_MODEL_AMBIENT, asFloatBuffer(new float[]{0.05f,
        //      0.05f, 0.05f, 1f}));
        glLightModel(GL_LIGHT_MODEL_AMBIENT, asFloatBuffer(new float[]{0.1f,
                0.1f, 0.1f, 0.5f}));
        glLight(GL_LIGHT0, GL_POSITION,
                asFloatBuffer(new float[]{10, 0, 1, 1}));
        glEnable(GL_CULL_FACE);
        glCullFace(GL_BACK);
        glEnable(GL_COLOR_MATERIAL);
        glColorMaterial(GL_FRONT, GL_DIFFUSE);
	}

	/**
	 * Cast a float array into a FloatBuffer.
	 * @param values 
	 * @return FloatBuffer created from the float array.
	 * @see java.nio.FloatBuffer#FloatBuffer
	 */
	public static FloatBuffer asFloatBuffer(float[] values) {
        FloatBuffer buffer = BufferUtils.createFloatBuffer(values.length);
        buffer.put(values);
        buffer.flip();
		return buffer;
	}

	/**
	 * Switch to window/full-screen mode
	 */
	public static void switchFullscreen() {
		WindowSettings.fullscreen = !WindowSettings.fullscreen;
		try {
			Display.setFullscreen(fullscreen);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}