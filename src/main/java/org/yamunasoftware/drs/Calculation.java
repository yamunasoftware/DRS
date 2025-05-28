package org.yamunasoftware.drs;

import java.awt.image.BufferedImage;
import java.io.File;

@SuppressWarnings("unused")
public class Calculation extends Imaging {
  // Constructor:
  public Calculation(int r, int g, int b, double resizeRatio, double detectionRatio) {
    super(r, g, b, resizeRatio, detectionRatio);
  }

  // Calculate Distance to Detection:
  public static double distanceToDetection(String path, double altitude, double focalLength, double sensorSize) throws Exception {
    // Loops through Directory:
    File directory = new File(path);
    double detectionFrame = 0, frameNumber = 0;
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
          detectionFrame = frameNumber;
          break loop;
        }

        // Increments:
        frameNumber++;
      }
    }

    // Returns the Value:
    double frameCoverage = getFrameCoverage(altitude, focalLength, sensorSize);
    return (detectionFrame * frameCoverage);
  }

  // Gets the Frame Coverage:
  private static double getFrameCoverage(double altitude, double focalLength, double sensorSize) throws Exception {
    return (sensorSize * altitude) / focalLength;
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
