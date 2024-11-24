import java.util.Scanner;
public class Kafe16 {

    public static void menu(String namaPelanggan, boolean isMember) {
        System.out.println("Selamat Datang, " + namaPelanggan);

        if (isMember) {
            System.out.println("Anda adalah member, dapatkan diskon 10% untuk setiap pembelian!");
        }

        System.out.println("===== MENU RESTO KAFE =====");
        System.out.println("1. Kopi Hitam - Rp 15,000");
        System.out.println("2. Cappuccino - Rp 20,000");
        System.out.println("3. Latte - Rp 22,000");
        System.out.println("4. Teh Tarik - Rp 12,000");
        System.out.println("5. Roti Bakar - Rp 10,000");
        System.out.println("6. Mie Goreng - Rp 18,000");
        System.out.println("===========================");
        System.out.println("Silahkan pilih menu yang Anda inginkan.");
    }

    public static int hitungTotalHarga(int[] pilihanMenu, int[] banyakItem, String kodePromo) {
        int[] hargaItems = {15000, 20000, 22000, 12000, 10000, 18000};
        int hargaTotal = 0;
        
        for (int i = 0; i < banyakItem.length && banyakItem[i] > 0; i++) {
            hargaTotal += hargaItems[pilihanMenu[i] - 1] * banyakItem[i];
        }

        if (kodePromo.equals("DISKON50")) {
            hargaTotal = hargaTotal - (hargaTotal * 50 / 100);
        } else if (kodePromo.equals("DISKON30")) {
            hargaTotal = hargaTotal - (hargaTotal * 30 / 100);
        } else {
            System.out.println("Kode Invalid, Tidak ada pengurangan Harga");
        }

        return hargaTotal;
    }
    
    public static void main(String[] args) {
        menu("Andi", true);
        Scanner sc = new Scanner(System.in);
        int pilihanMenu[] = new int[10];
        int banyakItem[] = new int[10];
        int hitung = 0;
        
        while (true) {
            if (hitung >= pilihanMenu.length) {
                System.out.println("Pesanan telah mencapai batas maksimum");
                break;
            }
        System.out.print("\nMasukkan nomor menu yang ingin Anda pesan(ketik 0 untuk keluar): ");
        int pilihan = sc.nextInt();
        if (pilihan == 0) {
            System.out.println("Pesanan telah selesai");
            break;
        }
        if (pilihan < 1 || pilihan > 6) {
            System.out.println("Menu tidak valid, masukkan ulang");
            continue;
        }
        pilihanMenu[hitung] = pilihan;

        System.out.print("Masukkan jumlah item yang ingin dipesan: ");
        banyakItem[hitung] = sc.nextInt();
        
        hitung++;
    }
    if (hitung == 0) {
        System.out.println("Anda belum memesan apapun");
        return;
    }
        System.out.print("Masukkan Kode Promo: ");
        String kodePromo = sc.next();

        int totalHarga = hitungTotalHarga(pilihanMenu, banyakItem, kodePromo);

        System.out.println("Total harga untuk pesanan Anda: Rp" + totalHarga);
    }
}