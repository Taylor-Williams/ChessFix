Piece : abstract class to interface. Change each named piece to inheriting class [Done]

Board : abstract factory for board + piece creation instead of one bloated method in Board (Initialized Board)
Move : create an object which handles Valid Move states as opposed to each piece deciphering that logic
Different Game Types: Strategy pattern to implement 'bughouse' or 'fischer random' types of chess, with our classical version
State implementation: some logic to handle state of game (new game, check, checkmate, stalemate)
Move List: Memento pattern which remembers the moves in a game and is capable of listing the plays.