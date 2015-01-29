function[V] = incidence(idx)
% Create an incidence matrix for testing correlation of cluster results

[n, ~] = size(idx);
V = zeros(n, n);

for i = 1:n
   for j = 1:n
      result = 0;
      if (idx(j, 1) == idx(i, 1))
         result = 1;
      end
      V(j, i) = result;
   end
end