#include </Users/aj/v.h> 
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
    // Socket creation
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

    // Bind
    if (bind(sock, (struct sockaddr *)&addr, sizeof(addr)) < 0)
    {
        cout << "Bind failed" << endl;
        return 0;
    }
    cout << "Bind successful" << endl;

    // Listen
    if (listen(sock, 3) < 0) // 
    {
        cout << "Listen failed" << endl;
        return 0;
    }
    cout << "Listening..." << endl;

    // Accept
    int new_socket = accept(sock, (struct sockaddr *)&addr, (socklen_t *)&addr);
    if (new_socket < 0)
    {
        cout << "Accept failed" << endl;
        return 0;
    }
    cout << "Accept successful" << endl;

    // Read
    char buffer[1024] = {0};
    int valread = read(new_socket, buffer, 1024);
    cout << buffer << endl;

    // Write
    char *hello = "Hello from server";
    send(new_socket, hello, strlen(hello), 0);
    cout << "Hello message sent" << endl;

    // Close
    close(sock);
    return 0;

    
}
