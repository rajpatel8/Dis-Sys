# include </Users/aj/v.h>
//#include <bits/stdc++.h>
#include <netinet/in.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <unistd.h>
#define PORT 8080

using namespace std;

// Author: Patel Rajkumar Pankajbhai
// Roll No: AM.EN.U4CSE20349
// Code: Socket Programming 
// Date: 09-02-2023
// Course: Distributed System 

int main(int argc, char const *argv[])
{
    // client socket

    int sock = socket(AF_INET, SOCK_STREAM, 0);
    if (sock < 0)
    {
        cout << "Socket creation failed" << endl;
        return 0;
    }
    cout << "Socket created" << endl;

    // Socket address
    struct sockaddr_in addr; // sockaddr_in is a structure that contains an internet address
    addr.sin_family = AF_INET;  // Address family
    addr.sin_port = htons(8080); // Port number
    addr.sin_addr.s_addr = INADDR_ANY ; // IP address

    // Connect
    if (connect(sock, (struct sockaddr *)&addr, sizeof(addr)) < 0)
    {
        cout << "Connection failed" << endl;
        return 0;
    }
    cout << "Connection successful" << endl;

    // Write
    char *hello = "Hello from client";
    send(sock, hello, strlen(hello), 0);
    cout << "Hello message sent" << endl;

    // Read
    char buffer[1024] = {0};
    int valread = read(sock, buffer, 1024);
    cout << buffer << endl;

    // Close
    close(sock);
    
    return 0;
}
