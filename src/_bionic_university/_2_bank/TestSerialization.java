package _bionic_university._2_bank;

public class TestSerialization {

    public static void main(String[] args) {
        DepoList test = new DepoList();
        test.init();
        test.save("Depo.txt");
        System.out.println("Deposit list has been saved");
    }

}
