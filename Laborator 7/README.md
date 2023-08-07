# Laborator 7

## Concurrency

Consider a map represented as an n x n square matrix, where each cell is an individual location on the map. Robots (agents) must explore all the matrix cells. Initially, robots are located at random positions and can move in any direction within the map. No two robots can occupy the same cell simultaneously. Robots can access a shared memory containing tokens (for example, shuffled numbers from 1 to n^3). When a robot reaches an unvisited cell, it must extract n tokens and store them in the matrix cell. A supervisor can start/pause robots collectively or individually.

## Main Specifications

### Compulsory (1p)

- Create an object-oriented model of the problem.
- Each robot will have a name and must concurrently move randomly around the map, extracting tokens from shared memory upon reaching an unvisited cell.
- Display a message on the screen each time a robot visits a new cell.
- Simulate exploration using a thread for each robot.
- Ensure proper synchronization of threads while extracting tokens and visiting cells.

### Implementation

- Develop the logic for robot movement, token extraction, and cell visiting.
- Utilize proper synchronization mechanisms to prevent race conditions and ensure thread safety.
- Display messages and robot actions clearly in the application's interface.

---

 
