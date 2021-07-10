public class Animal {
    public void animalSound() {
        System.out.println("The animal makes a sound");
    }
}
class Cat extends Animal {
    public void animalSound() {
        System.out.println(" meow");
        }
        }

class Dog extends Animal {
    public void animalSound() {
        System.out.println("bow wow");
    }
}

class Main {
    public static void main(String[] args) {
        Animal a = new Animal();
        Animal c = new Cat();
        Animal d = new Dog();
        a.animalSound();
        c.animalSound();
        d.animalSound();
    }
}
