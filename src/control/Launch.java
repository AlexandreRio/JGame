package control;

import view.MainMenu;

/**
 * Launch the application.
 * @author Alexandre Rio
 * @version 1.0
 */
public class Launch {

	/**
	 * Main Launcher.
	 * @param args No arguments are needed.
	 */
	public static void main(String[] args) {
		MainMenu l = new MainMenu();
		l.draw();
	}

}