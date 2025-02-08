//import scanner
import java.util.Scanner;

public class DzakwanSoal4 {
    public static void main(String[] args){
        Scanner oni = new Scanner(System.in);

        /*harga lptp TScreen = 10000000 + tax 10%
        harga lptp non Tscreen = 9000000 + tax 10%

        tunai 100%
        non-tunai 95%


        */

        System.out.println("-------Selamat datang di PT. SukaMain selamat berbelanja------");
        System.out.println("Katalog:");
        System.out.println("Laptop Jenis Touchscreen, Kode = 1, Price 10.000.000 (Belum termasuk pajak 10%)");
        System.out.println("Laptop Jenis non-Touchscreen, Kode = 2, Price 9.000.000 (Belum termasuk pajak 10%)");
        System.out.println("Dapatkan diskon 5% dengan pembayaran non-tunai!");
        System.out.println("Silahkan pesan disini");
        System.out.println("    |    |    |    |");
        System.out.println("    v    v    v    v");

        //input nama
        String nama;
        System.out.print("Masukan Nama Anda: ");
        nama= oni.nextLine(); 
        
        // jenis laptop
        int jenisLaptop;
        System.out.print("Ketik kode katalog: ");
        jenisLaptop= oni.nextInt();

        String jenisBarang,a,b;
        a = "Laptop Touchscreen";
        b = "Laptop non-Touchscreen";
        jenisBarang = (jenisLaptop < 2 ) ? a : b;

        //kuantitas laptop
        int jumlahLaptop;
        System.out.print("Kuantitas: ");
        jumlahLaptop= oni.nextInt();

        //metode bayar
        int metode;
        System.out.print("Pilih metode pembayaran\n '0' untuk pembayaran tunai \n '1' untuk pembayaran non-tunai: ");
        metode= oni.nextInt();

       

        //perkalian jumlah*jenis
        //total harga sebelum pajak
        int totalHargaSebelumTax,c,d;
        c = jumlahLaptop*10000000;
        d = jumlahLaptop*9000000;
        totalHargaSebelumTax = (jenisLaptop < 2) ? c : d;

        //pajak
        int pajak;
        pajak = totalHargaSebelumTax*1/10;

        //total + pajak
        int totalHargaSetelahPajak;
        totalHargaSetelahPajak = totalHargaSebelumTax + pajak;

        //diskon
        int diskon,e,f;
        e= totalHargaSetelahPajak*5/100;
        f= 0;
        diskon = (metode > 0) ? e : f ;

        //total setelah pajak dan diskon
        int totalHargaSetelahPajakdanDiskon;
        totalHargaSetelahPajakdanDiskon = totalHargaSetelahPajak - diskon;

        

        /* nama pelanggan v
        jenis barang yang dibeli v
        jumlah barang v 
        total harga barang sebelum tax v 
        total tax v
        diskon v
        harga total v
        jumlah pembayaran
        kembalian 
         */

        System.out.println("Nama: " + nama);
        System.out.println("Jenis barang yang dibeli: " + jenisBarang);
        System.out.println("Jumlah barang yang dibeli: " + jumlahLaptop);
        System.out.println("Total harga sebelum ditambah pajak: Rp." + totalHargaSebelumTax);
        System.out.println("Total pajak: Rp." + pajak);
        System.out.println("Diskon: Rp." + diskon);
        System.out.println("Total yang harus dibayar: Rp." + totalHargaSetelahPajakdanDiskon );

        //input pembayaran
        int bayar;
        System.out.print("Masukan nominal uang pembayaran: ");
        bayar= oni.nextInt();

        //kembalian
        int kembalian;
        kembalian = bayar-totalHargaSetelahPajakdanDiskon;

        System.out.println("Nominal pembayaran anda: Rp." + bayar);
        System.out.println("Kembalian: Rp." + kembalian);

        //bonus
        int y;
        y = 50000000;
        String pembelian,x,z;
        x = "Anda mendapatkan hadiah berupa \"Mouse Wireless\"";
        z = "";
        pembelian = ( totalHargaSetelahPajakdanDiskon > y) ? x : z;
        System.out.println(pembelian);
        //Done

    }
}

