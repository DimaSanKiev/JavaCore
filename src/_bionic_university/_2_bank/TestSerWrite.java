package _bionic_university._2_bank;

public class TestSerWrite {

    public static void main(String[] args) {
        DepoList test = new DepoList();
        test.init();
        test.save("files/Depo.txt");
        System.out.println("Deposit list has been saved");
    }

}
