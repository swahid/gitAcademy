-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.41-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema elearning
--

CREATE DATABASE IF NOT EXISTS elearning;
USE elearning;

--
-- Definition of table `chapter_image`
--

DROP TABLE IF EXISTS `chapter_image`;
CREATE TABLE `chapter_image` (
  `chaimgid` int(11) NOT NULL auto_increment,
  `schid` int(11) default NULL,
  `imagename` varchar(45) default NULL,
  `imageurl` varchar(200) default NULL,
  `imagetype` varchar(45) default NULL,
  `imagesize` varchar(50) default NULL,
  PRIMARY KEY  (`chaimgid`),
  KEY `FK_jo47q1ed5n2eruabtf4aqf2qb` (`schid`),
  CONSTRAINT `FK_jo47q1ed5n2eruabtf4aqf2qb` FOREIGN KEY (`schid`) REFERENCES `sub_chapter` (`schid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `chapter_image`
--

/*!40000 ALTER TABLE `chapter_image` DISABLE KEYS */;
/*!40000 ALTER TABLE `chapter_image` ENABLE KEYS */;


--
-- Definition of table `chapter_type`
--

DROP TABLE IF EXISTS `chapter_type`;
CREATE TABLE `chapter_type` (
  `chtyid` int(11) NOT NULL auto_increment,
  `subid` int(11) default NULL,
  `typename` varchar(45) NOT NULL,
  PRIMARY KEY  (`chtyid`),
  KEY `FK_hkq6u1cxsorl1x97pgachi7vu` (`subid`),
  CONSTRAINT `FK_hkq6u1cxsorl1x97pgachi7vu` FOREIGN KEY (`subid`) REFERENCES `subject` (`subid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `chapter_type`
--

/*!40000 ALTER TABLE `chapter_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `chapter_type` ENABLE KEYS */;


--
-- Definition of table `class_info`
--

DROP TABLE IF EXISTS `class_info`;
CREATE TABLE `class_info` (
  `classid` int(11) NOT NULL auto_increment,
  `classname` varchar(45) NOT NULL,
  PRIMARY KEY  (`classid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `class_info`
--

/*!40000 ALTER TABLE `class_info` DISABLE KEYS */;
INSERT INTO `class_info` (`classid`,`classname`) VALUES 
 (1,'class1'),
 (2,'class2'),
 (3,'class3'),
 (4,'class4'),
 (5,'class5'),
 (6,'class6'),
 (7,'class7'),
 (8,'class8'),
 (9,'class9'),
 (10,'class10');
/*!40000 ALTER TABLE `class_info` ENABLE KEYS */;


--
-- Definition of table `desc_que_smeta`
--

DROP TABLE IF EXISTS `desc_que_smeta`;
CREATE TABLE `desc_que_smeta` (
  `descmetaid` int(11) NOT NULL auto_increment,
  `descquid` int(11) default NULL,
  `descqucmnt` longtext,
  `userid` varchar(45) default NULL,
  `cmnttime` datetime default NULL,
  PRIMARY KEY  (`descmetaid`),
  KEY `FK_kq155xpof8j1xm8hnfy7sd2f2` (`descquid`),
  CONSTRAINT `FK_kq155xpof8j1xm8hnfy7sd2f2` FOREIGN KEY (`descquid`) REFERENCES `desc_ques` (`descquesid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `desc_que_smeta`
--

/*!40000 ALTER TABLE `desc_que_smeta` DISABLE KEYS */;
/*!40000 ALTER TABLE `desc_que_smeta` ENABLE KEYS */;


--
-- Definition of table `desc_ques`
--

DROP TABLE IF EXISTS `desc_ques`;
CREATE TABLE `desc_ques` (
  `descquesid` int(11) NOT NULL auto_increment,
  `schid` int(11) default NULL,
  `descqutitle` longtext,
  `firstquestion` longtext,
  `firstanswer` longtext,
  `secondquestion` longtext,
  `secondanswer` longtext,
  `thirdquestion` longtext,
  `thirdanswer` longtext,
  `fourthquestion` longtext,
  `fourthanswer` longtext,
  `descqupubtime` datetime default NULL,
  `image` varchar(45) default NULL,
  PRIMARY KEY  (`descquesid`),
  KEY `FK_ce5t5metwxybim0vh65weokrd` (`schid`),
  CONSTRAINT `FK_ce5t5metwxybim0vh65weokrd` FOREIGN KEY (`schid`) REFERENCES `sub_chapter` (`schid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `desc_ques`
--

/*!40000 ALTER TABLE `desc_ques` DISABLE KEYS */;
/*!40000 ALTER TABLE `desc_ques` ENABLE KEYS */;


--
-- Definition of table `exam`
--

DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam` (
  `examid` int(11) NOT NULL auto_increment,
  `totalques` int(11) default NULL,
  `examname` varchar(45) default NULL,
  `examtime` int(11) default NULL,
  `examstatus` varchar(45) default NULL,
  `passmarks` int(11) default NULL,
  PRIMARY KEY  (`examid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `exam`
--

/*!40000 ALTER TABLE `exam` DISABLE KEYS */;
/*!40000 ALTER TABLE `exam` ENABLE KEYS */;


--
-- Definition of table `exam_ques_link`
--

DROP TABLE IF EXISTS `exam_ques_link`;
CREATE TABLE `exam_ques_link` (
  `examlinkid` int(11) NOT NULL auto_increment,
  `chtyid` int(11) default NULL,
  `examid` int(11) default NULL,
  `queslevelid` int(11) default NULL,
  `totalquesno` int(11) default NULL,
  PRIMARY KEY  (`examlinkid`),
  KEY `FK_hq8wq065dchnkmehtxtef59b2` (`chtyid`),
  KEY `FK_9s3kplgu0c5k4ws6wm5wvatw3` (`examid`),
  KEY `FK_3eq7m318q5wyfpal8xecft7vu` (`queslevelid`),
  CONSTRAINT `FK_3eq7m318q5wyfpal8xecft7vu` FOREIGN KEY (`queslevelid`) REFERENCES `ques_level` (`queslevelid`),
  CONSTRAINT `FK_9s3kplgu0c5k4ws6wm5wvatw3` FOREIGN KEY (`examid`) REFERENCES `exam` (`examid`),
  CONSTRAINT `FK_hq8wq065dchnkmehtxtef59b2` FOREIGN KEY (`chtyid`) REFERENCES `chapter_type` (`chtyid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `exam_ques_link`
--

/*!40000 ALTER TABLE `exam_ques_link` DISABLE KEYS */;
/*!40000 ALTER TABLE `exam_ques_link` ENABLE KEYS */;


--
-- Definition of table `exam_result`
--

DROP TABLE IF EXISTS `exam_result`;
CREATE TABLE `exam_result` (
  `rsid` int(11) NOT NULL auto_increment,
  `examid` int(11) default NULL,
  `userid` int(11) default NULL,
  `examdate` datetime default NULL,
  `totalques` int(11) default NULL,
  `marksobtained` int(11) default NULL,
  PRIMARY KEY  (`rsid`),
  KEY `FK_rqdmdynbtbqu4n9n23pjg5b20` (`examid`),
  KEY `FK_e09lit6m2o54dpr99601ndac0` (`userid`),
  CONSTRAINT `FK_e09lit6m2o54dpr99601ndac0` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`),
  CONSTRAINT `FK_rqdmdynbtbqu4n9n23pjg5b20` FOREIGN KEY (`examid`) REFERENCES `exam` (`examid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `exam_result`
--

/*!40000 ALTER TABLE `exam_result` DISABLE KEYS */;
/*!40000 ALTER TABLE `exam_result` ENABLE KEYS */;


--
-- Definition of table `institution_info`
--

DROP TABLE IF EXISTS `institution_info`;
CREATE TABLE `institution_info` (
  `insid` int(11) NOT NULL auto_increment,
  `userid` int(11) NOT NULL,
  `insname` varchar(100) default NULL,
  `instype` varchar(45) default NULL,
  `insaddress` varchar(200) default NULL,
  `insdistrict` varchar(45) default NULL,
  PRIMARY KEY  (`insid`),
  UNIQUE KEY `UK_fqlci00rk6bipf1e8bu3ipx8n` (`userid`),
  CONSTRAINT `FK_fqlci00rk6bipf1e8bu3ipx8n` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `institution_info`
--

/*!40000 ALTER TABLE `institution_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `institution_info` ENABLE KEYS */;


--
-- Definition of table `mcq_ques`
--

DROP TABLE IF EXISTS `mcq_ques`;
CREATE TABLE `mcq_ques` (
  `mcqid` int(11) NOT NULL auto_increment,
  `chtyid` int(11) default NULL,
  `queslevelid` int(11) default NULL,
  `schid` int(11) default NULL,
  `user` varchar(45) default NULL,
  `mcqtitle` longtext,
  `op1` varchar(45) default NULL,
  `op2` varchar(45) default NULL,
  `op3` varchar(45) default NULL,
  `op4` varchar(45) default NULL,
  `ansop` varchar(45) default NULL,
  `mcqtype` int(11) default NULL,
  `mcqpubtime` datetime default NULL,
  PRIMARY KEY  (`mcqid`),
  KEY `FK_tdah9acokp2hihbbw87p0gbfx` (`chtyid`),
  KEY `FK_irp2c42dn0jtyue7oddwshnwy` (`queslevelid`),
  KEY `FK_51c03uf5xdtcs7qwgfhgvsk59` (`schid`),
  CONSTRAINT `FK_51c03uf5xdtcs7qwgfhgvsk59` FOREIGN KEY (`schid`) REFERENCES `sub_chapter` (`schid`),
  CONSTRAINT `FK_irp2c42dn0jtyue7oddwshnwy` FOREIGN KEY (`queslevelid`) REFERENCES `ques_level` (`queslevelid`),
  CONSTRAINT `FK_tdah9acokp2hihbbw87p0gbfx` FOREIGN KEY (`chtyid`) REFERENCES `chapter_type` (`chtyid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mcq_ques`
--

/*!40000 ALTER TABLE `mcq_ques` DISABLE KEYS */;
/*!40000 ALTER TABLE `mcq_ques` ENABLE KEYS */;


--
-- Definition of table `ques_level`
--

DROP TABLE IF EXISTS `ques_level`;
CREATE TABLE `ques_level` (
  `queslevelid` int(11) NOT NULL auto_increment,
  `queslevelname` varchar(45) NOT NULL,
  PRIMARY KEY  (`queslevelid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ques_level`
--

/*!40000 ALTER TABLE `ques_level` DISABLE KEYS */;
/*!40000 ALTER TABLE `ques_level` ENABLE KEYS */;


--
-- Definition of table `sub_chapter`
--

DROP TABLE IF EXISTS `sub_chapter`;
CREATE TABLE `sub_chapter` (
  `schid` int(11) NOT NULL auto_increment,
  `subid` int(11) default NULL,
  `schname` varchar(100) default NULL,
  `schtopics` longtext,
  `schhints` longtext,
  `subpaper` varchar(45) default NULL,
  PRIMARY KEY  (`schid`),
  KEY `FK_ini5l7tv2jkh7647aa2491oaw` (`subid`),
  CONSTRAINT `FK_ini5l7tv2jkh7647aa2491oaw` FOREIGN KEY (`subid`) REFERENCES `subject` (`subid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sub_chapter`
--

/*!40000 ALTER TABLE `sub_chapter` DISABLE KEYS */;
/*!40000 ALTER TABLE `sub_chapter` ENABLE KEYS */;


--
-- Definition of table `sub_ebook`
--

DROP TABLE IF EXISTS `sub_ebook`;
CREATE TABLE `sub_ebook` (
  `ebookid` int(11) NOT NULL auto_increment,
  `subid` int(11) default NULL,
  `booklink` varchar(45) default NULL,
  PRIMARY KEY  (`ebookid`),
  KEY `FK_4gqhtob1mnb3urjrlvoxcvmnp` (`subid`),
  CONSTRAINT `FK_4gqhtob1mnb3urjrlvoxcvmnp` FOREIGN KEY (`subid`) REFERENCES `subject` (`subid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sub_ebook`
--

/*!40000 ALTER TABLE `sub_ebook` DISABLE KEYS */;
/*!40000 ALTER TABLE `sub_ebook` ENABLE KEYS */;


--
-- Definition of table `subject`
--

DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `subid` int(11) NOT NULL auto_increment,
  `classid` int(11) default NULL,
  `subname` varchar(45) default NULL,
  `subdesc` longtext,
  `subcode` varchar(10) default NULL,
  PRIMARY KEY  (`subid`),
  KEY `FK_e6200t51sv52xrjb2wdkfg1mb` (`classid`),
  CONSTRAINT `FK_e6200t51sv52xrjb2wdkfg1mb` FOREIGN KEY (`classid`) REFERENCES `class_info` (`classid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `subject`
--

/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL auto_increment,
  `insid` int(11) default NULL,
  `roleid` int(11) default NULL,
  `username` varchar(45) NOT NULL,
  `userpass` varchar(45) default NULL,
  `useremail` varchar(45) NOT NULL,
  `userphone` varchar(20) default NULL,
  `date` datetime default NULL,
  `firstname` varchar(45) default NULL,
  `lastname` varchar(45) default NULL,
  PRIMARY KEY  (`userid`),
  KEY `FK_nriy793uggs9mo4dv1pmebwm4` (`insid`),
  KEY `FK_6jfb22mx5nh0qym11cb92wqbg` (`roleid`),
  CONSTRAINT `FK_6jfb22mx5nh0qym11cb92wqbg` FOREIGN KEY (`roleid`) REFERENCES `user_role` (`roleid`),
  CONSTRAINT `FK_nriy793uggs9mo4dv1pmebwm4` FOREIGN KEY (`insid`) REFERENCES `institution_info` (`insid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`userid`,`insid`,`roleid`,`username`,`userpass`,`useremail`,`userphone`,`date`,`firstname`,`lastname`) VALUES 
 (1,NULL,2,'saurav','456','saurav@gmail.com',NULL,NULL,NULL,NULL),
 (2,NULL,1,'admin','456','admin@gmail.com',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


--
-- Definition of table `user_image`
--

DROP TABLE IF EXISTS `user_image`;
CREATE TABLE `user_image` (
  `imgid` int(11) NOT NULL auto_increment,
  `userid` int(11) default NULL,
  `imagename` varchar(45) default NULL,
  `imageurl` varchar(200) default NULL,
  `imagetype` varchar(45) default NULL,
  `imagesize` varchar(45) default NULL,
  PRIMARY KEY  (`imgid`),
  KEY `FK_128x6cd6fqeellagu4loxkijh` (`userid`),
  CONSTRAINT `FK_128x6cd6fqeellagu4loxkijh` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_image`
--

/*!40000 ALTER TABLE `user_image` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_image` ENABLE KEYS */;


--
-- Definition of table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `roleid` int(11) NOT NULL auto_increment,
  `rolename` varchar(30) NOT NULL,
  PRIMARY KEY  (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_role`
--

/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`roleid`,`rolename`) VALUES 
 (1,'admin'),
 (2,'student'),
 (3,'teacher');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
