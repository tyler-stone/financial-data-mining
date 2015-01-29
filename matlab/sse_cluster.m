function[total] = sse_cluster(series, duration, clusters)

[det, ~] = preprocess(series, duration);

[~, ~, sumd] = kmeans(transpose(det),clusters);
total = sum(sumd);
