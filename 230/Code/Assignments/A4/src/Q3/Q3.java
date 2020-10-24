import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutionException;

class ImageShapeFormHandler implements FormHandler {
    private ShapeModel shapeModel;
    private NestingShape newShapeParent;
    private Form theForm;
    private SwingWorker<ImageRectangleShape, Void> worker;
    public ImageShapeFormHandler(ShapeModel model, NestingShape parent) {
        shapeModel = model;
        newShapeParent = parent;
    }

    @Override
    public void processForm(Form form) {
        theForm = form;
        worker = new ImageWorker();
        worker.execute();
    }

    class ImageWorker extends SwingWorker<ImageRectangleShape, Void> {
        @Override
        protected ImageRectangleShape doInBackground() throws Exception {
            long startTime = System.currentTimeMillis();
            File imageFile = (File)theForm.getFieldValue(File.class, ImageFormElement.IMAGE);
            int width = theForm.getFieldValue(Integer.class, ShapeFormElement.WIDTH);
            int deltaX = theForm.getFieldValue(Integer.class, ShapeFormElement.DELTA_X);
            int deltaY = theForm.getFieldValue(Integer.class, ShapeFormElement.DELTA_Y);
            BufferedImage fullImage = null;

            try {
                fullImage = ImageIO.read(imageFile);
            } catch (IOException e) {
                System.out.println(e);
                System.out.println("Error loading image.");
            }

            int fullImageWidth = fullImage.getWidth();
            int fullImageHeight = fullImage.getHeight();
            BufferedImage scaledImg = fullImage;

            if(width < fullImageWidth ) {
                double scaler = (double) width / (double) fullImageWidth;
                int height = (int)((double)fullImageHeight * scaler);
                scaledImg = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
                Graphics2D g = scaledImg.createGraphics();
                g.drawImage(fullImage, 0, 0, width, height, null);
            }

            ImageRectangleShape imageShape = new ImageRectangleShape(deltaX, deltaY, scaledImg);
            shapeModel.add(imageShape, newShapeParent);
            long elapsedTime = System.currentTimeMillis() - startTime;
            return imageShape;
        }

        @Override
        protected void done(){
            try {
                shapeModel.add(get(), newShapeParent);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
