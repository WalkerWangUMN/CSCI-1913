def left(e):
    return e[0]
def op(e):
    return e[1]
def right(e):
    return e[2]

def isInside(v, e):
    if v == e:
        return True
    elif isinstance(e,tuple):
        return isInside(v, left(e)) or isInside(v, right(e))
    else:
        return False
def solve(v, q):
    if isInside (v,left(q)):
        return solving(v, q)
    elif isInside (v,right(q)):
        return solving(v, (right(q),op(q),left(q)))
    else:
        return None

def solving (v, q):
    if v == left(q):
        return q
    elif op(left(q)) == '+':
        return solvingAdd(v,q)
    elif op(left(q)) =='-':
        return solvingSubtract(v,q)
    elif op(left(q)) =='*':
        return solvingMultiply(v,q)
    elif op(left(q)) =='/':
        return solvingDivide(v,q)

def solvingAdd (v,q):
    if isInside (v, left(left(q))):
        return solving(v, (left(left(q)),'=',(right(q),'-',right(left(q)))))
    else:
        isInside (v, right(left(q)))
        return solving(v, (right(left(q)),'=',(right(q),'-',left(left(q)))))

def solvingSubtract(v,q):
    if isInside (v,left(left(q))):
        return solving(v, (left(left(q)),'=',(right(q),'+',right(left(q)))))
    else:
        isInside (v,right(left(q)))
        return solving(v, (right(left(q)),'=',(left(left(q)),'-',right(q))))

def solvingMultiply (v,q):
    if isInside (v,left(left(q))):
        return solving(v, (left(left(q)),'=',(right(q),'/',right(left(q)))))
    else:
        isInside (v, right(left(q)))
        return solving(v, (right(left(q)),'=',(right(q),'/',left(left(q)))))

def solvingDivide (v,q):
    if isInside (v, left(left(q))):
        return solving(v, (left(left(q)),'=',(right(q),'*',right(left(q)))))
    else:
        isInside (v, right(left(q)))
        return solving(v, (right(left(q)),'=',(left(left(q)),'/',right(q))))



print(isInside('x', 'x'))                          #  True   1 point
print(isInside('x', 'y'))                          #  False  1 point
print(isInside('x', ('x', '+', 'y')))              #  True   2 points
print(isInside('x', ('a', '+', 'b')))              #  False  2 points
print(isInside('+', ('a', '+', 'b')))              #  False  2 points
print(isInside('x', (('m', '*', 'x'), '+', 'b')))  #  True   2 points


print(solve('x', (('a', '+', 'x'), '=', 'c')))
#  ('x', '=', ('c', '-', 'a'))  2 points

print(solve('x', (('x', '+', 'b'), '=', 'c')))
#  ('x', '=', ('c', '-', 'b'))  2 points

print(solve('x', (('a', '-', 'x'), '=', 'c')))
#  ('x', '=', ('a', '-', 'c'))  2 points

print(solve('x', (('x', '-', 'b'), '=', 'c')))
#  ('x', '=', ('c', '+', 'b'))  2 points

print(solve('x', (('a', '*', 'x'), '=', 'c')))
#  ('x', '=', ('c', '/', 'a'))  2 points

print(solve('x', (('x', '*', 'b'), '=', 'c')))
#  ('x', '=', ('c', '/', 'b'))  2 points

print(solve('x', (('a', '/', 'x'), '=', 'c')))
#  ('x', '=', ('a', '/', 'c'))  2 points

print(solve('x', (('x', '/', 'b'), '=', 'c')))
#  ('x', '=', ('c', '*', 'b'))  2 points

print(solve('y', ('y', '=', (('m', '*', 'x'), '+', 'b'))))
# ('y', '=', (('m', '*', 'x'), '+', 'b'))  2 points

print(solve('x', ('y', '=', (('m', '*', 'x'), '+', 'b'))))
# ('x', '=', (('y', '-', 'b'), '/', 'm'))  2 points

print(solve('a', (('b', '+', 'c'), '=', ('d', '*', (('a', '/', 'e'), '-', 'f')))))
# ('a', '=', (((('b', '+', 'c'), '/', 'd'), '+', 'f'), '*', 'e'))  5 points


#True
#False
#True
#False
#False
#True
#('x', '=', ('c', '-', 'a'))
#('x', '=', ('c', '-', 'b'))
#('x', '=', ('a', '-', 'c'))
#('x', '=', ('c', '+', 'b'))
#('x', '=', ('c', '/', 'a'))
#('x', '=', ('c', '/', 'b'))
#('x', '=', ('a', '/', 'c'))
#('x', '=', ('c', '*', 'b'))
#('y', '=', (('m', '*', 'x'), '+', 'b'))
#('x', '=', (('y', '-', 'b'), '/', 'm'))
#('a', '=', (((('b', '+', 'c'), '/', 'd'), '+', 'f'), '*', 'e'))
