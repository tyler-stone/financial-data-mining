function[] = sortClusters(distMat,cVect,centroids,tickers,windowNumber)
% function written only for numClust = 10

%series = transpose(series);

% Split 'ts' matrix into clusters to create new distance matrecies
count = 1; 
%row1 = 2; row2 = 2; row2 = 2; row3 = 2; row4 = 2; row5 = 2;
%row6 = 2; row7 = 2; row8 = 2; row9 = 2; row10 = 2;

vectLen = length(cVect);
numClust = length(centroids);
clustersSym = zeros(vectLen,numClust);
clusters = cell(vectLen,numClust);  %Preallocate cell memory
dim = round( (vectLen*2)/numClust );
clusterTickers = cell(dim,numClust); % preallocate with buffer

%build array indicating clusters
for clustId = cVect(1:vectLen)
    clustersSym(count,clustId) = count;
    count = count + 1;
end

count = 1; %RESET COUNT

for proto = centroids(1:numClust)
    
    pro = distMat(proto,:);
    %sort ascending, output original indices
    [~ , indices] = sort(pro);
    
    %check if each index is member of given cluster 
    check = ismember(indices,clustersSym(:,count));
    
    % keep only cluster values, make all others 0
    clustersSym(:,count) = (check .* indices);
 
    count = count + 1;
end

% propogate array with tickers instead of indices

for col = 1:numClust
    row = 1;
    
    focus = transpose(clustersSym(:,col));
    
    for index = focus(1:vectLen)
        if index ~= 0
            clusters(row,col) = tickers(index);
        end
        row = row + 1;
    end
    col = col + 1;
end

% eliminate zero elements of each column
column = 1;
vert = 1;

for column = 1:numClust
    target = clusters(:,column);
    
    target(cellfun(@isempty,target)) = [];
    
    tickLength = length(target);
    
    target = transpose(target);
    
    for ele = target(1:tickLength)
        clusterTickers(vert,column) = ele;
        vert = vert + 1;
    end
    column = column + 1;
    vert = 1;
end

nearest = clusterTickers(2:end,:);

table = cell2table(nearest);

table.Properties.VariableNames = clusterTickers(1,:);

% UNCOMMENT LINES BELOW TO DIPLAY TABLES IN COMMAND WINDOW

%fprintf('\r\n "K" closest stocks to prototype (indicated in bold) \r\n')
%disp(table)

filename = sprintf('clusters%d.txt',windowNumber);

writetable(table,filename)

