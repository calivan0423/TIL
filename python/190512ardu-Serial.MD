
import serial
print('serial'+serial.__version__)

#set a port number&baud rate

PORT= 'COM6'
BaudRate=9600

ARD= serial.Serial(PORT,BaudRate)

def Decode(A):
    A= A.decode()
    A= str(A)
    if A[0]=='W':
        if(len(A)==10):
            Ard1=int(A[1:4])
            Ard2=int(A[4:8])
            result=[Ard1,Ard2]
            return result
        else:
            print("error_lack of number _ %d" %len(A))
            return False
    else:
        print("error_wrong signal")
        return False

def Ardread(): #return list [Ard1, Ard2]

    if ARD.readable():
        LINE = ARD.readline()
        code=Decode(LINE)
        print(code)
        return code
    else:
        print("읽기 실패 from_Ardread")


while(True):
    Ardread()
