import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageWriter {
	private BufferedImage image;
	private String outfile;

	/* Write the processed image into the specified file */
	public void writeImage(String outfile, Color[][] array) {
		this.outfile = outfile;
		ImageConverter converter = new ImageConverter();
		image = converter.arrayToBufferedImage(array); // Convert array into image
		writeFile();
	}

	/* Write modified image file in computer disk */
	private void writeFile() {
		File outputfile = new File(outfile);
		try {
			ImageIO.write(image, "jpg", outputfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
