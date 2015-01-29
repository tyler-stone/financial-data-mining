function [ts, tickers] = prep(filename,duration)

ts = csvread(filename,0,1);
raw = importdata(filename);
tickers = raw.textdata;
preprocess(ts,duration);


