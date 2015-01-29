function[corrs] = rdm_corr2(iter, rows, cols, min, max, clusters)
% Assuming pre-processing was not already done on random data

corrs = zeros(iter, 1);
for i=1:iter
    rng(i);
    rand_mat = min + (max - min) * randn(rows,cols);
    rand_mat = preprocess(rand_mat, rows);
    transposed = transpose(rand_mat);
    
    idx = kmeans(transposed, clusters);
    
    dist_mat = squareform(pdist(transposed));
    incidence_mat = incidence(idx);
    corr = corrcoef(dist_mat(:), incidence_mat(:));
    corrs(i,1) = corr(1, 2);
    
    disp( [i corrs(i, 1)] );
end 