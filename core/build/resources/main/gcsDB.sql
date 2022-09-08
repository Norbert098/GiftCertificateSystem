create table gift_certificate(
id bigserial primary key,
name varchar(255),
description varchar(255),
price numeric,
duration int,
create_date timestamp,
last_update_date timestamp
);

create table tag (
id bigserial primary key,
name varchar(255)
);

create table gift_certificate_tag(
id bigserial primary key,
gift_certificate_id bigint,
tag_id bigint,

CONSTRAINT fk_gift_certificate
	FOREIGN KEY(gift_certificate_id)
		REFERENCES gift_certificate(id),
CONSTRAINT fk_tag
	FOREIGN KEY(tag_id)
		REFERENCES tag(id)
);
