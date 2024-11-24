#!/bin/bash

# Assemble the example3.s file into an object file with debug information
as --gstabs example3.s -o example3.o

# Link the object file to create the executable
ld example3.o -o example3

# Run the example3 with ddd debugger in the background
ddd example3&
