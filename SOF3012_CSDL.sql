Create Database PolyOE
GO
Use PolyOE
GO
CREATE TABLE Users(
Id NVARCHAR(20) NOT NULL,
Password NVARCHAR(50) NOT NULL,
Fullname NVARCHAR(50) NOT NULL,
Email NVARCHAR(50) NOT NULL,
Admin BIT NOT NULL,
PRIMARY KEY(Id)
)

-- Tạo bảng Video--
CREATE TABLE Video (
    Id CHAR(11) NOT NULL,
    Title NVARCHAR(50) NOT NULL,
    Poster NVARCHAR(50) NOT NULL,
    Views INT NOT NULL DEFAULT 0,
    Description TEXT,
    Active BIT NOT NULL,
	PRIMARY KEY(Id)
)

-- Tạo bảng Favorite
CREATE TABLE Favorite (
    Id BIGINT PRIMARY KEY,
    UserId NVARCHAR(20) NOT NULL,
    VideoId CHAR(11)NOT NULL,
    LikeDate DATE,
    UNIQUE (UserId, VideoId), -- Đảm bảo UserId và VideoId là duy nhất
    FOREIGN KEY (UserId) REFERENCES Users(Id),
    FOREIGN KEY (VideoId) REFERENCES Video(Id)
);

-- Tạo bảng Share
CREATE TABLE Share (
    Id BIGINT PRIMARY KEY ,
    UserId NVARCHAR(20)NOT NULL,
    VideoId CHAR(11)NOT NULL,
    Email NVARCHAR(50)NOT NULL,
    ShareDate DATE,
    FOREIGN KEY (UserId) REFERENCES Users(Id),
    FOREIGN KEY (VideoId) REFERENCES Video(Id)
);


INSERT INTO Users (Id,Password,Fullname,Email,Admin) VALUES ('nguyenntk','123456', N'Nguyễn Thị Kim Nguyên','nguyen@abc.com',1);
INSERT INTO Users (Id,Password,Fullname,Email,Admin) VALUES ('tupt','123456', N'Phan Thanh Tú','tu@abc.com',0);
INSERT INTO Users (Id,Password,Fullname,Email,Admin) VALUES ('trungtp','123456', N'Trần Phan Trung','trung@fpt.edu.vn',0);
INSERT INTO Users (Id,Password,Fullname,Email,Admin) VALUES ('phuongtt','123456', N'Trần Thị Phương','phuongtran@fpt.edu.vn',0);
INSERT INTO Users (Id,Password,Fullname,Email,Admin) VALUES ('nguyenng','123456', N'Nguyen Nít Gà','nguyenNG@bruh.com',1);
INSERT INTO Users (Id,Password,Fullname,Email,Admin) VALUES ('Daitn','123456', N'Nguyễn Thành Đại','DaiTN@112.com',0);
INSERT INTO Users (Id,Password,Fullname,Email,Admin) VALUES ('nguyenyn','123456', N'Nguyễn Yến Nhi','YN@990.com',1);
INSERT INTO Users (Id,Password,Fullname,Email,Admin) VALUES ('Thuongpt','123456', N'Phạm Thanh Thương','thuong@mno.com',0);
INSERT INTO Users (Id,Password,Fullname,Email,Admin) VALUES ('ToNv','123456', N'Nguyễn Văn Tô','to@fpt.edu.vn',0);
INSERT INTO Users (Id,Password,Fullname,Email,Admin) VALUES ('LiemNa','123456', N'Nguyễn Anh Liêm','Liemna69@Gmail.vn',0);
INSERT INTO Users (Id,Password,Fullname,Email,Admin) VALUES ('HoangNL','123456', N'Nguyen Lâm Hoàng','HoangNL@fpt.edu.vn',1);
INSERT INTO Users (Id,Password,Fullname,Email,Admin) VALUES ('NgaDtt','123456', N'Đặng Thị Tuyết Nga','NgaDtt@fpt.edu.vn',0);
INSERT INTO Users (Id,Password,Fullname,Email,Admin) VALUES ('ToNT','123456', N'Nguyễn Trung Tô','ToNT@abc.com',0);
INSERT INTO Users (Id,Password,Fullname,Email,Admin) VALUES ('SangPL','123456', N'Phan Lâm Sang','Sang@fpt.edu.vn',0);
INSERT INTO Users (Id,Password,Fullname,Email,Admin) VALUES ('Trangvl','987654', N'Lê Văn Trang','Tranglv@fpt.edu.vn',0);

SELECT * FROM Users
SELECT * FROM Video
SELECT * FROM Favorite
SELECT * FROM Share