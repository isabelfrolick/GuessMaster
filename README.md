# BirthdayGuesser Game

This repository contains BirthdayGuesser, a console-based game where users guess the birthdays of people. Each version adds features and complexity beyond the previous one.

---

## 1️Simple Version (`simple/`)

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

## 2️Extended Version (`extended/`)

Building upon the basic version, this iteration adds:

- **Random selection** of the person to guess from an array of stored people.
- **Granular feedback** on incorrect guesses:
  - `"Incorrect. Try an earlier day."`  
  - `"Incorrect. Try a later month."`  
- **Scoring system**:
  - Points awarded when the user guesses correctly, based on difficulty of the person.
- Same input and exit mechanics as the basic version.
- Designed for better user engagement and challenge.

---

## 3 Advanced Version ('advanced/')

### Date Class Enhancements
- Implements `Comparable` and `Cloneable`.
- Replaces copy constructor with a **better clone method**.
- `compareTo()` replaces detailed day/month/year checks:

### Person and Guessable Classes
- `Person` abstract class:
  - Removed difficulty, start/closing messages, and point methods for reusability.
- `Guessable` interface:
  - `compareTo()` sorts by age, then name alphabetically.
  - Contains clone, startMessage, closingMessage, and scoring logic.

### Game Logic Improvements (GuessMaster3)
- Uses a `HashSet<GuessablePerson>` to store people, ensuring uniqueness.
- Iterates through players using an `Iterator`.

### Additional Features
- Eliminates random selection of people.
- Fully supports extensible object-oriented design for future enhancements.
- Uses encapsulation and clone methods to prevent privacy leaks.
- More maintainable and readable game code.
