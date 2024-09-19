package Day2CoreJava;

public class AbstractClasses {

    public static abstract  class Animal{   // abstract class can contain both abstarct and non-abstract methods ,have default constructor
        void walk(){
            System.out.println("Animal eats"); // non abstarct methods
        }

        //abstarct mthod
        abstract void eat(); //implemenattion of this method completely depends upon the subclass how it want to use and define.

    }

     public static class Horse extends Animal{

        public Horse(){

        }
        @Override
        void eat(){
            System.out.println("HOrse is herbivores eats plants grass");
        }
    }

    static class Tiger extends Animal{
        @Override
        void eat() {
            System.out.println("Eat flesh and meat");
        }
    }

    class Monkey extends Animal{
        @Override
        void eat() {
            System.out.println("omnivores");
        }
    }

    public static void main(String[] args) {
        Horse horse= new Horse();
        horse.eat();

        Tiger tiger= new Tiger();
        tiger.eat();
    }
}
