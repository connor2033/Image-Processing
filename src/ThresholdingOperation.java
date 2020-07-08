//The author of this code is Connor Haines. This class is meant to calculate the "brightness score" of pixels based on their RGB
//color values that are stored in a 2D Array. If the brightness score is over 100 the location of that pixel in the new "result"
//array will be white and if it is below 100 the pixel will be black. This ultimately creates a black and white only image.

import java.awt.Color;
public class ThresholdingOperation implements ImageOperation {
	public Color[][] doOperation(Color[][] imageArray) {
		int numOfRows = imageArray.length;
		int numOfColumns = imageArray[0].length;

		//This is where a the "result" array is created, which will be returned at the end of the method.
		Color[][] result = new Color[numOfRows][numOfColumns];
		int brightness;

		//These for loops cycle through each individual pixel in the image based on it's height and width.
		for (int i = 0; i < numOfRows; i++)
			for (int j = 0; j < numOfColumns; j++) {
				
				// This is where the brightness score is calculated based on the given equation and RGB values.
				brightness = (int) (0.21 * imageArray[i][j].getRed() + 0.71 * imageArray[i][j].getGreen() + 0.07 * imageArray[i][j].getBlue());
				
				//This is where the program decides to make a pixel white or black based on the brightness score.
				if (brightness > 100) {
					result[i][j] = new Color(255, 255, 255);
				}
				else {
					result[i][j] = new Color(0,0,0);
				}
			}
		return result;
	}
}