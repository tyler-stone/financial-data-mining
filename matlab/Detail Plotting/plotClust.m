function [] = plotClust(cVect, midx, series, clusterNumber)
% Using a clustering result (cVect) and the time series (series), plot only
% one cluster determined by the user (clust)

figure
vectLen = length(cVect);
hold all;
grid on;
xlabel('Days, relative to clustering date','FontSize',26,'FontWeight','bold')
ylabel('Closing price, normalized by training time series','FontSize',26,'FontWeight','bold')
title('Normalized close price versus days','FontSize',30);

% Comment out one of the below lines at a time for desired output
%set(gca, 'XLim',[-260 140],'FontSize',24) %display training and test set
set(gca, 'XLim',[-260 0],'FontSize',18) %display training set ONLY

%comment this out, find min/max of y axis, fill in values
ymin = -6;
ymax = 14;

line([0 0],[ymin ymax],'LineWidth',2,'Color','k') 
line([5 5],[ymin ymax],'LineWidth',1,'Color','b') 
line([10 10],[ymin ymax],'LineWidth',1,'Color','b') 
line([20 20],[ymin ymax],'LineWidth',1,'Color','b') 
line([40 40],[ymin ymax],'LineWidth',1,'Color','b') 
line([60 60],[ymin ymax],'LineWidth',1,'Color','b') 
line([120 120],[ymin ymax],'LineWidth',1,'Color','b')

x = -260:1:259;
ax = gca;
ax.XTick = [-260,0, 10, 20,40,60,120];

for n = 1:vectLen
    if cVect(n,1) == clusterNumber
        plot(x,series(:,n))
        if any(midx(:)==n)
            prototype = series(:,n);
        end
    end
end
plot(x,prototype,'LineWidth',4,'color','k')
