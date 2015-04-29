function[V] = znormalizeRelative(base,target)

% Normalize all elements in target matrix using mean and standard deviation for
% each column in base matrix.
      [m,n] = size(target);
      V = zeros(size(target));
      for i = 1:n
          dev = std(base(:,i));
          avg = mean(base(:,i));
          for j = 1:m
              V(j,i) = (target(j,i) - avg) / dev;
          end
      end
