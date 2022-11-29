/*
 Navicat Premium Data Transfer

 Source Server         : fzp服务器
 Source Server Type    : MySQL
 Source Server Version : 80024
 Source Host           : 106.52.51.88:3306
 Source Schema         : fzp

 Target Server Type    : MySQL
 Target Server Version : 80024
 File Encoding         : 65001

 Date: 24/09/2022 15:52:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '活动名称',
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '活动地点',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '活动内容',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '活动图片',
  `unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '举办单位',
  `time` datetime NULL DEFAULT NULL COMMENT '报名开始时间',
  `overTime` datetime NULL DEFAULT NULL COMMENT '报名截至时间',
  `start` datetime NULL DEFAULT NULL COMMENT '活动开始时间',
  `end` datetime NULL DEFAULT NULL COMMENT '活动结束时间',
  `claim` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '志愿者要求',
  `number` int NULL DEFAULT NULL COMMENT '活动参与人数',
  `state` int NULL DEFAULT NULL COMMENT '活动状态(外键)',
  `user` int NULL DEFAULT NULL COMMENT '活动发布人(外键)',
  `in` int NULL DEFAULT NULL COMMENT '是否再校内(外键)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_activity_user_1`(`user` ASC) USING BTREE,
  INDEX `fk_activity_state_1`(`state` ASC) USING BTREE,
  INDEX `fk_activity_in`(`in` ASC) USING BTREE,
  CONSTRAINT `fk_activity_in` FOREIGN KEY (`in`) REFERENCES `in` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_activity_state_1` FOREIGN KEY (`state`) REFERENCES `state` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_activity_user_1` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '活动记录表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES (1, '发放反诈宣传单', '诸暨市凤山小区', '分发反诈传单,并且介绍相关反诈知识', 'http://www.wuhuazai.com/uploadeview/16638284801881.jpg', '宁波红十字会', '2022-09-30 08:00:00', '2022-10-15 08:00:00', '2022-10-18 08:00:00', '2022-10-15 14:30:00', '在校大学生,有良好反诈意识', 15, 1, 2, 1);
INSERT INTO `activity` VALUES (3, '反诈演讲', '杭州市上城区小学', '进入校园宣传反诈知识并且能够与小朋友互动', 'http://www.wuhuazai.com/uploadeview/16638284981685.jpg', '学生会', '2022-09-08 08:00:00', '2022-10-10 08:00:00', '2022-10-12 08:00:00', '2022-10-12 11:30:00', '在校大学生,有良好反诈意识', 5, 1, 4, 1);
INSERT INTO `activity` VALUES (4, '反诈中心参观', '反诈体验中心', '参观反诈中心,并体验学习具体流程', 'http://www.wuhuazai.com/uploadeview/16638286241192.jpg', '校青年志愿者协会', '2022-09-20 08:00:00', '2022-10-30 12:00:00', '2022-11-02 08:00:00', '2022-11-02 11:30:00', '在校大学生,有良好反诈意识', 50, 2, 4, 2);
INSERT INTO `activity` VALUES (5, '校内义演', '学校的艺术大楼表演厅', '参加反诈表演。', 'http://www.wuhuazai.com/uploadeview/16638285215287.jpg', '学生会', '2022-09-30 08:00:00', '2022-10-15 12:00:00', '2022-10-15 12:00:00', '2022-11-25 11:30:00', '拥有一定才艺,能够在舞台上自如发挥。', 40, 1, 4, 1);
INSERT INTO `activity` VALUES (6, '反诈绘画比赛', '艺术大楼绘画室', '绘制一幅形象的反诈宣传漫画。', 'http://www.wuhuazai.com/uploadeview/16638294990194.jpg', '学生会', '2022-11-15 08:00:00', '2022-12-15 12:00:00', '2022-12-20 08:00:00', '2022-12-20 11:30:00', '在校大学生,拥有一定的绘画基础。在校大学生,有良好反诈意识。', 50, 1, 4, 1);
INSERT INTO `activity` VALUES (13, '第一期反诈手抄报比赛', '无详细地址', '反诈手抄报比赛，让反诈知识能够传到校园的每一个角落。一等奖：100积分，二等奖：50积分，三等奖：30积分。提交作品方式，发布心得体会，带上#第一期反诈手抄报比赛#即可参与。快来点击报名把！提示：必须要报名了的用户带上带上#第一期反诈手抄报比赛#的心得体会才算哦！', 'http://www.wuhuazai.com/uploadeview/1663947235795QQ截图20220923233317.jpg', '学生反诈组织', '2022-09-05 00:00:00', '2022-10-31 23:59:59', '2022-11-24 00:30:00', '2022-12-30 23:59:59', '在校大学生,有良好反诈意识', 300, 2, 4, 1);
INSERT INTO `activity` VALUES (18, '第一期反诈骗口罩设计比赛', '无详细地址', '第一期反诈骗口罩设计比赛，让反诈知识能够传到校园的每一个角落。一等奖：100积分，二等奖：50积分，三等奖：30积分。提交作品方式，发布心得体会，带上#第一期反诈骗口罩设计比赛#即可参与。快来点击报名把！提示：必须要报名了的用户带上带上#第一期反诈骗口罩设计比赛#的心得体会才算哦！', 'http://www.wuhuazai.com/uploadeview/1663946896838bis001.jpg', '信息媒体学院', '2022-09-08 00:00:00', '2022-09-30 00:00:00', '2022-09-10 00:00:00', '2022-09-30 00:00:00', '在校大学生,有良好反诈意识', 100, 3, 6, 1);
INSERT INTO `activity` VALUES (19, '反诈工艺品制作', '学校艺术大楼工艺品室', '尽情发挥你的才能,制作出一款反诈工艺品', 'http://www.wuhuazai.com/uploadeview/16638299225706.jpg', '学生反诈组织', '2022-11-15 08:00:00', '2022-12-15 12:00:00', '2022-12-20 08:00:00', '2022-12-20 11:30:00', '无', 10, 4, 6, 1);
INSERT INTO `activity` VALUES (28, '宣传反诈', '校内', '进入校园宣传反诈', 'http://www.wuhuazai.com/uploadeview/1664003212512587671b98c4c72502bdfc742cc1e314b.png', '学生会', '2022-08-01 00:00:00', '2022-10-01 00:00:00', '2022-10-08 00:00:00', '2022-10-01 20:00:00', '无', 15, 1, 5, 2);

-- ----------------------------
-- Table structure for clock
-- ----------------------------
DROP TABLE IF EXISTS `clock`;
CREATE TABLE `clock`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date NULL DEFAULT NULL,
  `user` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_clock_user`(`user` ASC) USING BTREE,
  CONSTRAINT `fk_clock_user` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of clock
-- ----------------------------
INSERT INTO `clock` VALUES (1, '2022-09-19', 5);
INSERT INTO `clock` VALUES (2, '2022-09-20', 5);
INSERT INTO `clock` VALUES (3, '2022-09-21', 5);
INSERT INTO `clock` VALUES (4, '0002-11-30', 2);
INSERT INTO `clock` VALUES (5, '2022-09-21', 2);
INSERT INTO `clock` VALUES (6, '2022-09-22', 2);
INSERT INTO `clock` VALUES (7, '2022-09-23', 2);
INSERT INTO `clock` VALUES (8, '2022-09-23', 4);
INSERT INTO `clock` VALUES (9, '2022-09-24', 19);
INSERT INTO `clock` VALUES (10, '2022-09-24', 6);
INSERT INTO `clock` VALUES (11, '2022-09-24', 5);
INSERT INTO `clock` VALUES (12, '2022-09-24', 2);

-- ----------------------------
-- Table structure for examine
-- ----------------------------
DROP TABLE IF EXISTS `examine`;
CREATE TABLE `examine`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `examine` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of examine
-- ----------------------------
INSERT INTO `examine` VALUES (1, '待审核');
INSERT INTO `examine` VALUES (2, '审核通过');
INSERT INTO `examine` VALUES (3, '审核失败');

-- ----------------------------
-- Table structure for headlines
-- ----------------------------
DROP TABLE IF EXISTS `headlines`;
CREATE TABLE `headlines`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '头条名字',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '头条内容',
  `date` datetime NULL DEFAULT NULL COMMENT '头条发布时间',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '头条封面图(路径)',
  `user` int NULL DEFAULT NULL COMMENT '头条发布人',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_headlines_user_1`(`user` ASC) USING BTREE,
  CONSTRAINT `fk_headlines_user_1` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '头条新闻表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of headlines
-- ----------------------------
INSERT INTO `headlines` VALUES (2, '网购月饼有质量问题为由实施诈骗', '<p>\n</p>\n<h1><b>以“网购月饼有质量问题”为由实施诈骗：<br>\n</b></h1>\n节日期间，要警惕诈骗分子冒充电商平台客服工作人员，\n<p></p>\n<p>谎称购买的月饼等商品存在质量问题，需要按照其要求办理退款或理赔。</p>\n<p>但实际上是诱骗消费者缴纳各种手续费用，或者以操作失误需要解冻、配合为由骗取钱财。</p>', '2020-04-04 08:00:00', 'http://www.wuhuazai.com/uploadeview/166382807826011.jpg', 8);
INSERT INTO `headlines` VALUES (3, '冒充电商物流客服', '<h1>冒充电商物流客服</h1>\n<p>彭某接到冒充快递公司的境外电话，对方称其快递新冠病毒检测呈阳性需要进行销毁，</p>\n<p>可以对彭某进行理赔。后对方以理赔退款需要验证是否为彭某本人在操作为由，</p>\n<p>要求彭某向其提供的私人银行账户进行转账，被骗<font color=\"#ff0100\"><b>9万元</b></font>。\n</p>', '2020-04-08 08:00:00', 'http://www.wuhuazai.com/uploadeview/166382704741818.jpg', 8);
INSERT INTO `headlines` VALUES (4, '冒充公检法', '<h1>冒充公检法</h1>\n<p>吴某接到冒充反诈中心打来的电话，对方称其涉嫌贩卖假口罩，</p>\n<p>需要封吴某微信号、罚款，要吴某添加QQ配合调查。后吴某为了自证清白</p>\n<p>按照对方的指示在一个链接里填写了银行卡号和手机验证码，被骗<b>39万元</b>。</p>', '2022-09-07 18:49:00', 'http://www.wuhuazai.com/uploadeview/166382757289419.jpg', 8);
INSERT INTO `headlines` VALUES (5, '冒充亲朋好友发送祝福短信进行诈骗', '<h1>冒充亲朋好友发送祝福短信进行诈骗</h1>\n<p>不法分子利用节日期间亲朋好友互相发送祝福信息这一习惯，</p>\n<p>通过发送短信、微信消息、邮件等形式，链接隐藏的木马病毒，</p>\n<p>并大肆传播木马程序。当感染病毒的用户进行网上交易时，</p>\n<p>不法分子会获取用户的账号和密码并伺机作案。\n</p>', '2022-09-09 18:49:03', 'http://www.wuhuazai.com/uploadeview/16638277170658.jpg', 8);
INSERT INTO `headlines` VALUES (6, '以“航班取消可办理退票”为由实施诈骗', '<h1>以“航班取消可办理退票”为由实施诈骗</h1>\n<p>节日期间，要警惕不法分子冒充航空客服人员实施诈骗。</p>\n<p>不法分子会向旅客发送诈骗短信，声称航班取消需办理免费退票，但需要交纳相关手续费。</p>\n<p>然后，告知旅客退款时银行卡存在问题，需电话联系发送授权，进而套取旅客隐私资料等。\n</p>', '2022-09-10 18:49:06', 'http://www.wuhuazai.com/uploadeview/16638276922949.jpg', 8);
INSERT INTO `headlines` VALUES (7, '以“中秋节促销”为由进行诈骗', '<h1>以“中秋节促销”为由进行诈骗</h1>\n<p>这是较为传统的诈骗方法的一个变异。不法分子利用市民通过电商渠道进行采购的时机，</p>\n<p>建立与正规网店相似的交易网站，打着“<b>中秋节特惠活动</b>”的旗号引诱用户购买商品。</p>\n<p>当用户输入真实的账号和密码支付费用时，不法分子便会通过真正的网上银行或者伪造银行储蓄卡、交易卡等方式来盗取用户资金。</p>', '2022-09-12 18:49:09', 'http://www.wuhuazai.com/uploadeview/166382737861717.jpg', 8);
INSERT INTO `headlines` VALUES (9, '诈骗案例（吴某）', '<p><b><span style=\"white-space:pre\">	</span>8月9日上午</b><br>\n<span style=\"white-space:pre\">	</span>吴某接到冒充反诈中心打来的电话，对方称其涉嫌贩卖假口罩，需要封吴某微信号、罚款，要吴某添加QQ配合调查。后吴某为了自证清白，按照对方的指示在一个链接里填写了银行卡号和手机验证码，被骗<font color=\"#ff0100\"><b>39万元</b>。</font></p>', '2022-09-14 11:05:47', 'http://www.wuhuazai.com/uploadeview/16638233581321.jpg', 8);
INSERT INTO `headlines` VALUES (10, '你的快递经过疫区被感染！请领取赔偿金！', '<h1><b>你的快递经过疫区被感染！请领取赔偿金！</b></h1>\n<p><b>疫情期间<br>\n</b>不管从何处来的快递先消毒总没错若是有一天你的快递被“感染”了你会怎么办？</p>\n<p>温州鹿城陈女士接到电话<br>\n自称某快递工作人员因陈女士的快递运送途中经过疫区被感染无法送达可提起300元赔偿。</p>\n<p><br>\n<b>**骗子电话**<br>\n</b>陈女士算算这快递也不过百元两倍多的赔偿很诱人于是爽快按照对方要求下载</p>\n<p>“亿联会议”APP进行沟通下载“与你”APP进行理赔</p>\n<p>\n接下来就是一招**偷天换日**陈女士打开手机银行输入对方提供的“赔付”银行卡号接着根据收到的“</p>\n<p>蚂蚁金融理赔系统”短信提示<br>\n实际上赔付卡号其实是收款账号认证码其实是转账金额**直到收到银行转账成功的短信提醒才发现自己中招了。</p>\n<p><br>\n<b>以上是典型的冒充客服诈骗</b></p>\n<div><br>\n</div>\n<div>这种骗术常居周报排行榜前三甲</div>', '2022-09-15 11:05:47', 'http://www.wuhuazai.com/uploadeview/16638234143336.jpg', 8);
INSERT INTO `headlines` VALUES (12, '诈骗案例（Z同学）', '<h1><b>诈骗案例（Z同学）</b></h1>\n<p><b>8月16上午</b><br>\n</p>\n<p>某学院某班Z同学三天前在“交易猫”平台上注册账号，并发布卖家“朝夕光年”的游戏账号（价格1000元，仅其投入游戏花费的成本价），</p>\n<p>随后接到一名伪装“买家”（骗子）的消息，骗子说想购买该账号；然而，骗子以不相信交易秩序（如果钱付了拿不到账号等情况为借口）为由，</p>\n<p>要求Z同学拨打所谓的“客服电话”，发给Z同学一个二维码要求其支付“第三方保证金”2000元；</p>\n<p>然而，Z同学在没有核实确认收款码情况下，向骗子转账了所谓的“第三方保证金”2000元。</p>\n<p>随后，3:00左右，<b>Z同学没收到骗子所承诺交易的1000元</b>。</p>', '2022-09-17 11:05:47', 'http://www.wuhuazai.com/uploadeview/16638248197444.jpg', 8);
INSERT INTO `headlines` VALUES (13, '诈骗案例（高校一员工）', '<h1>诈骗案例（高校一员工）</h1>\n<p><b>8月20日下午<br>\n</b></p>\n<p>某高校一员工被犯罪嫌疑人冒充京东客服以消除京东征信为名，又和骗子屏幕共享，</p>\n<p>在手机上操作几个银行APP贷款几十万，先后转账到骗子的账号约<b><font color=\"#ff0100\">68万元</font></b>。</p>', '2022-09-18 11:05:47', 'http://www.wuhuazai.com/uploadeview/16638249716747.jpg', 8);
INSERT INTO `headlines` VALUES (14, '诈骗案例（女职工）', '<p><b><span style=\"white-space:pre\">	</span>8月24日下午</b><br>\n<span style=\"white-space:pre\">	</span>近期宁波某集团公司一名女职工，因“投资＋刷单获利”为由被骗子诱导做任务，后来自己钱被骗光了，还四处网贷＋借钱，最后再问同事借20万元时候被提醒是否遇上诈骗才醒悟，直到报案时已累计被骗<b><font color=\"#ff0100\">35万元</font></b>。</p>\n<div><br>\n</div>', '2022-09-19 11:05:47', 'http://www.wuhuazai.com/uploadeview/16638237142822.jpg', 8);
INSERT INTO `headlines` VALUES (15, '诈骗案例（某学院学生）', '<p><b><span style=\"white-space:pre\">	</span>8月26日下午</b><br>\n<span style=\"white-space:pre\">	</span>某学院某班某生因接到网络骗子“以购物快递丢失货物赔钱\"，说她所购衣服快递丢失，骗子称“好心”将其衣服原价30元现赔付6倍总计180元打入她卡里，骗子以无法到账为由，要求其下载“上课宝”APP，按骗子要求操作且共享屏幕，还被要求开启花呗、京东白条（幸亏未启用）。在寝室接听语音通话时，同寝室女同学还告知可能是遇到骗子，该生未听从同学劝告，最后，该生还是给骗子一次性转账，被骗损失<font color=\"#ff0100\"><b>几千元</b>。</font></p>', '2022-09-20 11:05:47', 'http://www.wuhuazai.com/uploadeview/166382397228515.jpg', 8);
INSERT INTO `headlines` VALUES (16, '诈骗案例（黄先生）', '<p><b><span style=\"white-space:pre\">	</span>8月30日下午</b><br>\n<span style=\"white-space:pre\">	</span>黄先生在孩子的班级家长微信群中，15位家长看到“班主任”发布了一条信息，称需要收取418元购买学习资料，看到是“班主任”发的通知，名字头像也都对得上，群内几位家长陆续转账付款，黄先生看见别的家长都在交费，于是就跟着交了钱。<br>\n<span style=\"white-space:pre\">	</span>然而，黄先生发现这个“班主任”不是自己的好友，而他早已添加老师为微信好友，发现后已被骗。</p>', '2022-09-21 11:05:47', 'http://www.wuhuazai.com/uploadeview/16638240564855.jpg', 8);
INSERT INTO `headlines` VALUES (17, '诈骗案例（学院一同学）', '<p><b><span style=\"white-space:pre\">	</span>9月10日下午</b><br>\n</p>\n<p><span style=\"white-space:pre\">	</span>我校信息学院一同学被网友拉入了一个刷单群，出于好奇，该同学在群内观察了一段时间后，感觉这个刷单群不仅有“接待员”、“指导老师”，发布任务的同时还指导操作，看起来很专业，于是该同学通过群内链接注册了账号。开始刷单后，看到“账号”当即提示有“收益”。但是对方告知需继续刷4单才可提现，于是该同学又刷了4单后依旧无法提现。对方要求我继续刷单，这才被骗。</p>\n<p></p>', '2022-09-22 11:05:47', 'http://www.wuhuazai.com/uploadeview/166382411546414.jpg', 8);
INSERT INTO `headlines` VALUES (19, '诈骗案例（骆某）', '<div><span style=\"font-family: 黑体;\"><b>8月11日上午</b></span><br>\n</div>\n<div>骆某收到一个QQ好友申请，备注是社区新冠疫苗服务中心，其同意好友请求后，对方将其拉入一个群聊，称刷单可获取佣金。骆某点击群内链接下载“颗粒”APP领取任务，后因为“刷连单”、“账户冻结”等原因多次转账，被骗<b><font color=\"#ff0100\">10万元</font></b>。</div>', '2022-09-24 11:05:47', 'http://www.wuhuazai.com/uploadeview/166382476106920.jpg', 8);
INSERT INTO `headlines` VALUES (27, '诈骗分子通过QQ、微信、抖音或群发短信等渠道以诱人的广告吸引受害者兼职刷单', '<p><span style=\"white-space:pre\">	</span>诈骗分子通过QQ、微信、抖音或群发短信等渠道，以诱人的广告吸引受害者兼职刷单。诈骗分子通过QQ、微信、抖音或群发短信等渠道，以诱人的广告吸引受害者兼职刷单。诈骗分子获取信任后，刷单任务的金额会逐渐增加。然后平台会无法提现，甚至要求支付“保证金”、“解冻费”等。</p>\n<p><b><span style=\"white-space:pre\">	</span><font color=\"#ff0100\">「骗子惯用话术」<br>\n</font></b><span style=\"white-space:pre\">	</span><b>按照这上面我教您的取款,到账后记得跟我说一下,我这边需要报备,新人连续做满三单就能领取额外的188元奖励。</b></p>\n<p><b><span style=\"white-space:pre\">	</span><font color=\"#ff0100\">「温馨提示」<br>\n</font></b><span style=\"white-space:pre\">	</span><b>刷单诈骗多种多样，切勿贪小便宜吃大亏!</b></p>', '2022-09-22 13:46:42', 'http://www.wuhuazai.com/uploadeview/166382571931420.jpg', 6);
INSERT INTO `headlines` VALUES (28, '天上不会掉“馅饼”，更不会掉“骑着白马送蛋糕的王子”', '<p><span style=\"white-space:pre\">	</span>近日，利川的J女士收到一条微信好友验证消息，对方说自己叫“张昊远”，是通过珍爱网的红娘介绍的，J女士觉得可以先认识一 下，就通过了对方的好友验证。<br>\n<p>&nbsp; &nbsp;<span style=\"white-space:pre\">	</span>在接下来的聊天过程中，J女士分别就世界观、人生观、价值观等与对方进行了交谈，J女士发现“张昊远”的三观和自己很契合，甚至还略高一筹，是自己心目中那位可以引领自己走向成功的人。J女士也渐渐对“张昊远”产生了好感。<br>\n&nbsp; &nbsp;<span style=\"white-space:pre\">	</span>某天，“张昊远”把话题扯到了金钱观上，“张昊远”问J女士对理财是否感兴趣，J女士称自己近期正在学理财，还挺感兴趣的。就这样，绕了一大圈，“张昊远”终于将最重要的目的暴露出来。“张昊远”自称对理财很专业，并向J女士推荐了一款名为“上证环球”的投资平台。<br>\n&nbsp; &nbsp;<span style=\"white-space:pre\">	</span>前期，J女士试着小额投资，在“张昊远”的指导下在该平台购买美股试水，很快就盈利了1200元，并且可以顺利提现，这让J女士大为惊喜，便逐步加大投入。约一周后，J女士发现无法提现才发现自己被骗，共计损失63000元。</p>\n<p>&nbsp; <span style=\"white-space:pre\">	</span>&nbsp;<font color=\"#ff0100\">我后来了解到这叫“杀猪盘”类诈骗，网上认识的完美异性先进行嘘寒问暖，骗取信任后就带人投资骗钱，这温柔一刀，确实致命。想谈恋爱，又想发大财，这两个梦，骗子都给了我，但终究是一场梦，还是一场致命的噩梦！</font></p>\n<p>&nbsp; <span style=\"white-space:pre\">	</span>&nbsp;<b>天上不会掉“馅饼”，更不会掉“骑着白马送蛋糕的王子”。</b></p>\n</p>\n<div><br>\n</div>', '2022-09-22 13:49:06', 'http://www.wuhuazai.com/uploadeview/16638258535413.jpg', 6);
INSERT INTO `headlines` VALUES (29, '在手机上被骗10万需要几步？三步足以', '<p><span style=\"white-space:pre\">	</span><b>在手机上被骗10万需要几步？三步足以：加上陌生网友，通过网友给的链接下载App，听网友的话开始打钱。</b><br>\n<span style=\"white-space:pre\">	</span>短短三天内，山西小伙张某就这样被骗走了<font color=\"#ff0100\"><b>10万块</b></font>。<br>\n<span style=\"white-space:pre\">	</span>去年临近年关，张某收到一条陌生短信，短信上面显示：张XX（小伙名字）您好，您在我们店铺的快件已收，加微信号拿某品牌电饭煲一个。于是，张某加上微信，微信的头像是个青春貌美的少女，名为福利员-晓莹。随后晓莹就邀请张某进群，张某在群内抢到红包后，逐渐信任了该平台。这时，晓莹一步步引导，告诉张某想要赚取更多福利，就要通过给到的二维码下载一款App，刷单赚福利。如何能够赚到钱呢？该App里发布了所谓“抢多少元做多少元的任务”的抢单任务，成功抢单可以拿到30%的利润回扣。为了进一步引张某上钩，诈骗团伙继续给张某发“福利”，张某前期支付了总计7500元钱款做任务，同时赚了一笔大钱。两天后，“大单”如约而至。<br>\n<span style=\"white-space:pre\">	</span>张某抢到了10000元的订单，并向对方打款，但随后的任务过程中却不再那么顺利。张某收到了App里的提示，做错任务，需要重新操作，否则就无法回款。这种局面下，张某只好咬咬牙，继续支付了三笔费用，分别是20000元、50000元和20000元。对方坚称再交3000元才能取款。此时，张某才醒悟过来，自己被骗了。<br>\n<span style=\"white-space:pre\">	</span>后来，张某投诉到该App所冒名的知名公司，公司查证发现，张某是通过一个安全级别极低的渠道下载了该App。该App冒充某知名公司，借用该平台的影响力来欺骗用户，张某知道后悔不当初。<br>\n<span style=\"white-space:pre\">	</span>该平台工作人员告诉中国新闻周刊，手机应用分发存在灰色地带，一个二维码或一个链接，可能就关联到涉赌、涉诈类App。用户如果警惕性不高，或者犯罪分子手段稍微高明，就有可能禁不住诱惑，下载安装，被危及生命财产安全。</p>', '2022-09-22 13:51:14', 'http://www.wuhuazai.com/uploadeview/166382596590512.jpg', 6);
INSERT INTO `headlines` VALUES (30, '诈骗案例（某学院某班L同学）', '<p><span style=\"white-space:pre\">	</span><b>2022年4月6日8:30左右</b>，接到ZS派出所警官来电需要排查一名学生银行卡涉嫌诈骗资金非法转账记录。<br>\n<span style=\"white-space:pre\">	</span>经排查，某学院某班L同学于2022年2月8日在H省J市老家过寒假期间，其在网络上打游戏认识一位网友，但并不知道其对方真实身份和联系方式的情况下，以帮忙进行购买虚拟装备等名义，在不明真相的情况下，听从所谓的“网友”（骗子）向L同学借用个人农业银行卡进行转账，共收到骗子十余笔转账资金共计3000余元，并按照“网友”（骗子）的意图，通过L个人的支付宝、微信等方式转还<b><font color=\"#ff0100\">3000余元</font></b>给“网友”（骗子）的同伙，该生并未获取佣金；由于L同学的银行账号涉嫌资金来路不明及非法洗钱等原因被公安反诈平台监测到，并进行异地调查取证。随后，4月6日9:00左右在学院领导和班主任的陪同下到ZS派出所进行笔录询问和调查处理，并接受校方教育。</p>\n<div><br>\n</div>', '2022-09-22 13:53:42', 'http://www.wuhuazai.com/uploadeview/16638261587658.jpg', 6);
INSERT INTO `headlines` VALUES (31, '空手套白狼，这么好的网络刷单能赚大钱', '<p><span style=\"white-space:pre\">	</span>空手套白狼网络刷单案:近日，某学院某班某男生因网络刷单被骗7千元，被骗子拉进群（群里14个人，13个骗子团伙成员，1个学生小白），平白无故先刷单让你赚2000元，后面让你吐出来血本无归，最后反倒被骗转账2笔为<font color=\"#ff0100\"><b>2000元＋5000元</b></font>。</p>\n<p><span style=\"white-space:pre\">	</span><b>警示录</b>: 贪！大贪无厌！空手套白狼，这么好的网络刷单能赚大钱，你不是早该富得流油了吗？</p>', '2022-09-22 13:56:11', 'http://www.wuhuazai.com/uploadeview/166382631128014.jpg', 6);
INSERT INTO `headlines` VALUES (32, '骗子（商家）怎么这么好心会主动陪你六倍的钱呢？', '<p><span style=\"white-space:pre\">	</span><b>快递物品丢失赔偿案</b>: 近日，某学院某班某生因接到网络骗子“以购物快递丢失货物赔钱\"，说她所购衣服快递丢失，骗子称“好心”将其衣服原价30元现赔付6倍总计180元打入她卡里，骗子以无法到账为由，要求其下载“上课宝”APP，按骗子要求操作且共享屏幕，还被要求开启花呗、京东白条（幸亏未启用）。在寝室接听语音通话时，同寝室女同学还告知可能是遇到骗子，该生未听从同学劝告，最后，该生还是给骗子一次性转账，被骗损失<font color=\"#ff0100\"><b>几千元</b></font>。</p>\n<p>&nbsp; &nbsp; &nbsp; &nbsp;<b>警示录</b>: 贪！小贪巨损！正规购物网站的信息不会查验一下？真假信息不辨别，骗子（商家）怎么这么好心会主动陪你六倍的钱呢？还会让你转账？你想过吗？是自己太糊涂啦！</p>', '2022-09-22 14:00:00', 'http://www.wuhuazai.com/uploadeview/166382645604415.jpg', 6);
INSERT INTO `headlines` VALUES (33, '骗子、“裸聊、约炮”', '<p><span style=\"white-space:pre\">	</span>近期骗子以“裸聊、约炮”等诱饵拉学生进群，参与刷单网上赌博导致被骗案件严重，6月初以来涉及高校的相关诈骗案件已发生多起，最高被骗3万多元。</p>\n<p><span style=\"white-space:pre\">	</span><b>请各位同学：首先要洁身自好，网上交友要谨慎；其次切不可因“色”昏头而中了骗子的骗局导致自己被骗。\n    </b></p>', '2022-09-22 14:01:14', 'http://www.wuhuazai.com/uploadeview/166382652460316.jpg', 6);
INSERT INTO `headlines` VALUES (34, '网购月饼有质量问题？？？', '<p><span style=\"white-space:pre\">	</span><b>以“网购月饼有质量问题”为由实施诈骗：</b><br>\n<span style=\"white-space:pre\">	</span>节日期间，要警惕诈骗分子冒充电商平台客服工作人员，谎称购买的月饼等商品存在质量问题，需要按照其要求办理退款或理赔。但实际上是诱骗消费者缴纳各种手续费用，或者以操作失误需要解冻、配合为由骗取钱财。</p>\n<div><br>\n</div>', '2022-09-22 14:02:27', 'http://www.wuhuazai.com/uploadeview/166382672870811.jpg', 6);
INSERT INTO `headlines` VALUES (36, '航班取消可办理退票诈骗', '<p><span style=\"white-space:pre\">	</span>以“<b>航班取消可办理退票</b>”为由实施诈骗：<br>\n<span style=\"white-space:pre\">	</span>节日期间，要警惕不法分子冒充航空客服人员实施诈骗。不法分子会向旅客发送诈骗短信，声称航班取消需办理免费退票，但需要交纳相关手续费。然后，告知旅客退款时银行卡存在问题，需电话联系发送授权，进而套取旅客隐私资料等。</p>', '2022-09-22 14:07:36', 'http://www.wuhuazai.com/uploadeview/16638268886529.jpg', 6);
INSERT INTO `headlines` VALUES (38, '虚假投资理财（杀猪盘）', '<p><span style=\"white-space:pre\">	</span>梁某在交友APP上认识一个网友，后双方在网上聊天确立为情侣关系。对方称自己有内部消息，让梁某下载“夸克”APP并在里面充值投资新冠疫苗的基金，梁某多次转账最后发现无法提现，被骗<b><font color=\"#ff0100\">39万元</font></b>。\n    </p>', '2022-09-22 14:31:29', 'http://www.wuhuazai.com/uploadeview/16638283208153.jpg', 6);

-- ----------------------------
-- Table structure for headlineslike
-- ----------------------------
DROP TABLE IF EXISTS `headlineslike`;
CREATE TABLE `headlineslike`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user` int NULL DEFAULT NULL COMMENT '头条点赞的用户(外键)',
  `headlines` int NULL DEFAULT NULL COMMENT '点赞的头条(外键)',
  `likeType` int NULL DEFAULT NULL COMMENT '点赞、收藏(外键)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_headlineslike_user_user`(`user` ASC) USING BTREE,
  INDEX `fk_headlineslike_headlines_headlines`(`headlines` ASC) USING BTREE,
  INDEX `fk_headlineslike_likeType`(`likeType` ASC) USING BTREE,
  CONSTRAINT `fk_headlineslike_headlines_headlines` FOREIGN KEY (`headlines`) REFERENCES `headlines` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_headlineslike_likeType` FOREIGN KEY (`likeType`) REFERENCES `liketype` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_headlineslike_user_user` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 114 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of headlineslike
-- ----------------------------
INSERT INTO `headlineslike` VALUES (1, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (3, 4, 3, 1);
INSERT INTO `headlineslike` VALUES (4, 5, 4, 1);
INSERT INTO `headlineslike` VALUES (5, 6, 5, 1);
INSERT INTO `headlineslike` VALUES (6, 8, 6, 1);
INSERT INTO `headlineslike` VALUES (7, 14, 7, 1);
INSERT INTO `headlineslike` VALUES (8, 15, 34, 1);
INSERT INTO `headlineslike` VALUES (9, 16, 2, 1);
INSERT INTO `headlineslike` VALUES (10, 17, 3, 1);
INSERT INTO `headlineslike` VALUES (11, 18, 4, 1);
INSERT INTO `headlineslike` VALUES (12, 2, 5, 1);
INSERT INTO `headlineslike` VALUES (13, 4, 6, 2);
INSERT INTO `headlineslike` VALUES (14, 5, 7, 2);
INSERT INTO `headlineslike` VALUES (15, 6, 34, 2);
INSERT INTO `headlineslike` VALUES (16, 8, 2, 2);
INSERT INTO `headlineslike` VALUES (17, 14, 3, 2);
INSERT INTO `headlineslike` VALUES (18, 15, 3, 2);
INSERT INTO `headlineslike` VALUES (19, 16, 3, 2);
INSERT INTO `headlineslike` VALUES (20, 17, 3, 2);
INSERT INTO `headlineslike` VALUES (21, 18, 3, 2);
INSERT INTO `headlineslike` VALUES (22, 2, 3, 1);
INSERT INTO `headlineslike` VALUES (23, 4, 3, 1);
INSERT INTO `headlineslike` VALUES (24, 5, 3, 1);
INSERT INTO `headlineslike` VALUES (25, 6, 3, 1);
INSERT INTO `headlineslike` VALUES (26, 8, 4, 1);
INSERT INTO `headlineslike` VALUES (27, 14, 4, 2);
INSERT INTO `headlineslike` VALUES (28, 15, 4, 1);
INSERT INTO `headlineslike` VALUES (29, 16, 4, 1);
INSERT INTO `headlineslike` VALUES (30, 17, 4, 1);
INSERT INTO `headlineslike` VALUES (31, 18, 4, 2);
INSERT INTO `headlineslike` VALUES (32, 2, 4, 1);
INSERT INTO `headlineslike` VALUES (33, 4, 4, 1);
INSERT INTO `headlineslike` VALUES (34, 5, 4, 1);
INSERT INTO `headlineslike` VALUES (35, 6, 3, 1);
INSERT INTO `headlineslike` VALUES (36, 8, 5, 2);
INSERT INTO `headlineslike` VALUES (37, 14, 6, 1);
INSERT INTO `headlineslike` VALUES (38, 15, 6, 1);
INSERT INTO `headlineslike` VALUES (39, 16, 6, 1);
INSERT INTO `headlineslike` VALUES (40, 17, 6, 2);
INSERT INTO `headlineslike` VALUES (41, 18, 6, 1);
INSERT INTO `headlineslike` VALUES (42, 2, 6, 1);
INSERT INTO `headlineslike` VALUES (43, 4, 5, 1);
INSERT INTO `headlineslike` VALUES (46, 5, 5, 1);
INSERT INTO `headlineslike` VALUES (47, 6, 7, 2);
INSERT INTO `headlineslike` VALUES (48, 8, 34, 1);
INSERT INTO `headlineslike` VALUES (49, 14, 34, 1);
INSERT INTO `headlineslike` VALUES (51, 2, 3, 1);
INSERT INTO `headlineslike` VALUES (52, 2, 3, 1);
INSERT INTO `headlineslike` VALUES (53, 2, 3, 1);
INSERT INTO `headlineslike` VALUES (54, 2, 3, 1);
INSERT INTO `headlineslike` VALUES (55, 2, 3, 1);
INSERT INTO `headlineslike` VALUES (56, 2, 3, 1);
INSERT INTO `headlineslike` VALUES (57, 4, 2, 1);
INSERT INTO `headlineslike` VALUES (61, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (62, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (63, 4, 2, 1);
INSERT INTO `headlineslike` VALUES (64, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (65, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (66, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (67, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (68, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (69, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (70, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (72, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (74, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (75, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (76, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (77, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (78, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (86, 4, 2, 1);
INSERT INTO `headlineslike` VALUES (89, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (90, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (91, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (92, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (93, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (94, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (95, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (96, 19, 2, 1);
INSERT INTO `headlineslike` VALUES (97, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (98, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (99, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (100, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (101, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (102, 4, 2, 1);
INSERT INTO `headlineslike` VALUES (103, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (104, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (105, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (106, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (107, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (108, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (109, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (110, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (111, 2, 2, 1);
INSERT INTO `headlineslike` VALUES (112, 18, 4, 1);
INSERT INTO `headlineslike` VALUES (113, 18, 4, 2);

-- ----------------------------
-- Table structure for headlinessay
-- ----------------------------
DROP TABLE IF EXISTS `headlinessay`;
CREATE TABLE `headlinessay`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `say` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '评论内容',
  `date` datetime NULL DEFAULT NULL COMMENT '评论时间',
  `user` int NULL DEFAULT NULL COMMENT '评论用户(外键)',
  `headlines` int NULL DEFAULT NULL COMMENT '评论头条(外键)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_headlinesSay_user_1`(`user` ASC) USING BTREE,
  INDEX `fk_headlinesSay_headlines_1`(`headlines` ASC) USING BTREE,
  CONSTRAINT `fk_headlinesSay_headlines_1` FOREIGN KEY (`headlines`) REFERENCES `headlines` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_headlinesSay_user_1` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '头条评论记录表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of headlinessay
-- ----------------------------
INSERT INTO `headlinessay` VALUES (1, '【这就是帮信犯罪】“两部手机一根音频线，每天开机轻松赚钱”这样的兼职工作可别干！', '2022-05-12 08:00:00', 2, 2);
INSERT INTO `headlinessay` VALUES (3, '天下没有免费的午餐，记住这点就不会被骗', '2022-05-12 08:00:00', 2, 3);
INSERT INTO `headlinessay` VALUES (4, '骗子最担心最害怕的就是国家实行银行卡取款转账人脸识别制度，因为他们买来的银行卡无法通过人脸识别将变成废卡就骗不到钱了', '2022-09-07 16:24:21', 2, 4);
INSERT INTO `headlinessay` VALUES (5, '可不可以放开下载视频呢？不然转给老人她点不来', '2022-09-20 19:07:46', 4, 5);
INSERT INTO `headlinessay` VALUES (6, '转发微博', '2022-09-21 19:07:49', 5, 6);
INSERT INTO `headlinessay` VALUES (7, '免费送鸡蛋背后的套路，你了解多少？', '2022-09-22 19:07:52', 6, 7);
INSERT INTO `headlinessay` VALUES (8, '警察蜀黎帅哦', '2022-09-23 19:07:55', 17, 34);
INSERT INTO `headlinessay` VALUES (9, '【守住养老钱，幸福享晚年】', '2022-09-24 19:07:59', 15, 2);
INSERT INTO `headlinessay` VALUES (10, '擦亮双眼，谨防被骗！', '2022-09-25 19:08:02', 16, 3);
INSERT INTO `headlinessay` VALUES (11, '家庭情况要保密，涉及钱财要小心；', '2022-09-26 19:08:05', 17, 4);
INSERT INTO `headlinessay` VALUES (12, '短信诈骗花样多，不予理睬准没错；', '2022-09-27 19:08:08', 18, 5);
INSERT INTO `headlinessay` VALUES (13, '邮包违禁不要慌，医保欠费要骗你；', '2022-09-28 19:08:12', 16, 2);
INSERT INTO `headlinessay` VALUES (14, '电信欠费要核实，来电信息需辨清；', '2022-09-29 19:08:15', 4, 7);
INSERT INTO `headlinessay` VALUES (15, '公安法院来电紧，回拨号码查仔细；', '2022-09-30 19:08:20', 5, 34);
INSERT INTO `headlinessay` VALUES (16, '亲属出事别轻信，骗取钱财是目的；', '2022-10-01 19:08:23', 6, 3);
INSERT INTO `headlinessay` VALUES (19, '楼主说的很对，处处是陷阱，处处得提防', '2022-05-12 00:00:00', 2, 2);
INSERT INTO `headlinessay` VALUES (24, '\n阿白891\n这些诈骗集团胆子越来越大，手段越来越高明', '2022-09-23 13:49:46', 18, 2);
INSERT INTO `headlinessay` VALUES (25, '你这几条总结的好，是现在最流行的几种诈骗套路没错了，希望多一些人看到提高警惕。我现在看到有陌生电话都不太敢接，总觉得是诈骗。', '2022-09-23 13:53:55', 20, 2);
INSERT INTO `headlinessay` VALUES (26, '如果早看见这个，我相信我会自动忽略，没受过伤害的人永远不会去在意这些的', '2022-09-23 13:56:47', 19, 3);
INSERT INTO `headlinessay` VALUES (27, '每个人都要提高防范意识。虽然我亲身经历了诈骗，但看了这篇文章还是有很多收获，感谢罗罗。', '2022-09-23 13:57:07', 17, 3);
INSERT INTO `headlinessay` VALUES (28, '我认为道理站在你的说法，不是自己错在没有预防意识，而是错在一颗对钱持有不费吹灰之力就可以拿到的贪心', '2022-09-23 13:58:27', 15, 3);
INSERT INTO `headlinessay` VALUES (29, '买卖银行卡的是关键，国家目前搞断卡行动', '2022-09-23 14:03:29', 4, 4);
INSERT INTO `headlinessay` VALUES (30, '谨记防止诈骗发生', NULL, 4, 2);
INSERT INTO `headlinessay` VALUES (31, '谨防受骗', NULL, 18, 4);

-- ----------------------------
-- Table structure for headlinessaylike
-- ----------------------------
DROP TABLE IF EXISTS `headlinessaylike`;
CREATE TABLE `headlinessaylike`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user` int NULL DEFAULT NULL COMMENT '头条点赞的用户(外键)',
  `headlinesSay` int NULL DEFAULT NULL COMMENT '被用户点赞的头条(外键)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_headlinesSayLike_user_1`(`user` ASC) USING BTREE,
  INDEX `fk_headlinesSayLike_headlinesSay_1`(`headlinesSay` ASC) USING BTREE,
  CONSTRAINT `fk_headlinesSayLike_headlinesSay_1` FOREIGN KEY (`headlinesSay`) REFERENCES `headlinessay` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_headlinesSayLike_user_1` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '头条点赞记录表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of headlinessaylike
-- ----------------------------
INSERT INTO `headlinessaylike` VALUES (1, 2, 1);
INSERT INTO `headlinessaylike` VALUES (3, 4, 3);
INSERT INTO `headlinessaylike` VALUES (4, 5, 4);
INSERT INTO `headlinessaylike` VALUES (5, 6, 5);
INSERT INTO `headlinessaylike` VALUES (6, 8, 6);
INSERT INTO `headlinessaylike` VALUES (7, 15, 7);
INSERT INTO `headlinessaylike` VALUES (8, 16, 8);
INSERT INTO `headlinessaylike` VALUES (9, 17, 9);
INSERT INTO `headlinessaylike` VALUES (10, 18, 10);
INSERT INTO `headlinessaylike` VALUES (12, 2, 11);
INSERT INTO `headlinessaylike` VALUES (13, 4, 1);
INSERT INTO `headlinessaylike` VALUES (14, 5, 3);
INSERT INTO `headlinessaylike` VALUES (15, 6, 4);
INSERT INTO `headlinessaylike` VALUES (17, 8, 5);
INSERT INTO `headlinessaylike` VALUES (18, 15, 6);
INSERT INTO `headlinessaylike` VALUES (19, 16, 7);
INSERT INTO `headlinessaylike` VALUES (20, 17, 8);
INSERT INTO `headlinessaylike` VALUES (21, 18, 9);
INSERT INTO `headlinessaylike` VALUES (22, 2, 10);
INSERT INTO `headlinessaylike` VALUES (23, 4, 11);
INSERT INTO `headlinessaylike` VALUES (24, 5, 1);
INSERT INTO `headlinessaylike` VALUES (25, 6, 3);
INSERT INTO `headlinessaylike` VALUES (26, 8, 4);
INSERT INTO `headlinessaylike` VALUES (28, 15, 5);
INSERT INTO `headlinessaylike` VALUES (29, 16, 6);
INSERT INTO `headlinessaylike` VALUES (30, 17, 7);
INSERT INTO `headlinessaylike` VALUES (31, 18, 8);
INSERT INTO `headlinessaylike` VALUES (32, 2, 9);

-- ----------------------------
-- Table structure for in
-- ----------------------------
DROP TABLE IF EXISTS `in`;
CREATE TABLE `in`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `in` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '校内/校外',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of in
-- ----------------------------
INSERT INTO `in` VALUES (1, '校内');
INSERT INTO `in` VALUES (2, '校外');

-- ----------------------------
-- Table structure for institute
-- ----------------------------
DROP TABLE IF EXISTS `institute`;
CREATE TABLE `institute`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `institute` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '用户所属学院',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '学院头像',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户所属学院' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of institute
-- ----------------------------
INSERT INTO `institute` VALUES (1, '信息学院', 'http://www.wuhuazai.com/uploadeview/1663914249322coll01.png');
INSERT INTO `institute` VALUES (2, '设计学院', 'http://www.wuhuazai.com/uploadeview/1663914617237coll02.png');
INSERT INTO `institute` VALUES (3, '商学院', 'http://www.wuhuazai.com/uploadeview/1663914418749coll03.png');
INSERT INTO `institute` VALUES (5, '国际交流学院', 'http://www.wuhuazai.com/uploadeview/1663914689205coll04.png');
INSERT INTO `institute` VALUES (6, '艺术学院', 'http://www.wuhuazai.com/uploadeview/1663914561737coll06.png');
INSERT INTO `institute` VALUES (7, '时尚设计学院', 'http://www.wuhuazai.com/uploadeview/1663914782875coll05.png');
INSERT INTO `institute` VALUES (8, '国际教育学院', 'http://www.wuhuazai.com/uploadeview/1663914817411coll07.png');

-- ----------------------------
-- Table structure for join
-- ----------------------------
DROP TABLE IF EXISTS `join`;
CREATE TABLE `join`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user` int NULL DEFAULT NULL COMMENT '参与用户(外键)',
  `activity` int NULL DEFAULT NULL COMMENT '参与活动(外键)',
  `examine` int NULL DEFAULT 1 COMMENT '审核状态(外键)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_join_user`(`user` ASC) USING BTREE,
  INDEX `fk_join_activity`(`activity` ASC) USING BTREE,
  INDEX `fk_join_examine`(`examine` ASC) USING BTREE,
  CONSTRAINT `fk_join_activity` FOREIGN KEY (`activity`) REFERENCES `activity` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_join_examine` FOREIGN KEY (`examine`) REFERENCES `examine` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_join_user` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of join
-- ----------------------------
INSERT INTO `join` VALUES (7, 2, 1, 2);
INSERT INTO `join` VALUES (10, 6, 3, 2);
INSERT INTO `join` VALUES (11, 8, 4, 2);
INSERT INTO `join` VALUES (12, 15, 5, 1);
INSERT INTO `join` VALUES (13, 16, 6, 3);
INSERT INTO `join` VALUES (14, 17, 13, 1);
INSERT INTO `join` VALUES (15, 18, 18, 2);
INSERT INTO `join` VALUES (17, 2, 3, 2);
INSERT INTO `join` VALUES (18, 6, 3, 3);
INSERT INTO `join` VALUES (19, 8, 3, 2);
INSERT INTO `join` VALUES (20, 15, 3, 2);
INSERT INTO `join` VALUES (21, 16, 3, 3);
INSERT INTO `join` VALUES (22, 17, 3, 2);
INSERT INTO `join` VALUES (23, 2, 6, 1);
INSERT INTO `join` VALUES (24, 2, 4, 1);
INSERT INTO `join` VALUES (25, 4, 4, 1);
INSERT INTO `join` VALUES (26, 19, 19, 1);
INSERT INTO `join` VALUES (30, 4, 6, 1);
INSERT INTO `join` VALUES (31, 4, 6, 1);
INSERT INTO `join` VALUES (32, 6, 1, 1);
INSERT INTO `join` VALUES (33, 6, 3, 2);
INSERT INTO `join` VALUES (37, 2, 6, 1);
INSERT INTO `join` VALUES (38, 2, 6, 1);
INSERT INTO `join` VALUES (39, 2, 6, 1);
INSERT INTO `join` VALUES (40, 2, 1, 1);
INSERT INTO `join` VALUES (41, 4, 28, 1);
INSERT INTO `join` VALUES (42, 2, 28, 3);
INSERT INTO `join` VALUES (43, 15, 28, 1);
INSERT INTO `join` VALUES (44, 16, 28, 2);

-- ----------------------------
-- Table structure for liketype
-- ----------------------------
DROP TABLE IF EXISTS `liketype`;
CREATE TABLE `liketype`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `likeType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '点赞or收藏',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of liketype
-- ----------------------------
INSERT INTO `liketype` VALUES (1, '点赞');
INSERT INTO `liketype` VALUES (2, '收藏');

-- ----------------------------
-- Table structure for machine
-- ----------------------------
DROP TABLE IF EXISTS `machine`;
CREATE TABLE `machine`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `keyword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lock` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of machine
-- ----------------------------
INSERT INTO `machine` VALUES (1, '电信诈骗', '电信诈骗是指通过电话、网络和短信方式，编造虚假信息，设置骗局，对受害人实施远程、非接触式诈骗，诱使受害人打款或转账的犯罪行为，通常以冒充他人及仿冒、伪造各种合法外衣和形式的方式达到欺骗的目的。\r\n');
INSERT INTO `machine` VALUES (2, '通讯诈骗', '2014年5月6日，四川省公安厅刑侦局致函四川电信，正式将‘电信诈骗’犯罪的称谓改为‘通讯诈骗’犯罪。其函中明确，“针对贵公司来函（中电信川函[2014]10号）恳请我厅重新规范有关电信诈骗犯罪用语一事，省厅刑侦局高度重视，遵照厅领导指示精神，就贵公司提出的更名诉求进行了认真讨论研究，借鉴了其他省市做法，并征求了相关警种意见，达成了共识，拟逐步在我省范围内将‘电信诈骗’犯罪的称谓改为‘通讯诈骗’犯罪。”\r\n');
INSERT INTO `machine` VALUES (3, '诈骗罪', '诈骗罪是指以非法占有为目的，使用欺骗方法，骗取数额较大的公私财物的行为。\r\n');
INSERT INTO `machine` VALUES (4, '包裹骗局', '包裹骗局，一种经济犯罪的骗局，罪犯冒充邮局和刑侦人员对受害人进行经济诈骗。\r\n');
INSERT INTO `machine` VALUES (5, '网络诈骗', '网络诈骗是指以非法占有为目的，利用互联网采用虚构事实或者隐瞒真相的方法，骗取数额较大的公私财物的行为。\r\n其花样繁多，行骗手法日新月异，常用手段有假冒好友、网络钓鱼、网银升级诈骗等，主要特点有空间虚拟化、行为隐蔽化等。');
INSERT INTO `machine` VALUES (6, '如何防诈骗\r\n', '1.下载好“国家反诈中心”app2.一定要开启来电、短信预警3.如有预警提示要引起重视4.如发现被骗请及时拨打96110报警求助！\r\n');
INSERT INTO `machine` VALUES (7, '诈骗主要犯罪手法\r\n', '冒充公检法等机关工作人员，谎称受害人名下银行账户、电话卡、社保卡、医保卡等被冒用，或者身份信息被泄露，或者涉嫌洗钱、非法出入境、快递包裹藏毒等违法犯罪，以此要求受害人将资金转入“安全账户”配合调查或接受监管，进而实施诈骗。为增加可信度，一些诈骗分子会向受害人展示虚假公检法网站上发布的假通缉令等法律文书。为远程获取受害人手机上的个人信息，诈骗分子常常要求受害人下载具有屏幕共享功能的APP。为使受害人处于完全被操控状态，诈骗分子还会诱骗受害人到酒店等封闭空间，阻断所有短信、来电等外界联系。公安机关工作中发现，一些诈骗分子还会冒充不同部门的政府机关工作人员，以领取补助补贴、奖学金，医保卡、证券、金融账户被冻结，出入境证件异常、失效等为由实施诈骗。特别是近期一些诈骗分子以受害人涉嫌散布疫情谣言、贩卖假口罩、违反疫情防控规定等为由进行诈骗，影响恶劣。\r\n');
INSERT INTO `machine` VALUES (8, '预防诈骗\r\n', '1.第一就是不要轻易点击短信里面的链接，这里面很有可能就是盗取银行卡信息密码的网站，所以不管是什么短信都不要理会。\r\n2.第二就是朋友在网上找自己借钱，不过需要在网上直接转账的就需要注意了，一定要确定是本人，那么就需要打电话确定才行。\r\n3.第三就是不要在陌生网站输入自己的名字和一些重要信息，因为陌生网站会根据你所填写的信息也能盗取钱财。\r\n4.第四就是不要随便相信网上聊天的人，网上聊天虽然能够打发平时无聊的时间，那么必须要有火眼精金，不能相信网上之人。');
INSERT INTO `machine` VALUES (9, '裸聊', '\r\n\r\n\r\n\r\n\r\n裸聊是指两个以上的行为人利用现代高技术传媒手段，借助网络视频设备及聊天工具，在各自网络终端的摄像头下展示裸体或者玩弄相关身体部位，并将其视频图像即时传输给对方，同时配以大胆露骨的文字和动作，以此方式进行性交流的行为。\r\n社会危害：1.污染了网络世界：网络是传播知识和文化的阵地，是人类进行教育与自我教育的重要场所，裸聊的出现，使网络世界的秩序遭到破坏，淫秽之气风靡，网络危机四伏。\r\n2.对青少年造成不良后果：青少年世界观、人生观尚未形成，裸聊对于他们来说具有很大的诱惑力，严重腐蚀他们的心灵，带来心理、生理以及智力的负面影响，从而无法正常学习。\r\n3.引发其他犯罪行为：裸聊不仅是一种违反道德的行为，而且也是其他犯罪行为的导火线，裸聊可能诱发诈骗、强奸、敲诈勒索等犯罪行为的发生，对当事人造成的后果不堪设想。');
INSERT INTO `machine` VALUES (10, '兼职刷单', '在很多QQ群、微信群里，兼职刷单的信息并不陌生，这些信息号称“足不出户、日入斗金”“点点鼠标、轻松赚钱”。而实际上，在这些信息背后，却是不法分子在实施网络电信诈骗，受骗者少则被骗几百元至上千元，多则损失数十万元。这种利用网络虚假交易方式刷单的行为，本身就是商业欺诈，绝大多数网络兼职刷单工作都是诈骗。市民在网上找工作要坚持做到“四不要”：一是不要轻易在网上透露自己个人信息，特别是银行账户、密码、支付宝账号等，增强防范意识；是否想搜索【诈骗类型】、【被骗了怎么办】');
INSERT INTO `machine` VALUES (11, '诈骗类型', '1\r\n刷单诈骗\r\n\r\n2\r\n网贷诈骗\r\n\r\n3\r\n冒充公安检法人员诈骗\r\n\r\n4\r\n冒充客户诈骗\r\n\r\n5\r\n网络游戏买装备、账号诈骗\r\n警示：电话、QQ、微信都能假冒，莫要轻信他人身份。天下不会掉馅饼，莫要碰不懂的项目。莫要拆东墙补西墙，债滚债还不起，莫要外借各种证件，空白合同需谨慎。使用正规途径进行兼职实习，莫透露密码、验证码，不明链接莫点开。投资风险需谨慎，稳赚不赔不可能。眼见不一定为实，莫轻信莫转账。\r\n是否想搜索【防诈骗六不要】、【被骗了怎么办】');
INSERT INTO `machine` VALUES (12, '被骗了怎么办', '1.保持冷静，确定损失\r\n2.尽快报警，防止二次受骗\r\n确定了损失之后，尽快报警，切不可再联系网络诈骗者，防止二次受骗。有的受害者挽回损失心切，未经报案便私下联系网络诈骗者，\r\n甚至轻信其提供的退款、退物的谎言，二次受骗，使损失进一步扩大。\r\n3.如实反映案件情况\r\n有的受害人因受到网络诈骗而感到懊悔和羞愧，很少报案，或者即使报案也对案件事实有所隐瞒，这将会给公安机关破案增加难度。\r\n为了尽快抓住犯罪嫌疑人，挽回损失，请在报案后，向办案民警如实反映案件情况。');

-- ----------------------------
-- Table structure for opacity
-- ----------------------------
DROP TABLE IF EXISTS `opacity`;
CREATE TABLE `opacity`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `opacity` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '帖子可见度(0-自己, 1-公开)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '帖子可见度' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of opacity
-- ----------------------------
INSERT INTO `opacity` VALUES (1, '可见');
INSERT INTO `opacity` VALUES (2, '不可见');

-- ----------------------------
-- Table structure for points
-- ----------------------------
DROP TABLE IF EXISTS `points`;
CREATE TABLE `points`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `number` int NULL DEFAULT NULL COMMENT '积分数量',
  `info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '积分详情',
  `user` int NULL DEFAULT NULL COMMENT '积分用户(外键)',
  `add` int NULL DEFAULT 8 COMMENT '执行用户(外键)',
  `type` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_points_user_1`(`user` ASC) USING BTREE,
  INDEX `fk_points_user_2`(`add` ASC) USING BTREE,
  INDEX `fk_points_pointsType`(`type` ASC) USING BTREE,
  CONSTRAINT `fk_points_pointsType` FOREIGN KEY (`type`) REFERENCES `pointstype` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_points_user_1` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_points_user_2` FOREIGN KEY (`add`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 625 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户积分表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of points
-- ----------------------------
INSERT INTO `points` VALUES (2, 100, '签退', 5, 8, 1);
INSERT INTO `points` VALUES (4, 200, '签到', 8, 8, 4);
INSERT INTO `points` VALUES (5, 40, '阅读防诈骗文章', 2, 8, 4);
INSERT INTO `points` VALUES (6, 30, '阅读防诈骗文章', 6, 8, 2);
INSERT INTO `points` VALUES (7, -12, '兑换一号礼物', 5, 8, 1);
INSERT INTO `points` VALUES (8, -12, '兑换一号礼物', 5, 8, 1);
INSERT INTO `points` VALUES (9, -12, '兑换一号礼物', 5, 8, NULL);
INSERT INTO `points` VALUES (10, -10, '兑换优惠券', 2, 8, NULL);
INSERT INTO `points` VALUES (11, -10, '兑换优惠劵', 5, 8, 6);
INSERT INTO `points` VALUES (13, -10, '优惠券', 2, 8, 5);
INSERT INTO `points` VALUES (14, 200, '签到', 5, 2, 4);
INSERT INTO `points` VALUES (15, 200, '签退', 5, 2, 2);
INSERT INTO `points` VALUES (16, 200, '签到', 5, 2, 1);
INSERT INTO `points` VALUES (22, 2, '阅读防诈骗文章', 2, 8, 6);
INSERT INTO `points` VALUES (23, 2, '阅读防诈骗文章', 2, 8, 5);
INSERT INTO `points` VALUES (24, 2, '签退', 2, 8, 4);
INSERT INTO `points` VALUES (25, 2, '签退', 2, 8, 2);
INSERT INTO `points` VALUES (26, 3, '签到', 2, 8, 1);
INSERT INTO `points` VALUES (27, 2, '大学生防骗安全知识001', 2, 8, 6);
INSERT INTO `points` VALUES (28, 2, '紧急预警', 2, 8, 4);
INSERT INTO `points` VALUES (29, 2, '大学生防骗安全知识001', 2, 8, 5);
INSERT INTO `points` VALUES (30, 2, '紧急预警', 2, 8, 2);
INSERT INTO `points` VALUES (31, 2, '大学生防骗安全知识001', 2, 8, 1);
INSERT INTO `points` VALUES (32, 2, '紧急预警', 2, 8, 6);
INSERT INTO `points` VALUES (33, 2, '紧急预警', 2, 8, 5);
INSERT INTO `points` VALUES (34, 2, '阅读防诈骗文章', 2, 8, 4);
INSERT INTO `points` VALUES (35, 2, '紧急预警', 2, 8, 2);
INSERT INTO `points` VALUES (36, 2, '大学生防骗安全知识001', 2, 8, 1);
INSERT INTO `points` VALUES (37, 2, '紧急预警', 2, 8, 2);
INSERT INTO `points` VALUES (38, 2, '紧急预警', 2, 8, 2);
INSERT INTO `points` VALUES (39, 2, '紧急预警', 2, 8, 2);
INSERT INTO `points` VALUES (40, 2, '阅读防诈骗文章', 2, 8, 2);
INSERT INTO `points` VALUES (41, 2, '紧急预警', 2, 8, 1);
INSERT INTO `points` VALUES (42, 2, '防诈骗大学习', 2, 8, 1);
INSERT INTO `points` VALUES (43, 2, '阅读防诈骗文章', 2, 8, 2);
INSERT INTO `points` VALUES (44, 2, '紧急预警', 2, 8, 4);
INSERT INTO `points` VALUES (45, 2, '阅读防诈骗文章', 2, 8, 5);
INSERT INTO `points` VALUES (46, 2, '紧急预警', 2, 8, 6);
INSERT INTO `points` VALUES (47, 2, '防诈骗大学习', 2, 8, 6);
INSERT INTO `points` VALUES (48, 2, '大学生防骗安全知识001', 2, 8, 6);
INSERT INTO `points` VALUES (49, 2, '紧急预警', 2, 8, 6);
INSERT INTO `points` VALUES (50, 2, '阅读防诈骗文章', 2, 8, 5);
INSERT INTO `points` VALUES (51, 2, '大学生防骗安全知识001', 2, 8, 6);
INSERT INTO `points` VALUES (52, 2, '阅读防诈骗文章', 2, 8, 4);
INSERT INTO `points` VALUES (53, 2, '防诈骗大学习', 2, 8, 2);
INSERT INTO `points` VALUES (54, 2, '阅读防诈骗文章', 2, 8, 1);
INSERT INTO `points` VALUES (55, 2, '阅读防诈骗文章', 2, 8, 5);
INSERT INTO `points` VALUES (56, 2, '阅读防诈骗文章', 2, 8, 4);
INSERT INTO `points` VALUES (57, 2, '大学生防骗安全知识001', 2, 8, 2);
INSERT INTO `points` VALUES (58, 2, '阅读防诈骗文章', 2, 8, 2);
INSERT INTO `points` VALUES (59, 2, '大学生防骗安全知识001', 2, 8, 2);
INSERT INTO `points` VALUES (60, 2, '大学生防骗安全知识001', 2, 8, 2);
INSERT INTO `points` VALUES (61, 2, '大学生防骗安全知识001', 2, 8, 1);
INSERT INTO `points` VALUES (62, 2, '阅读防诈骗文章', 2, 8, 1);
INSERT INTO `points` VALUES (63, 2, '大学生防骗安全知识001', 2, 8, 1);
INSERT INTO `points` VALUES (64, 2, '大学生防骗安全知识001', 2, 8, 1);
INSERT INTO `points` VALUES (65, 2, '签到', 2, 8, 1);
INSERT INTO `points` VALUES (66, 3, '防诈骗大学习', 2, 8, 2);
INSERT INTO `points` VALUES (67, 2, '签到', 2, 8, 4);
INSERT INTO `points` VALUES (68, 2, '签到', 2, 8, 5);
INSERT INTO `points` VALUES (69, 2, '防诈骗大学习', 2, 8, 6);
INSERT INTO `points` VALUES (70, 2, '签退', 2, 8, 6);
INSERT INTO `points` VALUES (71, 2, '签退', 2, 8, 6);
INSERT INTO `points` VALUES (72, 2, '我的反诈笔记', 2, 8, 5);
INSERT INTO `points` VALUES (73, 2, '签退', 2, 8, 1);
INSERT INTO `points` VALUES (74, 2, '我的反诈笔记', 2, 8, 1);
INSERT INTO `points` VALUES (75, 2, '签退', 2, 8, 1);
INSERT INTO `points` VALUES (76, 2, '防诈骗大学习', 19, 8, 1);
INSERT INTO `points` VALUES (77, 2, '签到', 19, 8, 1);
INSERT INTO `points` VALUES (78, 2, '签到', 19, 8, 1);
INSERT INTO `points` VALUES (79, 2, '防诈骗大学习', 2, 8, 1);
INSERT INTO `points` VALUES (80, 2, '签到', 2, 8, 1);
INSERT INTO `points` VALUES (81, 2, '防诈骗大学习', 2, 8, 1);
INSERT INTO `points` VALUES (82, 2, '签到', 2, 8, 1);
INSERT INTO `points` VALUES (83, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (84, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (85, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (86, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (87, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (88, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (89, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (90, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (91, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (92, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (93, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (94, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (95, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (96, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (97, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (98, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (99, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (100, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (101, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (102, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (103, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (104, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (105, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (106, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (107, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (108, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (109, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (110, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (111, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (112, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (113, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (114, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (115, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (116, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (117, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (118, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (119, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (120, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (121, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (122, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (123, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (124, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (125, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (126, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (127, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (128, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (129, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (130, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (131, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (132, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (133, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (134, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (135, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (136, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (137, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (138, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (139, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (140, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (141, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (142, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (143, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (144, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (145, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (146, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (147, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (148, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (149, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (150, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (151, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (152, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (153, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (154, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (155, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (156, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (157, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (158, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (159, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (160, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (161, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (162, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (163, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (164, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (165, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (166, NULL, NULL, 2, 8, 1);
INSERT INTO `points` VALUES (167, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (168, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (169, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (170, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (171, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (172, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (173, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (174, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (175, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (176, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (177, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (178, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (179, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (180, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (181, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (182, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (183, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (184, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (185, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (186, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (187, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (188, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (189, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (190, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (191, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (192, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (193, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (194, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (195, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (196, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (197, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (198, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (199, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (200, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (201, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (202, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (203, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (204, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (205, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (206, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (207, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (208, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (209, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (210, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (211, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (212, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (213, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (214, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (215, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (216, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (217, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (218, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (219, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (220, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (221, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (222, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (223, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (224, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (225, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (226, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (227, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (228, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (229, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (230, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (231, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (232, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (233, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (234, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (235, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (236, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (237, NULL, NULL, 2, 8, 2);
INSERT INTO `points` VALUES (238, NULL, NULL, 2, 8, 4);
INSERT INTO `points` VALUES (239, NULL, NULL, 2, 8, 4);
INSERT INTO `points` VALUES (240, NULL, NULL, 2, 8, 4);
INSERT INTO `points` VALUES (241, NULL, NULL, 2, 8, 4);
INSERT INTO `points` VALUES (242, NULL, NULL, 2, 8, 4);
INSERT INTO `points` VALUES (243, NULL, NULL, 2, 8, 4);
INSERT INTO `points` VALUES (244, NULL, NULL, 2, 8, 4);
INSERT INTO `points` VALUES (245, NULL, NULL, 2, 8, 4);
INSERT INTO `points` VALUES (246, NULL, NULL, 2, 8, 4);
INSERT INTO `points` VALUES (247, NULL, NULL, 2, 8, 4);
INSERT INTO `points` VALUES (248, NULL, NULL, 2, 8, 4);
INSERT INTO `points` VALUES (249, NULL, NULL, 2, 8, 4);
INSERT INTO `points` VALUES (250, NULL, NULL, 2, 8, 4);
INSERT INTO `points` VALUES (251, NULL, NULL, 2, 8, 4);
INSERT INTO `points` VALUES (252, NULL, NULL, 2, 8, 4);
INSERT INTO `points` VALUES (253, NULL, NULL, 2, 8, 4);
INSERT INTO `points` VALUES (254, NULL, NULL, 2, 8, 4);
INSERT INTO `points` VALUES (255, NULL, NULL, 2, 8, 4);
INSERT INTO `points` VALUES (256, NULL, NULL, 2, 8, 4);
INSERT INTO `points` VALUES (257, NULL, NULL, 2, 8, 4);
INSERT INTO `points` VALUES (258, NULL, NULL, 2, 8, 4);
INSERT INTO `points` VALUES (259, NULL, NULL, 2, 8, 4);
INSERT INTO `points` VALUES (260, NULL, NULL, 2, 8, 4);
INSERT INTO `points` VALUES (261, NULL, NULL, 2, 8, 4);
INSERT INTO `points` VALUES (262, NULL, NULL, 2, 8, 4);
INSERT INTO `points` VALUES (263, NULL, NULL, 2, 8, 4);
INSERT INTO `points` VALUES (264, NULL, NULL, 2, 8, 4);
INSERT INTO `points` VALUES (265, NULL, NULL, 2, 8, 4);
INSERT INTO `points` VALUES (266, NULL, NULL, 2, 8, 4);
INSERT INTO `points` VALUES (267, NULL, NULL, 2, 8, 4);
INSERT INTO `points` VALUES (268, NULL, NULL, 2, 8, 4);
INSERT INTO `points` VALUES (269, NULL, NULL, 2, 8, 4);
INSERT INTO `points` VALUES (270, NULL, NULL, 2, 8, 4);
INSERT INTO `points` VALUES (271, NULL, NULL, 2, 8, 4);
INSERT INTO `points` VALUES (272, NULL, NULL, 2, 8, 4);
INSERT INTO `points` VALUES (273, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (274, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (275, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (276, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (277, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (278, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (279, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (280, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (281, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (282, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (283, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (284, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (285, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (286, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (287, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (288, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (289, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (290, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (291, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (292, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (293, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (294, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (295, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (296, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (297, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (298, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (299, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (300, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (301, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (302, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (303, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (304, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (305, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (306, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (307, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (308, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (309, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (310, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (311, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (312, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (313, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (314, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (315, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (316, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (317, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (318, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (319, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (320, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (321, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (322, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (323, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (324, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (325, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (326, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (327, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (328, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (329, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (330, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (331, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (332, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (333, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (334, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (335, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (336, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (337, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (338, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (339, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (340, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (341, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (342, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (343, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (344, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (345, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (346, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (347, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (348, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (349, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (350, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (351, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (352, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (353, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (354, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (355, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (356, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (357, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (358, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (359, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (360, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (361, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (362, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (363, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (364, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (365, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (366, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (367, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (368, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (369, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (370, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (371, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (372, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (373, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (374, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (375, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (376, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (377, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (378, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (379, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (380, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (381, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (382, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (383, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (384, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (385, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (386, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (387, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (388, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (389, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (390, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (391, NULL, NULL, 2, 8, 5);
INSERT INTO `points` VALUES (392, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (393, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (394, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (395, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (396, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (397, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (398, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (399, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (400, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (401, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (402, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (403, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (404, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (405, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (406, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (407, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (408, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (409, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (410, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (411, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (412, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (413, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (414, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (415, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (416, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (417, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (418, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (419, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (420, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (421, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (422, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (423, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (424, NULL, NULL, 2, 8, 6);
INSERT INTO `points` VALUES (425, 2, '网购月饼有质量问题为由实施诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (426, 2, '冒充电商物流客服', 2, 8, NULL);
INSERT INTO `points` VALUES (427, 2, '网购月饼有质量问题为由实施诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (428, 2, '网购月饼有质量问题为由实施诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (429, 2, '网购月饼有质量问题为由实施诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (430, 2, '冒充电商物流客服', 2, 8, NULL);
INSERT INTO `points` VALUES (431, 2, '冒充电商物流客服', 2, 8, NULL);
INSERT INTO `points` VALUES (432, 2, '网购月饼有质量问题为由实施诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (433, 2, '冒充公检法', 2, 8, NULL);
INSERT INTO `points` VALUES (434, 2, '冒充公检法', 2, 8, NULL);
INSERT INTO `points` VALUES (435, 2, '网购月饼有质量问题为由实施诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (436, 2, '冒充亲朋好友发送祝福短信进行诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (437, 2, '冒充电商物流客服', 2, 8, NULL);
INSERT INTO `points` VALUES (438, 2, '网购月饼有质量问题为由实施诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (439, 2, '冒充亲朋好友发送祝福短信进行诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (440, 2, '以“航班取消可办理退票”为由实施诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (441, 2, '以“航班取消可办理退票”为由实施诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (442, 2, '以“中秋节促销”为由进行诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (443, 2, '冒充电商物流客服', 2, 8, NULL);
INSERT INTO `points` VALUES (444, 2, '网购月饼有质量问题为由实施诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (445, 2, '网购月饼有质量问题为由实施诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (446, 2, '网购月饼有质量问题为由实施诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (447, 2, '冒充电商物流客服', 2, 8, NULL);
INSERT INTO `points` VALUES (448, 2, '冒充电商物流客服', 2, 8, NULL);
INSERT INTO `points` VALUES (449, 2, '冒充公检法', 2, 8, NULL);
INSERT INTO `points` VALUES (450, 2, '网购月饼有质量问题为由实施诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (451, 2, '网购月饼有质量问题为由实施诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (452, 2, '网购月饼有质量问题为由实施诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (453, 2, '网购月饼有质量问题为由实施诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (454, 2, '冒充公检法', 2, 8, NULL);
INSERT INTO `points` VALUES (455, 2, '这样的红包要谨慎！！', 2, 8, NULL);
INSERT INTO `points` VALUES (456, 2, '冒充公检法', 2, 8, NULL);
INSERT INTO `points` VALUES (457, 2, '冒充亲朋好友发送祝福短信进行诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (458, 2, '网购月饼有质量问题为由实施诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (459, 2, '冒充电商物流客服', 2, 8, NULL);
INSERT INTO `points` VALUES (460, 2, '冒充公检法', 2, 8, NULL);
INSERT INTO `points` VALUES (461, 2, '为什么很多诈骗短信看上去都很假，骗子还那么挣钱？', 2, 8, NULL);
INSERT INTO `points` VALUES (462, 2, '远离AG，全是诈骗，我输了三百多万', 2, 8, NULL);
INSERT INTO `points` VALUES (463, 2, '我的反诈笔记', 2, 8, NULL);
INSERT INTO `points` VALUES (464, 2, '我遇到骗子了——新型诈骗手段', 2, 8, NULL);
INSERT INTO `points` VALUES (465, 2, '网购月饼有质量问题为由实施诈骗', 19, 8, NULL);
INSERT INTO `points` VALUES (466, 2, '我的被诈骗经过，望大家引以为戒', 19, 8, NULL);
INSERT INTO `points` VALUES (467, 2, '冒充电商物流客服', 19, 8, NULL);
INSERT INTO `points` VALUES (468, 2, '我的被诈骗经过，望大家引以为戒', 19, 8, NULL);
INSERT INTO `points` VALUES (469, 2, '想不到！QQ群里的老乡竟然是这样的人...', 19, 8, NULL);
INSERT INTO `points` VALUES (470, 2, '江苏警方发布“羊了个羊”防骗指南', 19, 8, NULL);
INSERT INTO `points` VALUES (471, 2, '我遇到骗子了——新型诈骗手段', 2, 8, NULL);
INSERT INTO `points` VALUES (472, 2, '诈骗手段有多高明，你根本无法想象', 19, 8, NULL);
INSERT INTO `points` VALUES (473, 2, '为什么很多诈骗短信看上去都很假，骗子还那么挣钱？', 19, 8, NULL);
INSERT INTO `points` VALUES (474, 2, '投资电影只需要7块5！', 19, 8, NULL);
INSERT INTO `points` VALUES (475, 2, '为什么很多诈骗短信看上去都很假，骗子还那么挣钱？', 19, 8, NULL);
INSERT INTO `points` VALUES (476, 2, 'qqq', 2, 8, NULL);
INSERT INTO `points` VALUES (477, 2, '为什么很多诈骗短信看上去都很假，骗子还那么挣钱？', 19, 8, NULL);
INSERT INTO `points` VALUES (478, 2, '为什么很多诈骗短信看上去都很假，骗子还那么挣钱？', 2, 8, NULL);
INSERT INTO `points` VALUES (479, 2, '为什么很多诈骗短信看上去都很假，骗子还那么挣钱？', 19, 8, NULL);
INSERT INTO `points` VALUES (480, 2, '江苏警方发布“羊了个羊”防骗指南', 2, 8, NULL);
INSERT INTO `points` VALUES (481, 2, '江苏警方发布“羊了个羊”防骗指南', 19, 8, NULL);
INSERT INTO `points` VALUES (482, 2, '网购月饼有质量问题为由实施诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (483, 2, '网购月饼有质量问题为由实施诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (484, 2, '网购月饼有质量问题为由实施诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (485, 2, '网购月饼有质量问题为由实施诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (486, 2, '网购月饼有质量问题为由实施诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (487, 2, '网购月饼有质量问题为由实施诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (488, 2, '网购月饼有质量问题为由实施诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (489, 2, '我的被诈骗经过，望大家引以为戒', 19, 8, NULL);
INSERT INTO `points` VALUES (490, 2, '网购月饼有质量问题为由实施诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (491, 2, '我的被诈骗经过，望大家引以为戒', 2, 8, NULL);
INSERT INTO `points` VALUES (492, 2, '诈骗手段有多高明，你根本无法想象', 2, 8, NULL);
INSERT INTO `points` VALUES (493, 2, '我的被诈骗经过，望大家引以为戒', 2, 8, NULL);
INSERT INTO `points` VALUES (494, 2, '我的被诈骗经过，望大家引以为戒', 2, 8, NULL);
INSERT INTO `points` VALUES (495, 2, '我的被诈骗经过，望大家引以为戒', 19, 8, NULL);
INSERT INTO `points` VALUES (496, 2, '我的被诈骗经过，望大家引以为戒', 4, 8, NULL);
INSERT INTO `points` VALUES (497, 2, '我的被诈骗经过，望大家引以为戒', 19, 8, NULL);
INSERT INTO `points` VALUES (498, 2, '为什么很多诈骗短信看上去都很假，骗子还那么挣钱？', 19, 8, NULL);
INSERT INTO `points` VALUES (499, 2, '我的被诈骗经过，望大家引以为戒', 19, 8, NULL);
INSERT INTO `points` VALUES (500, 2, '一起来宣传反诈', 4, 8, NULL);
INSERT INTO `points` VALUES (501, 5, NULL, 4, 8, NULL);
INSERT INTO `points` VALUES (502, 5, NULL, 4, 8, NULL);
INSERT INTO `points` VALUES (503, 5, NULL, 4, 8, NULL);
INSERT INTO `points` VALUES (504, 5, NULL, 4, 8, NULL);
INSERT INTO `points` VALUES (505, 2, '网购月饼有质量问题为由实施诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (506, 5, NULL, 4, 8, NULL);
INSERT INTO `points` VALUES (507, 5, NULL, 4, 8, NULL);
INSERT INTO `points` VALUES (508, 5, NULL, 4, 8, NULL);
INSERT INTO `points` VALUES (509, 5, NULL, 4, 8, NULL);
INSERT INTO `points` VALUES (510, 5, NULL, 4, 8, NULL);
INSERT INTO `points` VALUES (511, 5, NULL, 4, 8, NULL);
INSERT INTO `points` VALUES (512, 5, NULL, 4, 8, NULL);
INSERT INTO `points` VALUES (513, 5, NULL, 4, 8, NULL);
INSERT INTO `points` VALUES (514, 5, NULL, 4, 8, NULL);
INSERT INTO `points` VALUES (515, 5, NULL, 4, 8, NULL);
INSERT INTO `points` VALUES (516, 5, NULL, 4, 8, NULL);
INSERT INTO `points` VALUES (517, 5, NULL, 4, 8, NULL);
INSERT INTO `points` VALUES (518, 5, NULL, 4, 8, NULL);
INSERT INTO `points` VALUES (519, 5, NULL, 4, 8, NULL);
INSERT INTO `points` VALUES (520, 5, NULL, 4, 8, NULL);
INSERT INTO `points` VALUES (521, 5, NULL, 5, 8, NULL);
INSERT INTO `points` VALUES (522, 5, NULL, 5, 8, NULL);
INSERT INTO `points` VALUES (523, 5, NULL, 5, 8, NULL);
INSERT INTO `points` VALUES (524, 5, NULL, 5, 8, NULL);
INSERT INTO `points` VALUES (525, 5, NULL, 5, 8, NULL);
INSERT INTO `points` VALUES (526, 5, NULL, 5, 8, NULL);
INSERT INTO `points` VALUES (527, 5, NULL, 5, 8, NULL);
INSERT INTO `points` VALUES (528, 5, NULL, 5, 8, NULL);
INSERT INTO `points` VALUES (529, 5, NULL, 5, 8, NULL);
INSERT INTO `points` VALUES (530, 5, NULL, 5, 8, NULL);
INSERT INTO `points` VALUES (531, 5, NULL, 5, 8, NULL);
INSERT INTO `points` VALUES (532, 5, NULL, 5, 8, NULL);
INSERT INTO `points` VALUES (533, 5, NULL, 5, 8, NULL);
INSERT INTO `points` VALUES (534, 5, NULL, 5, 8, NULL);
INSERT INTO `points` VALUES (535, 5, NULL, 5, 8, NULL);
INSERT INTO `points` VALUES (536, 5, NULL, 5, 8, NULL);
INSERT INTO `points` VALUES (537, 5, NULL, 5, 8, NULL);
INSERT INTO `points` VALUES (538, 5, NULL, 5, 8, NULL);
INSERT INTO `points` VALUES (539, 5, NULL, 5, 8, NULL);
INSERT INTO `points` VALUES (540, 5, NULL, 5, 8, NULL);
INSERT INTO `points` VALUES (541, 5, NULL, 5, 8, NULL);
INSERT INTO `points` VALUES (542, 5, NULL, 5, 8, NULL);
INSERT INTO `points` VALUES (543, 5, NULL, 5, 8, NULL);
INSERT INTO `points` VALUES (544, 5, NULL, 5, 8, NULL);
INSERT INTO `points` VALUES (545, 5, NULL, 5, 8, NULL);
INSERT INTO `points` VALUES (546, 5, NULL, 5, 8, NULL);
INSERT INTO `points` VALUES (547, 5, NULL, 5, 8, NULL);
INSERT INTO `points` VALUES (548, 2, '想不到！QQ群里的老乡竟然是这样的人...', 2, 8, NULL);
INSERT INTO `points` VALUES (549, 2, '为什么很多诈骗短信看上去都很假，骗子还那么挣钱？', 4, 8, NULL);
INSERT INTO `points` VALUES (550, 2, '远离AG，全是诈骗，我输了三百多万', 4, 8, NULL);
INSERT INTO `points` VALUES (551, 2, '网购月饼有质量问题为由实施诈骗', 4, 8, NULL);
INSERT INTO `points` VALUES (552, 2, '江苏警方发布“羊了个羊”防骗指南', 4, 8, NULL);
INSERT INTO `points` VALUES (553, 3, '签到', 4, 8, NULL);
INSERT INTO `points` VALUES (554, 2, '远离AG，全是诈骗，我输了三百多万', 4, 8, NULL);
INSERT INTO `points` VALUES (555, 2, NULL, 2, 8, NULL);
INSERT INTO `points` VALUES (556, 2, '网络骗术花样多，莫把虚拟当现实', 2, 8, NULL);
INSERT INTO `points` VALUES (557, 2, '投资电影只需要7块5！', 19, 8, NULL);
INSERT INTO `points` VALUES (558, 2, '投资电影只需要7块5！', 19, 8, NULL);
INSERT INTO `points` VALUES (559, 2, '网购月饼有质量问题为由实施诈骗', 19, 8, NULL);
INSERT INTO `points` VALUES (560, 2, '远离AG，全是诈骗，我输了三百多万', 2, 8, NULL);
INSERT INTO `points` VALUES (561, 2, '冒充亲朋好友发送祝福短信进行诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (562, 2, '江苏警方发布“羊了个羊”防骗指南', 2, 8, NULL);
INSERT INTO `points` VALUES (563, 2, NULL, 2, 8, NULL);
INSERT INTO `points` VALUES (564, 2, '网购月饼有质量问题为由实施诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (565, 2, NULL, 2, 8, NULL);
INSERT INTO `points` VALUES (566, 2, '又一个新型骗局出现了！大家请注意', 2, 8, NULL);
INSERT INTO `points` VALUES (567, 5, NULL, 2, 8, NULL);
INSERT INTO `points` VALUES (568, 5, NULL, 2, 8, NULL);
INSERT INTO `points` VALUES (569, 5, NULL, 2, 8, NULL);
INSERT INTO `points` VALUES (570, 5, NULL, 2, 8, NULL);
INSERT INTO `points` VALUES (571, 5, NULL, 2, 8, NULL);
INSERT INTO `points` VALUES (572, 5, NULL, 2, 8, NULL);
INSERT INTO `points` VALUES (573, 2, '网购月饼有质量问题为由实施诈骗', 4, 8, NULL);
INSERT INTO `points` VALUES (574, 2, '为什么很多诈骗短信看上去都很假，骗子还那么挣钱？', 17, 8, NULL);
INSERT INTO `points` VALUES (575, 2, '远离AG，全是诈骗，我输了三百多万', 17, 8, NULL);
INSERT INTO `points` VALUES (576, 2, '为什么很多诈骗短信看上去都很假，骗子还那么挣钱？', 17, 8, NULL);
INSERT INTO `points` VALUES (577, 2, '为什么很多诈骗短信看上去都很假，骗子还那么挣钱？', 2, 8, NULL);
INSERT INTO `points` VALUES (578, 2, '今天是个宣传反诈的好日子', 17, 8, NULL);
INSERT INTO `points` VALUES (579, 2, '我的被诈骗经过，望大家引以为戒', 17, 8, NULL);
INSERT INTO `points` VALUES (580, 2, '远离AG，全是诈骗，我输了三百多万', 17, 8, NULL);
INSERT INTO `points` VALUES (581, 3, '签到', 19, 8, NULL);
INSERT INTO `points` VALUES (582, 2, '远离AG，全是诈骗，我输了三百多万', 17, 8, NULL);
INSERT INTO `points` VALUES (583, 2, '远离AG，全是诈骗，我输了三百多万', 17, 8, NULL);
INSERT INTO `points` VALUES (584, 2, '网购月饼有质量问题为由实施诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (585, 2, '远离AG，全是诈骗，我输了三百多万', 19, 8, NULL);
INSERT INTO `points` VALUES (586, 2, '网购月饼有质量问题为由实施诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (587, 2, '网购月饼有质量问题为由实施诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (588, 2, '网购月饼有质量问题为由实施诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (589, 2, '网购月饼有质量问题为由实施诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (590, 2, '网购月饼有质量问题为由实施诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (591, 2, '网购月饼有质量问题为由实施诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (592, 2, '远离AG，全是诈骗，我输了三百多万', 2, 8, NULL);
INSERT INTO `points` VALUES (593, 2, '网购月饼有质量问题为由实施诈骗', 19, 8, NULL);
INSERT INTO `points` VALUES (594, 2, '网购月饼有质量问题为由实施诈骗', 2, 8, NULL);
INSERT INTO `points` VALUES (595, 2, '网购月饼有质量问题为由实施诈骗', 19, 8, NULL);
INSERT INTO `points` VALUES (596, 2, '远离AG，全是诈骗，我输了三百多万', 19, 8, NULL);
INSERT INTO `points` VALUES (597, 2, '网购月饼有质量问题为由实施诈骗', 19, 8, NULL);
INSERT INTO `points` VALUES (598, 3, '签到', 6, 8, NULL);
INSERT INTO `points` VALUES (599, -10, '优惠券', 2, 8, NULL);
INSERT INTO `points` VALUES (600, -10, '优惠券', 2, 8, NULL);
INSERT INTO `points` VALUES (601, 2, '我遇到骗子了——新型诈骗手段', 6, 8, NULL);
INSERT INTO `points` VALUES (602, 2, '远离AG，全是诈骗，我输了三百多万', 6, 8, NULL);
INSERT INTO `points` VALUES (603, 2, '远离AG，全是诈骗，我输了三百多万', 2, 8, NULL);
INSERT INTO `points` VALUES (604, 2, '为什么很多诈骗短信看上去都很假，骗子还那么挣钱？', 6, 8, NULL);
INSERT INTO `points` VALUES (605, 2, '我遇到骗子了——新型诈骗手段', 6, 8, NULL);
INSERT INTO `points` VALUES (606, 2, '我遇到骗子了——新型诈骗手段', 6, 8, NULL);
INSERT INTO `points` VALUES (607, 2, '我的被诈骗经过，望大家引以为戒', 6, 8, NULL);
INSERT INTO `points` VALUES (608, 2, '我遇到骗子了——新型诈骗手段', 2, 8, NULL);
INSERT INTO `points` VALUES (609, 2, '我遇到骗子了——新型诈骗手段', 6, 8, NULL);
INSERT INTO `points` VALUES (610, 2, '我遇到骗子了——新型诈骗手段', 6, 8, NULL);
INSERT INTO `points` VALUES (611, 2, '网络贷款，让你的信任无处安放', 2, 8, NULL);
INSERT INTO `points` VALUES (612, 2, '网络贷款，让你的信任无处安放', 2, 8, NULL);
INSERT INTO `points` VALUES (613, 2, '远离AG，全是诈骗，我输了三百多万', 18, 8, NULL);
INSERT INTO `points` VALUES (614, 2, '冒充公检法', 18, 8, NULL);
INSERT INTO `points` VALUES (615, 2, '江苏警方发布“羊了个羊”防骗指南', 18, 8, NULL);
INSERT INTO `points` VALUES (616, 2, '远离AG，全是诈骗，我输了三百多万', 18, 8, NULL);
INSERT INTO `points` VALUES (617, 2, '一起来反诈', 18, 8, NULL);
INSERT INTO `points` VALUES (618, 2, '网络贷款，让你的信任无处安放', 2, 8, NULL);
INSERT INTO `points` VALUES (619, 3, '签到', 5, 8, NULL);
INSERT INTO `points` VALUES (620, 2, '冒充亲朋好友发送祝福短信进行诈骗', 5, 8, NULL);
INSERT INTO `points` VALUES (621, 3, '签到', 2, 8, NULL);
INSERT INTO `points` VALUES (622, 2, '江苏警方发布“羊了个羊”防骗指南', 2, 8, NULL);
INSERT INTO `points` VALUES (623, 2, '为什么很多诈骗短信看上去都很假，骗子还那么挣钱？', 2, 8, NULL);
INSERT INTO `points` VALUES (624, -10, '优惠券', 2, 8, NULL);

-- ----------------------------
-- Table structure for pointstype
-- ----------------------------
DROP TABLE IF EXISTS `pointstype`;
CREATE TABLE `pointstype`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `pointsType` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pointstype
-- ----------------------------
INSERT INTO `pointstype` VALUES (1, '签到');
INSERT INTO `pointstype` VALUES (2, '评论');
INSERT INTO `pointstype` VALUES (3, '新闻');
INSERT INTO `pointstype` VALUES (4, '心得');
INSERT INTO `pointstype` VALUES (5, '活动');
INSERT INTO `pointstype` VALUES (6, '收藏');

-- ----------------------------
-- Table structure for posting
-- ----------------------------
DROP TABLE IF EXISTS `posting`;
CREATE TABLE `posting`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '帖子名',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '帖子内容',
  `date` datetime NULL DEFAULT NULL COMMENT '帖子发布时间',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '帖子封面图(路径)',
  `level` int NULL DEFAULT NULL COMMENT '帖子分类(外键)',
  `opacity` int NULL DEFAULT NULL COMMENT '帖子是否对外可见(外键)',
  `user` int NULL DEFAULT NULL COMMENT '帖子发布人(外键)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_posting_user_1`(`user` ASC) USING BTREE,
  INDEX `fk_posting_opacity_1`(`opacity` ASC) USING BTREE,
  INDEX `fk_posting_postingLevel_1`(`level` ASC) USING BTREE,
  CONSTRAINT `fk_posting_opacity_1` FOREIGN KEY (`opacity`) REFERENCES `opacity` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_posting_postingLevel_1` FOREIGN KEY (`level`) REFERENCES `postinglevel` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_posting_user_1` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '帖子' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of posting
-- ----------------------------
INSERT INTO `posting` VALUES (1, '为什么很多诈骗短信看上去都很假，骗子还那么挣钱？', '<h1>为什么很多诈骗短信看上去都很假，骗子还那么挣钱？</h1>\n<span style=\"font-size: 18px;\"><span style=\"white-space:pre\">	</span>有人说诈骗分子日薪9500（还是行情不好的时候），一个月换陆虎……这是真的吗？</span>\n<div><span style=\"font-size: 18px;\">&nbsp;<span style=\"white-space:pre\">	</span>现在那些骗子短信都很白痴，一看就是假的，真有那么多人上当？电信诈骗真能挣那么多钱吗？</span><span style=\"font-size: 18px;\">你是不是也曾经怀疑过，为什么那些看上去无比拙劣的诈骗短信，还能骗到钱？</span></div>\n<div><span style=\"font-size: 18px;\">&nbsp;<span style=\"white-space:pre\">	</span>在采访过一位因电信诈骗入狱的朋友后，我才明白这都是故意为之，也恰恰是骗子取得成功的关键所在。</span></div>\n<div><span style=\"font-size: 18px;\">这位因电信诈骗入狱的朋友，暂且叫他 K 君吧。他当时从 PHP 培训机构出来找工作，找我做面试咨询</span><span style=\"font-size: 18px;\">：</span></div>\n<div><br>\n</div>', '2022-08-17 19:43:36', 'http://www.wuhuazai.com/uploadeview/1663998871318v2-ce43e7326330a230038929df27903c08_1440w.jpg', 1, 1, 2);
INSERT INTO `posting` VALUES (3, '远离AG，全是诈骗，我输了三百多万', '<h1>远离AG，全是诈骗，我输了三百多万</h1>\n<div><br>\n</div>\n<span style=\"font-size: 18px;\"><span style=\"white-space:pre\">	</span>“AG模仿澳门赌场，我就是被那个场景迷惑，这就是妥妥的诈骗，十年里，输了存款，输掉了汽车，房产，</span>\n<div><span style=\"font-size: 18px;\">让我的经济倒退了二十年。</span></div>\n<div><span style=\"font-size: 18px;\"><span style=\"white-space:pre\">	</span>” 我没离婚，是因为不想家破人亡，苟延残喘一次次的欺骗老婆，父母，现在的这个家，</span></div>\n<div><span style=\"font-size: 18px;\">充满着不信任，不理解，有谁愿意去信任一个赌了十年的赌棍，如果换做是我，也一样无法相信。</span></div>\n<div><span style=\"font-size: 18px;\"><br>\n</span></div>\n<div><span style=\"font-size: 18px;\"><span style=\"white-space:pre\">	</span>我有一个小作坊，随时都可能倒闭，也是亲戚及时的借出一笔钱，才能正常运作，要是没有了那笔钱，</span></div>\n<div><span style=\"font-size: 18px;\">我可能现在也流落街头了，赌了这么久。</span></div>\n<div><br>\n</div>\n<div><span style=\"font-size: 18px;\"><span style=\"white-space:pre\">	</span>平时也都不喜欢跟人交流，所以只要一有闲钱，我总是第一时间想到了ag，这个让我坠入万丈深渊的百家乐游戏，</span></div>\n<div><br>\n</div>', '2022-09-05 17:55:01', 'http://wx4.sinaimg.cn/orj480/0089lW6tly1h67mo52cwlj30u0140ttc.jpg', 1, 1, 5);
INSERT INTO `posting` VALUES (6, '我的被诈骗经过，望大家引以为戒', '<h1>我的被诈骗经过，望大家引以为戒</h1>\n<div><br>\n</div>\n<span style=\"font-size: 18px;\"><span style=\"white-space:pre\">	</span>9月16日，是我人生中最黑暗的一天。 一个来自显示山东济南的诈骗电话，将我平静的生活完全打破碎。&nbsp;</span><span style=\"font-size: 18px;\">事实上，这样类似的电话已经在一周前就给我打过电话，当时接到电话的我正在上班，对方说是京东金条的贷款利率不正常，</span>\n<div><span style=\"font-size: 18px;\"><br>\n</span>\n<div><span style=\"font-size: 18px;\"><span style=\"white-space:pre\">	</span>超过国家标准需要下调，要我看下我的金条是不是贷款利率不正常，当时我随便敷衍了几句不需要就将电话挂掉了。</span></div>\n<div><span style=\"font-size: 18px;\">&nbsp;之后几天，类似的电话一直有打过来，我都将他们当成推销电话，直接挂掉了。因为我平常都不接此类电话，</span></div>\n<div><br>\n</div>\n<div><span style=\"font-size: 18px;\"><span style=\"white-space:pre\">	</span>这种偶尔再抖音里刷到的欺诈视频，降临在我身上的时候，我才知道有多痛苦！我几乎是在意识到我自己被</span><span style=\"font-size: 18px;\">骗了的瞬间，就失去了所有的自尊自信</span><span style=\"font-size: 18px;\">。</span></div>\n<div><span style=\"font-size: 18px;\"><br>\n</span></div>\n<div><span style=\"font-size: 18px;\"><span style=\"white-space:pre\">	</span>&nbsp;重点是平常我们都是正常下班，吃完饭就上楼了！！而这一天，所有人的行动轨迹，都跟我完美错开！所有小事件带来的心理转变，都在为我的受骗添砖加瓦！ 我真的欲哭无泪！！</span></div>\n</div>', '2022-09-10 17:55:06', 'https://wx2.sinaimg.cn/large/008eRyOkly1h5qtrhml9fj30rs0fm77c.jpg', 1, 2, 4);
INSERT INTO `posting` VALUES (7, '我的反诈笔记', '<p data-first-child=\"\" data-pid=\"qiTCbHP2\" style=\"margin-bottom: 1.4em; color: rgb(18, 18, 18); font-family: -apple-system, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, &quot;Source Han Sans SC&quot;, &quot;Noto Sans CJK SC&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: medium; background-color: rgb(255, 255, 255);\">随着现代科技的发展，我们的生活有了极大的改善，但这也促使了许多人利用高科技诈骗钱财，破坏人们的财产利益。现在的骗子无处不在，甚至就在我们身边。</p>\n<p data-pid=\"5uyNzFhB\" style=\"margin-top: 1.4em; margin-bottom: 1.4em; color: rgb(18, 18, 18); font-family: -apple-system, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, &quot;Source Han Sans SC&quot;, &quot;Noto Sans CJK SC&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: medium; background-color: rgb(255, 255, 255);\">同学们学会如何防诈骗：</p>\n<p data-pid=\"wV-GEa1f\" style=\"margin-top: 1.4em; margin-bottom: 1.4em; color: rgb(18, 18, 18); font-family: -apple-system, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, &quot;Source Han Sans SC&quot;, &quot;Noto Sans CJK SC&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: medium; background-color: rgb(255, 255, 255);\">1、不要有“贪图小便宜”、“一夜暴富”、“天上掉馅饼”的心理；</p>\n<p data-pid=\"HW-I4fYm\" style=\"margin-top: 1.4em; margin-bottom: 1.4em; color: rgb(18, 18, 18); font-family: -apple-system, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, &quot;Source Han Sans SC&quot;, &quot;Noto Sans CJK SC&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: medium; background-color: rgb(255, 255, 255);\">2、注意保护个人资料信息，不可随意注册、填写自己的身份、手机号码、银行卡号等私人信息；</p>\n<p data-pid=\"V_YjRnzP\" style=\"margin-top: 1.4em; margin-bottom: 1.4em; color: rgb(18, 18, 18); font-family: -apple-system, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, &quot;Source Han Sans SC&quot;, &quot;Noto Sans CJK SC&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: medium; background-color: rgb(255, 255, 255);\">3、在做好自身防范的同时，积极向周围的亲人、朋友做好宣传，特别是平时独自在家的中老年、离退休人员等易受骗群体要注意提醒；</p>\n<p data-pid=\"2NxFTHg4\" style=\"margin-top: 1.4em; margin-bottom: 1.4em; color: rgb(18, 18, 18); font-family: -apple-system, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, &quot;Source Han Sans SC&quot;, &quot;Noto Sans CJK SC&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: medium; background-color: rgb(255, 255, 255);\">4、发现电信诈骗违法犯罪行为要及时报警，如果掉入不法分子所设置的陷阱，要及时采取措施，尽量减少损失。</p>\n<p data-pid=\"O8hGSDft\" style=\"margin-top: 1.4em; color: rgb(18, 18, 18); font-family: -apple-system, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, &quot;Source Han Sans SC&quot;, &quot;Noto Sans CJK SC&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: medium; background-color: rgb(255, 255, 255);\">希望大家能提高警惕，擦亮自己的眼睛，明辨是非。更希望我们的犯罪分子能改邪归正，自食其力，还人们、社会一个安定的生活环境。</p>', '2022-04-04 21:00:00', 'https://wx2.sinaimg.cn/large/008eRyOkly1h5yzqrnhf3j30gz09j0tq.jpg', 2, 2, 8);
INSERT INTO `posting` VALUES (8, '我遇到骗子了——新型诈骗手段', '<span style=\"color: rgb(18, 18, 18); font-family: -apple-system, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, &quot;Source Han Sans SC&quot;, &quot;Noto Sans CJK SC&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: medium; background-color: rgb(255, 255, 255);\">事情从昨天（7.28）说起，一个陌生号码给我发短信，短信内容如下:</span>\n<div><img src=\"https://pic3.zhimg.com/80/v2-9db241a00c9c23d57671bd219fb3be8a_1440w.jpg\"><span style=\"color: rgb(18, 18, 18); font-family: -apple-system, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, &quot;Source Han Sans SC&quot;, &quot;Noto Sans CJK SC&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: medium; background-color: rgb(255, 255, 255);\"><br>\n</span></div>\n<div>\n<p data-pid=\"1YxtTrmA\" style=\"margin-top: 1.4em; margin-bottom: 1.4em; color: rgb(18, 18, 18); font-family: -apple-system, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, &quot;Source Han Sans SC&quot;, &quot;Noto Sans CJK SC&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: medium; background-color: rgb(255, 255, 255);\">以前也会收到这种短信，我都没有理会，这一次我就想抱着试一试的心态，看到底是怎么一回事？加了这个微信。加完后，发现：</p>\n<div><img src=\"https://pic3.zhimg.com/80/v2-8a25cd13100888b3f7ce88fe8ac5d516_1440w.jpg\"><br>\n</div>\n<div><span style=\"color: rgb(18, 18, 18); font-family: -apple-system, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, &quot;Source Han Sans SC&quot;, &quot;Noto Sans CJK SC&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: medium; background-color: rgb(255, 255, 255);\">我琢磨着可能是骗子，但我还是按他的操作加了支付宝群，想着，反正我就去看看，能领个免费的空调扇也不错。进群后，群是这样的：</span><br>\n</div>\n<div><img src=\"https://pic2.zhimg.com/80/v2-b8ef1e0eda7c04bf0f8d0846b4693999_1440w.jpg\"><span style=\"color: rgb(18, 18, 18); font-family: -apple-system, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, &quot;Source Han Sans SC&quot;, &quot;Noto Sans CJK SC&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: medium; background-color: rgb(255, 255, 255);\"><br>\n</span></div>\n<div><span style=\"color: rgb(18, 18, 18); font-family: -apple-system, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, &quot;Source Han Sans SC&quot;, &quot;Noto Sans CJK SC&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: medium; background-color: rgb(255, 255, 255);\">群里的管理员备注全部都是格力谁谁谁，群主一直不停的发红包，红包金额还挺大，我前前后后领了一共二十多，他们的理由是为格力作线下推广，我其实心里有点点怀疑了 然后我去问我姐夫，因为我姐夫在珠海格力有限公司上班</span><br>\n</div>\n<div><span style=\"color: rgb(18, 18, 18); font-family: -apple-system, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, &quot;Source Han Sans SC&quot;, &quot;Noto Sans CJK SC&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: medium; background-color: rgb(255, 255, 255);\">我内心还是想着，我这么聪明，绝不可能被骗，哈哈哈哈哈，然后我开始提高警惕，他们收集快递收货地址，我没填我自己的名字，紧接着，就开始莫名其妙叫我关注格力一系列的微信公众号，关注一个公众号截屏到群里，群主就会转账给你，关注一个公众号就可以拿到5.8元，我想着这也太容易了，我刷刷的一下一共搞到了二十多块钱，我内心戏还是，格力搞得内部宣传力度真大，可能他们想涨粉吧！先后让我们关注了两个公众号</span><span style=\"color: rgb(18, 18, 18); font-family: -apple-system, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, &quot;Source Han Sans SC&quot;, &quot;Noto Sans CJK SC&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: medium; background-color: rgb(255, 255, 255);\"><br>\n</span></div>\n<div><span style=\"color: rgb(18, 18, 18); font-family: -apple-system, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, &quot;Source Han Sans SC&quot;, &quot;Noto Sans CJK SC&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: medium; background-color: rgb(255, 255, 255);\">关注的都是格力的公众号，然后开始转移地方了，叫我们下载一个软件，并添加这个软件里的客服，给了我们下载链接，但应用市场根本搜不到，我想着反正下完领个16.8就走，然后就坐等那个空调扇到底能不能到。</span><span style=\"color: rgb(18, 18, 18); font-family: -apple-system, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, &quot;Source Han Sans SC&quot;, &quot;Noto Sans CJK SC&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: medium; background-color: rgb(255, 255, 255);\"><br>\n</span></div>\n<div><img src=\"https://pic2.zhimg.com/80/v2-b8d5fa65e3c0dd66679cb012e292646d_1440w.jpg\"><span style=\"color: rgb(18, 18, 18); font-family: -apple-system, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, &quot;Source Han Sans SC&quot;, &quot;Noto Sans CJK SC&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: medium; background-color: rgb(255, 255, 255);\"><br>\n</span></div>\n<figure data-size=\"small\" style=\"margin: 1.4em 0px; clear: both; color: rgb(18, 18, 18); font-family: -apple-system, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, &quot;Source Han Sans SC&quot;, &quot;Noto Sans CJK SC&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: medium; background-color: rgb(255, 255, 255);\"></figure></div>', '2022-04-04 21:00:00', 'https://wx1.sinaimg.cn/large/008eRyOkly1h51n2fc3zkj30rs0fmq5a.jpg', 1, 2, 6);
INSERT INTO `posting` VALUES (9, '诈骗手段有多高明，你根本无法想象', '<h1 class=\"Post-Title\" style=\"margin-top: 24px; margin-bottom: 24px; font-variant-numeric: inherit; font-variant-east-asian: inherit; font-stretch: inherit; font-size: 24px; line-height: 1.22; font-family: -apple-system, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, &quot;Source Han Sans SC&quot;, &quot;Noto Sans CJK SC&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-synthesis: style; overflow-wrap: break-word; color: rgb(18, 18, 18); background-color: rgb(255, 255, 255);\">诈骗手段有多高明，你根本无法想象</h1>\n<div><span style=\"color: rgb(18, 18, 18); font-family: -apple-system, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, &quot;Source Han Sans SC&quot;, &quot;Noto Sans CJK SC&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: medium; background-color: rgb(255, 255, 255);\">诈骗手段确实是很高明的，一环扣一环。诈骗分子的每一句话，所做的每一件事。都是事先所构思好的，所设定好的。</span><br>\n</div>\n<div><img src=\"https://pic1.zhimg.com/80/v2-778d0a39c9b87a7690da6f6bc18bb0dc_1440w.jpg\"><span style=\"color: rgb(18, 18, 18); font-family: -apple-system, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, &quot;Source Han Sans SC&quot;, &quot;Noto Sans CJK SC&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: medium; background-color: rgb(255, 255, 255);\"><br>\n</span></div>\n<div>\n<p data-pid=\"xJUgReT9\" style=\"margin-top: 1.4em; margin-bottom: 1.4em; color: rgb(18, 18, 18); font-family: -apple-system, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, &quot;Source Han Sans SC&quot;, &quot;Noto Sans CJK SC&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: medium; background-color: rgb(255, 255, 255);\">没有一个标点符号是多余的，没有一个字是无用的。之所以有很多人中枪，被诈骗，损失巨款。就是因为诈骗分子拿捏了人性，懂得人的需求，懂得人的软肋。</p>\n<p data-pid=\"MzxssX3R\" style=\"margin-top: 1.4em; margin-bottom: 1.4em; color: rgb(18, 18, 18); font-family: -apple-system, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, &quot;Source Han Sans SC&quot;, &quot;Noto Sans CJK SC&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: medium; background-color: rgb(255, 255, 255);\">人不可能无欲无求的，但是你只要是有需求，就一定会被诈骗。诈骗分子就是利用你的需求进行诈骗的。比如说你想在网络上赚钱，对方就有兼职刷单诈骗等着你。</p>\n<p data-pid=\"S3ZqQw4S\" style=\"margin-top: 1.4em; margin-bottom: 1.4em; color: rgb(18, 18, 18); font-family: -apple-system, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, &quot;Source Han Sans SC&quot;, &quot;Noto Sans CJK SC&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: medium; background-color: rgb(255, 255, 255);\">除了垫付刷单，还有刷彩票流水，给网红短视频公众号点赞，做手工活，文字录入等这些都是兼职类的诈骗，只要你想赚钱，你总会上当的。</p>\n<p data-pid=\"_UFxydPt\" style=\"margin-top: 1.4em; margin-bottom: 1.4em; color: rgb(18, 18, 18); font-family: -apple-system, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, &quot;Source Han Sans SC&quot;, &quot;Noto Sans CJK SC&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: medium; background-color: rgb(255, 255, 255);\">如果说你不想做兼职上赚钱，那就不会被骗，可你想的太过于简单了。因为还有教你做自媒体的诈骗，还有推荐股票，炒币，炒外汇等诈骗。</p>\n<p data-pid=\"8EOD0zd6\" style=\"margin-top: 1.4em; margin-bottom: 1.4em; color: rgb(18, 18, 18); font-family: -apple-system, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, &quot;Source Han Sans SC&quot;, &quot;Noto Sans CJK SC&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: medium; background-color: rgb(255, 255, 255);\">这些诈骗类型不光是网络上有，现实当中也不少。所以说只要你想赚钱，不在现实当中被骗，就会在网络上被骗。</p>\n<p data-pid=\"NH2pCY3s\" style=\"margin-top: 1.4em; margin-bottom: 1.4em; color: rgb(18, 18, 18); font-family: -apple-system, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, &quot;Source Han Sans SC&quot;, &quot;Noto Sans CJK SC&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: medium; background-color: rgb(255, 255, 255);\">有人说我不想赚钱，是不是就可以规避诈骗。但我很明确的告诉你，是规避不了的。因为还有冒充公检法诈骗，冒充领导诈骗，冒充亲朋好友诈骗。这些都不是让你赚钱的，但是能够让你掏钱。</p>\n<p data-pid=\"zaoZLYao\" style=\"margin-top: 1.4em; margin-bottom: 1.4em; color: rgb(18, 18, 18); font-family: -apple-system, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, &quot;Source Han Sans SC&quot;, &quot;Noto Sans CJK SC&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: medium; background-color: rgb(255, 255, 255);\">你说你不想在网络上赚钱，也识破了冒充类的诈骗。但是如果说你在网络上谈恋爱，或者打游戏，也还是会被骗。因为有一种网络诈骗跟感情有关，跟恋爱有关，那就是网络交友杀猪盘诈骗。</p>\n<p data-pid=\"B3a8lUf_\" style=\"margin-top: 1.4em; margin-bottom: 1.4em; color: rgb(18, 18, 18); font-family: -apple-system, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, &quot;Source Han Sans SC&quot;, &quot;Noto Sans CJK SC&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: medium; background-color: rgb(255, 255, 255);\">要是你不谈恋爱，应该不会被骗了吧。但有可能还是会被骗，真的就是这样。因为有一种网络诈骗，叫做免费领皮肤和装备诈骗，还有游戏代练等。当然还有几种，现在还没想出来的。</p>\n<p data-pid=\"XscBkCYa\" style=\"margin-top: 1.4em; margin-bottom: 1.4em; color: rgb(18, 18, 18); font-family: -apple-system, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, &quot;Source Han Sans SC&quot;, &quot;Noto Sans CJK SC&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: medium; background-color: rgb(255, 255, 255);\">所以说网络诈骗的手段是很高明的，可以涵盖你生活的方方面面。只要稍微不注意，就有可能上当受骗，造成不必要的经济损失。</p>\n<p data-pid=\"XscBkCYa\" style=\"margin-top: 1.4em; margin-bottom: 1.4em; color: rgb(18, 18, 18); font-family: -apple-system, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, &quot;Source Han Sans SC&quot;, &quot;Noto Sans CJK SC&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: medium; background-color: rgb(255, 255, 255);\"><img src=\"https://pic2.zhimg.com/80/v2-ca8621128d0934ec7e6d10ee04fe59bd_1440w.jpg\"><br>\n</p>\n<p data-pid=\"XscBkCYa\" style=\"margin-top: 1.4em; margin-bottom: 1.4em; color: rgb(18, 18, 18); font-family: -apple-system, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, &quot;Source Han Sans SC&quot;, &quot;Noto Sans CJK SC&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: medium; background-color: rgb(255, 255, 255);\"><span style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, &quot;Source Han Sans SC&quot;, &quot;Noto Sans CJK SC&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif;\">这么讲的话，大家应该明白是怎么一回事。所以说，学习网络诈骗的预防知识还是有用的。可以提前预防，提前警惕，就可以避免遭受不必要的损失。</span><br>\n</p>\n</div>', '2022-07-05 03:00:00', 'https://wx2.sinaimg.cn/large/008eRyOkly1h4k3wwq3c4j30b4069dfr.jpg', 1, 1, 14);
INSERT INTO `posting` VALUES (18, '一起来宣传反诈', '今天我进行反诈宣传真是太好啦', NULL, 'http://www.wuhuazai.com/uploadeview/1663934826185f7b6f200586f1122815213f5e9fd163d.png', 2, 1, 4);
INSERT INTO `posting` VALUES (19, '反诈你我他', '反诈你你我一起的操作', NULL, 'http://www.wuhuazai.com/uploadeview/16639349859612.jpg', 1, 1, 19);
INSERT INTO `posting` VALUES (21, '一起来反诈', '今天我进行了反诈活动', NULL, 'http://www.wuhuazai.com/uploadeview/1664002548980587671b98c4c72502bdfc742cc1e314b.png', 1, 1, 18);

-- ----------------------------
-- Table structure for postinglevel
-- ----------------------------
DROP TABLE IF EXISTS `postinglevel`;
CREATE TABLE `postinglevel`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `level` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '帖子分类(0-心得, 1-笔记)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '帖子分类表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of postinglevel
-- ----------------------------
INSERT INTO `postinglevel` VALUES (1, '心得体会');
INSERT INTO `postinglevel` VALUES (2, '笔记');

-- ----------------------------
-- Table structure for postinglike
-- ----------------------------
DROP TABLE IF EXISTS `postinglike`;
CREATE TABLE `postinglike`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user` int NULL DEFAULT NULL COMMENT '用户ID(外键）',
  `posting` int NULL DEFAULT NULL COMMENT '帖子ID(外键)',
  `likeType` int NULL DEFAULT NULL COMMENT '点赞、收藏(外键)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_postingLike_user_1`(`user` ASC) USING BTREE,
  INDEX `fk_postingLike_posting_1`(`posting` ASC) USING BTREE,
  INDEX `fk_postingLike_likeType`(`likeType` ASC) USING BTREE,
  CONSTRAINT `fk_postingLike_likeType` FOREIGN KEY (`likeType`) REFERENCES `liketype` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_postingLike_posting_1` FOREIGN KEY (`posting`) REFERENCES `posting` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_postingLike_user_1` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '帖子点赞记录表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of postinglike
-- ----------------------------
INSERT INTO `postinglike` VALUES (1, 2, 1, 1);
INSERT INTO `postinglike` VALUES (3, 4, 3, 2);
INSERT INTO `postinglike` VALUES (8, 4, 3, 1);
INSERT INTO `postinglike` VALUES (9, 2, 6, 1);
INSERT INTO `postinglike` VALUES (10, 2, 7, 1);
INSERT INTO `postinglike` VALUES (11, 4, 8, 1);
INSERT INTO `postinglike` VALUES (12, 4, 9, 1);
INSERT INTO `postinglike` VALUES (13, 4, 9, 1);
INSERT INTO `postinglike` VALUES (14, 2, 8, 1);
INSERT INTO `postinglike` VALUES (15, 4, 7, 1);
INSERT INTO `postinglike` VALUES (16, 4, 6, 2);
INSERT INTO `postinglike` VALUES (17, 4, 3, 2);
INSERT INTO `postinglike` VALUES (18, 2, 1, 1);
INSERT INTO `postinglike` VALUES (21, 2, 6, 1);
INSERT INTO `postinglike` VALUES (22, 2, 6, 1);
INSERT INTO `postinglike` VALUES (23, 2, 6, 1);
INSERT INTO `postinglike` VALUES (24, 2, 6, 1);
INSERT INTO `postinglike` VALUES (25, 4, 1, 1);
INSERT INTO `postinglike` VALUES (26, 4, 3, 1);
INSERT INTO `postinglike` VALUES (27, 17, 3, 1);
INSERT INTO `postinglike` VALUES (28, 17, 3, 1);
INSERT INTO `postinglike` VALUES (29, 17, 3, 1);
INSERT INTO `postinglike` VALUES (30, 2, 3, 1);
INSERT INTO `postinglike` VALUES (31, 2, 3, 1);
INSERT INTO `postinglike` VALUES (32, 2, 3, 1);
INSERT INTO `postinglike` VALUES (33, 18, 3, 1);

-- ----------------------------
-- Table structure for postingsay
-- ----------------------------
DROP TABLE IF EXISTS `postingsay`;
CREATE TABLE `postingsay`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `say` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '评论内容',
  `date` datetime NULL DEFAULT NULL COMMENT '帖子评论的时间',
  `user` int NULL DEFAULT NULL COMMENT '评论的用户(外键)',
  `posting` int NULL DEFAULT NULL COMMENT '被评论的帖子(外键)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_postingSay_user_1`(`user` ASC) USING BTREE,
  INDEX `fk_postingSay_posting_1`(`posting` ASC) USING BTREE,
  CONSTRAINT `fk_postingSay_posting_1` FOREIGN KEY (`posting`) REFERENCES `posting` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_postingSay_user_1` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '帖子评论记录表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of postingsay
-- ----------------------------
INSERT INTO `postingsay` VALUES (1, '骗子太可恶', '2022-05-12 08:00:00', 2, 1);
INSERT INTO `postingsay` VALUES (3, '冒充公检法诈骗“洗脑”多可怕？', '2022-05-03 08:00:00', 4, 3);
INSERT INTO `postingsay` VALUES (4, '全民反诈', '2022-08-17 16:26:05', 8, 6);
INSERT INTO `postingsay` VALUES (5, '不要让一些平台打着正规的平台，然后投放虚假的广告', '2022-08-12 16:26:05', 6, 7);
INSERT INTO `postingsay` VALUES (6, '很多冒充北方公安机关的骗子，口音都对不上', '2022-08-17 16:26:05', 14, 8);
INSERT INTO `postingsay` VALUES (7, '请国家反诈中心研究一套行之有效的好办法，让骗子再也无法用他人手机号银行卡骗到钱，个人觉得只有从电信运营商和金融机构入手，每个月进行一次人脸识别指纹识别限制非本人使用，让骗子买来的“两卡”作废', '2022-08-19 16:26:05', 15, 9);
INSERT INTO `postingsay` VALUES (8, '京东金融客服网贷诈骗，这是现在最普遍的', '2022-08-25 16:26:05', 16, 1);
INSERT INTO `postingsay` VALUES (9, '是的   征信类诈骗是最普遍的   时间短损失金额巨大', '2022-09-02 16:26:05', 17, 1);
INSERT INTO `postingsay` VALUES (10, '严厉打击养老诈骗', '2022-06-05 00:00:00', 2, 1);

-- ----------------------------
-- Table structure for postingsaylike
-- ----------------------------
DROP TABLE IF EXISTS `postingsaylike`;
CREATE TABLE `postingsaylike`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user` int NULL DEFAULT NULL COMMENT '评论点赞的用户(外键)',
  `postingSay` int NULL DEFAULT NULL COMMENT '被用户点赞的评论(外键)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_postingSayLike_user_1`(`user` ASC) USING BTREE,
  INDEX `fk_postingSayLike_postingSay_1`(`postingSay` ASC) USING BTREE,
  CONSTRAINT `fk_postingSayLike_postingSay_1` FOREIGN KEY (`postingSay`) REFERENCES `postingsay` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_postingSayLike_user_1` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '评论点赞记录表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of postingsaylike
-- ----------------------------
INSERT INTO `postingsaylike` VALUES (1, 2, 1);
INSERT INTO `postingsaylike` VALUES (2, 4, 3);
INSERT INTO `postingsaylike` VALUES (4, 4, 1);
INSERT INTO `postingsaylike` VALUES (5, 5, 4);
INSERT INTO `postingsaylike` VALUES (6, 6, 6);
INSERT INTO `postingsaylike` VALUES (7, 8, 7);
INSERT INTO `postingsaylike` VALUES (8, 14, 8);
INSERT INTO `postingsaylike` VALUES (9, 15, 9);
INSERT INTO `postingsaylike` VALUES (10, 16, 10);
INSERT INTO `postingsaylike` VALUES (12, 17, 1);
INSERT INTO `postingsaylike` VALUES (13, 18, 3);
INSERT INTO `postingsaylike` VALUES (15, 5, 1);
INSERT INTO `postingsaylike` VALUES (16, 6, 1);
INSERT INTO `postingsaylike` VALUES (17, 14, 1);
INSERT INTO `postingsaylike` VALUES (18, 15, 1);

-- ----------------------------
-- Table structure for sex
-- ----------------------------
DROP TABLE IF EXISTS `sex`;
CREATE TABLE `sex`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '性别(0-男, 1-女)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '性别表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sex
-- ----------------------------
INSERT INTO `sex` VALUES (1, '男');
INSERT INTO `sex` VALUES (2, '女');

-- ----------------------------
-- Table structure for sign
-- ----------------------------
DROP TABLE IF EXISTS `sign`;
CREATE TABLE `sign`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '签到地点',
  `date` datetime NULL DEFAULT NULL COMMENT '签到时间',
  `user` int NULL DEFAULT NULL COMMENT '签到的用户(外键)',
  `activity` int NULL DEFAULT NULL COMMENT '被签到的活动(外键)',
  `type` int NULL DEFAULT NULL COMMENT '签到状态(外键)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_sign_type_1`(`type` ASC) USING BTREE,
  INDEX `fk_sign_activity_1`(`activity` ASC) USING BTREE,
  INDEX `fk_sign_user_1`(`user` ASC) USING BTREE,
  CONSTRAINT `fk_sign_activity_1` FOREIGN KEY (`activity`) REFERENCES `activity` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_sign_type_1` FOREIGN KEY (`type`) REFERENCES `type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_sign_user_1` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 75 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '活动签到表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sign
-- ----------------------------
INSERT INTO `sign` VALUES (4, '本部', '2022-10-07 10:00:00', 2, 1, 1);
INSERT INTO `sign` VALUES (5, 'B街道', '2022-10-09 18:00:00', 4, 3, 2);
INSERT INTO `sign` VALUES (8, 'C街道', '2022-10-10 10:00:00', 5, 4, 1);
INSERT INTO `sign` VALUES (11, '本部', '2022-10-11 10:00:00', 15, 5, 2);
INSERT INTO `sign` VALUES (12, 'A街道', '2022-10-11 13:00:00', 16, 6, 1);
INSERT INTO `sign` VALUES (44, 'D街道', '2022-10-12 10:00:00', 17, 13, 2);
INSERT INTO `sign` VALUES (45, '本部', '2022-10-13 10:00:00', 18, 18, 1);
INSERT INTO `sign` VALUES (46, 'A街道', '2022-09-14 00:00:00', 4, 19, 2);
INSERT INTO `sign` VALUES (65, NULL, '2022-09-24 12:59:19', 2, 6, 1);
INSERT INTO `sign` VALUES (66, NULL, '2022-09-24 12:59:27', 2, 6, 1);
INSERT INTO `sign` VALUES (67, NULL, '2022-09-24 12:59:33', 2, 6, 1);
INSERT INTO `sign` VALUES (68, NULL, '2022-09-24 13:00:10', 2, 6, 1);
INSERT INTO `sign` VALUES (69, NULL, '2022-09-24 13:06:22', 2, 6, 1);
INSERT INTO `sign` VALUES (70, NULL, '2022-09-24 13:06:27', 2, 6, 1);
INSERT INTO `sign` VALUES (71, NULL, '2022-09-24 13:08:12', 2, 6, 1);
INSERT INTO `sign` VALUES (72, NULL, '2022-09-24 13:08:18', 2, 6, 1);
INSERT INTO `sign` VALUES (73, NULL, '2022-09-24 13:10:57', 2, 6, 1);
INSERT INTO `sign` VALUES (74, NULL, '2022-09-24 13:11:20', 2, 6, 1);

-- ----------------------------
-- Table structure for state
-- ----------------------------
DROP TABLE IF EXISTS `state`;
CREATE TABLE `state`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '活动状态(0-报名中, 1-进行中, 2-已结束)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '活动状态表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of state
-- ----------------------------
INSERT INTO `state` VALUES (1, '报名中');
INSERT INTO `state` VALUES (2, '进行中');
INSERT INTO `state` VALUES (3, '已结束');
INSERT INTO `state` VALUES (4, '审核中');
INSERT INTO `state` VALUES (5, '报名未开始');

-- ----------------------------
-- Table structure for study
-- ----------------------------
DROP TABLE IF EXISTS `study`;
CREATE TABLE `study`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '文章名字',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '文章内容',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '文章封面图(路径)',
  `date` datetime NULL DEFAULT NULL COMMENT '文章发布时间',
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '文章地点(可填)',
  `user` int NULL DEFAULT NULL COMMENT '发表文章的用户',
  `type` int NULL DEFAULT NULL COMMENT '文章的类型',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_study_user_1`(`user` ASC) USING BTREE,
  INDEX `fk_study_studyType_1`(`type` ASC) USING BTREE,
  CONSTRAINT `fk_study_studyType_1` FOREIGN KEY (`type`) REFERENCES `studytype` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_study_user_1` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 124 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '学习文章' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of study
-- ----------------------------
INSERT INTO `study` VALUES (69, '又一个新型骗局出现了！大家请注意', 'http://www.wuhuazai.com/uploadeview/v01_ (1).mp4', 'http://www.wuhuazai.com/uploadeview/1663980835416t1.png', '2022-09-21 10:59:01', 'null', 8, 9);
INSERT INTO `study` VALUES (70, '盘点反诈老陈pk各路主播', 'http://www.wuhuazai.com/uploadeview/v01_ (2).mp4', 'http://www.wuhuazai.com/uploadeview/1663980912024t2.png', '2022-09-22 10:59:01', 'null', 8, 9);
INSERT INTO `study` VALUES (71, '网络骗术花样多，莫把虚拟当现实', 'http://www.wuhuazai.com/uploadeview/v01_ (3).mp4', 'http://www.wuhuazai.com/uploadeview/1663983488073shi03.jpg', '2022-09-23 10:59:01', 'null', 8, 9);
INSERT INTO `study` VALUES (72, '刷单返利诈骗\"受害人\"现身说法', 'http://www.wuhuazai.com/uploadeview/v01_ (4).mp4', 'http://www.wuhuazai.com/uploadeview/1663983854002t3.png', '2022-09-24 10:59:01', 'null', 8, 9);
INSERT INTO `study` VALUES (90, NULL, 'http://www.wuhuazai.com/uploadeview/VCG (1).gif', NULL, '2022-09-01 11:19:48', NULL, 8, 5);
INSERT INTO `study` VALUES (91, NULL, 'http://www.wuhuazai.com/uploadeview/VCG (2).gif', NULL, '2022-09-02 11:19:48', NULL, 8, 5);
INSERT INTO `study` VALUES (92, NULL, 'http://www.wuhuazai.com/uploadeview/VCG (3).gif', NULL, '2022-09-03 11:19:48', NULL, 8, 5);
INSERT INTO `study` VALUES (93, NULL, 'http://www.wuhuazai.com/uploadeview/VCG (1).jpg', NULL, '2022-09-04 11:19:48', NULL, 8, 5);
INSERT INTO `study` VALUES (94, NULL, 'http://www.wuhuazai.com/uploadeview/VCG (2).jpg', NULL, '2022-09-05 11:19:48', NULL, 8, 5);
INSERT INTO `study` VALUES (95, NULL, 'http://www.wuhuazai.com/uploadeview/VCG (3).jpg', NULL, '2022-09-06 11:19:48', NULL, 8, 5);
INSERT INTO `study` VALUES (96, NULL, 'http://www.wuhuazai.com/uploadeview/VCG (4).jpg', NULL, '2022-09-07 11:19:48', NULL, 8, 5);
INSERT INTO `study` VALUES (97, NULL, 'http://www.wuhuazai.com/uploadeview/VCG (5).jpg', NULL, '2022-09-08 11:19:48', NULL, 8, 5);
INSERT INTO `study` VALUES (98, NULL, 'http://www.wuhuazai.com/uploadeview/VCG (6).jpg', NULL, '2022-09-09 11:19:48', NULL, 8, 5);
INSERT INTO `study` VALUES (99, NULL, 'http://www.wuhuazai.com/uploadeview/VCG (7).jpg', NULL, '2022-09-10 11:19:48', NULL, 8, 5);
INSERT INTO `study` VALUES (107, '江苏警方发布“羊了个羊”防骗指南', '<img src=\"http://www.wuhuazai.com/uploadeview/1663899584510yang01.jpg\">\n<div><img src=\"http://www.wuhuazai.com/uploadeview/1663899620353yang02.jpg\"><br>\n</div>\n<div><img src=\"http://www.wuhuazai.com/uploadeview/1663899654995yang03.jpg\"><br>\n</div>\n<div><img src=\"http://www.wuhuazai.com/uploadeview/1663899686667yang04.jpg\"><br>\n</div>\n<div><img src=\"http://www.wuhuazai.com/uploadeview/1663899706408yang05.jpg\"><br>\n</div>', 'http://www.wuhuazai.com/uploadeview/1663900084983yang.jpg', '2022-09-23 10:14:59', '浙江省宁波市镇海区', 6, 7);
INSERT INTO `study` VALUES (108, '网络贷款，让你的信任无处安放', '<img src=\"http://www.wuhuazai.com/uploadeview/1663900497055dai01.jpg\">\n<div><img src=\"http://www.wuhuazai.com/uploadeview/1663900516336dai02.jpg\"></div>\n<div><br>\n<div><br>\n</div>\n</div>\n<div><img src=\"http://www.wuhuazai.com/uploadeview/1663900577686dai04.jpg\"><br>\n</div>\n<div><br>\n</div>\n<div><br>\n</div>\n<div><br>\n</div>', 'http://www.wuhuazai.com/uploadeview/1663900762851dai.png', '2022-09-23 10:30:16', '浙江省宁波市镇海区', 6, 7);
INSERT INTO `study` VALUES (109, '一无所有，还是负债更多？', '<img src=\"http://www.wuhuazai.com/uploadeview/1663906405898fu01.jpg\">\n<div><img src=\"http://www.wuhuazai.com/uploadeview/1663906610066fu02.jpg\"><br>\n</div>', 'http://www.wuhuazai.com/uploadeview/1663908830647yi.png', '2022-09-23 12:14:50', '浙江省宁波市镇海区', 6, 4);
INSERT INTO `study` VALUES (110, '路边的二维码，你不要扫哇不要扫', '<img src=\"http://www.wuhuazai.com/uploadeview/1663907296466ma01.jpg\">\n<div><img src=\"http://www.wuhuazai.com/uploadeview/1663907316417ma02.jpg\"><br>\n</div>\n<div><img src=\"http://www.wuhuazai.com/uploadeview/1663907603212ma03.jpg\"><br>\n</div>\n<div><img src=\"http://www.wuhuazai.com/uploadeview/1663907658120ma04.jpg\"><br>\n</div>\n<div><br>\n</div>\n<div><br>\n</div>', 'http://www.wuhuazai.com/uploadeview/1663908367307ma.png', '2022-09-23 12:26:36', '浙江省宁波市镇海区', 6, 4);
INSERT INTO `study` VALUES (111, '你被赌博平台耍了', '<img src=\"http://www.wuhuazai.com/uploadeview/1663907684360ma05.jpg\">\n<div><img src=\"http://www.wuhuazai.com/uploadeview/1663908055726ma06.jpg\"><br>\n</div>\n<div><img src=\"http://www.wuhuazai.com/uploadeview/1663908079706ma07.jpg\"><br>\n</div>', 'http://www.wuhuazai.com/uploadeview/1663908200044bo.png', '2022-09-23 12:40:08', '浙江省宁波市镇海区', 6, 4);
INSERT INTO `study` VALUES (112, '嘿！今天的骗术有点意思', '<img src=\"http://www.wuhuazai.com/uploadeview/1663908673582fu03.jpg\">\n<div><img src=\"http://www.wuhuazai.com/uploadeview/1663908705777fu04.jpg\"><br>\n</div>\n<div><img src=\"http://www.wuhuazai.com/uploadeview/1663908730615fu05.jpg\"><br>\n</div>', 'http://www.wuhuazai.com/uploadeview/1663908774717fu.jpg', '2022-09-23 12:50:48', '浙江省宁波市镇海区', 6, 4);
INSERT INTO `study` VALUES (113, '想不到！QQ群里的老乡竟然是这样的人...', '<img src=\"http://www.wuhuazai.com/uploadeview/1663909303108qq01.jpg\">\n<div><img src=\"http://www.wuhuazai.com/uploadeview/1663909328390qq02.jpg\"><br>\n</div>', 'http://www.wuhuazai.com/uploadeview/1663913511547屏幕截图 2022-09-23 141028.png', '2022-09-23 12:59:28', '浙江省宁波市镇海区', 6, 1);
INSERT INTO `study` VALUES (114, '投资电影只需要7块5！', '<img src=\"http://www.wuhuazai.com/uploadeview/1663909560917wo01.jpg\">\n<div><br>\n<div><br>\n</div>\n</div>\n<div><img src=\"http://www.wuhuazai.com/uploadeview/1663909633644wo04.jpg\"><br>\n</div>', 'http://www.wuhuazai.com/uploadeview/1663909765912wo.png', '2022-09-23 13:04:22', '浙江省宁波市镇海区', 6, 1);
INSERT INTO `study` VALUES (115, '我和你，男和女，都要提放这帮人', '<img src=\"http://www.wuhuazai.com/uploadeview/1663910070448www01.jpg\">\n<div><img src=\"http://www.wuhuazai.com/uploadeview/1663910130979wo02.jpg\"><br>\n</div>\n<div><img src=\"http://www.wuhuazai.com/uploadeview/1663910161820wo03.jpg\"><br>\n</div>', 'http://www.wuhuazai.com/uploadeview/1663910250754www.png', '2022-09-23 13:13:58', '浙江省宁波市镇海区', 6, 1);
INSERT INTO `study` VALUES (116, '醒醒吧！别再被虚假投资平台诈骗了', '<img src=\"http://www.wuhuazai.com/uploadeview/1663910349361xu001.jpg\">\n<div><img src=\"http://www.wuhuazai.com/uploadeview/1663910371244xu002.jpg\"><br>\n</div>\n<div><img src=\"http://www.wuhuazai.com/uploadeview/1663910443014xu003.jpg\"><br>\n</div>\n<div><br>\n</div>', 'http://www.wuhuazai.com/uploadeview/1663910607145xu.png', '2022-09-23 13:18:36', '浙江省宁波市镇海区', 6, 1);
INSERT INTO `study` VALUES (118, '桂林某公司遭“黑客”入侵！被骗365万？', '<img src=\"http://www.wuhuazai.com/uploadeview/1663910914614ke01.jpg\">\n<div><img src=\"http://www.wuhuazai.com/uploadeview/1663910944170ke02.jpg\"><br>\n</div>\n<div><img src=\"http://www.wuhuazai.com/uploadeview/1663910968349ke03.jpg\"><br>\n</div>\n<div><br>\n</div>', 'http://www.wuhuazai.com/uploadeview/1663911063804ke.png', '2022-09-23 13:28:13', '浙江省宁波市镇海区', 6, 2);
INSERT INTO `study` VALUES (119, '这样的红包要谨慎！！', '<img src=\"http://www.wuhuazai.com/uploadeview/1663911145463hong01.jpg\">\n<div><img src=\"http://www.wuhuazai.com/uploadeview/1663911179253hong02.jpg\"><br>\n</div>\n<div><img src=\"http://www.wuhuazai.com/uploadeview/1663911203851hong03.jpg\"><br>\n</div>', 'http://www.wuhuazai.com/uploadeview/1663911492352bu.png', '2022-09-23 13:31:17', '浙江省宁波市镇海区', 6, 2);
INSERT INTO `study` VALUES (120, '打工人，打工魂，网上办公要留神！', '<img src=\"http://www.wuhuazai.com/uploadeview/1663911561308da01.jpg\">\n<div><img src=\"http://www.wuhuazai.com/uploadeview/1663911590413da02.jpg\"><br>\n</div>\n<div><img src=\"http://www.wuhuazai.com/uploadeview/1663911613453da03.jpg\"><br>\n</div>', 'http://www.wuhuazai.com/uploadeview/1663912017659da01.png', '2022-09-23 13:38:29', '浙江省宁波市镇海区', 6, 2);
INSERT INTO `study` VALUES (121, '一元骗局盗刷银行卡要留神！！！', '<img src=\"http://www.wuhuazai.com/uploadeview/1663912640132yu01.jpg\">\n<div><img src=\"http://www.wuhuazai.com/uploadeview/1663912660089yu02.jpg\"><br>\n</div>', 'http://www.wuhuazai.com/uploadeview/1663912878968yu.png', '2022-09-23 13:56:41', '浙江省宁波市镇海区', 6, 2);
INSERT INTO `study` VALUES (122, '“感情咨询”骗局揭晓', '<img src=\"http://www.wuhuazai.com/uploadeview/1663913184425dai05.jpg\">\n<div><br>\n<div><img src=\"http://www.wuhuazai.com/uploadeview/1663913292012dai07.jpg\"><br>\n</div>\n</div>', 'http://www.wuhuazai.com/uploadeview/1663913616487v2-6d7aa62dd5677a46b675e984c82505db_1440w.jpg', '2022-09-23 14:06:06', '浙江省宁波市镇海区', 6, 7);
INSERT INTO `study` VALUES (123, '网购放诈攻略', '<img src=\"http://www.wuhuazai.com/uploadeview/1663913375902dai03.jpg\">\n<div><img src=\"http://www.wuhuazai.com/uploadeview/1663913395467dai04.jpg\"><br>\n</div>', 'http://www.wuhuazai.com/uploadeview/1663913628846v2-4c764791ce920b7a112de171eb5cc10a_1440w.jpg', '2022-09-23 14:09:28', '浙江省宁波市镇海区', 6, 7);

-- ----------------------------
-- Table structure for studylike
-- ----------------------------
DROP TABLE IF EXISTS `studylike`;
CREATE TABLE `studylike`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user` int NULL DEFAULT NULL COMMENT '用户(外键)',
  `study` int NULL DEFAULT NULL COMMENT '学习文章(外键)',
  `likeType` int NULL DEFAULT NULL COMMENT '类型(点赞,收藏)(外键)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_studyLike_user`(`user` ASC) USING BTREE,
  INDEX `fk_studyLike_study`(`study` ASC) USING BTREE,
  INDEX `fk_studyLike_likeType`(`likeType` ASC) USING BTREE,
  CONSTRAINT `fk_studyLike_likeType` FOREIGN KEY (`likeType`) REFERENCES `liketype` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_studyLike_study` FOREIGN KEY (`study`) REFERENCES `study` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_studyLike_user` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 109 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '文章点赞or收藏' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of studylike
-- ----------------------------
INSERT INTO `studylike` VALUES (54, 2, 70, 1);
INSERT INTO `studylike` VALUES (55, 2, 70, 1);
INSERT INTO `studylike` VALUES (56, 2, 69, 1);
INSERT INTO `studylike` VALUES (57, 2, 111, 1);
INSERT INTO `studylike` VALUES (58, 2, 113, 1);
INSERT INTO `studylike` VALUES (59, 2, 113, 1);
INSERT INTO `studylike` VALUES (60, 2, 113, 1);
INSERT INTO `studylike` VALUES (61, 2, 113, 1);
INSERT INTO `studylike` VALUES (62, 5, 69, 2);
INSERT INTO `studylike` VALUES (63, 4, 107, 1);
INSERT INTO `studylike` VALUES (64, 4, 107, 2);
INSERT INTO `studylike` VALUES (65, 4, 69, 1);
INSERT INTO `studylike` VALUES (66, 4, 69, 1);
INSERT INTO `studylike` VALUES (67, 4, 69, 1);
INSERT INTO `studylike` VALUES (68, 4, 69, 1);
INSERT INTO `studylike` VALUES (69, 4, 69, 1);
INSERT INTO `studylike` VALUES (70, 4, 69, 1);
INSERT INTO `studylike` VALUES (71, 4, 69, 1);
INSERT INTO `studylike` VALUES (72, 4, 69, 1);
INSERT INTO `studylike` VALUES (73, 4, 69, 1);
INSERT INTO `studylike` VALUES (74, 4, 71, 1);
INSERT INTO `studylike` VALUES (75, 4, 71, 1);
INSERT INTO `studylike` VALUES (77, 5, 69, 2);
INSERT INTO `studylike` VALUES (78, 5, 69, 2);
INSERT INTO `studylike` VALUES (80, 2, 69, 1);
INSERT INTO `studylike` VALUES (81, 2, 113, 1);
INSERT INTO `studylike` VALUES (82, 2, 69, 1);
INSERT INTO `studylike` VALUES (83, 2, 70, 1);
INSERT INTO `studylike` VALUES (84, 5, 69, 2);
INSERT INTO `studylike` VALUES (85, 2, 69, 1);
INSERT INTO `studylike` VALUES (86, 2, 69, 1);
INSERT INTO `studylike` VALUES (88, 2, 113, 1);
INSERT INTO `studylike` VALUES (89, 2, 113, 1);
INSERT INTO `studylike` VALUES (90, 2, 113, 1);
INSERT INTO `studylike` VALUES (91, 2, 113, 1);
INSERT INTO `studylike` VALUES (92, 2, 113, 1);
INSERT INTO `studylike` VALUES (93, 2, 113, 1);
INSERT INTO `studylike` VALUES (94, 2, 113, 1);
INSERT INTO `studylike` VALUES (95, 2, 113, 1);
INSERT INTO `studylike` VALUES (96, 2, 113, 1);
INSERT INTO `studylike` VALUES (97, 2, 113, 1);
INSERT INTO `studylike` VALUES (98, 2, 113, 1);
INSERT INTO `studylike` VALUES (99, 2, 113, 1);
INSERT INTO `studylike` VALUES (100, 2, 113, 1);
INSERT INTO `studylike` VALUES (101, 2, 113, 1);
INSERT INTO `studylike` VALUES (102, 2, 113, 1);
INSERT INTO `studylike` VALUES (103, 2, 107, 1);
INSERT INTO `studylike` VALUES (104, 2, 108, 2);
INSERT INTO `studylike` VALUES (105, 18, 107, 1);
INSERT INTO `studylike` VALUES (106, 18, 107, 2);
INSERT INTO `studylike` VALUES (107, 2, 70, 1);
INSERT INTO `studylike` VALUES (108, 2, 107, 1);

-- ----------------------------
-- Table structure for studysay
-- ----------------------------
DROP TABLE IF EXISTS `studysay`;
CREATE TABLE `studysay`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `say` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '评论内容',
  `date` datetime NULL DEFAULT NULL COMMENT '评论时间',
  `user` int NULL DEFAULT NULL COMMENT '评论用户(外键)',
  `study` int NULL DEFAULT NULL COMMENT '评论文章(外键)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_studySay_study`(`study` ASC) USING BTREE,
  INDEX `fk_studySay_user`(`user` ASC) USING BTREE,
  CONSTRAINT `fk_studySay_study` FOREIGN KEY (`study`) REFERENCES `study` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_studySay_user` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of studysay
-- ----------------------------
INSERT INTO `studysay` VALUES (38, '现在诈骗团队一般都在境外，以前还能联合执法三不五时抓一飞机回来，现在国外疫情肆虐，出入境办案困难，骗子更猖狂了。', '2022-09-01 11:05:16', 2, 107);
INSERT INTO `studysay` VALUES (39, '我们觉得很可笑的骗局 都有人被骗 谁不想轻松去赚钱 你上一个月班赚的钱 可能就是人家轻轻松松几分钟 不是每个人都能抗住这种诱惑的', '2022-08-31 11:05:21', 4, 107);
INSERT INTO `studysay` VALUES (41, '世界上丝毫没有良心的人简直不要太多', '2022-09-03 11:05:27', 15, 70);
INSERT INTO `studysay` VALUES (43, '现在有很多打着感情的幌子行骗，要小心', '2022-09-05 11:05:30', 17, 69);
INSERT INTO `studysay` VALUES (44, '如果自己不贪心 ，就不会被诈骗。', '2022-09-23 11:05:49', 18, 70);
INSERT INTO `studysay` VALUES (45, '博士被骗的也不少，和学历没关，主要和阅历，贪心程度和反诈知识有关', '2022-09-24 11:05:30', 19, 70);
INSERT INTO `studysay` VALUES (46, '不管骗子多高明，钱笫一步通过手机银行转账，如果对持卡人追邢事责任，以后就没有人随便为了小利益，转借银行卡', '2022-09-25 11:05:30', 20, 70);
INSERT INTO `studysay` VALUES (51, '骗子太可恶了', '2022-09-24 14:22:06', 19, 90);
INSERT INTO `studysay` VALUES (52, '也许骗子就在你对面', '2022-09-24 14:45:17', 18, 90);
INSERT INTO `studysay` VALUES (53, '小心被骗', '2022-09-24 14:50:03', 2, 71);
INSERT INTO `studysay` VALUES (54, '小心骗子', '2022-09-24 14:50:46', 2, 69);
INSERT INTO `studysay` VALUES (55, '大家小心了', '2022-09-24 14:51:52', 2, 69);

-- ----------------------------
-- Table structure for studysaylike
-- ----------------------------
DROP TABLE IF EXISTS `studysaylike`;
CREATE TABLE `studysaylike`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user` int NULL DEFAULT NULL COMMENT '点赞用户(外键)',
  `studySay` int NULL DEFAULT NULL COMMENT '点赞评论(外键)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_studySayLike_user`(`user` ASC) USING BTREE,
  INDEX `fk_studySayLike_studySay`(`studySay` ASC) USING BTREE,
  CONSTRAINT `fk_studySayLike_studySay` FOREIGN KEY (`studySay`) REFERENCES `studysay` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_studySayLike_user` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of studysaylike
-- ----------------------------
INSERT INTO `studysaylike` VALUES (20, 2, 39);

-- ----------------------------
-- Table structure for studysayuser
-- ----------------------------
DROP TABLE IF EXISTS `studysayuser`;
CREATE TABLE `studysayuser`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `say` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '评论内容',
  `date` datetime NULL DEFAULT NULL COMMENT '评论时间',
  `user` int NULL DEFAULT NULL COMMENT '评论用户',
  `byUser` int NULL DEFAULT NULL COMMENT '被评论的用户',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_studySayUser_user`(`user` ASC) USING BTREE,
  INDEX `fk_studySayUser_user_byUser`(`byUser` ASC) USING BTREE,
  CONSTRAINT `fk_studySayUser_studySay` FOREIGN KEY (`byUser`) REFERENCES `studysay` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_studySayUser_user` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of studysayuser
-- ----------------------------
INSERT INTO `studysayuser` VALUES (12, '并不是，很多老实人知道贪小便宜容易吃亏，所以他们不会因为贪心被骗。但是他们还是被骗了，因为骗子会利用人的各种心理设局，比如以警察的身份跟你说你涉及到某个案子，比如你被开通了贷款，如果你不按照他们的步骤来，你的征信会有问题还会产生滞纳金，又比如他们会用技术模仿你亲人朋友的声音，说自己现在情况紧急，需要你马上转一笔钱，等等', '2022-09-01 11:05:12', 20, 44);

-- ----------------------------
-- Table structure for studytype
-- ----------------------------
DROP TABLE IF EXISTS `studytype`;
CREATE TABLE `studytype`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '(0-案例, 1-心里篇, 2-技术篇.....)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '文章类型' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of studytype
-- ----------------------------
INSERT INTO `studytype` VALUES (1, '心理防线');
INSERT INTO `studytype` VALUES (2, '信息安全');
INSERT INTO `studytype` VALUES (4, '身边案例');
INSERT INTO `studytype` VALUES (5, '视觉探索');
INSERT INTO `studytype` VALUES (6, '学习视频');
INSERT INTO `studytype` VALUES (7, '健康上网');
INSERT INTO `studytype` VALUES (8, '反诈资讯');
INSERT INTO `studytype` VALUES (9, '抖音视频');

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '签到状态(0-签到, 1-签退)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '签到状态表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES (1, '签到');
INSERT INTO `type` VALUES (2, '签退');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户表id',
  `number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '用户学号/工号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '用户密码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '用户姓名',
  `introduce` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '用户简介',
  `birthday` date NULL DEFAULT NULL COMMENT '用户生日',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '用户手机号',
  `mail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '用户邮箱',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '头像路径',
  `sex` int NULL DEFAULT NULL COMMENT '用户性别(外键)',
  `level` int NULL DEFAULT NULL COMMENT '用户权限(外键)',
  `institute` int NULL DEFAULT NULL COMMENT '用户所属学院(外键)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_user_institute_1`(`institute` ASC) USING BTREE,
  INDEX `fk_user_sex_1`(`sex` ASC) USING BTREE,
  INDEX `fk_user_userLevel_1`(`level` ASC) USING BTREE,
  CONSTRAINT `fk_user_institute_1` FOREIGN KEY (`institute`) REFERENCES `institute` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_user_sex_1` FOREIGN KEY (`sex`) REFERENCES `sex` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_user_userLevel_1` FOREIGN KEY (`level`) REFERENCES `userlevel` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (2, '2020009025', '1234567', '骆小天', '用户很低调，没有留下什么信息', '2003-04-03', '13158766488', '9025@qq.com', 'http://www.wuhuazai.com/uploadeview/1663648161534my_head011.jpg', 1, 1, 1);
INSERT INTO `user` VALUES (4, '2020009026', '123456', '凌丰丰', '这是凌丰丰哦', '2020-04-04', '13108565220', '9026@qq.com', 'http://www.wuhuazai.com/uploadeview/1663648273400my_head12.jpg', 2, 2, 2);
INSERT INTO `user` VALUES (5, '2020009027', '12345678', '林玲', '这是一位教师哦', '1993-04-16', '13185028196', '9027@qq.com', 'http://www.wuhuazai.com/uploadeview/1662857789291daimao01.jpg', 2, 3, 3);
INSERT INTO `user` VALUES (6, '3020009028', '000000', '24小时小助手', '这是24小时校园反诈中心的官方账号，24小时小助手。', '2022-07-01', '9028', '9028@qq.com', 'http://www.wuhuazai.com/uploadeview/1663411675983logoFzp.png', 1, 4, 5);
INSERT INTO `user` VALUES (8, '3020009029', '000000', '反诈小能手', '反诈小能手是官方账号哦！！！', '2020-07-01', '9029', '9029@qq.com', 'http://www.wuhuazai.com/uploadeview/1663411688288logoFzp.png', 1, 4, 8);
INSERT INTO `user` VALUES (14, '2020009030', '123456', '王小晓', '用户很低调，没有留下什么信息', '2000-07-21', '9030', '9030@qq.com', 'http://www.wuhuazai.com/uploadeview/1663646819348my_head043.jpg', 2, 1, 7);
INSERT INTO `user` VALUES (15, '2020009031', '123456', '李小勇', '用户很低调，没有留下什么信息', '2001-01-26', '9031', '9031@qq.com', 'http://www.wuhuazai.com/uploadeview/1663646942685my_head001.jpg', 1, 1, 8);
INSERT INTO `user` VALUES (16, '2020009032', '123456', '林晓', '用户很低调，没有留下什么信息', '2000-01-25', '9032', '9032@qq.com', 'http://www.wuhuazai.com/uploadeview/1663647036278my_head018.jpg', 1, 1, 6);
INSERT INTO `user` VALUES (17, '2020009033', '123456', '杨笑图', '用户很低调，没有留下什么信息', '2000-03-25', '18858444676', '9033@qq.com', 'http://www.wuhuazai.com/uploadeview/1663647134134my_head042.jpg', 2, 1, 3);
INSERT INTO `user` VALUES (18, '2020009034', '123456', '周琳', '用户很低调，没有留下什么信息', '2000-04-14', '13185028166', '9034@qq.com', 'http://www.wuhuazai.com/uploadeview/1663648745312moren.jpg', 2, 1, 1);
INSERT INTO `user` VALUES (19, '2020009035', 'qwertyui1', '徐小徐', '用户很低调，没有留下什么信息', '2003-10-15', '1373879215555', '9035@qq.com', 'http://www.wuhuazai.com/uploadeview/1663740506476logout001.jpeg', 2, 1, 1);
INSERT INTO `user` VALUES (20, '2020009036', '1111111', '徐加加', '用户很低调，没有留下什么信息', '2000-01-11', '1885844343', '9036@qqcom', 'http://www.wuhuazai.com/uploadeview/1663900986403logout003.jpeg', 2, 1, 1);

-- ----------------------------
-- Table structure for userlevel
-- ----------------------------
DROP TABLE IF EXISTS `userlevel`;
CREATE TABLE `userlevel`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `level` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '权限级别(0-普通, 1-干部, 2-管理员)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户权限表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of userlevel
-- ----------------------------
INSERT INTO `userlevel` VALUES (1, '学生');
INSERT INTO `userlevel` VALUES (2, '学生干部');
INSERT INTO `userlevel` VALUES (3, '二级学院管理员');
INSERT INTO `userlevel` VALUES (4, '超级管理员');

SET FOREIGN_KEY_CHECKS = 1;
