# Image Processing Application

<b><i>Part 1</i></b>

This application can perform the following operations:
1. Convert image to gray scale
2. Convert image to sepia tone
3. Apply blur filter on the image
4. Apply sharpen filter on the image
5. Generate a rainbow image with both horizontal and vertical stripes
6. Generate an image with a checkerboard pattern
7. Generate the an image with the Flag of France and Flag of Greece.

To input the image to be transformed, go to the utility folder and go to the ImageReader file.  
Under the main method, the first line of code would be to create a new File with the specified pathname.  
This pathname can be altered to take any image path required, provided that the image has a format among png, jpg or bmp.  
Make sure that the path specified for the originalLocation variable is similar to the directory location specified while making the new File in the previous step.
After giving in the path of the image in consideration, run the main method.  
The new images will be formed in the res directory.  

The images used in the application were airplane.png and cat.png taken from the website:  
https://homepages.cae.wisc.edu/~ece533/images/ . 


Both cat.png and airplane.png are owned by the website mentioned above. The website holds images soley meant for project work
and testing.

<b><i>Part 2</i></b>

<font size = "40"><b>To Run the Application:</b></font>

Copy the input.txt file from the project folder and make changes if required.

<b>Add it to the folder from where you are running the application.</b>
    
 
The output images will be stored in a folder called <b>res</b> in the same location from where the application is run.


<b>Design changes:</b>

The individual interfaces for each of the image filters or transformations have been removed. There was no requirement of an interface for every operation. So a single interface, IImage, was created which could be used to perform the operations from each class.


The FileHelper class has also been removed. It was created in order to support multiple image file types like png, jpg and bmp, in the main driver class of Version 1. Now that a controller handles script reading, there is no requirement of a driver class or the FileHelper class. The user can load the image and save the image with the image file type of their choice, in the script.

The application now supports these additional features:

1. Dithering of the image.
2. Mosaic filter on the image.

Two controllers have also been added to this version of the application. One controller is responsible for reading a file with the commands entered by a user. The input commands trigger the requested operation on the image and finally those images are saved to the res folder.


The application currently supports any kind of file like text or bash files. The other controller is created in order to support any future kinds of user interaction with the application. 

<b>Script Commands:</b>

1. load to load the image to be transformed:

    Eg: load cat.png

2. blur, dither, sepia, grayscale and sharpen are given as a single command:

    Eg: dither

3. mosaic is given along with the number of seeds required:

    Eg: mosaic 1000

4. To generate a checkerboard image the square size is also mentioned:

    Eg: generate checkerboard 40

5. To generate a rainbow image, the orientation along with the height and width are mentioned:

    Eg: generate vibgyor horizontal 500 400

6. To generate either the France or Greece flag, the country name and the height and width of the image are mentioned:

    Eg: generate flag greece 200 300

7. save to save a new output image after the operations have been added:

    Eg: save greece-flag.png

