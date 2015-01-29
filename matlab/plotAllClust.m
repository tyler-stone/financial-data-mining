function [midx] = plotAllClust(series, numClust)

[cVect,~,~,~,midx] = kmedoids(transpose(series),numClust);
hold on;
figure_handle = figure;
vectLen = length(cVect);
rowsCols = ceil(sqrt(numClust + 1));
colors = distinguishable_colors(numClust + 1);

for n = 1:vectLen
    if cVect(n,:) ~= 0
        subplot(rowsCols+2, rowsCols,1:rowsCols*2);
        hold on
        plot(series(:,n),'Color',colors(cVect(n,:)+1,:));
        ylim([-2,2])
        title('Cumulative Clusters')
        
        subplot(rowsCols+2,rowsCols,cVect(n,:)+rowsCols*2)
        hold on
        plot(series(:,n),'Color',colors(cVect(n,:)+1,:));
        str = sprintf('Cluster %d',cVect(n,:));
        ylim([-2,2])
        title(str)
    else
        subplot(rowsCols+2,rowsCols,rowsCols*2 + numClust + 1)
        hold on
        plot(series(:,n),'Color',colors(cVect(n,:)+1,:));
        ylim([-2,2])
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
