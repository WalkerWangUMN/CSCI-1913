FirstNum = 7 **5
SecondNum = 2 ** 31 - 1
class Random:
    def __init__(self, seed):
        self.seed = seed

    def next(self):
        self.seed = (self.seed * FirstNum) % SecondNum
        return self.seed

    def choose(self, limit):
        return self.next() % limit

class Rule:
    def __init__(self, left, right):
        self.left = left
        self.right = right
        self.count = 1
    def repr(self):
        self.str = str(self.count) + " "+ self.left + " " + "->" + " " + " ".join(self.right)
        return self.str

class Grammar:
    def __init__(self, seed):
        self.work = Random(seed)
        self.dic = {}

    def rule(self, left, right):
        if left not in self.dic:
            self.dic[left] = (Rule(left, right), )
        else:
            self.dic[left] += (Rule(left,right), )

    def generate(self):
        if 'Start' in self.dic:
            return self.generating(('Start', ))
        else:
            raise Exception ("cannot generate strings")

    def generating(self, strings):
        result = ""
        for i in strings:
            if i not in self.dic:
                result = result + i +" "
            else:
                tuple = self.select(i)
                result = result + self.generating(tuple)
        return result

    def select(self, left):
        rules = self.dic[left]
        total = 0
        for i in rules:
            total += i.count

        index = self.work.choose(total)

        for i in rules:
            index -= i.count
            if index <= 0:
                chosen = i
                break
        for i in rules:
            if i != chosen:
                i.count += 1
        return chosen.right


G = Grammar(101)
G.rule('Noun',   ('cat',))                                #  01
G.rule('Noun',   ('boy',))                                #  02
G.rule('Noun',   ('dog',))                                #  03
G.rule('Noun',   ('girl',))                               #  04
G.rule('Verb',   ('bit',))                                #  05
G.rule('Verb',   ('chased',))                             #  06
G.rule('Verb',   ('kissed',))                             #  07
G.rule('Phrase', ('the', 'Noun', 'Verb', 'the', 'Noun'))  #  08
G.rule('Story',  ('Phrase',))                             #  09
G.rule('Story',  ('Phrase', 'and', 'Story'))              #  10
G.rule('Story',  ('Phrase', 'but', 'Story'))              #  11
G.rule('Start',  ('Story', '.'))                          #  12

print(G.generate())
print(G.generate())
print(G.generate())
print(G.generate())
print(G.generate())
