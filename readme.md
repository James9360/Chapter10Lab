# Lab 3: Chapter 10
**Due:** October 13th by 6:30 PM

## Question 1: TestScores Class

Write a class named *TestScores*. The class constructor should accept an array of doubles representing test scores as its argument. The class should have a method that returns the average of the test scores named **getAverage**.

Write an exception class named *InvalidTestScoreException*.  If any test score in the array is negative or greater than 100, the *TestScores* class constructor should throw an *InvalidTestScoreException*.

From the Question1 main method, ask the user to enter any number of test scores separated by commas. Then show the user the average of the test scores formatted as a percentage rounded to the nearest tenth of a percent (round up on 5s).  If a test score is not a  number, skip it, and print a message indicating it was skipped.  Accept any number, but use the *InvalidTestScoreException* from the constructor to show a message if a number is out of bounds.

Example run #1:

    Enter the test scores separated with a comma:
	> 90,72.4,80,100,99.9
	The average score is 88.5%

Example run #2:

	Enter the test scores separated with a comma:
	> 99,abc,10,def,100,100,100
	Skipped non-number "abc"
	Skipped non-number "def"
	The average score is 81.8%
	
Example run #3

	Enter the test scores separated with a comma:
	> 101,90,99,100
	Test scores must be between 0 and 100.
	
**Points breakdown**

- Technical: 25 points
- Style: 10 points
- Total: 35 points

## Question 2: TestScores Serialization

Modify the class named *TestScores* so it is serializable.  Write a program in the Question2 main method that asks the user for a test scores file name.  If the file exists, deserialize the *TestScores* objects from the file and display the list of scores and averages for each *TestScores* object.  Ask the user to enter a new set of test scores to append to the file.  If the user does not enter valid scores (see question 1), exit the program. Otherwise, append to the existing file or create a new file containing the serialized *TestScores*.

Example run #1:
	
	Enter the path to a TestScores dat file:
	> newscores.dat
	This is a new file!
	Enter test scores to append to the file separated with a comma:
	> 90,72.4,80,100,99.9
	The average score is 88.5%
	newscores.dat file updated.
	
Example run #2:

	Enter the path to a TestScores dat file:
	> oldscores.dat
	The file contains the following scores:
	90,72.4,80,100,99.9: Average 88.5%
	100,100,100: Average 100%
	90,90,90,90,90,90,90,100: Average 91.3%
	Enter test scores to append to the file separated with a comma:
	50,50,50,50
	The average score is 50%
	oldscores.dat file updated.
	
**Points breakdown**

- Technical: 25 points
- Style: 10 points
- Total: 35 points

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
	1. Read/implement the Question 1 section above
	2. Keep all existing and new classes in the edu.carroll.cis232 package.
	3. Do not rename any existing files.
4. Test your work.
	1. Run the application by pressing the Play button to test your program manually.
	2. To test your program with the built-in Unit tests: 
		1. Open the unit test class named Question1Test in the src/test/java folder.
		2. Press the Play button.
		3. The failed tests will show up as red on the left. Passed tests will show up as green.
		4. Repeat the process with Question2Test
5. Submit your work
	1. Right click the project
	2. Choose Team->Commit...
	3. Enter a comment such as "My solution for the chapter 8 lab"
	4. Enter your name/email for the author/committer fields if it is not set
	5. Press "Commit and Push". (Committing saves the changes locally, Pushing saves the changes on your GitHub fork)
	6. Your work is now on your GitHub fork.  Open up the browser to your GitHub fork of the example lab.
	7. Press the green pull request button at the top to the left of the "Branch: master" dropdown.
	8. To finally submit your lab, Click the green "Create new pull request" button, enter a title and message, and press "Create pull request".
	9. Your lab is now submitted!

**Special**: You can give "kudos" points to up to 2 people for helping you with the lab either through tutoring or by looking at their forks.  When you submit your lab, indicate up to 2 people that you would like to give points. A student can earn up to 5 bonus points combined from multiple kudos.
