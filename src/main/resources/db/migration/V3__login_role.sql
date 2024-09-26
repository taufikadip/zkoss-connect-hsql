INSERT INTO PERSON VALUES(50,'2024-09-03 00:00:00.000000','Indonesia','Fulltime','Male','BBBBB')
INSERT INTO PERSON VALUES(51,'2024-09-04 00:00:00.000000','Indonesia','Part-time','Male','Kapt kepin')
INSERT INTO PERSON VALUES(52,'2024-09-03 00:00:00.000000','USA','Fulltime','Male','Dari Form')
INSERT INTO PERSON VALUES(53,'2024-09-04 00:00:00.000000','USA','Fulltime','Male','Baru 2')

INSERT INTO Role VALUES (1, 'ROLE_ADMIN')
INSERT INTO Role VALUES (2, 'ROLE_USER')

INSERT INTO PersonLogin (id, username, password) VALUES (1, 'admin', '$2a$10$x2DF9HSnr3ZQyt2GYMLbJeKmhxfRkKd3Qr63k3tW5icxL1DuTwtqC');
INSERT INTO PersonLogin (id, username, password) VALUES (2, 'user', '$2a$10$FAf.R1GIRaAiTbIHgd98k.RZ3g397g1I/63ACjqMoGES/MkrIRRre');

INSERT INTO person_roles (person_id, role_id) VALUES (1, 1);
INSERT INTO person_roles (person_id, role_id) VALUES (2, 2);



