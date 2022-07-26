# HACK
Virtual Machine, Assembler and Compiler based tools written in Java as a work of the book Noam Nisan and Shimon Schocken's: 'The Elements of Computer Systems: Building a Modern Computer from first Principles.'

The Virtual Machine and is used to emulate .vm extension files from the HACK chipset and write them out to a .txt file using the CodeWriter module. To run the program open the 3 .java files in an IDE. Include a black .txt file and one or all of the .vm files. Change the name of the desired .vm file in the filestring variable of the parser. 

The Hack Assembler module is used for assembling HACK commands from machine code. HACK machine code for programs is given in files with a .asm file extension. The purpose of the module is to identify the type of instruction given the binary input and is used for assembling instructions for the preceeding module: Assembler and Virtual Machine. 
