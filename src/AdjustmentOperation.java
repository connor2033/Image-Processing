//The author of this code is Connor Haines. This class darkens pixels in an image from the top left based on their relative distance to the top left corner.

import java.awt.Color;
public class AdjustmentOperation implements ImageOperation {
	
	//This method calculates the exact distance diagonally across an image based on the width and height and returns it as a double named "M".
	public static double maxDist(int numRows, int numColumns) {
		double M = Math.sqrt(numColumns*numColumns + numRows*numRows);
		return M;
	}
	
	//This method calculates the exact distance  from the given x and y values to the top left corner and returns it as a double named "D".
	public static double cornerDist(int x, int y) {
		double D = Math.sqrt(x*x + y*y);
		return D;
	}
	
	
	public Color[][] doOperation(Color[][] imageArray) {
		int numOfRows = imageArray.length;
		int numOfColumns = imageArray[0].length;

		//This is where a the "result" array is created, which will be returned at the end of the method.
		Color[][] result = new Color[numOfRows][numOfColumns];	
		
		//These for loops cycle through each individual pixel in the image based on it's height and width.
		for (int i = 0; i < numOfRows; i++)
			for (int j = 0; j < numOfColumns; j++) {
				//This double variable uses the given formula to calculate by how much each pixel should be adjusted.
				double adjustBrightness = cornerDist(i,j)/maxDist(numOfRows,numOfColumns);
				
				//Here, the RGB values are adjusted based on the above calculated double
				int pRed = (int) (imageArray[i][j].getRed()*adjustBrightness);
				int pGreen = (int) (imageArray[i][j].getGreen()*adjustBrightness);
				int pBlue = (int) (imageArray[i][j].getBlue()*adjustBrightness);


				result[i][j] = new Color(pRed, pGreen, pBlue);
			}
		
		return result;
	}
}
