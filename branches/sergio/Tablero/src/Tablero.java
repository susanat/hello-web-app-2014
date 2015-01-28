import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;


public class Tablero {

	
    /// <summary>
    /// Enumeración de la dirección de una cuadrícula respecto a otra.
    /// </summary>
    public enum eDireccion{
        CasillaNorte,
        CasillaNorDeste,
        CasillaEste,
        CasillaSureste,
        CasillaSur,
        CasillaSurOeste,
        CasillaOeste,
        CasillaNoroEste
    };
            
    //para el buffer
    //public Bitmap ImageBuffer;
    private Graphics GraficoBuffer;               
    
    //colección que contendrá las cuadrículas (nombre y cuadricula de tipo cuadrícula)
    private HashMap<Point,Cuadricula> lstCuadriculas = new HashMap<Point,Cuadricula>(); 

    //numero de filas y columnas
    private int _filas; // r accesible Filas
    private int _columnas; // r accesible Columnas                      

    //Tamaño de cada cuadricula
    private int _width;// r accesible TamanoCuadricula
    private int _height;// r accesible TamanoCuadricula
            
    //posición del tablero
    private int _posx; // r/w accesible PosicionTablero
    private int _posy; // r/w accesible PosicionTablero

    //Tamaño del tablero
    private int _tableroWidth; // r accesible TamanoTablero
    private int _tableroHeight; // r accesible TamanoTablero
    
    //rectántulo que utiliza el tablero 
    private Rectangle _rectanguloTablero; // no accesible
    public Rectangle getRectanguloTablero()
    {
         return _rectanguloTablero;
    }

    //Apariencia
    private Image _imagenFondo; // r/w accesible ImagenFondo       
    private Color _ColorFondoTablero; //r/w accesible ColorFondo        
    //private SolidBrush _BrushFondo;
    private Color _ColorBordeCuadriculas ;
                   
    //Estado
    private Boolean _EstaCreado; // r accesible EstaCreadoTablero
    private Point _cuadriculaActiva; //accesible CuadriculaActiva
    private Point _cuadriculaSeleccionada; //accesible CuadriculaSeleccionada

    private void InicializarComponentes(){

        lstCuadriculas = new HashMap<Point, Cuadricula>();
        _filas = 4;
        _columnas = 4;
        _height = 40;
        _width = 40;
        _posx = 0;
        _posy = 0;
        _imagenFondo = null;
        _ColorFondoTablero = Color.white;
        //_BrushFondo = new SolidBrush(Color.Transparent);
        _ColorBordeCuadriculas = Color.black;
        _EstaCreado = false;
        _cuadriculaActiva = null;
        _cuadriculaSeleccionada = null;            
    }

    /// <summary>
    /// listado de los identificadores de las cuadrículas existentes en el tablero
    /// </summary>
    public List<Point> getListadoCuadriculas()
    {
        
    	return new ArrayList<Point>(lstCuadriculas.keySet());
    	
    	//return lstCuadriculas.keySet() ;
    }
    /// <summary>
    /// Imagen que contiene el dibujo del tablero
    /// </summary>
    
    /*
    public Image getImgBuffer()
    {
        return ImageBuffer;
    }
    */
    /// <summary>
    /// color de los bordes de las cuadrículas
    /// </summary>
    public Color getColorBordeCuadriculas()
    {
        return _ColorBordeCuadriculas;
    }

	public void setColorBordeCuadriculas(Color color){
		this._ColorBordeCuadriculas = color;
		ModificarColorBordeCuadriculas();
	}
		

    /// <summary>
    /// Asigna o devuelve la posición del tablero
    /// </summary>
    public Point getPosicionTablero()
    {
        return new Point(_posx,_posy);                    
    }
    
    public void setPosicionTablero(Point value) {    	
            _posx = value.x;
            _posy = value.y;        
    }
    
    /// <summary>
    /// Devuelve el número de filas
    /// </summary>
    public int getFilas()
    {
        return _filas;        
    }
    
