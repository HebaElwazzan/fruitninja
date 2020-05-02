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