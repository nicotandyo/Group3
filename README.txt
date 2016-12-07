# Group3 TCSS 360 Final Project
username = admin, password = admin - to login as an administrative staff.
username = faculty, password = faculty - to login as a faculty staff.
username = advisor, password = advisor - to login as an advisor.
press the "Log in as a student" button to login as a student.

Use cases that are implemented: Add or Update Student' Data, Generate Outputs, Login into the system, 
Graduated students request to edit their employment information and we also implemented the design pattern which is the iterator 
and used it in our StudentGUI class. 
	Nico is working on the model classes and writing tests, add changes in the Phase 3 document. 
	Yau: working on model classes, writing tests, fixing GUI classes, clean up code and working on the design pattern.
	Loc: working on all of the GUI classes, clean up code and add changes in the Phase 3 document.

Instruction for using the program:
Administrative staff:
When you are logged in as an administrative staff, all of the tabs are available except the "Request to Edit Student's Data" tab.
To search for a student, you can press the "Student Search" button and then enter the search keyword.
You can also add a student using the "Add Student" button. You can also add or update student's employment information.
Press the "Student Employment Search" to search an employment.
You can enter any search key, from name, company, position, skill used, and the type of employment. 
You can also add a student employment information to the list. Press the "Add Student Employment" button.
First you have to choose a student and then you have to enter all of the required fields.
You can also generate outputs by choosing one criterion to view by.
Criterion:
GPA - Sort the student based on the GPA from highest to lowest.
Salary - Sort the student based on the salary from highest to lowest.
Major - Show all of the students with selected major and then sort their name in alphabetical order.
Degree - Show all of the students with selected degree and then sort their name in alphabetical order.
Internship - Show all of the students with an internship and then sort their name in alphabetical order.
Job - Show all of the students with a job and then sort their name in alphabetical order.
The users can't generate output for students that don't have employment information. They can use the Search Student in the
"Add or Update Student's Data" tab to do that.
In the "Generates outputs" tab, the users can't edit the student's data. If they want to modify the student's data,
they have to do that in the "Add or Update student's Employment Information" tab.
You can also view and delete student request in the "View Student Request" tab.
You can press the "Log Out" tab and then press the "Log Out" button to log out from the program.

Advisor:
When you are logged in as an advisor, only "Add or Update Student's Data", "Add or Update Student's Employment Information",
 "View Student Request", and "Log Out" tabs are available.
To search for a student, you can press the "Student Search" button and then enter the search keyword.
You can also add a student using the "Add Student" button. You can also add or update student's employment information.
Press the "Student Employment Search" to search an employment.
You can enter any search key, from name, company, position, skill used, and the type of employment. 
You can also add a student employment information to the list. Press the "Add Student Employment" button. 
First you have to choose a student and then you have to enter all of the required fields.
You can also view and delete student request in the "View Student Request" tab.
You can press the "Log Out" tab and then press the "Log Out" button to log out from the program.

Faculty:
When you are logged in as a faculty, only "Generate Outputs" and "Log Out" tabs are available.
You can also generate outputs by choosing one criterion to view by.
Criterion:
GPA - Sort the student based on the GPA from highest to lowest.
Salary - Sort the student based on the salary from highest to lowest.
Major - Show all of the students with selected major and then sort their name in alphabetical order.
Degree - Show all of the students with selected degree and then sort their name in alphabetical order.
Internship - Show all of the students with an internship and then sort their name in alphabetical order.
Job - Show all of the students with a job and then sort their name in alphabetical order.
You can press the "Log Out" tab and then press the "Log Out" button to log out from the program.
In the "Generates outputs" tab, the users can't edit the student's data. If they want to modify the student's data,
they have to do that in the "Add or Update student's Employment Information" tab.

Student:
When you are logged in as a student, only the "Request to Edit Student's Data" and "Log Out" tabs are available.
You can only make a request to edit your employment data.
You can fill in all of the new information you would like to have in your student employment information.
You can also press the "Log Out" tab and then press the "Log Out" button to log out from the program.

Our program will catch the exceptions when:
	You add a student with an existing SID.
	You input invalid start day and end day.
	You input a salary not as an integer.
	You input an invalid GPA (negative or larger than 4.0).
	
Lastly, when there is no internet connection, our program will display a message dialog that says 
"Unable to connect to the server! Please check your internet connection and restart the program!" when users try to log in.
In addition, if you are already logged in into the system and you lose your internet connection, then our program will be trying to
connect to the server and it takes 10 seconds to do that, after that it will pop up a message says that "Unable to connect to the
server! Please check your internet connection and restart the program!" when you try to do any operations. 
