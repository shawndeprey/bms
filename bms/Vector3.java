package bms;

public class Vector3 {
	// Attributes
	private double X;
	private double Y;
	private double Z;
	
	// Constructors
	public Vector3() {
		setX(0D);
		setY(0D);
		setZ(0D); }
	
	public Vector3(double x, double y, double z) {
		setX(x);
		setY(y);
		setZ(z); }
	
	public Vector3(float x, float y, float z) {
		setX(x);
		setY(y);
		setZ(z); }
	
	public Vector3(int x, int y, int z) {
		setX(x);
		setY(y);
		setZ(z); }
	
	public Vector3(Vector3 v) {
		X = v.getX();
		Y = v.getY();
		Z = v.getZ(); }
	
	// Getters
	public double getX() { return X; }
	public double getY() { return Y; }
	public double getZ() { return Z; }
	
	// Setters
	public void set(Vector3 vec) { X = vec.getX(); Y = vec.getY(); Z = vec.getZ(); }
	
	public void setX(double value) { X = value; }
	public void setX(float value) { X = (double)value; }
	public void setX(int value) { X = (double)value; }
	
	public void setY(double value) { Y = value; }
	public void setY(float value) { Y = (double)value; }
	public void setY(int value) { Y = (double)value; }
	
	public void setZ(double value) { Z = value; }
	public void setZ(float value) { Z = (double)value; }
	public void setZ(int value) { Z = (double)value; }
	
	// Utility
	public void Add(Vector3 vec)
	{
		this.set(new Vector3(X + vec.getX(), Y + vec.getY(), Z + vec.getZ()));
	}
	
	public void Sub(Vector3 vec)
	{
		this.set(new Vector3(X - vec.getX(), Y - vec.getY(), Z - vec.getZ()));
	}
	
	public void Mult(Vector3 vec)
	{
		this.set(new Vector3(X * vec.getX(), Y * vec.getY(), Z * vec.getZ()));
	}
	
	public void Mult(double val)
	{
		this.set(new Vector3(X * val, Y * val, Z * val));
	}
	
	public void Mult(float val)
	{
		this.set(new Vector3(X * (double)val, Y * (double)val, Z * (double)val));
	}
	
	public void Mult(int val)
	{
		this.set(new Vector3(X * (double)val, Y * (double)val, Z * (double)val));
	}
	
	public void Div(Vector3 vec)
	{
		this.set(new Vector3(X / vec.getX(), Y / vec.getY(), Z / vec.getZ()));
	}
	
	public void Div(double val)
	{
		this.set(new Vector3(X / val, Y / val, Z / val));
	}
	
	public void Div(float val)
	{
		this.set(new Vector3(X / (double)val, Y / (double)val, Z / (double)val));
	}
	
	public void Div(int val)
	{
		this.set(new Vector3(X / (double)val, Y / (double)val, Z / (double)val));
	}
}
