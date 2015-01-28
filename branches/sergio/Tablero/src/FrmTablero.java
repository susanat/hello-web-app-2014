import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class FrmTablero extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTablero frame = new FrmTablero();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	private void myInitComponents() 
	{
		
		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//le pasamos el número de filas y columnas
				
				//le pasamos el origen y el destino
				
				//le damos a ejecutar para llenar el listado
			}
		});
		
		cmbListRutas.setEditable(false);        
		cmbListRutas.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                
	            }
	          });
		
	}
	
	private JComboBox cmbListRutas;
	private JButton btnComprobar;
	
	
	
	
	
	
	private void cargarComboRutas(List<List<Point>> rutas) throws IOException
    {
        System.out.println("cargarComboRutas: Carga del combo de las rutas.");
        
        //cargamos el listado con el nombre de fichero dado
        //lstManejador = new ClsCFGListados(fichero);
                
        //cargamos el combo        
        cmbListRutas.removeAllItems(); 
        //cmbListRutas.setModel(new DefaultComboBoxModel<>(manejador.getTipos().toArray()));
                
        
        
        
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Create the frame.
	 */
	public FrmTablero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{294, 14, 1, 0};
		gbl_contentPane.rowHeights = new int[]{14, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel pnlControles = new JPanel();
		pnlControles.setBorder(new LineBorder(Color.GREEN, 2));
		GridBagConstraints gbc_pnlControles = new GridBagConstraints();
		gbc_pnlControles.fill = GridBagConstraints.BOTH;
		gbc_pnlControles.gridwidth = 3;
		gbc_pnlControles.weightx = 1.0;
		gbc_pnlControles.insets = new Insets(0, 0, 0, 5);
		gbc_pnlControles.gridx = 0;
		gbc_pnlControles.gridy = 0;
		contentPane.add(pnlControles, gbc_pnlControles);
		pnlControles.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblOrigen = new JLabel("Origen:");
		pnlControles.add(lblOrigen);
		
		textField = new JTextField();
		pnlControles.add(textField);
		textField.setColumns(10);
		
		JLabel lblDestino = new JLabel("Destino:");
		pnlControles.add(lblDestino);
		
		textField_1 = new JTextField();
		pnlControles.add(textField_1);
		textField_1.setColumns(10);
		
		btnComprobar = new JButton("Comprobar");
		
		pnlControles.add(btnComprobar);
		
		JLabel lblListado = new JLabel("Listado");
		pnlControles.add(lblListado);
		
		cmbListRutas = new JComboBox();
		pnlControles.add(cmbListRutas);
		
		JPanel pnlTablero = new JPanel();
		pnlTablero.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GridBagConstraints gbc_pnlTablero = new GridBagConstraints();
		gbc_pnlTablero.weighty = 1.0;
		gbc_pnlTablero.fill = GridBagConstraints.BOTH;
		gbc_pnlTablero.gridwidth = 3;
		gbc_pnlTablero.weightx = 1.0;
		gbc_pnlTablero.gridx = 0;
		gbc_pnlTablero.gridy = 1;
		contentPane.add(pnlTablero, gbc_pnlTablero);
		pnlTablero.setLayout(null);
		
		
	}
}