    /// <summary>
    /// Devuelve el número de columnas
    /// </summary>
    public int Columnas()
    {
        return _columnas;        
    }
    
    /// <summary>
    /// Devuelve el tamaño del tablero
    /// </summary>
    
    /*
    public Size TamanoTablero()
    {
        return new Size(_tableroWidth, _tableroHeight); 
    } 
    */
    
    
    /// <summary>
    /// Comprueba si el tablero está creado
    /// </summary>
    public Boolean EstaCreadoTablero()
    {
        return _EstaCreado;           
    }
    /// <summary>
    /// Asigna o devuelve el color de fondo del tablero
    /// </summary>
    public Color getColorFondo()
    {
        return _ColorFondoTablero;
    }
    
    
    public void setColorFondo(Color value) {
    	_ColorFondoTablero = value;
        //_BrushFondo.Color = _ColorFondoTablero;
        //this.ActualizarDibujo();  
    }
    
    /// <summary>
    /// Imagen que contendrá el fondo del tablero
    /// </summary>
    public Image ImagenFondo ()
    {
        return _imagenFondo;
        
    }
    
    public void setImagenFondo(Image imagen) {
    	_imagenFondo = imagen;
        //ActualizarDibujo();
    }
    	

   /// <summary>
   /// Devuelve el point de la cuadrícula activa
   /// </summary>
    public Point getCuadriculaActiva()
    {
        return _cuadriculaActiva;
    }

    public void setCuadriculaSeleccionada(Point p) {
    	_cuadriculaActiva = p;
    }
    	
    
    public Point getCuadriculaSeleccionada()
    {
        return _cuadriculaSeleccionada;        
    }
    
    /*
    public Size TamanoCuadricula()
    {
        return new Size(_width, _height);
        
    } 
    */ 

    public Tablero(int Filas, int Columnas, int Width, int Height, int PosX, int PosY)
    {
        InicializarComponentes();

        this._filas = Filas;
        this._columnas = Columnas;
        this._width = Width;
        this._height = Height;
        this._posx = PosX;
        this._posy = PosY;
        
        CrearTablero();
        //_BrushFondo = new SolidBrush(_ColorFondoTablero);
    }

    public Tablero(int Filas, int Columnas, int width, int height, Point Posicion)
    {
        InicializarComponentes();

        this._filas = Filas;
        this._columnas = Columnas;
        this._width = width;
        this._height = height;
        this._posx = Posicion.x;
        this._posy = Posicion.y;

        CrearTablero();
        //_BrushFondo = new SolidBrush(_ColorFondoTablero);
    }

    public Tablero(int Filas, int Columnas, int Width, int Height)
    {
        InicializarComponentes();

        this._filas = Filas;
        this._columnas = Columnas;
        this._width = Width;
        this._height = Height;
     
        CrearTablero();
        //_BrushFondo = new SolidBrush(_ColorFondoTablero);
    }
 

 
    /// <summary>
    /// Función que crea desde 0 el tablero
    /// </summary>
    private void CrearTablero()
    {

        //Posición inicial de la primera cuadrícula
        int lPosy = 0;
        int lPosx = 0;

        //creamos el objeto de cuadrícula
        Cuadricula objCuadricula;

        //inicializamos las listas
        lstCuadriculas = new HashMap<Point, Cuadricula>();
        
        for (int x = 0; x < _filas; x++)
        {
            for (int i = 0; i < _columnas; i++)
            {
                //creamos el objeto cuadricula
                objCuadricula = new Cuadricula(lPosx,lPosy,_width,_height);
                //le asignamos el nombre
                objCuadricula.setNombre(new Point(x, i));
                                                       
                //cargamos el listado de cuadriculas
                lstCuadriculas.put(objCuadricula.getNombre(), objCuadricula);
                
                lPosx += _width;
            }
            lPosy += _height;
            lPosx = 0;
        }

        //tamaño del tablero
        _tableroWidth = (_width * _columnas) + 1;
        _tableroHeight = (_height * _filas) + 1;

        //tamaño del rectángulo del tablero
        _rectanguloTablero = new Rectangle(0, 0, _tableroWidth, _tableroHeight);

        //marcamos el tablero como creado
        _EstaCreado = true;

        //preparamos los buffers para el dibujo del tablero (el bitmap con transparencias)
        //ImageBuffer = new Bitmap(_tableroWidth, _tableroHeight,PixelFormat.Format32bppArgb);
        //GraficoBuffer = Graphics.FromImage(ImageBuffer);

        //ActualizarDibujo();
    }

