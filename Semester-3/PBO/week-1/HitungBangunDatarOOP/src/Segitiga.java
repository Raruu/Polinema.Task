public class Segitiga {
    double alasSegitiga, tinggiSegitiga;
    Segitiga(double alasSegitiga, double tinggiSegitiga){
        this.alasSegitiga = alasSegitiga;
        this.tinggiSegitiga = tinggiSegitiga;
    }



    double luasSegitiga() {
        return 0.5 * alasSegitiga * tinggiSegitiga;
    }
}
