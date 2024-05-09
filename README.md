# Compensation Calculator 
This is a test project for National Conference of Bar Examiners

To execute this project run the following:

**mvn clean package**
**java -jar target/compensation-calculator.jar**


## Quick description

### Consider the following scenario:

A company has departments and employees.
All employees are in one and only one department.
Employees can be either interns, floor workers, supervisors, managers, or executives.
All employees are paid hourly and can be either full-time or part-time.
Full time workers get paid overtime (time and a half) for any hours worked in a week over 40hrs.
The rates for employees are as follows:
Interns – $10/hr
Floor workers - $20/hr
Supervisors - $25/hr
Managers - $35/hr
Executives - $50/hr
Management Level employees (Managers and Executives) get a $50 bonus every week
 
### Create a program that does the following:

Calculates the pay for all employees for the week depending on how many hours each employee worked.
List total pay for each department in a sorted list with highest department first.
List all employees sorted alphabetically across all departments indicating their base pay.
 
### Instructions:

We would like to have this written in vanilla Java or PHP (No Spring, Lombok, etc.).  We want to see your programming skills in action, not what a framework can do.
Please do not write a database layer.  Test data can be hardcoded into your project.
We encourage the use of design patterns.
Output from your code should print to the console.
