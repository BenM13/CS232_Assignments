# MIT query utiltity

This script is used to query a student database and return a list of students
and email addresses that meet the criteria given in the form of positional argument.
The list is outputed to a .csv file

How to call this script:
    java NewQuery $course_number $output_file $optional_flags

course_number:
If no course number is chosen, the script will search all classes for the given criteria. Multiple courses may be given seperated by a space

output_file:
Should be .txt or .csv filename. If the file aready exists, it will be overwritten.
If no output file is specified, results will be exported to "results.csv"

optional_flags:
-h, --help: displays this help message and exits
-ot, --opt_in: searches for students who have opted in for marketing emails
-p, --paid: searches for students who have paid for courses
-a, --audit: searches for students who have not paid/audited the course
-v, --viewed: searches for students who have viewed course materials
-nv, --not_viewed: searches for students who have not yet viewed any course materials
-c, --completed: searches for students who passed a course
-nc, --not_viewed: seraches for students who have failed or not completed a course