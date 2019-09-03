import java.awt.Color;
import java.awt.Graphics;

public class Nodo {
	
	public Integer x, y, id;
	public boolean aceptacion;
	
	public Nodo( int x, int y, int id, int ac ) {
		this.x = x;
		this.y = y;
		this.id = id;
		if( ac == 1 ) this.aceptacion = true;
		else this.aceptacion = false;
	}
	
	public void pintar( Graphics g ){
		
		if( this.aceptacion == false  ){
			g.setColor(new Color(220,0,0));
		}else{
			g.setColor(new Color(0,220,0));
		}
		g.drawOval(this.x - 30, this.y - 30, 60, 60);
		g.setColor(new Color (0,0,0)) ;
		g.drawString("Q" + id.toString(), x - 5, y + 5);
	}
}
