import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.font.*;
import java.awt.geom.*;
public class SegiPanjangWarnaGradient1 extends JApplet {
public static void main(String s[]) {
JFrame frame = new JFrame();
frame.setTitle("Outline Gradien");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JApplet applet = new SegiPanjangWarnaGradient1();
applet.init();
frame.getContentPane().add(applet);
frame.pack();
frame.setVisible(true);

}
public void init() {
JPanel panel = new Panel2D();
getContentPane().add(panel);
}
}
class Panel2D extends JPanel{
public Panel2D() {
setPreferredSize(new Dimension(500, 400));
setBackground(Color.white);
}
public void paintComponent(Graphics g) {
super.paintComponent(g);
Graphics2D g2 = (Graphics2D)g;
//gambar persegipanjang.
Rectangle2D.Double persegipanjang2 = new Rectangle2D.Double(100,200,
200,50);
//membuat warna gradien asiklis (acyclic).
GradientPaint warnaGradien2 = new GradientPaint(125,100,Color.blue,
175,100,Color.darkGray,false);
g2.setStroke(new BasicStroke(10.0f));
g2.setPaint(warnaGradien2);
g2.draw(persegipanjang2);
}
}