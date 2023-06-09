import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public class AnnulusColorGradient {
  
  public static void main(String[] args) {
    int annulusWidth = 200;
    int annulusHeight = 200;
    int innerRadius = 50;
    int outerRadius = 100;
    Color color1 = Color.RED;
    Color color2 = Color.YELLOW;
    
    BufferedImage image = new BufferedImage(annulusWidth, annulusHeight, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = image.createGraphics();
    
    for (int x = 0; x < annulusWidth; x++) {
      for (int y = 0; y < annulusHeight; y++) {
        Point2D p = new Point2D.Double(x, y);
        Point2D center = new Point2D.Double(annulusWidth / 2, annulusHeight / 2);
        double angle = Math.atan2(p.getY() - center.getY(), p.getX() - center.getX());
        double radius = p.distance(center);
        
        if (radius >= innerRadius && radius <= outerRadius) {
          double t = (angle + Math.PI) / (2 * Math.PI);
          Color color = interpolateColor(color1, color2, t);
          image.setRGB(x, y, color.getRGB());
        }
      }
    }
    
    Arc2D.Double annulus = new Arc2D.Double(0, 0, annulusWidth, annulusHeight, 0, 360, Arc2D.Double.OPEN);
    g2d.setClip(annulus);
    g2d.drawImage(image, 0, 0, null);
    
    // Do something with the filled annulus
  }
  
  private static Color interpolateColor(Color c1, Color c2, double t) {
    double r = interpolate(c1.getRed(), c2.getRed(), t);
    double g = interpolate(c1.getGreen(), c2.getGreen(), t);
    double b = interpolate(c1.getBlue(), c2.getBlue(), t);
    double a = interpolate(c1.getAlpha(), c2.getAlpha(), t);
    return new Color((int) r, (int) g, (int) b, (int) a);
  }
  
  private static double interpolate(double a, double b, double t) {
    return a + (b - a) * t;
  }
}
