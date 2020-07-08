//The author of this code is Connor Haines. This class simply accepts a 2D image array and doubles it's size (length and width).

import java.awt.Color;
public class MagnifyOperation implements ImageOperation {
	
	public Color[][] doOperation(Color[][] imageArray) {
		int numOfRows = imageArray.length;
		int numOfColumns = imageArray[0].length;

		//Here is where the result array of twice the size is created.
		Color[][] result = new Color[numOfRows*2][numOfColumns*2];
		
		int red;
		int green;
		int blue;
		int x;
		int y;
		
		//These for loops cycle through each individual pixel in the image based on it's height and width.
		for (int i = 0; i < numOfRows; i++)
			for (int j = 0; j < numOfColumns; j++) {
				
				//Here the RGB values are collected into integer variables and the x and y variables are just two times the i and j variables for simplicity.
				red = imageArray[i][j].getRed();
				green = imageArray[i][j].getGreen();
				blue = imageArray[i][j].getBlue();
				x = 2*i;
				y = 2*j;
				
				//Here, the above RBG variables are set to the proper locations in the new image array in order to double the size of the image.
				//Each of the following four lines represents one of the four pixels drawn.
				result[x][y] = new Color(red, green, blue);
				result[x+1][y] = new Color(red, green, blue);
				result[x][y+1] = new Color(red, green, blue);
				result[x+1][y+1] = new Color(red, green, blue);
				
			}		
		return result;
	}
}