    /// <summary>
    /// Función que recrea el tablero manteniendo algunas de sus propiedades
    /// </summary>
    private void ReCrearTablero()
    {
        //Posición inicial de la primera cuadrícula
        int lPosy = 0;
        int lPosx = 0;

        Point nombre; //variable que contendrá el identificador de la cuadrícula
        
        for (int x = 0; x < _filas; x++)
        {
            for (int i = 0; i < _columnas; i++)
            {
                nombre = new Point(x, i);
                //recreamos los datos de la cuadrícula
                lstCuadriculas.get(nombre).setX(lPosx);
                lstCuadriculas.get(nombre).setY(lPosy);
                lstCuadriculas.get(nombre).setHeight(_height);
                lstCuadriculas.get(nombre).setWidth(_width);
                lstCuadriculas.get(nombre).set_ColorBorde(_ColorBordeCuadriculas);
                lstCuadriculas.get(nombre).CrearRectangulo();                 

                lPosx += _width;
            }
            lPosy += _height;
            lPosx = 0;
        }

        //tamaño del tablero
        _tableroWidth = (_width * _columnas) + 1;
        _tableroHeight = (_height * _filas) + 1;

        //tamaño del rectángulo del tablero
        //_rectanguloTablero = new Rectangle(_posx, _posy, _tableroWidth, _tableroHeight);
        _rectanguloTablero.x = 0;
        _rectanguloTablero.y = 0;
        _rectanguloTablero.width = _tableroWidth;
        _rectanguloTablero.height = _tableroHeight;   

        //preparamos los buffers para el dibujo del tablero (el bitmap con transparencias)
        //ImageBuffer = new Bitmap(_tableroWidth, _tableroHeight, PixelFormat.Format32bppArgb);
        //GraficoBuffer = Graphics.FromImage(ImageBuffer);
        
        //redibujamos el tablero
        //ActualizarDibujo();
    }

    /// <summary>
    /// Función que dibuja el tablero en una imagen
    /// </summary>
    
    /*
    public void ActualizarDibujo()
    {
        //limpiamos el buffer
        //GraficoBuffer.Clear(Color.Transparent);

        //color de fondo
        //GraficoBuffer.FillRectangle(_BrushFondo, _rectanguloTablero);

        //Dibujamos la imagen de fondo si la tiene
        if (_imagenFondo != null)            
        {                                              
            GraficoBuffer. .DrawImage(_imagenFondo, _rectanguloTablero);
        }

        //dibujamos las cuadrículas
        foreach (KeyValuePair<Point, Cuadricula> Cua in lstCuadriculas)
        {
            Cua.Value.Dibujar(GraficoBuffer);
        }

        //lanzamos el evento de dibujado
        if (Dibujado != null)
            this.Dibujado();

        //Borde para el tablero
        //GraficoBuffer.DrawRectangle(new Pen(Color.Red), _rectanguloTablero);

    }
    */

    /// <summary>
    /// Función que dibuja solo una cuadrícula en la imagen
    /// </summary>
    /// <param name="coordenada"></param>
    /*
    public void ActualizarDibujo(Point coordenada)
    {
        //redibujamos solo la cuadrícula indicada
        lstCuadriculas[coordenada].Dibujar(GraficoBuffer);
        if (Dibujado != null)
            this.Dibujado();
    }
    */

