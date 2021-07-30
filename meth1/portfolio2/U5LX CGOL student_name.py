# <insert names here>
# 

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

    #Diagram and write out your pseudocode first
    #how many cells do you have to check
    #you have access to the board initialized in the main program area
    
    return 


# Complete this function get_next_gen_cell
# Code Conway's Game of Life algorithm in this function
# :param row int
# :param column int
# :return status String whether alive('X') or dead('-')
def get_next_gen_cell(row, column):

    # code the count_neighbors function first and use it here
    # in your CGOL rules algorithm
    
    
    return

# Complete this function generate_next_board
# After you code the algorithm to determine the status of the next gen for each individual cell
# Code to update the board for all cells
# :param board 2D list containing current board
# :return new_board 2D list containing board for next generation
def generate_next_board(board):

    # Create a new local board. Look at how to initialize in the main area
    new_board = [['-' for i in range(BOARD_SIZE)] for j in range(BOARD_SIZE)]

    # Iterate through each cell and generate the new status for each cell
    # save the new status in your new board
    # You can use a for loop but we need to have the row and column
    # so use a for...in range() loop


    
    return 


##########################################
# main 
##########################################

# initialize board (using list comprehension)
board = [['-' for i in range(BOARD_SIZE)] for j in range(BOARD_SIZE)]
# print_board(board)

#Create some live cells indicated by 'X'
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