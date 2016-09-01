from urllib import request
import re

def write():
    url = "http://www.bing.com/"
    webdata = request.urlopen(url).read()
    output = open("page.html","w", encoding="utf-8")
    output.write(webdata.decode("utf-8"))
    output.close()

write()
