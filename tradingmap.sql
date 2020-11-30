/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : tradingmap

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2020-11-30 21:30:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `classify` int(11) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', 'admin', 'admin', '1');
INSERT INTO `account` VALUES ('2', 'user', '123456', '0');
INSERT INTO `account` VALUES ('3', 'test', '123456', '0');

-- ----------------------------
-- Table structure for classify
-- ----------------------------
DROP TABLE IF EXISTS `classify`;
CREATE TABLE `classify` (
  `cid` int(11) NOT NULL,
  `cname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of classify
-- ----------------------------
INSERT INTO `classify` VALUES ('1', '食品');
INSERT INTO `classify` VALUES ('2', '日用品');
INSERT INTO `classify` VALUES ('3', '电子产品');
INSERT INTO `classify` VALUES ('4', '奢侈品');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `gid` int(11) NOT NULL,
  `gname` varchar(255) DEFAULT NULL,
  `gprice` double(10,2) DEFAULT NULL,
  `gclass` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('101', '蔬菜', '10.00', '1');
INSERT INTO `goods` VALUES ('102', '罐头食品', '15.00', '1');
INSERT INTO `goods` VALUES ('103', '水果', '20.00', '1');
INSERT INTO `goods` VALUES ('104', '大米', '25.00', '1');
INSERT INTO `goods` VALUES ('105', '肉类制品', '30.00', '1');
INSERT INTO `goods` VALUES ('106', '加工肉类制品', '40.00', '1');
INSERT INTO `goods` VALUES ('201', '化工制品', '60.00', '2');
INSERT INTO `goods` VALUES ('202', '莆田鞋', '100.00', '2');
INSERT INTO `goods` VALUES ('203', '便宜家具', '200.00', '2');
INSERT INTO `goods` VALUES ('204', '大牌衣物', '450.00', '2');
INSERT INTO `goods` VALUES ('301', '智能手表', '800.00', '3');
INSERT INTO `goods` VALUES ('302', '二手游戏机', '1100.00', '3');
INSERT INTO `goods` VALUES ('303', '智能手机', '2000.00', '3');
INSERT INTO `goods` VALUES ('304', '液晶电视', '3500.00', '3');
INSERT INTO `goods` VALUES ('305', '笔记本电脑', '6000.00', '3');
INSERT INTO `goods` VALUES ('401', '名牌包包', '10000.00', '4');
INSERT INTO `goods` VALUES ('402', '概念型科技产品', '15000.00', '4');
INSERT INTO `goods` VALUES ('403', '名家字画', '30000.00', '4');
INSERT INTO `goods` VALUES ('404', '珍贵珠宝', '60000.00', '4');
INSERT INTO `goods` VALUES ('405', '古代收藏品', '100000.00', '4');

-- ----------------------------
-- Table structure for player
-- ----------------------------
DROP TABLE IF EXISTS `player`;
CREATE TABLE `player` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `cash` double(10,2) DEFAULT NULL,
  `debt` double(10,2) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `nowin` int(11) DEFAULT NULL,
  `limit` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of player
-- ----------------------------
INSERT INTO `player` VALUES ('1', 'Player', '1044.00', '99900.10', '2020-11-30', '1', '2021-11-28');

-- ----------------------------
-- Table structure for province
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province` (
  `pid` int(11) NOT NULL,
  `pname` varchar(255) DEFAULT NULL,
  `pregion` varchar(255) DEFAULT NULL,
  `northp` int(11) DEFAULT NULL,
  `eastp` int(11) DEFAULT NULL,
  `westp` int(11) DEFAULT NULL,
  `southp` int(11) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of province
-- ----------------------------
INSERT INTO `province` VALUES ('1', '北京', '1', '3', '2', '3', '3');
INSERT INTO `province` VALUES ('2', '天津', '1', '3', '8', '1', '14');
INSERT INTO `province` VALUES ('3', '河北', '1', '1', '8', '4', '14');
INSERT INTO `province` VALUES ('4', '山西', '1', '5', '3', '30', '17');
INSERT INTO `province` VALUES ('5', '内蒙古', '1', '6', '7', '31', '33');
INSERT INTO `province` VALUES ('6', '黑龙江', '2', '0', '0', '5', '7');
INSERT INTO `province` VALUES ('7', '吉林', '2', '6', '0', '5', '8');
INSERT INTO `province` VALUES ('8', '辽宁', '2', '7', '7', '3', '14');
INSERT INTO `province` VALUES ('9', '上海', '3', '10', '0', '0', '11');
INSERT INTO `province` VALUES ('10', '江苏', '3', '14', '0', '12', '9');
INSERT INTO `province` VALUES ('11', '浙江', '3', '9', '0', '13', '15');
INSERT INTO `province` VALUES ('12', '安徽', '3', '17', '10', '18', '13');
INSERT INTO `province` VALUES ('13', '江西', '3', '12', '11', '19', '20');
INSERT INTO `province` VALUES ('14', '山东', '3', '3', '0', '17', '10');
INSERT INTO `province` VALUES ('15', '福建', '3', '11', '16', '13', '20');
INSERT INTO `province` VALUES ('16', '台湾', '3', '11', '0', '15', '20');
INSERT INTO `province` VALUES ('17', '河南', '4', '4', '14', '30', '18');
INSERT INTO `province` VALUES ('18', '湖北', '4', '17', '12', '25', '19');
INSERT INTO `province` VALUES ('19', '湖南', '4', '18', '13', '27', '20');
INSERT INTO `province` VALUES ('20', '广东', '5', '13', '15', '21', '23');
INSERT INTO `province` VALUES ('21', '广西', '5', '27', '20', '28', '22');
INSERT INTO `province` VALUES ('22', '海南', '5', '21', '24', '28', '0');
INSERT INTO `province` VALUES ('23', '香港', '5', '20', '16', '24', '0');
INSERT INTO `province` VALUES ('24', '澳门', '5', '20', '23', '22', '0');
INSERT INTO `province` VALUES ('25', '重庆', '6', '30', '18', '26', '27');
INSERT INTO `province` VALUES ('26', '四川', '6', '31', '25', '29', '28');
INSERT INTO `province` VALUES ('27', '贵州', '6', '25', '19', '28', '21');
INSERT INTO `province` VALUES ('28', '云南', '6', '26', '27', '29', '0');
INSERT INTO `province` VALUES ('29', '西藏', '6', '34', '26', '0', '0');
INSERT INTO `province` VALUES ('30', '陕西', '7', '5', '4', '33', '25');
INSERT INTO `province` VALUES ('31', '甘肃', '7', '5', '33', '32', '26');
INSERT INTO `province` VALUES ('32', '青海', '7', '34', '31', '34', '29');
INSERT INTO `province` VALUES ('33', '宁夏', '7', '5', '30', '31', '31');
INSERT INTO `province` VALUES ('34', '新疆', '7', '0', '31', '0', '29');

-- ----------------------------
-- Table structure for region
-- ----------------------------
DROP TABLE IF EXISTS `region`;
CREATE TABLE `region` (
  `rid` int(11) NOT NULL,
  `rname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of region
-- ----------------------------
INSERT INTO `region` VALUES ('1', '华北');
INSERT INTO `region` VALUES ('2', '东北');
INSERT INTO `region` VALUES ('3', '华东');
INSERT INTO `region` VALUES ('4', '华中');
INSERT INTO `region` VALUES ('5', '华南');
INSERT INTO `region` VALUES ('6', '西南');
INSERT INTO `region` VALUES ('7', '西北');

-- ----------------------------
-- Table structure for sale
-- ----------------------------
DROP TABLE IF EXISTS `sale`;
CREATE TABLE `sale` (
  `pid` int(11) DEFAULT NULL,
  `gid` int(11) DEFAULT NULL,
  `realprice` double(10,2) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `totalprice` double(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of sale
-- ----------------------------
INSERT INTO `sale` VALUES ('1', '101', '9.50', '411', '4336.05');
INSERT INTO `sale` VALUES ('1', '102', '11.13', '216', '2820.96');
INSERT INTO `sale` VALUES ('1', '103', '17.72', '330', '5659.50');
INSERT INTO `sale` VALUES ('1', '104', '28.59', '156', '3698.76');
INSERT INTO `sale` VALUES ('1', '105', '26.62', '391', '13516.87');
INSERT INTO `sale` VALUES ('1', '106', '36.29', '367', '15913.12');
INSERT INTO `sale` VALUES ('1', '201', '71.88', '50', '3371.50');
INSERT INTO `sale` VALUES ('1', '202', '115.28', '288', '32140.80');
INSERT INTO `sale` VALUES ('1', '203', '179.34', '330', '59004.00');
INSERT INTO `sale` VALUES ('1', '204', '260.84', '373', '138789.57');
INSERT INTO `sale` VALUES ('1', '301', '820.30', '133', '93167.83');
INSERT INTO `sale` VALUES ('1', '302', '1082.47', '321', '399394.62');
INSERT INTO `sale` VALUES ('1', '303', '1891.40', '237', '428958.15');
INSERT INTO `sale` VALUES ('1', '304', '3740.57', '75', '279703.50');
INSERT INTO `sale` VALUES ('1', '305', '6493.48', '338', '2403940.50');
INSERT INTO `sale` VALUES ('1', '401', '8350.58', '322', '2662263.80');
INSERT INTO `sale` VALUES ('1', '402', '11513.69', '354', '5159298.66');
INSERT INTO `sale` VALUES ('1', '403', '28035.15', '245', '6973209.60');
INSERT INTO `sale` VALUES ('1', '404', '44261.65', '364', '21311166.24');
INSERT INTO `sale` VALUES ('1', '405', '79589.37', '154', '13366154.34');
INSERT INTO `sale` VALUES ('2', '101', '9.25', '307', '3189.73');
INSERT INTO `sale` VALUES ('2', '102', '13.76', '206', '3073.52');
INSERT INTO `sale` VALUES ('2', '103', '20.24', '114', '2018.94');
INSERT INTO `sale` VALUES ('2', '104', '23.25', '129', '3187.59');
INSERT INTO `sale` VALUES ('2', '105', '44.52', '106', '3736.50');
INSERT INTO `sale` VALUES ('2', '106', '33.23', '212', '7051.12');
INSERT INTO `sale` VALUES ('2', '201', '57.86', '310', '17586.30');
INSERT INTO `sale` VALUES ('2', '202', '98.13', '121', '10903.31');
INSERT INTO `sale` VALUES ('2', '203', '171.06', '323', '76421.80');
INSERT INTO `sale` VALUES ('2', '204', '342.73', '368', '158446.08');
INSERT INTO `sale` VALUES ('2', '301', '786.78', '193', '147282.16');
INSERT INTO `sale` VALUES ('2', '302', '998.12', '346', '379503.18');
INSERT INTO `sale` VALUES ('2', '303', '2757.17', '116', '275479.12');
INSERT INTO `sale` VALUES ('2', '304', '3637.83', '107', '328756.43');
INSERT INTO `sale` VALUES ('2', '305', '5861.33', '126', '711490.50');
INSERT INTO `sale` VALUES ('2', '401', '6958.18', '260', '2195541.40');
INSERT INTO `sale` VALUES ('2', '402', '13494.20', '237', '3723080.40');
INSERT INTO `sale` VALUES ('2', '403', '35920.63', '28', '755088.32');
INSERT INTO `sale` VALUES ('2', '404', '47292.19', '344', '16754389.28');
INSERT INTO `sale` VALUES ('2', '405', '76106.40', '136', '10929747.44');
INSERT INTO `sale` VALUES ('3', '101', '6.67', '273', '1654.38');
INSERT INTO `sale` VALUES ('3', '102', '13.26', '82', '1129.14');
INSERT INTO `sale` VALUES ('3', '103', '25.95', '54', '1245.78');
INSERT INTO `sale` VALUES ('3', '104', '28.27', '49', '1192.17');
INSERT INTO `sale` VALUES ('3', '105', '38.62', '42', '1337.28');
INSERT INTO `sale` VALUES ('3', '106', '34.60', '260', '9360.00');
INSERT INTO `sale` VALUES ('3', '201', '57.56', '76', '4111.60');
INSERT INTO `sale` VALUES ('3', '202', '77.59', '250', '24430.00');
INSERT INTO `sale` VALUES ('3', '203', '165.90', '201', '35064.45');
INSERT INTO `sale` VALUES ('3', '204', '464.86', '241', '106594.30');
INSERT INTO `sale` VALUES ('3', '301', '800.27', '162', '110147.04');
INSERT INTO `sale` VALUES ('3', '302', '1368.53', '148', '165071.80');
INSERT INTO `sale` VALUES ('3', '303', '1585.88', '139', '234508.29');
INSERT INTO `sale` VALUES ('3', '304', '2980.67', '180', '562980.60');
INSERT INTO `sale` VALUES ('3', '305', '6091.31', '30', '160720.50');
INSERT INTO `sale` VALUES ('3', '401', '11788.97', '62', '665074.00');
INSERT INTO `sale` VALUES ('3', '402', '13063.52', '310', '5238928.70');
INSERT INTO `sale` VALUES ('3', '403', '17808.16', '392', '9695551.60');
INSERT INTO `sale` VALUES ('3', '404', '72331.74', '24', '1431130.80');
INSERT INTO `sale` VALUES ('3', '405', '101879.09', '108', '10140960.24');
INSERT INTO `sale` VALUES ('4', '101', '7.58', '175', '1566.25');
INSERT INTO `sale` VALUES ('4', '102', '16.44', '55', '695.20');
INSERT INTO `sale` VALUES ('4', '103', '15.31', '371', '8633.17');
INSERT INTO `sale` VALUES ('4', '104', '24.37', '190', '4271.20');
INSERT INTO `sale` VALUES ('4', '105', '21.49', '367', '10925.59');
INSERT INTO `sale` VALUES ('4', '106', '50.66', '86', '4106.50');
INSERT INTO `sale` VALUES ('4', '201', '65.80', '49', '3056.13');
INSERT INTO `sale` VALUES ('4', '202', '124.99', '232', '26874.88');
INSERT INTO `sale` VALUES ('4', '203', '124.99', '344', '63230.64');
INSERT INTO `sale` VALUES ('4', '204', '569.41', '231', '121007.04');
INSERT INTO `sale` VALUES ('4', '301', '936.19', '164', '125745.36');
INSERT INTO `sale` VALUES ('4', '302', '1045.19', '224', '219011.52');
INSERT INTO `sale` VALUES ('4', '303', '1898.36', '270', '477241.20');
INSERT INTO `sale` VALUES ('4', '304', '3446.11', '293', '1092761.08');
INSERT INTO `sale` VALUES ('4', '305', '5733.83', '91', '493641.33');
INSERT INTO `sale` VALUES ('4', '401', '11918.23', '173', '1932384.05');
INSERT INTO `sale` VALUES ('4', '402', '12683.24', '392', '5714748.48');
INSERT INTO `sale` VALUES ('4', '403', '24748.22', '275', '6659257.00');
INSERT INTO `sale` VALUES ('4', '404', '58811.58', '214', '13178721.34');
INSERT INTO `sale` VALUES ('4', '405', '106497.80', '129', '12512036.37');
INSERT INTO `sale` VALUES ('5', '101', '11.84', '360', '4183.20');
INSERT INTO `sale` VALUES ('5', '102', '17.09', '55', '839.30');
INSERT INTO `sale` VALUES ('5', '103', '27.06', '100', '2233.00');
INSERT INTO `sale` VALUES ('5', '104', '24.43', '148', '3295.96');
INSERT INTO `sale` VALUES ('5', '105', '19.07', '327', '8171.73');
INSERT INTO `sale` VALUES ('5', '106', '63.25', '27', '1276.29');
INSERT INTO `sale` VALUES ('5', '201', '55.63', '43', '2399.40');
INSERT INTO `sale` VALUES ('5', '202', '92.23', '196', '18388.72');
INSERT INTO `sale` VALUES ('5', '203', '149.78', '387', '69501.33');
INSERT INTO `sale` VALUES ('5', '204', '403.65', '84', '36225.00');
INSERT INTO `sale` VALUES ('5', '301', '702.89', '323', '243596.91');
INSERT INTO `sale` VALUES ('5', '302', '1579.58', '42', '54783.12');
INSERT INTO `sale` VALUES ('5', '303', '1902.51', '355', '715456.35');
INSERT INTO `sale` VALUES ('5', '304', '3605.73', '95', '311971.45');
INSERT INTO `sale` VALUES ('5', '305', '4288.10', '229', '1147166.34');
INSERT INTO `sale` VALUES ('5', '401', '9545.58', '93', '866932.98');
INSERT INTO `sale` VALUES ('5', '402', '22631.82', '88', '1530822.48');
INSERT INTO `sale` VALUES ('5', '403', '24587.96', '200', '4864088.00');
INSERT INTO `sale` VALUES ('5', '404', '65892.74', '125', '8146976.25');
INSERT INTO `sale` VALUES ('5', '405', '90213.03', '366', '41689354.44');
INSERT INTO `sale` VALUES ('6', '101', '10.31', '236', '2721.08');
INSERT INTO `sale` VALUES ('6', '102', '18.21', '84', '1260.84');
INSERT INTO `sale` VALUES ('6', '103', '29.87', '38', '893.00');
INSERT INTO `sale` VALUES ('6', '104', '27.93', '264', '6660.72');
INSERT INTO `sale` VALUES ('6', '105', '35.01', '30', '926.10');
INSERT INTO `sale` VALUES ('6', '106', '36.24', '301', '13755.70');
INSERT INTO `sale` VALUES ('6', '201', '65.02', '171', '11981.97');
INSERT INTO `sale` VALUES ('6', '202', '76.88', '337', '30990.52');
INSERT INTO `sale` VALUES ('6', '203', '209.62', '152', '28372.32');
INSERT INTO `sale` VALUES ('6', '204', '493.64', '69', '26383.53');
INSERT INTO `sale` VALUES ('6', '301', '1223.53', '21', '20042.19');
INSERT INTO `sale` VALUES ('6', '302', '1111.63', '154', '139406.96');
INSERT INTO `sale` VALUES ('6', '303', '1450.81', '268', '505614.16');
INSERT INTO `sale` VALUES ('6', '304', '4955.32', '104', '419326.96');
INSERT INTO `sale` VALUES ('6', '305', '5872.06', '180', '1058029.20');
INSERT INTO `sale` VALUES ('6', '401', '11225.22', '103', '960296.81');
INSERT INTO `sale` VALUES ('6', '402', '16771.00', '231', '3801864.99');
INSERT INTO `sale` VALUES ('6', '403', '29864.18', '177', '5611422.15');
INSERT INTO `sale` VALUES ('6', '404', '52291.65', '288', '16585896.96');
INSERT INTO `sale` VALUES ('6', '405', '63006.21', '302', '24239332.38');
INSERT INTO `sale` VALUES ('7', '101', '13.04', '25', '290.75');
INSERT INTO `sale` VALUES ('7', '102', '13.45', '141', '2122.05');
INSERT INTO `sale` VALUES ('7', '103', '18.60', '38', '696.54');
INSERT INTO `sale` VALUES ('7', '104', '30.66', '81', '2071.17');
INSERT INTO `sale` VALUES ('7', '105', '34.55', '64', '1896.32');
INSERT INTO `sale` VALUES ('7', '106', '42.45', '382', '16380.16');
INSERT INTO `sale` VALUES ('7', '201', '67.81', '335', '21470.15');
INSERT INTO `sale` VALUES ('7', '202', '122.83', '117', '12096.63');
INSERT INTO `sale` VALUES ('7', '203', '256.54', '131', '30579.33');
INSERT INTO `sale` VALUES ('7', '204', '385.96', '388', '194485.00');
INSERT INTO `sale` VALUES ('7', '301', '837.69', '286', '224956.16');
INSERT INTO `sale` VALUES ('7', '302', '945.91', '266', '317292.78');
INSERT INTO `sale` VALUES ('7', '303', '2167.24', '299', '641588.22');
INSERT INTO `sale` VALUES ('7', '304', '2402.11', '300', '905319.00');
INSERT INTO `sale` VALUES ('7', '305', '6537.57', '238', '1434047.58');
INSERT INTO `sale` VALUES ('7', '401', '6585.47', '280', '2354956.80');
INSERT INTO `sale` VALUES ('7', '402', '16424.92', '21', '307418.37');
INSERT INTO `sale` VALUES ('7', '403', '28020.32', '151', '4501136.35');
INSERT INTO `sale` VALUES ('7', '404', '65929.73', '270', '15893774.10');
INSERT INTO `sale` VALUES ('7', '405', '87993.06', '71', '6143074.78');
INSERT INTO `sale` VALUES ('8', '101', '10.90', '48', '531.84');
INSERT INTO `sale` VALUES ('8', '102', '11.97', '341', '5115.00');
INSERT INTO `sale` VALUES ('8', '103', '18.83', '365', '8723.50');
INSERT INTO `sale` VALUES ('8', '104', '23.50', '71', '1546.38');
INSERT INTO `sale` VALUES ('8', '105', '35.84', '154', '4607.68');
INSERT INTO `sale` VALUES ('8', '106', '41.53', '136', '5631.76');
INSERT INTO `sale` VALUES ('8', '201', '47.12', '222', '11546.22');
INSERT INTO `sale` VALUES ('8', '202', '141.95', '35', '4126.50');
INSERT INTO `sale` VALUES ('8', '203', '206.45', '168', '30912.00');
INSERT INTO `sale` VALUES ('8', '204', '524.17', '203', '91808.78');
INSERT INTO `sale` VALUES ('8', '301', '886.76', '177', '132229.62');
INSERT INTO `sale` VALUES ('8', '302', '1293.55', '88', '104433.12');
INSERT INTO `sale` VALUES ('8', '303', '2413.06', '134', '268786.58');
INSERT INTO `sale` VALUES ('8', '304', '4207.66', '84', '310583.28');
INSERT INTO `sale` VALUES ('8', '305', '5348.29', '247', '1616923.75');
INSERT INTO `sale` VALUES ('8', '401', '12117.54', '268', '2990333.28');
INSERT INTO `sale` VALUES ('8', '402', '13483.93', '79', '973702.65');
INSERT INTO `sale` VALUES ('8', '403', '30517.21', '238', '6700273.58');
INSERT INTO `sale` VALUES ('8', '404', '72519.37', '102', '7216561.20');
INSERT INTO `sale` VALUES ('8', '405', '89192.69', '265', '21585445.15');
INSERT INTO `sale` VALUES ('9', '101', '5.67', '340', '2815.20');
INSERT INTO `sale` VALUES ('9', '102', '17.61', '112', '1668.80');
INSERT INTO `sale` VALUES ('9', '103', '18.80', '194', '4316.50');
INSERT INTO `sale` VALUES ('9', '104', '23.34', '378', '9967.86');
INSERT INTO `sale` VALUES ('9', '105', '40.83', '74', '2333.22');
INSERT INTO `sale` VALUES ('9', '106', '36.35', '166', '5612.46');
INSERT INTO `sale` VALUES ('9', '201', '57.46', '217', '10860.85');
INSERT INTO `sale` VALUES ('9', '202', '79.32', '236', '19160.84');
INSERT INTO `sale` VALUES ('9', '203', '245.65', '32', '6411.84');
INSERT INTO `sale` VALUES ('9', '204', '389.61', '266', '137266.64');
INSERT INTO `sale` VALUES ('9', '301', '797.69', '237', '206389.08');
INSERT INTO `sale` VALUES ('9', '302', '910.26', '318', '307286.58');
INSERT INTO `sale` VALUES ('9', '303', '1952.45', '203', '339629.15');
INSERT INTO `sale` VALUES ('9', '304', '3376.23', '273', '1005136.86');
INSERT INTO `sale` VALUES ('9', '305', '7922.31', '111', '732203.73');
INSERT INTO `sale` VALUES ('9', '401', '6578.93', '331', '2907378.22');
INSERT INTO `sale` VALUES ('9', '402', '18319.67', '100', '1647452.00');
INSERT INTO `sale` VALUES ('9', '403', '23390.16', '375', '10991617.50');
INSERT INTO `sale` VALUES ('9', '404', '65106.02', '64', '3620143.36');
INSERT INTO `sale` VALUES ('9', '405', '147233.64', '57', '6778931.91');
INSERT INTO `sale` VALUES ('10', '101', '11.03', '97', '865.24');
INSERT INTO `sale` VALUES ('10', '102', '16.41', '345', '5758.05');
INSERT INTO `sale` VALUES ('10', '103', '20.85', '113', '2043.04');
INSERT INTO `sale` VALUES ('10', '104', '26.66', '349', '9485.82');
INSERT INTO `sale` VALUES ('10', '105', '22.96', '385', '9474.85');
INSERT INTO `sale` VALUES ('10', '106', '35.80', '392', '16530.64');
INSERT INTO `sale` VALUES ('10', '201', '53.01', '290', '17547.90');
INSERT INTO `sale` VALUES ('10', '202', '112.00', '169', '15656.16');
INSERT INTO `sale` VALUES ('10', '203', '196.05', '302', '68369.78');
INSERT INTO `sale` VALUES ('10', '204', '288.72', '324', '118110.96');
INSERT INTO `sale` VALUES ('10', '301', '546.82', '273', '177504.60');
INSERT INTO `sale` VALUES ('10', '302', '1451.40', '109', '128307.17');
INSERT INTO `sale` VALUES ('10', '303', '1760.98', '135', '217503.90');
INSERT INTO `sale` VALUES ('10', '304', '3171.58', '268', '1085547.40');
INSERT INTO `sale` VALUES ('10', '305', '4927.49', '201', '1024225.65');
INSERT INTO `sale` VALUES ('10', '401', '11647.27', '102', '1208567.40');
INSERT INTO `sale` VALUES ('10', '402', '13254.68', '365', '5599490.55');
INSERT INTO `sale` VALUES ('10', '403', '26597.32', '216', '6506252.64');
INSERT INTO `sale` VALUES ('10', '404', '45548.44', '335', '16267298.50');
INSERT INTO `sale` VALUES ('10', '405', '86483.36', '51', '4145348.85');
INSERT INTO `sale` VALUES ('11', '101', '11.04', '238', '2287.18');
INSERT INTO `sale` VALUES ('11', '102', '15.58', '326', '5502.88');
INSERT INTO `sale` VALUES ('11', '103', '13.29', '380', '6509.40');
INSERT INTO `sale` VALUES ('11', '104', '26.08', '28', '725.76');
INSERT INTO `sale` VALUES ('11', '105', '36.20', '342', '11802.42');
INSERT INTO `sale` VALUES ('11', '106', '44.34', '202', '7558.84');
INSERT INTO `sale` VALUES ('11', '201', '66.16', '128', '7351.04');
INSERT INTO `sale` VALUES ('11', '202', '106.56', '199', '22900.92');
INSERT INTO `sale` VALUES ('11', '203', '171.79', '239', '44195.88');
INSERT INTO `sale` VALUES ('11', '204', '446.01', '399', '190534.47');
INSERT INTO `sale` VALUES ('11', '301', '684.66', '146', '95930.76');
INSERT INTO `sale` VALUES ('11', '302', '1014.19', '381', '483008.94');
INSERT INTO `sale` VALUES ('11', '303', '2329.59', '198', '404258.58');
INSERT INTO `sale` VALUES ('11', '304', '2729.09', '388', '1330261.88');
INSERT INTO `sale` VALUES ('11', '305', '6897.74', '178', '1213239.10');
INSERT INTO `sale` VALUES ('11', '401', '10412.73', '318', '3077368.68');
INSERT INTO `sale` VALUES ('11', '402', '15268.98', '175', '2230443.25');
INSERT INTO `sale` VALUES ('11', '403', '29014.13', '230', '7489618.80');
INSERT INTO `sale` VALUES ('11', '404', '53602.83', '255', '13573706.10');
INSERT INTO `sale` VALUES ('11', '405', '109321.24', '23', '2358713.48');
INSERT INTO `sale` VALUES ('12', '101', '7.14', '333', '2953.71');
INSERT INTO `sale` VALUES ('12', '102', '11.45', '371', '5850.67');
INSERT INTO `sale` VALUES ('12', '103', '22.16', '86', '1470.60');
INSERT INTO `sale` VALUES ('12', '104', '17.43', '322', '7203.14');
INSERT INTO `sale` VALUES ('12', '105', '39.28', '228', '7674.48');
INSERT INTO `sale` VALUES ('12', '106', '37.61', '161', '5430.53');
INSERT INTO `sale` VALUES ('12', '201', '73.55', '31', '1998.26');
INSERT INTO `sale` VALUES ('12', '202', '133.10', '84', '10053.96');
INSERT INTO `sale` VALUES ('12', '203', '145.46', '399', '79724.19');
INSERT INTO `sale` VALUES ('12', '204', '320.55', '342', '132562.62');
INSERT INTO `sale` VALUES ('12', '301', '909.31', '161', '121593.64');
INSERT INTO `sale` VALUES ('12', '302', '817.98', '367', '367891.81');
INSERT INTO `sale` VALUES ('12', '303', '2088.86', '259', '620429.32');
INSERT INTO `sale` VALUES ('12', '304', '3879.06', '33', '111022.56');
INSERT INTO `sale` VALUES ('12', '305', '8545.73', '143', '1015826.24');
INSERT INTO `sale` VALUES ('12', '401', '8248.94', '351', '3799708.38');
INSERT INTO `sale` VALUES ('12', '402', '12547.43', '376', '4981872.16');
INSERT INTO `sale` VALUES ('12', '403', '37098.26', '112', '3451001.12');
INSERT INTO `sale` VALUES ('12', '404', '61670.52', '65', '3579092.40');
INSERT INTO `sale` VALUES ('12', '405', '83171.13', '51', '4328293.50');
INSERT INTO `sale` VALUES ('13', '101', '11.17', '205', '1992.60');
INSERT INTO `sale` VALUES ('13', '102', '15.04', '286', '4538.82');
INSERT INTO `sale` VALUES ('13', '103', '15.42', '192', '3371.52');
INSERT INTO `sale` VALUES ('13', '104', '25.52', '189', '4732.56');
INSERT INTO `sale` VALUES ('13', '105', '25.13', '314', '7988.16');
INSERT INTO `sale` VALUES ('13', '106', '41.13', '51', '1693.20');
INSERT INTO `sale` VALUES ('13', '201', '44.77', '332', '20335.00');
INSERT INTO `sale` VALUES ('13', '202', '104.06', '339', '40452.87');
INSERT INTO `sale` VALUES ('13', '203', '153.71', '348', '60649.44');
INSERT INTO `sale` VALUES ('13', '204', '464.86', '127', '51606.45');
INSERT INTO `sale` VALUES ('13', '301', '801.14', '37', '27703.01');
INSERT INTO `sale` VALUES ('13', '302', '928.22', '373', '412664.82');
INSERT INTO `sale` VALUES ('13', '303', '2315.19', '59', '131595.37');
INSERT INTO `sale` VALUES ('13', '304', '2334.92', '333', '965873.16');
INSERT INTO `sale` VALUES ('13', '305', '8430.08', '130', '894621.00');
INSERT INTO `sale` VALUES ('13', '401', '12058.54', '32', '381674.88');
INSERT INTO `sale` VALUES ('13', '402', '12833.26', '169', '2215343.26');
INSERT INTO `sale` VALUES ('13', '403', '28758.83', '173', '4835061.09');
INSERT INTO `sale` VALUES ('13', '404', '60346.56', '121', '7885457.47');
INSERT INTO `sale` VALUES ('13', '405', '114476.62', '328', '36490118.08');
INSERT INTO `sale` VALUES ('14', '101', '8.81', '308', '3628.24');
INSERT INTO `sale` VALUES ('14', '102', '13.93', '187', '2586.21');
INSERT INTO `sale` VALUES ('14', '103', '15.61', '192', '3204.48');
INSERT INTO `sale` VALUES ('14', '104', '16.90', '282', '6088.38');
INSERT INTO `sale` VALUES ('14', '105', '32.74', '123', '3897.87');
INSERT INTO `sale` VALUES ('14', '106', '41.08', '268', '11864.36');
INSERT INTO `sale` VALUES ('14', '201', '51.33', '209', '12757.36');
INSERT INTO `sale` VALUES ('14', '202', '137.05', '87', '9886.68');
INSERT INTO `sale` VALUES ('14', '203', '233.63', '218', '51707.42');
INSERT INTO `sale` VALUES ('14', '204', '396.16', '23', '8932.97');
INSERT INTO `sale` VALUES ('14', '301', '861.49', '79', '59438.81');
INSERT INTO `sale` VALUES ('14', '302', '1051.78', '241', '291354.54');
INSERT INTO `sale` VALUES ('14', '303', '2601.67', '87', '185529.24');
INSERT INTO `sale` VALUES ('14', '304', '4356.96', '252', '1001783.16');
INSERT INTO `sale` VALUES ('14', '305', '8290.64', '169', '1179391.85');
INSERT INTO `sale` VALUES ('14', '401', '9560.13', '309', '3475387.89');
INSERT INTO `sale` VALUES ('14', '402', '15972.93', '156', '2708453.28');
INSERT INTO `sale` VALUES ('14', '403', '28462.34', '138', '4250869.20');
INSERT INTO `sale` VALUES ('14', '404', '56248.24', '234', '16681988.70');
INSERT INTO `sale` VALUES ('14', '405', '89810.85', '360', '31729053.60');
INSERT INTO `sale` VALUES ('15', '101', '7.52', '355', '3986.65');
INSERT INTO `sale` VALUES ('15', '102', '19.70', '83', '1290.65');
INSERT INTO `sale` VALUES ('15', '103', '20.48', '304', '6478.24');
INSERT INTO `sale` VALUES ('15', '104', '25.04', '179', '4446.36');
INSERT INTO `sale` VALUES ('15', '105', '33.84', '235', '7165.15');
INSERT INTO `sale` VALUES ('15', '106', '20.89', '397', '13124.82');
INSERT INTO `sale` VALUES ('15', '201', '55.37', '272', '16230.24');
INSERT INTO `sale` VALUES ('15', '202', '112.80', '252', '25000.92');
INSERT INTO `sale` VALUES ('15', '203', '243.94', '68', '15561.12');
INSERT INTO `sale` VALUES ('15', '204', '411.90', '259', '123333.21');
INSERT INTO `sale` VALUES ('15', '301', '774.50', '306', '272722.50');
INSERT INTO `sale` VALUES ('15', '302', '1256.31', '209', '267927.55');
INSERT INTO `sale` VALUES ('15', '303', '1987.01', '190', '325739.80');
INSERT INTO `sale` VALUES ('15', '304', '3501.16', '298', '1026913.96');
INSERT INTO `sale` VALUES ('15', '305', '6724.55', '156', '909826.32');
INSERT INTO `sale` VALUES ('15', '401', '9478.68', '26', '214861.14');
INSERT INTO `sale` VALUES ('15', '402', '15399.63', '86', '1284547.60');
INSERT INTO `sale` VALUES ('15', '403', '35570.55', '60', '2066053.20');
INSERT INTO `sale` VALUES ('15', '404', '65418.35', '45', '2863643.85');
INSERT INTO `sale` VALUES ('15', '405', '78868.77', '260', '21031673.00');
INSERT INTO `sale` VALUES ('16', '101', '5.89', '371', '3101.56');
INSERT INTO `sale` VALUES ('16', '102', '11.66', '390', '6154.20');
INSERT INTO `sale` VALUES ('16', '103', '15.17', '271', '4918.65');
INSERT INTO `sale` VALUES ('16', '104', '17.33', '353', '8016.63');
INSERT INTO `sale` VALUES ('16', '105', '27.90', '254', '6667.50');
INSERT INTO `sale` VALUES ('16', '106', '33.25', '277', '10808.54');
INSERT INTO `sale` VALUES ('16', '201', '80.66', '115', '7678.55');
INSERT INTO `sale` VALUES ('16', '202', '94.99', '186', '20076.84');
INSERT INTO `sale` VALUES ('16', '203', '190.61', '261', '46408.41');
INSERT INTO `sale` VALUES ('16', '204', '529.70', '274', '145866.64');
INSERT INTO `sale` VALUES ('16', '301', '682.17', '207', '135516.69');
INSERT INTO `sale` VALUES ('16', '302', '1043.71', '323', '322292.63');
INSERT INTO `sale` VALUES ('16', '303', '1238.88', '360', '586065.60');
INSERT INTO `sale` VALUES ('16', '304', '2707.53', '344', '1332459.92');
INSERT INTO `sale` VALUES ('16', '305', '5989.24', '36', '216478.44');
INSERT INTO `sale` VALUES ('16', '401', '9700.73', '251', '2916027.64');
INSERT INTO `sale` VALUES ('16', '402', '14883.57', '20', '262496.80');
INSERT INTO `sale` VALUES ('16', '403', '35187.12', '237', '8224208.10');
INSERT INTO `sale` VALUES ('16', '404', '54559.95', '236', '12513262.80');
INSERT INTO `sale` VALUES ('16', '405', '90618.57', '95', '9080974.95');
INSERT INTO `sale` VALUES ('17', '101', '14.42', '36', '401.04');
INSERT INTO `sale` VALUES ('17', '102', '15.78', '335', '5658.15');
INSERT INTO `sale` VALUES ('17', '103', '16.42', '399', '6623.40');
INSERT INTO `sale` VALUES ('17', '104', '21.62', '382', '8728.70');
INSERT INTO `sale` VALUES ('17', '105', '29.82', '313', '8898.59');
INSERT INTO `sale` VALUES ('17', '106', '37.10', '232', '7932.08');
INSERT INTO `sale` VALUES ('17', '201', '37.77', '354', '18142.50');
INSERT INTO `sale` VALUES ('17', '202', '84.68', '206', '17946.72');
INSERT INTO `sale` VALUES ('17', '203', '286.35', '77', '16973.88');
INSERT INTO `sale` VALUES ('17', '204', '366.71', '399', '164399.97');
INSERT INTO `sale` VALUES ('17', '301', '757.40', '379', '330328.82');
INSERT INTO `sale` VALUES ('17', '302', '1110.93', '328', '401747.52');
INSERT INTO `sale` VALUES ('17', '303', '2246.03', '226', '521153.74');
INSERT INTO `sale` VALUES ('17', '304', '3821.03', '204', '848193.24');
INSERT INTO `sale` VALUES ('17', '305', '8617.61', '133', '906758.09');
INSERT INTO `sale` VALUES ('17', '401', '11058.01', '359', '3857946.83');
INSERT INTO `sale` VALUES ('17', '402', '13044.03', '38', '467616.22');
INSERT INTO `sale` VALUES ('17', '403', '31042.34', '121', '3199423.92');
INSERT INTO `sale` VALUES ('17', '404', '40853.98', '332', '17190774.08');
INSERT INTO `sale` VALUES ('17', '405', '116199.36', '168', '18538929.36');
INSERT INTO `sale` VALUES ('18', '101', '6.94', '297', '2530.44');
INSERT INTO `sale` VALUES ('18', '102', '17.52', '52', '682.24');
INSERT INTO `sale` VALUES ('18', '103', '20.97', '298', '5691.80');
INSERT INTO `sale` VALUES ('18', '104', '22.24', '175', '4443.25');
INSERT INTO `sale` VALUES ('18', '105', '27.12', '296', '9184.88');
INSERT INTO `sale` VALUES ('18', '106', '35.00', '272', '10159.20');
INSERT INTO `sale` VALUES ('18', '201', '82.94', '146', '10501.78');
INSERT INTO `sale` VALUES ('18', '202', '86.44', '217', '18282.25');
INSERT INTO `sale` VALUES ('18', '203', '198.56', '226', '43952.48');
INSERT INTO `sale` VALUES ('18', '204', '360.67', '167', '65540.82');
INSERT INTO `sale` VALUES ('18', '301', '761.43', '184', '145941.44');
INSERT INTO `sale` VALUES ('18', '302', '814.67', '200', '197018.00');
INSERT INTO `sale` VALUES ('18', '303', '1670.43', '386', '752375.76');
INSERT INTO `sale` VALUES ('18', '304', '2157.77', '293', '839609.08');
INSERT INTO `sale` VALUES ('18', '305', '4932.60', '392', '2498165.04');
INSERT INTO `sale` VALUES ('18', '401', '11735.96', '135', '1557870.30');
INSERT INTO `sale` VALUES ('18', '402', '13516.65', '175', '2323588.75');
INSERT INTO `sale` VALUES ('18', '403', '29624.10', '97', '3076592.65');
INSERT INTO `sale` VALUES ('18', '404', '64389.81', '345', '22737445.80');
INSERT INTO `sale` VALUES ('18', '405', '76353.56', '304', '27211584.16');
INSERT INTO `sale` VALUES ('19', '101', '8.23', '278', '2224.00');
INSERT INTO `sale` VALUES ('19', '102', '21.98', '67', '1206.00');
INSERT INTO `sale` VALUES ('19', '103', '17.71', '366', '6317.16');
INSERT INTO `sale` VALUES ('19', '104', '29.53', '94', '2770.18');
INSERT INTO `sale` VALUES ('19', '105', '25.67', '164', '4469.00');
INSERT INTO `sale` VALUES ('19', '106', '39.67', '56', '2152.64');
INSERT INTO `sale` VALUES ('19', '201', '42.26', '265', '14174.85');
INSERT INTO `sale` VALUES ('19', '202', '99.53', '242', '21796.94');
INSERT INTO `sale` VALUES ('19', '203', '183.40', '216', '42871.68');
INSERT INTO `sale` VALUES ('19', '204', '437.13', '96', '38605.44');
INSERT INTO `sale` VALUES ('19', '301', '882.90', '77', '59219.16');
INSERT INTO `sale` VALUES ('19', '302', '598.56', '387', '352576.35');
INSERT INTO `sale` VALUES ('19', '303', '2127.18', '23', '47685.21');
INSERT INTO `sale` VALUES ('19', '304', '3778.47', '187', '754887.21');
INSERT INTO `sale` VALUES ('19', '305', '6624.34', '98', '598327.24');
INSERT INTO `sale` VALUES ('19', '401', '7761.02', '264', '2465596.32');
INSERT INTO `sale` VALUES ('19', '402', '13121.27', '74', '967105.26');
INSERT INTO `sale` VALUES ('19', '403', '25012.83', '258', '6611998.20');
INSERT INTO `sale` VALUES ('19', '404', '60850.75', '265', '15084610.90');
INSERT INTO `sale` VALUES ('19', '405', '89448.52', '60', '5034625.80');
INSERT INTO `sale` VALUES ('20', '101', '11.22', '97', '872.03');
INSERT INTO `sale` VALUES ('20', '102', '14.57', '389', '6297.91');
INSERT INTO `sale` VALUES ('20', '103', '22.19', '162', '2912.76');
INSERT INTO `sale` VALUES ('20', '104', '21.56', '89', '1964.23');
INSERT INTO `sale` VALUES ('20', '105', '23.67', '316', '7982.16');
INSERT INTO `sale` VALUES ('20', '106', '42.25', '389', '17298.83');
INSERT INTO `sale` VALUES ('20', '201', '71.91', '277', '18376.18');
INSERT INTO `sale` VALUES ('20', '202', '104.59', '63', '6491.52');
INSERT INTO `sale` VALUES ('20', '203', '204.97', '226', '51643.26');
INSERT INTO `sale` VALUES ('20', '204', '474.86', '175', '90424.25');
INSERT INTO `sale` VALUES ('20', '301', '944.83', '280', '258605.20');
INSERT INTO `sale` VALUES ('20', '302', '1051.93', '205', '210592.40');
INSERT INTO `sale` VALUES ('20', '303', '2340.75', '185', '357588.35');
INSERT INTO `sale` VALUES ('20', '304', '3034.94', '211', '635920.24');
INSERT INTO `sale` VALUES ('20', '305', '6596.85', '66', '410360.28');
INSERT INTO `sale` VALUES ('20', '401', '11352.49', '100', '961261.00');
INSERT INTO `sale` VALUES ('20', '402', '13613.17', '241', '3034944.33');
INSERT INTO `sale` VALUES ('20', '403', '35975.92', '240', '6279400.80');
INSERT INTO `sale` VALUES ('20', '404', '40651.04', '301', '16228065.84');
INSERT INTO `sale` VALUES ('20', '405', '57693.16', '394', '35684623.34');
INSERT INTO `sale` VALUES ('21', '101', '10.46', '167', '1436.20');
INSERT INTO `sale` VALUES ('21', '102', '12.05', '313', '5173.89');
INSERT INTO `sale` VALUES ('21', '103', '18.91', '36', '633.24');
INSERT INTO `sale` VALUES ('21', '104', '29.68', '383', '11401.91');
INSERT INTO `sale` VALUES ('21', '105', '35.94', '251', '8486.31');
INSERT INTO `sale` VALUES ('21', '106', '32.51', '249', '8548.17');
INSERT INTO `sale` VALUES ('21', '201', '69.14', '88', '4825.04');
INSERT INTO `sale` VALUES ('21', '202', '93.95', '207', '22457.43');
INSERT INTO `sale` VALUES ('21', '203', '233.39', '159', '35579.43');
INSERT INTO `sale` VALUES ('21', '204', '415.80', '212', '79271.04');
INSERT INTO `sale` VALUES ('21', '301', '849.12', '79', '56703.83');
INSERT INTO `sale` VALUES ('21', '302', '1156.03', '126', '130169.34');
INSERT INTO `sale` VALUES ('21', '303', '1653.56', '169', '293541.17');
INSERT INTO `sale` VALUES ('21', '304', '2431.46', '246', '733013.58');
INSERT INTO `sale` VALUES ('21', '305', '4302.58', '297', '1609404.39');
INSERT INTO `sale` VALUES ('21', '401', '12233.87', '78', '907073.70');
INSERT INTO `sale` VALUES ('21', '402', '11740.82', '391', '5089424.13');
INSERT INTO `sale` VALUES ('21', '403', '28974.76', '121', '3581149.88');
INSERT INTO `sale` VALUES ('21', '404', '55523.11', '253', '12701037.69');
INSERT INTO `sale` VALUES ('21', '405', '100448.11', '178', '20480829.52');
INSERT INTO `sale` VALUES ('22', '101', '8.41', '170', '1603.10');
INSERT INTO `sale` VALUES ('22', '102', '11.07', '180', '2235.60');
INSERT INTO `sale` VALUES ('22', '103', '18.66', '352', '7156.16');
INSERT INTO `sale` VALUES ('22', '104', '26.20', '212', '5696.44');
INSERT INTO `sale` VALUES ('22', '105', '20.97', '334', '8426.82');
INSERT INTO `sale` VALUES ('22', '106', '41.41', '174', '7953.54');
INSERT INTO `sale` VALUES ('22', '201', '50.09', '270', '14148.00');
INSERT INTO `sale` VALUES ('22', '202', '104.99', '120', '13891.20');
INSERT INTO `sale` VALUES ('22', '203', '174.25', '386', '74320.44');
INSERT INTO `sale` VALUES ('22', '204', '343.67', '387', '164401.47');
INSERT INTO `sale` VALUES ('22', '301', '779.94', '250', '211022.50');
INSERT INTO `sale` VALUES ('22', '302', '1243.54', '108', '135249.48');
INSERT INTO `sale` VALUES ('22', '303', '1346.40', '360', '709668.00');
INSERT INTO `sale` VALUES ('22', '304', '3910.17', '320', '1295292.80');
INSERT INTO `sale` VALUES ('22', '305', '7489.38', '253', '1710120.61');
INSERT INTO `sale` VALUES ('22', '401', '9449.32', '262', '3004516.44');
INSERT INTO `sale` VALUES ('22', '402', '9883.46', '388', '5899664.16');
INSERT INTO `sale` VALUES ('22', '403', '24250.09', '193', '5379618.31');
INSERT INTO `sale` VALUES ('22', '404', '60988.87', '318', '21989184.84');
INSERT INTO `sale` VALUES ('22', '405', '119909.70', '43', '3862260.00');
INSERT INTO `sale` VALUES ('23', '101', '9.33', '253', '3015.76');
INSERT INTO `sale` VALUES ('23', '102', '18.15', '338', '5911.62');
INSERT INTO `sale` VALUES ('23', '103', '19.19', '298', '6880.82');
INSERT INTO `sale` VALUES ('23', '104', '23.00', '376', '9651.92');
INSERT INTO `sale` VALUES ('23', '105', '30.03', '195', '6006.00');
INSERT INTO `sale` VALUES ('23', '106', '44.10', '137', '6241.72');
INSERT INTO `sale` VALUES ('23', '201', '44.85', '244', '13627.40');
INSERT INTO `sale` VALUES ('23', '202', '78.74', '147', '12733.14');
INSERT INTO `sale` VALUES ('23', '203', '184.19', '83', '15793.24');
INSERT INTO `sale` VALUES ('23', '204', '434.21', '135', '57188.70');
INSERT INTO `sale` VALUES ('23', '301', '673.49', '162', '106861.68');
INSERT INTO `sale` VALUES ('23', '302', '1225.54', '299', '360665.76');
INSERT INTO `sale` VALUES ('23', '303', '1925.39', '309', '724660.62');
INSERT INTO `sale` VALUES ('23', '304', '4916.23', '27', '99653.22');
INSERT INTO `sale` VALUES ('23', '305', '4703.22', '235', '1318923.40');
INSERT INTO `sale` VALUES ('23', '401', '9428.88', '292', '2826729.36');
INSERT INTO `sale` VALUES ('23', '402', '14868.55', '216', '3049958.88');
INSERT INTO `sale` VALUES ('23', '403', '34707.53', '168', '5968132.80');
INSERT INTO `sale` VALUES ('23', '404', '77599.04', '39', '2711794.41');
INSERT INTO `sale` VALUES ('23', '405', '120874.45', '308', '34407884.28');
INSERT INTO `sale` VALUES ('24', '101', '9.45', '225', '2439.00');
INSERT INTO `sale` VALUES ('24', '102', '13.74', '239', '3709.28');
INSERT INTO `sale` VALUES ('24', '103', '19.13', '316', '5966.08');
INSERT INTO `sale` VALUES ('24', '104', '29.75', '244', '6646.56');
INSERT INTO `sale` VALUES ('24', '105', '27.88', '275', '9361.00');
INSERT INTO `sale` VALUES ('24', '106', '43.62', '252', '9903.60');
INSERT INTO `sale` VALUES ('24', '201', '50.39', '326', '18774.34');
INSERT INTO `sale` VALUES ('24', '202', '107.14', '322', '38079.72');
INSERT INTO `sale` VALUES ('24', '203', '186.02', '159', '28799.67');
INSERT INTO `sale` VALUES ('24', '204', '421.85', '373', '187768.20');
INSERT INTO `sale` VALUES ('24', '301', '656.45', '230', '175766.00');
INSERT INTO `sale` VALUES ('24', '302', '1342.30', '246', '304056.00');
INSERT INTO `sale` VALUES ('24', '303', '1762.78', '261', '437344.65');
INSERT INTO `sale` VALUES ('24', '304', '2813.82', '383', '1091887.04');
INSERT INTO `sale` VALUES ('24', '305', '5514.40', '192', '1162200.96');
INSERT INTO `sale` VALUES ('24', '401', '11597.35', '21', '208871.67');
INSERT INTO `sale` VALUES ('24', '402', '21010.10', '106', '1857440.12');
INSERT INTO `sale` VALUES ('24', '403', '31269.76', '386', '12559965.22');
INSERT INTO `sale` VALUES ('24', '404', '77534.90', '143', '9006897.90');
INSERT INTO `sale` VALUES ('24', '405', '111448.57', '333', '37336392.90');
INSERT INTO `sale` VALUES ('25', '101', '9.05', '256', '2186.24');
INSERT INTO `sale` VALUES ('25', '102', '11.73', '338', '4590.04');
INSERT INTO `sale` VALUES ('25', '103', '20.85', '75', '1266.00');
INSERT INTO `sale` VALUES ('25', '104', '28.60', '69', '1617.36');
INSERT INTO `sale` VALUES ('25', '105', '23.35', '222', '5938.50');
INSERT INTO `sale` VALUES ('25', '106', '49.82', '225', '10379.25');
INSERT INTO `sale` VALUES ('25', '201', '74.45', '45', '3056.85');
INSERT INTO `sale` VALUES ('25', '202', '122.45', '97', '9129.64');
INSERT INTO `sale` VALUES ('25', '203', '154.88', '386', '90578.76');
INSERT INTO `sale` VALUES ('25', '204', '538.37', '143', '72904.26');
INSERT INTO `sale` VALUES ('25', '301', '747.08', '328', '291716.64');
INSERT INTO `sale` VALUES ('25', '302', '1285.41', '73', '92722.41');
INSERT INTO `sale` VALUES ('25', '303', '2263.38', '45', '82205.10');
INSERT INTO `sale` VALUES ('25', '304', '5392.55', '40', '160731.60');
INSERT INTO `sale` VALUES ('25', '305', '4671.03', '341', '2345834.48');
INSERT INTO `sale` VALUES ('25', '401', '6540.42', '210', '1687331.10');
INSERT INTO `sale` VALUES ('25', '402', '16597.67', '118', '2108208.06');
INSERT INTO `sale` VALUES ('25', '403', '39457.22', '78', '2551959.54');
INSERT INTO `sale` VALUES ('25', '404', '53720.98', '372', '20064463.56');
INSERT INTO `sale` VALUES ('25', '405', '80998.03', '311', '25757041.77');
INSERT INTO `sale` VALUES ('26', '101', '11.94', '188', '1960.84');
INSERT INTO `sale` VALUES ('26', '102', '20.60', '30', '497.10');
INSERT INTO `sale` VALUES ('26', '103', '16.78', '379', '8868.60');
INSERT INTO `sale` VALUES ('26', '104', '20.95', '213', '5024.67');
INSERT INTO `sale` VALUES ('26', '105', '33.28', '106', '3337.94');
INSERT INTO `sale` VALUES ('26', '106', '48.28', '31', '1109.49');
INSERT INTO `sale` VALUES ('26', '201', '76.00', '73', '4543.52');
INSERT INTO `sale` VALUES ('26', '202', '116.11', '191', '20198.25');
INSERT INTO `sale` VALUES ('26', '203', '157.54', '212', '35874.64');
INSERT INTO `sale` VALUES ('26', '204', '624.61', '113', '57663.90');
INSERT INTO `sale` VALUES ('26', '301', '1168.28', '62', '58603.02');
INSERT INTO `sale` VALUES ('26', '302', '868.22', '363', '386232.00');
INSERT INTO `sale` VALUES ('26', '303', '1794.93', '326', '723296.20');
INSERT INTO `sale` VALUES ('26', '304', '3301.27', '294', '976432.80');
INSERT INTO `sale` VALUES ('26', '305', '8895.72', '110', '783449.70');
INSERT INTO `sale` VALUES ('26', '401', '11326.59', '101', '1153210.93');
INSERT INTO `sale` VALUES ('26', '402', '19378.42', '106', '1667299.44');
INSERT INTO `sale` VALUES ('26', '403', '25345.68', '368', '12502961.92');
INSERT INTO `sale` VALUES ('26', '404', '66764.82', '160', '10650419.20');
INSERT INTO `sale` VALUES ('26', '405', '123940.60', '108', '11983513.68');
INSERT INTO `sale` VALUES ('27', '101', '9.36', '381', '3600.45');
INSERT INTO `sale` VALUES ('27', '102', '14.65', '184', '2366.24');
INSERT INTO `sale` VALUES ('27', '103', '17.80', '385', '6903.05');
INSERT INTO `sale` VALUES ('27', '104', '14.73', '369', '7959.33');
INSERT INTO `sale` VALUES ('27', '105', '27.28', '229', '6702.83');
INSERT INTO `sale` VALUES ('27', '106', '46.09', '167', '6346.00');
INSERT INTO `sale` VALUES ('27', '201', '38.14', '386', '22071.48');
INSERT INTO `sale` VALUES ('27', '202', '120.65', '243', '28970.46');
INSERT INTO `sale` VALUES ('27', '203', '135.56', '274', '47558.18');
INSERT INTO `sale` VALUES ('27', '204', '354.30', '380', '152300.20');
INSERT INTO `sale` VALUES ('27', '301', '790.22', '88', '58982.00');
INSERT INTO `sale` VALUES ('27', '302', '947.82', '193', '205768.88');
INSERT INTO `sale` VALUES ('27', '303', '2200.20', '299', '604649.76');
INSERT INTO `sale` VALUES ('27', '304', '2324.50', '349', '982141.84');
INSERT INTO `sale` VALUES ('27', '305', '6214.55', '355', '2518455.20');
INSERT INTO `sale` VALUES ('27', '401', '12388.47', '182', '1974345.10');
INSERT INTO `sale` VALUES ('27', '402', '15243.66', '318', '4665527.46');
INSERT INTO `sale` VALUES ('27', '403', '34771.94', '52', '1564135.56');
INSERT INTO `sale` VALUES ('27', '404', '41225.45', '362', '17808608.10');
INSERT INTO `sale` VALUES ('27', '405', '79912.57', '148', '12786011.56');
INSERT INTO `sale` VALUES ('28', '101', '8.67', '264', '2867.04');
INSERT INTO `sale` VALUES ('28', '102', '15.80', '288', '4098.24');
INSERT INTO `sale` VALUES ('28', '103', '17.22', '203', '3306.87');
INSERT INTO `sale` VALUES ('28', '104', '26.75', '43', '931.38');
INSERT INTO `sale` VALUES ('28', '105', '23.70', '362', '12362.30');
INSERT INTO `sale` VALUES ('28', '106', '35.88', '371', '17796.87');
INSERT INTO `sale` VALUES ('28', '201', '55.95', '257', '18154.48');
INSERT INTO `sale` VALUES ('28', '202', '97.16', '95', '8460.70');
INSERT INTO `sale` VALUES ('28', '203', '185.06', '223', '44232.05');
INSERT INTO `sale` VALUES ('28', '204', '438.05', '287', '154256.76');
INSERT INTO `sale` VALUES ('28', '301', '585.68', '288', '222235.20');
INSERT INTO `sale` VALUES ('28', '302', '1092.76', '130', '127293.40');
INSERT INTO `sale` VALUES ('28', '303', '1761.83', '60', '105288.60');
INSERT INTO `sale` VALUES ('28', '304', '3713.80', '137', '507775.43');
INSERT INTO `sale` VALUES ('28', '305', '5382.64', '235', '1320375.70');
INSERT INTO `sale` VALUES ('28', '401', '7822.23', '288', '2948693.76');
INSERT INTO `sale` VALUES ('28', '402', '16057.00', '326', '5498511.60');
INSERT INTO `sale` VALUES ('28', '403', '19493.71', '381', '10023081.30');
INSERT INTO `sale` VALUES ('28', '404', '47469.18', '176', '9262279.84');
INSERT INTO `sale` VALUES ('28', '405', '96205.86', '292', '33482848.68');
INSERT INTO `sale` VALUES ('29', '101', '10.15', '360', '3675.60');
INSERT INTO `sale` VALUES ('29', '102', '19.07', '81', '1219.86');
INSERT INTO `sale` VALUES ('29', '103', '18.83', '93', '1780.02');
INSERT INTO `sale` VALUES ('29', '104', '23.47', '164', '3936.00');
INSERT INTO `sale` VALUES ('29', '105', '29.37', '99', '3116.52');
INSERT INTO `sale` VALUES ('29', '106', '37.45', '287', '12424.23');
INSERT INTO `sale` VALUES ('29', '201', '69.86', '127', '7844.79');
INSERT INTO `sale` VALUES ('29', '202', '104.80', '101', '9417.24');
INSERT INTO `sale` VALUES ('29', '203', '128.48', '330', '55713.90');
INSERT INTO `sale` VALUES ('29', '204', '564.27', '39', '19719.18');
INSERT INTO `sale` VALUES ('29', '301', '656.17', '265', '222931.25');
INSERT INTO `sale` VALUES ('29', '302', '888.88', '337', '373972.27');
INSERT INTO `sale` VALUES ('29', '303', '2210.90', '36', '64551.96');
INSERT INTO `sale` VALUES ('29', '304', '2559.30', '324', '1043033.76');
INSERT INTO `sale` VALUES ('29', '305', '5881.35', '338', '2261544.48');
INSERT INTO `sale` VALUES ('29', '401', '10515.24', '33', '335592.84');
INSERT INTO `sale` VALUES ('29', '402', '12963.30', '150', '2158152.00');
INSERT INTO `sale` VALUES ('29', '403', '27000.10', '234', '6671618.46');
INSERT INTO `sale` VALUES ('29', '404', '50798.32', '202', '10677689.70');
INSERT INTO `sale` VALUES ('29', '405', '102878.23', '367', '43648913.79');
INSERT INTO `sale` VALUES ('30', '101', '8.87', '338', '3319.16');
INSERT INTO `sale` VALUES ('30', '102', '16.10', '64', '814.08');
INSERT INTO `sale` VALUES ('30', '103', '23.85', '44', '969.76');
INSERT INTO `sale` VALUES ('30', '104', '28.55', '63', '1438.92');
INSERT INTO `sale` VALUES ('30', '105', '29.66', '191', '5269.69');
INSERT INTO `sale` VALUES ('30', '106', '45.27', '386', '18296.40');
INSERT INTO `sale` VALUES ('30', '201', '45.45', '122', '6046.32');
INSERT INTO `sale` VALUES ('30', '202', '121.69', '112', '12584.32');
INSERT INTO `sale` VALUES ('30', '203', '203.98', '388', '81759.36');
INSERT INTO `sale` VALUES ('30', '204', '378.28', '222', '84997.14');
INSERT INTO `sale` VALUES ('30', '301', '1176.02', '59', '55111.31');
INSERT INTO `sale` VALUES ('30', '302', '1357.74', '22', '25399.88');
INSERT INTO `sale` VALUES ('30', '303', '2175.39', '189', '362564.37');
INSERT INTO `sale` VALUES ('30', '304', '3203.90', '259', '1065225.56');
INSERT INTO `sale` VALUES ('30', '305', '5974.32', '230', '1429857.10');
INSERT INTO `sale` VALUES ('30', '401', '8732.65', '283', '2645973.59');
INSERT INTO `sale` VALUES ('30', '402', '10866.97', '320', '4642764.80');
INSERT INTO `sale` VALUES ('30', '403', '25811.17', '386', '10063749.54');
INSERT INTO `sale` VALUES ('30', '404', '69018.17', '240', '16004212.80');
INSERT INTO `sale` VALUES ('30', '405', '74988.70', '395', '33206879.75');
INSERT INTO `sale` VALUES ('31', '101', '8.70', '204', '1738.08');
INSERT INTO `sale` VALUES ('31', '102', '16.43', '313', '5374.21');
INSERT INTO `sale` VALUES ('31', '103', '16.51', '257', '4392.13');
INSERT INTO `sale` VALUES ('31', '104', '27.92', '119', '2815.54');
INSERT INTO `sale` VALUES ('31', '105', '28.02', '288', '8513.28');
INSERT INTO `sale` VALUES ('31', '106', '31.57', '366', '12853.92');
INSERT INTO `sale` VALUES ('31', '201', '52.18', '395', '24711.20');
INSERT INTO `sale` VALUES ('31', '202', '62.58', '336', '29040.48');
INSERT INTO `sale` VALUES ('31', '203', '170.45', '154', '27776.98');
INSERT INTO `sale` VALUES ('31', '204', '377.75', '379', '166475.75');
INSERT INTO `sale` VALUES ('31', '301', '529.66', '280', '183545.60');
INSERT INTO `sale` VALUES ('31', '302', '1192.19', '340', '441551.20');
INSERT INTO `sale` VALUES ('31', '303', '2041.49', '299', '660613.59');
INSERT INTO `sale` VALUES ('31', '304', '3420.15', '40', '114866.40');
INSERT INTO `sale` VALUES ('31', '305', '6378.52', '291', '2000159.40');
INSERT INTO `sale` VALUES ('31', '401', '6815.42', '296', '2771104.64');
INSERT INTO `sale` VALUES ('31', '402', '9190.72', '371', '4782267.91');
INSERT INTO `sale` VALUES ('31', '403', '20124.79', '341', '9624898.91');
INSERT INTO `sale` VALUES ('31', '404', '44697.27', '330', '20658402.60');
INSERT INTO `sale` VALUES ('31', '405', '87056.88', '184', '15875586.24');
INSERT INTO `sale` VALUES ('32', '101', '9.81', '31', '251.10');
INSERT INTO `sale` VALUES ('32', '102', '17.55', '158', '2347.88');
INSERT INTO `sale` VALUES ('32', '103', '26.34', '67', '1502.14');
INSERT INTO `sale` VALUES ('32', '104', '22.68', '348', '9465.60');
INSERT INTO `sale` VALUES ('32', '105', '24.59', '355', '10234.65');
INSERT INTO `sale` VALUES ('32', '106', '33.99', '356', '14037.08');
INSERT INTO `sale` VALUES ('32', '201', '65.44', '147', '8527.47');
INSERT INTO `sale` VALUES ('32', '202', '86.77', '103', '9507.93');
INSERT INTO `sale` VALUES ('32', '203', '206.44', '361', '76199.88');
INSERT INTO `sale` VALUES ('32', '204', '522.94', '125', '60136.25');
INSERT INTO `sale` VALUES ('32', '301', '913.20', '122', '107746.74');
INSERT INTO `sale` VALUES ('32', '302', '1187.62', '88', '81969.36');
INSERT INTO `sale` VALUES ('32', '303', '1791.07', '70', '126004.90');
INSERT INTO `sale` VALUES ('32', '304', '5413.81', '41', '167648.18');
INSERT INTO `sale` VALUES ('32', '305', '6359.55', '388', '2538587.00');
INSERT INTO `sale` VALUES ('32', '401', '11688.52', '63', '568191.96');
INSERT INTO `sale` VALUES ('32', '402', '11836.61', '307', '4917240.49');
INSERT INTO `sale` VALUES ('32', '403', '23472.94', '163', '3952570.70');
INSERT INTO `sale` VALUES ('32', '404', '63358.82', '278', '17666752.66');
INSERT INTO `sale` VALUES ('32', '405', '103433.37', '314', '31872500.92');
INSERT INTO `sale` VALUES ('33', '101', '10.92', '196', '1801.24');
INSERT INTO `sale` VALUES ('33', '102', '13.49', '243', '3802.95');
INSERT INTO `sale` VALUES ('33', '103', '19.95', '167', '2945.88');
INSERT INTO `sale` VALUES ('33', '104', '25.73', '80', '1713.60');
INSERT INTO `sale` VALUES ('33', '105', '33.91', '244', '7200.44');
INSERT INTO `sale` VALUES ('33', '106', '41.88', '70', '2722.30');
INSERT INTO `sale` VALUES ('33', '201', '46.07', '307', '15681.56');
INSERT INTO `sale` VALUES ('33', '202', '100.44', '197', '18789.86');
INSERT INTO `sale` VALUES ('33', '203', '141.98', '365', '60965.95');
INSERT INTO `sale` VALUES ('33', '204', '409.29', '351', '158392.26');
INSERT INTO `sale` VALUES ('33', '301', '841.52', '245', '208254.90');
INSERT INTO `sale` VALUES ('33', '302', '934.80', '160', '153089.60');
INSERT INTO `sale` VALUES ('33', '303', '1726.23', '163', '295872.71');
INSERT INTO `sale` VALUES ('33', '304', '3904.43', '79', '311251.31');
INSERT INTO `sale` VALUES ('33', '305', '8414.97', '121', '866563.28');
INSERT INTO `sale` VALUES ('33', '401', '12908.80', '28', '326509.96');
INSERT INTO `sale` VALUES ('33', '402', '18303.89', '152', '2698536.56');
INSERT INTO `sale` VALUES ('33', '403', '29683.24', '90', '2608878.60');
INSERT INTO `sale` VALUES ('33', '404', '50499.44', '262', '13597999.12');
INSERT INTO `sale` VALUES ('33', '405', '105408.74', '203', '23514257.34');
INSERT INTO `sale` VALUES ('34', '101', '9.12', '388', '3872.24');
INSERT INTO `sale` VALUES ('34', '102', '11.99', '213', '2796.69');
INSERT INTO `sale` VALUES ('34', '103', '16.49', '186', '3241.98');
INSERT INTO `sale` VALUES ('34', '104', '20.66', '226', '5552.82');
INSERT INTO `sale` VALUES ('34', '105', '29.46', '330', '10850.40');
INSERT INTO `sale` VALUES ('34', '106', '30.47', '285', '11656.50');
INSERT INTO `sale` VALUES ('34', '201', '61.79', '96', '5035.20');
INSERT INTO `sale` VALUES ('34', '202', '105.42', '55', '5418.60');
INSERT INTO `sale` VALUES ('34', '203', '195.25', '387', '91479.06');
INSERT INTO `sale` VALUES ('34', '204', '516.57', '222', '116070.48');
INSERT INTO `sale` VALUES ('34', '301', '681.62', '69', '46566.03');
INSERT INTO `sale` VALUES ('34', '302', '1191.62', '215', '271684.75');
INSERT INTO `sale` VALUES ('34', '303', '2906.60', '41', '90280.77');
INSERT INTO `sale` VALUES ('34', '304', '3299.88', '117', '419202.81');
INSERT INTO `sale` VALUES ('34', '305', '5334.27', '217', '1093046.36');
INSERT INTO `sale` VALUES ('34', '401', '9894.55', '302', '2935319.20');
INSERT INTO `sale` VALUES ('34', '402', '21988.67', '40', '655400.00');
INSERT INTO `sale` VALUES ('34', '403', '27340.27', '293', '8851600.32');
INSERT INTO `sale` VALUES ('34', '404', '60645.02', '261', '15972098.58');
INSERT INTO `sale` VALUES ('34', '405', '120861.80', '24', '2670978.96');

-- ----------------------------
-- Table structure for storage
-- ----------------------------
DROP TABLE IF EXISTS `storage`;
CREATE TABLE `storage` (
  `id` int(11) NOT NULL,
  `gid` int(11) NOT NULL,
  `number` int(11) DEFAULT NULL,
  `cost` double(10,2) DEFAULT NULL,
  `avgprice` double(10,2) DEFAULT '0.00',
  PRIMARY KEY (`id`,`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of storage
-- ----------------------------
INSERT INTO `storage` VALUES ('1', '101', '0', '0.00', '0.00');
INSERT INTO `storage` VALUES ('1', '102', '0', '0.00', '0.00');
INSERT INTO `storage` VALUES ('1', '103', '0', '0.00', '0.00');
INSERT INTO `storage` VALUES ('1', '104', '0', '0.00', '0.00');
INSERT INTO `storage` VALUES ('1', '105', '0', '0.00', '0.00');
INSERT INTO `storage` VALUES ('1', '106', '0', '0.00', '0.00');
INSERT INTO `storage` VALUES ('1', '201', '0', '0.00', '0.00');
INSERT INTO `storage` VALUES ('1', '202', '0', '0.00', '0.00');
INSERT INTO `storage` VALUES ('1', '203', '0', '0.00', '0.00');
INSERT INTO `storage` VALUES ('1', '204', '0', '0.00', '0.00');
INSERT INTO `storage` VALUES ('1', '301', '0', '0.00', '0.00');
INSERT INTO `storage` VALUES ('1', '302', '0', '0.00', '0.00');
INSERT INTO `storage` VALUES ('1', '303', '0', '0.00', '0.00');
INSERT INTO `storage` VALUES ('1', '304', '0', '0.00', '0.00');
INSERT INTO `storage` VALUES ('1', '305', '0', '0.00', '0.00');
INSERT INTO `storage` VALUES ('1', '401', '0', '0.00', '0.00');
INSERT INTO `storage` VALUES ('1', '402', '0', '0.00', '0.00');
INSERT INTO `storage` VALUES ('1', '403', '0', '0.00', '0.00');
INSERT INTO `storage` VALUES ('1', '404', '0', '0.00', '0.00');
INSERT INTO `storage` VALUES ('1', '405', '0', '0.00', '0.00');
DROP TRIGGER IF EXISTS `DebtRule`;
DELIMITER ;;
CREATE TRIGGER `DebtRule` BEFORE UPDATE ON `player` FOR EACH ROW begin
	if new.date > old.date then set new.debt = new.debt + new.debt * 0.001;
	end if;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `NoZero`;
DELIMITER ;;
CREATE TRIGGER `NoZero` BEFORE UPDATE ON `player` FOR EACH ROW begin
	if new.cash < 0 then set new.cash = 0;
	end if;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `getLimit`;
DELIMITER ;;
CREATE TRIGGER `getLimit` BEFORE UPDATE ON `player` FOR EACH ROW begin
	if new.nowin = 1 and new.cash = 1000 and new.debt = 100000 then set new.`limit` = date_add(new.date,interval 1 year);
	end if;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `AccountTotalprice`;
DELIMITER ;;
CREATE TRIGGER `AccountTotalprice` BEFORE INSERT ON `sale` FOR EACH ROW begin
	set new.totalprice = new.realprice * new.number;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `UpdateTotalprice`;
DELIMITER ;;
CREATE TRIGGER `UpdateTotalprice` BEFORE UPDATE ON `sale` FOR EACH ROW begin
	set new.totalprice = new.realprice * new.number;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `MarketRule`;
DELIMITER ;;
CREATE TRIGGER `MarketRule` BEFORE UPDATE ON `sale` FOR EACH ROW begin
	if new.number > old.number then set new.realprice = new.realprice - new.realprice * (new.number - old.number) * 0.001;
	elseif new.number < old.number then set new.realprice = new.realprice + new.realprice * (old.number - new.number) * 0.001;
	else set new.realprice = old.realprice;
	end if;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `getAvgPrice`;
DELIMITER ;;
CREATE TRIGGER `getAvgPrice` BEFORE UPDATE ON `storage` FOR EACH ROW begin
	if new.cost != old.cost then set new.avgprice = new.cost / new.number;
	end if;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `saveStorage`;
DELIMITER ;;
CREATE TRIGGER `saveStorage` BEFORE UPDATE ON `storage` FOR EACH ROW begin
	if new.cost < 0 then set new.cost = 0;
	end if;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `saveStorage2`;
DELIMITER ;;
CREATE TRIGGER `saveStorage2` BEFORE UPDATE ON `storage` FOR EACH ROW begin
	if new.avgprice is null then set new.avgprice = 0;
	end if;
end
;;
DELIMITER ;
