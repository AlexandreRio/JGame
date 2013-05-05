package view.model;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector3f;

/**
 * Represents a full 3D model.
 * @author Alexandre Rio
 * @version 1.0
 */
public class Model {

	/** List of the vertices that made the model. */
	public List<Vector3f> vertices = new ArrayList<Vector3f>();
	/** List of the normals that made the model. */
	public List<Vector3f> normals = new ArrayList<Vector3f>();
	/** List of the faces that made the model. */
	public List<Face> faces = new ArrayList<Face>();
	
	/**
	 * Nothing to do.
	 */
	public Model() {}
}