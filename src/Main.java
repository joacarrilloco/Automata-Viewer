
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

	
	static class Arista{

		Nodo desde;
		Nodo hasta;
		char con;
		
		public Arista (Nodo a, Nodo b, char c){
			desde = a;
			hasta = b;
			con = c;
		}
		
	}


	public static void main ( String args[]){
		
		JFrame ventana = new JFrame();
		
		ventana.setSize(700,600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		
		JPanel pannel = new JPanel();
		ventana.add(pannel);

		ventana.setVisible(true);
		
		Lienzo l = new Lienzo();
		ventana.add(l);
		
		
		JButton nuevoNodo = new JButton("Nuevo Nodo");
		JButton nuevaArista = new JButton("Nueva Arista");
		JButton validarCadena = new JButton("Validar Cadena");
		
		pannel.add(nuevoNodo);
		pannel.add(nuevaArista);
		pannel.add(validarCadena);
		

		nuevoNodo.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				l.botonNuevoNodo = true;
			}
		});
		
		nuevaArista.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				l.botonNuevaArista = true;
			}
		});
		
		validarCadena.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				l.validateString();
			}
		});
		
		
	}
	
}
