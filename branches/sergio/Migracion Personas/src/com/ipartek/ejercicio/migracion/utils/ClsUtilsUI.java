package com.ipartek.ejercicio.migracion.utils;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.ListModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 * Clase de recopilación de funciones útiles para los controles UI de swing
 * 
 * @author baskito
 * @version 03.11.2014
 */
public class ClsUtilsUI {

	public static void clearListModel(JList<?> lista)
    {
        DefaultListModel listModel = new DefaultListModel();
        listModel.removeAllElements();
        lista.setModel(listModel); 
    }
    
    public static void clearComboBox(JComboBox combo){    	
    	
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.removeAllElements();
        combo.setModel(model); 
    }
    
    public static void clearTreeModel(JTree arbol){
        DefaultMutableTreeNode rootPadre = new DefaultMutableTreeNode("Empty");           
        DefaultTreeModel modeloPadre = new DefaultTreeModel(rootPadre); 
        arbol.setModel(modeloPadre);
    }
    
    public static boolean exitJFrame(JFrame jframe)
    {
        int result = JOptionPane.showConfirmDialog(
                jframe,
                "¿Esta seguro?",
                "Exit Application",
                JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean solicitarConfirmacion(JFrame jframe, String texto, String titulo)
    {
        int result = JOptionPane.showConfirmDialog(
                jframe,
                texto,
                titulo,
                JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            return true;
        } else {
            return false;
        }
    }
    
    public static void mensajeError(String titulo, String texto)
    {
        JOptionPane.showMessageDialog(null, texto,titulo,JOptionPane.ERROR_MESSAGE);
    }
    
    
    public static Thread showNoModalAlert(final String message, final String title) throws InterruptedException{
	Thread t = new Thread(new Runnable(){
	        public void run(){
	            JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
	        }
	    });
	    t.start();
	    t.join();
	    
	    return t;
    }
    
    public static Thread showNoModalInformation(final String message, final String title) throws InterruptedException{
	Thread t = new Thread(new Runnable(){
	        public void run(){
	            JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	        }
	    });
	    t.start();
	    t.join();
	return t;
    }
}
