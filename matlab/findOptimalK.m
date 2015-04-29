function[index] = findOptimalK(series)
% Plot Sum Squared Error over the number of clusters from 1 to 50
      results = zeros(50, 1);
      %series = transpose(series); %transpose input
      rng(1104);
      for i = 2:50
        [~,~,sumd] = kmedoids(series,i); 
        total = sum(sumd);
        results(i,1) = total;
      end
    % Find Elbow 
    % Following section modified from response at link (below)
    % http://stackoverflow.com/questions/2018178/finding-the-best-trade-off-point-on-a-curve
    nPoints = length(results)-2;
    rele = results(3:nPoints+2); % eliminate first two points of array
    rele = transpose(rele); % Transpose results matrix
    allCoord = [1:nPoints;rele]';  % SO formatting
    % pull out first point
    firstPoint = allCoord(1,:);
    % get vector between first and last point - this is the line
    lineVec = allCoord(end,:) - firstPoint;
    % normalize the line vector
    lineVecN = lineVec / sqrt(sum(lineVec.^2));
    % find the distance from each point to the line:
    vecFromFirst = bsxfun(@minus, allCoord, firstPoint); % vector between all points and first point
    %Calculate furthest perpendicular point from line
    scalarProduct = dot(vecFromFirst, repmat(lineVecN,nPoints,1), 2);
    vecFromFirstParallel = scalarProduct * lineVecN;
    vecToLine = vecFromFirst - vecFromFirstParallel;
    % distance to line is the norm of vecToLine
    distToLine = sqrt(sum(vecToLine.^2,2));
    % plot the distance to the line
    %figure('Name','distance from curve to line'), plot(distToLine)
    %xlabel('Number of Clusters (K)','FontSize',26,'FontWeight','bold')
    %ylabel('Distance line to Curve','FontSize',26,'FontWeight','bold')
    %grid minor
    % now all you need is to find the maximum dist to line
    [~,idxOfBestPoint] = max(distToLine);
    index = round(idxOfBestPoint);

%disp('     Selected number of Clusters: '),disp(index);
figure('Name','Sum Squared Error with optimal K indicated'), plot(rele)
xlabel('Number of Clusters (K)','FontSize',26,'FontWeight','bold')
ylabel('Sum Squared Error','FontSize',26,'FontWeight','bold')
set(gca, 'XLim',[0 50],'FontSize',24)
grid on
hold on
plot(allCoord(index,1), allCoord(index,2), 'or')

%midx = plotAllClust(series,index);
%idCent(midx,tickers);


      