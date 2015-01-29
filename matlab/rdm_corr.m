function[corrs] = rdm_corr(iter, rows, cols, min, max, clusters)
% Assuming pre-processing was already done on random data using scale 0-1 &
% detrend

corrs = zeros(iter, 1);
for i=1:iter
    rng(i);
    rand_mat = min + (max - min) * randn(rows,cols);
    transposed = transpose(rand_mat);
    
    idx = kmeans(transposed, clusters);
    
    dist_mat = squareform(pdist(transposed));
    incidence_mat = incidence(idx);
    corr = corrcoef(dist_mat(:), incidence_mat(:));
    corrs(i,1) = corr(1, 2);
    
    disp( [i corrs(i, 1)] );
end 