#coding=utf-8

import os
import sys

dir = "G:/temp/pages"
prefix = "E"
postfix = ".jpg"
cdtn = ".png"


def reName(dir, postfix, cdtn, prefix=""):
    os.chdir(dir)
    files = os.listdir(dir)
    count = 0
    for file in files:
        if file.endswith(cdtn):
            count+=1
            newFileName = prefix + str(count) + postfix
            print(file+" -->",end=" ")
            print(newFileName)
            os.rename(file,newFileName)

reName(dir, postfix, cdtn, prefix)

