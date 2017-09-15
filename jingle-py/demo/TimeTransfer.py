# coding=utf-8

import MysqlConnector as dao
import pymysql,time

finder = dao.Finder()
weibos = finder.findAll("weibo")

cur = finder.conn.cursor()
for i in weibos:
    print(i['time'])
    #转成时间数组
    timeArray = time.strptime(i['time'], "%Y-%m-%d %H:%M")
    # #转换成时间戳
    ts = time.mktime(timeArray)
    print(int(ts))
    cur.execute("update weibo set ts = '%s' where id = '%s'" %(int(ts),i['id']))
    pass

finder.conn.commit()

# for i in finder.findAll("weibo"):
#     print(i['time'])

