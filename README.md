# Student Management System 🎓

Hệ thống quản lý sinh viên được viết bằng ngôn ngữ Java, áp dụng mô hình thiết kế **MVC (Model - View - Controller)**, phân tách rõ ràng giữa xử lý dữ liệu, giao diện console và kiểm tra dữ liệu đầu vào. Dự án được quản lý phụ thuộc và đóng gói bằng **Apache Maven**.

---

## 🏗️ Cấu trúc mã nguồn

```text
01-Student-Management/
├── src/
│   └── main/
│       └── java/
│           ├── controller/
│           │   └── StudentManager.java       # Điều khiển logic CRUD & nghiệp vụ chính
│           ├── main/
│           │   └── Main.java                 # Điểm khởi chạy chương trình (Entry point)
│           ├── model/
│           │   ├── Person.java               # Lớp cha chứa thông tin cơ bản (ID, Name, DateOfBirth...)
│           │   └── Student.java              # Lớp sinh viên kế thừa từ Person (GPA, Email...)
│           ├── utils/
│           │   ├── Utils.java                # Các hàm tiện ích hỗ trợ đọc dữ liệu Console
│           │   └── Validates.java            # Kiểm tra định dạng đầu vào (Regex, Range...)
│           └── view/
│               ├── MenuView.java             # Hiển thị menu điều hướng người dùng
│               └── StudentIOHandler.java     # Xử lý nhập/xuất dữ liệu sinh viên từ Console
├── pom.xml                                   # Cấu hình dự án Maven
└── README.md                                 # Tài liệu dự án
```

---

## 📌 Tính năng chính (v1.0)

- [x] **Quản lý danh sách (CRUD)**:
  - Thêm mới thông tin sinh viên vào hệ thống.
  - Hiển thị danh sách sinh viên hiện có theo định dạng bảng.
  - Cập nhật thông tin sinh viên dựa trên Mã sinh viên (ID).
  - Xóa sinh viên khỏi hệ thống.
- [x] **Kiểm tra dữ liệu đầu vào (Input Validation)**:
  - Đảm bảo Mã sinh viên không trùng lặp và tuân thủ định dạng.
  - Ràng buộc định dạng Ngày sinh, Email, Số điện thoại.
  - Ràng buộc điểm trung bình (GPA) nằm trong khoảng hợp lệ ($0.0 - 10.0$).
- [x] **Kiến trúc mô-đun**:
  - Lớp `Person` làm nền tảng mở rộng cho các đối tượng khác trong tương lai (Ví dụ: `Teacher`, `Staff`).

---

## 🚀 Hướng dẫn chạy chương trình

### Yêu cầu hệ thống
- **Java Development Kit (JDK)**: Phiên bản 8 trở lên.
- **Apache Maven**: Phiên bản 3.6+

### Các bước thực hiện

1. **Clone repository về máy local:**
   ```bash
   git clone https://github.com/Cinzogoni/Student-Management.git
   ```

2. **Di chuyển vào thư mục dự án:**
   ```bash
   cd Student-Management
   ```

3. **Biên dịch và chạy ứng dụng qua Maven:**
   ```bash
   mvn clean compile
   mvn exec:java -Dexec.mainClass="main.Main"
   ```

---

## 🔮 Kế hoạch phát triển & Mở rộng (Roadmap)

Dự án được thiết kế chuẩn mực để sẵn sàng nâng cấp cho các giai đoạn tiếp theo:

- [ ] **v1.1 - Tìm kiếm & Lọc dữ liệu**:
  - Tìm kiếm sinh viên theo Tên hoặc Mã SV.
  - Sắp xếp danh sách theo Tên (A-Z) hoặc theo GPA tăng/giảm dần.
- [ ] **v1.2 - Lưu trữ dữ liệu lâu dài (Persistence)**:
  - Ghi/Đọc danh sách sinh viên ra file (`.txt` / `.json` / `.csv`).
  - Kết nối Cơ sở dữ liệu quan hệ (MySQL / PostgreSQL / SQLite) thông qua JDBC.
- [ ] **v2.0 - Mở rộng mô hình đối tượng**:
  - Thêm quản lý Giảng viên (`Teacher`) và Nhân viên (`Staff`) kế thừa từ `Person`.
  - Quản lý Môn học (Subject) và Đăng ký học phần.
- [ ] **v2.1 - Giao diện đồ họa (GUI)**:
  - Chuyển đổi giao diện Console sang **JavaFX** hoặc **Swing**.

---

## 📝 Giấy phép (License)
Dự án được xây dựng phục vụ mục đích học tập và thực hành Lập trình hướng đối tượng (OOP).