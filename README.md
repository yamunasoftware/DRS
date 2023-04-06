# DRS (Drone Recovery System)

Computer Vision System to Use Drone Imaging to Locate Rocket After Landing

## Information

DRS is a project based upon the challenges of especially high-powered hobby rocketry. The main issue with the overall system of recovering rockets currently is the unreliability of GPS in more remote locations. The possible landing locations of these rockets is also too vast to search by hand; therefore, a technological solution is required. One of the best solutions that comes to mind is to use drone with a camera to search a large area for the rocket quickly. While machine learning is an option in this case to find the rocket. The rocket color may be washed out by the surrounding area; thus, the recommendation is that the rocket be mounted with a bright orange parachute to make the parachute easy to find.

## Method

The system uses ffmpeg (a popular video interface client), which needs to be pre-installed by the user ([Installation Guide](https://phoenixnap.com/kb/ffmpeg-windows)). Once the video is split into frames, the imaging algorithm will be used to detect when there are enough orange pixels in the image to warrant detection. Then based on the image fps and the mount fo detections, the system can give an estimate of how long in the flight path each detection happened, giving us usable timestamps. Then,based on the waypoints in the flight path of the drone, the system can find where in the flight path the rocket was spotted and how far the rocket is.
