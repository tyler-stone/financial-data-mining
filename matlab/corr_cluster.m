function[idx, corr] = corr_cluster(series, duration, clusters)
% Cluster data and return the clusters and the correlation result

[det, dist_mat] = preprocess(series, duration);

idx = kmeans(transpose(det), clusters);

incidence_mat = incidence(idx);
corrmat = corrcoef(dist_mat(:), incidence_mat(:));
corr = corrmat(1,2);