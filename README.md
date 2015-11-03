# number-guessing-game
A simple number guessing game

# Note
The game works as follows:

The user chooses a number in his mind and types “ready” to indicate to the computer that he is ready to begin playing.
The computer asks a series of questions to arrive at the number the user has in mind. The user can only respond with “high”, “low” or “yes”.The game ends when the user responds with “yes”

# Example:

User chooses number 40 in his mind.

Computer: Is the number 30?
User: high

Computer: Is the number 50?
User: low

Computer: Is the number 35?
User: high

Computer: Is the number 40?
User: yes

# How to Run

1. Make sure that you have JAVA and MAVEN Install
2. Using CMD, go to root of project i.e pom.xml 
3. mvn -q clean package spring-boot:run
