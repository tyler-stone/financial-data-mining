function [cVect,midx] = weightedClustPlot(distMat, series, numClust, tickers)

[cVect,midx] = kmedoids2(distMat,numClust);

hold on;
figure_handle = figure;
vectLen = length(cVect);
rowsCols = ceil(sqrt(numClust + 1));
colors = distinguishable_colors(numClust + 1);

sortClusters(distMat,cVect,midx,tickers,0) 
% above call creates table of all clusters, sorted by distance to centroid

cVect=transpose(cVect);


for n = 1:vectLen
    if cVect(n,:) ~= 0
        subplot(rowsCols+2, rowsCols,1:rowsCols*2);
        hold on
        plot(series(:,n),'Color',colors(cVect(n,:)+1,:));
        ylim([-3,3])
        title('Cumulative Clusters')
        
        subplot(rowsCols+2,rowsCols,cVect(n,:)+rowsCols*2)
        hold on
        plot(series(:,n),'Color',colors(cVect(n,:)+1,:));
        str = sprintf('Cluster %d',cVect(n,:));
        ylim([-3,3])
        title(str)
    else
        subplot(rowsCols+2,rowsCols,rowsCols*2 + numClust + 1)
        hold on
        plot(series(:,n),'Color',colors(cVect(n,:)+1,:));
        ylim([-3,3])
        title('Noise')
    end
    b = mod(n,100); %integer determines how many values pass before printing
    isInt = mod(b,1); %check if value is integer
    if isInt == 1
        disp('.')
    end  
end
all_ha = findobj( figure_handle, 'type', 'axes', 'tag', '' );
linkaxes( all_ha, 'xy' );
