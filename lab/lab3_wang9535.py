#import functools
#def Maximum(T):
    #return functools.reduce(lambda a,b: a if a > b else b, T)

def Sort(T):
    if len(T) <= 1:
        return T
    else:
        return Sort(Remove(T,Maximum(T))) +(Maximum(T),)

def Maximum(T):
    if len(T) == 1:
        return T[0]
    else:
        if T[0] > Maximum(T[1:]):
            return T[0]
        else:
            return Maximum(T[1:])

def Remove(T,E):
    if len(T) == 0:
        return ()
    elif T[0] == E:
        return T[1:]
    else:
        return (T[0],) + Remove(T[1:],E)





print(Maximum((1,)))                      #  1                            2 pt.
print(Maximum((-2, -1)))                  # -1                            2 pt.
print(Maximum((1, 1)))                    #  1                            2 pt.
print(Maximum((1, 2, 3)))                 #  3                            2 pt.

print(Remove((), 1))                      #  ()                           2 pt.
print(Remove((1,), 1))                    #  ()                           2 pt.
print(Remove((0, 1), 0))                  #  (1,)                         2 pt.
print(Remove((0, 1, 2, 1, 3), 1))         #  (0, 2, 1, 3)                 2 pt.
print(Remove((0, 1, 2, 1, 3), 2))         #  (0, 1, 1, 3)                 2 pt.
print(Remove((1, 2, 3), 3))               #  (1, 2)                       2 pt.

print(Sort(()))                           #  ()                           2 pt.
print(Sort((0,)))                         #  (0,)                         2 pt.
print(Sort((0, -1)))                      #  (-1, 0)                      2 pt.
print(Sort((1, 0)))                       #  (0, 1)                       2 pt.
print(Sort((0, 0, 1)))                    #  (0, 0, 1)                    2 pt.
print(Sort((0, -1, 0)))                   #  (-1, 0, 0)                   2 pt.
print(Sort((0, 0, 1)))                    #  (0, 0, 1)                    2 pt.

print(Sort((9, 8, 7, 6, 5, 4, 3, 2, 1)))  #  (1, 2, 3, 4, 5, 6, 7, 8, 9)  2 pt.
print(Sort((1, 2, 3, 4, 5, 6, 7, 8, 9)))  #  (1, 2, 3, 4, 5, 6, 7, 8, 9)  2 pt.
print(Sort((1, 2, 1, 4, 2, 5, 4, 5, 3)))  #  (1, 1, 2, 2, 3, 4, 4, 5, 5)  2 pt.

#1
#-1
#1
#3
#()
#()
#(1,)
#(0, 2, 1, 3)
#(0, 1, 1, 3)
#(1, 2)
#()
#(0,)
#(-1, 0)
#(0, 1)
#(0, 0, 1)
#(-1, 0, 0)
#(0, 0, 1)
#(1, 2, 3, 4, 5, 6, 7, 8, 9)
#(1, 2, 3, 4, 5, 6, 7, 8, 9)
#(1, 1, 2, 2, 3, 4, 4, 5, 5)
