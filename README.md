# APCS2FinalProject
Team Name: Sardine Kimbap (Ely Sandine and Issac Kim)
Project Name: OCR
Description: We created an Optical Character Reader that takes image files and returns the letters in the image. To test it compile and run DemoDriver.java the rest of the instructions are included. Sample files to test on are text.JPEG, text1.JPEG, text2.JPEG, text3.JPEG, and text4.JPEG. You can also test images from the internet, but they are not guaranteed to be successful.
NOTE: If there is an error it is likely due to not all files being compiled. The following files need to be compiled and are not auto-compiled by compiling DemoDriver:

BlockReader.java
Character.java
Characters.java
Pixel.java
Read.java
ReadBlock.java
ReadImage.java
ReadLines.java
booleanArray.java
rescale.java

Project Plan:
-Make it possible to read image files into a 2D array of pixels
-Convert 2D array of pixels to arrays of booleans with true representing part of the character and false being the whitespace
-Compare with individual characters the same size to determine what matches with an image
-Scale images and trim whitespace in order to improve speed.
-Read lines of characters
-Read multiple lines of characters
-Rotate images that are tilted
-Output results to an html file


Development Log:

06/06/2016:
-Ely Sandine
-New Features:
-correct finds angle to rotate
-writeHTML in ReadImage writes the results in html to results.html
-Added text to description and driver
-Bugs Added:
-Bugs Fixed:
-Deleted alot of test image files that were cluttering te directory
-helped fix lowercase letters
-Goals:
-None we are finished
-Issac Kim
-New Features:
-add demo driver
-add lowercase letters
-Bugs Added:
-none
-Bugs Fixed:
-None
-Goals:
-Finish

06/05/2016:
-Issac Kim
-New Features:
-make read lines, can read multiple lines now
-allow reading one line to be able to read different size chars
-Bugs Added:
-not added now, but found that letters b, n, and w in upper are not being processed correctly
-Bug Fixed:
-None
-Goals
-make demoDriver
-Ely Sandine
-New Features:
-setBlackAndWhite now works by detecting the two most common colors in the image
-Added lowercase letters
-Bugs Added:
-Lowercase letters are not very accurately scanned
-Bugs Fixed:
-Goals
-Make sure rotating works


06/04/2016:
-Ely Sandine
-New Features:
-Commented all the important classes
-Bugs Added:
-none
-Bugs Fixed:
-Error with Readimage is fixed using colorspace and colormodel
-Goals
-add fonts / figure out how much to rotate and image
-Issac Kim
-kind of done 06/04/2016, started before midnight ended way after
-New Features:
-Reworked block reading so it doesn't create actual image files for each indiviudal symbol
-Boosts efficiency and goes around buggy constructor
-Reading one line of text works
-finding spaces in text works, but maybe not best method
-Bugs Fixed:
-Reading line of text
-Bugs Added:
-None
-Goals:
-Reading multi lines of text


06/03/2016:
-Ely Sandine
-New Features:
-none
-Bugs Added:
-The bug with reading files is not in the booleanArray class
-Bugs Fixed:
-none
-Goals

06/02/2016:
-Issac Kim
-New Features:
-Restart completely
-Found out there was an error with one of our original constructors
-Entire image was read as black, which led to big issues with breaking blocks of text into smaller lines
-Made a default "image" with hard coded values
-breaking this test image worked and was able to output these symbols into image files
-can not read text yet, because original constructor is not working
-Bugs Added: 
-none
-Bugs Fixed:
-breaking blocks works, but needs default array values
-Goals:
-make sure breaking blocks of text works with actual text and not only preset values
-Ely Sandine
-New Features:
-none
-Bugs Added:
-Discovered that all fiels were being read as all black
-Bugs Fixed:
-began researching how png pixels work
-Goals
-Fix the bug


5/31/2016:
-Ely Sandine
-New Features:
-rescale.java now trims image files
-Bugs Added:
-the ocr is more effective now, now recognizes the B
-Bugs Fixed:
-Minor indexoutofbounds fixed on getFirstCharacter
-Goals
-Figure how much to rotate an image by

05/27/2016:
-Issac Kim
-New Features:
-Bug fix attempt
-Bugs Added:
-not functioning
-Bugs Fixed:
-none
-Goals:
-Fix block reading
-Ely Sandine
-New Features:
-Trim function fixes the problem of Rotate making the images too big
-Bugs Added:
-loss of pixels when rotating
-Bugs Fixed:
-Rotate is fixed
-Goals
-Make Rotate better

05/26/2016:
-Issac Kim
-New Features:
-create new method for finding dimensions
-Bugs Added:
-not functioning
-Bugs Fixed:
-none
-Goals:
-fix reading blocks of text
-Ely Sandine
-New Features:
-Rotation works by enlarging the image and spinning it
-Bugs Added:
-Need to full test rotating,
-Some pixels disapper
-Bugs Fixed:
-Fixed the trig problems
-Goals
-Test rotating more,
-make a program that cuts down the white space

