import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Cuadricula {
	
	public enum eCapas
    {
        capa1,
        capa2,
        capa3,
        capa4,
        capa5,
        capa6
    }

	private int x = 0; //coordenada anchura
	private int y = 0; //coordenada altura
	
	private int width = 0; //tamaño ancho
	private int height = 0; //Tamaño altura
	
	private Rectangle rectangulo = null;
	
	private Point nombre;
	
	//Color del borde de la cuadricula
    private Color _ColorBorde;
    private Boolean _mostrarBorde;
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Rectangle getRectangulo() {
		return rectangulo;
	}

	public void setRectangulo(Rectangle rectangulo) {
		this.rectangulo = rectangulo;
	}
	
	public Point getNombre() {
		return nombre;
	}

	public void setNombre(Point nombre) {
		this.nombre = nombre;
	}
	
	public Color get_ColorBorde() {
		return _ColorBorde;
	}

	public void set_ColorBorde(Color _ColorBorde) {
		this._ColorBorde = _ColorBorde;
	}

	public Boolean get_mostrarBorde() {
		return _mostrarBorde;
	}

	public void set_mostrarBorde(Boolean _mostrarBorde) {
		this._mostrarBorde = _mostrarBorde;
	}

	public Cuadricula(int x, int y, int width, int height) {
		super();
		this.setX(x);
		this.setY(y);
		this.setWidth(width);
		this.setHeight(height);
	}

	public void dibujar(Graphics g) {
		g.drawRect(x, y, width, height);
	}
	
	//Crea el rectángulo
    public void CrearRectangulo()
    {
        this.rectangulo = new Rectangle(x, y, width, height);
    }
	
	/// <summary>
    /// calculamos la posición del vértice opuesto a X e Y de la cuadricula
    /// </summary>
    /// <returns>Devuelve un point con la posición del vértice opuesto</returns>
    private Point CalcularVerticeB()
    {
        return new Point(x + width, y + height);
    }
	
}
