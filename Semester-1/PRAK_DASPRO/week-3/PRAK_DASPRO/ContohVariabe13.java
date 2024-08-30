/**
 * ContohVariabe13
 */
public class ContohVariabe13 {
    public static void main(String[] args) {
        String hobby_Saya = "Bermain petak umpet";
        boolean isPandai_Saya = true;
        char kelamin_Saya = 'L';
        byte umur_Saya = 20;
        double ipk_Saya = 3.24, tinggi_Saya = 1.78;
        System.out.println(hobby_Saya);
        System.out.println("Apakah pandai? " + isPandai_Saya);
        System.out.println("Jenis kelamin: " + kelamin_Saya);
        System.out.println("Umurku saat ini: " + umur_Saya);
        System.out.println(String.format("Saya beripk %s dengan tinggi badan %s", ipk_Saya, tinggi_Saya));
    }
}