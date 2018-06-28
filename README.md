# Group-Chat-Application
It's a Desktop Application that allows group chat in a Client-Server Network.

This project is made using java, more specifically, Swing, Socket Programming and Multithreading.

## How does this project works ?

1. Server code is started first and then multiple clients can run their code.

2. On Server side, as soon as a client request arrives, it assigns one thread acting as a server thread for only that single client, thus one to one relationship between server thread and client comes into picture which exists till client signs out from the group chat.

3. Server also assigns separate socket, data input and output streams to all server threads.

4. An ArrayList is maintained which consists of all the active server threads, used to broadcast messages to all online users. 

5. On Client side, there is a requirement of 2 separate threads for reading and writing (sending) messages as both processes can't be completed using a single thread.

6. As soon as a client signs out (closes the window), its corresponding server thread is removed from the ArrayList and all the active streams and socket of client and corresponding server thread are closed, also all respective threads stops.

## Example

1. First JFrame which appears after running the project:

![first_page](https://user-images.githubusercontent.com/32769719/42042950-e3cc619e-7b12-11e8-99a2-b73b91193628.JPG)

2. A group chat between friends (appears after signining in through first JFrame) :

![jay](https://user-images.githubusercontent.com/32769719/42042962-e83a93f4-7b12-11e8-90c6-d23bf3da8670.JPG)

![akshay](https://user-images.githubusercontent.com/32769719/42042995-fd0fb2dc-7b12-11e8-9660-84bc74504aa0.JPG)

![viral](https://user-images.githubusercontent.com/32769719/42043003-020679c4-7b13-11e8-9567-42c8676d08f5.JPG)
