import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;  // Import this class to handle errors

public class ImageRectangleShape extends RectangleShape{
	Image image;
	int sw;
	int sh;
	public ImageRectangleShape(int deltaX, int deltaY, Image image){
		super(DEFAULT_X_POS, DEFAULT_Y_POS, deltaX, deltaY, image.getWidth(null), image.getHeight(null));
		image = image;
		sw = image.getWidth(null);
		sh = image.getHeight(null);
    }

	public static Image makeImage(String imageFileName, int shapeWidth){
		int sw = shapeWidth;
		double sf = 0.00;

		File f = new File(imageFileName);
		BufferedImage b = null;
		try {
			b = ImageIO.read(f);
		} catch (IOException e) {
			e.printStackTrace();
		}

		double w = b.getWidth();
		double h = b.getHeight();
		if(w > sw){
			sf = (double) (sw / w);
		}
		int sh = (int) (h * sf);
		BufferedImage b2 = new BufferedImage(sw, sh, b.getType());
		Graphics2D g = b2.createGraphics();
		g.drawImage(b, 0, 0, sw, sh, null);
		return b2;
	}
    @Override
	public void paint(Painter painter) {
		painter.drawImage(image, _x, _y, sw, sh);
	}
}