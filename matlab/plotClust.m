function [] = plotClust(cVect, series, clust)
% Using a clustering result (cVect) and the time series (series), plot only
% one cluster determined by the user (clust)

figure
vectLen = length(cVect);
hold all;

for n = 1:vectLen
    if cVect(n,1) == clust
        plot(series(:,n))
    end
end