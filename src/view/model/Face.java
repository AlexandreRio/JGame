package view.model;

import org.lwjgl.util.vector.Vector3f;

/**
 * Represents a face made of vertices and normals.
 * @author Alexandre Rio
 * @version 1.0
 */
public class Face {
	/** Vertex 3D coordinate. */
	public Vector3f vertex 	= new Vector3f(); // 3 indices, not vertices or normals !
	/** Normal 3D coordinate.*/
	public Vector3f normal	= new Vector3f();
	
	/**
	 * Create a face from 3 vertices and 3 normals.
	 * @param vertex Group of 3 vertices.
	 * @param normal Group of 3 normals.
	 */
	public Face(Vector3f vertex, Vector3f normal) {
		this.vertex = vertex;
		this.normal = normal;
	}
}