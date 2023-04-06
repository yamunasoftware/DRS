package main;

import java.io.File;

public class Preprocessing {
  // Constructor:
  public Preprocessing() {}

  // Split Frames Method:
  public static void splitFrames(String video, String path, String fps) throws Exception {
    // Changes Directory:
    String command[] = {"ffmpeg", "-i", path+video, "-vf", "fps="+fps, "%05d.png"};
    ProcessBuilder builder = new ProcessBuilder(command);
    builder = builder.directory(new File(path));
    builder.start();
  }
}
