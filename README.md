# 2-Player Pong (Football Edition)

A real-time, two-player Pong-style game built in **Java** with **JavaFX**, themed as a football pitch. Two players face off on the same keyboard, each controlling a paddle to keep the ball out of their goal. Built as a practice project to explore JavaFX rendering, animation loops, and object-oriented game design.

## Features

- **Local two-player** gameplay on a single keyboard
- **Real-time rendering** on a JavaFX `Canvas` driven by a `Timeline` game loop
- **Ball physics & collision detection** — the ball bounces off paddles and top/bottom walls
- **Dynamic difficulty** — the ball speeds up each time it hits a paddle and slows down when it bounces off a wall
- **Randomized rebounds** — vertical direction is randomized on paddle hits to keep rallies unpredictable
- **Live score tracking** displayed at the top of the pitch

## Controls

| Action | Player 1 (left) | Player 2 (right) |
|--------|-----------------|------------------|
| Move up | `W` | `↑` (Up arrow) |
| Move down | `S` | `↓` (Down arrow) |

Click anywhere on the window to start / serve the ball.

## Gameplay

- The ball serves in a random direction when you click.
- Hitting the ball with your paddle increases its speed; hitting a wall reduces it slightly.
- If the ball passes a paddle and reaches the goal wall, the opponent scores and the ball resets to the center.

## Tech Stack

- **Language:** Java
- **UI / Graphics:** JavaFX (`Canvas`, `GraphicsContext`, `Timeline`, `Scene`, `Stage`)

## Project Structure

```
src/application/
├── Main.java     # Entry point, game loop, input routing, scoring/serve logic
├── Field.java    # Draws the pitch (boundaries, center line, center circle)
├── Player.java   # Paddle: position, movement, key handling, rendering
└── Ball.java     # Ball: movement, wall collisions, speed, score reset
```

Image assets (`field.png`, `icon.png`, `icon2.png`) are loaded from the classpath and should sit on the resource path (e.g. alongside the compiled classes or in the project's resource folder).

## Requirements

- **JDK 11+**
- **JavaFX SDK** (bundled with the JDK for Java 8; a separate download for Java 11+)

## Running the Game

### From an IDE (Eclipse / IntelliJ)

1. Import the project.
2. Add the JavaFX SDK libraries to the build path / module path.
3. Run `application.Main`.

### From the command line (Java 11+ with JavaFX SDK)

```bash
# Compile
javac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls \
      -d bin src/application/*.java

# Run
java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls \
     -cp bin application.Main
```

Replace `/path/to/javafx-sdk/lib` with the location of your JavaFX SDK, and make sure the image assets are reachable on the classpath.

## Possible Improvements

- Win condition / match point and a game-over screen
- Pause and restart controls
- Sound effects on hits and scoring
- Configurable ball speed and paddle size

## License

Free to use for learning purposes. Add a license file (e.g. MIT) if you plan to share or reuse it.
