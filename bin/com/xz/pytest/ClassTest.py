
class Dog(object):
    def __init__(self,name="dog"):
        self.name = name

    def say(self):
        print("this is a "+self.name)