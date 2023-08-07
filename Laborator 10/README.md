# Laborator 10

## Networking - Gomoku Implementation

Develop an implementation of Gomoku (Five in a Row) that enables remote players to initiate or join games. The application consists of two parts (create a project for each):

1. The server is responsible for game management and mediating players.
2. The client communicates with the server, sending commands such as creating or joining games, submitting moves, etc.

## Main Specifications

### Compulsory (1p)

**ServerApplication Project:**

- Create the `ServerApplication` project. It will include at least the classes `GameServer` and `ClientThread`.
- Design the `GameServer` class. An instance of this class will create a `ServerSocket` running at a specific port. The server will receive requests (commands) from clients and execute them.
- Implement the `ClientThread` class. An instance of this class will handle communication with a client `Socket`. If the server receives the `stop` command, it will stop and return the response "Server stopped". Otherwise, it will return "Server received the request ...".

**ClientApplication Project:**

- Establish the `ClientApplication` project, containing at least the `GameClient` class.
- Develop the `GameClient` class. An instance of this class will read commands from the keyboard and send them to the server. The client will stop when it reads the string "exit" from the keyboard.

### Optional (2p)

- Implement game functionalities using classes like `Game`, `Board`, `Player`, etc.
- Clients will send commands to the server, including creating a game, joining a game, submitting a move, etc.
- The server will manage games and mediate players.
- Implement games played under time control (blitz) where each player starts with the same amount of time. If a player's time runs out, the game is lost.

---
