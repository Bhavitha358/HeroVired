import mysql.connector
mydb = mysql.connector.connect(host = 'localhost',user = 'root',password='Bhavi@mysql358')
print(mydb.connection_id)

#1.Create a database called “Inventory_Management” with different tables like “manufacture”, “goods”, “purchase”, “sale” etc.
#create table in command line client using create table INVENTORY_MANAGEMENT;

___________________________________________________________________________________________________________________________
#3.In the “manufacture” table, one should be able to see all the products that need to be manufactured, and defective items during the manufacture with different entries like manufacture id, number of items required, etc. 

import mysql.connector
mydb = mysql.connector.connect(host = 'localhost',user = 'root',password='Bhavi@mysql358',database = 'INVENTORY_MANAGEMENT')
cur=mydb.cursor()
my_cursor = 'create table MANUFACTURE(id INTEGER(20) PRIMARY KEY,product_name VARCHAR(20),color VARCHAR(20),quantity INTEGER(20),manufacturing_date DATE,defective_ITEM VARCHAR(20),company_name varchar(20))'
cur.execute(my_cursor)

___________________________________________________________________________________________________________________________
#4.In the “goods” table, it should include different items that are manufactured by the company along with the goods id, manufactured date, etc.
import mysql.connector
mydb = mysql.connector.connect(host = 'localhost',user = 'root',password='Bhavi@mysql358',database = 'INVENTORY_MANAGEMENT')
cur=mydb.cursor()
my_cursor = 'create table GOODS(id INTEGER(20),product_name varchar(20),color varchar(20),quantity INTEGER(20),manufacturing_date date)'
cur.execute(my_cursor)
print("Successfull")

___________________________________________________________________________________________________________________________
#5.In the “purchase” table, it should include all the purchase details that are purchased in different online and offline stores, along with the purchase id, purchase amount, etc.

import mysql.connector
mydb = mysql.connector.connect(host = 'localhost',user = 'root',password='Bhavi@mysql358',database = 'INVENTORY_MANAGEMENT')
cur=mydb.cursor()
my_cursor = 'create table PURCHASE(id INTEGER(20),store_name TEXT,product_name varchar(20),color VARCHAR(20),quantity INTEGER(20),purchase_amount INTEGER(20),purchase_date DATE)'
cur.execute(my_cursor)
print("Successfull")

___________________________________________________________________________________________________________________________
#6.In the “sale” table, it should include all the items got sold in different stores with the sale date, profit margin, etc
import mysql.connector
mydb = mysql.connector.connect(host = 'localhost',user = 'root',password='Bhavi@mysql358',database = 'INVENTORY_MANAGEMENT')
cur=mydb.cursor()
my_cursor = 'create table SALE(id INTEGER(10),store_name VARCHAR(10),product_name VARCHAR(20),color VARCHAR(10),no_of_items INTEGER(10),sale_amount REAL,sale_date DATE,profit_margin real)'
cur.execute(my_cursor)
print("Successfull")


___________________________________________________________________________________________________________________________
#inserting the values into MANUFACTURE,GOODS,PURCHASE,SALE tables.

import mysql.connector
mydb = mysql.connector.connect(host = 'localhost',user = 'root',password='Bhavi@mysql358',database = 'INVENTORY_MANAGEMENT')
cur=mydb.cursor()

insertion1 = 'insert into MANUFACTURE(id,product_name,color,quantity,manufacturing_date,defective_ITEM,company_name) values(%s,%s,%s,%s,%s,%s,%s)'
value1 = [(1, 'Toy Car', 'Red', 100, '01-05-23', 0,'TANISH'),(2, 'Toy Train', 'Green', 50, '01-05-23', 0,'SS Export'),(3, 'Wooden Chair', 'Brown', 200, '01-04-23', 0,'SS Export'),(4, 'Wooden Table', 'Brown', 100, '01-03-23', 0,'VGC')]
cur.executemany(insertion1,value1)
mydb.commit()

