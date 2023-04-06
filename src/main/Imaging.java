package main;

import lib.Analyze;

public class Imaging {
  /* IMAGING VARIABLES */

  // Color Filter Variables:
  private static int red = 255, green = 121, blue = 0;
  private static String detectorName = "orange";
  
  // Constructor:
  public Imaging() {
    try {
      // Initializes Detector:
      Analyze.initDetector(detectorName, red, green, blue);
    }

    catch (Exception e) {
      // Prints:
      e.printStackTrace();
    }
  }

  /* RGB METHODS */

  // Get RGB Method:
  public static int[] getRGB() throws Exception {
    // Returns the RGB:
    int rgb[] = {red, green, blue};
    return rgb;
  }

  // Set RGB Method:
  public static void setRGB(int r, int g, int b) throws Exception {
    // Sets the RGB:
    red = r;
    green = g;
    blue = b;
    Analyze.initDetector(detectorName, red, green, blue);
  }
}