package main;

import java.awt.image.BufferedImage;
import java.io.File;

public class Calculation extends Imaging {
  // Constructor:
  public Calculation(int r, int g, int b, double resizeRatio, double detectionRatio) {
    super(r, g, b, resizeRatio, detectionRatio);
  }

  // Calculate Distance to Detection:
  public static double distanceToDetection(String path, double frameCoverage) throws Exception {
    // Loops through Directory:
    File directory = new File(path);
    double frameNumber = 0;
    loop: for (File file : directory.listFiles()) {
      // Checks the Case:
      if (file.isFile()) {
        // Gets the Name:
        String fileName = getFileName(file);
        String fileType = getFileType(file);
        BufferedImage image = openFrame(fileName, fileType);

        // Checks the Case:
        if (isDetectionInFrame(image)) {
          // Breaks:
          break loop;
        }

        // Increments:
        frameNumber++;
      }
    }

    // Returns the Value:
    return (frameNumber * frameCoverage);
  }

  // Gets the File Name:
  private static String getFileName(File file) throws Exception {
    // Gets the File Name:
    String string = file.getName();
    int pos = string.lastIndexOf(".");
    if (pos == -1) return string;
    return string.substring(0, pos);
  }

  // Gets the File Type:
  private static String getFileType(File file) throws Exception {
    // Gets the File Extension:
    String name = file.getName();
    int lastIndexOf = name.lastIndexOf(".");
    if (lastIndexOf == -1) {
        return "";
    }
    return name.substring(lastIndexOf);
  }
}
