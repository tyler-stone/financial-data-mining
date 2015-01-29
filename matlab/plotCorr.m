function[] = plotCorr(series, iter)
% Plot the correlation over the number of clusters (iter)

hold on;

results = zeros(iter, 1);
for i = 2:iter
    [~, comparison] = corr_cluster(series, 60, i);
    total = comparison;
    disp(total)
    results(i,1) = total;
end
disp(results);
plot(results);