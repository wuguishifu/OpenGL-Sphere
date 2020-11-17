package com.bramerlabs.sphere;

import java.util.ArrayList;

public class Sphere {

    /** final variables */
    // default difference between normal and shaded color for each [r, g, b]
    private static final float SHADE_DIFFERENCE = 0.2f;

    // the amount of times to recursively subdivide faces
    private static final int depth = 4; // feel free to change this, higher numbers mean more intensive but better looking

    // the golden ratio
    private static final float phi = 1.6180339f;

    /** object specific variables */
    // position of the sphere
    private Vector3f position;

    // color of the sphere
    private Vector3f color;

    // different color, used to visually show shading
    private Vector3f colorShaded;

    // the radius of this sphere
    private float radius = 1;

    // a list of triangles in this sphere
    private ArrayList<Triangle> faces = new ArrayList<>();

    /**
     * constructor for specified position, specified color, and specified shaded color
     * @param position - the position of this sphere
     * @param color - an org.joml.Vector3f vector representing the default color [r, g, b]
     * @param shadedColor - an org.joml.Vector3f vector representing the shaded color [r*, g*, b*]
     */
    public Sphere(Vector3f position, Vector3f color, Vector3f shadedColor) {
        this.position = position;
        this.color = color;
        this.colorShaded = shadedColor;
    }

    /**
     * constructor for specified position, specified color, and specified shaded color
     * @param position - float array containing the position in the form [x, y, z]
     * @param color - float array containing the color in the form [r, g, b]
     * @param shadedColor - float array containing the shaded color in the form [r*, g*, b*]
     */
    public Sphere(float[] position, float[] color, float[] shadedColor) {
        this.position = new Vector3f(position[0], position[1], position[2]);
        this.color = new Vector3f(color[0], color[1], color[2]);
        this.colorShaded = new Vector3f(shadedColor[0], shadedColor[1], shadedColor[2]);
    }

    /**
     * constructor for specified position, specified color, and generated shaded color with specified shade difference
     * @param position - a float array containing the position in the form [x, y, z]
     * @param color - a float array containing the color in the form [r, g, b]
     * @param shadeDifference - a float value difference for each [r, g, b] value to be lower by to generate a shaded color
     */
    public Sphere(float[] position, float[] color, float shadeDifference) {
        this.position = new Vector3f(position[0], position[1], position[2]);
        this.color = new Vector3f(color[0], color[1], color[2]);
        float r = color[0] - shadeDifference > 0 ? color[0] - shadeDifference : 0;
        float g = color[1] - shadeDifference > 0 ? color[1] - shadeDifference : 0;
        float b = color[2] - shadeDifference > 0 ? color[2] - shadeDifference : 0;
        this.colorShaded = new Vector3f(r, g, b);
    }

    /**
     * constructor for specified position, specified color, and generated shaded color with default shade difference
     * @param position - a float array containing the position in the form [x, y, z]
     * @param color - a float array containing the color in the form [r, g, b]
     */
    public Sphere(float[] position, float[] color) {
        this.position = new Vector3f(position[0], position[1], position[2]);
        this.color = new Vector3f(color[0], color[1], color[2]);
        float r = color[0] - SHADE_DIFFERENCE > 0 ? color[0] - SHADE_DIFFERENCE : 0;
        float g = color[1] - SHADE_DIFFERENCE > 0 ? color[1] - SHADE_DIFFERENCE : 0;
        float b = color[2] - SHADE_DIFFERENCE > 0 ? color[2] - SHADE_DIFFERENCE : 0;
        this.colorShaded = new Vector3f(r, g, b);
    }

    /**
     * constructor for specified position, randomly generated color, and generated shaded color with default shade difference
     * @param position - a float array containing the position in the form [x, y, z]
     */
    public Sphere(float[] position) {
        this.position = new Vector3f(position[0], position[1], position[2]);
        this.color = new Vector3f((float)Math.random(), (float)Math.random(), (float)Math.random());
        float r = color.x - SHADE_DIFFERENCE > 0 ? color.x - SHADE_DIFFERENCE : 0;
        float g = color.y - SHADE_DIFFERENCE > 0 ? color.y - SHADE_DIFFERENCE : 0;
        float b = color.z - SHADE_DIFFERENCE > 0 ? color.z - SHADE_DIFFERENCE : 0;
        this.colorShaded = new Vector3f(r, g, b);
    }

