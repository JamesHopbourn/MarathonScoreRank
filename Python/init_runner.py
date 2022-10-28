#!/usr/bin/env python3

import os
import pymysql
import pandas as pd

# 定义表格名字
table = 'testM'

# 连接数据库
connection = pymysql.connect(
    user='root',
    password='newpassword',
    host='127.0.01',
    database='demo'
)

# 表格数据转为字典
sheet = pd.read_excel('name.xlsx')
data = sheet.to_dict(orient="records")

# 清空表
cursor = connection.cursor()
cursor.execute(f"DELETE FROM {table}")
connection.commit()

# SQL 插入语句
command = []
for item in data:
    command.append((f"{item['team_name'].rstrip()}", f"{item['personal_bib']:04}",
                   f"{item['personal_name']}", f"{item['gender']}"))
insert_query = f"INSERT INTO {table}(`team_name`,`personal_bib`,`personal_name`, `gender`) VALUES (%s, %s, %s, %s) "

cursor.executemany(insert_query, command)
connection.commit()
cursor.close()
connection.close()
