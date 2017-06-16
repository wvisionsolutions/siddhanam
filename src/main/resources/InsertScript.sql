INSERT INTO momentum.momentum_unemployment_benefits(
   Id
  ,SSN
  ,Name
  ,gender
  ,age
  ,employment_status
  ,address
  ,phoneNumber
  ,SkillsandAptitudes
  ,GradeLevel
  ,Reading
  ,writing
) VALUES (
   1 -- Id - IN int(11)
  ,'123-77-6789'  -- SSN - IN varchar(50)
  ,'John Krain'  -- Name - IN varchar(100)
  ,'M'  -- gender - IN char(1)
  ,'04/06/1984'   -- age - IN int(11)
  ,'U'  -- employment_status - IN char(1)
  ,'US'  -- address - IN varchar(100)
  ,'765-789-6543'  -- phoneNumber - IN varchar(100)
  ,'Driving'  -- SkillsandAptitudes - IN varchar(100)
  ,'Nine'  -- GradeLevel - IN varchar(100)
  ,'Y'  -- Reading - IN char(1)
  ,'Y'  -- writing - IN char(1)
);

INSERT INTO momentum.hhs_commission(
   Id
  ,SSN
  ,Name
  ,gender
  ,age
  ,disabilities
  ,mobility
  ,Address
  ,PhoneNumber
) VALUES (
   1 -- Id - IN int(11)
  ,'123-88-6789' -- SSN - IN varchar(50)
  ,'Craig Mickel'  -- Name - IN varchar(100)
  ,'M'  -- gender - IN char(1)
  ,'04/01/1964'   -- age - IN int(11)
  ,'No'  -- disabilities - IN varchar(100)
  ,'Yes'  -- mobility - IN varchar(100)
  ,'US'  -- Address - IN varchar(100)
  ,'789-654-3219'  -- PhoneNumber - IN varchar(100)
);


LOCK TABLES `language` WRITE;
INSERT INTO `language` VALUES (1,'English'),(2,'French'),(3,'Hindi'),(4,'Chinese'),(5,'German'),(6,'Russian');
UNLOCK TABLES;



LOCK TABLES `services` WRITE;
INSERT INTO `services` VALUES (1,'ChildCare Service'),(2,'Disability Service'),(3,'Senior Citiizen Service');
UNLOCK TABLES;

INSERT INTO `user` VALUES 
(5,'987-34-3849','Alex','F','12/23/1968','German','N','N','E','Texas','987-287-2979','Recruitment and Training','Bachelors','Y','Y','Admin'),
(6,'132-44-8922','Jerilyn','F','02/15/1971','English','Y','Y','U','Seattle','979-879-8798','Java','Masters','Y','Y','Basic'),
(7,'123-33-4545','John','M','04/03/1979','English','Y','Y','S','California','714-778-9776','Management','Doctorate','Y','Y','Admin'),
(8,'343-87-5593','Sarah','F','09/01/1988','English','N','y','S','123 Seasame Street','128-389-3983','Singer','Bachelors, Masters','Y','Y','Basic'),
(9,'282-44-9894','Mark','M','07/20/1960','Russian','N','Y','U','34 Cienega, Irvine','233-989-4584','Fashion Designing','Masters','Y','Y','Basic'),
(10,'456-34-3938','Dan','M','04/01/1964','English','N','Y','U','Bellvue','343-343-4545','Agilist','Masters','Y','Y','Basic'),
(11,'837-34-3434','Matt','M','04/17/1984','English','Y','N','U','SanJose','343-343-4545','All','Doctorate','Y','Y','Basic'),
(12,'345-34-5465','Felix','M','04/07/2014','English','Y','Y','U','Los Angeles','454-454-4545','Translator','Masters','Y','Y','Basic'),
(13,'234-32-2324','Maria','M','04/01/2014','English','Y','Y','U','Orlando','343-454-3432','Driving','High School','Y','Y','Basic');

INSERT INTO `role` VALUES (1,'Admin'),(2,'Basic');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


