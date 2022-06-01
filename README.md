# spring-blog nhóm 20 tổ 5
## Phân công công việc
- Trịnh Bùi Quang Huy: Hiển thị những blog và thêm sửa xóa
- Nguyễn Công Thắng: Làm về người dùng: comment, xem blog, đăng nhập đăng xuất 
- Lê Văn Vượng: Tạo các entity
## Mô tả hệ thống
### Hệ thống blog online
#### -Khi truy cập vào hệ thống người dùng chỉ có thể xem các blog
#### -Nếu muốn thực hiện các chức năng khác thì cần phải có tài khoản
#### -Bấm vào mục đăng ký để tạo 1 tài khoản
##### Nếu chưa có tài khoản thì truy cập vào web bấm nút đăng ký
##### Sau khi đăng kí và có thông báo thành công tài khoản sẽ được lưu trong cơ sở dữ liệu và người dùng quay lại đăng nhập vào trang web bằng tài khoản vừa tạo
#### -Sau khi đã đăng ký và đăng nhập thành công, người dùng có thể thực hiện đầy đủ các chức năng:
#####	Bước 1: Kiểm tra dữ liệu đầu vào từ ô tài khoản và mật khẩu mà người dùng nhập vào.
#####	Bước 2: So sánh username, password với bản ghi có trong cơ sở dữ liệu
Nếu kết quả đúng thì cho người dùng đăng nhập	
Thông báo tài khoản hoặc mật khẩu người dùng nhập vào không hợp lệ.

#### -Viết blog để tạo 1 bài viết mới người dùng bấm ” new post” và nhập nội dung muốn viết
#### -Sửa blog khi người dùng sửa thông tin mong muốn và nhấn nút “Edit” và chỉnh sửa nội dung
#### -Xóa blog khi người dùng cần xóa bài viết nhấn nút “Delete” thì bài viết sẽ được xóa
#### -Bình luận nếu muốn bình luận thì bấm “comment” và nhập nội dung cần bình luận vào