05/25/2016:
-Issac Kim
-New Features:
-restart work on removing symbols, this time in a new class unlike original
-idea is to return dimensions of an subimage in larger image and remove it
-Bugs Added:
-not functioning
-Bugs Fixed:
-none
-Goals:
-Make line reading work
-Ely Sandine
-New Features:
-added rotating by converting to polar coordinates then back into normal array
-Bugs Added:
-Rotating does not work and throws exception
-Bugs Fixed:
-none
-Goals
-Fix rotations

05/24/2016:
-Ely Sandine
-New Features:
-booleanArrays are now scalable
-no more rescaling of image files, only boolean arrays
-Bugs Added:
-Potentially less accurate with a very simple scaling method
-Bugs Fixed:
-faster
-Goals
-rotating

05/23/2016:
-Issac Kim
-New Features:
-make driver for class demo
-Bugs Added:
-none
-Bugs Fixed:
-none
-Goals:
-Reading lines of text

05/22/2016:
-Issac Kim 
-New Features:
-add rest of alphabet
-rescale images of alphabet to single size
-Make comparing imput char to preloaded chars work
-return string of image if it is found
-Bug Fixed:
-none
-Bugs Added:
-none
Goals:
-Make reading more than once char work
-Ely Sandine
-New Features:
-Used booleanCharacter class to make loadDirectory which converts all files in a directory to a hashtable with the booleanArray of the picture and a string with the name
-added closestMatch() which compares the booleanArray to all the other characters to find which character it is
-rescale class rescales images
-Bugs Added:
-closestMatch is not very accurate (when comparing a B from the internet it said W"
-Bugs Fixed:
-Made percentError more efficient
-Made booleanCharacters automatically rescale images
-Determined the problem is scaling
-Made the program run much faster
-Goals:
-improve speed
-improve accuracy
-be able to identify letters

05/20/2016:
-Issac Kim
-New Features:
-once program loops through directory, its output images will fill up a new directory
-Bugs Added: 
-none
-Bugs Fixed:
-Directory looping works now
-Goal:
-now that directory looping works for smaller subset of random images, add the rest of the alphabet

05/18/2016:
-Ely Sandine
-New Features:
-percentError method takes two images and retuns the percent error between them
-Bugs Added:
-It prints alot of numbers while it is running, I am not sure why
-Bugs Fixed:
-none
-Goals
-Made a bunch of booleanArrays to check if a letter is the same as another

05/17/2016:
-Ely Sandine
-New Features:
-Created class booleanArray
-Created class Read with static methods
-Read.loadBoolean(String): creates a booleanArray given the name of an image file
-Read.compare(String,String,double): compares the two images and calculates a percent error when both are converted to black and white
-Bugs Added:
-Messy
-Bugs Fixed:
-none
-Goals
-Clean up code
-calculate a percent error given two images
-Issac Kim
-New Features:
-Make Character class, each img file of font will become a character object, which is a boolean array
-Start Characters class, which will store the Character objects
-Begin directory reading, so images can be stored in one directory and the a method can loop through that dir
-Bugs Added:
-directory reading is buggy
-Bugs Fixed:
-none
-Goals:
-fix reading through dirs, so program can compare person's images to preloaded text images

05/16/2016:
-Ely Sandine
-New Features:
-added toBoolean() that converts the array of pixels into booleans with true marking the pixel is part of the character
-Bugs Added:
-Merging with git is not fully understood so it is possible something my have been messed up
-Have not tested the new function yet
-Bugs Fixed:
-none
-Goals
-Work on comparison between image and characters
-Issac Kim
-New Features:
-nothing big, started adding images of text chars in OCR font
-Bug Added:
-none
-Bugs Fixed:
-none
-Goals:
-continue adding ocr font chars and comparison to output string of image files

05/14/2016:
Issac Kim
-New Features:
-Try to begin removing symbols
-After finding background, attempt removing smaller images consisting of non bg color parts
-Bugs Added:
-Not really a bug, but attempt at removing was unsuccessful and scrapped
-Bugs Fixed:
-none
-Goals:
-comparing text to preloaded text

05/13/2016:
-Ely Sandine
-New Features:
-Pixel class keeps track of each pixel
-setRGBValues() converts the pixels back to the image
-outPut takes a file, proccesses it and writes it in a new file
-setBlackAndWhite() converts the pixels to black and white
-Bugs Added:
-none
-Bugs Fixed:
-none
-Goals:
-Comparing with images to get letters
-Issac Kim
-New Features:
-Start loadRGBValues()
-Using an imput image, it loads the rgb values onto an int[]
-Begin looking for background color, in attempt to differentiate between text and non-text
-Issues with bgcolor method is that it uses very simplistic determination method
-Bugs Added:
-none
-Bugs Fixed:
-none
-Goals:
-Try to break an image into smaller sub images

Project Plan:
0) Learn to read image files and convert to pixels
1) Read image files with single characters
2) Read image files with lines of characters
3) Differentiate between spaces
4) Blocks of text
5) Utilize different fonts
6) Find the characters in a image
7) More fonts
8) Put it into calculator or something