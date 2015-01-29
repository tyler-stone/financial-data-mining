function[] = plotSSE(series, iter)
% Plot Sum Squared Error over the number of clusters (iter)
hold on;
      results = zeros(iter, 1);
      for i = 2:iter
[~, ~, sumd] = kmeans(series,i); total = sum(sumd);
disp(total)
results(i,1) = total;

conc = diff(diff(results)); %Take second derrivative
[pks,locs] = findpeaks(conc); %find max point indicating elbow.
% Negative values need not be considered as plot is concave Up (F">0)

      end
      plot(results)
      disp(pks)
      disp(locs)
     
     
     