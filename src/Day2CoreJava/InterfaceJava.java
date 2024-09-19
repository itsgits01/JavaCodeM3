package Day2CoreJava;

public class InterfaceJava {

    interface Flyable{
        void fly();  //all abstarct methods doesnt have implemtation at all

    }

    interface Swimmable {
        void canSwim();
    }
    class Peacock implements Flyable, Swimmable{

        @Override
        public void fly() {
            System.out.println("Can Fly");
        }

        @Override
        public void canSwim() {
            System.out.println("Cannot Swim");
        }
    }

    static class Penguin implements Swimmable, Flyable{
        @Override
        public void canSwim() {
            System.out.println("Can swim");
        }

        @Override
        public void fly() {
            System.out.println("Cannoy fly");
        }
    }

    public static void main(String[] args) {
        Penguin penguin= new Penguin();

        penguin.canSwim();
        penguin.fly();
    }
}
