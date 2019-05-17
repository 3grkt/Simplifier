 
INSERT INTO credentials(username,password,enabled, verifyPassword) VALUES ('guest','guest', TRUE, 'guest');
INSERT INTO credentials(username,password,enabled, verifyPassword) VALUES ('admin','$2a$10$U1adWet9rNw49v5ktENubefe1q9SIoJQGWXw7nJhUry.mEXKTfkO2', TRUE, 'admin');
INSERT INTO credentials(username,password,enabled, verifyPassword) VALUES ('user','$2a$10$aT1JfAa/5TtoMwknYsrLn.DJ3.xvQLbimloKxgTP8auWE5LdZ/WI.', TRUE, 'user');
 
INSERT INTO authority (authority) VALUES ('ROLE_SUPERVISOR');
INSERT INTO authority (authority) VALUES ('ROLE_ADMIN');
INSERT INTO authority (authority) VALUES ('ROLE_USER');
INSERT INTO authority (authority) VALUES ('ROLE_GUEST');


INSERT INTO  `MEMBER` (firstname, lastname,age,title,membernumber, member_id) VALUES ('Curious','George',12,'Boy Monkey', 8754,'admin');
INSERT INTO `MEMBER` (firstname, lastname,age,title,membernumber,member_id) VALUES ('Allen','Rench',123,'Torque Master', 8733,'guest');
INSERT INTO `MEMBER` (firstname, lastname,age,title,membernumber,member_id) VALUES ('Huy','Nguyen',123,'User Booking', 8733,'user');

INSERT INTO groups (group_name) VALUES ('SUPERVISOR');
INSERT INTO groups (group_name) VALUES ('ADMIN');
INSERT INTO groups (group_name) VALUES ('MEMBER');
INSERT INTO groups (group_name) VALUES ('GUEST');

INSERT INTO groups_credentials (groups_id, userCredentials_username) VALUES (1, 'admin');
INSERT INTO groups_credentials (groups_id, userCredentials_username) VALUES (3, 'user');	

INSERT INTO groups_authority (groups_id, authority_id) VALUES (1, 1);	
INSERT INTO groups_authority (groups_id, authority_id) VALUES (2, 2);	
INSERT INTO groups_authority (groups_id, authority_id) VALUES (3, 3);	
INSERT INTO groups_authority (groups_id, authority_id) VALUES (4, 4);	

INSERT INTO roomtype (description, price) VALUES ('King Room', 300);
INSERT INTO roomtype (description, price) VALUES ('Deluxe Room', 350);

INSERT INTO booking (bookingDate, checkinDate, checkoutDate, agent_id, user_id, bookingStatus) VALUES (STR_TO_DATE('1-01-2017', '%d-%m-%Y'), STR_TO_DATE('3-01-2017', '%d-%m-%Y'), STR_TO_DATE('5-01-2017', '%d-%m-%Y'), 1, 2, 1);
INSERT INTO booking (bookingDate, checkinDate, checkoutDate, agent_id, user_id, bookingStatus) VALUES (STR_TO_DATE('2-01-2017', '%d-%m-%Y'), STR_TO_DATE('4-01-2017', '%d-%m-%Y'), STR_TO_DATE('6-01-2017', '%d-%m-%Y'), 1, 2, 1);
INSERT INTO booking (bookingDate, checkinDate, checkoutDate, agent_id, user_id, bookingStatus) VALUES (STR_TO_DATE('12-01-2017', '%d-%m-%Y'), STR_TO_DATE('14-01-2017', '%d-%m-%Y'), STR_TO_DATE('16-01-2017', '%d-%m-%Y'), 1, 2, 2);


INSERT INTO room (capacity, description, numBed, price, roomNumber, book_id, typeId, available) VALUES (2, "King Room", 1, 300, 101,1,1, true);	
INSERT INTO room (capacity, description, numBed, price, roomNumber, book_id, typeId, available) VALUES (4, "Deluxe Room", 2, 350, 102,1,2, true);
INSERT INTO room (capacity, description, numBed, price, roomNumber, book_id, typeId, available) VALUES (3, "Standard Room", 3, 250, 203,null,2, true);
