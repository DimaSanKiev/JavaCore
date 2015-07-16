package _bionic_university._2_bank;

public class TestSerRead {

    public static void main(String[] args) {
        DepoList test = new DepoList();
        test.read("Depo.txt");
        System.out.println(test.getPrincipal());
    }

}
