# Laborator 6

## Graphical User Interfaces (Swing, JavaFX)

Consider a positional game played on a board containing dots placed on a circle. Some dots are connected to other dots using lines. Initially, the existing lines are gray (not colored). Two players take turns coloring uncolored lines. One player uses red, and the other uses blue.

### Variants

- Variant 1: Each player tries to create a triangle solely of their color. The player who succeeds wins the game.
- Variant 2: Each player tries to avoid creating a triangle solely of their color. The player who cannot avoid creating such a triangle loses the game.

## Main Specifications

### Compulsory (1p)

- Create the following components:
  - The main frame of the application.
  - A configuration panel for introducing parameters regarding the number of dots and lines and a button for creating a new game. Place this panel at the top part of the frame. Include at least one label and one input component.
  - A canvas (drawing panel) for drawing the board. Draw dots and lines according to the values specified in the config panel. Place this panel in the center part of the frame.
  - A control panel for managing the game. This panel will contain buttons such as Load, Save, Exit, etc. Place it at the bottom part of the frame.

### Implementation

- You may choose either Swing or JavaFX for creating the graphical user interface for the game.
- Implement the game logic for both variants.
- Display the board, dots, lines, and player moves appropriately in the graphical interface.

---

 
