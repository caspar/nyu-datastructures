//package inClassWork;
/**
 * A class for solving the towers of Hanoi with recursion
 * @author jake getz
 *
 */

public class TowersOfHanoi {
    /**
     * A test main to run the towers of Hanoi method
     * @param args unused
     */
    public static void main (String[] args){
        towersOfHanoi(5,1,2,3,0);
    }
    /**
     * A method used to solve the towers of Hanoi with any number of slabs
     * @param slabs The number of slabs being moved
     * @param origTower The tower the slabs start on
     * @param interTower The tower used as "Storage Space"
     * @param finTower The final tower to move the slabs to
     * @param count The initial count when the method is called
     */ 
    public static void towersOfHanoi(int slabs, int origTower, int interTower, int finTower, int count){
        //count ++; //this should increment the count every time the method is called
        if (slabs <= 0){
            System.out.println("That is an incorrect amount of slabs");;
        }

        if (slabs == 1){
            System.out.println("Slab 1 moved from tower " + origTower + " to " + finTower);
            System.out.println("It has been " + count +" moves."); //I'm not sure if this is the write place to print the count
        }
        if (slabs > 1){
            //the problem with the count arises here when the method is called twice.
            towersOfHanoi(slabs -1, origTower, finTower, interTower, count);
            System.out.println("Slab " + slabs + " moved from tower " + origTower + " to "+ finTower);
            towersOfHanoi(slabs-1, interTower, origTower, finTower, count+1);
        }
    }

}
