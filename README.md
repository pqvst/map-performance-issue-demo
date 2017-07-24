# map-performance-issue-demo
Map performance issue demo project for https://issuetracker.google.com/issues/63958503

Performance at the initial location is especially bad (like shown in the video).

 - Lat: 35.655598
 - Lng: 139.701059
 - Zoom: 17.239813f

I've also included a toggle in the top-right corner of the activity to easily switch the custom map style on and off for comparison.

Note: It is reproducible for me with API level 26 as well.

---

Additional details:
- Google Pixel, Android 7.1.2
- Google Play Services client library version: 11.0.2
- Google Play Services version on the device: 11.3.02
- Android SDK Version: 25
- Was this working correctly on a previous version of Google Play Services? Not sure

Here's a video that attempts to demonstrate the lag (it feels waaaaaay worse in real life than what the video makes it out to be...) https://youtu.be/j5uZtjyqjZk

Stackoverflow: https://stackoverflow.com/questions/45249642/mapview-very-laggy-and-bad-performance-no-markers
