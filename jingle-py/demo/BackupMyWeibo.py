# coding=utf-8
import requests, json, time, random
import MysqlConnector as dao


WEIBO_URL = 'https://api.weibo.com/2/statuses/user_timeline.json' \
            '?access_token=2.00dC4L_DyJJz5D1d9f58bb1f2DU5YB' \
            '&max_id=%s&count=10'
WEIBO_FILE = "weibo.txt"


def getWeibo(url, weiboFile, maxid):
    rawText = requests.get(url % maxid).text
    weiboFile = open(weiboFile, "w", encoding="utf-8")
    weiboFile.write(rawText)
    return rawText


def getFiveWeibo(fromApi = False, maxId = 0):
    weiboText = open(WEIBO_FILE, encoding="utf-8").read()
    if len(weiboText) < 500 or fromApi:
        print("从微博接口读取")
        rawData = json.loads(getWeibo(WEIBO_URL, WEIBO_FILE, maxId))
    else:
        print("从本地文件读取")
        rawData = json.loads(weiboText)
    # print(rawData)
    return rawData["statuses"]

resWeibos = []
mid = 0
while True:
    try:
        fiveWeibo = getFiveWeibo(True,mid)
    except Exception as e:
        raise
    if len(fiveWeibo) == 0:
        print(mid)
        print(fiveWeibo)
        print("获取数据长度为零,程序退出")
        break

    for j in range(len(fiveWeibo)):
        wb = fiveWeibo[j]
        # for (k, v) in i.items():
        #     print("%s: %s" % (k, v))
        resWeibos.append((wb["id"], wb["user"]["name"], wb["created_at"], wb["text"], 0))
        print("id:%s__\nmd:%s"%(wb["id"],wb["mid"]))
        if j == len(fiveWeibo)-1:
            mid = wb["id"]
            print(wb["created_at"])

    print("===============")
    print(mid)
    print(mid-1)
    mid = mid - 1
    time.sleep(random.randint(3,10))

ins = dao.Inserter()
ins.insert("weibo", resWeibos)