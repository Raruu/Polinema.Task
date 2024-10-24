package Exercise2;

public class TestElektronik {
    public static void main(String[] args) {
        Manusia indro = new Manusia();
        TelevisiJadul tvJadul= new TelevisiJadul();
        TelevisiModern tvModern = new TelevisiModern();

        indro.nyalakanPerangkat(tvJadul);
        indro.nyalakanPerangkat(tvModern);
    }
}
