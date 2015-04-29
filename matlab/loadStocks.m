function [ts,sp,tickers] = loadStocks(timeSeriesFilename,singlePointFilename,duration)

ts = csvread(timeSeriesFilename,0,1);
raw = importdata(timeSeriesFilename);
tickers = raw.textdata;

sp = transpose(csvread(singlePointFilename,1,1));


