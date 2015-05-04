class Word<E extends Comparable<E> > implements Comparable<E> {

    private E word;
    private int count = 1;

    public word(){

    }

    public int getCount(){

    }

    public E getData(){

    }

    public int compareTo(Word other){
        if (this.getCount() > other.getCount())
            return 1;
        if (this.getCount() < other.getCount())
            return -1;
        else
            return 0;
    }
}
