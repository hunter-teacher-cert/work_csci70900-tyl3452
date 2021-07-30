# <insert names here>
# Solution

# Unit 5 Lab X
# Conway's Game of Life
# Mr Liu

# Default board size, assumes square board
BOARD_SIZE = 25

# Complete this function to set the board during initial setup
# :param row int
# :param column int
# :param character String 'X' = live, '-' = dead
# :return None
def set_cell(row, column, character):
    board[row][column] = character
    return

# Print out the current board
# :param board 2D list that will be printed
# :return None
def print_board(board):
    print('*****BEGIN BOARD*********')
    for row in board:
        for cell in row:
            print(cell, end= '')
        print()
    print('*****END BOARD***********')

    return

# Complete this function count neighbors
# count the number of surrounding neighbors that are alive
# :param row int
# :param column int
# :return number of live cells surrounding the current cell
def count_neighbors(row, column):
    number_of_neighbors = 0

    #flags to avoid out of bounds errors
    check_first_row = True
    check_left_column = True
    check_right_column = True
    check_last_row = True

    # check flags on which cell to check to avoid out of range errors
    if (row == 0):
        check_first_row = False
    if (column == 0):
        check_left_column = False
    if (column == len(board[0])-1):
        check_right_column = False
    if (row == len(board)-1):
        check_last_row = False

    #Top row
    if (check_first_row and check_left_column and board[row-1][column-1] == 'X'):
        number_of_neighbors += 1
    if (check_first_row and board[row-1][column] == 'X'):
        number_of_neighbors += 1
    if (check_first_row and check_right_column and board[row-1][column+1] == 'X'):
        number_of_neighbors += 1
    #Middle rows
    if (check_left_column and board[row][column-1] == 'X'):
        number_of_neighbors += 1
    if (check_right_column and board[row][column+1] == 'X'):
        number_of_neighbors += 1
    # Bottom row
    if (check_last_row and check_left_column and board[row+1][column-1] == 'X'):
        number_of_neighbors += 1
    if (check_last_row and board[row+1][column] == 'X' ):
        number_of_neighbors += 1
    if (check_last_row and check_right_column and board[row+1][column+1] == 'X'):
        number_of_neighbors += 1
    
    return number_of_neighbors


# Complete this function get_next_gen_cell
# Code Conway's Game of Life algorithm in this function
# :param row int
# :param column int
# :return status String whether alive('X') or dead('-') 
def get_next_gen_cell(row, column):

    status = '-'
    number_of_neighbors = count_neighbors(row, column)

    #More common solution version
    #check if cell is alive or dead first, then check neighbor count
    # if (board[row][column] == '-'): # if dead
    #     if (number_of_neighbors == 3):   #check if exactly 3 neighbors to birth
    #         status = 'X'            # birth
    #     else:
    #         status = '-'             # dead cell stays dead
    # elif (board[row][column] == 'X'):  # if alive
    #     if (number_of_neighbors < 2 or number_of_neighbors > 3): # cell dies
    #         status = '-'        # dies
    #     else:
    #         status = 'X'       # alive cell stays alive if neighbors is 2 or 3
    # else:   # catchall if not dead or alive, set to dead, shouldn't get here unless error
    #     status =  '-'

    # Alternative solution - less common
    # if cell has 2 or 3 neighbors, cell survives, set to X
    # optimized version that only checks number of neighbors
    if (number_of_neighbors == 3):
        status = 'X'
    elif (number_of_neighbors < 2 or number_of_neighbors > 3):    # cell dies starvation or overpopulation
        status = '-'
    else:
        status = board[row][column]

    return status

# Complete this function generate_next_board
# After you code the algorithm to determine the status of the next gen for each individual cell
# Code to update the board for all cells
# :param board 2D list containing current board
# :return new_board 2D list containing board for next generation
def generate_next_board(board):

    new_board = [['-' for i in range(BOARD_SIZE)] for j in range(BOARD_SIZE)]

    # Use a loop but we need to have the row and column so use a for...in range() loop
    for row in range(len(board)):
        for column in range(len(board[0])):
            new_board[row][column] = get_next_gen_cell(row,column)

    return new_board


##########################################
# main 
##########################################

# initialize board (using list comprehension)
board = [['-' for i in range(BOARD_SIZE)] for j in range(BOARD_SIZE)]
# print_board(board)

#Create some live cells
set_cell(0, 0, 'X')
set_cell(0, 1, 'X')
set_cell(1, 0, 'X')
# print_board(board)

#blinker test
set_cell(4, 7, 'X')
set_cell(5, 7, 'X')
set_cell(6, 7, 'X')
# print_board(board)


#tub test
set_cell(20, 15, 'X')
set_cell(21, 14, 'X')
set_cell(21, 16, 'X')
set_cell(22, 15, 'X')
# print_board(board)

#castle?? test
set_cell(5, 20, 'X')
set_cell(6, 19, 'X')
set_cell(6, 20, 'X')
set_cell(6, 21, 'X')
# print_board(board)

#R?? test
set_cell(14, 21, 'X')
set_cell(14, 20, 'X')
set_cell(15, 20, 'X')
set_cell(16, 20, 'X')
# print_board(board)

#glider test
set_cell(11, 3, 'X')
set_cell(12, 3, 'X')
set_cell(13, 3, 'X')
set_cell(13, 2, 'X')
set_cell(12, 1, 'X')
# print_board(board)

# Add additional test cases


### game loop
user_input = ''
gen = 0
while(user_input != 'stop'):
    print('gen' + str(gen))
    print_board(board)
    user_input = input('Press Enter to go to next generation (Type stop otherwise): ')
    gen += 1
    board = generate_next_board(board)