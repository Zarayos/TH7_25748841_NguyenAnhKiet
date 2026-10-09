package nguyenanhkiet25748841;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so luong hoa don: ");
        int n = Integer.parseInt(sc.nextLine());

        KhachHang[] ds = new KhachHang[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nHoa don thu " + (i + 1));
            System.out.println("1. Khach hang Viet Nam");
            System.out.println("2. Khach hang nuoc ngoai");
            System.out.print("Chon loai khach hang: ");

            int loai = Integer.parseInt(sc.nextLine());

            System.out.print("Ho ten: ");
            String hoTen = sc.nextLine();

            System.out.print("Ngay lap hoa don (yyyy-mm-dd): ");
            LocalDate ngay = LocalDate.parse(sc.nextLine());

            System.out.print("So KW: ");
            double soKW = Double.parseDouble(sc.nextLine());

            System.out.print("Don gia: ");
            double donGia = Double.parseDouble(sc.nextLine());

            if (loai == 1) {
                System.out.print("Doi tuong: ");
                String doiTuong = sc.nextLine();

                System.out.print("Dinh muc: ");
                double dinhMuc =
                        Double.parseDouble(sc.nextLine());

                ds[i] = new KhachHangVN(
                        hoTen, ngay, soKW, donGia,
                        doiTuong, dinhMuc
                );

            } else if (loai == 2) {
                System.out.print("Quoc tich: ");
                String quocTich = sc.nextLine();

                ds[i] = new KhachHangNN(
                        hoTen, ngay, soKW, donGia,
                        quocTich
                );

            } else {
                System.out.println("Loai khach hang khong hop le!");
                i--;
            }
        }

        System.out.println("\n========== DANH SACH HOA DON ==========");
        KhachHang.inTieuDe();

        for (int i = 0; i < n; i++) {
            ds[i].Xuat();
        }

        double tongKWVN = 0;
        double tongKWNN = 0;

        double tongTienNN = 0;
        int demNN = 0;

        for (int i = 0; i < n; i++) {
            if (ds[i] instanceof KhachHangVN) {
                tongKWVN += ds[i].getSoKW();
            } else if (ds[i] instanceof KhachHangNN) {
                tongKWNN += ds[i].getSoKW();
                tongTienNN += ds[i].thanhTien();
                demNN++;
            }
        }

        System.out.println("\n========== THONG KE ==========");
        System.out.printf(
                "Tong KW khach hang Viet Nam: %.2f%n",
                tongKWVN
        );

        System.out.printf(
                "Tong KW khach hang nuoc ngoai: %.2f%n",
                tongKWNN
        );

        if (demNN > 0) {
            System.out.printf(
                    "Trung binh thanh tien khach nuoc ngoai: %.2f%n",
                    tongTienNN / demNN
            );
        } else {
            System.out.println(
                    "Khong co hoa don khach hang nuoc ngoai."
            );
        }
        
        System.out.println("\n===== HOA DON THANG 09/2013 =====");
        KhachHang.inTieuDe();

        boolean timThay = false;

        for (int i = 0; i < n; i++) {
            LocalDate ngay = ds[i].getNgayLapHoaDon();

            if (ngay.getMonthValue() == 9
                    && ngay.getYear() == 2013) {
                ds[i].Xuat();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println(
                    "Khong co hoa don trong thang 09/2013."
            );
        }

        sc.close();
    }
}