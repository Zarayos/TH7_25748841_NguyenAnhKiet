package nguyenanhkiet25748841;

import java.time.LocalDate;

public abstract class KhachHang {
    protected final String maKhachHang;
    protected String hoTen;
    protected LocalDate ngayLapHoaDon;
    protected double soKW;
    protected double donGia;

    private static int nextId = 1;

    public KhachHang(String hoTen, LocalDate ngayLapHoaDon,
                     double soKW, double donGia) {
        this.maKhachHang = String.format("KH%03d", nextId++);
        setHoTen(hoTen);
        setNgayLapHoaDon(ngayLapHoaDon);
        setSoKW(soKW);
        setDonGia(donGia);
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public String getHoTen() {
        return hoTen;
    }

    public LocalDate getNgayLapHoaDon() {
        return ngayLapHoaDon;
    }

    public double getSoKW() {
        return soKW;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setHoTen(String hoTen) {
        if (hoTen == null || hoTen.isBlank()) {
            throw new IllegalArgumentException("Ho ten khong hop le");
        }
        this.hoTen = hoTen;
    }

    public void setNgayLapHoaDon(LocalDate ngayLapHoaDon) {
        if (ngayLapHoaDon == null) {
            throw new IllegalArgumentException("Ngay khong hop le");
        }

        if (ngayLapHoaDon.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException(
                "Ngay lap hoa don khong duoc o tuong lai"
            );
        }

        this.ngayLapHoaDon = ngayLapHoaDon;
    }

    public void setSoKW(double soKW) {
        if (soKW < 0) {
            throw new IllegalArgumentException("So KW phai >= 0");
        }
        this.soKW = soKW;
    }

    public void setDonGia(double donGia) {
        if (donGia < 0) {
            throw new IllegalArgumentException("Don gia phai >= 0");
        }
        this.donGia = donGia;
    }

    public abstract double thanhTien();

    @Override
    public String toString() {
        return String.format(
            "| %-8s | %-25s | %-16s | %10.2f | %12.2f",
            getMaKhachHang(),
            getHoTen(),
            getNgayLapHoaDon(),
            getSoKW(),
            getDonGia()
        );
    }

    public static void inTieuDe() {
        System.out.printf(
            "| %-8s | %-25s | %-16s | %10s | %12s | %-15s | %10s | %15s|%n",
            "MaKH", "Ho Ten", "NgayLapHoaDon", "So KW",
            "DonGia", "Doi tuong/Quoc tich", "Dinh muc", "Thanh tien"
        );

        System.out.println("-".repeat(132));
    }

	public void Xuat() {
	    System.out.println(this);
	}

    
}