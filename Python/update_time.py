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

# SQL 插入语句
command = []
for item in data:
    if (type(item['record_time']) is float):
        continue
    command.append((f"{item['record_time']}", f"{item['personal_bib']:04}"))

insert_query = f"update {config['data-table']} set record_time= %s where personal_bib = %s "
cursor = connection.cursor()
cursor.executemany(insert_query, command)
connection.commit()
cursor.close()
connection.close()
