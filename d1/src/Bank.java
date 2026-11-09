import java.util.ArrayList;

public class Bank {
    private ArrayList<Konto> kontos;

    public Bank() {
        kontos = new ArrayList<>();
    }

    public ArrayList<Konto> getKontos() {
        return kontos;
    }

    public void addKonto(Konto konto) {
        kontos.add(konto);
    }

    public Konto getKonto(String kontoName) {
        for (Konto k : kontos) {
            if (k.customerName.equals(kontoName)) {
                return k;
            }
        }
        return null;
    }

    public void printKontos() {
        for (Konto k : kontos) {
            System.out.println(k.customerName + " " + k.money);
        }
    }
}
