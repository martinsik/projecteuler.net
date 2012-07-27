import sys
from subprocess import call

#for i in range(1000):
sys.stdout.write(str(call(["./Release/problem-027"])))
