#Question-1 :-
'''------------
Description - Create a small command-line program in Python to calculate the total invoice amount for the below purchases - 
Book - Introduction to Python Programming : Rs 499.00
Book - Python Libraries Cookbook : Rs. 855.00
Book - Data Science in Python : Rs. 645.00
Taxes and additional charges are described as details - 
GST : 12%
Delivery Charges : Rs. 250.00
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------'''
#Code:
#Step-1: Asking the user to enter the number of books he/she would like to buy
no_of_books1 = int(input("How many books of Introduction to Python Programming do you want? "))
no_of_books2 = int(input("How many books of Python Libraries Cookbook do you want? "))
no_of_books3 = int(input("How many books of Data Science in Python do you want? "))

#Step-2: Calculating the total amount of books
Total = (no_of_books1 * 499.00) + (no_of_books2 * 855.00) + (no_of_books3 * 645.00)

#Step-3: Adding the total amount with 12% GST and delivery charges 
if(Total != 0) :
    Final_total = Total + (0.12 * Total) + 250.00
else:
    Final_total = 0.00

#Step-4: Printing the final total as an output
print(Final_total) 
__________________________________________________________________________________________________________________________________________________________________________________

#Question-2 :-
'''-------------
Description: Write a program in Python to print the number of unique letters in a string. Only new letters from the string should be counted and not duplicates.
Input : string1 = "India"
Output : uniqueLetters = i,n,d,a
Input : string1 = "Dedication"
Output : uniqueLetters = d,e,i,c,a,t,o,n
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------'''
#Code:
#Step-1: Asking the user to enter the string as an input.
input_string = input("Enter any string: ")

#Step-2: Convert the input string into lowercase.
conv_string = input_string.lower() 

#Step-3: Taking an empty list which is used to store the unique letters in a string.
List = []
#Step-4: Using a for loop to append the unique letters in the string into an empty list.
for i in range(len(conv_string)):
    if conv_string[i] not in List :
        List.append(conv_string[i])

#Step-5: Printing the elements of the above list one by one seperated by comma ','
output = ','.join(List)
print(output)
'''-------------------------------------------------------------------------------------------------------------------------------------------------------------------------'''
