#!/usr/bin/env python3

import yaml
import pymysql
import pandas as pd

# 定义表格名字
table = 'testM'

with open("../src/main/resources/application.yml", 'r') as f:
    config = yaml.load(f, Loader=yaml.FullLoader)['spring']['datasource']
# 连接数据库
connection = pymysql.connect(
    user=config['username'],
    password=config['password'],
    host='127.0.0.1',
    database='demo'
)

# 表格数据转为字典
sheet = pd.read_excel('data.xlsx')
data = sheet.to_dict(orient="records")

# SQL 插入语句
command = []
for item in data:
    if (type(item['record_time']) is float):
        continue
    command.append((f"{item['record_time']}", f"{item['personal_bib']:04}"))

insert_query = f"update {table} set record_time= %s where personal_bib = %s "
cursor = connection.cursor()
cursor.executemany(insert_query, command)
connection.commit()
cursor.close()
connection.close()
