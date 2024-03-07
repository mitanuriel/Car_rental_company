show databases;

use carRental;

create table if not exists Cars
(id int auto_increment primary key,
car_brand varchar(255),
car_model varchar(255),
fuel_type varchar(255),
registration datetime,
plate_number varchar(255),
mileage_counter int
);

show tables;
describe Cars; 

create table if not exists Customers
(id int auto_increment primary key,
full_name varchar(255),
address varchar(255),
city varchar(255),
postal_code int,
phone_number varchar(255),
license_number varchar(255),
license_issue_date datetime
);

show tables;

create table if not exists Rental
(id int auto_increment primary key,
rental_from datetime,
rental_to datetime,
total_km int,
customer_id int,
car_plate_number varchar(255),
foreign key(customer_id) references Customers(id),
foreign key(car_plate_number) references Cars(plate_number)
);

alter table Cars
add index car_indx (plate_number);

show tables;

insert into Cars (car_brand, car_model, fuel_type, registration, plate_number, mileage_counter)
values
  ('Toyota', 'Camry', 'Gasoline', '2022-01-01 10:00:00', 'ABC123', 50000),
  ('Honda', 'Civic', 'Hybrid', '2022-02-01 11:30:00', 'XYZ789', 35000),
  ('Ford', 'Mustang', 'Petrol', '2022-03-01 12:45:00', 'DEF456', 60000);
  
  insert into Customers (full_name, address, city, postal_code, phone_number, license_number, license_issue_date)
values
  ('John Doe', '123 Main St', 'Cityville', 12345, '555-1234', 'ABC789', '2020-01-15'),
  ('Jane Smith', '456 Oak St', 'Townsville', 54321, '555-5678', 'XYZ456', '2019-05-20'),
  ('Bob Johnson', '789 Pine St', 'Villagetown', 98765, '555-9876', 'DEF123', '2021-08-10');
  
  insert into Rental (rental_from, rental_to, total_km, customer_id, car_plate_number)
values
  ('2022-04-01 08:00:00', '2022-04-10 16:30:00', 500, 1, 'ABC123'),
  ('2022-05-15 09:30:00', '2022-05-25 18:15:00', 350, 2, 'XYZ789'),
  ('2022-06-20 11:00:00', '2022-06-30 20:45:00', 600, 3, 'DEF456');
  
  select * from Cars;
  select * from Customers;
  select * from Rental;
  
  
  
  



