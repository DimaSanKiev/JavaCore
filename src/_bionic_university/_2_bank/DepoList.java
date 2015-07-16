package _bionic_university._2_bank;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class DepoList {
    ArrayList<Depo> list = null;

    public DepoList() {
        list = new ArrayList<Depo>();
    }

    public void init() {
        list = new ArrayList<Depo>();
        list.add(new Depo(LocalDate.of(2015, 6, 8), 61, 2500.0, 18.0));
        list.add(new Depo(LocalDate.of(2015, 2, 1), 181, 10000.0, 21.0));
        list.add(new Depo(LocalDate.of(2015, 6, 12), 30, 5500.0, 15.3));
        list.add(new Depo(LocalDate.of(2014, 12, 18), 370, 43000.0, 19.56));
        list.add(new Depo(LocalDate.of(2015, 7, 12), 91, 12000.0, 16.0));
    }

    public double getPrincipal() {
        double sum = 0.0;
        for (Depo depo : list) {
            sum += depo.getSum();
        }
        return sum;
    }

    public void remove() {
        for (Iterator<Depo> it = list.iterator(); it.hasNext(); ) {
            if (it.next().getSum() < 10000.0)
                it.remove();
        }
    }

    public ArrayList<Depo> getList() {
        return list;
    }

    public void save(String fileId) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileId));) {
            for (Depo depo : list)
                out.writeObject(depo);
        } catch (IOException ei) {
            System.out.println(ei.getMessage());
        }
    }

    public void read(String fileId) {
        list.clear();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileId));) {
            while (true) {
                Depo depo = (Depo) in.readObject();
                list.add(depo);
            }
        } catch (ClassNotFoundException ec) {
            System.out.println("Input file " + fileId + " structure corrupted");
        } catch (EOFException ignore) {
        } catch (IOException ei) {
            System.out.println(ei.getMessage());
        }
    }

}

