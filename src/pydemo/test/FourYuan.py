#coding=utf-8

for x1 in range(-20,21):
    for x2 in range(-20,20):
        for y1 in range(-20,20):
            for y2 in range(-20,20):
                if x1+x2==8 & y1+y2==6 & x1+y1==13 & x2+y2==8:
                    print(x1+" "+x2+" "+y1+" "+y2)
                # else:
                #     print("continue "+str(x1)+" "+str(x2)+" "+str(y1)+" "+str(y2))

print("end")

