%Ryan Mckenna & Tyler Stone 2015
%4/12/15

%DESCRIPTION: Preprocesses one timeseries "target" with respect to another,
%"base"
%INPUTS: series - timeseries to be processed
%        baseDuration - length of base series, origin of scaling values
%        targetDuration - length of timeseries to normalize by base values
% OUTPUTS: scaledBase- normalized timeseries
%          scaledTarget- normalized with respect to base
function[scaledBase,scaledTarget] = prepRelative(series, baseDuration, targetDuration) % Standardized way of preprocessing time series
      series = transpose(series); %transpose series for preprocessing
      [s, ~] = size(series);
      rawBase = series(1:baseDuration, :);
      rawTarget = series(1:targetDuration, :);

scaledBase = znormalize(rawBase);   %Not necessary for output
scaledTarget = znormalizeRelative(rawBase,rawTarget); %call%
