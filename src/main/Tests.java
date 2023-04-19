package main;

@SuppressWarnings("unused")
public class Tests {
  /* TEST SETUP */
  
  // Constructor:
  public Tests() {}

  // Test Variables:
  private static int red = 255, green = 121, blue = 0;
  private static double resize = 0.25, detection = 0.33;
  private static Calculation calculation = new Calculation(red, green, blue, resize, detection);

  // Test Camera Variables:
  private static double altitude = 100, focalLength = 50, sensorSize = 28.2;

  /* TEST METHOD */

  // Test Detection Method:
  public static double testDetection(String path) throws Exception {
    // Gets the Distance:
    return Calculation.distanceToDetection(path, altitude, focalLength, sensorSize);
  }
}