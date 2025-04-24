BEGIN TRANSACTION;

CREATE TABLE IF NOT EXISTS `students` (
	`id`	INTEGER NOT NULL,
	`name`	TEXT NOT NULL UNIQUE,
	`surname`	TEXT NOT NULL,
	`year`	INTEGER NOT NULL,
	`course` 	TEXT NOT NULL,
	`marks` SET,
	PRIMARY KEY(`id`)
);

COMMIT;