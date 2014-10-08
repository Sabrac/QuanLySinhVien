/*
Navicat MySQL Data Transfer

Source Server         : dbo
Source Server Version : 50619
Source Host           : localhost:3306
Source Database       : qlsv

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2014-10-08 11:09:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for chuyennganh
-- ----------------------------
DROP TABLE IF EXISTS `chuyennganh`;
CREATE TABLE `chuyennganh` (
  `chuyennganh_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `ma_cn` varchar(45) NOT NULL DEFAULT '',
  `ten_cn` varchar(45) NOT NULL DEFAULT '',
  `nganh_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`chuyennganh_id`),
  KEY `FK_nganh` (`nganh_id`),
  CONSTRAINT `FK_nganh` FOREIGN KEY (`nganh_id`) REFERENCES `nganh` (`nganh_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chuyennganh
-- ----------------------------
INSERT INTO `chuyennganh` VALUES ('1', 'C1NT', 'Công nghệ phần mềm', '1');
INSERT INTO `chuyennganh` VALUES ('2', 'C2NT', 'Dữ liệu và giải thuật', '1');
INSERT INTO `chuyennganh` VALUES ('3', 'KV36', 'Hệ thống thông tin', '2');
INSERT INTO `chuyennganh` VALUES ('4', 'QTUV', 'Quản trị hệ thống', '3');
INSERT INTO `chuyennganh` VALUES ('5', 'KX36', 'Sóng điện từ', '4');
INSERT INTO `chuyennganh` VALUES ('6', 'KTTT', 'Kinh tế vĩ mô', '5');
INSERT INTO `chuyennganh` VALUES ('7', 'None', 'Không', '1');
INSERT INTO `chuyennganh` VALUES ('9', 'None', 'Không', '2');
INSERT INTO `chuyennganh` VALUES ('10', 'None', 'Không', '3');
INSERT INTO `chuyennganh` VALUES ('11', 'None', 'Không', '4');
INSERT INTO `chuyennganh` VALUES ('12', 'None', 'Không', '5');

-- ----------------------------
-- Table structure for dantoc
-- ----------------------------
DROP TABLE IF EXISTS `dantoc`;
CREATE TABLE `dantoc` (
  `dantoc_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `tendantoc` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`dantoc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dantoc
-- ----------------------------
INSERT INTO `dantoc` VALUES ('1', 'Kinh');
INSERT INTO `dantoc` VALUES ('2', 'Tày');
INSERT INTO `dantoc` VALUES ('3', 'Mường');

-- ----------------------------
-- Table structure for diem
-- ----------------------------
DROP TABLE IF EXISTS `diem`;
CREATE TABLE `diem` (
  `diem_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `monhoc_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `lanthi` varchar(45) NOT NULL DEFAULT '',
  `diemthi` float NOT NULL DEFAULT '0',
  `diemchuyencan` float NOT NULL DEFAULT '0',
  `diemgiuaky` float NOT NULL DEFAULT '0',
  `hocky_id` bigint(20) unsigned NOT NULL,
  `sinhvien_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`diem_id`),
  KEY `FK_monhoc` (`monhoc_id`),
  KEY `FK_sinhvien` (`sinhvien_id`),
  KEY `FK_hocky` (`hocky_id`),
  CONSTRAINT `FK_hocky` FOREIGN KEY (`hocky_id`) REFERENCES `hocky` (`hocky_id`),
  CONSTRAINT `FK_monhoc` FOREIGN KEY (`monhoc_id`) REFERENCES `monhoc` (`monhoc_id`),
  CONSTRAINT `FK_sinhvien` FOREIGN KEY (`sinhvien_id`) REFERENCES `dmsinhvien` (`sinhvien_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of diem
-- ----------------------------
INSERT INTO `diem` VALUES ('1', '1', '1', '10', '8', '8', '1', '1');
INSERT INTO `diem` VALUES ('2', '2', '2', '10', '10', '5', '2', '1');
INSERT INTO `diem` VALUES ('3', '3', '3', '6', '8', '9', '2', '6');
INSERT INTO `diem` VALUES ('4', '4', '1', '8', '7', '8', '2', '8');
INSERT INTO `diem` VALUES ('5', '5', '2', '9', '8', '9', '2', '5');
INSERT INTO `diem` VALUES ('6', '6', '2', '8', '10', '9', '2', '3');
INSERT INTO `diem` VALUES ('8', '1', '1', '7', '5', '6', '1', '4');
INSERT INTO `diem` VALUES ('9', '1', '1', '7', '5', '6', '1', '3');
INSERT INTO `diem` VALUES ('10', '3', '1', '8', '7', '8', '3', '3');
INSERT INTO `diem` VALUES ('11', '1', '1', '8', '8', '8', '1', '5');
INSERT INTO `diem` VALUES ('12', '2', '1', '9', '6', '7', '1', '5');
INSERT INTO `diem` VALUES ('13', '1', '1', '8', '5', '8', '1', '10');
INSERT INTO `diem` VALUES ('14', '2', '1', '10', '3', '9', '1', '10');
INSERT INTO `diem` VALUES ('15', '1', '1', '7', '6', '7', '3', '10');
INSERT INTO `diem` VALUES ('16', '4', '1', '7', '8', '7', '1', '10');
INSERT INTO `diem` VALUES ('17', '1', '1', '7', '8', '7', '1', '12');
INSERT INTO `diem` VALUES ('18', '2', '1', '9', '6', '5', '1', '12');
INSERT INTO `diem` VALUES ('19', '6', '1', '8', '5', '6', '2', '12');
INSERT INTO `diem` VALUES ('20', '4', '1', '7', '8', '8', '3', '12');
INSERT INTO `diem` VALUES ('21', '4', '1', '7', '8', '8', '3', '12');
INSERT INTO `diem` VALUES ('22', '2', '1', '9', '4', '4', '3', '12');

-- ----------------------------
-- Table structure for dmsinhvien
-- ----------------------------
DROP TABLE IF EXISTS `dmsinhvien`;
CREATE TABLE `dmsinhvien` (
  `sinhvien_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `masv` varchar(45) NOT NULL DEFAULT '',
  `hodem` varchar(45) NOT NULL DEFAULT '',
  `ten` varchar(45) NOT NULL DEFAULT '',
  `ngaysinh` datetime DEFAULT NULL,
  `gioitinh` bit(1) NOT NULL DEFAULT b'0',
  `cmtnd` varchar(45) NOT NULL DEFAULT '',
  `sodthoai` varchar(45) NOT NULL DEFAULT '',
  `noisinh` varchar(45) NOT NULL DEFAULT '',
  `quequan` varchar(45) NOT NULL DEFAULT '',
  `hokhauthuongtru` varchar(200) NOT NULL DEFAULT '',
  `noiohientai` varchar(200) NOT NULL DEFAULT '',
  `chedouudai` varchar(100) NOT NULL DEFAULT '',
  `dantoc_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `tongiao_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `quoctich_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `hotenbo` varchar(45) NOT NULL DEFAULT '',
  `nghenghiepbo` varchar(45) NOT NULL DEFAULT '',
  `hotenme` varchar(45) NOT NULL DEFAULT '',
  `nghenghiepme` varchar(45) NOT NULL DEFAULT '',
  `hedt_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `lop_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `chuyennganh_id` bigint(20) unsigned DEFAULT NULL,
  `khoahoc_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `ngaynhaphoc` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `diemdauvao1` float NOT NULL DEFAULT '0',
  `diemdauvao2` float DEFAULT NULL,
  `diemdauvao3` float NOT NULL DEFAULT '0',
  `anhsinhvien` varchar(45) NOT NULL DEFAULT '',
  `delete_flg` bit(1) NOT NULL,
  PRIMARY KEY (`sinhvien_id`),
  KEY `FK_dantoc` (`dantoc_id`),
  KEY `FK_tongiao` (`tongiao_id`),
  KEY `FK_quoctich` (`quoctich_id`),
  KEY `FK_hedt` (`hedt_id`),
  KEY `FK_lophoc` (`lop_id`),
  KEY `FK_khoahoc` (`khoahoc_id`),
  KEY `FK_chuyennganh_sinhvien` (`chuyennganh_id`),
  CONSTRAINT `FK_chuyennganh_sinhvien` FOREIGN KEY (`chuyennganh_id`) REFERENCES `chuyennganh` (`chuyennganh_id`),
  CONSTRAINT `FK_dantoc` FOREIGN KEY (`dantoc_id`) REFERENCES `dantoc` (`dantoc_id`),
  CONSTRAINT `FK_hedt` FOREIGN KEY (`hedt_id`) REFERENCES `hedaotao` (`hedt_id`),
  CONSTRAINT `FK_khoahoc` FOREIGN KEY (`khoahoc_id`) REFERENCES `khoahoc` (`khoahoc_id`),
  CONSTRAINT `FK_lophoc` FOREIGN KEY (`lop_id`) REFERENCES `lophoc` (`lop_id`),
  CONSTRAINT `FK_quoctich` FOREIGN KEY (`quoctich_id`) REFERENCES `quoctich` (`quoctich_id`),
  CONSTRAINT `FK_tongiao` FOREIGN KEY (`tongiao_id`) REFERENCES `tongiao` (`tongiao_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 3072 kB; (`hedt_id`) REFER `hssv/hedaotao`(`hed';

-- ----------------------------
-- Records of dmsinhvien
-- ----------------------------
INSERT INTO `dmsinhvien` VALUES ('1', 'K1', 'Nguyễn Tuấn', 'Vũ', '1991-10-10 00:00:00', '', '4654654', '01654897', 'Hà Nội', 'Hà Nội', 'Số 18 Bà Triệu', 'Số 6 Phạm Văn Đồng ', 'Không', '1', '1', '1', 'Nguyễn Văn Đức', 'Cán bộ', 'Hoàng Thanh Mai', 'Bác sỹ', '1', '1', null, '1', '2014-09-09 23:24:36', '6', '7', '8', 'img', '\0');
INSERT INTO `dmsinhvien` VALUES ('2', 'K2', 'Vũ Thanh', 'Mai', '1991-10-11 00:00:00', '\0', '1231231', '01399494', 'Thái Bình', 'Thái Bình', 'Số 16 A Nam Đồng', 'Số 16 A Nam Đồng', 'Không', '1', '2', '1', 'Vũ Văn Việt', 'Kiến trúc sư', 'Nguyễn Thu Cúc', 'Nội trợ', '1', '1', '7', '1', '2010-10-10 00:00:00', '8', '7', '8', 'img', '\0');
INSERT INTO `dmsinhvien` VALUES ('3', 'D3', 'Nguyễn Tuấn', 'Anh', '1990-07-06 00:00:00', '', '5465169', '09345451', 'Hà Nội', 'Nam Định', 'Só 7 Hoàng Hoa Thám', 'Só 7 Hoàng Hoa Thám', 'Không', '1', '3', '1', 'Nguyễn Văn Tú', 'Cán bộ', 'Hoàng Thanh Mai', 'Phóng viên', '2', '1', null, '1', '2014-09-19 21:53:08', '7', '7', '5', 'img', '\0');
INSERT INTO `dmsinhvien` VALUES ('4', 'D4', 'Vũ Tuấn', 'Anh', '1991-07-06 00:00:00', '', '5465169', '09745774', 'Hà Nội', 'Hải Phòng', 'Só 3 Núi Trúc', 'Số 3 Núi Trúc', 'Không', '1', '3', '2', 'Vũ Văn Nam', 'Cán bộ', 'Hoàng Thanh Nga', 'Cán bộ', '2', '2', '9', '2', '2014-09-19 21:53:08', '7', '8', '5', 'img', '\0');
INSERT INTO `dmsinhvien` VALUES ('5', 'D5', 'Phạm Hoài', 'Anh', '1990-07-06 00:00:00', '\0', '4564564', '09012385', 'Hà Nội', 'Nam Định', 'Só 30 ngõ 6 Hào Nam', 'Só 30 ngõ 6 Hào Nam', 'Có', '3', '5', '1', 'Phạm Văn Linh', 'Cán bộ', 'Hoàng Thanh Hương', 'Phóng viên', '2', '2', null, '2', '2014-09-19 21:53:08', '9', '8', '5', 'img', '\0');
INSERT INTO `dmsinhvien` VALUES ('6', 'D6', 'Trần Tuấn', 'Ngọc', '1991-07-06 00:00:00', '', '1756786', '09311236', 'Ninh Bình', 'Đồng Tháp', 'Só 3 Núi Trúc', 'Số 3 Núi Trúc', 'Không', '1', '4', '1', 'Trần Văn Tú', 'Bác sỹ', 'Hoàng Thanh Thúy', 'Phóng viên', '2', '2', '10', '2', '2014-09-19 21:53:08', '7', '4', '5', 'img', '\0');
INSERT INTO `dmsinhvien` VALUES ('7', 'D7', 'Đoàn Hoài', 'Đức', '1989-07-06 00:00:00', '', '7821648', '09567876', 'Hà Nội', 'Nam Định', 'Số 10 Ngõ 2 Bưởi', 'Số 10 Ngõ 2 Bưởi', 'Không', '1', '3', '4', 'Đoàn Văn Tú', 'Giáo Viên', 'Nguyễn Thu Trà', 'Nội trợ', '2', '2', null, '2', '2014-09-19 21:53:08', '8', '8', '8', 'img', '\0');
INSERT INTO `dmsinhvien` VALUES ('8', 'D8', 'Đào Đức', 'Cần', '1991-07-06 00:00:00', '', '4567812', '09245677', 'Hà Nội', 'Hà Nam', '12A Trích Sài', '12A Trích Sài', 'Không', '1', '4', '1', 'Đào Văn Tú', 'Bộ Đội', 'Nguyễn Thu Ngọc', 'Phóng viên', '2', '3', '11', '3', '2014-09-19 21:53:08', '9', '4', '7', 'img', '\0');
INSERT INTO `dmsinhvien` VALUES ('9', 'D9', 'Trần Việt', 'Anh', '1987-07-06 00:00:00', '', '5568469', '09354564', 'Nam Định', 'Nam Định', 'Số 1 Nam Tràng', 'Số 1 Nam Tràng', 'Không', '2', '3', '1', 'Trần Văn Bách', 'Cán bộ', 'Nguyễn Ngọc Lê', 'Phóng viên', '3', '3', null, '3', '2014-09-19 21:53:08', '7', '5', '9', 'img', '\0');
INSERT INTO `dmsinhvien` VALUES ('10', 'D10', 'Phạm Xuân', 'Bách', '1991-07-06 00:00:00', '', '5456933', '09459997', 'Ninh Bình', 'Nam Định', 'Số 12 Xóm 6 Vĩnh Tuy', 'Số 12 Xóm 6 Vĩnh Tuy', 'Có', '1', '2', '3', 'Phạm Văn Tuấn', 'Kiểm dịch', 'Nguyễn Ngọc Tâm', 'Đầu bếp', '3', '3', '12', '3', '2014-09-19 21:53:08', '9', '6', '10', 'img', '\0');
INSERT INTO `dmsinhvien` VALUES ('11', 'D11', 'Lê Hoàng', 'Hải', '1991-07-06 00:00:00', '', '1045641', '09456878', 'Hà Nội', 'Nam Định', 'Số 2 Nguyễn Biểu', 'Số 2 Nguyễn Biểu', 'Không', '1', '1', '1', 'Lê Văn Tú', 'Cán bộ', 'Nguyễn Ngọc Phương', 'Phóng viên', '3', '3', null, '3', '2014-09-19 21:53:08', '9', '7', '6', 'img', '\0');
INSERT INTO `dmsinhvien` VALUES ('12', 'D12', 'Nguyễn Minh', 'Hải', '2014-10-05 00:00:00', '\0', '8201469', '888-888-8888', 'Hà Nội', 'Hà Nội', 'Só 3 Bà Triệu', 'Só 3 Bà Triệu', 'Không', '1', '1', '1', 'Nguyễn Minh Hào', 'Cán bộ', 'Đào Lê Hương', 'Phóng viên', '2', '3', '2', '3', '2014-10-05 00:00:00', '7', '6', '8', 'img', '\0');

-- ----------------------------
-- Table structure for hedaotao
-- ----------------------------
DROP TABLE IF EXISTS `hedaotao`;
CREATE TABLE `hedaotao` (
  `hedt_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `mahedt` varchar(45) NOT NULL DEFAULT '',
  `ten_hedt` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`hedt_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hedaotao
-- ----------------------------
INSERT INTO `hedaotao` VALUES ('1', 'K01', 'Đại Học');
INSERT INTO `hedaotao` VALUES ('2', 'K02', 'Cao Học');
INSERT INTO `hedaotao` VALUES ('3', 'K03', 'Trung Cấp');

-- ----------------------------
-- Table structure for hocky
-- ----------------------------
DROP TABLE IF EXISTS `hocky`;
CREATE TABLE `hocky` (
  `hocky_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `tenhocky` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`hocky_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hocky
-- ----------------------------
INSERT INTO `hocky` VALUES ('1', 'Học kỳ I');
INSERT INTO `hocky` VALUES ('2', 'Học kỳ II');
INSERT INTO `hocky` VALUES ('3', 'Học kỳ III');

-- ----------------------------
-- Table structure for khoahoc
-- ----------------------------
DROP TABLE IF EXISTS `khoahoc`;
CREATE TABLE `khoahoc` (
  `khoahoc_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `tenkhoahoc` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`khoahoc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of khoahoc
-- ----------------------------
INSERT INTO `khoahoc` VALUES ('1', 'K1');
INSERT INTO `khoahoc` VALUES ('2', 'K2');
INSERT INTO `khoahoc` VALUES ('3', 'K3');
INSERT INTO `khoahoc` VALUES ('4', 'K4');

-- ----------------------------
-- Table structure for lophoc
-- ----------------------------
DROP TABLE IF EXISTS `lophoc`;
CREATE TABLE `lophoc` (
  `lop_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `tenlop` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`lop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lophoc
-- ----------------------------
INSERT INTO `lophoc` VALUES ('1', 'K16SE');
INSERT INTO `lophoc` VALUES ('2', 'K065');
INSERT INTO `lophoc` VALUES ('3', 'SS202');
INSERT INTO `lophoc` VALUES ('4', 'K204');

-- ----------------------------
-- Table structure for monhoc
-- ----------------------------
DROP TABLE IF EXISTS `monhoc`;
CREATE TABLE `monhoc` (
  `monhoc_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `tenmonhoc` varchar(45) NOT NULL DEFAULT '',
  `sotrinh` varchar(45) NOT NULL DEFAULT '',
  `hesoChuyenCan` float NOT NULL DEFAULT '0',
  `hesoGiuaKy` float NOT NULL DEFAULT '0',
  `hesoHocKy` float NOT NULL DEFAULT '0',
  `chuyennganh_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `songaynghi` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`monhoc_id`),
  KEY `FK_chuyennganh` (`chuyennganh_id`),
  CONSTRAINT `FK_chuyennganh` FOREIGN KEY (`chuyennganh_id`) REFERENCES `chuyennganh` (`chuyennganh_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of monhoc
-- ----------------------------
INSERT INTO `monhoc` VALUES ('1', 'Lập trình nâng cao', '5', '10', '20', '70', '1', '5');
INSERT INTO `monhoc` VALUES ('2', 'Cấu trúc dữ liệu', '5', '10', '20', '70', '2', '5');
INSERT INTO `monhoc` VALUES ('3', 'Toán cao cấp', '3', '10', '30', '60', '3', '3');
INSERT INTO `monhoc` VALUES ('4', 'Vật lý', '4', '10', '30', '60', '4', '5');
INSERT INTO `monhoc` VALUES ('5', 'Tiếng Anh', '6', '10', '20', '70', '5', '4');
INSERT INTO `monhoc` VALUES ('6', 'Đường lối CM', '3', '10', '20', '70', '6', '2');

-- ----------------------------
-- Table structure for nganh
-- ----------------------------
DROP TABLE IF EXISTS `nganh`;
CREATE TABLE `nganh` (
  `nganh_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `manganh` varchar(45) NOT NULL DEFAULT '',
  `tennganh` varchar(45) NOT NULL DEFAULT '',
  `ghichu` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`nganh_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nganh
-- ----------------------------
INSERT INTO `nganh` VALUES ('1', 'CNTT', 'Công nghệ thông tin', '');
INSERT INTO `nganh` VALUES ('2', 'NET', 'NET', '');
INSERT INTO `nganh` VALUES ('3', 'QTM', 'Quản trị mạng', '');
INSERT INTO `nganh` VALUES ('4', 'DTVT', 'Điện tử viễn thông', '');
INSERT INTO `nganh` VALUES ('5', 'MARK', 'Marketing', '');

-- ----------------------------
-- Table structure for quoctich
-- ----------------------------
DROP TABLE IF EXISTS `quoctich`;
CREATE TABLE `quoctich` (
  `quoctich_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `tenquoctich` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`quoctich_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of quoctich
-- ----------------------------
INSERT INTO `quoctich` VALUES ('1', 'Việt Nam');
INSERT INTO `quoctich` VALUES ('2', 'Nhật');
INSERT INTO `quoctich` VALUES ('3', 'Mỹ');
INSERT INTO `quoctich` VALUES ('4', 'Thụy Điển');

-- ----------------------------
-- Table structure for tongiao
-- ----------------------------
DROP TABLE IF EXISTS `tongiao`;
CREATE TABLE `tongiao` (
  `tongiao_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `tentongiao` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`tongiao_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tongiao
-- ----------------------------
INSERT INTO `tongiao` VALUES ('1', 'Không');
INSERT INTO `tongiao` VALUES ('2', 'Đạo Phật');
INSERT INTO `tongiao` VALUES ('3', 'Đạo Thiên Chúa');
INSERT INTO `tongiao` VALUES ('4', 'Đạo Hồi');
INSERT INTO `tongiao` VALUES ('5', 'Đạo Hindu');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL DEFAULT '',
  `password` varchar(45) NOT NULL DEFAULT '',
  `hovaten` varchar(255) NOT NULL DEFAULT '',
  `diachi` varchar(255) DEFAULT NULL,
  `sodienthoai` varchar(255) DEFAULT NULL,
  `ngaysinh` date DEFAULT NULL,
  `socmt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', 'Nguyễn Đức Nhanh', 'So 2A bưởi', '0231654', '1988-10-10', '05646516');
INSERT INTO `user` VALUES ('2', 'bdmin', 'bdmin', 'Nguyễn Khuyến', '1 Nam Đồng', '165465465', '1962-10-10', '41564564');
INSERT INTO `user` VALUES ('3', 'cdmin', 'cmin', 'Đào Công Sự', '3 Đồng Xuân', '465454566', '1955-10-10', '549465465');
