function[distance] = euc(a, b)
[n, ~] = size(a);
distance = 0;

for i = 1:n
    distance = distance + (a(i,1) - b(i,1))^2;
end

distance = sqrt(distance);