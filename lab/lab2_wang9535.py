class Zillion:
    def __init__(self, digits):
            self.list = []
            digitFound = False
            for i in digits:
                if i.isdigit():
                    digitFound = True
                    self.list.append(int(i))

                elif (i != ' ' and i != ','):
                    raise RuntimeError

            if digitFound == False:
                    raise RuntimeError

    def increment(self):
        nineFound = True
        i = 1
        while(i <= len(self.list)):
            if self.list[-i] == 9:
                self.list[-i] = 0
                i+=1
            else:
                self.list[-i] + =1
                nineFound = False
                break
        if nineFound == True:
            self.list.insert(0,1)

    def isZero(self):
        for i in self.list:
            if i == 0:
                return True
        return False

    def toString(self):
        return ''.join(str(x)for x in self.list)



    #def increment(self):
        #self.list = recursion(self.list)

#def recursion(list):
    #if len(list) == 0:
        #return [1]
    #elif list[-1] != 9:
        #list[-1] += 1
        #return list
    #else:
        #return recursion(list[:-1]) + [0]


try:
  z = Zillion('')
except RuntimeError:
  print('Empty string')

# It must print 'Empty string' without apostrophes. 2 points.

try:
  z = Zillion(' , ')
except RuntimeError:
  print('No digits in the string')

# It must print 'No digits in the string' without apostrophes. 2 points.

try:
  z = Zillion('1+0')
except RuntimeError:
  print('Non-digit in the string')

# It must print 'Non-digit in the string' without apostrophes. 2 points.

try:
  z = Zillion('0')
except RuntimeError:
  print('This must not be printed')

#  It must print nothing. 2 points.

print(z.isZero())    #  It must print True. 2 points.

try:
  z = Zillion('000000000')
except RuntimeError:
  print('This must not be printed')

#  It must print nothing. 2 points.

print(z.isZero())    #  It must print True. 2 points.

try:
  z = Zillion('000 000 000')
except RuntimeError:
  print('This must not be printed')

#  It must print nothing. 2 points.

print(z.isZero())    #  It must print True. 2 points.

try:
  z = Zillion('997')
except RuntimeError:
  print('This must not be printed')

#  It must print nothing.  2 points.

print(z.isZero())    #  It must print False. 2 points.

print(z.toString())  #  It must print 997. 2 points.

z.increment()

print(z.toString())  #  It must print 998. 2 points.

z.increment()

print(z.toString())  #  It must print 999. 2 points.

z.increment()

print(z.toString())  #  It must print 1000. 2 points.

try:
  z = Zillion('0 9,9 9')
except:
  print('This must not be printed')

#  It must print nothing.  3 points.

z.increment()
print(z.toString())  #  It must print 1000. 2 points.




#Empty string
#No digits in the string
#Non-digit in the string
#True
#True
#True
#False
#997
#998
#999
#1000
#1000
