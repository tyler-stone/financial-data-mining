function[V] = znormalize(series)
% Normalize all elements in a matrix using mean and standard deviation for
% each column.
      [m,n] = size(series);
      V = zeros(size(series));
      for i = 1:n
          dev = std(series(:,i));
          avg = mean(series(:,i));
          for j = 1:m
              V(j,i) = (series(j,i) - avg) / dev;
          end
      end
