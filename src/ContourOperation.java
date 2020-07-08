//The author of this code is Connor Haines. This class checks a pixels location and then stores the RGB values of it's surrounding pixels and uses the 
//given formula to calculate the "color distance". The pixel is then either changed to black or white based on that calculation.
import java.awt.Color;
public class ContourOperation implements ImageOperation{
	
	public Color[][] doOperation(Color[][] imageArray){
		int numOfRows = imageArray.length;
		int numOfColumns = imageArray[0].length;
		
		//This is where a the "result" array is created, which will be returned at the end of the method.
		Color[][] result = new Color[numOfRows][numOfColumns];
			
		//These for loops cycle through each individual pixel in the image based on it's height and width.
		for (int i = 0; i < numOfRows; i++)
			for (int j = 0; j < numOfColumns; j++) {
				
				//This boolean variable is very important because it tells the loop to stop if the pixel becomes black.
				boolean check = false;
				int exponent = 2;
				
				//The RGB values from the current pixel are stored in these integer variables.
				int red = imageArray[i][j].getRed();
				int green = imageArray[i][j].getGreen();
				int blue = imageArray[i][j].getBlue();
				
				//In this for loop, the method checks if the position of the current pixel is on the edge of the image, then checks the surrounding pixels accordingly.
				for(int x = -1; x < 2; x++)
					for(int y = -1; y < 2; y++) {
					
						if(check == false && numOfRows > i + x && i + x >= 0 && numOfColumns > j + y && j+y >= 0) {
							
							//These variables store the RGB values of the neighboring pixels.
							int otherRed = imageArray[i + x][j + y].getRed();
							int otherGreen = imageArray[i + x][j + y].getGreen();
							int otherBlue = imageArray[i + x][j +y].getBlue();
							
							//The following four lines of code are where the given formula for color distance is used, however it is written this way to reduce clutter.
							double redConst = Math.pow(red - otherRed, exponent);
							double greenConst = Math.pow(green - otherGreen, exponent);
							double blueConst = Math.pow(blue - otherBlue, exponent);
					
							double colorDist = Math.sqrt(redConst + greenConst + blueConst);
							
							//These if and else statements finally check the colorDist variable and set the pixel color accordingly.
							//This is also where the "check" variable becomes true if the pixel is set to black, as a way of terminating the loop.
							if (colorDist > 65) {
								check = true;
								result[i][j] = new Color(0,0,0);
							}
							else result[i][j] = new Color(255, 255, 255);
						}
					}
			}
		return result;
	}

}
