package org.yamunasoftware.drs;

import org.yamunasoftware.jvision.Analyze;
import java.awt.image.BufferedImage;

@SuppressWarnings("unused")
public class Imaging {
  /* IMAGING VARIABLES */

  // Color Filter Variables:
  private static int red = 255, green = 121, blue = 0;
  private static double resize = 0.25, detection = 0.33;
  private static String detectorName = "parachute";
  
  // Constructor:
  public Imaging(int r, int g, int b, double ratio, double detectionRatio) {
    try {
      // Sets Values:
      red = r;
      green = g;
      blue = b;
      resize = ratio;
      detection = detectionRatio;

      // Initializes Detector:
      Analyze.initDetector(detectorName, red, green, blue);
    }

    catch (Exception e) {
      // Prints:
      e.printStackTrace();
    }
  }

  /* DETECTION METHODS */

  // Detect Blobs Methods:
  public static boolean isDetectionInFrame(BufferedImage image) throws Exception {
    // Gets the Detection:
    BufferedImage resizedImage = Analyze.resizeBufferedImageRatio(image, resize);
    int rgb[][]  = Analyze.findSelectedBufferedRGB(resizedImage, 0, 0, resizedImage.getWidth(), resizedImage.getHeight());
    double pixelCount = (resizedImage.getWidth() * resizedImage.getHeight()) * detection;
    return Analyze.getBodyBoolean(rgb, (int)(pixelCount));
  }

  // Open Image Method:
  public static BufferedImage openFrame(String fileName, String fileType) throws Exception {
    // Returns:
    return Analyze.openImage(fileName, fileType);
  }

  /* RGB METHODS */

  // Get RGB Method:
  public static int[] getRGB() throws Exception {
    // Returns the RGB:
    return new int[]{red, green, blue};
  }

  // Get Resize:
  public static double getResize() throws Exception {
    // Returns:
    return resize;
  }

  // Get Detection:
  public static double getDetection() throws Exception {
    // Returns:
    return detection;
  }

  // Set RGB Method:
  public static void setRGB(int r, int g, int b) throws Exception {
    // Sets the RGB:
    red = r;
    green = g;
    blue = b;
    Analyze.initDetector(detectorName, red, green, blue);
  }

  // Set Resize:
  public static void setResize(double resizeRatio) throws Exception {
    // Sets the Value:
    resize = resizeRatio;
  }

  // Set Detection:
  public static void setDetection(double detectionRatio) throws Exception {
    // Sets the Value:
    detection  = detectionRatio;
  }
}