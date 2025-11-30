# GuessMaster Game

**GuessMaster** is an interactive console game where the user tries to guess the birthday of a person (celebrity, historical figure, or fictional character). 

---

## ✨ Overview

The game mechanics are as follows:

1. **Greeting & Introduction**
   - The player is welcomed and informed of whose birthday they are guessing.
   - Three preset people are available, and the game cycles through them.

2. **User Input**
   - The user types guesses in the format `DD/MM/YYYY`.  
     - Example: `21/08/1986`  
   - Optionally, different date formats can be supported internally.  
   - Entering `quit` exits the game immediately.

3. **Feedback Loop**
   - If the guess is **incorrect**:
     - `"Incorrect. Try an earlier date."`  
       (guess > actual birthday)
     - `"Incorrect. Try a later date."`  
       (guess < actual birthday)
   - If the guess is **correct**:
     - `"CORRECT. You got it!!"`  
     - The game moves to the next person.

4. **Game Continuation**
   - After guessing correctly, the player proceeds to the next preset person.  
   - Game continues until all three birthdays are guessed or the user types `quit`.

---

## How to Run

Compile the program:

```bash
g++ -std=c++11 GuessMaster.cpp -o GuessMaster
./GuessMaster
```
