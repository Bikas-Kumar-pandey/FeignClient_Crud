https://www.dotnettricks.com/learn/sqlserver/different-types-of-sql-server-functions#:~:text=A%20function%20is%20a%20database,the%20database%20table(s).
CREATE TABLE Employee
(
 EmpID int PRIMARY KEY,
 FirstName varchar(50) NULL,
 LastName varchar(50) NULL,
 Salary int NULL,
 Address varchar(100) NULL,
)

Insert into Employee(EmpID,FirstName,LastName,Salary,Address) Values(1,'Mohan','Chauahn',22000,'Delhi');
Insert into Employee(EmpID,FirstName,LastName,Salary,Address) Values(2,'Asif','Khan',15000,'Delhi');
Insert into Employee(EmpID,FirstName,LastName,Salary,Address) Values(3,'Bhuvnesh','Shakya',19000,'Noida');
Insert into Employee(EmpID,FirstName,LastName,Salary,Address) Values(4,'Deepak','Kumar',19000,'Noida');

select * from demo


--Scalar Function

create function employeeFullName(
@FirstName varchar(50),
@LastName varchar(50)
)
returns varchar(100)
As
Begin return  (select @FirstName +' '+ @LastName);
end


SELECT dbo.employeeFullName(FirstName,LastName) as Name from Employee e


--Inline Table-Valued Function
create function returnEmployee() returns table as  return (select * from Employee);

select * from returnEmployee()


create function EmployeeMulValue()returns @Employee table(
EmpId int, FirstName varchar(50), Salary int)  as begin
  Insert into @Employee Select e.EmpID,e.FirstName,e.Salary from Employee e

  Select * from EmployeeMulValue()

--Now update salary of first employee
 update @Employee set Salary=25000 where EmpID=1;
--It will update only in @Emp table not in Original Employee table
return
end
Select * from Employee



