import java.util.*;

import javax.imageio.ImageIO;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;




public class ImageMain {

	public static void main(String[] args) throws IOException {
		Image image = ImageIO.read(new File("Racetrack.bmp"));
		BufferedImage img = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_BYTE_GRAY);
		
		int w = img.getWidth();
		int h = img.getHeight();

		int[][] array = new int[w][h];
		Raster raster = ((BufferedImage) image).getData();
		for (int j = 0; j < w; j++) {
		    for (int k = 0; k < h; k++) {
		        array[j][k] = raster.getSample(j, k, 0);
		    }
		}
		
		

		
//		System.out.println( array.length);
//		System.out.println( array[0].length);
		for (int i = 0; i < array[0].length; i++) {
		    for (int u = 0; u < array.length; u++) {
		    	if(array[u][i] == 9){
		    		array[u][i] = 2;
		        }
		    	else if(array[u][i] == 11){
		    		array[u][i] = 3;
		        }
		    	else if(array[u][i] == 0){
		    		array[u][i] = 1;
		        }
		    	else if(array[u][i] != 6) {
		    		array[u][i] = 0;
		        }
		    }
		}
		
		
		for (int i = 0; i < array[0].length; i++) {
		    for (int u = 0; u < array.length; u++) {
		        System.out.print( array[u][i] + " ");
		        if(u == array[0].length-1){
		        	System.out.print("\n");
		        }
		    }
		}
		
		        PrintWriter pw = new PrintWriter(new File("Track.csv"));
		        StringBuilder sb = new StringBuilder();
		        
		        
				for (int i = 0; i < array[0].length; i++) {
				    for (int u = 0; u < array.length; u++) {
				        sb.append(array[u][i]);
				        sb.append(',');
				        if(u == array[0].length-1){
					        sb.append('\n');
				        }
				    }
				}
				

		        pw.write(sb.toString());
		        pw.close();
		        System.out.println("done!");
		    }
		

	}
