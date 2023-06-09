import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovingCubeExample extends JPanel {
    private static final int CUBE_SIZE = 100;
    private int x;
    private int y;

    public MovingCubeExample() {
        x = 0;
        y = 0;

        // Set up a timer to update the position of the cube
        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update the position of the cube
                x++;
                y++;

                // Repaint the panel to reflect the updated position
                repaint();
            }
        });
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Membuat transformasi
        g2d.setColor(Color.ORANGE);
        g2d.translate(x, y);

        // Membuat warna campuran (mix)
        Color color1 = Color.RED;
        Color color2 = Color.GREEN;
        GradientPaint gradient = new GradientPaint(0, 0, color1, CUBE_SIZE, CUBE_SIZE, color2);
        g2d.setPaint(gradient);

        // Membuat tekstur
        BufferedImage image = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gImage = image.createGraphics();
        gImage.setColor(Color.BLUE);
        gImage.fillRect(0, 0, 10, 10);
        gImage.setColor(Color.WHITE);
        gImage.drawLine(0, 0, 10, 10);
        gImage.drawLine(0, 10, 10, 0);
        TexturePaint texture = new TexturePaint(image, new java.awt.Rectangle(10, 10));

        // Menggambar kubus
        g2d.fillRect(0, 0, CUBE_SIZE, CUBE_SIZE); // Muka depan
        g2d.setPaint(texture);
        g2d.fillRect(0, 0, CUBE_SIZE, CUBE_SIZE); // Muka atas
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, CUBE_SIZE, CUBE_SIZE); // Muka samping
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Moving Cube Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MovingCubeExample());
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
