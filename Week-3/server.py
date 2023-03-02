# Name: Patel Rajkumar Pankajbhai
# Date: 23/02/2023
# Roll No: AM.EN.U4CSE20349

# server for fibonaci

import socket
import sys
import time

def fib(n):
    if n == 0:
        return 0
    elif n == 1:
        return 1
    else:
        return fib(n-1) + fib(n-2)
    
def main():
    # create a socket object
    serversocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    # get local machine name
    host = socket.gethostname()
    port = 9999
    # bind to the port
    serversocket.bind((host, port))
    # queue up to 5 requests
    serversocket.listen(5)
    while True:
        # establish a connection
        clientsocket,addr = serversocket.accept()
        print("Got a connection from %s" % str(addr))
        msg = 'Thank you for connecting'+ "\r\n"
        clientsocket.send(msg.encode('ascii'))
        while True:
            data = clientsocket.recv(1024)
            if not data: break
            print("Received %s" % data)
            n = int(data)
            result = fib(n)
            print("Sending %s" % result)
            clientsocket.send(str(result).encode('ascii'))
        clientsocket.close()

if __name__ == "__main__":
    print("\nName : Patel Rajkumar Pankajbhai")
    print("Roll No : AM.EN.U4CSE20349\n")
    main()