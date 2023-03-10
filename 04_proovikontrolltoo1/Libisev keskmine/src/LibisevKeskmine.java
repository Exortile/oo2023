import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class LibisevKeskmine {
    private final ArrayList<Double> algArvud;
    private final ArrayList<Double> keskmineArvud;

    public LibisevKeskmine(double[] arvud) {
        this.algArvud = DoubleStream.of(arvud).boxed().collect(Collectors.toCollection(ArrayList::new));
        this.keskmineArvud = new ArrayList<>();
        this.esmaneLibisevKeskmine();
    }

    private void esmaneLibisevKeskmine() {
        if (this.algArvud.size() < 3)
            return;

        for (int i = 0; i < (this.algArvud.size() - 2); i++) {
            double keskmine = (this.algArvud.get(i) + this.algArvud.get(i + 1) + this.algArvud.get(i + 2)) / 3.0;
            this.keskmineArvud.add(keskmine);
        }
    }

    public void lisaArv(double arv) {
        this.algArvud.add(arv);

        if (this.algArvud.size() < 3)
            return;

        int i1 = this.algArvud.size() - 3;
        int i2 = this.algArvud.size() - 2;
        int i3 = this.algArvud.size() - 1;
        this.keskmineArvud.add((this.algArvud.get(i1) + this.algArvud.get(i2) + this.algArvud.get(i3)) / 3.0);
    }

    public void naitaKeskmisiArve() {
        System.out.println(this.keskmineArvud);
    }

    public void naitaAlgArve() {
        System.out.println(this.algArvud);
    }
}
