function[V] = cumdtw(series, s, e)

[~,n] = size(series);
V = zeros(n,n);

tic
for i = 1:n
    for j = 1:n
        V(j,i) = dtw(series(s:e,i),series(s:e,j),0);
    end
    
    disp( i );
    toc
end
