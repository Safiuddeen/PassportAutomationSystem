create database Paport_System;
use Paport_System;


create table AdminUser (UserName varchar(50),Password varchar (25));
insert into AdminUser values ('SAFI','Safi1234');
insert into AdminUser values ('RUWAN','Ruwan321');

-- create application form
CREATE TABLE Application_Form (
    ApplicantId INT AUTO_INCREMENT PRIMARY KEY,
    PassportID VARCHAR(8),
    UserFullName VARCHAR(50),
    DateOfBirth DATE,
    Gender VARCHAR(100),
    NICNumber VARCHAR(30),
    Address VARCHAR(50),
    MobilNumber INT(15),
    E_mail VARCHAR(30),
    PoliceLocation VARCHAR(30),
    Postalcode INT(20),
    Documentdate date,
    image_BC longblob,
    image_NIC longblob,
    image_Applicant longblob,
    Verification varchar(20),PoliceReport varchar(20),PassportStatus varchar(20)
);

alter table Application_Form
add About varchar(200);

-- Create trigger to generate PassportID
DELIMITER //
CREATE TRIGGER generate_PassportID_before_insert
BEFORE INSERT ON Application_Form
FOR EACH ROW
BEGIN
    DECLARE maxApplicantId INT;
    SELECT MAX(ApplicantId) INTO maxApplicantId FROM Application_Form;
    IF maxApplicantId IS NULL THEN
        SET maxApplicantId = 0;
    END IF;
    SET NEW.PassportID = CONCAT('SLP', LPAD(maxApplicantId + 1, 5, '0'));
END;
//
DELIMITER ;


-- create Account for userRejistration
create table CreateAccount (UserName varchar(45),MobilNumber int(20),E_mail varchar (40), 
Password varchar(25));

-- Police report table
create table Police_Report(PassportID VARCHAR(8),NICNumber VARCHAR(30),UserFullName VARCHAR(50),
PoliceReport_image longblob);
drop table Police_Report;



select * from AdminUser;
select * from Application_Form;
select * from CreateAccount;

select * from Police_report;
drop table Application_Form;
