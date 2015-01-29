function[result] = weighted_multi_distance(m1, w1, m2, w2)

[m1Len,n] = size(m1);
[m2Len,~] = size(m2);
V1        = zeros(n,n);
V2        = zeros(n,n);
result    = zeros(n,n);

for i = 1:n
    for j = 1:n
        V1(j,i)     = euc(m1(:,i),m1(:,j));
        V2(j,i)     = euc(m2(:,i),m2(:,j));
        result(j,i) = (w1 * V1(j,i)) + (w2 * V2(j,i));
    end
end

function[distance] = euc(a, b)
[n, ~] = size(a);
distance = 0;

for i = 1:n
    distance = distance + (a(i,1) - b(i,1))^2;
end

distance = sqrt(distance);
