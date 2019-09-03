import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.QuadCurve2D;
import java.util.ArrayList;

public class Arista {
	public Nodo desde, hasta;
	public ArrayList < Character > etiquetas = new ArrayList < Character > ();
	public String aux;
	
	public Arista( Nodo x, Nodo y , String s) {
		this.desde = x;
		this.hasta = y;
		
		String t [] = s.split(" ");
		for( String n : t){
			etiquetas.add(n.charAt(0));
		}
		this.aux = s;
	}
	
	
	
	
	public void pintar( Graphics g ){
		
	    if( desde.id != hasta.id ){
			
			
	    	double norm = Math.sqrt( ( hasta.x - desde.x ) * ( hasta.x - desde.x ) + ( hasta.y - desde.y) * ( hasta.y - desde.y) );
	    	
	    	
	    	double finx = 30.0 * ( desde.x - hasta.x ) / norm ;
	    	double finy = 30.0 * ( desde.y - hasta.y) / norm;
	    	
	    	double inix = 30.0 * ( hasta.x - desde.x ) / norm ;
	    	double iniy = 30.0 * ( hasta.y - desde.y) / norm;
	    	
	   
	    	double angle = Math.PI / 8.0;
	  
	    	double tx = inix;
	    	double ty = iniy;
	    	
	    	
	    	inix = tx * Math.cos(angle) + ty * Math.sin(angle);
	    	iniy = -tx * Math.sin(angle) + ty * Math.cos(angle);
	    	
	    	tx = finx;
	    	ty = finy;
	    	
	    	finx = tx * Math.cos(-angle) + ty * Math.sin(-angle);
	    	finy = -tx * Math.sin(-angle) + ty * Math.cos(-angle);
	   
	    	finx += hasta.x;
	    	finy += hasta.y;
			inix += desde.x;
	    	iniy += desde.y;
	    	
	    	
	    	
	    	g.fillOval((int) finx  - 5, ( int ) finy - 5, 10, 10);
			
	    	double midx = ( inix + finx ) / 2.0;
	    	double midy = ( iniy + finy ) / 2.0;
	    	
	    	int posSy = 0, posSx = 0;
	    	
	    	if( hasta.x >= desde.x && hasta.y >= desde.y){
	    		midx += 12;
	    		midy -= 12;
	    		posSx = (int) midx + 7;
	    		posSy = (int) midy - 7;
	    	}
	    	if( hasta.x >= desde.x && hasta.y < desde.y){
	    		midx -= 12;
	    		midy -= 12;
	    		posSx = (int) midx - 7;
	    		posSy = (int) midy - 7;
	    	}
	    	
	    	if( hasta.x < desde.x && hasta.y >= desde.y){
	    		midx += 12;
	    		midy += 12;
	    		posSx = (int) midx + 7;
	    		posSy = (int) midy + 7;
	    	}
	    	
	    	if( hasta.x < desde. x && hasta.y < desde.y ){
	    		midx -= 12;
	    		midy += 12;
	    		posSx = (int) midx - 7;
	    		posSy = (int) midy + 7;
	    	}
	    	
	    	g.drawString(aux, (int) posSx, posSy);
	    	
	    	
		    QuadCurve2D.Double curve = new QuadCurve2D.Double(inix, iniy , midx, midy, finx, finy); 
		    Graphics2D aux = ((Graphics2D)g);         
		    aux.draw(curve);      
			
	    }else{

			g.drawString(aux, desde.x, desde.y - 65);
	    	g.fillOval(desde.x + 10 , desde.y - 29 , 10, 10);
			

	    	QuadCurve2D.Double curve = new QuadCurve2D.Double( desde.x + 15 , desde.y - 24 , desde.x, desde.y - 100, desde.x - 15, desde.y - 24); 
		    Graphics2D aux = ((Graphics2D)g);         
		    aux.draw(curve);

	    
	    }
	}
}
