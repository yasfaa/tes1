import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GradientPaint;
import java.awt.TexturePaint;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawingExample extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // // Membuat garis
        // g2d.setColor(Color.BLUE);
        // g2d.drawLine(20, 20, 200, 20);

        // // Membuat titik
        // g2d.setColor(Color.RED);
        // g2d.fillRect(50, 50, 5, 5);

        // // Membuat warna campuran (mix)
        // Color color1 = Color.RED;
        // Color color2 = Color.GREEN;
        // GradientPaint gradient = new GradientPaint(70, 70, color1, 150, 150, color2);
        // g2d.setPaint(gradient);
        // g2d.fillRect(70, 70, 100, 100);

        // Membuat textures/gambar 2D
        BufferedImage image = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gImage = image.createGraphics();
        gImage.setColor(Color.YELLOW);
        gImage.fillRect(0, 0, 10, 10);
        gImage.setColor(Color.BLACK);
        gImage.drawLine(0, 0, 10, 10);
        gImage.drawLine(0, 10, 10, 0);
        g2d.setPaint(new TexturePaint(image, new Rectangle(10, 10)));
        g2d.fillRect(200, 200, 100, 100);

    //     // Membuat transformasi
    //     g2d.setColor(Color.BLUE);
    //     AffineTransform oldTransform = g2d.getTransform();
    //     AffineTransform transform = new AffineTransform();
    //     transform.translate(300, 300);
    //     transform.rotate(Math.toRadians(45));
    //     g2d.setTransform(transform);
    //     g2d.fillRect(0, 0, 100, 100);
    //     g2d.setTransform(oldTransform);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Drawing Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new DrawingExample());
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
