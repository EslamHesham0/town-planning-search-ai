# Town Planning Search Algorithms

This project implements various search algorithms to solve town planning problems, where the goal is to reach a prosperity level of 100 or higher through strategic resource management and building construction.

## Features

The project implements the following search algorithms:
- **Breadth-First Search (BFS)**
- **Depth-First Search (DFS)**
- **Iterative Deepening Search (ID)**
- **Uniform Cost Search (UCS)**
- **Greedy Search with Heuristic 1 (GR1)**
- **Greedy Search with Heuristic 2 (GR2)**
- **A* Search with Heuristic 1 (AS1)**
- **A* Search with Heuristic 2 (AS2)**

## Test Cases

The following test cases represent different initial states for the town planning problem:

### Test Case 0
**Initial State:** `"17;49,30,46;7,57,6;7,1;20,2;29,2;350,10,9,8,28;408,8,12,13,34;"`

### Test Case 1
**Initial State:** `"50;12,12,12;50,60,70;30,2;19,2;15,2;300,5,7,3,20;500,8,6,3,40;"`

### Test Case 2
**Initial State:** `"30;30,25,19;90,120,150;9,2;13,1;11,1;3195,11,12,10,34;691,7,8,6,15;"`

### Test Case 3
**Initial State:** `"0;19,35,40;27,84,200;15,2;37,1;19,2;569,11,20,3,50;115,5,8,21,38;"`

### Test Case 4
**Initial State:** `"21;15,19,13;50,50,50;12,2;16,2;9,2;3076,15,26,28,40;5015,25,15,15,38;"`

### Test Case 5
**Initial State:** `"72;36,13,35;75,96,62;20,2;5,2;33,2;30013,7,6,3,36;40050,5,10,14,44;"`

### Test Case 6
**Initial State:** `"29;14,9,26;650,400,710;20,2;29,2;38,1;8255,8,7,9,36;30670,12,12,11,36;"`

### Test Case 7
**Initial State:** `"1;6,10,7;2,1,66;34,2;22,1;14,2;1500,5,9,9,26;168,13,13,14,46;"`

### Test Case 8
**Initial State:** `"93;46,42,46;5,32,24;13,2;24,1;20,1;155,7,5,10,7;5,5,5,4,4;"`

### Test Case 9
**Initial State:** `"50;20,16,11;76,14,14;7,1;7,1;7,1;359,14,25,23,39;524,18,17,17,38;"`

### Test Case 10
**Initial State:** `"32;20,16,11;76,14,14;9,1;9,2;9,1;358,14,25,23,39;5024,20,17,17,38;"`

## State Format

Each initial state string follows this format:
```
prosperity;food,materials,energy;foodCost,materialsCost,energyCost;building1(cost,delay);building2(cost,delay);building3(cost,delay);request1(cost,food,materials,energy,prosperity);request2(cost,food,materials,energy,prosperity);
```

Where:
- **prosperity**: Current prosperity level (goal is to reach 100+)
- **food,materials,energy**: Current resource amounts
- **foodCost,materialsCost,energyCost**: Cost to request each resource type
- **building(cost,delay)**: Cost and delay for each building type
- **request(cost,food,materials,energy,prosperity)**: Cost and resource/prosperity gains for each request type

## Usage

### Basic Usage

1. Compile the Java files:
   ```bash
   javac src/*.java
   ```

2. Run with GenericSearch (uses default BFS):
   ```bash
   java -cp src GenericSearch
   ```

3. Use LLAPSearch for specific algorithms:
   ```bash
   java -cp src LLAPSearch
   ```

### Available Search Strategies

The `LLAPSearch.solve()` method supports the following search strategies:

- **"BF"** - Breadth-First Search
- **"DF"** - Depth-First Search  
- **"ID"** - Iterative Deepening Search
- **"UC"** - Uniform Cost Search
- **"GR1"** - Greedy Search with Heuristic 1
- **"GR2"** - Greedy Search with Heuristic 2
- **"AS1"** - A* Search with Heuristic 1
- **"AS2"** - A* Search with Heuristic 2

### Example Usage in Code

```java
// Example: Solve Test Case 0 with Breadth-First Search
String initialState0 = "17;49,30,46;7,57,6;7,1;20,2;29,2;350,10,9,8,28;408,8,12,13,34;";
String solution = LLAPSearch.solve(initialState0, "BF", false);
solution = solution.replace(" ", "");

// Validate the solution (if you have the plan checker)
LLAPPlanChecker pc = new LLAPPlanChecker(initialState0);
boolean isValid = pc.applyPlan(initialState0, solution);
System.out.println("Solution valid: " + isValid);
```

### Testing Different Strategies

```java
// Test all strategies on the same initial state
String initialState = "21;15,19,13;50,50,50;12,2;16,2;9,2;3076,15,26,28,40;5015,25,15,15,38;";

// Breadth-First Search
String bfsSolution = LLAPSearch.solve(initialState, "BF", false);

// Depth-First Search  
String dfsSolution = LLAPSearch.solve(initialState, "DF", false);

// Iterative Deepening
String idSolution = LLAPSearch.solve(initialState, "ID", false);

// Uniform Cost Search
String ucsSolution = LLAPSearch.solve(initialState, "UC", false);

// Greedy Search (Heuristic 1)
String gr1Solution = LLAPSearch.solve(initialState, "GR1", false);

// Greedy Search (Heuristic 2)  
String gr2Solution = LLAPSearch.solve(initialState, "GR2", false);

// A* Search (Heuristic 1)
String as1Solution = LLAPSearch.solve(initialState, "AS1", false);

// A* Search (Heuristic 2)
String as2Solution = LLAPSearch.solve(initialState, "AS2", false);
```

### Visualization

Set the third parameter to `true` to enable visualization:

```java
// Enable visualization to see the path taken
String solution = LLAPSearch.solve(initialState, "BF", true);
```

When visualization is enabled, the program will print the town status at each step of the solution path.

## Goal

The objective is to find a sequence of actions that brings the town's prosperity to 100 or higher while managing resources efficiently.

## Performance

The algorithms are optimized for performance with various data structure improvements and efficient state management to handle complex search spaces within reasonable time limits.
