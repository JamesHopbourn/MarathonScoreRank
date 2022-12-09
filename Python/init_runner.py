#!/usr/bin/env python3

import yaml
import pymysql
import pandas as pd

with open("../src/main/resources/application.yml", 'r') as f:
    config = yaml.load(f, Loader=yaml.FullLoader)['mysql']
# 连接数据库
connection = pymysql.connect(
    host=config['host'],
    user=config['username'],
    password=config['password'],
    database=config['database'],
)

# 表格数据转为字典
sheet = pd.read_excel('data.xlsx')
data = sheet.to_dict(orient="records")

# 删除表
cursor = connection.cursor()
# cursor.execute(f"DROP TABLE IF EXISTS {config['data-table']}")
# connection.commit()

# 创建表
# cursor.execute(f"""CREATE TABLE {config['table']} (
#       `team_name` char(14) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '团队名字',
#       `personal_bib` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '选手号码',
#       `personal_name` char(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '选手名字',
#       `gender` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '性别',
#       `record_time` time DEFAULT NULL COMMENT '计时时间',
#       `net_time` time DEFAULT NULL COMMENT '净时间',
#       `video_rank` int DEFAULT NULL COMMENT '视频排名',
#       `gender_rank` int DEFAULT NULL COMMENT '性别排名',
#       `overall_rank` int DEFAULT NULL COMMENT '全体排名',
#       `avg_pace` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '平均配速',
#       PRIMARY KEY (`personal_bib`) USING BTREE
#     ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
# """)
# connection.commit()


# SQL 插入语句
command = []
for item in data:
    command.append((f"{item['team_name'].rstrip()}", f"{item['personal_bib']:04}",
                   f"{item['personal_name']}", f"{item['gender']}"))
insert_query = f"INSERT INTO {config['data-table']}(`team_name`,`personal_bib`,`personal_name`, `gender`) VALUES (%s, %s, %s, %s) "

cursor.executemany(insert_query, command)
connection.commit()
cursor.close()
connection.close()