    /// <summary>
    /// Función que dibuja la imagen del tablero en un Graphics
    /// </summary>
    /// <param name="SpriteBatch"></param>
    /*
    public void DiujarTablero(Graphics SpriteBatch)
    {           
        //Dibujamos en el graphics que le pasemos en la posición indicada
        SpriteBatch.DrawImage(ImageBuffer, new Point(_posx,_posy));
    }
    */

    /*
    /// <summary>
    /// Añade filas al final del tablero
    /// </summary>
    /// <param name="nColumnas">Número de filas a añadir</param>
    public void AnadirFila(int nFilas)
    {
        if (nFilas > 0)
        {
            for (int x = 0; x < nFilas; x++)
            {
                _filas += 1;
                for (int i = 0; i < _columnas; i++)
                {
                    //creo una cuadrícula estandar
                    Cuadricula cua = new Cuadricula(0, 0, 0, 0);
                    cua.ColorBorde = _ColorBordeCuadriculas;
                    lstCuadriculas.Add(new Point(_filas - 1, i), cua);
                }
            }

            ReCrearTablero();
        }
    }

    /// <summary>
    /// Añade columnas al final tablero
    /// </summary>
    /// <param name="nColumnas">Número de columnas a añadir</param>
    public void AnadirColumna(int nColumnas)
    {
        if (nColumnas > 0)
        {

            for (int i = 0; i < nColumnas; i++)
            {
                _columnas += 1;

                for (int x = 0; x < _filas; x++)
                {
                    //creo una cuadrícula estandar
                    Cuadricula cua = new Cuadricula(0, 0, 0, 0);
                    cua.ColorBorde = _ColorBordeCuadriculas;
                    lstCuadriculas.Add(new Point(x, _columnas - 1), cua);
                }
            }
            ReCrearTablero();
        }
    }

    /// <summary>
    /// Elimina filas del final tablero, jungo con sus propiedades
    /// </summary>
    /// <param name="nColumnas">Número de filas a eliminar</param>
    public void EliminarFila(int nFilas)
    {
        if (nFilas > 0)
        {
            for (int x = 0; x < nFilas; x++)
            {
                _filas -= 1;
                for (int i = 0; i < _columnas; i++)
                {
                    lstCuadriculas.Remove(new Point(_filas, i));
                }
            }
            ReCrearTablero();
        }

    }

    /// <summary>
    /// Elimina columnas del final tablero, jungo con sus propiedades
    /// </summary>
    /// <param name="nColumnas">Número de columnas a eliminar</param>
    public void EliminarColumna(int nColumnas)
    {
        if (nColumnas > 0)
        {
            for (int i = 0; i < nColumnas; i++)
            {
                _columnas -= 1;
                for (int x = 0; x < _filas; x++)
                {

                    lstCuadriculas.Remove(new Point(x, _columnas));
                }
            }
            ReCrearTablero();
        }
    }
    
    */
    
    /// <summary>
    /// Comprueba si existe una cuadrícula por su identificador
    /// </summary>
    /// <param name="value">Identificador de cuadrícula (Point)</param>
    /// <returns>True si existe</returns>
    public Boolean ExisteCuadicula(Point value)
    {
        if (value == null)
            return false;
        
        return lstCuadriculas.containsKey(value);
    }

    /// <summary>
    /// Modifica el color de los bordes de cada cuadrícula
    /// </summary>
    private void ModificarColorBordeCuadriculas()
    {
    	
    	for(Entry<Point, Cuadricula> c : lstCuadriculas.entrySet()) {
    		
    		c.getValue().set_ColorBorde(_ColorBordeCuadriculas);
    		
    	}
    	   	
        
        //ActualizarDibujo();
    }

    /// <summary>
    /// Elimina la imagen de una capa de todas las cuadrículas(lento)
    /// </summary>
    /// <param name="capa"></param>
    public void LimpiarCapa(Cuadricula.eCapas capa)
    {
        for(Point p : lstCuadriculas.keySet())
        {
            AsignarImagenACuadricula(p, null, capa, false);
        }

        //ActualizarDibujo();
    }

