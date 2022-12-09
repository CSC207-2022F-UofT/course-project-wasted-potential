# Maze game

Our program is a platform for users to design and play mazes made by other users. Our design toolkit allows designers to build their own / randomly and verify the solvability of their mazes before publishing. Players can view all published mazes and choose which one they would like to play.


## Feature overview

#### General features
- User registration
- User login

#### Designer flow
- Manually designing mazes 
- Randomly generating mazes
- Maze solvability verification
- Publishing mazes

#### Player flow
- Playing mazes
- Generating hints


## How to Design Mazes
1. Login or register as a designer 
2. Use the 'build' and 'destroy' buttons to place and destroy walls respectively
3. Use the 'start' and 'end' buttons to move the start and end locations of your maze
3. Use the 'random' button to randomly generate a maze layout
4. Use the 'reset' button to reset your design 
5. Use the text input in the top left to edit your maze's name
6. Make sure your maze is solvable by refering to the solvability indicator in the bottom left corner 
7. Publish your maze by clicking the 'publish' button
8. That's it! 

## How to Play
1. Login or register as a player
2. In the home menu, click on a button for a maze you would like to play
3. Use the 'WASD' keys to move around and navigate the maze
4. Use the 'hint' button to get hints
5. Use the 'quit' button to return to the home menu
6. Have fun! 

## Screenshots

#### Maze designing interface

![image](https://user-images.githubusercontent.com/25446747/206626057-b2085380-526d-4a23-84e6-4c125e09d0dd.png)

#### Maze playing interface 
*Note: The yellow path is a hint

![image](https://user-images.githubusercontent.com/44539091/206628813-de52cb9c-e231-494d-b46e-da5383521140.png)


## Tools and libraries

- Gradle build automation tool
- GUI was built using JavaFX
- JavaDoc for generating documentation
- JUnit for testing

## Running the project locally

1. Clone the repository

```
git clone https://github.com/CSC207-2022F-UofT/course-project-wasted-potential 
```

2. Open the project in IntelliJ using

```
gradle run
```

## View JavaDoc

Open the project in IntelliJ and click `Tools > Generate JavaDoc`.

## Running tests

Right click `src/test` in IntellJ and click `Run Tests`.
