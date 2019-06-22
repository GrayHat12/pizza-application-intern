import pafy
import sys

def func(query):
    dat=pafy.new(query)
    print(dat.title)
    print(dat.author)
    print(dat.getbestaudio().url_https)

if __name__ == '__main__':
    #print(sys.argv)
    func(sys.argv[1])
