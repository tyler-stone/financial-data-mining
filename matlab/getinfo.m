function[V] = getinfo(p, l)

    [n, ~] = size(p);
    [m, k] = size(l);
    V = cell(n,k);
    
    for i = 1:n
       for j = 1:m
           if isequal(p{i,1},l{j,1})
               V(i,1:k) = l(j,1:k);
           end
       end
    end