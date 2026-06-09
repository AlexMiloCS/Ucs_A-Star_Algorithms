# Pathfinding Algorithms: A* and Uniform Cost Search (UCS)

A complete, Java-based console application that visualizes and compares pathfinding algorithms on a randomized grid. The project generates a labyrinth with varying terrain heights and obstacles, then finds the optimal cost-effective path from a starting position to one of two potential goals using Uniform Cost Search (UCS) and A* (A-Star).

---

## Table of Contents
1. [Features](#-features)
2. [Algorithms Explained](#-algorithms-explained)
3. [Getting Started](#-getting-started)
4. [Usage & Example](#-usage--example)
5. [Project Structure & Source Code](#-project-structure--source-code)

---

## Features
- **Randomized Labyrinth Generation:** Creates a grid of customizable size with random obstacles (blocked cells) and terrain heights (values 1-4).
- **Dynamic Movement Costs:** Moving between cells incurs a cost based on height differences and whether the movement is straight or diagonal.
- **Multiple Goals:** Supports calculating the optimal path to either Goal 1 (G1) or Goal 2 (G2), whichever is cheaper.
- **Algorithm Comparison:** Runs both UCS and A* sequentially to allow for comparison of node expansion and execution efficiency.

---

## Algorithms Explained
- **Uniform Cost Search (UCS):** Explores paths iteratively by choosing the node with the lowest path cost from the start ($g(n)$). It guarantees the optimal (shortest) path but expands equally in all directions, making it slower.
- **A* Search Algorithm:** Combines the actual cost from the start ($g(n)$) with an estimated cost to the goal ($h(n)$). This evaluation function $f(n) = g(n) + h(n)$ directs the search towards the goals, resulting in a highly optimized execution that expands far fewer nodes while still guaranteeing an optimal path.

---

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher installed on your machine.

### Compilation
Open your terminal, navigate to the project directory, and compile all Java files:
```bash
javac *.java
