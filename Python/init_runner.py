#!/usr/bin/env python3

import yaml
import json
import pymysql
import pandas as pd

stream = open("../src/main/resources/application.yml", "r")
config = yaml.load(stream, Loader=yaml.FullLoader)['mysql']

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
    
    command.append((f"{item['team_name'].rstrip()}", f"{item['personal_bib']:04}",
                   f"{item['personal_name']}", f"{item['gender']}"))
insert_query = f"INSERT INTO {config['data-table']}(`team_name`,`personal_bib`,`personal_name`, `gender`) VALUES (%s, %s, %s, %s) "

cursor = connection.cursor()
cursor.executemany(insert_query, command)
connection.commit()
cursor.close()
connection.close()
