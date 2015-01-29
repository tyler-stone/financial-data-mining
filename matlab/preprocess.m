function[result, dist_mat] = preprocess(series, duration) % Standardized way of preprocessing time series
      series = transpose(series); %transpose series for preprocessing
      [s, n] = size(series);
      raw = series(s - duration + 1:s, :);
% Begin pre-processing
% Scaling and detrending
% Can also use znormalize, detrending only, etc
% scaled = scale01(raw);
scaled = znormalize(raw);   %call%
% scaled = scale(scaled);  %call%
% Find NaNs and replace them with 0 (only for scaled values) 
% scaled( isnan(scaled) ) = 0;
% Optional detrend, otherwise just set it equal
      result = scaled;
      % Get distance matrix for result
dist_mat = squareform(pdist(transpose(result)));