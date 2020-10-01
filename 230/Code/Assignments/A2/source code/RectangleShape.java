import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

class ImageRectangleShape extends RectangleShape{
    public ImageRectangleShape(int deltaX, int deltaY, Image image){
        //
    }
    public static Image makeImage(String imageFileName, int shapeWidth){
        int sw; //new shape width 
        int sh; // height of new shape
        File f; // instance of a file 
        BufferedImage b, b2; // instances of bufferimage 
        int w; // width of loaded img 
        int h; // height of loaded img 
        double sf; // scale factor 
        Graphics2D g; // instance of Graphics2D

        f = new File("myImage");

        b2 = b;
        w = b.getWidth();
        h = b.getHeight();
        if (w > sw){
            sf = sw / w;
            sh = h * sf;
            b2 = "new BufferedImage object"; //  supplying sw and sh as parameters
            g = "new Graphics2D object by calling method createGraphics() on b2";
            drawImage(b, sw, sh);
        }
    }

}
