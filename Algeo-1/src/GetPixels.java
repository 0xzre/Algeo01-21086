import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.*;
import java.io.*;
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
            //Retrieving Alpha
            int alpha = color.getAlpha();
            writer.append(alpha+ " ");
            writer.append(red+" ");
            writer.append(green+" ");
            writer.append(blue+"");
            writer.append("\n");
            writer.flush();
         }
      }
      writer.close();
      System.out.println("RGB values at each pixel are stored in the specified file");

      //Inputing the rgb value to each rgb matrix
      File fileRGB = new File("gambar.txt");
      Scanner input = new Scanner(fileRGB);
      
      Matrix alphaMat = new Matrix(img.getHeight(), img.getWidth());
      Matrix redMat = new Matrix(img.getHeight(), img.getWidth());
      Matrix greenMat = new Matrix(img.getHeight(), img.getWidth());
      Matrix blueMat = new Matrix(img.getHeight(), img.getWidth());

      int i,j;
      for(i = 0; i < img.getHeight(); i++){
         for(j = 0; j < img.getWidth(); j++){
            alphaMat.matrix[i][j] = input.nextInt();
            redMat.matrix[i][j] = input.nextInt();
            greenMat.matrix[i][j] = input.nextInt();
            blueMat.matrix[i][j] = input.nextInt();
         }
      }

      input.close();

      alphaMat.displayMatrix();
   }
}