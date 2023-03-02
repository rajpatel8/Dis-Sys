# Name: Patel Rajkumar Pankajbhai
# Date: 23/02/2023
# Roll No: AM.EN.U4CSE20349

import socket

def main():
    # create a socket object
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    # get local machine name
    host = socket.gethostname()
    port = 9999
    # connection to hostname on the port.
    s.connect((host, port))
    # Continous send and recieve data
    while True:
        # Receive no more than 1024 bytes
        msg = s.recv(1024)
        print(msg.decode('ascii'))
        # Send data to server
        s.send(input("Enter message: ").encode('ascii'))
    # Close the connection
    s.close()

if __name__ == '__main__':
    print("\nName : Patel Rajkumar Pankajbhai")
    print("Roll No : AM.EN.U4CSE20349\n")
    main()