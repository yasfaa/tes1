import java.awt.*;
import java.awt.geom.GeneralPath;
public class SimpleJava2DExample extends Frame
{
SimpleJava2DExample()
{
addWindowListener(new MyFinishWindow());
}
public void paint(Graphics g){
    Graphics2D g2d = (Graphics2D) g;
    //g2d.drawString("Hello world!",30,50);
    
    GeneralPath gp = new GeneralPath();
    gp.moveTo(60,120);
    gp.lineTo(80,120); //front underbody
    gp.quadTo(90,140,100,120); //front wheel
    gp.lineTo(160,120); //middle underbody
    gp.quadTo(170,140,180,120); //rear wheel
    gp.lineTo(200,120); //rear underbody
    gp.curveTo(195,100,200,80,160,80); //rear
    gp.lineTo(110,80); //roof
    gp.lineTo(90,100); //windscreen
    gp.lineTo(60,100); //bonnet
    gp.lineTo(60,120); //front
    g2d.draw(gp); //Draw the car
    }
    
    public static void main(String[] argv){
        SimpleJava2DExample f = new SimpleJava2DExample();
        f.setTitle("The first Java 2D program");
        f.setSize(350,80);
        f.setVisible(true);
        }
    }