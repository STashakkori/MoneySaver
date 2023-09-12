#!/bin/bash

# Check for the correct number of command-line arguments
if [ $# -ne 4 ]; then
    echo "Usage: ./run.sh <directory> <file_extensions> <line_number> <text_to_insert>"
    exit 1
fi

# Run the Kotlin program
kotlin InsertTextKt "$1" "$2" "$3" "$4"