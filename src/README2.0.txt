How to run the program:

Run the DietManagerApp.java file



When the program opens, you will see a JFrame that has a Menu and 4 buttons on it. 

In the Menu:
Under the File button, there is an exit.
Under the About button, there is information about the authors of the program
and which version of the program this is. 
Under the Help button, there is instructions for how to run the program 
and contact information in case you have any questions. 

On the Main UI:
There are 4 buttons: View Log, Add Food, Track Weight, and Exercise.

Clicking on the Add Food button allows you to Log an existing Food to the Database,
specifying the number of portions consumed for that food.
You can also add a new food to the Database, by providing the Food name, 
Calories, Fats, Carbs, and Proteins associated with that food. 
Also if you add a new Food it will instantly show up in the combobox.

Clicking on the Exercise button allows you to Log an existing exercise or 
add a new exercise to the Database.
To log an existing exercise you need to specify which exercise you completed and the 
time in minutes that you did it for.
To add a new Exercise you need to specify the name of the exercise and the calories
that are expended in 1 hour for a 100 pound person doing that exercise. 
Also if you add a new Exercise it will instantly show up in the combobox.

Clicking on the View Log Button brings up the DailyLog. The default is the current
date. If there are no entries for the current date then it says "No entries found."
At the bottom of this frame there is a Filter By Date Search Bar that lets the user 
specify by date which day of the DailyLog they want to look at. 

Clicking on the Track Weight button pops up a Input Box that prompts you to enter your Weight.
When you click "OK" the Weight is submitted to the log.csv file.