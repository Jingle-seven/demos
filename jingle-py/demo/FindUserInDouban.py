#coding=utf-8
import re
import urllib.request

def findUsers(userName,start=0,count=100):
    name = urllib.parse.quote(userName)
    req = urllib.request.Request("https://api.douban.com/v2/user?q=%s&count=%d&start=%d"%(name,count,start))
    data = urllib.request.urlopen(req).read()
    return data.decode("utf-8")

d = findUsers("zipkin")
print(d)