    /// <summary>
    /// Asigna una imagen a una cuadrícula en la capa indicada.
    /// </summary>
    /// <param name="cua">identificador de cuadrícula (point)</param>
    /// <param name="imagen">Imagen a añadir a la capa</param>
    /// <param name="capa">Capa a la que se le añadirá la imagen</param>
    /// <param name="actualizarDibulo">Permite o evita que se actualice el dibujo</param>
    public void AsignarImagenACuadricula(Point cua, Image imagen, Cuadricula.eCapas capa, Boolean actualizarDibujo)
    {
    	/*
        if (ExisteCuadicula(cua))
        {
            lstCuadriculas[cua].AsignarCapa(imagen, capa);
            //ActualizarDibujo(cua.Value);
            if(actualizarDibujo)
                ActualizarDibujo();
        }
        */
    }

    /*
    /// <summary>
    /// Obtener una imagen a una cuadrícula en la capa indicada.
    /// </summary>
    /// <param name="cua">Identificador de cuadrícula (point)</param>
    /// <param name="capa">Capa de la que queremos obtener la imagen</param>
    /// <returns></returns>
    public Image ObtenerImagenDeCuadricula(Point cua, Cuadricula.eCapas capa)
    {
        if (ExisteCuadicula(cua))
        {
            return lstCuadriculas[cua].ObtenerCapa(capa);                
        }
        return null;
    }
	*/

    /// <summary>
    /// Función para obtener el rectángulo de una cuadrícula
    /// </summary>
    /// <param name="value">Identificador de la cuadrícula (Point)</param>
    /// <returns>El rectángulo de la cuadrícula indicada</returns>
    public Rectangle ObtenerRectanguloDeCuadricula(Point value)
    {
        if (ExisteCuadicula(value))
            //return lstCuadriculas[value].Rectangulo;
        	return lstCuadriculas.get(value).getRectangulo();
        else
            return null;            
    }

    /// <summary>
    /// Aumenta el tamaño de las cuadrículas
    /// </summary>
    /// <param name="zoomIn">Unidades a aumentar</param>
    public void ZoomIn(int zoomIn)
    {                       
        _height += zoomIn;
        _width += zoomIn;
     
        ReCrearTablero(); 
    }

    /// <summary>
    /// Disminuye el tamaño de las cuadrículas
    /// </summary>
    /// <param name="zoomOut">Unidades a disminuir</param>
    public void ZoomOut(int zoomOut)
    {                            
        _height -= zoomOut;
        _width -= zoomOut;

        ReCrearTablero();
    }


    /// <summary>
    /// Función que devuelve el point de la cuadricula en la que está la coordenada
    /// </summary>
    /// <param name="coorRaton">Corrdenadas</param>
    /// <returns></returns>
    public Point CasillaDeCoordenadaRaton(Point coorRaton)
    {
    	for(Entry<Point, Cuadricula> cua : lstCuadriculas.entrySet()) {
    		if(cua.getValue().getRectangulo().contains(coorRaton)) {
    			return cua.getKey();
    		}
    	}
    	
    	return null;        
    }

    /// <summary>
    /// Función para conocer la cuadricula sobre la que se situa el raton
    /// </summary>
    /// <param name="coorRaton"></param>
    /// <returns>La coordenada o null si no encuentra coincidencia</returns>
    //public Point CoordenadaCuadriculaActiva(Point coorRaton)
    //{
    //    //comprobamos si coincide con alguna cuadricula          
    //        Point c = CasillaDeCoordenadaRaton(coorRaton);
    //        _cuadriculaActiva = c;
    //        return c;          
    //}

