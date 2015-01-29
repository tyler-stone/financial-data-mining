function[V] = scale(series)
% Scale all elements in a matrix between 0 and 1 for each column
      [m,n] = size(series);
      V = zeros(size(series));
      for i = 1:n
          big = max(series(:,i));
          small = min(series(:,i));
          for j = 1:m
              V(j,i) = (series(j,i) - small) / (big - small);
end end
