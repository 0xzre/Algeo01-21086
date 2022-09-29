import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class GetPixels {
   public static void main(String args[])throws Exception {
      BufferedWriter writer = new BufferedWriter(new FileWriter("../test/output/gambar.txt"));
      //Reading the image
      File file= new File("ein.png");
      BufferedImage img = ImageIO.read(file);
      for (int y = 0; y < img.getHeight(); y++) {
         for (int x = 0; x < img.getWidth(); x++) {
            //Retrieving contents of a pixel
            int pixel = img.getRGB(x,y);
            //Creating a Color object from pixel value
            Color color = new Color(pixel, true);
            //Retrieving the R G B values
            int red = color.getRed();
            int green = color.getGreen();
            int blue = color.getBlue();
            writer.append(red+":");
            writer.append(green+":");
            writer.append(blue+"");
            writer.append("\n");
            writer.flush();
         }
      }
      writer.close();
      System.out.println("RGB values at each pixel are stored in the specified file");
   }
}