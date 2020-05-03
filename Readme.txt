Fruit Ninja
A game where user slices fruits and tries to beat their highscore.
Assumptions made:
	The user quits from inside the game itself.
	If the user does not quit from the game itself, problems could occur.
	An attempt to fix this problem was made by using a thread that works before closing but it does not seem to be working inside the GameScreenController to stop the animation.
	The user runs the game from an executable jar file inside the program file.
	After failing to create a runnable jar file that works outside the program file, it was decided that the user should run the game from inside the program file from the executable jar file for the game to work correctly.
Division of labour:
	Heba El-Wazzan 6521: Splash Screen, Object animation, UML Diagrams, File Handling.

	Omar Aboshousha 6492: Main Menu screen, Game screen, Game over screen, Pause menu.

	John Hany Kamal 6441: User Manager screen, Help menu, Leaderboard screen, Media Player.
Notes:
* We did not strictly implement the methods in the given interfaces in their children, but all functionality was otherwise 
  implemented through other classes.

* We were not able to set the game into fullscreen mode due to the background image not being resized. We could not use css style
  sheets to set the background as eclipse had a problem with the paths inside the css style sheets and we could not figure out 
  how to solve it unfortunately.

* There is a bug that occasionally occurs when the Game Over screen appears. It seems that it does not close original game screen
  so if you play again there ends up being two game screens playing and a game over message appears. The problem occurs once
  every couple of games and we have tried our best to limit its occurence.

* The images on the "New user" button and the "Level two" title could not be loaded in the executable jar file for unknown resons,
  however the button still works fine.