    /**
     * constructor for specified position, specified color, and generated shaded color with specific shade difference
     * @param position - the position of this sphere
     * @param color - an org.joml.Vector3f vector representing the default color [r, g, b]
     * @param shadeDifference - a float value difference for each [r, g, b] value to be lowered by to generate a shaded color
     */
    public Sphere(Vector3f position, Vector3f color, float shadeDifference) {
        this.position = position;
        this.color = color;
        float r = color.x - shadeDifference > 0 ? color.x - shadeDifference : 0;
        float g = color.y - shadeDifference > 0 ? color.y - shadeDifference : 0;
        float b = color.z - shadeDifference > 0 ? color.z - shadeDifference : 0;
        this.colorShaded = new Vector3f(r, g, b);
    }

    /**
     * constructor for specified position, specified color, and generated shaded color by default shade difference SHADE_DIFFERENCE
     * @param position - the position of this sphere
     * @param color - an org.joml.Vector3f vector representing the default color [r, g, b]
     */
    public Sphere(Vector3f position, Vector3f color) {
        this.position = position;
        this.color = color;
        float r = color.x - SHADE_DIFFERENCE > 0 ? color.x - SHADE_DIFFERENCE : 0;
        float g = color.y - SHADE_DIFFERENCE > 0 ? color.y - SHADE_DIFFERENCE : 0;
        float b = color.z - SHADE_DIFFERENCE > 0 ? color.z - SHADE_DIFFERENCE : 0;
        this.colorShaded = new Vector3f(r, g, b);
    }

    /**
     * constructor for specified position, random color, and generated shaded color by default shade difference SHADE_DIFFERENCE
     * @param position - the position of this sphere
     */
    public Sphere(Vector3f position) {
        this.position = position;
        this.color = new Vector3f((float)Math.random(), (float)Math.random(), (float)Math.random());
        float r = color.x - SHADE_DIFFERENCE > 0 ? color.x - SHADE_DIFFERENCE : 0;
        float g = color.y - SHADE_DIFFERENCE > 0 ? color.y - SHADE_DIFFERENCE : 0;
        float b = color.z - SHADE_DIFFERENCE > 0 ? color.z - SHADE_DIFFERENCE : 0;
        this.colorShaded = new Vector3f(r, g, b);
    }

    /**
     * constructor for default position (0, 0, 0), random color, and generated shaded color by default shade difference SHADE_DIFFERENCE
     */
    public Sphere() {
        this.position = new Vector3f(0, 0, 0);
        this.color = new Vector3f((float)Math.random(), (float)Math.random(), (float)Math.random());
        float r = color.x - SHADE_DIFFERENCE > 0 ? color.x - SHADE_DIFFERENCE : 0;
        float g = color.y - SHADE_DIFFERENCE > 0 ? color.y - SHADE_DIFFERENCE : 0;
        float b = color.z - SHADE_DIFFERENCE > 0 ? color.z - SHADE_DIFFERENCE : 0;
        this.colorShaded = new Vector3f(r, g, b);
    }

    /**
     * changes the radius from the default (1)
     * @param r - the new radius
     */
    public void setRadius(float r) {
        this.radius = r;
    }

    /**
     * moves sphere
     * @param newPosition - the new position of the sphere
     */
    public void moveTo(Vector3f newPosition) {
        this.position = newPosition;
    }

    /**
     * sets color
     * @param newColor - the new color of the sphere
     */
    public void setColor(Vector3f newColor) {
        this.color = newColor;
    }

    /**
     * sets shaded color
     * @param colorShaded - the new shaded color of the sphere
     */
    public void setColorShaded(Vector3f colorShaded) {
        this.colorShaded = colorShaded;
    }

    /**
     * generates a new shaded color for the current color using specified shade difference
     * @param shadeDifference - a float value difference for each [r, g, b] value to be lowered by to generate a shaded color
     */
    public void generateShadedColor(float shadeDifference) {
        float r = color.x - shadeDifference > 0 ? color.x - shadeDifference : 0;
        float g = color.y - shadeDifference > 0 ? color.y - shadeDifference : 0;
        float b = color.z - shadeDifference > 0 ? color.z - shadeDifference : 0;
        this.colorShaded = new Vector3f(r, g, b);
    }

    /**
     * generates a new shaded color for the current color using the default shade difference SHADE_DIFFERENCE
     */
    public void generateShadedColor() {
        float r = color.x - SHADE_DIFFERENCE > 0 ? color.x - SHADE_DIFFERENCE : 0;
        float g = color.y - SHADE_DIFFERENCE > 0 ? color.y - SHADE_DIFFERENCE : 0;
        float b = color.z - SHADE_DIFFERENCE > 0 ? color.z - SHADE_DIFFERENCE : 0;
        this.colorShaded = new Vector3f(r, g, b);
    }

