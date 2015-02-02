# 2/2 - Guess Capitals Game //file parsing review
    1. create File obj for input file
        - check the size of args[] (if wrong, quit)
        - create file obj
        - make sure file exists & that you can write to it
    2. create Scanner obj using the file obj from above
        `scanner = new Scanner(new File(file));`
    3. create file obj for output file
        - args
        - create File obj
        - check permissions
    4. create Printwriter obj
    5. create Scanner obj for user input
    6. read data from the input file
        - while loop over all lines
        1.  - read line into a string
            - split() from String
            - trim()  from String  //to match user input
            - save country + capital into an array/AL obj
        2.  - change scanner delimiter to '-' and `'\n'`
    7. GAME
        - loop n times //user specified, etc.
            - ask question ("what is the capital of ___ ?")
            - if correct
                congratulate & continue
            - if not correct
                complain
                give correct answer
                write wrong answer to output file
                continue


# 1/26 - Books:

(req'd) Object0Oriented Data Structures Using Java, Third Edition
Neil Dale et al.

(req'd, free?) OpenDSA - online eBook

Introduction to Java Programming //done!