    /// <summary>
    /// Comprueba si unas coordenadas se encuentran dentro del tablero
    /// </summary>
    /// <param name="coorRaton"></param>
    /// <returns></returns>
    public Boolean CursorEnTablero(Point coorRaton)
    {
        return _rectanguloTablero.contains(coorRaton);
    }

    /// <summary>
    /// Función que devuelve el nombre de la casilla adyacente que le indiquemos
    /// </summary>
    /// <param name="casillaCentral"></param>
    /// <param name="Direccion"></param>
    /// <returns></returns>
    public Point DameCoordenadasCasillaAdyacente(Point casillaCentral, eDireccion Direccion)
    {
        //int[] resultado = new int[2];
        Point resultado = new Point();
        //Distancia de las casillas (proximamente)
        int casillasDistancias = 1;

        /*Cajas subyacentes
        '  1,1  1,0  1,-1 
        '  0,1       1,0
        ' -1,1 -1,0 -1,-1*/
        switch (Direccion)
        {
            case CasillaNoroEste:
                resultado.x = casillaCentral.x - casillasDistancias;
                resultado.y = casillaCentral.y - casillasDistancias;
                break;
            case CasillaNorte:
                resultado.x = casillaCentral.x - casillasDistancias;
                resultado.y = casillaCentral.y;
                break;
            case CasillaNorDeste:
                resultado.x = casillaCentral.x - casillasDistancias;
                resultado.y = casillaCentral.y + casillasDistancias;
                break;
            case CasillaEste:
                resultado.x = casillaCentral.x;
                resultado.y = casillaCentral.y + casillasDistancias;
                break;
            case CasillaSureste:
                resultado.x = casillaCentral.x + casillasDistancias;
                resultado.y = casillaCentral.y + casillasDistancias;
                break;
            case CasillaSur:
                resultado.x = casillaCentral.x + casillasDistancias;
                resultado.y = casillaCentral.y;
                break;
            case CasillaSurOeste:
                resultado.x = casillaCentral.x + casillasDistancias;
                resultado.y = casillaCentral.y - casillasDistancias;
                break;
            case CasillaOeste:
                resultado.x = casillaCentral.x;
                resultado.y = casillaCentral.y - casillasDistancias;
                break;
        }

        if (ExisteCuadicula(resultado))
            return resultado;
        else
            return null;
    }

    
    /*

    public static Image ResizeImage(Image srcImage, int newWidth, int newHeight)
    {
        using (Bitmap imagenBitmap =
           new Bitmap(newWidth, newHeight, PixelFormat.Format32bppRgb))
        {
            imagenBitmap.SetResolution(
               Convert.Toint(srcImage.HorizontalResolution),
               Convert.Toint(srcImage.HorizontalResolution));

            using (Graphics imagenGraphics =
                    Graphics.FromImage(imagenBitmap))
            {
                imagenGraphics.SmoothingMode =
                   SmoothingMode.AntiAlias;
                imagenGraphics.InterpolationMode =
                   InterpolationMode.HighQualityBicubic;
                imagenGraphics.PixelOffsetMode =
                   PixelOffsetMode.HighQuality;
                imagenGraphics.DrawImage(srcImage,
                   new Rectangle(0, 0, newWidth, newHeight),
                   new Rectangle(0, 0, srcImage.Width, srcImage.Height),
                   GraphicsUnit.Pixel);
                MemoryStream imagenMemoryStream = new MemoryStream();
                imagenBitmap.Save(imagenMemoryStream, ImageFormat.Jpeg);
                srcImage = Image.FromStream(imagenMemoryStream);
            }
        }
        return srcImage;
    }
    */

    /// <summary>
    /// obtiene una imagen del tablero
    /// </summary>
    /// <returns>Imagen del tablero</returns>
    /*
    public Image ObtenerThumb()
    {
        
        Size a = TamanoCuadricula;
        _width = 50;
        _height = 50;
        ReCrearTablero();

        Image th = ImageBuffer;

        _width = a.Width;
        _height = a.Height;
        ReCrearTablero();


        return th;
    }
    */

}


