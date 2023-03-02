# Name: Patel Rajkumar Pankajbhai
# Date: 23/02/2023
# Roll No: AM.EN.U4CSE20349

import rpyc 
import sys 
if len(sys.argv) < 2: 
    exit("Usage {} SERVER".format(sys.argv[0])) 
server = sys.argv[1] 
conn = rpyc.classic.connect(server)
conn.execute("num = int(input('Enter the number: '))")
conn.execute("def fibonacci(num):\n    if num <= 1:\n        return num\n    else:\n        return fibonacci(num-1) + fibonacci(num-2)")

result = conn.eval("fibonacci(num)")
conn.execute("name ='Name: Patel Rajkumar Pankajbhai'")
conn.execute("rollno ='Rollno: AM.EN.U4CSE20349'")
print(result)
print(conn.eval("name"))
print(conn.eval("rollno"))

