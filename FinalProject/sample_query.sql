SELECT c.student_id AS id, c.course_number AS course,
students.student_name AS student_name, students.student_email AS email
FROM (SELECT * FROM courses_taken WHERE course_number IN ('101x/FL17')  AND paid = 1) c
JOIN students ON students.student_id = c.student_id
WHERE email_opt_in = 1;

