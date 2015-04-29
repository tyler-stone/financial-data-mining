function [tsSlicePrep] = prepWindow(series,duration,offset)

start = offset + 1;
finish = duration+offset;

tsSlice = series(1:end,start:finish);

tsSlicePrep = preprocess(tsSlice,duration);