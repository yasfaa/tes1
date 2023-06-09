import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import java.awt.image.BufferedImage;

/**
* An example for an animation based on convex combinations of two
* geometric transformations. An ellipse in the upper left corner of
* the window is transformed stepwise into another ellipse
* in the lower right corner of the window.
*
* This version uses double buffering to eliminate flicker.
* 
* @author Frank Klawonn
* Last change 21.01.2005
*/
public class ConvexDoubleBuffer extends Frame
{
  private Image offScreenBuffer;
  private Graphics offScreenGraphics;
  
  //Constructor
  public ConvexDoubleBuffer()
  {
    //Enables the closing of the window.
    addWindowListener(new MyFinishWindow());
  }

  public void update(Graphics g) {
    paint(g);
  }

  public void paint(Graphics g)
  {
    Graphics2D g2d = (Graphics2D) g;

    //Use of antialiasing to have nicer lines.
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

    int xul, yul, xwidth, yheight;

    xul = 20;     //x-coordinate for the definition of a bounding recatangle
                  //for an ellipse
    yul = 40;     //y-coordinate the definition of the rectangle
    xwidth = 50;  //Width of the rectangle
    yheight = 20; //Height of the rectangle

    //Generating an ellipse from the rectangle.
    //This ellipse is used to construct the initial and the final ellipse.
    Ellipse2D.Double elli = new Ellipse2D.Double(xul,yul,xwidth,yheight);

    //Midpoint of the ellipse/rectangle
    double xmid = xul+xwidth/2.0;
    double ymid = yul+yheight/2.0;

    //Transformation for constructing the initial ellipse.
    AffineTransform initialTransform = new AffineTransform();
    initialTransform.setToRotation(Math.PI/6,xmid,ymid);

    //The matrix for the transformation of the initial ellipse.
    //The matrix is needed for the computation of the convex combinations.
    double[] initialMatrix = new double[6];
    initialTransform.getMatrix(initialMatrix);

    //Transformation for constructing the final ellipse.
    AffineTransform finalTransform = new AffineTransform();
    finalTransform.setToTranslation(500,200);
    finalTransform.concatenate(scalingWRTXY(xmid,ymid,2,0.5));
    finalTransform.rotate(3*Math.PI/4,xmid,ymid);

    //The matrix for the transformation of the final ellipse.
    //The matrix is needed for the computation of the convex combinations.
    double[] finalMatrix = new double[6];
    finalTransform.getMatrix(finalMatrix);

    //Number of steps/images/frames for the transformation of the
    //initial into the final eellipse.
    int steps = 200;

    //The initial ellipse
    Shape initialElli = initialTransform.createTransformedShape(elli);

    //The final ellipse
    Shape finalElli = finalTransform.createTransformedShape(elli);

    //This shape is used for drawing the intermediate ellipses.
    Shape s;
  }
    //This transformation is used for the convex combinations of the 
    //initial and
