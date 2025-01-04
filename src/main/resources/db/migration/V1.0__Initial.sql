CREATE TABLE ms_file_maintenance.tbl_scan (
	id bigserial NOT NULL,
	path varchar NULL,
	folder varchar NULL,
	file_name varchar NULL,
	duplicate varchar(1) NULL,
	duplicate_with varchar NULL,
	created_on timestamp NULL,
	updated_on timestamp NULL
);

CREATE TABLE ms_file_maintenance.tbl_scan_delete (
	id bigserial NOT NULL,
	path varchar NULL,
	deleted varchar(1) NULL,
	created_on timestamp NULL,
	updated_on timestamp NULL
);
