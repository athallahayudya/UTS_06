package uts;

import java.util.Scanner;
public class Toko06 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan nama pelanggan: ");
        String namaPelanggan = input.nextLine();

        System.out.print("Apakah pelanggan adalah member (ya/tidak)? ");
        boolean isMember = input.nextLine().equalsIgnoreCase("ya");

        double totalHargaSebelumDiskon = 0;
        double totalDiskon = 0;
        int totalItemBarang = 0;

        boolean tambahProduk = true;
        while (tambahProduk) {
            System.out.print("Masukkan nama produk: ");
            String namaProduk = input.nextLine();

            System.out.print("Masukkan kuantitas produk: ");
            int kuantitas = input.nextInt();

            System.out.print("Masukkan harga satuan produk: ");
            double hargaSatuan = input.nextDouble();

            System.out.print("Apakah ada diskon untuk produk ini (persentase, jika tidak ketik 0)? ");
            double diskonProduk = input.nextDouble();

            totalItemBarang += kuantitas;
            double subTotal = kuantitas * hargaSatuan;

            double diskon = subTotal * (diskonProduk / 100);
            totalDiskon += diskon;

            totalHargaSebelumDiskon += subTotal;

            System.out.print("Tambah produk lagi (y/t)? ");
            input.nextLine();
            tambahProduk = input.nextLine().equalsIgnoreCase("y");
        }

        double diskonMember = 0;
        if (isMember) {
            if (totalHargaSebelumDiskon >= 200000) {
                diskonMember = totalHargaSebelumDiskon * 0.1;
            } else {
                diskonMember = totalHargaSebelumDiskon * 0.05;
            }
        }

        double totalAkhir = totalHargaSebelumDiskon - totalDiskon - diskonMember;

        System.out.println("Nama Pelanggan: " + namaPelanggan);
        System.out.println("Tipe Pelanggan: " + (isMember ? "Member" : "Bukan Member"));
        System.out.println("Total Item Barang: " + totalItemBarang);
        System.out.println("Total Harga Sebelum Diskon: " + totalHargaSebelumDiskon);
        System.out.println("Total Diskon: " + totalDiskon);
        System.out.println("Diskon Member: " + diskonMember);
        System.out.println("Total Akhir: " + totalAkhir);

        input.close();
    

    }
}