#inserting values into GOODS table.
insertion2 = 'insert into GOODS(id,product_name,color,quantity,manufacturing_date) values(%s,%s,%s,%s,%s)'
value2 = [(1, 'Toy Car', 'Red', 100, '01-05-23'),(2, 'Toy Train', 'Green', 50, '01-05-23'),(3, 'Wooden Chair', 'Brown', 200, '01-04-23'),(4, 'Wooden Table', 'Brown', 100, '01-03-23')]
cur.executemany(insertion2,value2)
mydb.commit()

#inserting values into PURCHASE table.
insertion3 = 'insert into PURCHASE(id,store_name,product_name,color,quantity,purchase_amount,purchase_date) values(%s,%s,%s,%s,%s,%s,%s)'
value3 = [(1, 'MyKids', 'Toy Car', 'Red', 50, 500, '01-05-23'),(2, 'MyKids', 'Toy Train', 'Green', 25, 250, '01-05-23'),(3, 'ORay', 'Shirt', 'Blue',10,200,'01-05-23')]
cur.executemany(insertion3,value3)
mydb.commit()

#inserting values into SALE table.
insertion4 = 'insert into SALE(id,store_name,product_name,color,no_of_items,sale_amount,sale_date,profit_margin) values(%s,%s,%s,%s,%s,%s,%s,%s)'
value4 = [(1, 'Offline store', 'Toy Car', 'Green', 100, 800, '2023-04-05',10),(2, 'Online store', 'Toy Train', 'Green', 100, 800, '2023-01-05',12.2),(3, 'Offlin store', 'Wooden Chair', 'Green', 100, 800, '2023-04-10',15.6),(4, 'Online store', 'Wooden Table', 'Green', 100, 800, '2023-03-15',13.65),(5, 'Offline store', 'Toy Train', 'Green', 100, 800, '2023-09-25',18.65)]
cur.executemany(insertion4,value4)
mydb.commit()


___________________________________________________________________________________________________________________________

#7.Delete the defective item, e.g., the shirt which was accidentally purchased by the “ORay” store, manufactured on the date ‘01-04-23’.
import mysql.connector
mydb = mysql.connector.connect(host = 'localhost',user = 'root',password='Bhavi@mysql358',database = 'INVENTORY_MANAGEMENT')
cur=mydb.cursor()
deletion ="DELETE FROM purchase WHERE product_name = 'shirt' AND purchase_date = '2001-05-23' AND store_name = 'ORay'"
cur.execute(deletion) 
print("Successfull")


___________________________________________________________________________________________________________________________
#8.Update the manufacture details of all the red-colored toys which are purchased by the “MyKids” store.
import mysql.connector
mydb = mysql.connector.connect(host = 'localhost',user = 'root',password='Bhavi@mysql358',database = 'INVENTORY_MANAGEMENT')
cur=mydb.cursor()
updatation ="UPDATE manufacture SET quantity = '35' WHERE color = 'Red'"
cur.execute(updatation)  
print("Successfull")


___________________________________________________________________________________________________________________________
#9.Display all the “wooden chair” items that were manufactured before the 1st May 2023. 
import mysql.connector
mydb = mysql.connector.connect(host = 'localhost',user = 'root',password='Bhavi@mysql358',database = 'INVENTORY_MANAGEMENT')
cur=mydb.cursor()
display ="SELECT *FROM goods WHERE manufacturing_date < '2001-05-23' AND product_name = 'wooden chair'"
cur.execute(display)  
print("Successfull")


___________________________________________________________________________________________________________________________
#10.Display the profit margin amount of the “wooden table” that was sold by the “MyCare” store, manufactured by the “SS Export” company.
import mysql.connector
mydb = mysql.connector.connect(host = 'localhost',user = 'root',password='Bhavi@mysql358',database = 'INVENTORY_MANAGEMENT')
cur=mydb.cursor()
margin ="SELECT profit_margin FROM sale WHERE product_name = 'wooden table' AND store_name = 'Mykids' AND id IN (SELECT id FROM manufacture WHERE company_name = 'SS Export')"
cur.execute(margin)
print("Successfull")
