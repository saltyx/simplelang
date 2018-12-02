function f1(arg1, arg2)
    arg1 = 1.2+arg1
    arg3 = arg1+a
    return arg1+arg2
end

function f2(arg1)
    arg1=f1(arg1, 10)
    return arg1
end

a=1
b=f2(a)
c=f2(1.2)