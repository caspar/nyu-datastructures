#### 5/4 - Hashtables / More BSTs





#### 4/20 - BSTs

                 4
               /   \
              2     8
             / \   / \
            1   3 7   9

    inorder(n): //root is middle
    > [1, 2, 3, 4, 5, 8, 9]
    - `inorder(n.left)`
    - `print(n.data)`
    - `inorder(n.right)`

    preorder(n): //root is first
    > [4, 2, 1, 3, 8, 7, 9]
    - `print(n.data)`
    - `preorder(n.left)`
    - `preorder(n.right)`

    postorder(n): //root comes last
    > [1, 3, 2, 4, 9, 8, 7]
    - `postorder(n.left)`
    - `postorder(n.right)`
    - `print(n)`

#### 3/23 - Midterm Review
    Topics:
        - Adv. Java Topics
        - Recursion (overlaps w/ sorting)
        - Generics  (overlaps w/ everything)
        - Performance Results:
            - Sorting
            - Lists, Queues, Stacks (Array-based)
            - Reference-based lists (linked list)

    1. Revisit InsertionSort

    2. Generics
        - 'E' in brackets goes not where we are going to use it as a type,
        - but when we place restrictions on it <E extends Comparable<E> >
        - Only reference types work with generics, not primitives
        > implements vs. extends
            - when you write a class header, use 'implements'.
            - use this when working with an interface

            ` public class Dog implements Comparable<Dog> `
            ` public class Pet<E extends Comparable<E> >  `

    3. Declared vs. Actual types (method calls)
    4. polymorphism

                    Pet
            _________|___________
            |        |          |
           Cat      Dog   SmallCreature
        ____|____  eat()   _____|_____
        |       |          |         |
      Lion  HouseCat     Mouse     Snake

      ` Pet p = new Dog(); //polymorphism `
      ` p.toString(); //calls toString() from Dog `
      ` p.eat(); `
      ` ArrayList<Pet> myPets = new ArrayList<Pet>(); `

      When to use the `super` keyword:
        1. call a hidden method of the superclass
            - `super.eat()` called within HouseCat to access Cat's `eat()` method
            - No super.super!!!
        2. make a constructor call to the superclass's constructor
            -


    5. Comparable<E> interfaced used with extends/implements


    6. Abstract Classes vs. Interfaces
        - AC's can have datafields, I's cannot
        - No restrictions on how many interfaces you can implement

# Self.Notes:
    - Learn implementations of all sorts of sorts
    - BASED ON DNHI HOMEWORKS!!


#### 2/2  - Guess Capitals Game //file parsing review
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
    7. GAMEGAMEGAMEGAME
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
