--select all male student

select * from student WHERE studentGender = 'male';

select s.studentID, s.studentFName , s.studentLName , count(e.examID) as 'Number of Exam'
From s student join e exam on e.studentid = s.studentid
group by s.studentID, s.studentFName , s.studentLName, e.studentID