package uniandes.dpoo.swing.interfaz.mapa;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelMapaVisualizar extends JPanel
{
    private Image imagenMapa;
    private List<Restaurante> restaurantes;

    public PanelMapaVisualizar( )
    {
        ImageIcon icono = new ImageIcon( "mapa.png" );
        if( icono.getIconWidth( ) == -1 )
        {
            icono = new ImageIcon( "./imagenes/mapa.png" );
        }
        this.imagenMapa = icono.getImage( );
        setPreferredSize( new Dimension( 450, 450 ) );
    }

    @Override
    protected void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        Graphics2D g2d = ( Graphics2D ) g;

        if( imagenMapa != null )
        {
            g2d.drawImage( imagenMapa, 0, 0, this );
        }

        if( this.restaurantes != null )
        {
            for( Restaurante r : this.restaurantes )
            {
                String name = r.getNombre( );
                int x = r.getX( );
                int y = r.getY( );

                g2d.setColor( Color.RED );
                g2d.fillOval( x - 3, y - 3, 7, 7 );

                g2d.setColor( Color.BLACK );
                g2d.drawString( name, x + 8, y + 5 );
            }
        }
    }

    public void actualizarMapa( List<Restaurante> nuevosRestaurantes )
    {
        this.restaurantes = nuevosRestaurantes;
        repaint( );
    }
}