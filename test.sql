select classno, classname as name
from sc, (select * from class where class.gno = 'grade one') as sub
where sc.no in (select sno from student where student.classno=sub.classno) and true
order by name

select name
from speak as s1
where not exists(select language
                 from speak
                 where name = 'Eve'
                 except
                 select language
                 from speak
                 where name = s1.name)