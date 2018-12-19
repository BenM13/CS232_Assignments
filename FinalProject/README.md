# MIT query utiltity

This script is used to query a student database and return a list of students
and email addresses that meet the criteria given in the form of positional argument.
The list is outputed to a .csv file

How to call this script:
    java NewQuery $course_number $output_file $optional_flags

IMPORTAN: the Java Classpath variable must be set to "lib/sqlite-jdbc-3_23_1.jar" in order for 
the driver to be found. If Classpath variable is not set, script should be called as follows:
    on Unix:        java -cp ":/lib/sqlite-jdbc-3_23_1.jar" NewQuery $arguments
    on Windows:     java -cp ";lib\sqlite-jdbc-3_23_2.jar" NewQuery $arguments
SQLite3 must also be installed

$course_number:
If no course number is chosen, the script will search all classes for the given criteria. 
Multiple courses may be given seperated by a space
For a list of course numbers open the file /docs/course_nums.txt

$output_file:
Should be .txt or .csv filename. If the file aready exists, it will be overwritten.
If no output file is specified, results will be exported to "results.csv"

$optional_flags:
-h, --help: displays this help message and exits
-oi, --opt_in: searches for students who have opted in for marketing emails
-p, --paid: searches for students who have paid for courses
-a, --audit: searches for students who have not paid/audited the course
-v, --viewed: searches for students who have viewed course materials
-nv, --not_viewed: searches for students who have not yet viewed any course materials
-c, --completed: searches for students who passed a course
-nc, --not_completed: seraches for students who have failed or not completed a course