    /**
     * generates the vertices of this sphere
     */
    public void generateVertices() {

        // define a regular icosahedron using 12 vertices
        Vector3f[] vertices = new Vector3f[12];
        vertices[0]  = new Vector3f( 0.5f * radius, 0,  phi/2 * radius);
        vertices[1]  = new Vector3f( 0.5f * radius, 0, -phi/2 * radius);
        vertices[2]  = new Vector3f(-0.5f * radius, 0,  phi/2 * radius);
        vertices[3]  = new Vector3f(-0.5f * radius, 0, -phi/2 * radius);
        vertices[4]  = new Vector3f( phi/2 * radius,  0.5f * radius, 0);
        vertices[5]  = new Vector3f( phi/2 * radius, -0.5f * radius, 0);
        vertices[6]  = new Vector3f(-phi/2 * radius,  0.5f * radius, 0);
        vertices[7]  = new Vector3f(-phi/2 * radius, -0.5f * radius, 0);
        vertices[8]  = new Vector3f(0,  phi/2 * radius, 0.5f * radius);
        vertices[9]  = new Vector3f(0,  phi/2 * radius,-0.5f * radius);
        vertices[10] = new Vector3f(0, -phi/2 * radius, 0.5f * radius);
        vertices[11] = new Vector3f(0, -phi/2 * radius,-0.5f * radius);

        // subdivide each triangular face (20 total) recursively
        subdivide(vertices[0],  vertices[2],  vertices[10], depth);
        subdivide(vertices[0],  vertices[10], vertices[5],  depth);
        subdivide(vertices[0],  vertices[5],  vertices[4],  depth);
        subdivide(vertices[0],  vertices[4],  vertices[8],  depth);
        subdivide(vertices[0],  vertices[8],  vertices[2],  depth);
        subdivide(vertices[3],  vertices[1],  vertices[11], depth);
        subdivide(vertices[3],  vertices[11], vertices[7],  depth);
        subdivide(vertices[3],  vertices[7],  vertices[6],  depth);
        subdivide(vertices[3],  vertices[6],  vertices[9],  depth);
        subdivide(vertices[3],  vertices[9],  vertices[1],  depth);
        subdivide(vertices[2],  vertices[6],  vertices[7],  depth);
        subdivide(vertices[2],  vertices[7],  vertices[10], depth);
        subdivide(vertices[10], vertices[7],  vertices[11], depth);
        subdivide(vertices[10], vertices[11], vertices[5],  depth);
        subdivide(vertices[5],  vertices[11], vertices[1],  depth);
        subdivide(vertices[5],  vertices[1],  vertices[4],  depth);
        subdivide(vertices[4],  vertices[1],  vertices[9],  depth);
        subdivide(vertices[4],  vertices[9],  vertices[8],  depth);
        subdivide(vertices[8],  vertices[9],  vertices[6],  depth);
        subdivide(vertices[8],  vertices[6],  vertices[2],  depth);
    }

    /**
     * recursively subdivides a triangle into 4 triangles, and then normalizes each new vertex to a radius of 1
     * @param v1 - the first vertex of the triangle
     * @param v2 - the second vertex of the triangle
     * @param v3 - the third vertex of the triangle
     * @param depth - the current depth of recursion
     */
    private void subdivide(Vector3f v1, Vector3f v2, Vector3f v3, long depth) {

        // default condition
        if (depth == 0) {

            // create new vectors to modify
            Vector3f v1p = new Vector3f(v1);
            Vector3f v2p = new Vector3f(v2);
            Vector3f v3p = new Vector3f(v3);

            // if the triangle is in the lower half of the sphere use the shaded color to draw it
            if (v1p.y + position.y > position.y || v2p.y + position.y > position.y || v3p.y + position.y > position.y) {
                faces.add(new Triangle(v1p.add(position), v2p.add(position), v3p.add(position), color));
            } else {
                faces.add(new Triangle(v1p.add(position), v2p.add(position), v3p.add(position), colorShaded));
            }
            return;
        }

        // create new vertices for each face
        Vector3f v12 = new Vector3f(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
        Vector3f v23 = new Vector3f(v2.x + v3.x, v2.y + v3.y, v2.z + v3.z);
        Vector3f v31 = new Vector3f(v3.x + v1.x, v3.y + v1.y, v3.z + v1.z);

        // normalize each vertex to retain a certain radius
        v12.normalize(radius);
        v23.normalize(radius);
        v31.normalize(radius);

        // recursive part
        subdivide(v1, v12, v31, depth-1);
        subdivide(v2, v23, v12, depth-1);
        subdivide(v3, v31, v23, depth-1);
        subdivide(v12, v23, v31,depth-1);
    }

    /**
     * @return - an array list of faces of this sphere
     */
    public ArrayList<Triangle> getFaces() {
        return this.faces;
    }
}
