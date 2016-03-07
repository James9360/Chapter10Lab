# Lab 3: Chapter 10
**Due:** March 13th by 6:30 PM

## Question 1: `FileArray` Class

Design a class that has a static method named `writeArray`. The method should take two arguments: the name of a file 
and a reference to an `int` array. The file should be opened as a binary file, the contents of the array should be 
written to the file, and then the file should be closed.

Write a second method in the class named `readArray`. The method should take two arguments: the name of a file and 
a reference to an `int` array. The file should be opened, data should be read from the file and stored in the array,
and then the file should be closed.

Demonstrate both methods in a program in Question1.java.
	
**Points breakdown**

- Technical: 10 points
- Style: 5 points
- Total: 15 points

## Question 2: `Employee` Serialization

Modify the `Employee` class that you created for the Chapter 9 Lab to be serializable. Write a program that
creates an array of at least five `Employee` objects and serializes them in Question2Write.java. 

Write another program that deserializes the objects from the file in Question2Read.java.
	
**Points breakdown**

- Technical: 20 points
- Style: 5 points
- Total: 25 points

## Question 3: Exception Project

Modify the `Employee` and `ProductionWorker` classes from the Chapter 9 lab so they throw exceptions when the 
following errors occur:

1. The `Employee` class should throw an exception named `InvalidEmployeeNumber` when it receives an employee
number that is less than 0 or greater than 9999.
2. The `ProductionWorker` class should throw an exception named `InvalidShift` when it receives an invalid shift.
3. The `ProductionWorker` class should throw an exception named `InvalidPayRate` when it receives a negative
number for the hourly pay rate.

Write a test program that demonstrates how each of these exception conditions work in Question3.java.
	
**Points breakdown**

- Technical: 25 points
- Style: 5 points
- Total: 30 points

----
### How to submit the lab
This section outlines how to get the lab on to your computer and how to submit it.

1. Fork the Chapter 10 lab repository
2. Import the project into Eclipse
	1. Click File->Import...
	2. Choose Git->Projects from Git
	3. Choose "Clone URI", press Next
	4. Copy the clone URI on **your forked** github repository (bottom right)
	5. Paste the URI into the Eclipse window
	6. Set your GitHub user name and password, leave everything else as it is.
	7. Press Next
	8. Choose Master on the "Branch Selection" screen and press Next
	9. Choose a local destination directory and press Next
	10. Select "Import existing Eclipse project" (should be default choice), press Next.
	11. Press Finish and your project is imported!
	12. Right click the project in the package explorer, click Maven->Update Project... (Or press Alt+F5)
3. Do the actual lab work
	1. Read/implement the Question sections above
	2. Keep all existing and new classes in the edu.carroll.cis232 package.
	3. Do not rename any existing files.
4. Test your work.
	1. Run the application by pressing the Play button to test your program manually.
	2. Feel free to write unit tests to test your work
5. Submit your work
	1. Right click the project
	2. Choose Team->Commit...
	3. Enter a comment such as "My solution for the chapter 10 lab"
	4. Enter your name/email for the author/committer fields if it is not set
	5. Press "Commit and Push". (Committing saves the changes locally, Pushing saves the changes on your GitHub fork)
	6. Your work is now on your GitHub fork.  Open up the browser to your GitHub fork of the lab.
	7. Press the green pull request button at the top to the left of the "Branch: master" dropdown.
	8. To finally submit your lab, Click the green "Create new pull request" button, enter a title and message, and press "Create pull request".
	9. Your lab is now submitted!

