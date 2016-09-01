import pymysql.cursors

# Connect to the database
conn = pymysql.connect(host='localhost',
                             user='root',
                             password='123456',
                             db='web1',
                             charset='utf8',
                             cursorclass=pymysql.cursors.DictCursor)

cur = conn.cursor()
cur.execute("SELECT * FROM tuser")
for r in cur.fetchall():
           print(r)
           cur.close()
conn.close()

#‘§±‡“Î?
# sql = "INSERT INTO `users` (`email`, `password`) VALUES (%s, %s)"
# cur.execute(sql, ('webmaster@python.org', 'very-secret'))