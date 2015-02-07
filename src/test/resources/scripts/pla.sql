DROP TABLE IF EXISTS `security_permission`;
CREATE TABLE `security_permission` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `permission_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_qq00m1swwhgg4ef2u4r7u3rh3` (`permission_id`)
) ;
INSERT INTO security_permission (ID, DESCRIPTION, PERMISSION_ID ) VALUES (3,'ROLE_ADMIN','ROLE_ADMIN' );
