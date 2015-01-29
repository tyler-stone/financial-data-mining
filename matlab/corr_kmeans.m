function[idx, corr] = corr_kmeans(series, clusters)
% Cluster data and return the clusters and the correlation result

idx = kmeans(transpose(series), clusters);

incidence_mat = incidence(idx);
dist_mat = squareform(pdist(transpose(series)));
corrmat = corrcoef(dist_mat(:), incidence_mat(:));
corr = corrmat(1,2);