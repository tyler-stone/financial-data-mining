function[V] = getClusterRows(idx, series, cluster)

[iter, ~] = size(idx);
[s, ~] = size(series);
V = zeros(s,1);
count = 1;
for i = 1:iter
    if (idx(i, 1) == cluster)
        V(:, count) = series(:, i);
        count = count + 1;
    end
end