function aa(a, b)
    c=1+a
    a=a+1*b
    return a
end

function aaa(a)
    d=12
    a=aa(a, d)
    return a
end

a=1
b=aaa(a)