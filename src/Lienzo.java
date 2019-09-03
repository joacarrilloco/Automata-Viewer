import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Lienzo extends JPanel implements MouseListener {

	public ArrayList< Nodo > nodos;
	public ArrayList< Arista > aristas;
	private Nodo p, q;
	
	public boolean botonNuevoNodo;
	public boolean botonNuevaArista;
	
	
	public Lienzo(){
		this.nodos = new ArrayList < Nodo >();
		this.aristas = new ArrayList < Arista >();
		this.addMouseListener(this);
		botonNuevoNodo = false;
		botonNuevaArista = false;
		p = null;
		q = null;
	}
	
	
	void validateString(){
		String cadena = JOptionPane.showInputDialog("Ingrese la cadena que desea testear");
		
		int estado_actual = 0;
		boolean es_aceptacion = nodos.get(0).aceptacion;
		
		for(int i = 0; i<cadena.length(); i++){
			
			int siguiente = -1;
			for( Arista ar : aristas) {
				
				for( Character con : ar.etiquetas ){
					if( ar.desde.id == estado_actual && con == cadena.charAt(i)){
						siguiente = ar.hasta.id;
						es_aceptacion = ar.hasta.aceptacion;
						break;
					}
				}
				
			}
			estado_actual = siguiente;
			if( estado_actual == -1 ) break;
		}
		
		if( estado_actual == -1 || es_aceptacion == false ){
			String str = "La cadena " + cadena + " NO es de aceptacion.";
			JOptionPane.showMessageDialog(null, str);
		}else{
			String str = "La cadena " + cadena + " SI es de aceptacion.";
			JOptionPane.showMessageDialog(null, str);
		}
		
	}
	

	@Override
	public void paint(Graphics g){
		for(Nodo n : nodos){
			n.pintar(g);
		}
		for(Arista a : aristas){
			a.pintar(g);
		}
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e ) {
		// TODO Auto-generated method stub
		if( botonNuevoNodo == true && e.getButton() == MouseEvent.BUTTON1) {
			int id = nodos.size();
			
			String aceptacion = JOptionPane.showInputDialog("Ingrese 1 si el estado Q" + id + " es estado de aceptacion, 0 si no lo es");
			if( aceptacion != null){
				int b = Integer.parseInt(aceptacion);
				this.nodos.add(new Nodo ( e.getX(), e.getY(), id , b));
				repaint();
			}
			botonNuevoNodo = false;
		}
		
		if( botonNuevaArista == true && e.getButton() == MouseEvent.BUTTON1 ){
			
			for( Nodo n : nodos ){
				
				if( (n.x - e.getX()) * (n.x - e.getX()) + (n.y - e.getY()) * (n.y - e.getY()) <= 30 * 30 ) {
					if( p == null ){
						p = n;
					}else{
						q = n;
						String etiquetas = JOptionPane.showInputDialog("Ingrese las etiqutas ( 1 o varias separadas por espacios ) para la arista que va desde Q" + p.id + " hacia Q" + q.id);
						
						if( etiquetas != null ){ 
							this.aristas.add(new Arista ( p, q, etiquetas ));
							repaint();
						}
						botonNuevaArista = false;
						p = null;
						q = null;
						break;
					}
				}
			}
		}
		
		
	}
	
	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
