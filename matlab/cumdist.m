function[V] = cumdist(series, s, e)

[~,n] = size(series);
V = zeros(n,n);

tic
for i = 1:n
    for j = 1:n
        V(j,i) = euc(series(s:e,i),series(s:e,j));
    end
    
    disp( i );
    toc
end

function[d] = euc(f, s)

[n,~] = size(f);
d = 0;

for i = 1:n
     d = d + (f(n,1) - s(n,1));
end

d = abs(d);
