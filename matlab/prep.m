function [ts, tickers, clean] = prep(filename,duration)

ts = csvread(filename,0,1);
raw = importdata(filename);
tickers = raw.textdata;
clean = preprocess(ts,duration);


