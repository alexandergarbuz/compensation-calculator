package com.garbuz.calculator;

/**
Consider the following scenario:
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
 
Create a program that does the following:
Calculates the pay for all employees for the week depending on how many hours each employee worked.
List total pay for each department in a sorted list with highest department first.
List all employees sorted alphabetically across all departments indicating their base pay.
 
Instructions:
We would like to have this written in vanilla Java or PHP (No Spring, Lombok, etc.).  We want to see your programming skills in action, not what a framework can do.
Please do not write a database layer.  Test data can be hardcoded into your project.
We encourage the use of design patterns.
Output from your code should print to the console.
Please email your project (or a link to your project) to Brian at bmccrary@ncbex.org within a few days.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Department unitedWorkers = DepartmentFactory.create("United Workers");
    	Department workersUnited = DepartmentFactory.create("Workers United");
    	Department abcAndMore = DepartmentFactory.create("ABC and More");
    	
    	Company company = new Company();
    	company.addDepartment(abcAndMore);
    	company.addDepartment(workersUnited);
    	company.addDepartment(unitedWorkers);
    	
    	Schedule schedule = new Schedule();
    	
    	Scheduler.schedule(schedule, unitedWorkers, 20, EmployeeFactory.create("John", "Smith Jr.", JobType.INTERN));
    	Scheduler.schedule(schedule, unitedWorkers, 40, EmployeeFactory.create("John", "Smith",     JobType.FLOOR_WORKER));
    	Scheduler.schedule(schedule, unitedWorkers, 30, EmployeeFactory.create("John", "Smith Sr.", JobType.SUPERVISOR));
    	Scheduler.schedule(schedule, unitedWorkers, 40, EmployeeFactory.create("Bob", "Stevenson",  JobType.FLOOR_WORKER));
    	Scheduler.schedule(schedule, unitedWorkers, 50, EmployeeFactory.create("Jack", "Smith",     JobType.MANAGER));
    	Scheduler.schedule(schedule, unitedWorkers, 60, EmployeeFactory.create("Alex", "Garbuz",    JobType.EXECUTIVE));
    	Scheduler.schedule(schedule, unitedWorkers, 45, EmployeeFactory.create("Susan", "Johnson",  JobType.SUPERVISOR));
    	
    	Scheduler.schedule(schedule, workersUnited, 20, EmployeeFactory.create("Susan", "The Intern",    JobType.INTERN));
    	Scheduler.schedule(schedule, workersUnited, 40, EmployeeFactory.create("Bob", "The Floor worker",JobType.FLOOR_WORKER));
    	Scheduler.schedule(schedule, workersUnited, 30, EmployeeFactory.create("John", "The Supervisor.",JobType.SUPERVISOR));
    	Scheduler.schedule(schedule, workersUnited, 40, EmployeeFactory.create("Jack", "The Manager",    JobType.MANAGER));
    	Scheduler.schedule(schedule, workersUnited, 60, EmployeeFactory.create("Julie", "The Boss",      JobType.EXECUTIVE));

    	Scheduler.schedule(schedule, abcAndMore, 20, EmployeeFactory.create("Sam", "The Intern",       JobType.INTERN));
    	Scheduler.schedule(schedule, abcAndMore, 40, EmployeeFactory.create("Sue", "The Floor worker", JobType.FLOOR_WORKER));
    	Scheduler.schedule(schedule, abcAndMore, 30, EmployeeFactory.create("Maggie", "The Supervisor",JobType.SUPERVISOR));
    	Scheduler.schedule(schedule, abcAndMore, 40, EmployeeFactory.create("Brien", "The Manager",    JobType.MANAGER));
    	Scheduler.schedule(schedule, abcAndMore, 60, EmployeeFactory.create("Oliver", "The Boss",      JobType.EXECUTIVE));
    	
    	Calculator calc = CalculatorFactory.create(company, schedule);
    	
    	System.out.println(calc.calculatePayByDepartment());
    	
    	System.out.println(calc.calclulatePayByLastName());
    	


    	
    	
    	
    }
}
