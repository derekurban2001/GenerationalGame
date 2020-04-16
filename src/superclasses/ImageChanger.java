package superclasses;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;


/**
 * The Class ImageChanger.
 */
//Image Changer class, main functionality is to change image colors
public class ImageChanger {
	
	/**
	 * Change image color method.
	 *
	 * @param image the image
	 * @param from the color to change from
	 * @param to the the color to change to
	 * @return the image
	 */
	//changeImageColor takes in an image, a color to change from, and a color to change to.
	public static BufferedImage changeImageColor(BufferedImage image, Color from, Color to) {
		
		//initializes both colors and gets the dimensions of the image
		int[] fromColor = {from.getRed(), from.getGreen(), from.getBlue()};
		int[] toColor = {to.getRed(), to.getGreen(), to.getBlue()};
	    int width = image.getWidth();
	    int height = image.getHeight();
	    //rasterizes the image
	    WritableRaster raster = image.getRaster();
	    
	    //goes in pixel by pixel and changes each colored pixel to the a new colored pixel
	    for (int xx = 0; xx < width; xx++) {
	      for (int yy = 0; yy < height; yy++) {
	        int[] pixels = raster.getPixel(xx, yy, (int[]) null);
	        if(pixels[0] == fromColor[0] && pixels[1] == fromColor[1] && pixels[2] == fromColor[2]) {
	            pixels[0] = toColor[0];
	            pixels[1] = toColor[1];
	            pixels[2] = toColor[2];
	            raster.setPixel(xx, yy, pixels);
	        }
	      }
	    }
	    
	    //returns the image
	    return image;
	  }
}
