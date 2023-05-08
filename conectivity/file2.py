import mysql.connector
mydb = mysql.connector.connect(host = 'Bhavitha_new_connection',user = 'root',password='Bhavi@mysql358',database = 'Bhavitha')
cur=mydb.cursor()
my_cursor = 'create table MANUFACTURE(id INTEGER(20) PRIMARY KEY,product_name VARCHAR(20),color VARCHAR(20),quantity INTEGER(20),manufacturing_date DATE,defective_ITEM VARCHAR(20),company_name varchar(20))'
cur.execute(my_cursor)
print("Success")