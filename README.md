# DRS

Drone Recovery System

## Information

DRS is a project based upon the challenges of high-powered hobby rocketry. The main issue with the overall system of recovering rockets currently is the unreliability of GPS in more remote locations. The possible landing locations of these rockets is also too vast to search by hand; therefore, a technological solution is required. One of the best solutions that comes to mind is to use drone with a camera to search a large area for the rocket quickly. While machine learning is an option in this case to find the rocket. The rocket color may be washed out by the surrounding area; thus, the recommendation is that the rocket be mounted with a bright orange parachute to make the parachute easy to find. Thus, we can use a fast computer vision technique called color masking to identify the parachute of the rocket.

## Method

The system uses ffmpeg (a popular video interface client), which needs to be pre-installed by the user ([Installation Guide](https://phoenixnap.com/kb/ffmpeg-windows)). Once the video is split into frames, the imaging algorithm will be used to detect when there are enough orange pixels in the image to warrant detection. Then, based on the image fps, and the amount of detections, the system can give an estimate of how long in the flight path each detection happened with usable timestamps. Then, based on the waypoints in the flight path of the drone, the system can find where in the flight path the rocket was spotted and how far the rocket is. The image detection is done through the in-house Java computer vision library: JVision. JVision is a lightweight and fast Java image processing library, and it has a lot of functionality in relation to detecting features in images. [Link to JVision](https://github.com/yamunasoftware/JVision)

## Installation

The installation for this library is listed below either using the Maven or Gradle build tools. Both of these tools are ubiquitous in the Java build environment world. The other option for using this library in your code is to use this as a module or use the included jar file found in the repository. This can be used locally, but updating to newer versions is much harder in build environments without using the Maven or Gradle implementation. Lastly, it is important to us that you pay attention to the version number when building your project with our library.

Maven:

```XML
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>

<dependencies>
  <dependency>
    <groupId>com.github.yamunasoftware</groupId>
    <artifactId>DRS</artifactId>
    <version>{LATEST VERSION}</version>
  </dependency>
</dependencies>
```

Gradle:

```Java
allprojects {
  repositories {
    maven { url 'https://jitpack.io' }
  }
}

dependencies {
  implementation 'com.github.yamunasoftware:DRS:{LATEST VERSION}'
}
```
