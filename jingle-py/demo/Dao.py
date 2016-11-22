import pymysql.cursors

# Connect to the database
conn = pymysql.connect(host='10.17.36.55',
                             user='root',
                             password='z',
                             db='cloudins',
                             charset='utf8',
                             cursorclass=pymysql.cursors.DictCursor)

cur = conn.cursor()
cur.execute("SELECT start_time FROM yarn_app_result order by record_ts")
startTimes = []
for r in cur.fetchall():
   # print(r)
   startTimes.append(r["start_time"])
   cur.close()
conn.close()

print(len(startTimes))
count = 0
for i in range(0,len(startTimes)-1):
    if startTimes[i] > startTimes[i+1]:
        print(startTimes[i-1])
        print(startTimes[i])
        print(startTimes[i+1])
        print("wrong order %d"%(i))
        count+=1

print("total wrong order: %d"%count)
