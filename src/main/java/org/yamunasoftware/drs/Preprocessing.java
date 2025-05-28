package org.yamunasoftware.drs;

import java.io.File;

@SuppressWarnings("unused")
public class Preprocessing {
  /* PREPROCESSING */

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
