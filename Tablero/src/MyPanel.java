import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


public class MyPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1998389229744523235L;

	
	//valor que se mostrará en el dado
    private int val;    
    
    //variables para el dibujo
    private Dimension size = new Dimension(30,30);    
    private Dimension dot = new Dimension((int)(size.width/3), (int)(size.height/3));
    private Dimension arc = new Dimension((int)Math.sqrt(size.width), (int)Math.sqrt(size.height));
    
    
    //////////////////////variables para el timer
    private TimerTask timerTask = null;
    private Timer timer = null;  
    
    //intervalo de tiempo en el que se realiza el cambio de dado (velocidad)
    private int period = 200;
    public void setCadenciaCambio(int milisegundos) throws Exception  {
        if(milisegundos < 1) 
            throw new Exception("La cadencia ha de ser mayor que 0");
                
        this.period = milisegundos;
        
    }    
    public int getCadenciaCambio(){
        return period;
    }
    
    //duración de la animación
    private int duracion = 5000;
    public void setDuracion(int milisegundos) throws Exception {
        if(milisegundos < 0) 
            throw new Exception("La duración ha de ser mayor o igual a 0");
        
        this.duracion = milisegundos;
    }
    public int getDuracion(){
        return duracion;
    }
    
    private int delay = 0;
    public void setDelay(int milisegundos) throws Exception {
        if(milisegundos < 0) 
            throw new Exception("La retardo ha de ser mayor o igual a 0");
        
        this.delay = milisegundos;
    }
    public int getDelay(){
        return delay;
    }
    
    //Flag para el conteo del tiempo pasado para terminar la animación
    private int tiempoPasado = 0;    
    //flags para evitar que se repitan en la animación el mismo número seguido
    private int valAnterior = 0;
    private int valActual = 0;
    //////////////////////////////////////////////////////////////
    
    //resultado cuando se inicia
    private int resultado = 0;
    
    public int getResultado(){
        return resultado;
    }
    
    public MyPanel(int val){
        this.val = val;
        
        //repinta cuando se redimensiona
        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent evt) {
                 size = getPreferredSize();
                 repaint();
            }
        });
    }
    
    public void setValue(int val){
        this.val = val;
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        if(val != -1)
        {
            // turn on anti-alias mode
            Graphics2D antiAlias = (Graphics2D)g;
            antiAlias.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // draw white rectangle
            g.setColor(Color.WHITE);
            g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc.width, arc.height);

            // draw black border
           
            g.setColor(Color.BLACK);
            
            g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc.width, arc.height);

            // draw inside light border
            g.setColor(Color.decode("#c0c0c0"));
            g.drawRoundRect(1, 1, getWidth() - 3, getHeight() - 3, arc.width, arc.height);

            int height;
            int width = height = dot.height * 2/3;

            // possible positions for each dot on the dice
            int left   = getWidth() * 1/3 - dot.width/2 - width * 1/4;
            int center = getWidth() * 2/3 - dot.width/2 - width * 1/2;
            int right  = getWidth() * 3/3 - dot.width/2 - width * 3/4;

            int top    = getHeight() * 1/3 - dot.height/2 - height * 1/4;
            int middle = getHeight() * 2/3 - dot.height/2 - height * 1/2;
            int bottom = getHeight() * 3/3 - dot.height/2 - height * 3/4;

            // draw the dots
            g.setColor(Color.BLACK);
            switch(val)
            {
                case 0:
                    break;
                case 1:
                    g.fillOval(center, middle, width, height);
                    break;
                case 2:
                    g.fillOval(right, top, width, height);
                    g.fillOval(left, bottom, width, height);
                    break;
                case 3:
                    g.fillOval(right, top, width, height);
                    g.fillOval(center, middle, width, height);
                    g.fillOval(left, bottom, width, height);
                    break;
                case 4:
                    g.fillOval(left, top, width, height);
                    g.fillOval(left, bottom, width, height);
                    g.fillOval(right, top, width, height);
                    g.fillOval(right, bottom, width, height);
                    break;
                case 5:
                    g.fillOval(left, top, width, height);
                    g.fillOval(left, bottom, width, height);
                    g.fillOval(right, top, width, height);
                    g.fillOval(right, bottom, width, height);
                    g.fillOval(center, middle, width, height);
                    break;
                case 6:
                    g.fillOval(left, top, width, height);
                    g.fillOval(left, middle, width, height);
                    g.fillOval(left, bottom, width, height);
                    g.fillOval(right, top, width, height);
                    g.fillOval(right, middle, width, height);
                    g.fillOval(right, bottom, width, height);
                    break;
                case 7:
                    g.fillOval(left, top, width, height);
                    g.fillOval(left, middle, width, height);
                    g.fillOval(left, bottom, width, height);
                    g.fillOval(right, top, width, height);
                    g.fillOval(right, middle, width, height);
                    g.fillOval(right, bottom, width, height);
                    g.fillOval(center, middle, width, height);
                    break;
                case 8:
                    g.fillOval(left, top, width, height);
                    g.fillOval(left, middle, width, height);
                    g.fillOval(left, bottom, width, height);
                    g.fillOval(right, top, width, height);
                    g.fillOval(right, middle, width, height);
                    g.fillOval(right, bottom, width, height);
                    g.fillOval(center, top, width, height);
                    //g.fillOval(center, middle, width, height);
                    g.fillOval(center, bottom, width, height);
                    break;
                case 9:
                    g.fillOval(left, top, width, height);
                    g.fillOval(left, middle, width, height);
                    g.fillOval(left, bottom, width, height);
                    g.fillOval(right, top, width, height);
                    g.fillOval(right, middle, width, height);
                    g.fillOval(right, bottom, width, height);
                    g.fillOval(center, top, width, height);
                    g.fillOval(center, middle, width, height);
                    g.fillOval(center, bottom, width, height);
                    break;
            }
        }
    }
    
    @Override
    public void setPreferredSize(Dimension preferredSize) {
        super.setPreferredSize(preferredSize);
        size = preferredSize;
        dot = new Dimension((int)(size.width/3), (int)(size.height/3));
        arc = new Dimension((int)Math.sqrt(size.width), (int)Math.sqrt(size.height));        
        updateUI(); 
    }
    
    public void start(int cadencia, int duracion, int delay)
    {
        //obtenemos el resultado
        resultado = valorAleatorio(1, 6); 
        
        //inicializamos la animación
        inicializarTimer();         
        //empezamos la animación
        // Dentro de X milisegundos avísame cada X milisegundos
        timer.scheduleAtFixedRate(timerTask, delay, period); 
        
        System.out.println("Resultado: " + resultado);
    }
    
    public void start()
    {
        start(period, duracion, delay);        
    }
    
    private void inicializarTimer(){
        valAnterior = 0;
        tiempoPasado = 0;
        valActual = 0;
        
        // Clase en la que está el código a ejecutar
        timerTask = new TimerTask()
        {
            @Override
            public void run() 
            {
                elRunable();
            }
        };
         // Aquí se pone en marcha el timer cada segundo.
        timer = new Timer();        
    }
    
    private void elRunable(){
        //para que no se repita un número seguido en el mostrado del dado
            do{
                valActual = valorAleatorio(1, 6);
            }while(valActual == valAnterior);                  
            valAnterior = valActual;

            //aumentamos el tiempo que ha pasado
            tiempoPasado = tiempoPasado + period;

            //cambiamos el valor del dado
            setValue(valorAleatorio(1, 6));

            //acabamos cuando el tiempo ha terminado
            if(tiempoPasado > duracion)
            {
                timer.cancel();
                timer = null;
                setValue(resultado);
                onDadoStop(this, resultado);
            }
    }
    
    public void stop()
    {
        if (timer != null){
            timer.cancel();
            timer = null;
        }
        
        if(resultado != 0)
            setValue(resultado);
        
        onDadoStop(this, resultado);        
    }
    
    //Combatiente
    //paso 1
    public static interface dadoListener extends EventListener{                          
        void onDadoStop(MyPanel dado, int resultado);        
    }
    //paso 2
    private List<dadoListener> dadoIlisteners=new ArrayList<>();
    public void addListadoListener(dadoListener listener){
        dadoIlisteners.add(listener);
    }
    public void removeListadoListener(dadoListener listener){
        dadoIlisteners.remove(listener);
    }
    //paso 3
    protected void onDadoStop(MyPanel dado, int resultado){
        for(dadoListener listener:dadoIlisteners)
            listener.onDadoStop(dado, resultado);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        // Elementos de la pantalla
        JFrame j = new JFrame("Imagen en JLabel");
        j.setLayout(null);
        j.setDefaultCloseOperation(DISPOSE_ON_CLOSE);        
        j.setMinimumSize(new Dimension(300,350));
        j.setResizable(true);
        j.setVisible(true);
         
        j.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        j.addWindowListener(   
            new java.awt.event.WindowAdapter()   
            {
                @Override              
                public void windowClosing( java.awt.event.WindowEvent e )                 
                {         
                    System.exit(0);          
                }  
            }           
         ); 
         
        final List<MyPanel> lstDado = new ArrayList<>();
        MyPanel dado = null;
        
        for (int i = 0; i<10; i++)
        {
            dado = new MyPanel(1);
            //dado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));        
            dado.setPreferredSize(new Dimension(50,50));
            lstDado.add(dado);
            j.add(dado);
            dado.setName("Dado" + i);
            j.revalidate();
            dado.start(100,5000,i*200);
            dado.addListadoListener(new dadoListener() {

                @Override
                public void onDadoStop(MyPanel dado, int resultado) {
                    System.out.println("Ha finalizado " + dado.getName() + " con el resultado: " + resultado);
                }
            });
        }
        
    }    
    
    /**
     * Obtiene un valor aleatorio entero entre los dos números indicados, ambos inclusive.
     * @param desde Límite inferior
     * @param hasta Límite superior
     * @return entero con el valor aleatorio     
     */
    public static int valorAleatorio(int desde, int hasta)
    {               
        return  (int) Math.floor(Math.random()*(hasta-desde+1)+ desde);  // Valor entre M y N, ambos incluidos.
    
    }
}
