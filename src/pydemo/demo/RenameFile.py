#coding=utf-8
import os

# -*- coding: cp936 -*-
import os
path = "F:\\audio\手机录音\\records_former\\六级听力\\"
prefix = "亚纪"
fileList = os.listdir(path)
for file in fileList:
    if file.find(".")>0:
        newName = prefix + file
        print(newName)
        os.rename(path + file,path + newName)

for file in os.listdir(path):
    print(file)

print(len(fileList))